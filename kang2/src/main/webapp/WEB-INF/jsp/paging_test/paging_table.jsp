<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:forEach items="${list }" var="list">
    <tr>
												<td>${list.idx }</td>
												<td>${list.title }</td>
												<td>${list.contant }</td>
											</tr>
    </c:forEach>
											
