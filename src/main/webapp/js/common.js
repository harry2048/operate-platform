
//分页

function page(total,number){
    var _page_html="";
    if(total==0||number==0){
        return false;
    }else{
        var pages = Math.ceil(total/number);

        _page_html+="<a href='javascript:;' class='index_page' page='1'>首页</a>";
        _page_html+="<a href='javascript:;' page='' disabled class='prev_page'>上页</a>";

        for(var i =1;i<=pages;i++){
            if(i==1){
                _page_html+="<a href='javascript:;' class='active' page='"+i+"'>"+i+"</a>";
            }else{
                _page_html+="<a href='javascript:;' page='"+i+"'>"+i+"</a>";
            }

        }

        if(pages==1){
            _page_html+="<a href='javascript:;' page='' disabled class='next_page'>下页</a>";
            _page_html+="<a href='javascript:;' page='' disabled class='last_page'>末页</a>";
        }else{
            _page_html+="<a href='javascript:;' page='2' class='next_page'>下页</a>";
            _page_html+="<a href='javascript:;' class='last_page' page="+pages+" >末页</a>";

        }
        $(".common_page").html(_page_html);
    }
}

