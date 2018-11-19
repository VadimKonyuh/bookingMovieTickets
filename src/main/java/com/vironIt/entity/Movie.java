package com.vironIt.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Movie {

    private Long id;
    private String title;
    private String duration;
    private String description;
    private Integer ageRate;
    private Date endOfRental;
}
