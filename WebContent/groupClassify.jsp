<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%@page import="factory.UserDaoFactory" language="java"%>
<%@page import="factory.GroupDaoFactory" language="java"%>
<%@page import="dao.GroupDao" language="java"%>
<%@page import="dao.UserDao" language="java"%>
<%@page import="bean.Group" language="java"%>
<%@page import="bean.User" language="java"%>
<%@page import="java.net.URLEncoder" language="java" %>
 <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link href="css/header.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/grouppage.css" type="text/css" rel="stylesheet" media="all" />
<link href="css/footer.css" type="text/css" rel="stylesheet" media="all" />
<title>${group.groupType}</title>
</head>
<body>
	<%@include file = "header.jsp"%> 
	
	
	<div class="content">
		<%@include file = "groupSideBar.jsp"%>
	
	
		<div class="classmain">
			<c:choose>
				<c:when test="${empty requestScope.groupClassify}" >
					<h1>该分类还没有小组</h1>	
				</c:when>
				<c:otherwise>
					<c:forEach items="${requestScope.groupClassify}" var="group">
						<li id="groupclassify">
							<div class = "detail">小组名:<a href = "ShowGroup?groupID=${group.groupID }">${group.groupName }</a></div>
							<div class = "detail">帖子数:${group.groupPostNum }</div>
							<div class = "detail">加入人数:${group.groupUserNum }</div>
						</li>	
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</div>
		
	</div>
	
	<%@include file = "footer.jsp"%>
</body>
</html>