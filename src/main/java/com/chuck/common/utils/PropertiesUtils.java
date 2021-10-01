package com.chuck.common.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * Chuck 24/9/21 21:07
 */
public class PropertiesUtils {
    private PropertiesUtils(){ }

    public Properties propertiesOfFile(String path){
        Properties props=new Properties();
        try {
            props.load(this.getClass().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }

    public String valueOfProperty(String path,String key){
        Properties props=this.propertiesOfFile(path);
        return props.getProperty(key);
    }
}
