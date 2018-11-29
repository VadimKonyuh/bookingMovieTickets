package com.vironIt.entity;

import lombok.Data;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import static javax.persistence.GenerationType.SEQUENCE;



@Data
@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = SEQUENCE, generator = "genre_id_seq")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany
    private List<Movie> movies = new ArrayList<>();

//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {
//                    CascadeType.PERSIST,
//                    CascadeType.MERGE
//            },
//            mappedBy = "genres")
}
