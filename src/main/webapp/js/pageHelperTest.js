
//分页条
function build_nav_page(res){
    var result = res.data;
    $(".common_page").empty()
    var ul = $("<ul></ul>").addClass("pagination")//为ul添加属性pagination，其就变为分页条，就这么神奇

    //构建首页和前一页
    var firstLi = $("<li></li>").append($("<a>首页</a>"))
    var preLi = $("<li></li>").append($("<a></a>").append("&laquo;"))
    if(result.pageIndex > 1){
        firstLi.click(function(){
            queryBySelect(1)
        })
        preLi.click(function(){
            queryBySelect(result.pageIndex-1)
        })
    }else{
        firstLi.addClass("disabled")
        preLi.addClass("disabled")
    }

    //构建下一页和尾页
    var nextLi = $("<li></li>").append($("<a></a>").append("&raquo;"))
    var lastLi = $("<li></li>").append($("<a>尾页</a>"))
    if(result.pageIndex < result.totalPage){
        nextLi.click(function(){
            queryBySelect(result.pageIndex+1)
        })
        lastLi.click(function(){
            queryBySelect(result.totalPage)
        })
    }else{
        nextLi.addClass("disabled")
        lastLi.addClass("disabled")
    }

    //添加首页和前一页到ul中
    ul.append(firstLi).append(preLi)


    //构建页数并添加到ul中
    var num = new Array(result.totalPage);
    $.each(num,function(index,ele){
        var pageNum = index +1;
        var numLi = $("<li></li>").append($("<a></a>").append(pageNum))
        if(result.pageIndex == pageNum){
            numLi.addClass("active")
        }else{
            //为每页添加点击事件(为非当前页添加点击事件)
            numLi.click(function(){
                queryBySelect(pageNum)
            })
        }
        //将页码添加到ul中
        ul.append(numLi)
    })

    //将下一页和尾页添加到ul中
    ul.append(nextLi).append(lastLi)

    //把ul添加到<nav>中，再添加到分页条区域
    $("<nav></nav>").append(ul).appendTo($(".common_page"))
}