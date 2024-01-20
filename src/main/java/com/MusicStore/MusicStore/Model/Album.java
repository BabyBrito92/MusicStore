package com.MusicStore.MusicStore.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("Albums")
public class Album extends Product{
    @Id
    private String id;
    @Field(name="albumID")
    private Long albumID;
    @Field(name="title")
    private String title;
    @Field(name="artistID")
    private Long artistID;
    @Field(name="quantity")
    private int albumQuantity;
    @Field(name="label")
    private String label;
    @Field(name="imagePath")
    private String imagePath;
    @Field(name="genre")
    private String genre;
    @Field(name="releaseDate")
    private int releaseDate;

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
