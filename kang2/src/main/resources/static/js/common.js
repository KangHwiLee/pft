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
	
