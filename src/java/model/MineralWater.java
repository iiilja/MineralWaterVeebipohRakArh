/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

public class MineralWater {
    private int id;
    private String name;
    private int mineralisation;
    private String content;

    public MineralWater(int id, String name, int mineralisation, String content) {
        this.id = id;
        this.name = name;
        this.mineralisation = mineralisation;
        this.content = content;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMineralisation() {
        return mineralisation;
    }

    public void setMineralisation(int mineralisation) {
        this.mineralisation = mineralisation;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
