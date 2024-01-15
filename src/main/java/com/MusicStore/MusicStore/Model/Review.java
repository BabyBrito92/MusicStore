package com.MusicStore.MusicStore.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("Reviews")
public class Review {

    @Id
    private String id;

    @Field(name="accountiD")
    private String accountiD;

    @Field(name="comment")
    private String comment;

    @Field(name="rating")
    private Float rating;

    public Review(String accountiD, String comment, Float rating) {
        this.accountiD = accountiD;
        this.comment = comment;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public String getAccountiD() {
        return accountiD;
    }

    public void setAccountiD(String accountiD) {
        this.accountiD = accountiD;
    }


    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Review(){

    }
}
