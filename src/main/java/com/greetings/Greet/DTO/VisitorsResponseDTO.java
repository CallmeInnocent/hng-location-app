package com.greetings.Greet.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitorsResponseDTO {

    private String client_Ip;
    private String location;
    private String greeting;
    //private Double temperature;




}