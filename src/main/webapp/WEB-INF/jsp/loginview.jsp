<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>H+ 后台主题UI框架 - 登录</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico"> <link href="model/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="model/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">

    <link href="model/css/animate.min.css" rel="stylesheet">
    <link href="model/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>
</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name">H+</h1>

            </div>
            <h3>欢迎使用 H+</h3>

            <form class="m-t" role="form" action="login" method="post">
                <div class="form-group">
                    <input type="text" class="form-control" name="usercode" placeholder="用户名" required="">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" name="password" placeholder="密码" required="">
                </div>
                <div class="form-group">
                    <input type="text" class="form-control" name="randomcode" placeholder="验证码" required="">
                    <img id="randomcode_img" src="validatecode.jsp" alt="" width="80" height="25" align='absMiddle'/>
                    <a href="loginview">刷新</a>
                </div>
                <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>


                <p class="text-muted text-center"> <a href="WEB-INF/static/UI_new/login.html#"><small>忘记密码了？</small></a> | <a href="register.html">注册一个新账号</a>
                </p>

            </form>
        </div>
    </div>
    <script src="model/js/jquery.min63b9.js?v=2.1.4"></script>
    <script src="model/js/bootstrap.min14ed.js?v=3.3.6"></script>
    <script type="text/javascript" src="model/http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>


<!-- Mirrored from www.zi-han.net/theme/hplus/login.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 03 Mar 2016 12:28:43 GMT -->
</html>
