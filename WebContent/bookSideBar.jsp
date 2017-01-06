<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="sidebar">
			<div class="sort">
				<h2>����</h2>
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
		</div>