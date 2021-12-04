<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>gguksoon_JSP-Board</title>
</head>
	
<body id="">
	<c:forEach var="map" items="${list}">
	    <div>
	    	<div>
	    		<img src="${map.img}" onclick="location.href='${map.downLink}'" style="width:500px;">
	    	</div>
	    	<div>
	    		${map.title}
	    	</div>
	    	<div>
			    ${map.date}
	    	</div>
	    	<div>
			    <a href="${map.downLink}">download</a>
	    	</div>
	    	<hr>
	    	<hr>
	    	<hr>
	    	<hr>
	    	<hr>
	    </div>
	</c:forEach>
</body>
</html>