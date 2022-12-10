  $(document).ready(function(){
	  $.ajax({
		  url : "/header",
		  type : "get",
		  dataType : "html",
		  success : function(data){
			  $("#header").html(data);
		  }
	  })
	 main_body()
  })
  
  function main_body(){
	  $.ajax({
		  url : "/main_body",
		  type : "get",
		  dataType : "html",
		  success : function(data){
			  $("#body").html(data);
		  }
	  })
  }
  
  
  
  function stack_menu_move(num){
	  $.ajax({
		  url : "/stack_menu_move?num="+num,
		  type : "get",
		  dataType : "html",
		  success : function(data){
			  $("#body").html(data);
			  }
	  })
  }

  function chart_menu_move(num){
	  var codemr = document.createElement("jsp:include")
	  codemr.setAttribute("page", "/WEB-INF/jsp/base/codemirror_area.jsp");
	  console.log(codemr)
	  $.ajax({
		  url : "/chart_menu_move?num="+num,
		  type : "get",
		  dataType : "html",
		  success : function(data){
				var chart_area = document.createElement("canvas")
				  chart_area.setAttribute("id", "mychart")
				  chart_area.style.width="1000px";
				  chart_area.style.height="500px";
				  $("#body").html(chart_area);
			  
			  var chart_config = document.getElementById("today_chart")
				  chart_config = document.createElement("div")
				  chart_config.setAttribute("id", "today_chart")
				  console.log(chart_config);
			  $("#today_chart").html(data);
			  
			 	var randomize = document.createElement("button");
			 	var jbBtnText = document.createTextNode( 'randomize' );
			 	randomize.setAttribute("type", "button");
			 	randomize.setAttribute("onclick", "randomize()");
			 	randomize.appendChild(jbBtnText);
			 	$("#body").append(randomize);
			 	
			 	var addDataSet = document.createElement("button");
			 	var jbBtnText = document.createTextNode( 'addDataSet' );
			 	addDataSet.setAttribute("type", "button")
			 	addDataSet.setAttribute("onclick", "addDataSet()")
			 	addDataSet.appendChild(jbBtnText);
			 	$("#body").append(addDataSet);

			 	var subDataSet = document.createElement("button");
			 	var jbBtnText = document.createTextNode( 'subDataSet' );
			 	subDataSet.setAttribute("type", "button")
			 	subDataSet.setAttribute("onclick", "subDataSet()")
			 	subDataSet.appendChild(jbBtnText);
			 	$("#body").append(subDataSet);
			 	
			 	$.ajax({
			 		url : "/code_mirror_area",
			 		data : {"data" : data},
			 		type : "get",
			 		dataType : "html",
			 		success : function(data){
			 			$("#body").append(data)
			 		
			 		}
			 	})
		  }
	  })
  }
  
  function tistory(){
	  $.ajax({
		  url : "/tistory",
		  type : "get",
		  dataType : "html",
		  success : function(data){
			 $("#body").html(data);
		  }
	  })
  }
  
  function chartData(){
	$.ajax({
		url : "/chartData",
		data : {"kospi" : "코스피", "kosdaq" : "코스닥"},
		dataType : "json",
		type : "get",
		success : function(data){
			console.log(data[0].baseDt);
		}
	})
}