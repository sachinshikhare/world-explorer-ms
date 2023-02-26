package com.example.worldexplorerms.service;

import com.example.worldexplorerms.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CountryService {

    public static final String HOST = "https://restcountries.com/v3.1";

    @Autowired
    private RestTemplate restTemplate;

    public List<Country> getCountries() {

        ResponseEntity<List<Country>> response = restTemplate.exchange(HOST + "/all",
                HttpMethod.GET,
                getRequestEntity(),
                new ParameterizedTypeReference<>() {
                });

        return response.getBody();
    }

    public List<Country> searchCountriesByName(String name, boolean fullText) {

        ResponseEntity<List<Country>> response = restTemplate.exchange(HOST + "/name/" + name + "?fullText=" + fullText,
                HttpMethod.GET,
                getRequestEntity(),
                new ParameterizedTypeReference<>() {
                });

        return response.getBody();
    }

    public List<Country> searchCountriesByCurrency(String currency) {

        ResponseEntity<List<Country>> response = restTemplate.exchange(HOST + "/currency/" + currency,
                HttpMethod.GET,
                getRequestEntity(),
                new ParameterizedTypeReference<>() {
                });

        return response.getBody();
    }

    public List<Country> searchCountriesByLanguage(String language) {

        ResponseEntity<List<Country>> response = restTemplate.exchange(HOST + "/lang/" + language,
                HttpMethod.GET,
                getRequestEntity(),
                new ParameterizedTypeReference<>() {
                });

        return response.getBody();
    }

    public List<Country> searchCountriesByCapital(String capital) {

        ResponseEntity<List<Country>> response = restTemplate.exchange(HOST + "/capital/" + capital,
                HttpMethod.GET,
                getRequestEntity(),
                new ParameterizedTypeReference<>() {
                });

        return response.getBody();
    }

    public List<Country> searchCountriesByRegion(String region) {

        ResponseEntity<List<Country>> response = restTemplate.exchange(HOST + "/region/" + region,
                HttpMethod.GET,
                getRequestEntity(),
                new ParameterizedTypeReference<>() {
                });

        return response.getBody();
    }

    public List<Country> searchCountriesBySubRegion(String subRegion) {

        ResponseEntity<List<Country>> response = restTemplate.exchange(HOST + "/subRegion/" + subRegion,
                HttpMethod.GET,
                getRequestEntity(),
                new ParameterizedTypeReference<>() {
                });

        return response.getBody();
    }

    private HttpEntity<Country> getRequestEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("accept", "application/json");
        return new HttpEntity<>(null, headers);
    }
}
