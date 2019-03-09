/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ac.ait.oop2.k17053.web.database;

/**
 *
 * @author k17053kk
 */
public class Status {

    private int id;
    private int skill1s;
    private int skill2s;
    private int skill3s;
    private int skill4s;
    private int skill5s;

    public Status(int skill1s, int skill2s, int skill3s, int skill4s, int skill5s) {
        this.skill1s = skill1s;
        this.skill2s = skill2s;
        this.skill3s = skill3s;
        this.skill4s = skill4s;
        this.skill5s = skill5s;
    }

    public int getId() {
        return id;
    }

    public int getSkill1s() {
        return skill1s;
    }

    public int getSkill2s() {
        return skill2s;
    }

    public int getSkill3s() {
        return skill3s;
    }

    public int getSkill4s() {
        return skill4s;
    }

    public int getSkill5s() {
        return skill5s;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSkill1s(int skill1s) {
        this.skill1s = skill1s;
    }

    public void setSkill2s(int skill2s) {
        this.skill2s = skill2s;
    }

    public void setSkill3s(int skill3s) {
        this.skill3s = skill3s;
    }

    public void setSkill4s(int skill4s) {
        this.skill4s = skill4s;
    }

    public void setSkill5s(int skill5s) {
        this.skill5s = skill5s;
    }

}
