/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ac.ait.oop2.k17053.web.database;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 *
 * @author k17053kk
 */
public class User {

    private int id;
    private String name;
    private InputStream photo;
    private String position;
    private String phone;
    private String message;
    private String email;
    private String password;
    private int status_id;
    private int organization_id;

    public User(String name, InputStream photo, String position, String phone, String message, String email, String password, int organization_id) {
        this.name = name;
        this.photo = photo;
        this.position = position;
        this.phone = phone;
        this.message = message;
        this.email = email;
        this.password = password;
        this.organization_id = organization_id;
    }

    public User(String name, String position, String phone, String message, String email, String password) {
        this.name = name;
        this.position = position;
        this.phone = phone;
        this.message = message;
        this.email = email;
        this.password = password;
    }

    public User(int id, String name, String position, String phone, InputStream photo, String message, String email, String password, int status_id, int organization_id) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.phone = phone;
        this.photo = photo;
        this.message = message;
        this.email = email;
        this.password = password;
        this.status_id = status_id;
        this.organization_id = organization_id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getPhone() {
        return phone;
    }

    public InputStream getPhoto() {
        return photo;
    }

    public String getMessage() {
        return message;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getStatus_id() {
        return status_id;
    }

    public int getOrganization_id() {
        return organization_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setOrganization_id(int organization_id) {
        this.organization_id = organization_id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

}
