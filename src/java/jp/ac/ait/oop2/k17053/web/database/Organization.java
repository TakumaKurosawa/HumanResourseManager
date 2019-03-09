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
public class Organization {

    private int id;
    private String team_name;
    private int skills_id;
    private String communication_tool;
    private String created_by;

    public Organization(int id, String team_name, int skills_id, String communication_tool, String created_by) {
        this.id = id;
        this.team_name = team_name;
        this.skills_id = skills_id;
        this.communication_tool = communication_tool;
        this.created_by = created_by;
    }

    public String getCommunication_tool() {
        return communication_tool;
    }

    public String getCreated_by() {
        return created_by;
    }

    public int getId() {
        return id;
    }

    public int getSkills_id() {
        return skills_id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setCommunication_tool(String communication_tool) {
        this.communication_tool = communication_tool;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSkills_id(int skills_id) {
        this.skills_id = skills_id;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

}
