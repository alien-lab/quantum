/**
 * Created by 橘 on 2016/11/14.
 */
$(function(){
	var currentpage=0;
    var swiper = new Swiper('.swiper-container', {
        nextButton: '.swiper-button-next',
        direction: 'vertical',
        lazyLoading : true,
        speed:1000,
        lazyLoadingInPrevNext : true,
        lazyLoadingInPrevNextAmount : 2,
        lazyLoadingOnTransitionStart : false,
        onInit: function(swiper){ //Swiper2.x的初始化是onFirstInit
            swiperAnimateCache(swiper); //隐藏动画元素
            swiperAnimate(swiper); //初始化完成开始动画
        },
        onSlideChangeEnd: function(swiper){
            swiperAnimate(swiper); //每个slide切换结束时也运行当前slide动画
            currentpage=swiper.activeIndex;
            switch(swiper.activeIndex){
                case 3:{
                    if(ready4){
                        $("#p4bg").attr("src",p4image.src);
                    }else{
                        $("#p4bg").attr("data-src","res/image/p4-bak.jpg");
                    }
                    $("#p5bg").attr("data-src","res/image/p5-bak.jpg").attr("src","res/image/p5-bak.jpg");
                    break;
                }
                case 4:{
                    if(ready5){
                        $("#p5bg").attr("src",p5image.src);
                    }else{
                        $("#p5bg").attr("data-src","res/image/p5-bak.jpg");
                    }
                    $("#p4bg").attr("data-src","res/image/p4-bak.jpg").attr("src","res/image/p4-bak.jpg");
                    $("#p6bg").attr("data-src","res/image/p6-bak.jpg").attr("src","res/image/p6-bak.jpg");
                    break;
                }
                case 5:{
                    if(ready6){
                        $("#p6bg").attr("src",p6image.src);
                    }else{
                        $("#p6bg").attr("data-src","res/image/p6-bak.jpg");
                    }
                    $("#p5bg").attr("data-src","res/image/p5-bak.jpg").attr("src","res/image/p5-bak.jpg");
                    $("#p7bg").attr("data-src","res/image/p7-bak.jpg").attr("src","res/image/p7-bak.jpg");;
                    break;
                }
                case 6:{
                    if(ready7){
                        $("#p7bg").attr("src",p7image.src);
                    }else{
                        $("#p7bg").attr("data-src","res/image/p7-bak.jpg");
                    }
                    $("#p6bg").attr("data-src","res/image/p6-bak.jpg").attr("src","res/image/p6-bak.jpg");
                    $("#p8bg").attr("data-src","res/image/p8-bak.jpg").attr("src","res/image/p8-bak.jpg");;
                    break;
                }
                case 7:{
                    if(ready8){
                        $("#p8bg").attr("src",p8image.src);
                    }else{
                        $("#p8bg").attr("data-src","res/image/p8-bak.jpg");
                    }
                    $("#p7bg").attr("data-src","").attr("src","res/image/p7-bak.jpg");;
                    break;
                }
            }
        }
    });

    var ready4=false,ready5=false,ready6=false,ready7=false,ready8=false;

    var p4image=new Image();
    var p5image=new Image();
    var p6image=new Image();
    var p7image=new Image();
    var p8image=new Image();
    
    var remoteurl="http://www.iaoapp.com/qih5/";
    p4image.src="res/image/4.gif";
    p4image.onload=function(a,b,c){
        if(currentpage==3)$("#p4bg").attr("src",p4image.src);
        ready4=true;
        p5image.src="res/image/5.gif";
    }
    p5image.onload=function(a,b,c){
        if(currentpage==4)$("#p5bg").attr("src",p5image.src);
        ready5=true;
        p6image.src="res/image/6.gif";
    }
    p6image.onload=function(a,b,c){
        if(currentpage==5)$("#p6bg").attr("src",p6image.src);
        ready6=true;
        p7image.src="res/image/7.gif";
    }

    p7image.onload=function(a,b,c){
        if(currentpage==6)$("#p7bg").attr("src",p7image.src);
        ready7=true;
        p8image.src="res/image/8.gif";
    }

    p8image.onload=function(a,b,c){
        if(currentpage==7)$("#p8bg").attr("src",p8image.src);
        ready8=true;
    }
    var audio=document.getElementById("audio");
    $("body").on("touchstart",function(){
        if(audio.paused){
            audio.play();
        }
    });
});
