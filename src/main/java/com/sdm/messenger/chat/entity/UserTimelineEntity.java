package com.sdm.messenger.chat.entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ch.tbl_user_timelines")
public class UserTimelineEntity {
    public enum TimelinePermission{
        ONLY_ME,
        CUSTOM,
        PUBLIC
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tbl_timeline_images",
            joinColumns = @JoinColumn(name = "timelineId", columnDefinition = "MEDIUMINT UNSIGNED"),
            inverseJoinColumns = @JoinColumn(name = "fileId", columnDefinition = "MEDIUMINT UNSIGNED"))
    @NotFound(action = NotFoundAction.IGNORE)
    private Set<FileEntity> timelineImages = new HashSet<>();

    @Column
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date timelineDate;

    @Column(length = 500)
    private String description;

    @Enumerated(EnumType.STRING)
    private TimelinePermission permission;

    public UserTimelineEntity(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<FileEntity> getTimelineImages() {
        return timelineImages;
    }

    public void setTimelineImages(Set<FileEntity> timelineImages) {
        this.timelineImages = timelineImages;
    }

    public Date getTimelineDate() {
        return timelineDate;
    }

    public void setTimelineDate(Date timelineDate) {
        this.timelineDate = timelineDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TimelinePermission getPermission() {
        return permission;
    }

    public void setPermission(TimelinePermission permission) {
        this.permission = permission;
    }
}
