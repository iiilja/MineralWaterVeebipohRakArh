<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="model.MineralWater"%> 
<jsp:useBean id="water" scope="request" type="model.MineralWater[]"/>
<html>
<head>
<script src="static/js/water.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mineral Water</title>
</head>
<body>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<a href='s'>servlet</a> | <a href='http://imbi.ld.ttu.ee/tomcat_webapp_logs/t112818_MineralWater/log.txt'>log</a> <br>
Mineral Water list: 
<br>

<% 
      String id = "" ;
      String name = "" ;
      String mineralisation = "" ;
      String content = "";
      out.println("<table border=1 cellpadding=2 cellspacing=1>");
      out.println("<tr bgcolor='#cccccc'><td><STRONG> id&nbsp;</td><td><STRONG>Name&nbsp;</td><td><STRONG>Mineralisation&nbsp;</td><td><STRONG>Contents&nbsp;</td><td>link</td></tr><tr></tr>");

      try
      {
         for (int n = 0; n < water.length ; n++)
              {    
                id = Integer.toString(water[n].getId()) ;
                name = water[n].getName();
                mineralisation = Integer.toString(water[n].getMineralisation()) ;
                content = water[n].getContent();
                out.println("<TR BGCOLOR='#FFFFFF' ><TD  nowrap>");
                //out.println("&nbsp;"+ id + "&nbsp;</TD><TD>"+ type +  "&nbsp;</TD><TD>"+ count + "&nbsp");
                out.println("&nbsp;"+ id + "&nbsp;</TD><TD>"+ name + "&nbsp;</TD><TD>"+ mineralisation + "&nbsp;</TD><TD>"+"<a href='javascript:showDescription("+id+")' target='_self'>Description</a>"+"&nbsp");             
                out.println("</TD><TD align='top' nowrap><a HREF='s?id=" + id + "' TARGET='_self'><b><u>change</u><b></a></TD></TR>");
              }
     }
    catch(Exception ex)
      { 
      out.println("Some error" + ex.getMessage());

       }
         
         out.println("</table>");
         out.println("</form>");
	
 %>
 
 <br>
 <br>
 <div ID="ajax_response">
</div>
<div ID="description_form" style="visibility:hidden;">
<form name=description_form>
<TABLE BGCOLOR='#cccccc'>
<TR BGCOLOR='#ffffff'><TD BGCOLOR='#eeeeee' COLSPAN=2>Contents</TD></tr>
<TR BGCOLOR='#ffffff'><TD BGCOLOR='#cccccc' nowrap>Mineral water id</td><td BGCOLOR='#cccccc'><input type=text name=water_id size=4 disabled id='id'></TD></tr>
<TR BGCOLOR='#ffffff'><TD BGCOLOR='#cccccc' nowrap>Contents</td><td BGCOLOR='#cccccc'><textarea name=description cols=25 rows=5 id="desc"></textarea></TD></tr>
<TR BGCOLOR='#ffffff'><TD BGCOLOR='#cccccc' nowrap COLSPAN=2><input type="button" value="HIDE" onClick="hide_description_form()"></TD></tr>
</TABLE>
</form>
</div>








</body>
</html>