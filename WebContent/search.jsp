<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	
	
	
	
		<form id="register-formx" action="Search" method="post" role="form">
	 	 <input name="search_id" id="search_id" class="form-control" type="text" placeholder="Id" aria-label="Search">

	 	 <input name="search_headline" id="search_headline" class="form-control" type="text" placeholder="Headline" aria-label="Search">
		
	 	 <input name="search_agency" id="search_agency" class="form-control" type="text" placeholder="Agency" aria-label="Search">
		
	 	 <input name="search_city" id="search_city" class="form-control" type="text" placeholder="City" aria-label="Search">

	 	 <input name="search_date" id="search_date" class="form-control" type="text" placeholder="Date" aria-label="Search">
	
	 	 <input name="search_content" id="search_content" class="form-control" type="text" placeholder="Content" aria-label="Search">
	
		<input type="submit" name="register_submit" id="register_submit" tabindex="4" class="form-control btn btn-login" value="Search">
		</form>
							
</body>
</html>