package com.vironIt.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "distribution")
public class Distribution {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;
    @Column(name = "cinema_id")
    private Long cinemaId;
    @Column(name = "movie_id")
    private Long movieId;
    @Column(name = "date")
    private Date date;
}
