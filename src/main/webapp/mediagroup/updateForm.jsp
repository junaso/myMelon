<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mediagroup/upateForm.jsp</title>
<style type="text/css">
* {
	font-family: gulim;
	font-size: 24px;
}
</style>
<link href="../css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<DIV class="title">미디어 그룹 수정</DIV>
	<FORM name='frm' method='POST' action='./update.do'>
		<input type="hidden" name="mediagroupno" value="${dto.mediagroupno}">
		<TABLE class='table'>
			<TR>
				<TH>미디어 그룹 제목</TH>
				<TD><input type='text' name='title' size='50'
					value='${dto.title}'></TD>
			</TR>
		</TABLE>

		<div class="content">
			<p>미디어 그룹을 수정하시겠습니까?</p>
		</div>

		<DIV class='bottom'>
			<input type='submit' value='수정'> 
			<input type='button' value='목록' onclick="window.location.href='./list.do'">
		</DIV>
	</FORM>
</body>
</html>
