package org.example;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Cities {
    private String city;
    private String country;
    private String iconId;
    private String shortDescription;
    private String extendedDescription;
    private double temperature;
    private double pressure;
    private double humidity;
    private double minTemperature;
    private double maxTemperature;
    private double windSpeed;
    private double windDirection;
    private double cloudiness;

    public Cities(
            String city,
            String country,
            String iconId,
            String shortDescription,
            String extendedDescription,
            double temperature,
            double pressure,
            double humidity,
            double minTemperature,
            double maxTemperature,
            double windSpeed,
            double windDirection,
            double cloudiness) {
        this.city = city;
        this.country = country;
        this.iconId = iconId;
        this.shortDescription = shortDescription;
        this.extendedDescription = extendedDescription;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.cloudiness = cloudiness;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIconId() {
        return iconId;
    }

    public void setIconId(String iconId) {
        this.iconId = iconId;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getExtendedDescription() {
        return extendedDescription;
    }

    public void setExtendedDescription(String extendedDescription) {
        this.extendedDescription = extendedDescription;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(double windDirection) {
        this.windDirection = windDirection;
    }

    public double getCloudiness() {
        return cloudiness;
    }

    public void setCloudiness(double cloudiness) {
        this.cloudiness = cloudiness;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", iconId='" + iconId + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", extendedDescription='" + extendedDescription + '\'' +
                ", temperature=" + temperature +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", minTemperature=" + minTemperature +
                ", maxTemperature=" + maxTemperature +
                ", windSpeed=" + windSpeed +
                ", windDirection=" + windDirection +
                ", cloudiness=" + windDirection +
                '}';
    }


    public String getWidgetHtml() {
        @SuppressWarnings("unused")
        String paragraphCloseTag = "</p>\n";
        return "<center>" +
                "<h1>********************************</h1>\n"
                + "<h1>Weather in " + city + ", " + country + "</h1>\n"
                + "<h1>********************************</h1>\n"
                + "<img src=https://openweathermap.org/img/w/" + iconId + ".png alt=" + "</p>\n" +
                "<h1>********************************</h1>\n" +
                "<p>Brief description of the weather: " + shortDescription + "</p>\n" +
                "<p>Extended weather description: " + extendedDescription + "</p>\n" +
                "<p>Current temperature in degrees Celsius: " + temperature + " °C" + "</p>\n" +
                "<p>Pressure in millimeters of mercury: " + pressure + " mm Hg" + "</p>\n" +
                "<p>Moisture percentage: " + humidity + " %" + "</p>\n" +
                "<p>Minimum temperature for today: " + minTemperature + " °C" + "</p>\n" +
                "<p>Maximum temperature for today: " + maxTemperature + " °C" + "</p>\n" +
                "<p>Wind speed: " + windSpeed + " m/s SW" + "</p>\n" +
                "<p>Direction of the wind: " + windDirection + " m/s SW" + "</p>\n" +
                "<p>Cloudiness in percent: " + windDirection + " %" + "</p>\n" +
                "<h1>********************************</h1>\n";
    }

    public void saveWidgetHtml() throws IOException {
        String widgetCode = getWidgetHtml();

        File fileHtml = new File("src\\main\\java\\org\\example\\Weather.html");
        try {
            Desktop desktop = null;
            if (Desktop.isDesktopSupported()) {
                desktop = Desktop.getDesktop();
            }
            desktop.open(new File("src\\main\\java\\org\\example\\Weather.html"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }


        try {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileHtml))) {
                bufferedWriter.write(widgetCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}