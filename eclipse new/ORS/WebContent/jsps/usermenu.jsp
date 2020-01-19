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
<li><a href=<%=request.getContextPath()+"/jsps/userhome.jsp" %> target="_self" >HOME</a>
</li>
<li><a href=<%=request.getContextPath()+"/jsps/viewassignment.jsp" %> target="_self" >ASSIGNMENT</a>
</li>
<li><a href=<%=request.getContextPath()+"/jsps/viewshedule.jsp" %> target="_self" >COURSE SHEDULE</a>
</li>
<li><a href="#" target="_self" >MAIL</a>
<ul>
<li><a href=<%=request.getContextPath()+"/jsps/inbox.jsp" %> target="_self" >INBOX</a></li>
<li><a href=<%=request.getContextPath()+"/jsps/sendmail.jsp" %> target="_self" >SENDMAIL</a></li>
</ul>
</li>
<li><a href="#" target="_self" >ACCOUNT</a>
<ul>
<li><a href=<%=request.getContextPath()+"/jsps/ChangePassword.jsp" %> target="_self" >CHANGEPASS</a></li>
<li><a href=<%=request.getContextPath()+"/logoutaction" %> target="_self" >LOGOUT</a></li>
</ul>
</ul>
</div>