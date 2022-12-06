<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page session="true"%>
<!DOCTYPE html>
<!--
* CoreUI - Free Bootstrap Admin Template
* @version v4.2.2
* @link https://coreui.io
* Copyright (c) 2022 creativeLabs Łukasz Holeczek
* Licensed under MIT (https://coreui.io/license)
-->
<!-- Breadcrumb-->
<html lang="en">
  <head>
    <base href="./">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <meta name="description" content="CoreUI - Open Source Bootstrap Admin Template">
    <meta name="author" content="Łukasz Holeczek">
    <meta name="keyword" content="Bootstrap,Admin,Template,Open,Source,jQuery,CSS,HTML,RWD,Dashboard">
    <title>포트폴리오 뉴 샘플</title>
    <script src="resources/js/jquery-3.6.0.min.js" ></script>
    <link rel="apple-touch-icon" sizes="57x57" href="resources/core_ui/assets/favicon/apple-icon-57x57.png">
    <link rel="apple-touch-icon" sizes="60x60" href="resources/core_ui/assets/favicon/apple-icon-60x60.png">
    <link rel="apple-touch-icon" sizes="72x72" href="resources/core_ui/assets/favicon/apple-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="76x76" href="resources/core_ui/assets/favicon/apple-icon-76x76.png">
    <link rel="apple-touch-icon" sizes="114x114" href="resources/core_ui/assets/favicon/apple-icon-114x114.png">
    <link rel="apple-touch-icon" sizes="120x120" href="resources/core_ui/assets/favicon/apple-icon-120x120.png">
    <link rel="apple-touch-icon" sizes="144x144" href="resources/core_ui/assets/favicon/apple-icon-144x144.png">
    <link rel="apple-touch-icon" sizes="152x152" href="resources/core_ui/assets/favicon/apple-icon-152x152.png">
    <link rel="apple-touch-icon" sizes="180x180" href="resources/core_ui/assets/favicon/apple-icon-180x180.png">
    <link rel="icon" type="image/png" sizes="192x192" href="resources/core_ui/assets/favicon/android-icon-192x192.png">
    <link rel="icon" type="image/png" sizes="32x32" href="resources/core_ui/assets/favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="96x96" href="resources/core_ui/assets/favicon/favicon-96x96.png">
    <link rel="icon" type="image/png" sizes="16x16" href="resources/core_ui/assets/favicon/favicon-16x16.png">
    <link rel="manifest" href="resources/core_ui/assets/favicon/manifest.json">
    <meta name="msapplication-TileColor" content="#ffffff">
    <meta name="msapplication-TileImage" content="resources/assets/favicon/ms-icon-144x144.png">
    <meta name="theme-color" content="#ffffff">
    <!-- Vendors styles-->
    <link rel="stylesheet" href="resources/core_ui/vendors/simplebar/css/simplebar.css">
    <link rel="stylesheet" href="resources/core_ui/css/vendors/simplebar.css">
    <!-- Main styles for this application-->
    <link href="resources/core_ui/css/style.css" rel="stylesheet">
    <!-- We use those styles to show code examples, you should remove them in your application.-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/prismjs@1.23.0/themes/prism.css">
    <link href="resources/core_ui/css/examples.css" rel="stylesheet">
    <!-- Global site tag (gtag.js) - Google Analytics-->
    <script async="" src="https://www.googletagmanager.com/gtag/js?id=UA-118965717-3"></script>
    <script>
      window.dataLayer = window.dataLayer || [];

      function gtag() {
        dataLayer.push(arguments);
      }
      gtag('js', new Date());
      // Shared ID
      gtag('config', 'UA-118965717-3');
      // Bootstrap ID
      gtag('config', 'UA-118965717-5');
    </script>
    <link href="resources/core_ui/vendors/@coreui/chartjs/css/coreui-chartjs.css" rel="stylesheet">
    <link href="resources/core_ui/scss/_ltr-rtl.scss" type="text/css">
      </head>
  <body class="dark-theme">
    <div class="sidebar sidebar-dark sidebar-fixed" id="sidebar">
      <!-- 사이드 메뉴 -->
      <jsp:include page="/WEB-INF/jsp/new_pft/side_bar.jsp"/>
    
    </div>
    <div class="wrapper d-flex flex-column min-vh-100 bg-light">
      <header class="header header-sticky mb-4" id="header">
      
        <!-- 헤더 ajax 인클루드 -->
        
      </header>
      <div class="body flex-grow-1 px-3">
        <div class="container-lg">
          <div class="row" id="body">
        <!-- body ajax 인클루드 -->
          <%-- <jsp:include page="/WEB-INF/jsp/new_pft/body_sample.jsp"/> --%>
        </div>
        </div>
      </div>
      <footer class="footer">
        <div><a href="https://coreui.io">CoreUI </a><a href="https://coreui.io">Bootstrap Admin Template</a> © 2022 creativeLabs.</div>
        <div class="ms-auto">Powered by&nbsp;<a href="https://coreui.io/docs/">CoreUI UI Components</a></div>
      </footer>
    </div>
    <!-- CoreUI and necessary plugins-->
    <script src="resources/core_ui/vendors/@coreui/coreui/js/coreui.bundle.min.js"></script>
    <script src="resources/core_ui/vendors/simplebar/js/simplebar.min.js"></script>
    <!-- Plugins and scripts required by this view-->
    <script src="resources/core_ui/vendors/chart.js/js/chart.min.js"></script>
    <script src="resources/core_ui/vendors/@coreui/chartjs/js/coreui-chartjs.js"></script>
    <script src="resources/core_ui/vendors/@coreui/utils/js/coreui-utils.js"></script>
    <script src="resources/core_ui/js/main.js"></script>
    <script>
    </script>

  </body>
  
  <script>
  $(document).ready(function(){
	  $.ajax({
		  url : "/header",
		  type : "get",
		  dataType : "html",
		  success : function(data){
			  $("#header").html(data);
		  }
	  })
	 main_body()
  })
  
  function main_body(){
	  $.ajax({
		  url : "/main_body",
		  type : "get",
		  dataType : "html",
		  success : function(data){
			  $("#body").html(data);
		  }
	  })
  }
  
  function stack_menu_move(num){
	  $.ajax({
		  url : "/stack_menu_move?num="+num,
		  type : "get",
		  dataType : "html",
		  success : function(data){
			  $("#body").html(data);
		  }
	  })
  }
  
  </script>
  
</html>