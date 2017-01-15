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
			
		
			<div class="hotcomment">
				<h2>最受欢迎小组</h2>
				<ul>
					<%
						GroupDao groupDao = GroupDaoFactory.getGroupDaoInstance();
						List<Group> groups = groupDao.findAllGroupOrderByUserNum();
						int i = 0;
						for(Group group:groups){
					%> 
							<li class = "comment">
								<div><a href = "ShowGroup?groupID=<%=group.getGroupID()%>"><%=group.getGroupName() %></a></div>
								<div><%=group.getGroupType() %></div>
								<div>人数:<%=group.getGroupUserNum() %></div>
							</li>
					<%if(i==4)
						break;
						i++;
					} %>
				</ul>
			</div>
		</div>
		</div>