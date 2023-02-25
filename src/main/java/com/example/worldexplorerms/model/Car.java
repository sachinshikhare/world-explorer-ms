package com.example.worldexplorerms.model;

import lombok.*;

import java.util.ArrayList;

@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    ArrayList<String> signs = new ArrayList<>();
    private String side;


}
