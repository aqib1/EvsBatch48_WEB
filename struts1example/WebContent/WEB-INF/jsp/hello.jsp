<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="struts"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>There</h1>
<c:if test="${ helloForm.show == true}">
<struts:write name="helloForm" property="message"/>
<html:form action="/loginAction">
Enter name = <html:text name="loginForm" property="name"></html:text>
Enter password= <html:password name="loginForm" property="password"></html:password>
<html:submit></html:submit>
</html:form>
</c:if>
</body>
</html>