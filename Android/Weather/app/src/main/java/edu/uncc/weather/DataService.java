package edu.uncc.weather;

import java.io.Serializable;
import java.util.ArrayList;

public class DataService {

    static public final ArrayList<City> cities = new ArrayList<City>(){{
        add(new City("US","Charlotte", -80.843132, 35.227089));
        add(new City("US","Chicago", -87.650047,41.850029));
        add(new City("US","New York City", -74.005966, 40.714272));
        add(new City("US","Miami", -80.193657, 25.774269));
        add(new City("US","San Francisco", -122.419418, 37.774929));
        add(new City("US","Baltimore", -76.61219, 39.290379));
        add(new City("US","Houston", -95.363274, 29.763281));
        add(new City("GB","London", -0.12574, 51.50853));
        add(new City("GB","Bristol", -2.59665, 51.455231));
        add(new City("GB","Cambridge", 0.11667, 52.200001));
        add(new City("GB","Liverpool", -2.91667, 53.416672));
        add(new City("AE","Abu Dhabi", 54.366669, 24.466669));
        add(new City("AE","Dubai", 55.304722, 25.258169));
        add(new City("AE","Sharjah", 55.403301, 25.357309));
        add(new City("JP","Tokyo", 139.691711, 35.689499));
        add(new City("JP","Kyoto", 135.753845, 35.021069));
        add(new City("JP","Hashimoto", 135.616669, 34.316669));
        add(new City("JP","Osaka", 137.266663, 35.950001));
    }};

    static class City implements Serializable {
        private String country;
        private String city;
        private double latitude, longitude;

        public City(String country, String city, double longitude, double latitude) {
            this.country = country;
            this.city = city;
            this.latitude = latitude;
            this.longitude = longitude;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        @Override
        public String toString() {
            return city + ", " + country;
        }
    }
}
