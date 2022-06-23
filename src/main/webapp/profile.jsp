<%@ page import="com.edu.hrbu.infoengineering.gcollect.bean.Account" %>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%Account account = (Account)request.getSession().getAttribute("account");%>
<%if(account.getAccountConfirmBit()==0){%>
<div class="alert fade in">
    <button class="close" data-dismiss="alert">×</button>
    <strong>注意:</strong> 请修改密码，以保证账户安全。
</div>
<%}%>
<form method="post" action="profile" class="form-horizontal">
    <fieldset>
        <div class="control-group">
            <label class="control-label" for="accountId">账号ID</label>
            <div class="controls">
                <input class="input-xlarge focused" id="accountId" name="AccountId" type="text" value="<%=account.getAccountId()%>" disabled>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="accountNumber">工号</label>
            <div class="controls">
                <input class="input-xlarge focused" id="accountNumber" name="AccountNumber" type="text" value="<%=account.getAccountNumber()%>" disabled>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="accountName">姓名</label>
            <div class="controls">
                <input class="input-xlarge focused" id="accountName" name="AccountName" type="text" value="<%=account.getAccountName()%>" >
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="accountPassword">密码</label>
            <div class="controls">
                <input class="input-xlarge focused" id="accountPassword" name="AccountPassword" type="password" value="<%=account.getAccountPassword()%>">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="accountAuthority">权限</label>
            <div class="controls">
                <input class="input-xlarge focused" id="accountAuthority" name="AccountAuthority" type="text" value="<%=account.getAccountAuthority()%>" disabled>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="accountPid">身份证号</label>
            <div class="controls">
                <input class="input-xlarge focused" id="accountPid" name="AccountPid" type="text" value="<%=account.getAccountPid()%>" >
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="accountDepartment">部门</label>
            <div class="controls">
                <input class="input-xlarge focused" id="accountDepartment" name="AccountDepartment" type="text" value="<%=account.getAccountDepartment()%>">
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="accountTitle">职称</label>
            <div class="controls">
                <input class="input-xlarge focused" id="accountTitle" name="AccountTitle" type="text" value="<%=account.getAccountTitle()%>">
            </div>
        </div>
        <div class="form-actions">
            <button type="submit" class="btn btn-primary">更新个人信息</button>
            <span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
            <button type="button" class="btn btn-success" onclick="Gfresh()">重置个人信息</button>
            <button type="button" class="btn btn-info pull-right" onclick="downloadExcel(JSON_fromServer,true)">导出信息</button>
<%--            <input type="file" onchange="parseExcel(this)" />--%>
        </div>
    </fieldset>
</form>