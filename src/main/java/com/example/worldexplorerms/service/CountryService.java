package com.example.worldexplorerms.service;

import com.example.worldexplorerms.exception.ResourceNotFoundException;
import com.example.worldexplorerms.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CountryService {

    public static final String HOST = "https://restcountries.com/v3.1";

    @Autowired
    private RestTemplate restTemplate;

    public Flux<Country> getCountries() {
        return callRestCountriesApiWithEndpoint("/all");
    }


    public Flux<Country> searchCountriesByName(String name, boolean fullText) {
        return callRestCountriesApiWithEndpoint("/name/" + name + "?fullText=" + fullText);
    }

    public Flux<Country> searchCountriesByCurrency(String currency) {
        return callRestCountriesApiWithEndpoint("/currency/" + currency);
    }

    public Flux<Country> searchCountriesByLanguage(String language) {
        return callRestCountriesApiWithEndpoint("/lang/" + language);
    }

    public Flux<Country> searchCountriesByCapital(String capital) {
        return callRestCountriesApiWithEndpoint("/capital/" + capital);
    }

    public Flux<Country> searchCountriesByRegion(String region) {
        return callRestCountriesApiWithEndpoint("/region/" + region);
    }

    public Flux<Country> searchCountriesBySubRegion(String subRegion) {
        return callRestCountriesApiWithEndpoint("/subregion/" + subRegion);
    }

    private WebClient getWebClient() {
        return WebClient.builder()
                .filter(errorHandler())
                .baseUrl(HOST)
                .build();

    }

    private Flux<Country> callRestCountriesApiWithEndpoint(String endpoint) {
        return getWebClient()
                .get()
                .uri(endpoint)
                .retrieve()
                .bodyToFlux(Country.class);
    }

    public static ExchangeFilterFunction errorHandler() {
        return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
            if (clientResponse.statusCode().is5xxServerError()) {
                return clientResponse.bodyToMono(String.class)
                        .flatMap(errorBody -> Mono.error(new ResourceNotFoundException(errorBody)));
            } else if (clientResponse.statusCode().is4xxClientError()) {
                return clientResponse.bodyToMono(String.class)
                        .flatMap(errorBody -> Mono.error(new ResourceNotFoundException(errorBody)));
            } else {
                return Mono.just(clientResponse);
            }
        });
    }

}
