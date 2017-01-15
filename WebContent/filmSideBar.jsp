<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="sidebar">
			<div class="sort">
				<h2>分类</h2>
				<ul>
					<li><a href="GroupClassify?groupType=<%=URLEncoder.encode("电影", "utf-8") %>">电影</a></li>
					<li><a href="GroupClassify?groupType=<%=URLEncoder.encode("美食", "utf-8") %>">美食</a></li>
					<li><a href="GroupClassify?groupType=<%=URLEncoder.encode("旅行", "utf-8") %>">旅行</a></li>
					<li><a href="GroupClassify?groupType=<%=URLEncoder.encode("读书", "utf-8") %>">读书</a></li>
				</ul>
				<ul>
					<li><a href="GroupClassify?groupType=<%=URLEncoder.encode("历史", "utf-8") %>">历史</a></li>
					<li><a href="GroupClassify?groupType=<%=URLEncoder.encode("游戏", "utf-8") %>">游戏</a></li>
				</ul>	
			</div>
			
			<div class="rank">
				<h2>观看排名</h2>
				<ul>
					<%
						UserDao userDao = UserDaoFactory.getUserDaoInstance();
						List<User> users = userDao.findAlluserOrderByWatch();
						int i =0;
						for(User user:users){
					%>
							<li class = "userApprove">
								<div><a href = "ShowUser?userID=<%=user.getUserID()%>"><%=user.getUserName() %></a>:<%=user.getUserWatch() %>部</div>
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
						FilmCommentDao filmCommentDao = FilmCommentDaoFactory.getCommentDaoInstance();
						List<FilmComment> filmComments = filmCommentDao.findCommentOrderByApprove();
						i = 0;
						for(FilmComment filmComment:filmComments){
					%> 
							<li class = "comment">
								<div><%=filmComment.getCommentTitle() %></div>
								<div><a href = "ShowFilm?filmID=<%=filmComment.getFilmID()%>"><%=filmComment.getCommentContent() %></a></div>
								<div>点赞数:<%=filmComment.getCommentApprove() %></div>
							</li>
					<%if(i==4)
						break;
						i++;
					} %>
				</ul>
			</div>
		</div>