<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- 引入样式文件和动态控制 -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <!--主要样式控制-->
        <link href="css/main.css" rel="stylesheet">

<title>TaoBei_admin</title>

</head>
<body>
<!--顶部导航栏部分-->
<nav class="navbar navbar-inverse" >
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" title="logoTitle" href="#">TaoBei</a>
       </div>
       <div class="collapse navbar-collapse">
           <ul class="nav navbar-nav navbar-right">
               <li role="presentation">
                   <a href="#"><i class="glyphicon glyphicon-user"></i> 
                   	当前用户：白仔</a>
               </li>
               <li>
                   <a href="../login/logout">
                         <span class="glyphicon glyphicon-log-out"></span>退出登录</a>
                </li>
            </ul>
       </div>
    </div>      
</nav>

<!-- 中间主体内容部分 -->
<div class="pageContainer">
     <!-- 左侧导航栏 -->
     <div class="pageSidebar">
         <ul class="nav nav-stacked nav-pills">
             <li role="presentation">
                 <a href="/UserListServlet?pageNum=1" target="mainFrame" ><i class="glyphicon glyphicon-user"></i> 用户管理</a>
             </li>
             
             <li role="presentation">
                 <a href="nav2.html" target="mainFrame"><i class="glyphicon glyphicon-gift"></i> 商品管理</a>
             </li>
             <li role="presentation">
                 <a href="nav3.html" target="mainFrame"><i class="glyphicon glyphicon-usd"></i> 订单管理</a>
             </li>
             <li role="presentation">
                 <a href="nav4.html" target="mainFrame"><i class="glyphicon glyphicon-comment"></i> 评论管理</a>
             </li>
             <!-- 开始 -->
             <li class="dropdown">
                 <a class="dropdown-toggle" data-toggle="dropdown" href="nav4.html" target="mainFrame">
                     <i class="glyphicon glyphicon-link"></i> 个人设置<span class="caret"></span>
                 </a>
                 <ul class="dropdown-menu">
                     <li>
                         <a href="nav1.html" target="mainFrame"><i class="glyphicon glyphicon-wrench"></i> 修改密码</a>
                     </li>
                     <li>
                         <a href="nav2.html" target="mainFrame"><i class="glyphicon glyphicon-log-out"></i> 退出系统</a>
                     </li>
                     <li>
                         <a href="nav3.html" target="mainFrame"><i class="glyphicon glyphicon-user"></i> 查看个人信息</a>
                     </li>
                 </ul>
             </li>
             <!-- 结束 -->
             <li role="presentation">
                 <a href="nav5.html" target="mainFrame"><i class="glyphicon glyphicon-cog"></i> 权限设置</a>
             </li>



         </ul>
     </div>

      <!-- 左侧导航和正文内容的分隔线 -->
     <div class="splitter"></div>
     <!-- 正文内容部分 -->
     <div class="pageContent">
       <iframe src="/UserListServlet?pageNum=1" id="mainFrame" name="mainFrame"
       frameborder="0" width="100%"  height="100%" frameBorder="0">
       </iframe> 
     </div>

 </div>
  <!-- 底部页脚部分 -->
 <div class="footer">
     <p class="text-center">
         2020 &copy; BaiLCccc.
     </p>
 </div>

 <script type="text/javascript">
 $(".nav li").click(function() {
        $(".active").removeClass('active');
        $(this).addClass("active");
    }); 


 </script>
 
 <script>
        $(function () {          
            $(".dropdown-menu").on('click', function (e) {
                e.stopPropagation();
            });

        });
    </script>
</body>
</html>