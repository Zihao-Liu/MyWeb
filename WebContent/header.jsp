<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<div id="topnavigation">
		<div id="logo">���Ӻ�</div>
		
		
		<div id="user">
			<c:choose>
				<c:when test="${empty sessionScope.user}">
					<form action="StatusRecognise" method="post">
						<span>
							<label for="name" >�û���:</label>
							<input name = "username" type ="text" id = "username" >
						</span>
					
						<span>
							<label for="name" >��    ��:</label>
							<input name = "userpassword" type = "password" id="password">
						</span>
						<input value = "�ύ" type = "submit">
						<input value="ע��" type = "button"  onclick = "window.location.href='register.jsp';">
					</form>
					<font color="red">${requestScope.error }</font>
				</c:when>
				<c:otherwise>
					<a href="">�û�����${user.userName}</a>
				</c:otherwise>
			</c:choose>
		</div>
		
		<div id="menu">
				<form action="" method="post" id="searchbar">
					<input name="searchText" type="text" placeholder ="���������Ȥ��ͼ��" id ="searchtext">
					<input value="����" type="submit">
				</form>
				<ul>
					<li class = "navigationbutton"><a href = "./index.jsp">��ҳ</a></li>
					<li class = "navigationbutton"><a href="">ͼ��</a></li>
				</ul>
		</div>
	
	</div>