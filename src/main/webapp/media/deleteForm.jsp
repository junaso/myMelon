<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>media/deleteForm.jsp</title>
<style type="text/css">
* {
	font-family: gulim;
	font-size: 24px;
}
</style>
<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="title">음원 삭제</div>
	<form method="post" action="./delete.do">
		<input type="hidden" name="mediagroupno" value="${dto.mediagroupno}"> 
		<input type="hidden" name="mediano" value="${dto.mediano}"> 
		<div class="content">
			<p>음원을 삭제하시겠습니까?</p>
			<p>* 관련 미디어 파일(mp3, mp4)도 전부 삭제됩니다</p>
		</div>
		
		<div class="bottom">
			<input type="submit" value="삭제"> 
			<input type="button" value="목록" onclick="location.href='./list.do&${dto.mediagroupno}'">
		</div>
		
	</form>

</body>
</html>
