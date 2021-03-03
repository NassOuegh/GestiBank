package com.example.gestibank.models;

import android.service.autofill.ImageTransformation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Agent {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("matricule")
    @Expose
    private String matricule;

    @SerializedName("tel")
    @Expose
    private String tel;

    @SerializedName("mail")
    @Expose
    private String mail;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("role")
    @Expose
    private String role;

    public Agent() {
    }

    public Agent(String name, String mail, String tel, String matricule) {
        this.name=name;
        this.tel=tel;
        this.mail=mail;
        this.matricule= matricule;
        this.password=randompwd();
        this.role="AGENT";
    }

    public static String randompwd() {
        Random generator = new Random();
        StringBuilder randomStringBuilder = new StringBuilder();
        int randomLength = generator.nextInt(12);
        char tempChar;
        for (int i = 0; i < randomLength; i++){
            tempChar = (char) (generator.nextInt(96) + 32);
            randomStringBuilder.append(tempChar);
        }
        return randomStringBuilder.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getAgentInfo(){
        List<String> list = new ArrayList<>();
        list.add(this.name);
        list.add(this.mail);
        list.add(this.tel);
        list.add(this.matricule);
        list.add(this.role);
        list.add(this.password);
        return list;
    }
}
