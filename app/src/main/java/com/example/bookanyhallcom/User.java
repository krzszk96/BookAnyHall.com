package com.example.bookanyhallcom;

public class User {
    private String HallId;
    private String HallName;
    private String HallStreet;
    private String HallPost;
    private String HallCity;

    public User(String hId, String hName, String hStreet, String hPost, String hCity) {
        HallId = hId;
        HallName = hName;
        HallStreet = hStreet;
        HallPost = hPost;
        HallCity = hCity;
    }

    public String getHallid() {
        return HallId;
    }

    public String getHallname() {
        return HallName;
    }

    public String getHallstreet() {
        return HallStreet;
    }

    public String getHallpost() {
        return HallPost;
    }

    public String getHallcity() {
        return HallCity;
    }
}
