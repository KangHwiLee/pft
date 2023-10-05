

var header = $("meta[name='_csrf_header']").attr('content');
var token = $("meta[name='_csrf']").attr('content');
$(document).ready(function(){
field_list();
})

$(document).on('click', '#btn-a', function(){
    window.open("/field_add", "테스트", "width=400, height=500")
}).on('click', ".card-body ul li", function(){
    var lat = $(this).data('field_lat')
    var lon = $(this).data('field_lon')
    town_weather(lat, lon);
    $('.card-body input:eq(1)').val($(this).text())

play(lat ,lon);
//    initTmap();
    //navigation(lat, lon);
//    getRP(lat, lon);

})

async function play(lat, lon){
    $("#naviInfo p").remove();
    $("#naviInfo img").css('display','block');
    $(".card-body img").css('display','block')
    initTmap();
    setTimeout(function(){
    getRP(lat, lon)
    }, 100)
}

function field_list(){
    $.ajax({
        url : "/field_list",
        type : "post",
        beforeSend: function(xhr){
                        xhr.setRequestHeader(header, token);
                    },
        success : function(data){
            view = "";
            data.forEach((a) =>{
            view += "<li data-id='"+a.id+"'"
            view += " data-field_lat='"+a.field_lat+"'"
            view += " data-field_lon='"+a.field_lon+"'"
            view += ">"
            view += a.field_name+"</li>"
            })
            $(".card-body ul").html(view);
        }
    })
}