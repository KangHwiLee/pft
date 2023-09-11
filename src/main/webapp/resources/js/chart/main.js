const ctx = document.getElementById('myChart1');

                        let data = {
                                        labels: ['1','2','3','4','5','6','7'],
                                        datasets: [{
                                            label: 'CPU 사용량',
                                            data: [1, 59, 80, 81, 56, 55, 100],
                                            fill: true,
                                            borderColor: 'rgb(75, 192, 192)',
                                            tension: 0.1,
                                            pointBorderWidth: 0
                                        }]
                                        };
                        let config = {
                        type: 'line',
                        data: data,                       
                        };
                        new Chart(ctx, config)

let chartData;

$(function(){
    //dataLoad();
})

function dataLoad(){
    return chartData = setInterval(function(){
        $.ajax({
            url : "/chart_data",
            type : "post",
            success : function(data){
                console.log(data);
            }
        })
    }, 1000)
}