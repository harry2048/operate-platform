$(document).ready(function () {
	$('#con li:nth-child(1)').addClass("show")
    $('#tit span').click(function () {
        let i = $(this).index();//下标第一种写法
        //let i = $('tit').index(this);//下标第二种写法
        $(this).addClass('select').siblings().removeClass('select');
        $('#con li:nth-child(1)').removeClass("show")
        $('#con li').eq(i).show().siblings().hide();
    });
    //模糊查询


});  