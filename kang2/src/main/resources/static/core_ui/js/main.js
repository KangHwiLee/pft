
function paging_1(num){
	var obj = {"pageNum" : num, "amount" : 2};
	$.ajax({
		url:"/paging",
		type : "get",
		data : obj,
		success : function(data){
			view = "<ul>"
			if(data.prev == true){
				view += "<li><a onclick='paging_1(1)' class='first'>첫페이지</a></li>"
				view += "<li><a onclick='paging_1("+(data.startPage-1)+")' class='prev'>이전페이지</a></li>"
			}
			for(var i=data.startPage; i<=data.endPage; i++){
				view += " <li><a onclick='paging_table_1("+(i-1)+")' id='paging_L"+(i-1)+"'>"+i+"</a></li>"
			}
			if(data.next == true){
				view += "<li><a onclick='paging_1("+(data.endPage+1)+")' class='next'>다음페이지</a></li>"
				view += "<li><a onclick='paging_1(0)' class='last'>끝페이지</a></li>"
			}
			view+= "</ul>"
			$("#pagination_1").html(view);
			if(num == 0){
			paging_table_1(data.endPage-1)
			}else{
			paging_table_1(num-1)
			}
		}
	});
}

function paging_table_1(num){
	var obj = {"num" : num, "amount" : 2}
	$.ajax({
		url : "paging_table",
		type : "get",
		data : obj,
		dataType : "html",
		success : function(data){
			$("#paging_table").html(data);
			$("#pagination_1>ul>li>a").removeClass('active');
			$("#paging_L"+num).attr('class','active');
		}
	})
}
