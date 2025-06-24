<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>${message}</h1>
  <h2>Names List</h2>
  <hr>
  <%
     String[] names = (String[])request.getAttribute("names");
      if (names != null) {
            for (String name : names) {
                 out.println("<li>" + name + "</li>");
            }
      } else {
            out.println("<p>No names available.</p>");
      }
  %>
  
  <h3>Counters</h3>
  <h3>ApplicationCounter:<%=request.getAttribute("applicationCount") %></h3>  
    <h3>SessionCounter:<%=request.getAttribute("sessionCount") %></h3> 
</body>
</html>