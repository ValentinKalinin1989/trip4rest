package com.senla.tripstorage.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * сообщение состоит из:
 * чата,
 * пользователя,
 * текста сообщения
 * и даты сообщения
 */
@Data
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "uuid", unique = true)
    private String uuid;

    @ManyToOne
    @JoinColumn(name = "chat_uuid")
    private Chat chat;

    @ManyToOne
    @JoinColumn(name = "usr_uuid")
    private Usr usr;
    private String text;
    private LocalDateTime dateTime;
}
