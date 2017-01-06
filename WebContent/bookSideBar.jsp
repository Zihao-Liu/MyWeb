<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="sidebar">
			<div class="sort">
				<h2>分类</h2>
				<ul>
					<li><a href="BookClassify?bookType=<%=URLEncoder.encode("小说", "utf-8") %>">小说</a></li>
					<li><a href="BookClassify?bookType=<%=URLEncoder.encode("戏剧", "utf-8") %>">戏剧</a></li>
					<li><a href="BookClassify?bookType=<%=URLEncoder.encode("散文", "utf-8") %>">散文</a></li>
					<li><a href="BookClassify?bookType=<%=URLEncoder.encode("漫画", "utf-8") %>">漫画</a></li>
				</ul>
				<ul>
					<li><a href="BookClassify?bookType=<%=URLEncoder.encode("历史", "utf-8") %>">历史</a></li>
					<li><a href="BookClassify?bookType=<%=URLEncoder.encode("哲学", "utf-8") %>">哲学</a></li>
				</ul>	
			</div>
			
			<div class="rank">
				<h2>阅读排名</h2>
				<ul>
					<%
						UserDao userDao = UserDaoFactory.getUserDaoInstance();
						List<User> users = userDao.findAlluserOrderByRead();
						int i =0;
						for(User user:users){
					%>
							<li class = "userApprove">
								<div><a href = "ShowUser?userID=<%=user.getUserID()%>"><%=user.getUserName() %></a>:<%=user.getUserRead() %>本</div>
							</li>
					<%if(i==9)
						break;
						i++;
					} %> 
				</ul>
			</div>
			
			<div class="rank">
				<h2>点赞排名</h2>
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
				<h2>热门评论</h2>
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
								<div>点赞数:<%=bookComment.getCommentApprove() %></div>
							</li>
					<%if(i==4)
						break;
						i++;
					} %>
				</ul>
			</div>
		</div>