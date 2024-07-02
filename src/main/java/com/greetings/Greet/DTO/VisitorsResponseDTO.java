package com.greetings.Greet.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitorsResponseDTO {

    private String clientIP;
    private String greetings;
    private String city;
    private Double temperature;




}