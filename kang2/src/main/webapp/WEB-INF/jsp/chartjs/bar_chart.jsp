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
  var ctx = document.getElementById('mychart');
  
  var data = {
		  labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
		  datasets: [{
		    label: 'My First Dataset',
		    data: [12, 19, 3, 5, 2, 3],
		    backgroundColor: [
		      'rgba(255, 99, 132, 0.2)',
		      'rgba(54, 162, 235, 0.2)',
		      'rgba(255, 205, 86, 0.2)',
		      'rgba(75, 192, 192, 0.2)',
		      'rgba(153, 102, 255, 0.2)',
		      'rgba(255, 159, 64, 0.2)'
		    ],
		    borderColor: [
		      'rgb(255, 99, 132)',
		      'rgb(54, 162, 235)',
		      'rgb(255, 205, 86)',
		      'rgb(75, 192, 192)',
		      'rgb(153, 102, 255)',
		      'rgb(255, 159, 64)'
		    ],
		    borderWidth: 1
		  }]
		};
  var config = {
		    type: 'bar',
		    data: data,
		    options: {
		      scales: {
		        y: {
		          beginAtZero: true
		        }
		      }
		    }
		  }
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
	  var add = [];
	  var addDataSet = {
			    label: 'My First Dataset',
			    data: [12, 19, 3, 5, 2, 3],
			    backgroundColor: [
			      'rgba(255, 99, 132, 0.2)',
			      'rgba(54, 162, 235, 0.2)',
			      'rgba(255, 205, 86, 0.2)',
			      'rgba(75, 192, 192, 0.2)',
			      'rgba(153, 102, 255, 0.2)',
			      'rgba(255, 159, 64, 0.2)'
			    ],
			    borderColor: [
			      'rgb(255, 99, 132)',
			      'rgb(54, 162, 235)',
			      'rgb(255, 205, 86)',
			      'rgb(75, 192, 192)',
			      'rgb(153, 102, 255)',
			      'rgb(255, 159, 64)'
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
