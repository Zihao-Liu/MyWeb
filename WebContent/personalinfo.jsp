<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="css/header.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/personalinfo.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/footer.css" type="text/css" rel="stylesheet" media="all" />

<script language="javascript">
function firm(statusID){
	if(confirm("��ȷ��Ҫɾ��������̬��")){
		location.href="DeleteStatus?statusID="+statusID; 
	}
	else{
		alert("ȡ��ɾ��");
	}
}

</script>
<title>�ҵ���Ϣ</title>
</head>
<body>
	<%@include file = "header.jsp"%> 
	<div id="mid">
		<div id = "userInfo">
			<h2><label>�û�����</label>${userNew.userName}</h2>
			<h2><label>���յ�����:</label>${userNew.userApprove}��</h2>
			<h2><label>�Ҷ�������:</label>${userNew.userRead }��</h2>
			<h2><label>�ҿ����ĵ�Ӱ:</label>${userNew.userWatch }��</h2>
		</div>
		<div class="booklist">
			<h2>�ҵ��鵥</h2>
			<c:forEach items="${requestScope.userreadbook}" var="userreadbook">
				<li class = "book">
					<div><img src="${userreadbook.bookCoverPath}"/></div>
					<div>����:<a href = "ShowBook?bookID=${userreadbook.bookID}">${userreadbook.bookName }</a></div>
					<div>����:${userreadbook.bookAuthor}</div>
				</li>
			</c:forEach>
		</div>
		<div class="filmlist">
			<h2>�ҵ�Ӱ��</h2>
			<c:forEach items="${requestScope.userwatchfilm}" var="userwatchfilm">
				<li class = "film">
					<div><img src="${userwatchfilm.filmCoverPath}"/></div>
					<div>Ƭ��:<a href = "">${userwatchfilm.filmName }</a></div>
					<div>����:${userwatchfilm.filmDirector}</div>
				</li>
			</c:forEach>
		</div>
		
		<div class="statuslist">
			<h2>�ҵĶ�̬</h2>
			<c:forEach items="${requestScope.userstatus}" var="userstatus">
				<li class = "status">
					<div>${userstatus.statusContent }</div>
					<div>${userstatus.publishTime}</div>
					<%--<a href = "DeleteStatus?statusID=${userstatus.statusID }">ɾ����̬</a> --%>
					<input type="submit" name="Submit2" value="ɾ����̬" onclick="firm(${userstatus.statusID })" />
				</li>
			</c:forEach>
		</div>
	</div>
	
	<%@include file = "footer.jsp"%>
</body>
</html>