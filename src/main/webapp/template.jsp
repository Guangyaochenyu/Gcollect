<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="description" content="">
    <meta name="author" content="hrbu.edu.guangyaochenyu.top">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="http://www.hrbu.edu.cn/images/hrbu.ico" type="image/x-icon">
    <title>资料收集系统</title>
    <link type="text/css" rel="stylesheet" href="http://docs.bootcss.com/bootstrap-2.0.3/docs/assets/css/bootstrap.css" />
    <link type="text/css" rel="stylesheet" href="http://docs.bootcss.com/bootstrap-2.0.3/docs/assets/css/bootstrap-responsive.css" />
    <style>
        body {padding-top: 60px;padding-bottom: 40px;background-color: rgb(217,217,217);}
        body::-webkit-scrollbar {width: 0;}
    </style>
    <script src="http://docs.bootcss.com/bootstrap-2.0.3/docs/assets/js/jquery.js"></script>
    <script src="http://docs.bootcss.com/bootstrap-2.0.3/docs/assets/js/bootstrap-transition.js"></script>
    <script src="http://docs.bootcss.com/bootstrap-2.0.3/docs/assets/js/bootstrap-alert.js"></script>
    <script src="http://docs.bootcss.com/bootstrap-2.0.3/docs/assets/js/bootstrap-modal.js"></script>
    <script src="http://docs.bootcss.com/bootstrap-2.0.3/docs/assets/js/bootstrap-dropdown.js"></script>
    <script src="http://docs.bootcss.com/bootstrap-2.0.3/docs/assets/js/bootstrap-scrollspy.js"></script>
    <script src="http://docs.bootcss.com/bootstrap-2.0.3/docs/assets/js/bootstrap-tab.js"></script>
    <script src="http://docs.bootcss.com/bootstrap-2.0.3/docs/assets/js/bootstrap-tooltip.js"></script>
    <script src="http://docs.bootcss.com/bootstrap-2.0.3/docs/assets/js/bootstrap-popover.js"></script>
    <script src="http://docs.bootcss.com/bootstrap-2.0.3/docs/assets/js/bootstrap-button.js"></script>
    <script src="http://docs.bootcss.com/bootstrap-2.0.3/docs/assets/js/bootstrap-collapse.js"></script>
    <script src="http://docs.bootcss.com/bootstrap-2.0.3/docs/assets/js/bootstrap-carousel.js"></script>
    <script src="http://docs.bootcss.com/bootstrap-2.0.3/docs/assets/js/bootstrap-typeahead.js"></script>
    <script src="https://cdn.sheetjs.com/xlsx-latest/package/dist/xlsx.full.min.js"></script>
</head>
<body>
    <script src="source/js/g.js"></script>
    <jsp:include page="header.jsp" />
    <jsp:include page="${requestScope.path}" />
    <jsp:include page="footer.jsp" />
</body>
</html>