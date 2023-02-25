package com.example.worldexplorerms.model;

import lombok.*;

@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Maps {
    private String googleMaps;
    private String openStreetMaps;


}
