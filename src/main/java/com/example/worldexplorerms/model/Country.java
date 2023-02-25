package com.example.worldexplorerms.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
import java.util.Map;

@Data
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Country {
    @JsonProperty("name")
    private CountryName countryName;
    @JsonProperty("tld")
    private List< String > tlds;
    private boolean independent;
    private String status;
    private boolean unMember;
    private Map<String, Currency> currencies;
    @JsonProperty("idd")
    private IddCode iddCode;
    private List < String > capital;
    private List < String > altSpellings;
    private String region;
    private String subregion;
    private Map<String, String> languages;
    private List <Float> latlng;
    private boolean landlocked;
    private List < String > borders;
    private float area;
    private String flag;
    private Maps maps;
    private float population;
    private Map<String, Float> gini;
    private String fifa;
    private Car car;
    private List < String > timezones;
    private List < String > continents;
    private Flags flags;
    private CoatOfArms coatOfArms;
    private String startOfWeek;
    private CapitalInfo capitalInfo;
    private PostalCode postalCode;


}
