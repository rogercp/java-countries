package com.lambdaschool.webcountries;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;


@RestController
@RequestMapping("/population")
public class PopulationController
{
    ///localhost:7777/population/size/30000000
    @GetMapping(value="/size/{size}",
            produces={"application/json"})
    public ResponseEntity<?> getCountryByPopulation(@PathVariable int size)
    {
        ArrayList<Country> rtnCount = WebcountriesApplication.myCountryList.
                findCountries(c -> c.getPopulation() >= size);
        return new ResponseEntity<>(rtnCount, HttpStatus.OK);
    }

    //localhost:7777/population/min
    @RequestMapping(value="/min",
            produces={"application/json"})
    public ResponseEntity<?> getCountryWithSmallestPop()
    {
        WebcountriesApplication.myCountryList.countryList.sort(Comparator.comparingInt(Country::getPopulation));
        int minPop=WebcountriesApplication.myCountryList.countryList.get(0).getPopulation();
        ArrayList<Country> rtnMin=WebcountriesApplication.myCountryList.findCountries(c -> (c.getPopulation()==minPop));
        return new ResponseEntity<>(rtnMin, HttpStatus.OK);
    }

    //localhost:7777/population/max
    @RequestMapping(value="/max",
            produces={"application/json"})
    public ResponseEntity<?> getCountryWithBiggestPop()
    {
        WebcountriesApplication.myCountryList.countryList.sort(Comparator.comparingInt(Country::getPopulation).reversed());
        int maxPop=WebcountriesApplication.myCountryList.countryList.get(0).getPopulation();
        ArrayList<Country> rtnMax=WebcountriesApplication.myCountryList.findCountries(c -> (c.getPopulation()==maxPop));
        return new ResponseEntity<>(rtnMax, HttpStatus.OK);
    }
}