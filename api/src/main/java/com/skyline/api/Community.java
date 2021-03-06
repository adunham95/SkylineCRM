package com.skyline.api;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Document(collection = "communities")
public class Community {
    @Id
    private String id;

    public String name;
    public String city;
    public String state;

    @Override
    public String toString() {
        return "communities{" +
                ", name='" + name + '\'' +
                ", city=" + city + '\'' +
                ", state=" + state + '\'' +
                '}';
    }

    public Community(String name, String city, String state){
        this.name = name;
        this.city = city;
        this.state = state;
    }

    public Community(){}

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }
}
