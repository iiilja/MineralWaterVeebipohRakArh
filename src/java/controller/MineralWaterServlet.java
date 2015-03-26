/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import db.MineralWaterDAO;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MineralWater;
import model.MineralWaterForm;
import org.apache.log4j.Logger;

public class MineralWaterServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;
    private MineralWaterDAO db = new MineralWaterDAO();
    Logger logger = Logger.getLogger("controller.MineralWaterServlet");

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MineralWaterServlet() {
        super();
        init();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    public void init() {
        logger.error("MineralWaterServlet.init(): mind loodi");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        if (id != null) {
            int foo = 0;
            try {
                foo = Integer.parseInt(id);
            } catch (NumberFormatException e) {
                //logger.error("MineralWaterServlet.doGet(): wrong data: "+ id);

            }

            if (db.findById(foo).getId() == 0) {
                logger.error("MineralWaterServlet.doGet(): wrong id: " + id);
                response.sendRedirect("error.jsp");
            } else {
                MineralWater water = db.findById(foo);
                System.out.println(water);
                request.setAttribute("mineralWater", water.toForm());
                request.getRequestDispatcher("mineralWater.jsp").forward(request, response);
            }

        } else {
            MineralWater[] water = db.findAll();
            request.setAttribute("water", water);
            request.getRequestDispatcher("mineralWaterAll.jsp").forward(request, response);

        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String mineralisation = request.getParameter("mineralisation");
        String content = request.getParameter("content");
        System.out.println("Got id = " + id + " name" + name + " mineralisation" + mineralisation + " content = " + content);
        Map<String, String> errorList = new HashMap<>();
        errorList = validate(id, name, mineralisation);

        MineralWaterForm form = new MineralWaterForm(id, name, mineralisation, content);

        if (errorList.isEmpty()) {
            db.update(form.toWater());
        } else {
            logger.error("MineralWaterServlet.doPost(): save failed");
        }
        request.setAttribute("mineralWater", form);

        request.setAttribute("formError", errorList);

        request.getRequestDispatcher("mineralWater.jsp").forward(request, response);

    }
    
    private Map validate(String id, String name, String mineralisation){
        Map<String, String> errorList = new HashMap<>();
        try {
            Integer.parseInt(mineralisation);
        } catch (Exception e) {
            errorList.put("mineralisation", "Only numbers");
        }

        try {
            Integer.parseInt(id);
        } catch (Exception e) {
            errorList.put("id", "Dont touch id !");
        }
        if (name.length() == 0) {
            errorList.put("name", "Can not be empty");
        }
        if (name.length() > 10) {
            errorList.put("name", "Max 10 cahracters");

        }
        return errorList;
    }
}
