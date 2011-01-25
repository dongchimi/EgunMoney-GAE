<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
 <c:set var="ctx" value="${pageContext.request.contextPath}" scope="request"/>
 
<!DOCTYPE HTML>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Welcome</title>
</head>
<body>
<p><a href="${requestContext.request.contextRoot}/auth/form">로그인</a> |<a href="${requestContext.request.contextRoot}/signup/form">회원가입</a></p>
</body>
</html>