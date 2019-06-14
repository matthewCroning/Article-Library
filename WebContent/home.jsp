<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="classes.Article"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	

<%
ArrayList<Article> articles = (ArrayList<Article>)request.getAttribute("articles");
%>
 <table id="myTable" class="table">
    <thead>
      <tr>
    <form id="register-form" action="Home" method="post" role="form" style="display: none;">
			 
        <th><input type="submit" name="id_sort" id="id_sort" tabindex="4" class="btn btn-link" value="Id"></th>
        <th><input type="submit" name="headline_sort" id="headline_sort" tabindex="4" class="btn btn-link" value="Headline"></th>
        <th><input type="submit" name="agency_sort" id="agency_sort" tabindex="4" class="btn btn-link" value="Agency"></th>
   </form>   
      </tr>
    </thead>
    	<div class="container">
  <div class="row">
    <tbody>
						
<%
	
for(Article article : articles)
{
	out.print("<tr>");
    out.print("<td>" + article.getId() + "</td>");
    out.print("<td><a href = 'Article" + "?id=" + article.getId() + "'>" + article.getHeadline() + "</a></td>");
    out.print("<td>" + article.getAgency() + "</td>");
    out.print("</tr>");
}
%>

  </tbody>
  </table>
</div>
</div>

</body>
</html>