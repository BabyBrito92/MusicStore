package com.MusicStore.MusicStore.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("Artists")
public class Artist {

    @Id
    private String id;
    @Field(name="artistName")
    private String artistName;
    @Field(name="bio")
    private String bio;

    public Artist(String artistName, String bio) {
        this.id = id;
        this.artistName = artistName;
        this.bio = bio;
    }

    public String getId() {
        return id;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
