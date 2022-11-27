package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 */
public class App {

    public static Map<String, Object> jsonToMap(String str) {
        Map<String, Object> map = new Gson().fromJson(str, new TypeToken<HashMap<String, Object>>() {
        }.getType());
        return map;
    }

    public static void main(String[] args) throws IOException {
        String link = "https://api.openweathermap.org/data/2.5/weather?q=Buenos Aires,ar&mode=json&appid=3e0eccb6c2a7730ffca0a7f4bee8d3e8";
        URL url = new URL(link);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        StringBuilder str = null;
        if (responseCode == 200) {
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String out;
            str = new StringBuilder();
            while ((out = br.readLine()) != null) str.append(out);
        }

        System.out.println(str);

        assert str != null;//ide add
        Map<String, Object> respMap = jsonToMap(str.toString());

        @SuppressWarnings("unchecked")
        Map<String, Object> weatherMap = (Map<String, Object>) ((List<Object>) respMap.get("weather")).get(0);
        Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());
        Map<String, Object> windMap = jsonToMap(respMap.get("wind").toString());
        Map<String, Object> cloudsMap = jsonToMap(respMap.get("clouds").toString());
        Map<String, Object> sysMap = jsonToMap(respMap.get("sys").toString());

        String city = respMap.get("name").toString();
        String country = sysMap.get("country").toString();
        String iconId = weatherMap.get("icon").toString();
        String shortDescription = weatherMap.get("main").toString();
        String extendedDescription = weatherMap.get("description").toString();
        double temperature = (double) mainMap.get("temp");
        double pressure = (double) mainMap.get("pressure");
        double humidity = (double) mainMap.get("humidity");
        double minTemperature = (double) mainMap.get("temp_min");
        double maxTemperature = (double) mainMap.get("temp_max");
        double windSpeed = (double) windMap.get("speed");
        double windDirection = (double) windMap.get("deg");
        double cloudiness = (double) cloudsMap.get("all");

        Cities cities = new Cities(city, country, iconId, shortDescription, extendedDescription, temperature,
                pressure, humidity, minTemperature, maxTemperature, windSpeed, windDirection, cloudiness);

        System.out.println(cities.toString());
        cities.saveWidgetHtml();
    }
}
