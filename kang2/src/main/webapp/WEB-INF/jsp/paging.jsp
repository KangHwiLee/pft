<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/main.css" />
	<script src="resources/js/jquery-3.6.0.min.js" ></script>
	<script src="resources/js/common.js" ></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<style>
.pagination{display:block;padding-top:35px;text-align:center;clear: both;}
.pagination ul li{display:inline-block; vertical-align:top; margin:2px; padding:0;cursor:pointer}
.pagination ul li a{display:block;height:28px; border:1px solid #67738c; line-height:26px; font-size:14px; font-weight:400;color:#67738c;padding:0 5px}
.pagination ul li a.active{background:#67738c;color:#292d36;}
</style>
<body>

<div class="wrap">
		<div class="left">
			
		</div>
<div class="right">

<div class="right_wrap">
				<h2>강휘 포트폴리오</h2>
				<h1>paging study</h1>
			</div>
			
			<div style="display:flex; margin-top:30px;">
		<div class="table-responsive" style="width:33%; padding-left:50px; padding-right:20px;">
			<table class="table table-striped table-sm">
				<thead>
					<tr>
						<th>No.</th>
						<th>제목</th>
						<th>카테고리</th>
					</tr>
				</thead>
				<tbody id="paging_table">
					<tr>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</tbody>
			</table>
			<div class="pagination" id="pagination_1">
			
			</div>
			</div>
		<div class="table-responsive" style="width:33%; padding-left:50px; padding-right:20px;">
			<table class="table table-striped table-sm">
				<thead>
					<tr>
						<th>No.</th>
						<th>제목</th>
						<th>카테고리</th>
					</tr>
				</thead>
				<tbody id="paging_table_2">
					<tr>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</tbody>
			</table>
			<div class="pagination" id="pagination_2">
			
			</div>
			</div>
		<div class="table-responsive" style="width:33%; padding-left:50px; padding-right:20px;">
			<table class="table table-striped table-sm">
				<thead>
					<tr>
						<th>No.</th>
						<th>제목</th>
						<th>카테고리</th>
					</tr>
				</thead>
				<tbody id="paging_table_3">
					<tr>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</tbody>
			</table>
			<div class="pagination" id="pagination_3">
			
			</div>
			</div>
			
		</div>
    </div>
    </div>
</body>
<script>
$(document).ready(function(){
	paging_1(1);
	paging_2(1);
	paging_3(1);
})
</script>
</html>