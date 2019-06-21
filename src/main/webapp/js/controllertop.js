

//用户登录登出
$(function(){
    $("#nav").delegate(".state","click",function(){
        $(this).parents(".login_name").toggleClass("bg");
        $(this).next(".quit").toggle();
    });
});

$(function(){

// 左侧菜单收缩功能
    var _window_width;
    $(".iframe").width($(window).width()-180);
    $("#content").delegate(".listSou","click",function(){
        $(".sidebar").toggleClass("activeList");
         _window_width = $(window).width();
        if($(".sidebar").hasClass("activeList")){
           _window_width -=50;
            $(".one").css("display","none");
            $(".side_top").css("display","none");
            $(".content1").addClass("activeCon");
            $(".iframe").css("margin-left","50px");
            $(".iframe").css("width",_window_width+"px");
        }else {
            _window_width-=180;
            $(".content1").removeClass("activeCon");
            $(".side_top").css("display","block");
            $(".one").css("display","block");
            $(".iframe").css("margin-left","180px");
            $(".iframe").css("width",_window_width+"px");


        }
    });
// 左侧菜单点击换iframe
    $(".u_Li a").click(function() {
        if($(this).attr("msg")){
            $(".iframe").attr("src",$(this).attr("msg")+".html")
        }
    });

});




<!--签到功能-->
$(function(){
    //$("#nav").delegate(".qian","click",function(){
    //    $(this).parents(".qianLi").css("display","none");
    //    $(".login_name1").removeClass("qian_no");
    //});
    $("#nav").delegate(".login_name1",'mouseover mouseout',function(event){
        if(event.type == "mouseover"){
            $(this).children(".quit1").css("display","block");
        }else if(event.type == "mouseout"){
            $(this).children(".quit1").css("display","none");
        }
    });
    //$("#nav").delegate(".cheOut","click",function(){
    //    $(this).parents(".login_name1").addClass("qian_no");
    //    $(".qianLi").css("display","block");
    //})
});

