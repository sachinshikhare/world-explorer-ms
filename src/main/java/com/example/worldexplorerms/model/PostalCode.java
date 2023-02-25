package com.example.worldexplorerms.model;

import lombok.*;

@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PostalCode {
    private String format;
    private String regex;


}
