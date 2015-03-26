/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.MineralWater;

public class MineralWaterDAO {

    Connection con;
    Statement s;

    private void connect() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String serverName = "imbi.ld.ttu.ee";
        String mydatabase = "t112818_mineralwater";
        String url = "jdbc:postgresql://" + serverName + "/" + mydatabase;
        String username = "t112818";
        String password = "KrCGbxXP";
        /*String serverName = "hektor4.ttu.ee";
         String mydatabase = "t112818_MineralWater";
         String url = "jdbc:postgresql://" + serverName + "/" + mydatabase;
         String username = "t112818";
         String password = "NpxpIU38";*/

        try {
            con = DriverManager.getConnection(url, username, password);
            s = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public MineralWater[] findAll() throws ConnectException {
        connect();
        ArrayList<MineralWater> waterArray = new ArrayList<>();
        try {
            String sql = "SELECT * from water";
            if (s == null) {
                throw new ConnectException("could not connect to DB");
            }
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                MineralWater water = new MineralWater(rs.getInt("id"),rs.getString("name"),
                        rs.getInt("mineralisation"),rs.getString("content"));
                waterArray.add(water);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return waterArray.toArray(new MineralWater[waterArray.size()]);
    }

    public MineralWater findById(int id) throws ConnectException {
        connect();
        try {
            String sql = "SELECT * FROM water WHERE id='" + id + "'";
            if (s == null) {
                throw new ConnectException("could not connect to DB");
            }
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                MineralWater water = new MineralWater(rs.getInt("id"), rs.getString("name"),
                        rs.getInt("mineralisation"), rs.getString("content"));
                return water;
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return null;
    }

    public void update(MineralWater o) throws ConnectException {
        connect();
        String sql = "UPDATE water SET name='" + o.getName() + "', mineralisation='" + o.getMineralisation() 
                + "', content='" + o.getContent()+ "' WHERE id='" + o.getId() + "'";
        if (s == null) {
            throw new ConnectException("could not connect to DB");
        }
        try {
            s.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
