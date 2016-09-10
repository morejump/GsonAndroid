package com.example.hp.gsonandroid.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by HP on 9/10/2016.
 */
public class FacebookModel {
    @SerializedName("login")
    private String login01;
    private String id ;
    private String avatar_url;

    public String getLogin() {
        return login01;
    }

    public void setLogin(String login) {
        this.login01 = login;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
