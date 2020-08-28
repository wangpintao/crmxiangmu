$(function(){

    $(window).load(function(){
        cframeInit();
        //鍚庡彴棣栭〉鐨勫叏灞忓姛鑳界殑bug锛屽鏋滀笉寰椾笉鍙栧嚭Iframe鐨勫ぇ灏忓彉鍖栧悗鐨勭洃鍚簨浠躲€�
        $(window).resize(function(){
            cframeInit();
        });
    });

    //鍏叡form琛ㄥ崟楠岃瘉
    layui.use('form', function() {
        var form = layui.form;
        form.verify({
            //鏁扮粍鐨勪袱涓€煎垎鍒唬琛細[姝ｅ垯鍖归厤銆佸尮閰嶄笉绗︽椂鐨勬彁绀烘枃瀛梋

            //鍙兘杈撳叆涓枃
            ZHCheck: [
                /^[\u0391-\uFFE5]+$/
                ,'鍙厑璁歌緭鍏ヤ腑鏂�'
            ],
            //鍏堥潪绌猴紝濡傛灉鏈夊唴瀹瑰垯楠岃瘉閭鏍煎紡
            NEWEmail: function(value, item){ //value锛氳〃鍗曠殑鍊笺€乮tem锛氳〃鍗曠殑DOM瀵硅薄
                if(value != null && value != ""){
                    if(!/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(value)){
                        return '閭鏍煎紡涓嶆纭�';
                    }
                }
            },
            //鏍￠獙鐧诲綍鍚嶆槸鍚﹂噸澶�
            LoginName:function(value,item){
                var tag = submitcheck(value);
                if(!tag){
                    return "鐢ㄦ埛鍚嶅凡瀛樺湪";
                }
            },
            //楠岃瘉浠锋牸鏁板瓧
            //^[1-9]\d*(.\d{1,2})?$ 锛� 1-9寮€澶达紝鍚庤窡鏄�0-9锛屽彲浠ヨ窡灏忔暟鐐癸紝浣嗗皬鏁扮偣鍚庤甯︿笂1-2浣嶅皬鏁帮紝绫讳技2,2.0,2.1,2.22绛�
            //^0(.\d{1,2})?$ 锛� 0寮€澶达紝鍚庡彲浠ヨ窡灏忔暟鐐癸紝灏忔暟鐐瑰悗瑕佸緟涓�1-2浣嶅皬鏁帮紝绫讳技0,0.22,0.1绛�
            PriceCheck:[
                /(^[1-9]\d*(\.\d{1,2})?$)|(^0(\.\d{1,2})?$)/
                ,'璇锋寜鐓ф爣鍑嗕环鏍兼牸寮忚緭鍏ワ紝灏忔暟浣嶅彲閫夋嫨杈撳叆涓や綅'
            ]
            //韬唤璇佸彿
//          identity: function(value, item){ //value锛氳〃鍗曠殑鍊笺€乮tem锛氳〃鍗曠殑DOM瀵硅薄
//          	var reg1 = /^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;
//          	var reg2 = /^[1-9]\d{5}\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{2}[0-9Xx]$/;
//              if(!reg1.test(value) $$ !reg2.test(value)){
//                  return '璇疯緭鍏ユ纭殑韬唤璇佸彿......';
//              }
//          }

        });
    });
})

//鍒濆鍖栭〉闈�
function cframeInit(){
    var win_h = $(window).height();
    var conheight;
    try{
        conheight = $('#mainIframe',parent.document).parents(".frameMain").find(".con").height();
    }catch(e){
        conheight = win_h;
    }

    var fullScreenTAG = sessionStorage.getItem("fullScreenTAG");
    if(fullScreenTAG == 1){
        conheight = $(parent.document).height();
    }

    //璁＄畻Iframe鐨勯珮搴︿笌鐖跺厓绱犵浉鍚�
    $('#mainIframe',parent.document).css("height",conheight);
    //璁＄畻Iframe鍐卌Body鐨勯珮搴︼紝浣垮叾鍥哄畾
    $(".cBody").height(conheight - 20);
    //涓篶Body璁剧疆婊氬姩鏉＄殑鏍峰紡
    $(".cBody").mCustomScrollbar();
}

//鍟嗗搧鍥剧墖鏀惧ぇ
function imgBig(_this){
    _this.className = "imgBig";
    _this.width = "200";
    _this.height = "200";
}

//鍟嗗搧鍥剧墖鏀惧皬
function imgSmall(_this){
    _this.className = "imgSmall";
    _this.width = "20";
    _this.height = "20";
}

//鍥剧墖鍔犺浇澶辫触鍚庨粯璁ゅ浘鐗�
function errorImg(_this){
    _this.src = '../../images/imgError.png';
    _this.onerror=null;
}

//韬唤璇佹闈㈠浘鐗囧姞杞藉け璐ュ悗榛樿鍥剧墖
function errorCardZMImg(_this){
    _this.src = '../../images/cardZMImgError.png';
    _this.onerror=null;
}

//韬唤璇佸弽闈㈠浘鐗囧姞杞藉け璐ュ悗榛樿鍥剧墖
function errorCardFMImg(_this){
    _this.src = '../../images/cardFMImgError.png';
    _this.onerror=null;
}

//钀ヤ笟鎵х収鍥剧墖鍔犺浇澶辫触鍚庨粯璁ゅ浘鐗�
function errorYyzzImg(_this){
    _this.src = '../../images/yyzzImgError.png';
    _this.onerror=null;
}


//2018骞�07鏈�13鏃� 鏂板姛鑳絫ips鎻愮ず鍔熻兘璇︾粏鐢ㄩ€旂殑鎻愮ず鏍�
function getTips(_this, str){
    layer.tips(str , $(_this), {
        tips: [1, '#3595CC'],
        time: 0
    });
}