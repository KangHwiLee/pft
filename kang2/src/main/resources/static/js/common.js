	$(function(){
		$.ajax({
			url:"/side_include",
			type:"get",
			dataType:"html",
			success:function(data){
				$(".left").html(data);
			}
		})
	})
	
function paging(num){
	var obj = {"pageNum" : num, "amount" : 5};
	$.ajax({
		url:"/paging",
		type : "get",
		data : obj,
		success : function(data){
			view = "<ul>"
			if(data.prev == true){
				view += "<li><a onclick='paging(1)' class='first'>첫페이지</a></li>"
				view += "<li><a onclick='paging("+(data.startPage-1)+")' class='prev'>이전페이지</a></li>"
			}
			for(var i=data.startPage; i<=data.endPage; i++){
				view += " <li><a onclick='paging_table("+(i-1)+")' id='paging"+(i-1)+"'>"+i+"</a></li>"
			}
			if(data.next == true){
				view += "<li><a onclick='paging("+(data.endPage+1)+")' class='next'>다음페이지</a></li>"
				view += "<li><a onclick='paging(0)' class='last'>끝페이지</a></li>"
			}
			view+= "</ul>"
			$(".pagination").html(view);
			if(num == 0){
			paging_table(data.endPage-1)
			}else{
			paging_table(num-1)
			}
		}
	});
}

function paging_table(num){
	$.ajax({
		url : "paging_table",
		type : "get",
		data : {"num" : num},
		dataType : "html",
		success : function(data){
			console.log(data);
			$("#paging_table").html(data);
			$(".pagination>ul>li>a").removeClass('active');
			$("#paging"+num).attr('class','active');
		}
	})
}