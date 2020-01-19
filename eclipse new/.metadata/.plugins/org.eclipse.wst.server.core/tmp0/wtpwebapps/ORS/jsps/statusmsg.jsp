<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${requestScope.status ne null}">
	<center><strong><font color="red"><c:out value="${requestScope.status}"></c:out> </font></strong></center>
</c:if>