<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="css/header.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/searchresult.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/footer.css" type="text/css" rel="stylesheet" media="all" />

<title>�������</title>
</head>
<body>
	<%@include file = "header.jsp"%>
	<c:choose>
		<c:when test="${empty requestScope.booksearch}">
			<h2 class = "bookflag">�Ҳ�����Ҫ��ͼ��</h2>
		</c:when>
		<c:otherwise>
			<h2 class = "bookflag">ͼ�����������</h2>
			<div class = "bookInfo">
				<h2><a href ="ShowBook?bookID=${booksearch.bookID}">${booksearch.bookName}</a></h2>
				<div class="Infodisplay" >
					<a href ="ShowBook?bookID=${booksearch.bookID}"><img src="${booksearch.bookCoverPath }"></a>
					<ul>
						<li>����:${booksearch.bookAuthor}</li>
						<li>����:${booksearch.bookType}</li>
						<li>�Ķ�����:${booksearch.bookRead }</li>
						<li>����:${booksearch.bookScore }</li>
					</ul>
				</div>
				<h2 class="briefh2">���ݼ��:</h2>
				<p class="brief">${booksearch.bookInfo}</p>
			</div>
		</c:otherwise>
	</c:choose>
	
	<c:choose>
		<c:when test="${empty requestScope.filmsearch}">
			<h2 class = "filmflag">�Ҳ�����Ҫ�ĵ�Ӱ</h2>
		</c:when>
		<c:otherwise>
			<h2 class = "filmflag">��Ӱ���������</h2>
			<div class = "filmInfo">
				<h2><a href ="ShowFilm?filmID=${filmsearch.filmID}">${filmsearch.filmName}</a></h2>
				<div class="Infodisplay" >
					<a href ="ShowFilm?filmID=${filmsearch.filmID}"><img src="${filmsearch.filmCoverPath }"></a>
					<ul>
						<li>����:${filmsearch.filmDirector}</li>
						<li>����:${filmsearch.filmType}</li>
						<li>�Ķ�����:${filmsearch.filmWatch }</li>
						<li>����:${filmsearch.filmScore }</li>
					</ul>
				</div>
				<h2 class="briefh2">���ݼ��:</h2>
				<p class="brief">${filmsearch.filmInfo}</p>
			</div>
		</c:otherwise>
	</c:choose>
	
	
	<c:choose>
		<c:when test="${empty requestScope.groupsearch}">
			<h2 class = "groupflag">�Ҳ�����Ҫ��С��</h2>
		</c:when>
		<c:otherwise>
			<h2 class = "groupflag">С�����������</h2>
			<div class = "groupInfo">
				<ul>
					<li>С����:<a href = "ShowGroup?groupID=${groupsearch.groupID }">${groupsearch.groupName }</a></li>
					<li>����:${groupsearch.groupType }</li>
					<li>������:${groupsearch.groupPostNum }</li>
					<li>��������:${groupsearch.groupUserNum }</li>
				</ul>
			
				<h2 class="briefh2">���ݼ��:</h2>
				<p class="brief">${groupsearch.groupInfo}</p>
			</div>
		</c:otherwise>
	</c:choose>
	
	
	<c:choose>
		<c:when test="${empty requestScope.usersearch}">
			<h2 class = "userflag">�Ҳ�����Ҫ���û�</h2>
		</c:when>
		<c:otherwise>
			<h2 class = "userflag">�û����������</h2>
			<div id = "userInfo">
				<h2><a href="ShowUser?userID=${usersearch.userID }"><label>�û�����</label>${usersearch.userName}</a></h2>
				<h2><label>�յ�����:</label>${usersearch.userApprove}</h2>
				<h2><label>������ͼ��:</label>${usersearch.userRead }</h2>
				<h2><label>�����ĵ�Ӱ:</label>${usersearch.userWatch }</h2>
			</div>		
		</c:otherwise>
	</c:choose>
	
	<%@include file = "footer.jsp"%>
</body>
</html>