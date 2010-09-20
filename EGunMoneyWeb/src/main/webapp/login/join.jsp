<%@page import="java.util.Enumeration"%>
<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${requestContext.request.contextRoot}" scope="request" />
 
<!DOCTYPE HTML>
<html>
<head>
<title>E건머니 회원가입 </title>
<script type="text/javascript" src="${ctx}/style/js/jquery-1.4.2.min.js" charset="utf-8"></script>
</head>
<body>

<form action="${ctx}/login/join.xhtml" method="post">
id : <input type="email" name="user.userEmail" /><br />
pass : <input type="password" name="user.password" /><br />
nick : <input type="text" name="user.nickName" /><br />
<input type="submit" value="회원가입" /><a href="${ctx}/index.xhtml">취소</a>
</form>

</body>
</html>