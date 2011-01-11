<%@page import="java.util.Enumeration"%>
<%@ page language="java" pageEncoding="utf-8" contentType="text/html;charset=utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="/WEB-INF/tags/c.tld"%>

<c:set var="ctx" value="${requestContext.request.contextRoot}" scope="request" />
 
<!DOCTYPE HTML>
<html>
<head>
<title>나의 가계부 </title>
<script type="text/javascript" src="${ctx}/style/js/jquery-1.4.2.min.js" charset="utf-8"></script>
<script type="text/javascript">
	function registerAccountBookItem(){
		$("#registerAccountBookItemForm").attr("action", "${ctx}/accountBook/registerAccountBookItem.xhtml");
		$("#registerAccountBookItemForm").submit();
	}
</script>
</head>
<body>

<h2>돈쓴거입력</h2>
<form id="registerAccountBookItemForm" method="post">
	<label for="amount">사용금액 :</label><br />
	<input name="accountBookItem.amount"> <br />
	
	<label for="description">사용내용 :</label><br />
	<input name="accountBookItem.description"> <br />
	
	<label for="tagString">태그:</label><br />
	<input name="accountBookItem.tagString"><br />
	
	<label for="useDate">날짜:</label><br />
	<input name="accountBookItem.useDate"> <br />
	<label for="category">카테고리:</label><br />
	<select name="accountBookItem.category">
		<option value="0">신한카드</option>
	</select> 
	
	<label for="accountBookItem.useMethod">돈쓴방법:</label><br />
	<input type="radio" name="useMethod" value="Cash" /> 현금
	<input type="radio" name="useMethod" value="Card" /> 카드

	<label for="selectCard">카드선택:</label><br />
	<select name="selectCard">
		<option value="0">신한카드</option>
	</select>
	
	<label for="useMethod">할부:</label>
	<input type="radio" name="useMethod" value="Card" />개월<br />
	
	<input type="button" value="완료" onclick="registerAccountBookItem()" /> <a href="#">취소</a>
</form>
<br/ ><br />
<div style="clear:both;" ></div>
<H2>돈쓴내용목록</H2>

<table border=1 style="width:100%">
	<colgroup>
		<col style="text-align: center">
		<col style="text-align: center">
		<col style="text-align: center">
		<col style="text-align: right">
	</colgroup>
	<tr>
		<th>날짜</th>
		<th>카테고리</th>
		<th>사용내용</th>
		<th>나간돈(원)</th>
	</tr>
	<c:forEach items="${accountBookItems}" var="item">
	<tr>
		<td>${item.useDate}</td>
		<td>${item.myCategoryName}</td>
		<td>${item.description}</td>
		<td>${item.amount}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>