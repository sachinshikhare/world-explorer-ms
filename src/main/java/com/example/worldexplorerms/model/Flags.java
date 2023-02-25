package com.example.worldexplorerms.model;

import lombok.*;

@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Flags {
    private String png;
    private String svg;
    private String alt;


}
