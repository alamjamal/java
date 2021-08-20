<%@page import="com.book.category.CategoryPOJO"%>
<%@page import="com.book.cart.CartDAO"%>
<%@page import="com.book.cart.CartPOJO"%>
<%@page import="com.book.old.OldBookDAO"%>
<%@page import="com.book.old.OldBookPOJO"%>
<%@page import="com.sl.db.DBConn"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%String email=(String)request.getSession().getAttribute("email");
	if(email==null){
		request.getRequestDispatcher("index.jsp").forward(request, response);
	} %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<%@include file="XX-Style.jsp"%>
<style type="text/css">
.s{
margin-top: 90px;
}
.middle{
height:auto;
}
.cart-info{
color: black;
margin-top: 20px;
}
.cart-info table {
    border-collapse: collapse;
    width: 100%;
    text-align: center;
}

.cart-info th,.cart-info td {
    text-align: left;
    padding: 8px;
}

.cart-info tr:nth-child(even){
background-color: #f2f2f2;
}

.cart-info th {
    background-color: #4CAF50;
    color: white;
}
.grand-total{
width: 100%;
height: 15vh;
background-color: cyan;
margin-bottom: 20px;
}
</style>
</head>
<body>
	<%@include file="XX-Header.jsp"%>
	<div class="middle">
		<div class="path">
			<!-- <marquee style="color: white;">Latest Offers : Buy Computer
				Science Book At Great Discount</marquee> -->
				
		</div>
		<div class="cart-info">
		<%! int total=0; %>
		<%
		CartDAO dao = new CartDAO();
		
		List<CartPOJO> list = dao.getCartInfoByEmail(email);
		for(CartPOJO cp : list){%>
			<table class="myborder">
			<thead>
			<tr>
			<th></th>
			<th>Title</th>
			<th>ISBN</th>
			<th>Price</th>
			<th>QTY</th>
			<th>Total</th>
			<th>Remove</th>
			</tr>
			</thead>
			<tbody>
			<tr><td><img alt="" src="<%=cp.getIMAGEAPIPATH()%>"></td>
			<td><%=cp.getTITLE() %></td>
			<td><%=cp.getISBN13() %></td>
			<td><input type="text" id="price" readonly="readonly" value="<%=cp.getPRICE()%>"> </td>
			<td><input type="text" id="qty" value="<%=cp.getQty()%>"> </td>
			<td id="result"> </td>
			<td><a href="CartController?action=delete&isbn13=<%=cp.getISBN13()%>"><img alt=""src="img/delete.png"></a> </td>
			</tr>
			
			</tbody>
			
			</table>
		
		<%}		
		%>
		
		</div>
		<div class="grand-total">
		
		</div>
		
	</div>
	<%@include file="XX-Footer.jsp"%>
	
<script src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    $('#qty').keyup(function(event) {
    	  var price=$('#price').val();
    	  var qty = $('#qty').val();
    	  $.ajax({
    		 type : 'POST',
    		 data : {
    			price : price,
    			qty : qty,
    			action : 'ajax'
    		 },
    		 url : 'CartController',
    		 success :function(total){
    			 $('#result').html(total);
    			 
    		 }
    	  });
            
    });
});


</script>
</body>
</html>