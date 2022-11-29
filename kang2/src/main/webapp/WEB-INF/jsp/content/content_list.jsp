<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:forEach items="${list }" var="vo">
				<div class="contant">
					<div class="menu">
						<a>
						<img style="background-color:black;">
						<h2>${vo.title }</h2><br>
						<span>${vo.content }</span>
						</a>
					</div>
				</div>
	</c:forEach>