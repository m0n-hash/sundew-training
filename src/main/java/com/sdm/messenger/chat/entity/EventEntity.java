package com.sdm.messenger.chat.entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import sun.jvm.hotspot.ui.tree.CTypeTreeNodeAdapter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ch.tbl_events")
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "createdUser", columnDefinition = "BIGINT UNSIGNED", nullable = true)
    @NotFound(action = NotFoundAction.IGNORE)
    private UserEntity createdUser;

    @Column
    private String eventName;

    @Column
    private String geoLocation;

    @Column
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date eventDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "chatRoom", columnDefinition = "BIGINT UNSIGNED", nullable = true)
    @NotFound(action = NotFoundAction.IGNORE)
    private ChatRoomEntity chatRoom;

    public EventEntity(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserEntity getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(UserEntity createdUser) {
        this.createdUser = createdUser;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(String geoLocation) {
        this.geoLocation = geoLocation;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public ChatRoomEntity getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(ChatRoomEntity chatRoom) {
        this.chatRoom = chatRoom;
    }
}
