package com.vironIt.entity;

import lombok.*;
import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "cinema")
public  class Cinema {

   @Id
   @Column(name = "id")
   @GeneratedValue(strategy = SEQUENCE, generator = "user_id_seq")
   private Integer id;

   @Column(name = "name")
   private String name;

   @Column(name = "address")
   private String address;
}