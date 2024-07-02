package com.greetings.Greet.Service;

import com.greetings.Greet.DTO.VisitorsResponseDTO;
import com.greetings.Greet.DTO.WeatherData;
import com.greetings.Greet.DTO.WeatherResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


import java.util.Map;

@Service

public class GreetingsImpl implements GreetingsService {

    @Autowired
    private RestTemplate restTemplate;
    //private final WeatherResponseDTO weatherResponseDTO = new WeatherResponseDTO();

    private static final String API_KEY = "1ffefcd7cb594163b9d95242240207";
    private static final String BASE_URL = "https://api.weatherapi.com/v1/current.json";

    @Override
    public VisitorsResponseDTO visitorsResponse(String name, HttpServletRequest httpServletRequest) {

        VisitorsResponseDTO visitorsResponseDTO = new VisitorsResponseDTO();

        String ipAddress = httpServletRequest.getHeader("X-Forwarded-For");
        if (ipAddress == null) {
            ipAddress = httpServletRequest.getRemoteAddr();
        }

        WeatherResponseDTO weatherResponseDTO = getWeather(ipAddress);


        //String location = "You are currently in";


        visitorsResponseDTO.setClient_Ip(ipAddress);
        visitorsResponseDTO.setLocation(weatherResponseDTO.getCity());
        //visitorsResponseDTO.setTemperature(weatherResponseDTO.getTemperature());

        String message = "Hello, "+name+"!, the temperature is "
                +weatherResponseDTO.getTemperature()+" degrees Celsius in " +visitorsResponseDTO.getLocation();

        visitorsResponseDTO.setGreeting(message);

        return visitorsResponseDTO;
    }

    @Override
    public WeatherResponseDTO getWeather(String ip) {

        WeatherResponseDTO weatherResponseDTO = new WeatherResponseDTO();
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .queryParam("key", API_KEY)
                .queryParam("q", ip);

        ResponseEntity<WeatherData> response = restTemplate.getForEntity(uriBuilder.toUriString(), WeatherData.class);

        WeatherData responseBody = response.getBody();

        if (responseBody != null) {

           WeatherData.Location  location= responseBody.getLocation();
           WeatherData.Current tempInfo = responseBody.getCurrent();

            String city = location.getRegion();
            double temperature = tempInfo.getTemp_c();

            weatherResponseDTO.setCity(city);
            weatherResponseDTO.setTemperature(temperature);

        }

        return weatherResponseDTO;

    }



}
