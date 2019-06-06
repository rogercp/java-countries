package com.lambdaschool.webcountries;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
@RequestMapping("/names")
public class NameController
{
    ///localhost:7777/names/all
    @RequestMapping(value="/all",
            produces={"application/json"})
    public ResponseEntity<?> getAllCountries()
    {
        WebcountriesApplication.myCountryList.countryList.sort((c1,c2)->c1.getName().compareToIgnoreCase((c2.getName())));
        return new ResponseEntity<>(WebcountriesApplication.myCountryList.countryList, HttpStatus.OK);
    }

    ///localhost:7777/names/start/s
    @GetMapping(value="/start/{letter}",
            produces={"application/json"})
    public ResponseEntity<?> getCountryByFirstLetter(@PathVariable char letter)
    {
        ArrayList <Country> rtnCountries=WebcountriesApplication.myCountryList.
                findCountries(c-> c.getName().toUpperCase().charAt(0)==Character.toUpperCase(letter));
        return new ResponseEntity<>(rtnCountries, HttpStatus.OK);
    }

    ///localhost:7777/names/size/3
    @GetMapping(value="/size/{length}",
            produces={"application/json"})
    public ResponseEntity<?> getCountryByNameLength(@PathVariable int length)
    {
        ArrayList<Country> rtnCountri = WebcountriesApplication.myCountryList.
                findCountries(c -> c.getName().length() >= length);
        rtnCountri.sort((c1, c2) -> c1.getName().compareToIgnoreCase((c2.getName())));
        return new ResponseEntity<>(rtnCountri, HttpStatus.OK);
    }

}

//        /names/all return the names of all the countries alphabetically
//        /names/start/{letter}return the countries alphabetically that begin with the given letter
//        /names/size/{number}return the countries alphabetically that have a name equal to or longer than the given length
//        /population/size/{people}return the countries that have a population equal to or greater than the given population
//        /population/min return the country with the smallest population
//        /population/max return the country with the largest population
//
//        Stretch Goal
//
//        /population/median return the country with the median population
//        /age/age/{age}return the countries that have a median age equal to or greater than the given age
//        /age/min return the country with the smallest median age
//        /age/max return the country the the greatest median age