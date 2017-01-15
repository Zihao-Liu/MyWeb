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
<title>С��</title>
</head>
<body>
	<%@include file = "header.jsp"%> 
	<div class="content">
		<%@include file = "groupSideBar.jsp"%> 
	
	
		<div class="main">
			<div class="recommendbyhot">
				<h2>���ܹ�ע</h2>
				<ul>
					<%
						groups = groupDao.findAllGroupOrderByUserNum(); 
						i=0;
						for(Group group:groups){
					%>
							<li class = "group">
								<div >С����:<a href = "ShowGroup?groupID=<%=group.getGroupID()%>"><%=group.getGroupName()%></a></div>
								<div >����:<%=group.getGroupType()%></div>
								<div >��������:<%=group.getGroupUserNum()%></div>
							</li>
					<%if(i==4)
						break;
						i++;
					} %>
				</ul>
				<a href = "./showAllGroup.jsp">��ʾ����>></a>
			</div>
		
			<div class="recommendbyscore">
				<h2>�������</h2>
				<ul>
					<%
						groups = groupDao.findAllGroupOrderByPostNum();
						i=0;
						for(Group group:groups){
					%>
							<li class = "group">
								<div >С����:<a href = "ShowGroup?groupID=<%=group.getGroupID()%>"><%=group.getGroupName()%></a></div>
								<div >����:<%=group.getGroupType()%></div>
								<div >���Ӹ���:<%=group.getGroupPostNum()%></div>
							</li>
					<%if(i==4)
						break;
						i++;
					} %>
				</ul>
				<a href = "./showAllGroup.jsp">��ʾ����>></a>
			</div>
		</div>
	</div>
	
	<%@include file = "footer.jsp"%>
</body>
</html>