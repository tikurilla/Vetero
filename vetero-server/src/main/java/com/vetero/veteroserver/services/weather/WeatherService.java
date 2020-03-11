package com.vetero.veteroserver.services.weather;

import com.fasterxml.jackson.core.type.TypeReference;
import com.vetero.veteroserver.logger.Logger;
import com.vetero.veteroserver.model.Coordinate;
import com.vetero.veteroserver.model.CurrentWeather;

import com.vetero.veteroserver.services.http.HttpResponse;
import com.vetero.veteroserver.services.http.HttpService;
import com.vetero.veteroserver.utils.JsonUtils;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class WeatherService {
    @Value("${yandex.weather.api.key}")
    private String apiKey;

    @Value("${yandex.weather.api.uri}")
    private String apiUri;

    @Autowired
    private HttpService httpService;

    @Autowired
    private Logger logger;

    @Autowired
    private JsonUtils jsonUtils;

    public CurrentWeather getCurrentWeather(Coordinate coordinate) {
        try {
            URIBuilder builder = new URIBuilder(apiUri);
            addParamsToUri(builder, coordinate);
            HttpGet httpGet = new HttpGet(builder.build());
            httpGet.addHeader("X-Yandex-API-Key", apiKey);
            HttpResponse response = httpService.doRequest(httpGet);
            if (HttpStatus.SC_FORBIDDEN == response.getStatusCode()) {
                logger.error("Wrong request, incorrect X-Yandex-API-Key or weather request limit exceeded");
                return null;
            }

            Map<String, Object> body = jsonUtils.fromJson(response.getBody(), new TypeReference<Map<String, Object>>() {
            });
            Map<String, Object> factWeather = (Map<String, Object>) body.get("fact"); // todo check this code

            return jsonUtils.prepareDTO(factWeather, CurrentWeather.class);
        } catch (Exception e) {
            logger.error("Error while receiving weather");
            return null;
        }
    }

    private void addParamsToUri(URIBuilder uriBuilder, Coordinate coordinate) {
        uriBuilder.addParameter("lat", Double.toString(coordinate.getLatitude()));
        uriBuilder.addParameter("lon", Double.toString(coordinate.getLongitude()));
        uriBuilder.addParameter("lang", "ru_RU");
    }
}
