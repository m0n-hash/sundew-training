package com.sdm.messenger.chat.entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@Table(name = "ch.tbl_files")
public class FileEntity {
    public enum FileType{
        LOCAL,
        EXTERNAL
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ownerId", columnDefinition = "BIGINT UNSIGNED", nullable = true)
    @NotFound(action = NotFoundAction.IGNORE)
    private UserEntity owner;

    @Column(length = 1000, nullable = false)
    private String path;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private FileType type;

    public FileEntity(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity owner) {
        this.owner = owner;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public FileType getType() {
        return type;
    }

    public void setType(FileType type) {
        this.type = type;
    }
}
