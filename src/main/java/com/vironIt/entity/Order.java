package com.vironIt.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {

    private Long id;
    private Long userId;
    private Long distributionId;
    private Long placeId;
    private Date date;
    private String status;
}
