package com.senla.tripstorage.model.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * отзывы на места, событи и маршрут
 * состоит из:
 * типа объект
 * пользователя
 * рейтинга
 * текста отзыва
 */
@Data
@Entity
@Table(name = "review_on_trips")
public class ReviewOnTrip {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "uuid", unique = true)
    private String uuid;

    @ManyToOne
    private Usr usr;

    @ManyToOne
    private Trip trip;
    private Integer userRate;
    private String description;
}
