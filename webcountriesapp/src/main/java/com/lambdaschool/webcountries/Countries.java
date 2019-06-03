package com.lambdaschool.webcountries;

import java.util.concurrent.atomic.AtomicLong;

public class Countries
{
    private static final AtomicLong counter = new AtomicLong();
    private long id;
    private String name;
    private int population;
    private int  age;

    public Countries(String name, int population, int age)
    {
        this.id=counter.incrementAndGet();
        this.name = name;
        this.population = population;
        this.age = age;
    }



    public long getId()
    {
        return id;
    }


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getPopulation()
    {
        return population;
    }

    public void setPopulation(int population)
    {
        this.population = population;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "Countries{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", age=" + age +
                '}';
    }
}
