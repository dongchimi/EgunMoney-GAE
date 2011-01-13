<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" isELIgnored="false"%>
 
<!DOCTYPE HTML>
<html>
<head>
<title>E건머니 로그인 </title>
<script type="text/javascript" src="${requestContext.request.contextRoot}/style/js/jquery-1.4.2.min.js" charset="utf-8"></script>
</head>
<body>

<div><c:out value="${errorMessage}" /></div>

<form action="${requestContext.request.contextRoot}/login/login.xhtml" method="post">
아이디 : <input type="text" name="user.userEmail" /> ( 예 : honggildong@chosun.co.kr ) <br />
비밀번호 : <input type="password" name="user.password" /><br />
<input type="submit" value="로그인" />
</form>

</body>
</html>