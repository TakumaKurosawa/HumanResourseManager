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
public class Skills {

    private int id;
    private String skill1;
    private String skill2;
    private String skill3;
    private String skill4;
    private String skill5;

    public Skills(String skill1, String skill2, String skill3, String skill4, String skill5) {
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.skill3 = skill3;
        this.skill4 = skill4;
        this.skill5 = skill5;
    }

    public int getId() {
        return id;
    }

    public String getSkill1() {
        return skill1;
    }

    public String getSkill2() {
        return skill2;
    }

    public String getSkill3() {
        return skill3;
    }

    public String getSkill4() {
        return skill4;
    }

    public String getSkill5() {
        return skill5;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSkill1(String skill1) {
        this.skill1 = skill1;
    }

    public void setSkill2(String skill2) {
        this.skill2 = skill2;
    }

    public void setSkill3(String skill3) {
        this.skill3 = skill3;
    }

    public void setSkill4(String skill4) {
        this.skill4 = skill4;
    }

    public void setSkill5(String skill5) {
        this.skill5 = skill5;
    }

}
