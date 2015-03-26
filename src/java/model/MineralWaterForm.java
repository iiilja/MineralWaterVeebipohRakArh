/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ilja
 */
public class MineralWaterForm {

    private String id;
    private String name;
    private String mineralisation;
    private String content;

    public MineralWaterForm(String id, String name, String mineralisation, String content) {
        this.id = id;
        this.name = name;
        this.mineralisation = mineralisation;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMineralisation() {
        return mineralisation;
    }

    public void setMineralisation(String mineralisation) {
        this.mineralisation = mineralisation;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public MineralWater toWater(){
        return new MineralWater(Integer.parseInt(id), name, Integer.parseInt(mineralisation), content);
    }
}
