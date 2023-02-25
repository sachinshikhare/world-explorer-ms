package com.example.worldexplorerms.model;

import lombok.*;

import java.util.ArrayList;

@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class IddCode {
    private String root;
    ArrayList<String> suffixes;

}
