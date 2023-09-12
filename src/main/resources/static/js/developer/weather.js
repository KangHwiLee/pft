$(function(){
    town_weather()
    now_weather()
})

function town_weather(){
    $.ajax({
        url : "/town_weather",
        type : "post",
        success : function(data){
            console.log(data)
            data[1].data.forEach(function(a){
                console.log(a)
            })
            
        }
    })
}

function now_weather(){
    $.ajax({
        url : "/now_weather",
        type : "post",
        success : function(data){
            data.forEach(function(a){
                console.log(a)
            })
        }
    })
}