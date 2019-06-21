/**
 * Created by yangmeng on 2016/8/8.
 */
$(function () {
    var array = [];//定义array数组，用于存放所有图片的地址
    var conArray = [];//定义conArray数组，用于存放所有图片对应的文字描述
    var count = $(".orderImg").length;//所有图片的数量
    $(".total").html(count);//图片总数显示在页面上
//        把所有图片地址存入array数组中
    for (var i = 0; i < count; i++) {
        array.push($(".orderImg").eq(i).attr("src"));
    }
//        把所有图片对应的文字描述存入conArray数组中
    for (var j = 0; j < count; j++) {
        conArray.push($(".imgText").eq(j).text());
    }
    //事件触发方法
    $(".orderImg").on("click", function () {
//            获取当前点击图片的地址
        var index1 = $(this).attr("src");
        //获取当前图片的真实宽高
        var img = new Image();
        img.src = index1;
        var sWidth1=img.width;
        var sHeight1=img.height;
        var halfWidth=sWidth1/2*-1+"px";
        var halfHeight=sHeight1/2*-1+'px';
        //把获取的地址于array数组中的地址进行对比，获取当前对应的index值。
        for (var i = 0; i < count; i++) {
            if (array[i] == index1) {
                var indexNum = i;
            }
        }
        $(".picContent").html(conArray[indexNum]);
        $(".dang").html(indexNum + 1);
        $(".leBtn").on("click", function () {
            if (indexNum < 1) {
                indexNum = count - 1;
            } else {
                indexNum--;
            }
            $(".dang").html(indexNum + 1);
            $(".picContent").html(conArray[indexNum]);
            $(".fixImg").attr("src", array[indexNum]);

            //获取当前图片的真实宽高
            var img = new Image();
            img.src = $(".fixImg").attr("src");
            var sWidth1=img.width;
            var sHeight1=img.height;
            var halfWidth=sWidth1/2*-1+"px";
            var halfHeight=sHeight1/2*-1+'px';
            $(".fixImg").width(sWidth1);
            $(".fixImg").height(sHeight1);
            $(".fixImg").css({
                'top': '50%',
                'left': '50%',
                'margin-top': halfHeight,
                'margin-left':halfWidth
            });
        });
        $(".riBtn").on("click", function () {
            if (indexNum > count - 2) {
                indexNum = 0;
            } else {
                indexNum++;
            }
            $(".dang").html(indexNum + 1);
            $(".picContent").html(conArray[indexNum]);
            $(".fixImg").attr("src", array[indexNum]);
            //获取当前图片的真实宽高
            var img = new Image();
            img.src = $(".fixImg").attr("src");
            var sWidth1=img.width;
            var sHeight1=img.height;
            var halfWidth=sWidth1/2*-1+"px";
            var halfHeight=sHeight1/2*-1+'px';
            $(".fixImg").width(sWidth1);
            $(".fixImg").height(sHeight1);
            $(".fixImg").css({
                'top': '50%',
                'left': '50%',
                'margin-top': halfHeight,
                'margin-left':halfWidth
            });
        });
        var srcc = $(this).attr("src");
        $(".fixImg").attr("src", srcc);
        $(".fixImg").width(sWidth1);
        $(".fixImg").height(sHeight1);
        $(".fixImg").css({
            'top': '50%',
            'left': '50%',
            'margin-top': halfHeight,
            'margin-left':halfWidth
        });
        //键盘事件
        $(document).keydown(function(event){
            //判断当event.keyCode 为37时（即左方面键）;
            //判断当event.keyCode 为39时（即右方面键）;
            //判断当event.keyCode 为27时（即ESC键）;
            if(event.keyCode == 37){
                if (indexNum < 1) {
                    indexNum = count - 1;
                } else {
                    indexNum--;
                }
                $(".dang").html(indexNum + 1);
                $(".picContent").html(conArray[indexNum]);
                $(".fixImg").attr("src", array[indexNum]);
                //获取当前图片的真实宽高
                var img = new Image();
                img.src = $(".fixImg").attr("src");
                var sWidth1=img.width;
                var sHeight1=img.height;
                var halfWidth=sWidth1/2*-1+"px";
                var halfHeight=sHeight1/2*-1+'px';
                $(".fixImg").width(sWidth1);
                $(".fixImg").height(sHeight1);
                $(".fixImg").css({
                    'top': '50%',
                    'left': '50%',
                    'margin-top': halfHeight,
                    'margin-left':halfWidth
                });
            }else if (event.keyCode == 39){
                if (indexNum > count - 2) {
                    indexNum = 0;
                } else {
                    indexNum++;
                }
                $(".dang").html(indexNum + 1);
                $(".picContent").html(conArray[indexNum]);
                $(".fixImg").attr("src", array[indexNum]);
                //获取当前图片的真实宽高
                var img1 = new Image();
                img1.src = $(".fixImg").attr("src");
                var sWidth2=img1.width;
                var sHeight2=img1.height;
                var halfWidth2=sWidth2/2*-1+"px";
                var halfHeight2=sHeight2/2*-1+'px';
                $(".fixImg").width(sWidth2);
                $(".fixImg").height(sHeight2);
                $(".fixImg").css({
                    'top': '50%',
                    'left': '50%',
                    'margin-top': halfHeight2,
                    'margin-left':halfWidth2
                });
            }else if(event.keyCode == 27){
                $("#BG").css("display", "none");
            }
        });
    })
});
$(function () {
    var current = 0;
    var width1 = parseInt($(".fixImg").width());
    var height1 = parseInt($(".fixImg").height());
    $(".leftBtn").on("click", function () {
        current = (current + 90) % 360;
        $(".fixImg").css({
            'transform': 'rotate(' + current + 'deg)',
            '-moz-transform': 'rotate(' + current + 'deg)',
            '-o-transform': 'rotate(' + current + 'deg)'
        });
    });
    $(".rightBtn").on("click", function () {
        current = (current - 90) % 360;
        $(".fixImg").css({
            'transform': 'rotate(' + current + 'deg)',
            '-moz-transform': 'rotate(' + current + 'deg)',
            '-o-transform': 'rotate(' + current + 'deg)'
        });
    });
    $(".bigBtn").on("click", function () {
        var wd = parseInt($(".fixImg").width());
        var hg = parseInt($(".fixImg").height());
        wd = wd * 1.1;
        hg = hg * 1.1;
        $(".fixImg").width(wd);
        $(".fixImg").height(hg);
        $(".fixImg").css("margin-top",-hg/2);
        $(".fixImg").css("margin-left",-wd/2);
    });

    $(".smallBtn").on("click", function () {
        var wd = parseInt($(".fixImg").width());
        var hg = parseInt($(".fixImg").height());
        if (wd > 205) {
            wd = wd * 0.9;
        } else {
            wd = wd * 0.9;
        }
        if (hg > 140) {
            hg = hg * 0.9;
        } else {
            hg = hg * 0.9;
        }

        $(".fixImg").width(wd);
        $(".fixImg").height(hg);
        $(".fixImg").css("margin-top",-hg/2);
        $(".fixImg").css("margin-left",-wd/2);
    });
    $(".refreshBtn").on("click", function () {
        $(".fixImg").width(410);
        $(".fixImg").height(280);
        $(".fixImg").css({
            'top': '50%',
            'left': '50%',
            'margin-top': '-140px',
            'margin-left': '-210px'
        });
    });

    $(".img-thumbnail").on('click', function () {
        $("#BG").css("display", "table-cell");
    });
    $(".close_btn").on("click", function () {
        $("#BG").css("display", "none");
    });
// jquery 兼容的滚轮事件
    $(document).on("mousewheel DOMMouseScroll", function (e) {

        var delta = (e.originalEvent.wheelDelta && (e.originalEvent.wheelDelta > 0 ? 1 : -1)) ||  // chrome & ie
            (e.originalEvent.detail && (e.originalEvent.detail > 0 ? -1 : 1));              // firefox
        if (delta > 0) {
            // 向上滚
            var wd = parseInt($(".fixImg").width());
            var hg = parseInt($(".fixImg").height());
            wd = wd * 1.02;
            hg = hg * 1.02;
            $(".fixImg").width(wd);
            $(".fixImg").height(hg);
            $(".fixImg").css("margin-top",-hg/2);
            $(".fixImg").css("margin-left",-wd/2);
        } else if (delta < 0) {
            // 向下滚
            var wd = parseInt($(".fixImg").width());
            var hg = parseInt($(".fixImg").height());
            if (wd > 205) {
                wd = wd * 0.98;
            } else {
                wd = wd * 0.98;
            }
            if (hg > 140) {
                hg = hg * 0.98;
            } else {
                hg = hg * 0.98;
            }

            $(".fixImg").width(wd);
            $(".fixImg").height(hg);
            $(".fixImg").css("margin-top",-hg/2);
            $(".fixImg").css("margin-left",-wd/2);
        }
    });



});
$(function () {
    $(".imgBox img").on('click', function () {
        $("#BG").css("display", "table-cell");
        $("body").css("overflow", "hidden");
        var srcc = $(this).attr("src");
        $(".fixImg").attr("src", srcc);
    });
    $(".close_btn").on("click", function () {
        $("#BG").css("display", "none");
        $("body").css("overflow", "");
    });
});