package com.senla.tripstorage.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "review_on_places")
public class ReviewOnPlace {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "uuid", unique = true)
    private String uuid;

    @ManyToOne
    private Usr usr;

    @ManyToOne
    private Place place;
    private Integer userRate;
    private String description;
}
