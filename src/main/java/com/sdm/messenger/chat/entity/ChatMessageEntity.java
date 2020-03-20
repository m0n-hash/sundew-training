package com.sdm.messenger.chat.entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ch.tbl_chat_messages")
public class ChatMessageEntity {
    public enum MessageType{
        TEXT,
        IMAGE,
        STICKER,
        EMOJI,
        VOICE,
        VIDEO,
        LOCATION
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "chatRoom", columnDefinition = "BIGINT UNSIGNED", nullable = true)
    @NotFound(action = NotFoundAction.IGNORE)
    private ChatRoomEntity chatRoom;

    @Column(length = 1000)
    private String message;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private MessageType messageType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "replyMessage", columnDefinition = "BIGINT UNSIGNED", nullable = true)
    @NotFound(action = NotFoundAction.IGNORE)
    private ChatMessageEntity replyMessage;

    @Column
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date messageDate;

    @Column(length = 1)
    private String messageStatus;

    public ChatMessageEntity(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ChatRoomEntity getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(ChatRoomEntity chatRoom) {
        this.chatRoom = chatRoom;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public ChatMessageEntity getReplyMessage() {
        return replyMessage;
    }

    public void setReplyMessage(ChatMessageEntity replyMessage) {
        this.replyMessage = replyMessage;
    }

    public Date getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }

    public String getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(String messageStatus) {
        this.messageStatus = messageStatus;
    }
}
