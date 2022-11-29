<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
<link rel="stylesheet" href="resources/css/main.css" />
	<script src="resources/js/jquery-3.6.0.min.js" ></script>
	<script src="resources/js/common.js" ></script>
<title>board</title>


<!-- <script>
	$(document).on('click', '#btnSave', function(e){
		e.preventDefault();
		$("#form").submit();
	});
	$(document).on('click', '#btnList', function(e){
		e.preventDefault();
		location.href="${pageContext.request.contextPath}/board/getBoardList";
	});
</script> -->


</head>
<body>

<div class="wrap">
		<div class="left">
			
		</div>
		<div class="right">
			<div class="right_wrap">
				<h2>강휘 포트폴리오</h2>
				<h1>글쓰기</h1>
			</div>
			<div class="contant_list">
			<article>
		<div class="container" role="main" style="margin-left:58px;">
			<form name="form" id="content_form" role="form" method="post" action="/content_form.do">
				<div class="mb-3">
					<label for="title">카테고리</label>
					<select name="category">
						<option value="0">카테고리 없음</option>
						<option value="1">java</option>
						<option value="2">mysql</option>
						<option value="3">javascript</option>
						<option value="4">linux</option>
					</select>
				</div>
				<div class="mb-3">
					<label for="title">제목</label>
					<input type="text" class="form-control" name="title" id="title" placeholder="제목을 입력해 주세요">
				</div>
				<div class="mb-3">
					<label for="content">내용</label>
					<textarea class="form-control" rows="5" name="content" id="content" placeholder="내용을 입력해 주세요" style="min-height:500px"></textarea>
				</div>
				<div class="mb-3">
					<label for="tag">TAG</label>
					<input type="text" class="form-control" name="tag" id="tag" placeholder="태그를 입력해 주세요">
				</div>
			</form>
			<div >
				<button type="submit" class="btn btn-sm btn-primary" id="btnSave" form="content_form">저장</button>
				<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
			</div>
		</div>
	</article>
			</div>
</div>
</div>


	
</body>
</html>