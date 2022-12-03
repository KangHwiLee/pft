<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page session="true"%>

<c:forEach begin="${start }" end ="${end}" var="i" varStatus="status">
	<tr>
		<td>${i+1}</td>
		<td>${list[status.count-1].title }</td>
		<td>${list[status.count-1].category_name != null ? list[status.count-1].category_name : '카테고리없음'}</td>
	</tr> 
</c:forEach>