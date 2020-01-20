package com.vetero.veteroserver.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ArgUtils {
    public boolean isDataNotChanged(String oldData, String newData) {
        if (oldData == null && newData == null) {
            return true;
        }

        if (oldData == null) {
            return false;
        }

        if (newData == null) {
            return false;
        }

        return oldData.equals(newData);
    }

    public boolean isDataChanged(String arg1, String arg2) {
        return !isDataNotChanged(arg1, arg2);
    }

    public boolean isBlank(String arg) {
        return StringUtils.isBlank(arg);
    }

    public boolean isNotBlank(String arg) {
        return !isBlank(arg);
    }
}
