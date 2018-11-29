package com.vironIt.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "order")
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = SEQUENCE, generator = "order_id_seq")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "distribution_id")
    private Long distributionId;

    @Column(name = "place_id")
    private Long placeId;

    @Column(name = "booking_date")
    private Date date;

    @Column(name = "status")
    private String status;
}
