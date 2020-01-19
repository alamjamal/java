<%@page import="java.sql.ResultSet"%>
<%@page import="com.sl.db.DBConn"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.book.alam.NewBookDAO"%>
<%@page import="com.book.alam.NewBookPOJO"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String isbn13 = request.getParameter("isbn13");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="XX-Style.jsp"%>
<style type="text/css">
.s {
	margin-top: 90px;
}
.middle {
	height: auto;
	background-color: #FAF7F7;
	color: black;
}
.old-book-info {
	display: inline;
	padding-top: 20px;
	float: left;
	width: 100%;
}
.img-info {
	display: block;
	width: 20%;
	float: left;
}
.img-info img {
	padding-left: 60px;
}
.text-info {
	width: 80%;
	float: left;
	display: block;
	line-height: 40px;
}
.table-price{
display:inline-block;
margin-left:20%;
margin-top:5%;
}
.table h1,.table h2,.table h3,.table h4{
color: black;
}
.table  {
	 border-collapse: collapse;
    text-align: center;
}
.table table, .table tr, .table td ,.table th{
	width: 200px;
	text-align: left;
	border-collapse: collapse;
	padding: 10px;
	
	
}
.table  tr:nth-child(even) {
	background-color: #eee;
}
.table  tr:nth-child(odd) {
	background-color: #fff;
}
.table th {
    background-color: #4CAF50;
    color: white;
}
.buy-button {
	width: 100px;
	cursor: pointer;
	text-align: center;
	border-radius: 6px;
	font-weight: bold;
	background-color: navy;
	color: black;
	border: 2px solid #4CAF50;
	padding: 5px 10px;
	-webkit-transition-duration: 0.4s; /* Safari */
	transition-duration: 0.4s;
	margin-top: 20px;
}
.buy-button a{
color: black;
}
.buy-button:hover {
	background-color: #008CBA;
	color: white;
}
.description{
display: block;
width: 88%;
text-align: justify;
margin-left: 30px;
margin-top: 30px;
padding-left:30px;
padding-bottom: 30px
}
</style>
</head>
<body onload="bookSearch()">
	<%@include file="XX-Header.jsp"%>
	<div class="middle">
		<div class="path"
			style="color: white; text-align: center; font-weight: bold;">
			${msg }</div>
		<div class="old-book-info">
			<div class="img-info">
				<img alt="" src="" id="img">
			</div>
			<div class="text-info">
				<h2 id="title" style="color:black;"></h2>
				<h3  id="author" style="color:black;"></h3>
				<h4 id="publisher"style="color:black;"></h4>
				<%!int price=0; %>
				<%
				Connection con=null;
				PreparedStatement ps=null;
				ResultSet rs=null;
				try{
					con=DBConn.getConnection();
					ps=con.prepareStatement("select price from book_new where ISBN13=?");
					ps.setString(1, isbn13);
					 rs = ps.executeQuery();
					while(rs.next()){
						price=rs.getInt("price");
					}
				}catch(Exception e){
					e.printStackTrace();
				}
				con.close();
				%>
				
				<%if(price>0){%>
					<h2 style="color:black;">Price: <%=price%>&#8377;</h2>
					<a class="buy-button" href="CartController?action=addtocart&isbn13=<%=isbn13%>">
					Buy Now</a> <a class="buy-button" href="C-Cart.jsp"> CheckOut</a>
					
				<%}else{%>
					<h3 style="color:black;">Price: N/A in our store try below stores</h3>
				
				<%}
					
				%>
				
				
			</div>
		</div>
		<div class="table-price">
		<h2 style="color:black;text-align: center;">Buy Form Other Online Stores</h2>
		<table class="table">
			<thead>
				<tr class="info">
					<th>Store Name</th>
					<th>Price</th>
					<th>URL</th>
				</tr>
			</thead>
			<tbody id="price-list">
				<!-- Data will be appended here -->
			</tbody>
		</table>
		</div>
		<div class="description">
		<h3 style="color:black;"> Other Information</h3>
		<table style="width: 100%; font-weight: bold;">
		<tr><td>ISBN</td>
		<td id="isbn"></td>
		</tr>
		<tr><td>ISBN 13</td>
		<td id="isbn13"></td>
		</tr>
		<tr><td>PUBLISHED DATE</td>
		<td id="published_date"></td>
		</tr>
		<tr><td>CATEGORY</td>
		<td id="category"></td>
		</tr>
		<tr><td>PAGE COUNT</td>
		<td id="page_count"></td>
		</tr>
		</table>
		
		 
  <h3 style="color:black;">Description</h3>
 <p id="description" style="font-size: 20px"></p>

		
		</div>
	</div>
	<%@include file="XX-Footer.jsp"%>
	<script src="js/book/jq.js"></script>
	<script type="text/javascript">
		var itemTemplate = '<tr><td class="store"><strong>{{storename}}</strong></td><td class="price">Rs. {{price}}</td><td class="uri"><a class="buy-button" target="_blank" href="{{uri}}">Go to Store</a></td></tr>';
		var collection = '';
		function OnSuccess(data) {
			// do something with the data
			var element = '';
			for (i = 0; i < data.count; i++) {
				element = itemTemplate.replace(/{{storename}}/g,data.data[i].Seller_Name);
				element = element.replace(/{{price}}/g, data.data[i].Best_Price);
				element = element.replace(/{{uri}}/g, data.data[i].Uri);
				collection += element;
			}
			$('#price-list').html(collection);
		}
		$.ajax({
					type : "GET",
					url : "http://www.pricetree.com/dev/api.ashx?isbn="+<%=isbn13%>+"&apikey=7770AD31-382F-4D32-8C36-3743C0271699&v=1",
					dataType : "json",
					success : OnSuccess
				});
	</script>
	<script type="text/javascript">
		function bookSearch() {
			$.ajax({
				url : "https://www.googleapis.com/books/v1/volumes?q="+<%=isbn13%>+"&key=AIzaSyBPH5NGEgI6LUJT9xGB7ZcQ1axNgSW4f54",
				dataType : "json",
				type : 'GET',
				// on success, do this
				success : function(data) {
					console.log(data)
					// loop through data in data.items
					for (var i = 0; i < 1; i++) {
						// store current DATA info 
						var jdata = data.items[i].volumeInfo
						//store data to var
						var title = jdata.title
						if(jdata.authors){
							var author = jdata.authors[0]
						}
							var publisher = jdata.publisher
						if(jdata.publishedDate){
							var published_date = jdata.publishedDate
						}
						if(jdata.categories){
							var category = jdata.categories[0]
						}
						var isbn = jdata.industryIdentifiers[0].identifier
						var isbn13 = jdata.industryIdentifiers[1].identifier
						var imageapipath = jdata.imageLinks.thumbnail
						var description = jdata.description
						var pagecount = jdata.pageCount
						//print data to text boxes
						var temp
						if(isbn.length==13){
							temp=isbn13
			   				isbn13=isbn 
			   				isbn=temp
			   			}
						document.getElementById('img').src = imageapipath
						document.getElementById('title').innerText =title
						document.getElementById('author').innerText ="BY :  "+author
						document.getElementById('publisher').innerText ="PUBLISHER :  "+publisher
						document.getElementById('isbn').innerText =isbn
						document.getElementById('isbn13').innerText =isbn13
						document.getElementById('category').innerText =category
						document.getElementById('published_date').innerText =published_date
						document.getElementById('page_count').innerText =pagecount
						document.getElementById('description').innerText =description
					}
				}
			})
		}
		addEventListener('load', bookSearch, true)
		addEventListener('load', OnSuccess, true)
	</script>
	
</body>
</html>