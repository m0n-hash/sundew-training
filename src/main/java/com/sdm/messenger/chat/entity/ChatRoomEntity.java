package com.sdm.messenger.chat.entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ch.tbl_chat_rooms")
public class ChatRoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "createdUser", columnDefinition = "BIGINT UNSIGNED", nullable = true)
    @NotFound(action = NotFoundAction.IGNORE)
    private UserEntity createdUser;

    @NotFound(action = NotFoundAction.IGNORE)
    @JoinTable(name = "tbl_chat_members",
            joinColumns = {@JoinColumn(name = "chat_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<UserEntity> chatMembers = new HashSet<>();

    @Column
    private String name;

    public ChatRoomEntity(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public UserEntity getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(UserEntity createdUser) {
        this.createdUser = createdUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
