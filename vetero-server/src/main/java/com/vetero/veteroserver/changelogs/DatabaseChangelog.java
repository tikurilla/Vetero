package com.vetero.veteroserver.changelogs;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.vetero.veteroserver.model.Setting;
import org.springframework.data.mongodb.core.MongoTemplate;

@ChangeLog
public class DatabaseChangelog {
    @ChangeSet(order = "001", id = "cronSettingsForReadingWeather", author = "TimurGolovnya")
    public void changes1(MongoTemplate mongoTemplate){
        Setting settingApiKey = new Setting();
        settingApiKey.setCode("yandex.weather.api.key");
        settingApiKey.setValue("");
        mongoTemplate.save(settingApiKey);

        Setting settingWeatherApiUri = new Setting();
        settingWeatherApiUri.setCode("yandex.weather.api.uri");
        settingWeatherApiUri.setValue("https://api.weather.yandex.ru/v1/informers");

        mongoTemplate.save(settingWeatherApiUri);
    }
}
