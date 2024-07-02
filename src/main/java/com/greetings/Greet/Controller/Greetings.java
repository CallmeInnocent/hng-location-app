package com.greetings.Greet.Controller;

import com.greetings.Greet.DTO.VisitorsResponseDTO;
import com.greetings.Greet.Service.GreetingsService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api")
public class Greetings {

    @Autowired
    private GreetingsService greetings;

    @GetMapping("/hello")
    public VisitorsResponseDTO visitorsResponse(@RequestParam String visitor_name, HttpServletRequest httpServletRequest){


        return greetings.visitorsResponse(visitor_name, httpServletRequest);
    }

}
