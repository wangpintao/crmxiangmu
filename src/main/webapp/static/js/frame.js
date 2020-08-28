$(function(){

    init();
    $(window).resize(function(){
        init();
    });

    //鑿滃崟
    $(".menuFA").click(function(){
        menuFAClick($(this));
    });
    $(".menuFA").mouseenter(function(){
        menuFAMouseenter($(this));
    });
    $(".menuFA").mouseleave(function(){
        menuFAMouseleave($(this));
    });

})

function menuFAMouseenter(_this){
    _this.animate({
        borderWidth:'7px'
    },200);
}

function menuFAMouseleave(_this){
    _this.animate({
        borderWidth:'0px'
    },200);
}

function menuFAClick(_this){
    var dl = _this.siblings("dl");
    var bgColor = "#282a32";
    if(dl.length > 0){
        if(dl.css("display") == "none"){
            dl.show();
            _this.find(".right").attr("class","iconfont icon-arrow-down right");
            bgColor = "#282a32";
        }else{
            dl.hide();
            _this.find(".right").attr("class","iconfont icon-dajiantouyou right");
            bgColor = "transparent";
        }
    }
    _this.css("background-color",bgColor);
    _this.parent().siblings().find("dl").hide();
    _this.parent().siblings().find("a.menuFA").css("background-color","transparent");
}

//浜岀骇鑿滃崟鐐瑰嚮鍚庣殑澶勭悊鏂规硶
function menuCAClick(url,_this){

    //澶勭悊frameMain url鍦板潃
    $("#mainIframe").attr("src",url);

    //澶勭悊frameMain title鍚嶇О鍙樺寲
    if($(_this).find("i").attr("class") == "iconfont icon-yonghu1"){
        $("#frameMainTitle span").html('<i class="iconfont icon-xianshiqi"></i>涓汉璧勬枡');
        return;
    }
    if($(_this).text() == "淇敼瀵嗙爜"){
        $("#frameMainTitle span").html('<i class="iconfont icon-xianshiqi"></i>'+$(_this).text());
        return;
    }
    if($(_this).attr("class") == "menuFA"){
        $("#frameMainTitle span").html('<i class="iconfont icon-xianshiqi"></i>'+$(_this).text());
    }else{
        //鏄剧ず鐖惰彍鍗�
//		$("#frameMainTitle span").html('<i class="iconfont icon-xianshiqi"></i>'+$(_this).parent().parent().siblings(".menuFA").text());
        //鏄剧ず瀛愯彍鍗�
        $("#frameMainTitle span").html('<i class="iconfont icon-xianshiqi"></i>'+$(_this).text());
    }

    //澶勭悊鑿滃崟鏍峰紡鍙樺寲
    $(_this).css("cssText", "background-color:#fbcc19 !important;").css("color","#FFF");
    $(_this).parent().siblings().find("a").css("cssText", "background-color:#transparent").css("color","#c2c2c2");
    $(_this).parent().parent().parent().siblings().find("dl dt a").css("cssText", "background-color:#transparent").css("color","#c2c2c2")

}

//鍒濆鍖栭〉闈�
function init(){
    var win_h = $(window).height();
    var win_w = $(window).width();
    var frameMenuW = $(".frameMenu").width();
    var logoH = 110;
    var frameTopH = $(".frameTop").height();

    $(".frameMenu").height(win_h);
    $(".frameMenu .menu").height(win_h - logoH);
    $(".main").width(win_w - frameMenuW).height(win_h);
    $(".frameMain").height(win_h - frameTopH);
    $(".frameMain .con").height(win_h - frameTopH - 40);
    $(".frameMain .con iframe").height(win_h - frameTopH - 40);

    //鑷畾涔夋粴鍔ㄦ潯
    $(".menu").mCustomScrollbar();
}