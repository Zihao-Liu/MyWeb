<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="sidebar">
			<div class="sort">
				<h2>����</h2>
				<ul>
					<li><a href="GroupClassify?groupType=<%=URLEncoder.encode("��Ӱ", "utf-8") %>">��Ӱ</a></li>
					<li><a href="GroupClassify?groupType=<%=URLEncoder.encode("��ʳ", "utf-8") %>">��ʳ</a></li>
					<li><a href="GroupClassify?groupType=<%=URLEncoder.encode("����", "utf-8") %>">����</a></li>
					<li><a href="GroupClassify?groupType=<%=URLEncoder.encode("����", "utf-8") %>">����</a></li>
				</ul>
				<ul>
					<li><a href="GroupClassify?groupType=<%=URLEncoder.encode("��ʷ", "utf-8") %>">��ʷ</a></li>
					<li><a href="GroupClassify?groupType=<%=URLEncoder.encode("��Ϸ", "utf-8") %>">��Ϸ</a></li>
				</ul>	
			</div>
			
		
			<div class="hotcomment">
				<h2>���ܻ�ӭС��</h2>
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
								<div>����:<%=group.getGroupUserNum() %></div>
							</li>
					<%if(i==4)
						break;
						i++;
					} %>
				</ul>
			</div>
		</div>
		</div>