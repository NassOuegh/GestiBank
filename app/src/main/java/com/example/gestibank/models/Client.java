package com.example.gestibank.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Client {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("tel")
    @Expose
    private String tel;

    @SerializedName("mail")
    @Expose
    private String mail;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("role")
    @Expose
    private String role;

    public Client() {
    }

    public Client(String name, String mail, String tel, String type) {
        this.name=name;
        this.tel=tel;
        this.mail=mail;
        this.status="EN ATTENTE";
        this.password="1234";
        this.type=type;
        this.role="CLIENT";
    }

    public String getType() {
        return type;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}