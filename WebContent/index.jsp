<%@page import="factory.UserDaoFactory" language="java"%>
<%@page import="factory.BookCommentDaoFactory" language="java"%>
<%@page import="factory.StatusDaoFactory" language="java"%>
<%@page import="factory.FilmCommentDaoFactory" language="java"%>
<%@page import="dao.BookCommentDao" language="java"%>
<%@page import="dao.UserDao" language="java"%>
<%@page import="dao.StatusDao" language="java"%>
<%@page import="dao.FilmCommentDao" language="java"%>
<%@page import="bean.BookComment" language="java"%>
<%@page import="bean.User" language="java"%>
<%@page import="bean.Status" language="java"%>
<%@page import="bean.FilmComment" language="java"%>
<%@page import="java.net.URLEncoder" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="css/index.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/header.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/footer.css" type="text/css" rel="stylesheet" media="all" />
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<title>��ҳ</title>
</head>
<body>
	
	<%@include file = "header.jsp"%>
	<div id ="top">
		<form action="AddStatus" method="post">
			<textarea cols="80" rows="10" name="statusContent">����ʲô��˵��</textarea>
			<script type="text/javascript">CKEDITOR.replace( "statusContent",{
				width:950,height:60,
				toolbar :
				    [
						['Image','Link']
				    ]});</script>
				    <input type="submit" value="����">
		</form>
	</div>
	<div class="content">
		<div class="sidebar">
			<div class="sort">
				<h2>ͼ�����</h2>
				<ul>
					<li><a href="BookClassify?bookType=<%=URLEncoder.encode("С˵", "utf-8") %>">С˵</a></li>
					<li><a href="BookClassify?bookType=<%=URLEncoder.encode("Ϸ��", "utf-8") %>">Ϸ��</a></li>
					<li><a href="BookClassify?bookType=<%=URLEncoder.encode("ɢ��", "utf-8") %>">ɢ��</a></li>
					<li><a href="BookClassify?bookType=<%=URLEncoder.encode("����", "utf-8") %>">����</a></li>
				</ul>
				<ul>
					<li><a href="BookClassify?bookType=<%=URLEncoder.encode("��ʷ", "utf-8") %>">��ʷ</a></li>
					<li><a href="BookClassify?bookType=<%=URLEncoder.encode("��ѧ", "utf-8") %>">��ѧ</a></li>
				</ul>	
			</div>
			
			<div class="sort">
				<h2>��Ӱ����</h2>
				<ul>
					<li><a href="FilmClassify?filmType=<%=URLEncoder.encode("�ƻ�", "utf-8") %>">�ƻ�</a></li>
					<li><a href="FilmClassify?filmType=<%=URLEncoder.encode("����", "utf-8") %>">����</a></li>
					<li><a href="FilmClassify?filmType=<%=URLEncoder.encode("�ֲ�", "utf-8") %>">�ֲ�</a></li>
					<li><a href="FilmClassify?filmType=<%=URLEncoder.encode("����", "utf-8") %>">����</a></li>
				</ul>
				<ul>
					<li><a href="FilmClassify?filmType=<%=URLEncoder.encode("��ʷ", "utf-8") %>">��ʷ</a></li>
					<li><a href="FilmClassify?filmType=<%=URLEncoder.encode("����", "utf-8") %>">����</a></li>
				</ul>	
			</div>
			
			<div class="rank">
				<h2>�Ķ�����</h2>
				<ul>
					<%
						UserDao userDao = UserDaoFactory.getUserDaoInstance();
						List<User> users = userDao.findAlluserOrderByRead();
						int i =0;
						for(User user:users){
					%>
							<li class = "userApprove">
								<div><a href = "ShowUser?userID=<%=user.getUserID()%>"><%=user.getUserName() %></a>:<%=user.getUserRead() %>��</div>
							</li>
					<%if(i==9)
						break;
						i++;
					} %> 
				</ul>
			</div>
			
			<div class="rank">
				<h2>��Ӱ����</h2>
				<ul>
					<%
						users = userDao.findAlluserOrderByWatch();
						i =0;
						for(User user:users){
					%>
							<li class = "userApprove">
								<div><a href = "ShowUser?userID=<%=user.getUserID()%>"><%=user.getUserName() %></a>:<%=user.getUserWatch() %>��</div>
							</li>
					<%if(i==9)
						break;
						i++;
					} %> 
				</ul>
			</div>
			
			<div class="rank">
				<h2>��������</h2>
				<ul>
					<%
						users = userDao.findAllUserOrderByApprove();
						i=0;
						for(User user:users){
					%>
							<li class = "userApprove">
								<div><a href = "ShowUser?userID=<%=user.getUserID()%>"><%=user.getUserName() %></a>:<%=user.getUserApprove() %></div>
							</li>
					<%if(i==9)
						break;
						i++;
					} %>
				</ul>
			</div>
		
			<div class="hotcomment">
				<h2>ͼ����������</h2>
				<ul>
					<%
						BookCommentDao bookCommentDao = BookCommentDaoFactory.getCommentDaoInstance();
						List<BookComment> bookComments = bookCommentDao.findCommentOrderByApprove();
						i = 0;
						for(BookComment bookComment:bookComments){
					%> 
							<li class = "comment">
								<div><%=bookComment.getCommentTitle() %></div>
								<div><a href = "ShowBook?bookID=<%=bookComment.getBookID()%>"><%=bookComment.getCommentContent() %></a></div>
								<div>������:<%=bookComment.getCommentApprove() %></div>
							</li>
					<%if(i==4)
						break;
						i++;
					} %>
				</ul>
			</div>
			
			<div class="hotcomment">
				<h2>��Ӱ��������</h2>
				<ul>
					<%
						FilmCommentDao filmCommentDao = FilmCommentDaoFactory.getCommentDaoInstance();
						List<FilmComment> filmComments = filmCommentDao.findCommentOrderByApprove();
						i = 0;
						for(FilmComment filmComment:filmComments){
					%> 
							<li class = "comment">
								<div><%=filmComment.getCommentTitle() %></div>
								<div><a href = "ShowFilm?filmID=<%=filmComment.getFilmID()%>"><%=filmComment.getCommentContent() %></a></div>
								<div>������:<%=filmComment.getCommentApprove() %></div>
							</li>
					<%if(i==4)
						break;
						i++;
					} %>
				</ul>
			</div>
		</div>
	
	
		<div class="main">
			<div class="recommendbyscore">
				<h2>���¶�̬</h2>
				<ul>
					<%
						StatusDao statusDao= StatusDaoFactory.getStatusDaoInstance();
						List<Status> statuss = statusDao.findAllStatus();
						for(Status status:statuss){
					%> 
					<li class = "status">
						<div><%=status.getStatusContent()%></div>
						<div class="user">����:<a href = "ShowUser?userID=<%=status.getUserID()%>"><%=userDao.findUserByID(status.getUserID()).getUserName()%></a></div>
						<div><%=status.getPublishTime() %></div>
					</li>
					<%} %>
				</ul>
			</div>
		</div>
	</div>
	
	<%@include file = "footer.jsp"%>
</body>
</html>