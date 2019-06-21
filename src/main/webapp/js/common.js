
//分页
var _html="";
function page(total,number){
    if(total==0||number==0){
        return false;
    }else{
        var pages = Math.ceil(total/number);

        _html+="<a href='javascript:;' class='index_page' page='1'>首页</a>";
        _html+="<a href='javascript:;' page='' disabled class='prev_page'>上页</a>";

        for(var i =1;i<=pages;i++){
            if(i==1){
                _html+="<a href='javascript:;' class='active' page='"+i+"'>"+i+"</a>";
            }else{
                _html+="<a href='javascript:;' page='"+i+"'>"+i+"</a>";
            }

        }

        if(pages==1){
            _html+="<a href='javascript:;' page='' disabled class='next_page'>下页</a>";
            _html+="<a href='javascript:;' page='' disabled class='last_page'>末页</a>";
        }else{
            _html+="<a href='javascript:;' page='2' class='next_page'>下页</a>";
            _html+="<a href='javascript:;' class='last_page' page="+pages+" >末页</a>";

        }
        $(".common_page").html(_html);
    }
}
$(function(){
    //分页点击事件

    $(".common_page a").on("click",function(){
        $(this).addClass("active");
        $(this).siblings().removeClass("active");
        var _index = $(this).attr("page");
        if(_index==1){
            $(".prev_page").attr("disabled","disabled");
        }else{
            $(".prev_page").attr("page",_index-1);
            $(".last_page").attr("page",_index+1);
        }


    })
})
