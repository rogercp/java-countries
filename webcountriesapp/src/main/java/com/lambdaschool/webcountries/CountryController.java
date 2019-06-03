package com.lambdaschool.webcountries;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/data")
public class CountryController
{
    ///localhost:7777/data/all
    @RequestMapping(value="/all",
                    produces={"application/json"})
    public ResponseEntity<?> getAllCountries()
    {
        WebcountriesApplication.myCountryList.countryList.sort((c1,c2)->c1.getName().compareToIgnoreCase((c2.getName())));
        return new ResponseEntity<>(WebcountriesApplication.myCountryList.countryList, HttpStatus.OK);
    }

}
