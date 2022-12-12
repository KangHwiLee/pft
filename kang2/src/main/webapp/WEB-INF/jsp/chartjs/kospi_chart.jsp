<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <script>
 if(this.mychart != null){
	 console.log(this.mychart);
		console.log("차트이미존재 확인")
		this.mychart.destroy();
	};
	
	var ctx = document.getElementById('myChart');
                var color = ['rgb(255, 99, 132)',
      		      'rgb(54, 162, 235)',
      		      'rgb(255, 205, 86)',
      		      'rgb(75, 192, 192)',
      		      'rgb(153, 102, 255)',
      		      'rgb(255, 159, 64)']
                var label = [];
                var clpr = [];
			$(document).ready(function(){
				var name = "코스피"
				$.ajax({
            		url : "/chartData",
            		data : {"name" : name},
            		dataType : "json",
            		type : "get",
            		success : function(data){
            			console.log(data);
            			var check = data[data.length-1].fltRt.substring(0, 2);
            			var minus = "";
            			if(check.indexOf('-') != -1){
            				minus = "-"
            			}
            			console.log(check)
            			if(check.indexOf('0') == -1){
            				$("#body #span_2").text("전일대비 (0"+data[data.length-1].fltRt+") %");
            				}else{
            					$("#body #span_2").text("전일대비 ("+data[data.length-1].fltRt+") %");
            				}
            			$("#body #span_1").text("현재가 : " + data[data.length-1].clpr);
            			
            			for(var i=0; i<data.length; i++){
            				label.push(data[i].baseDt.substring(4,6)+"/"+data[i].baseDt.substring(6,8));
            				clpr.push(data[i].clpr);
            			}
            			
        		        
        		        var data = {
        		        		  labels: label,
        		      		  datasets: [{
        		      		    label: '코스피',
        		      		    data: clpr,
        		      		    borderColor: [
        		      		      color[0]
        		      		    ],
        		      		    backgroundColor : [
        		      		    	color[0]
        		      		    ],
        		      		    borderWidth: 2
        		      		  }]
        		      		};
        		        
        		        var config = {
        		      		  type: 'line',
        		      		  data: data,
        		      		  options: {
        		      		    responsive: true,
        		      		    plugins: {
        		      		      legend: {
        		      		        position: 'top',
        		      		      },
        		      		      title: {
        		      		        display: true,
        		      		        text: 'Chart.js Line Chart'
        		      		      }
        		      		    }
        		      		  },
        		      		};
        		        console.log(config.data.datasets[0].data.length);
        		        var mychart = new Chart(ctx, config);
            			}
            		})
			})
                </script>