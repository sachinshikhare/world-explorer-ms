package com.example.worldexplorerms.controller;

import com.example.worldexplorerms.model.Country;
import com.example.worldexplorerms.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping()
    public ResponseEntity<List<Country>> getCountries() {

        List<Country> countries = countryService.getCountries();
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Country>> searchCountriesByName(@PathVariable String name, @RequestParam(required = false, defaultValue = "false") Boolean fullText) {
        List<Country> countries = countryService.searchCountriesByName(name, fullText);
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    @GetMapping("/currency/{currency}")
    public ResponseEntity<List<Country>> searchCountriesByCurrency(@PathVariable String currency) {
        List<Country> countries = countryService.searchCountriesByCurrency(currency);
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    @GetMapping("/language/{language}")
    public ResponseEntity<List<Country>> searchCountriesByLanguage(@PathVariable String language) {
        List<Country> countries = countryService.searchCountriesByLanguage(language);
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    @GetMapping("/capital/{capital}")
    public ResponseEntity<List<Country>> searchCountriesByCapital(@PathVariable String capital) {
        List<Country> countries = countryService.searchCountriesByCapital(capital);
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    @GetMapping("/region/{region}")
    public ResponseEntity<List<Country>> searchCountriesByRegion(@PathVariable String region) {
        List<Country> countries = countryService.searchCountriesByRegion(region);
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    @GetMapping("/subRegion/{subRegion}")
    public ResponseEntity<List<Country>> searchCountriesBySubRegion(@PathVariable String subRegion) {
        List<Country> countries = countryService.searchCountriesBySubRegion(subRegion);
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }
}
