<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>黄宝康个人搭建的后台管理页面</title>
    <link rel="stylesheet" href="static/layui/css/layui.css" rel="external nofollow" >
    <script src="static/layui/layui.js"></script>
</head>
<body>
<div class="layui-layout-admin">
    <!--头部-->
    <div class="layui-header">
        <div class="layui-logo">Huang BaoKang</div>
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="javascript:void(0)" rel="external nofollow" >控制台</a></li>
            <li class="layui-nav-item"><a href="javascript:;" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" >商品管理</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" >其他系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" >邮件管理</a></dd>
                    <dd><a href="javascript:;" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" >消息管理</a></dd>
                    <dd><a href="javascript:;" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" >授权管理</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href=""><%--<img src=" rel="external nofollow" http://m.zhengjinfan.cn/images/0.jpg" class="layui-nav-img">--%>Huang BaoKang</a>
                <dl class="layui-nav-child">
                    <dd><a href="">基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                </dl>
            </li>
        </ul>
    </div>

    <!--左侧-->
    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <ul class="layui-nav layui-nav-tree" lay-filter="hbkNavbar">
                <li class="layui-nav-item">
                    <a href="javascript:;" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" >基本元素</a>
                    <dl class="layui-nav-child">
                        <dd lay-id="111"><a href="javascript:;" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" rel="external nofollow" data-options="{url:'test.html',title:'表格'}">表格</a></dd>
                        <dd><a href="">表单</a></dd>
                        <dd><a href="">导航栏</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="">组件</a>
                    <dl class="layui-nav-child">
                        <dd><a href="">Navbar</a></dd>
                        <dd><a href="">Tab</a></dd>
                        <dd><a href="">OneLevel</a></dd>
                        <dd><a href="">app.js主入口</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="">表格</a>
                </li>
                <li class="layui-nav-item">
                    <a href="">表单</a>
                </li>
            </ul>
        </div>
    </div>

    <!--中间主体-->
    <div class="layui-body" id="container">
        <div class="layui-tab" lay-filter="tabs" lay-allowClose="true">
            <ul class="layui-tab-title">
                <li class="layui-this">首页</li>
            </ul>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">首页内容</div>
            </div>
        </div>
    </div>

    <!--底部-->
    <div class="layui-footer">
        <center>黄宝康版权所有&copy;Tel:18679758769</center>
    </div>
</div>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;
        element.on('nav(hbkNavbar)',function(elem){
            /*使用DOM操作获取超链接的自定义data属性值*/
            var options = eval('('+elem.context.children[0].dataset.options+')');
            var url = options.url;
            var title = options.title;
            element.tabAdd('tabs',{
                title : title,
                content : '<iframe scrolling="auto" frameborder="0" src="'+url+'" style="width:100%;height:100%;"></iframe>',
                id : '111'
            });
        });
        /*使用下面的方式需要引用jquery*/
        /* $('.layui-nav-child a').click(function () {
          var options = eval('('+$(this).data('options')+')');
          var url = options.url;
          var title = options.title;
          element.tabAdd('tabs',{
            title : title,
            content : '<iframe scrolling="auto" frameborder="0" src="'+url+'" style="width:100%;height:100%;"></iframe>'
          });
        });*/
    });
</script>
</body>
</html>