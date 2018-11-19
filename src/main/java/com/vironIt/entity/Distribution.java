package com.vironIt.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Distribution {

    private Long id;
    private Long cinemaId;
    private Long movieId;
    private Date date;

}
