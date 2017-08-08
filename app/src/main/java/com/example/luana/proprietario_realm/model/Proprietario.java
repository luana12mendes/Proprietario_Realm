package com.example.luana.proprietario_realm.model;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import java.io.Serializable;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class Proprietario extends RealmObject implements Serializable {

    @PrimaryKey
    private int id;
    private String nome;
    private String end;
    private String cidade;
    private String cnh;
    private String tel;
    private String bairro;
    private String email;
    private String lat;
    private String longi;


    public Proprietario() {

    }

    public Proprietario(int id, String nome , String end, String cidade, String cnh, String tel, String bairro, String email,
                        String lat, String longi) {
        this.id = id;
        this.nome = nome;
        this.end = end;
        this.cidade = cidade;
        this.cnh = cnh;
        this.tel = tel;
        this.bairro = bairro;
        this.email = email;
        this.lat = lat;
        this.longi = longi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEnd() {return end;}

    public void setEnd(String end) {this.end = end;}

    public String getCidade() {return cidade;}

    public void setCidade(String cidade) {this.cidade = cidade;}

    public String getCnh() {return cnh;}

    public void setCnh(String cnh) {this.cnh = cnh;}

    public String getTel() {return tel;}

    public void setTel(String tel) {this.tel = tel;}

    public String getBairro() {return bairro;}

    public void setBairro(String bairro) {this.bairro = bairro;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getLat() {return lat;}

    public void setLat(String lat) {this.lat = lat;}

    public String getLongi() {return longi;}

    public void setLongi(String longi) {this.longi = longi;}

}
