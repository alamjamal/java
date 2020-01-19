
<head>
<script type="text/javascript" src=<%=request.getContextPath()+"/scripts/jquery.js" %>>
</script>
<script type="text/javascript">
$(document).ready(function () {
$('.menu li').hover(
function () {
//show its submenu
$('ul', this).slideDown(350);
},
function () {
//hide its submenu
$('ul', this).slideUp(350);
}
);
});
</script>

<link rel="stylesheet" href=<%=request.getContextPath()+"/CSS/menu_style1.css"%> type="text/css" />
</head>
<div class="menu">
<ul>
<li><a href=<%=request.getContextPath()+"/jsps/adminhome.jsp" %> target="_self" >HOME</a>
</li>
<li><a href="#" target="_self" >REGISTER</a>
<ul>
<li><a href=<%=request.getContextPath()+"/jsps/DepartmentRegisterform.jsp" %> target="_self">DEPARTMENT</a></li>
<li><a href=<%=request.getContextPath()+"/jsps/Registerform.jsp" %> target="_self">FACULTY</a></li>
</ul>
</li>
<li><a href="#" target="_self" >COURSE</a>
<ul>
<li><a href=<%=request.getContextPath()+"/jsps/addcourse.jsp" %> target="_self">ADD COURSE</a></li>
<li><a href=<%=request.getContextPath()+"/jsps/deletecourse.jsp" %> target="_self">VIEW/DELETECOURSE</a></li>
<li><a href=<%=request.getContextPath()+"/jsps/shedulecourse.jsp" %> target="_self">SHEDULE/ASSIGNCOURSE</a></li>
<li><a href=<%=request.getContextPath()+"/jsps/deleteshedule.jsp" %> target="_self">VIEW/DELETESHEDULE</a></li>
<li><a href=<%=request.getContextPath()+"/jsps/replyrequest.jsp" %> target="_self">VIEW/REPLYREQUEST</a></li>
</ul>
</li>
<li><a href="#" target="_self" >FACULTY</a>
<ul>
<li><a href=<%=request.getContextPath()+"/jsps/deleteassignment.jsp" %> target="_self">VIEWASSIGNMENT</a></li>
<li><a href=<%=request.getContextPath()+"/jsps/assigncourse.jsp" %> target="_self">UPDATEASSIGNMENT</a></li>
</ul>
</li>
<li><a href="#" target="_self" >USER</a>
<ul>
<li><a href=<%=request.getContextPath()+"/jsps/viewuser.jsp" %> target="_self" >VIEWUSERS</a></li>
<li><a href=<%=request.getContextPath()+"/jsps/userlog.jsp" %> target="_self" >LOGIN DETAILS</a></li>
</ul>
</li>
<li><a href="#" target="_self" >ACCOUNT</a>
<ul>
<li><a href=<%=request.getContextPath()+"/jsps/inbox.jsp" %> target="_self" >INBOX</a></li>
<li><a href=<%=request.getContextPath()+"/jsps/sendmail.jsp" %> target="_self" >SENDMAIL</a></li>
<li><a href=<%=request.getContextPath()+"/jsps/ChangePassword.jsp" %> target="_self" >CHANGEPASS</a></li>
<li><a href=<%=request.getContextPath()+"/logoutaction" %> target="_self" >LOGOUT</a></li>
</ul>
</ul>
</div>
