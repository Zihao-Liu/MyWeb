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
						<input value = "��¼" type = "submit">
						<input value="ע��" type = "button"  onclick = "window.location.href='register.jsp';">
					</form>
					<font color="red">${requestScope.error }</font>
				</c:when>
				<c:otherwise>
					<select onchange="window.location=this.value;">
  						<option value = "PersonalInfo">�û�����${user.userName}</option>
  						<option value ="PersonalInfo" >������ҳ</option>
  						<option value="LogOff" >�˳�</option>
					</select>
				</c:otherwise>
			</c:choose>
		</div>
		
		<div id="menu">
				<form action="Search" method="post" id="searchbar">
					<input name="searchText" type="text" placeholder ="���������Ȥ��ͼ����û�����" id ="searchtext">
					<input value="����" type="submit">
				</form>
				<ul>
					<li class = "navigationbutton"><a href = "./index.jsp">��ҳ</a></li>
					<li class = "navigationbutton"><a href="./bookPage.jsp">ͼ��</a></li>
					<li class = "navigationbutton"><a href="./filmPage.jsp">��Ӱ</a></li>
				</ul>
		</div>
	
	</div>