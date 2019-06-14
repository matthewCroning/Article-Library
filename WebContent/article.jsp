<%@page import="classes.Article"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Article</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container">
  <div class="row">
	<%
	
	Article article =  (Article)request.getAttribute("article");
    out.print("<h5> id: " + article.getId() + "</h3>");
    out.print("<h5> Headline: " + article.getHeadline() + "</h3>");
    out.print("<h5> Agency: " + article.getAgency() + "</h3>");
    out.print("<h5> Date: " + article.getDate() + "</h3>");
    out.print("<h5> City: " + article.getCity() + "</h3>");
    out.print("<h5> Content: " + article.getContent() + "</h5>");
	%>
	</div>
	</div>
</body>
</html>