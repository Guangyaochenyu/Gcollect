<%@ page import="java.util.ArrayList" %>
<%@ page import="com.edu.hrbu.infoengineering.gcollect.bean.Account" %>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<div class="container-fluid">
    <%String index = (String) request.getAttribute("index");%>
    <%String pname = "默认页面";%>
    <div class="row-fluid">
        <div class="span2">
            <div class="well sidebar-nav">
                <ul class="nav nav-list">
                    <li class="nav-header">资料收集系统</li>
                    <% ArrayList<String> k = (ArrayList<String>)request.getAttribute("k");%>
                    <% ArrayList<String> v = (ArrayList<String>)request.getAttribute("v");%>
                    <% int kvsize = k.size();%>
                    <%for(int i=0;i<kvsize;i++){%>
                        <%if (index.equals(k.get(i)+".jsp")) {%>
                            <li class="active"><a>
                            <%pname = v.get(i);%>
                        <%} else {%>
                            <li><a href="<%=k.get(i)%>">
                        <%}%>
                            <%=v.get(i)%></a></li>
                    <%}%>
                </ul>
            </div>
        </div>
        <div class="span10">
            <div id="message">
                <%String message = (String) session.getAttribute("message");%>
                <script>
                    const message = (type,message,delay)=>{
                        let messagedom = document.getElementById("message");
                        messagedom.innerHTML = `
                        <div class="alert alert-`+type+`">
                            <a class="close" data-dismiss="alert" href="#">×</a>
                            `+message+`
                        </div>`;
                        messagedom.style.display = '';
                        let timer = setTimeout(function(){
                            clearTimeout(timer);
                            messagedom.style.display = "none";
                        },delay);
                    }
                    <%if (message != null) {%>
                        message("${sessionScope.messageType}","<%=message%>",3000);
                    <% session.removeAttribute("message");%>
                    <% session.removeAttribute("messageType");%>
                    <%}%>
                </script>
            </div>
            <div class="well">
                <h3>
                    <span class="pull-left"><%=pname%></span>
                    <% if(!index.equals("profile.jsp")){%>
                    <button class="btn btn-info pull-right" data-toggle="modal" data-target="#IndexModal" onclick="IndexModel(this,false)">插入</button>
                    <span class="divider pull-right">&nbsp;&nbsp;&nbsp;&nbsp;</span>
                    <button class="btn btn-success pull-right" onclick="message('danger','<strong>v0.6.47</strong> : 批量导入功能暂未开发',3000)">导入</button>
                    <script>
                        const IndexModel = (obj,isUpdate) => {
                            let modalBody = document.getElementById("IndexModelBody");
                            if(!isUpdate){
                                for(let i=1;i<IndexModelCount;i++){
                                    document.getElementById("IndexModelParam"+i).value=i===2?AccountId:'';
                                }
                                document.getElementById("IndexModelParam1").value=0;
                            }else{
                                obj = obj.parentNode.parentNode;
                                let IndexModelParamLength = obj.childNodes.length - 1;
                                for(let i=1;i<=IndexModelParamLength;i++){
                                    document.getElementById("IndexModelParam"+i).value = obj.childNodes[i-1].innerHTML;
                                }
                            }
                            let modalFooter = document.getElementById("IndexModalFooter");
                            if(!isUpdate){
                                modalFooter.innerHTML = IndexModelSubmitButton('primary','插入','insert');
                            }else{
                                modalFooter.innerHTML = IndexModelSubmitButton('success','更新','update') +
                                                        IndexModelSubmitButton('danger','删除','delete');
                            }
                        }
                    </script>
                    <%}%>
                </h3>
                <hr />
                <jsp:include page="${requestScope.index}"/>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="IndexModal" tabindex="-1" role="dialog" aria-labelledby="IndexModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form method='POST' action='<%=index.replace(".jsp","")%>' class="form-horizontal" id="IndexModalForm">
<%--    <form method='POST' action='test' class="form-horizontal" id="IndexModalForm">--%>
            <input type='hidden' name='Table' value='<%=index.replace(".jsp","")%>'/>
            <input type="hidden" name="action" id="IndexModalAction"/>
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title" style="text-align: center" id="IndexModalTitle"></h4>
                </div>
                <div class="modal-body" id="IndexModalBody"></div>
                <div class="modal-footer" id="IndexModalFooter"></div>
            </div>
        </form>
    </div>
</div>
<script>
    var JSON_self = <%=((Account)request.getSession().getAttribute("account")).toJSON()%>;
    downloadJSON();
    let JSONonLoadTimer = setInterval(()=>{
        console.log("WAIT...");
        if(JSON_fromServer.Sheets!==undefined){
            clearInterval(JSONonLoadTimer);
            console.log("OK!");
            <%if(!index.equals("profile.jsp")){%>
            table.innerHTML = showTable(JSON_fromServer.Sheets[pname]);
            IndexModelInit(pname);
            <%}%>
        }
    },500);
    <%if(!index.equals("profile.jsp")){%>
    var table = document.getElementById("table");
    var pname = '<%=pname%>';
    var AccountId = <%=((Account)session.getAttribute("account")).getAccountId()%>;
    var IndexModelCount = 0;

    const IndexModelInit = (pname) => {
        let modalTitle = document.getElementById("IndexModalTitle");
        let modalBody = document.getElementById("IndexModalBody");
        modalTitle.innerHTML = pname.replace("列表","");
        modalBody.innerHTML = IndexModelCreateForm(pname);
    }
    const IndexModelCreateForm = (pname) => {
        let labels = JSON_fromServer.Sheets[pname][0];
        str = ``;
        IndexModelCount = JSONLength(labels);let cnt=1;
        for(key in labels) {
            if(cnt===IndexModelCount)break;
            str+=`<div class="control-group `+(cnt===1?'hidden':'')+`">
                <label class="control-label" for="IndexModelParam`+cnt+`">`+labels[key]+`</label>
                <div class="controls">
                    <input type="text" class="input-xlarge" id="IndexModelParam`+cnt+`" name="`+key+`" placeholder="`+labels[key]+`">
                </div>
            </div>`;
            cnt+=1;
        }
        return str;
    }
    const IndexModelFillAction = (action) => {document.getElementById("IndexModalAction").value = action;}
    const IndexModelSubmitButton = (style,text,action)=>{return `<button type="submit" class="btn btn-`+style+`" onclick="IndexModelFillAction('`+action+`')">`+text+`</button>`};
    <%}%>
</script>