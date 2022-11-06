<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<ul>
                                <li><a onclick="paging_status(0)" class="first">첫페이지</a></li>
                                <li><a onclick="paging_status(1)" class="prev">이전페이지</a></li>
                            <c:forEach var="i" begin="${start}" end="${end}">
                                <li><a onclick="paging_list_load(${i-1})" id="equip_list_${i-1 }">${i }</a></li>
                            </c:forEach>
                                <li><a onclick="paging_status(2)" class="next">다음페이지</a></li>
                                <li><a onclick="paging_status(3)" class="last">끝페이지</a></li>
                            </ul>
