<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="sidebar">
			<div class="sort">
				<h2>����</h2>
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
				<h2>�ۿ�����</h2>
				<ul>
					<%
						UserDao userDao = UserDaoFactory.getUserDaoInstance();
						List<User> users = userDao.findAlluserOrderByWatch();
						int i =0;
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
				<h2>��������</h2>
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