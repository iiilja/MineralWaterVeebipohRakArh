<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="model.MineralWaterForm"%> 
<jsp:useBean id="water" scope="request" type="model.MineralWaterForm"/>
<jsp:useBean id="formError" class="java.util.HashMap" scope="request"/>


    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Change Mineral water</title>
        </head>
        <body>


            <a href='s'>servlet</a> | <a href='http://imbi.ld.ttu.ee/tomcat_webapp_logs/t112818_MineralWater/log.txt'>log.txt</a> <br>

            <form action='s?action=save' method=POST>
            <%
                String trStart = "<TR BGCOLOR='#ffffff'><TD BGCOLOR='#cccccc' nowrap>";

                String id = water.getId() + "";
                String name = water.getName();
                String mineralisation = water.getMineralisation()+ "";
                String content = water.getContent();

                String nameError = "";
                String mineralisationError = "";

                if (formError.get("nameError") != null) {
                    nameError = (String) formError.get("nameError");

                }
                if (formError.get("mineralisationError") != null) {
                    mineralisationError = (String) formError.get("nameError");
                }

                if (!formError.isEmpty()) {

                    out.println("<table><tr><td><b><font face=arial color=red>Prooviti salvestada - aga ei onnestunud!</b></td></tr></table>");
                }

                out.println("<table bgcolor='#000000' border=0 cellpadding=0 cellspacing=0><tr><td><table width=100% border=0 cellpadding=2 cellspacing=1>");
                out.println(trStart + "id:</td><td>&nbsp;" + id + "&nbsp;</TD></tr>");
                out.println(trStart + "Size:</td><td>&nbsp;<b><font color='#0000ff'><input type='text' value='" + name + "' name='size'></font></b>" + nameError + "</TD></tr>");
                out.println(trStart + "Cost:</td><td>&nbsp;<b><font color='#0000ff'><input type='text' value='" + mineralisation + "' name='cost'></font></b>" + mineralisationError + "</TD></tr>");
                out.println(trStart + "Description</td><td>&nbsp;<b><font color='#0000ff'><textarea name=\"description\" cols=25 rows=6>" + content + "</textarea></font></b></TD></tr>");
                out.println("</table></td></tr></table>");


            %>

            <input type="submit" value="salvesta" >
            <input type="hidden" name="id" value="<%=id%>" />  




    </body>
</html>