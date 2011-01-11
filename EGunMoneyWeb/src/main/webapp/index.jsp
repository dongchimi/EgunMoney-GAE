<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="/WEB-INF/tags/c.tld"%>

<c:set var="ctx" value="${requestContext.request.contextRoot}" scope="request" />
 
<!DOCTYPE HTML>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Welcome</title>
</head>
<body>
<p><a href="${ctx}/login/loginView.xhtml">로그인</a> |<a href="${ctx}/login/joinView.xhtml">회원가입</a></p>
</body>
</html>