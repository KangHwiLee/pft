

function contant_detail(num){
	console.log("contant_detail 실행")
	location.href="/contant_detail?num="+num;
}

function write_move(){
	location.href="/write_move"
}

function add_paging_contant(){
	$.ajax({
			url : "add_paging_contant",
			type : "post",
			dataType : "html",
			success : function(data){
				$("#paging-area").html(data);
				paging_test(sessionStorage.getItem("paging"))
			}
		})
		
}

function paging_test(num){
	var obj = {"pageNum" : num, "amount" : 5};
	$.ajax({
		url:"/paging_test",
		type : "get",
		data : obj,
		success : function(data){
			console.log(data);
			view = "<ul class='pagination'>"
			if(data.prev == true){
				view += "<li><a onclick='paging_test(1)' class='first'><<</a></li>"
				view += "<li><a onclick='paging_test("+(data.startPage-1)+")' class='prev'><</a></li>"
			}
			for(var i=data.startPage; i<=data.endPage; i++){
				view += " <li><a onclick='paging_contant_load("+(i-1)+")' id='right_"+(i-1)+"'>"+i+"</a></li>"
			}
			if(data.next == true){
				view += "<li><a onclick='paging_test("+(data.endPage+1)+")' class='next'>></a></li>"
				view += "<li><a onclick='paging_test(0)' class='last'>>></a></li>"
			}
			view+= "</ul>"
			$("#pagination").html(view);
			if(num == 0){
			paging_contant_load(data.endPage-1)
			}else{
			paging_contant_load(num-1)
			}
		}
	});
}

function paging_contant_load(num){
	$.ajax({
		url : "/paging_contant_load?num="+num,
		type : "get",
		dataType : "html",
		success : function(data){
			$("#paging-area").html(data);
			sessionStorage.removeItem("paging");
			sessionStorage.setItem("paging", num+1);
		}
	})
}


