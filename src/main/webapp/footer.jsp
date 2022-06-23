<%@ page import="com.edu.hrbu.infoengineering.gcollect.bean.Account" %>
<%@ page import="com.edu.hrbu.infoengineering.gcollect.util.Storage" %>
<%@ page import="com.edu.hrbu.infoengineering.gcollect.util.Unicode" %>
<%@page contentType="text/html;charset=utf-8" language="java" pageEncoding="utf-8" %>
<div class="text-muted small navbar-fixed-bottom" >
    <div style="text-align: center;">
        <ul class="breadcrumb text-muted small navbar-fixed-bottom" style="margin: 0">
            <li>CopyRight © 2022 - 2023</li>
            <span class="divider">|</span>
            <li><a class="link-success" href="http://www.hrbu.edu.cn">Harbin University</a></li>
            <span class="divider">|</span>
            <li>All Rights Reserved.</li>
            <span class="divider">|</span>
            <% if(request.getSession().getAttribute("account")!=null){ %>
            <li class="small">
                <a href="logout">
                    <i class="icon-user"></i>
                    <%=((Account)request.getSession().getAttribute("account")).getAccountName()%>
                </a>
            </li>
            <span class="divider">|</span>
            <% } %>
            <li>点击量 : <%=request.getServletContext().getAttribute("PageView")%></li>
            <span class="divider">|</span>
            <li><a class="" href="http://time.tianqi.com/"><i class="icon-time"></i></a>
                <span id="footer-time"></span>
                <script>
                    const footerTime = ()=>{document.getElementById("footer-time").innerHTML = new Date().toLocaleString();setTimeout(()=>{footerTime()},1000);}
                    footerTime();
                </script>
            </li>
            <span class="divider">|</span>
            <li>
                <span class="">
                    <%=Unicode.toString(Storage.get("Author","Author1"))%>
                </span>
            </li>
            <span class="divider">&</span>
            <li>
                <span class="">
                    <%=Unicode.toString(Storage.get("Author","Author2"))%>
                </span>
            </li>
        </ul>
    </div>
</div>