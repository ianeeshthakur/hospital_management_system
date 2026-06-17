package com.stickytechnologies.hospitalmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Ward {
    @Id

    private String id;

    private String wardname;

    private String wardtype;

    private Integer floor;

    private Integer totalbeds;

    @OneToMany(mappedBy = "ward")
    private List<Beds> beds;
}
