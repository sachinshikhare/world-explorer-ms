package com.example.worldexplorerms.model;

import lombok.*;

@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CountryName {
    private String common;
    private String official;
}
