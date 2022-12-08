<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
function getRandomInt(max) {
	  return Math.floor(Math.random() * max);
	}
console.log(getRandomInt(50));
if(this.mychart != null){
	console.log("차트이미존재 확인")
	this.mychart.destroy();
};


var color = ['rgb(255, 99, 132)',
		      'rgb(54, 162, 235)',
		      'rgb(255, 205, 86)',
		      'rgb(75, 192, 192)',
		      'rgb(153, 102, 255)',
		      'rgb(255, 159, 64)']


  var ctx = document.getElementById('mychart');
  
  var data = {
		  labels: 'dataset1',
		  datasets: [{
		    label: 'My First Dataset',
		    data: [12, 19, 3, 5, 2, 3],
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
	  
  
  function randomize(){
	  var dataSet = config.data.datasets.length;
	  var length = config.data.datasets[0].data.length;
	  for(var j=0; j<dataSet; j++){
	  var change = [];
	  for(var i=0; i<length; i++){
		  change.push(getRandomInt(20));
	  }
	  config.data.datasets[j].data = change;
	  }
	  mychart.update();
  }
  
  function addDataSet(){
	  console.log(config.data.datasets.length)
	  var add = [];
	  var addDataSet = {
			    label: 'My First Dataset',
			    data: [12, 19, 3, 5, 2, 3],
			    backgroundColor: [
			      color[1]
			    ],
			    borderColor: [
			      color[1]
			    ],
			    borderWidth: 1
			  };
	  for(var i=0; i<addDataSet.data.length; i++){
		  add.push(getRandomInt(20));
	  }
	  addDataSet.data = add;
	  config.data.datasets.push(addDataSet);
	  mychart.update();
  }
  
  function subDataSet(){
	  config.data.datasets.pop();
	  mychart.update();
  }
</script>
