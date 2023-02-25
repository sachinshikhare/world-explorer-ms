package com.example.worldexplorerms.model;

import lombok.*;

@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Currency {

    private String name;
    private String symbol;

}
