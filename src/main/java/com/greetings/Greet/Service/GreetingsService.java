package com.greetings.Greet.Service;


import com.greetings.Greet.DTO.VisitorsResponseDTO;
import com.greetings.Greet.DTO.WeatherResponseDTO;
import jakarta.servlet.http.HttpServletRequest;

public interface GreetingsService {

    VisitorsResponseDTO visitorsResponse(String name, HttpServletRequest httpRequest);
    WeatherResponseDTO getWeather(String ip);
    //String extractClientIp(HttpServletRequest request);


}
