$(function(){
    town_weather()

})

var t_date;

function town_weather(){
    $.ajax({
        url : "/town_weather",
        type : "post",
        success : function(data){
            console.log(data)
            t_date = data[1].data[0]

            data[1].data.forEach(function(a){
                //console.log(a)
            })
            now_weather()
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
                if(a.category == 'PTY'){
                var sky = t_date.sky == 1 ? '맑음' : t_date.sky == 3 ? ' 구름많음' : '흐림'
                var pty = a.obsrValue == 0 ? sky :
                          a.obsrValue == 1 ? '비' :
                          a.obsrValue == 2 ? '비/눈' :
                          a.obsrValue == 3 ? '눈' :
                          a.obsrValue == 5 ? '빗방울' :
                          a.obsrValue == 6 ? '빗방울눈날림' : '눈날림'
                var img_ck = a.obsrValue == 0 ? 'sky' + t_date.sky : 'pty' + a.obsrValue + ".png"
                          console.log("/img/weather/" + img_ck)
                $("#now-weather img").attr("src", "/img/weather/" + img_ck + ".png")
                $("#now-weather span").eq(0).text(pty)
                    console.log(a.obsrValue)
                }else if(a.category == 'REH'){
                    console.log(a.obsrValue)
                }else if(a.category == 'RN1'){
                    console.log(a.obsrValue)
                }else if(a.category == 'T1H'){
                    console.log(a.obsrValue)
                }else if(a.category == 'UUU'){
                    console.log(a.obsrValue)
                }else if(a.category == 'VEC'){
                    console.log(a.obsrValue)
                }else if(a.category == 'VVV'){
                    console.log(a.obsrValue)
                }else{
                    console.log(a.obsrValue)
                }
            })
            $(".w-detail h1").text(t_date.temp+"℃")
        }
    })
}