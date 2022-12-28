package com.bikash.blogapi.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.NaturalId;

@Entity
@Data
@Table(name="catagories")

public class CatagoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long catagoryId;
    private  String catagoryName;

    private  String catagoryDescription;
}
