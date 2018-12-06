package com.vironIt.entity;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "seat")
public class Seat {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = SEQUENCE, generator = "seat_id_seq")
    private Integer id;

    @Column(name = "row")
    private Integer row;

    @Column(name = "place")
    private Integer place;

    @Column(name = "is_free")
    private Boolean isFree;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;
}
