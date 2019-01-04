package com.konyuh.entity;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_id", nullable = false)
    private Cinema cinema;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @Column(name = "date")
    private Date date;
}
