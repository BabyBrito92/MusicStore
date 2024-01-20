package com.MusicStore.MusicStore.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("Albums")
public class Album extends Product{
    @Id
    String id;
    @Field(name="albumID")
     Long albumID;
    @Field(name="title")
    String title;
    @Field(name="artistID")
    Long artistID;
    @Field(name="quantity")
    int albumQuantity;
    @Field(name="label")
    String label;
    @Field(name="imagePath")
    String imagePath;
    @Field(name="genre")
    String genre;
    @Field(name="releaseDate")
    int releaseDate;

    public Album(){
        super();
    }

    public Album(Long albumID, String title, Long artistID, String label, String imagePath, int albumQuantity, String genre, int releaseDate) {
        super();
        this.albumID = albumID;
        this.title = title;
        this.artistID = artistID;
        this.label = label;
        this.albumQuantity = albumQuantity;
        this.imagePath = imagePath;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }
    public String getID() {
        return id;
    }

    public Long getAlbumID() {
        return albumID;
    }

    public void setAlbumID(Long albumID) {
        this.albumID = albumID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getArtistID() {
        return artistID;
    }

    public void setArtistID(Long artistID) {
        this.artistID = artistID;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getAlbumQuantity() {
        return albumQuantity;
    }

    public void setAlbumQuantity(int albumQuantity) {
        this.albumQuantity = albumQuantity;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }


    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }


}
