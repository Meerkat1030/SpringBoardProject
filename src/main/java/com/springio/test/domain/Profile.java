package com.springio.test.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor

@Table
@Entity
public class Profile implements Serializable{

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String network;

    @Column
    private String username;

    @Column
    private String url;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedDate;

    @Builder

    public Profile(String network, String username, String url, LocalDateTime createdAt, LocalDateTime updateDate) {
        this.network = network;
        this.username = username;
        this.url = url;
        this.createdAt = createdAt;
        this.updatedDate = updatedDate;
    }

    public void setCreatedAtNow(){
        this.createdAt = LocalDateTime.now();
    }

    public void updateProfile(Profile profile){
        this.network = profile.network;
        this.username = profile.username;
        this.url = profile.url;
        this.updatedDate = LocalDateTime.now();
    }

}
