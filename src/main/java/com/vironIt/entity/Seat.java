package com.vironIt.entity;

import lombok.Data;

@Data
public class Seat {

    private Integer id;
    private Integer row;
    private Integer place;
    private Boolean isFree;
    private Cinema cinema;
}
