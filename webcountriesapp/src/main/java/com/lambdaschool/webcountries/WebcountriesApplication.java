package com.lambdaschool.webcountries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebcountriesApplication
{
    static CountriesList myCountryList;

    public static void main(String[] args)
    {
        myCountryList=new CountriesList();
        SpringApplication.run(WebcountriesApplication.class, args);

    }

}
