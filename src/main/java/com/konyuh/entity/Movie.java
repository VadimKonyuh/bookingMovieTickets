package com.konyuh.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = SEQUENCE, generator = "movie_id_seq")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "duration")
    private String duration;

    @Column(name = "description")
    private String description;

    @Column(name = "age_rate")
    private Integer ageRate;

    @ManyToMany
    @JoinTable(name = "movie_genre",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "genre_id")})
    private List<Genre> genres = new ArrayList<>();
}
