package com.sdm.messenger.chat.entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ch.tbl_users")
public class UserEntity {
    public enum UserGender{
        MALE,
        FEMALE,
        OTHERS,
        UNSPECIFIED
    }

    public enum MaritalStatus{
        SINGLE,
        IN_RELATIONSHIP,
        MARRIED,
        FA,
        UNSPECIFIED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "profileImage", columnDefinition = "BIGINT UNSIGNED", nullable = true)
    @NotFound(action = NotFoundAction.IGNORE)
    private FileEntity profileImage;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 50, nullable = false)
    private String phoneNo;

    @Column(length = 255, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private UserGender gender;

    @Column(length = 255)
    private String displayName;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date dateOfBirth;

    @Column(length = 500)
    private String address;

    @Column(length = 50)
    private String mapLocation;

    @Column(length=1000)
    private String biography;

    @Column(length=500)
    private String education;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private MaritalStatus maritalStatus;

    @Column(length = 50)
    private String mobileType;

    @Column(length = 255)
    private String occupation;

    @Column(length = 255)
    private String facebookToken;

    @Column(length = 255)
    private String hobby;

    @Column(length = 500)
    private String currentFeeling;

    @Column(length = 1)
    private String currentStatus;

    public UserEntity(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FileEntity getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(FileEntity profileImage) {
        this.profileImage = profileImage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserGender getGender() {
        return gender;
    }

    public void setGender(UserGender gender) {
        this.gender = gender;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMapLocation() {
        return mapLocation;
    }

    public void setMapLocation(String mapLocation) {
        this.mapLocation = mapLocation;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getMobileType() {
        return mobileType;
    }

    public void setMobileType(String mobileType) {
        this.mobileType = mobileType;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getFacebookToken() {
        return facebookToken;
    }

    public void setFacebookToken(String facebookToken) {
        this.facebookToken = facebookToken;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getCurrentFeeling() {
        return currentFeeling;
    }

    public void setCurrentFeeling(String currentFeeling) {
        this.currentFeeling = currentFeeling;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }
}
