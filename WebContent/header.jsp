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
						<input value = "登录" type = "submit">
						<input value="注册" type = "button"  onclick = "window.location.href='register.jsp';">
					</form>
					<font color="red">${requestScope.error }</font>
				</c:when>
				<c:otherwise>
					<select onchange="window.location=this.value;">
  						<option value = "PersonalInfo">用户名：${user.userName}</option>
  						<option value ="PersonalInfo" >个人主页</option>
  						<option value="LogOff" >退出</option>
					</select>
				</c:otherwise>
			</c:choose>
		</div>
		
		<div id="menu">
				<form action="Search" method="post" id="searchbar">
					<input name="searchText" type="text" placeholder ="搜索你感兴趣的图书或用户名称" id ="searchtext">
					<input value="搜索" type="submit">
				</form>
				<ul>
					<li class = "navigationbutton"><a href = "./index.jsp">首页</a></li>
					<li class = "navigationbutton"><a href="./bookPage.jsp">图书</a></li>
					<li class = "navigationbutton"><a href="./filmPage.jsp">电影</a></li>
				</ul>
		</div>
	
	</div>