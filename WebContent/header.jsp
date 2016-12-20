<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<div id="topnavigation">
		<div id="logo">刘子豪</div>
		
		
		<div id="user">
			<c:choose>
				<c:when test="${empty sessionScope.user}">
					<form action="StatusRecognise" method="post">
						<span>
							<label for="name" >用户名:</label>
							<input name = "username" type ="text" id = "username" >
						</span>
					
						<span>
							<label for="name" >密    码:</label>
							<input name = "userpassword" type = "password" id="password">
						</span>
						<input value = "提交" type = "submit">
						<input value="注册" type = "button"  onclick = "window.location.href='register.jsp';">
					</form>
					<font color="red">${requestScope.error }</font>
				</c:when>
				<c:otherwise>
					<a href="">用户名：${user.userName}</a>
				</c:otherwise>
			</c:choose>
		</div>
		
		<div id="menu">
				<form action="" method="post" id="searchbar">
					<input name="searchText" type="text" placeholder ="搜索你感兴趣的图书" id ="searchtext">
					<input value="搜索" type="submit">
				</form>
				<ul>
					<li class = "navigationbutton"><a href = "./index.jsp">首页</a></li>
					<li class = "navigationbutton"><a href="">图书</a></li>
				</ul>
		</div>
	
	</div>