/**
 * Created by 橘 on 2016/12/26.
 */
var wxdebug=false;
var wxoption={};
$.ajax({
    url:"/quantum/wechat/jsapi",
    method:"POST",
    async:false,
    data:{url:window.location.href},
    success:function(rep){
        wxoption=rep;
    }
});
wx.config({
    debug:wxdebug,
    appId:wxoption.appid,
    timestamp:wxoption.timestamp,
    nonceStr: wxoption.nonceStr,
    signature: wxoption.signature,
    jsApiList: [
        'checkJsApi',
        'onMenuShareTimeline',
        'onMenuShareAppMessage',
        'onMenuShareQQ',
        'onMenuShareWeibo',
        'hideMenuItems',
        'showMenuItems',
        'hideAllNonBaseMenuItem',
        'showAllNonBaseMenuItem',
        'translateVoice',
        'startRecord',
        'stopRecord',
        'onRecordEnd',
        'playVoice',
        'pauseVoice',
        'stopVoice',
        'uploadVoice',
        'downloadVoice',
        'chooseImage',
        'previewImage',
        'uploadImage',
        'downloadImage',
        'getNetworkType',
        'openLocation',
        'getLocation',
        'hideOptionMenu',
        'showOptionMenu',
        'closeWindow',
        'scanQRCode',
        'chooseWXPay',
        'openProductSpecificView',
        'addCard',
        'chooseCard',
        'openCard'
    ]
});
wx.ready(function (){
    var shareObject={
        title:"Quantum Inspiration",
        link:window.location.href,
        imgUrl:'http://www.bigercat.com/quantum/h5_1/res/image/logo.png',
        desc:'量子直觉'
    }
    if(window.shareObject!=null){
        shareObject=window.shareObject;
    }
    wx.onMenuShareTimeline({
        title: shareObject.title, // 分享标题
        link: shareObject.link, // 分享链接
        imgUrl: shareObject.imgUrl, // 分享图标
        success: function () {
            //alert(shareObject.imgUrl)
            // 用户确认分享后执行的回调函数
        },
        cancel: function () {
            // 用户取消分享后执行的回调函数
        }
    });
    wx.onMenuShareAppMessage({
        title: shareObject.title, // 分享标题
        desc: shareObject.desc, // 分享描述
        link: shareObject.link, // 分享链接
        imgUrl: shareObject.imgUrl, // 分享图标
        success: function () {
            //alert(shareObject.imgUrl)
            // 用户确认分享后执行的回调函数
        },
        cancel: function () {
            // 用户取消分享后执行的回调函数
        }
    });
});