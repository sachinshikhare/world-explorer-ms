package com.example.worldexplorerms.controller;

import com.example.worldexplorerms.model.Country;
import com.example.worldexplorerms.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping()
    public Flux<Country> getCountries() {
        return countryService.getCountries();
    }

    @GetMapping("/name/{name}")
    public Flux<Country> searchCountriesByName(@PathVariable String name, @RequestParam(required = false, defaultValue = "false") Boolean fullText) {
        return countryService.searchCountriesByName(name, fullText);
    }

    @GetMapping("/currency/{currency}")
    public Flux<Country> searchCountriesByCurrency(@PathVariable String currency) {
        return countryService.searchCountriesByCurrency(currency);
    }

    @GetMapping("/language/{language}")
    public Flux<Country> searchCountriesByLanguage(@PathVariable String language) {
        return countryService.searchCountriesByLanguage(language);
    }

    @GetMapping("/capital/{capital}")
    public Flux<Country> searchCountriesByCapital(@PathVariable String capital) {
        return countryService.searchCountriesByCapital(capital);
    }

    @GetMapping("/region/{region}")
    public Flux<Country> searchCountriesByRegion(@PathVariable String region) {
        return countryService.searchCountriesByRegion(region);
    }

    @GetMapping("/subRegion/{subRegion}")
    public Flux<Country> searchCountriesBySubRegion(@PathVariable String subRegion) {
        return countryService.searchCountriesBySubRegion(subRegion);
    }
}
