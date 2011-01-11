<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="/WEB-INF/tags/c.tld"%>

<c:set var="ctx" value="${requestContext.request.contextRoot}" scope="request" />
 
<!DOCTYPE HTML>
<html>
<head>
<title>E건머니 로그인 </title>
<script type="text/javascript" src="${ctx}/style/js/jquery-1.4.2.min.js" charset="utf-8"></script>
<script type="text/javascript">
$(document).ready(function({
	alert("jqeury 먹나");
});
</script>
</head>
<body>

<!-- 
<canvas id="myCanvas">I do not support canvas tag</canvas>
<script type="text/javascript">
var canvas=document.getElementById('myCanvas');
context=canvas.getContext('2d');
context.fillStyle='#00AA00';
context.fillRect(0,0,100,100);
</script>
 -->
<div><c:out value="${errorMessage}" /></div>

<form action="${ctx}/login/login.xhtml" method="post">
아이디 : <input type="text" name="user.userEmail" /> ( 예 : honggildong@chosun.co.kr ) <br />
비밀번호 : <input type="password" name="user.password" /><br />
<input type="submit" value="로그인" />
</form>

</body>
</html>