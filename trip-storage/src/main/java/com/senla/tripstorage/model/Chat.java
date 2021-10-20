package com.senla.tripstorage.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Чат пользователей,
 * состоит из: пользователей, которые в нем учавствуют и сообщений
 */
@Data
@Entity
@Table(name = "chats")
public class Chat {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "uuid", unique = true)
    private String uuid;

    @ManyToMany
    @JoinTable(
            name = "usr_chat",
            joinColumns = @JoinColumn(name = "chat_uuid"),
            inverseJoinColumns = @JoinColumn(name = "usr_uuid")
    )
    private List<Usr> usr;

    @OneToMany(mappedBy = "chat")
    private List<Message> message;
}
