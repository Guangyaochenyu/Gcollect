<%@ page import="com.edu.hrbu.infoengineering.gcollect.bean.Account" %>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<div class="navbar navbar-fixed-top ">
    <div class="navbar-inner">
        <div class="container-fluid">
            <a href="index"><img src="http://www.hrbu.edu.cn/img/logo.png" height="31" style="margin:8px" title="哈尔滨学院" alt="哈尔滨学院"/></a>
            <% if(request.getSession().getAttribute("account")!=null){ %>
            <div class="pull-right" style="margin:4px;">
                <%
                    String header_logout_btn_css = "";
                    Account account = (Account)session.getAttribute("account");
                    switch (account.getAccountAuthority()){
                        case 0: header_logout_btn_css = "btn btn-danger";break;
                        case 1: header_logout_btn_css = "btn btn-warning";break;
                        case 2: header_logout_btn_css = "btn btn-success";break;
                        case 3: header_logout_btn_css = "btn btn-info";break;
                        default: header_logout_btn_css = "btn btn-default";
                    }
                %>
                <button class="<%= header_logout_btn_css%>" data-toggle="modal" data-target="#LogoutModal">
                    <%=((Account)session.getAttribute("account")).getAccountName()%>
                </button>
            </div>
            <% } %>
        </div>
    </div>
</div>
<% if(session.getAttribute("account")!=null){ %>
<div class="modal fade" id="LogoutModal" tabindex="-1" role="dialog" aria-labelledby="LogoutModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×
                </button>
                <h4 class="modal-title" id="LogoutModalLabel">
                    确认登出
                </h4>
            </div>
            <div class="modal-body">
                是否确定退出登录？
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal" onclick="setTimeout(()=>{window.location.href='logout';},1000);">
                    确定
                </button>
            </div>
        </div>
    </div>
</div>
<% } %>