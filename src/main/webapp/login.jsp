<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<div class="container-fluid" style="margin-top: 100px;">
    <div class="span3"> . </div>
    <div class="span6">
        <form method="post" action="login" class="well form-horizontal">
            <fieldset>
                <legend class="text-muted mb-4" style="text-align: center">欢迎登录资料收集系统</legend>
                <% if(request.getAttribute("error") !=null){ %>
                <div class="container-fluid">
                    <div class="alert fade in span4">
                        <button class="close" data-dismiss="alert">×</button>
                        <strong>错误信息:</strong>${requestScope.error}
                    </div>
                </div>
                <% } %>
                <div class="control-group">
                    <label class="control-label" for="Number"><strong>工号</strong></label>
                    <div class="controls">
                        <input type="text" class="input-xlarge" id="Number" name="Number" placeholder="工号" required>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="Password"><strong>密码</strong></label>
                    <div class="controls">
                        <input type="text" class="input-xlarge" id="Password" name="Password" placeholder="密码" required>
                    </div>
                </div>
                <div class="form-actions">
                    <div class="btn-toolbar">
                        <div class="btn-group">
                            <button type="submit" class="btn btn-success">&nbsp;登&nbsp;录&nbsp;</button>
                        </div>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <div class="btn-group">
                            <button type="reset" class="btn btn-info">&nbsp;重&nbsp;置 &nbsp;</button>
                        </div>
                    </div>
                </div>
            </fieldset>
        </form>
        <pre class="prettyprint linenums">
测试用账号:(密码与账号相同)
管理员(权限0): root admin
院长(权限1): 20042134 20042120
教务处(权限2): 暂无
教师(权限3): 暂无
        </pre>
    </div>
    <div class="span3"> . </div>
</div>