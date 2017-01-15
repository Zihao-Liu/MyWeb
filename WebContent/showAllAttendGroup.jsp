<%@page import="factory.UserDaoFactory" language="java"%>
<%@page import="factory.GroupDaoFactory" language="java"%>
<%@page import="dao.UserDao" language="java"%>
<%@page import="dao.GroupDao" language="java"%>
<%@page import="bean.User" language="java"%>
<%@page import="bean.Group" language="java"%>
<%@page import="java.net.URLEncoder" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="css/grouppage.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/header.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/footer.css" type="text/css" rel="stylesheet" media="all" />
<title>所有图书</title>
</head>
<body>
	<%@include file = "header.jsp"%> 
	<div class="content">
		<%@include file = "groupSideBar.jsp"%>
	
	
		<div class="main">
			<div class="allgroup">
				<h2>小组列表</h2>
				<ul>
					<%
						groups = groupDao.findAllGroup(); 
						for(Group group:groups){
					%>
							<li class = "group">
								<div >小组名:<a href = "ShowGroup?groupID=<%=group.getGroupID()%>"><%=group.getGroupName()%></a></div>
								<div >分类:<%=group.getGroupType()%></div>
								<div >加入人数:<%=group.getGroupUserNum()%></div>
								<div >帖子个数:<%=group.getGroupPostNum()%></div>
							</li>
					<%} %> 
				</ul>
			</div>
			
		</div>
	</div>
	
	<%@include file = "footer.jsp"%>
</body>
</html>