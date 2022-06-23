<!--Gajax-->
const Gajax = (method,url,async,json,fn)=>{
    let xhr = new XMLHttpRequest();
    xhr.open(method,url,async);
    xhr.setRequestHeader('Content-Type','application/json');
    xhr.send("json="+JSON.stringify(json));
    xhr.onreadystatechange = ()=>{
        if(xhr.readyState === 4 && xhr.status === 200){
            fn(xhr.responseText);
        }
    }
}
<!-- Gactive -->
document.body.onmousemove = ()=>{Gactive(5000);}
document.body.onkeydown = ()=>{Gactive(5000);}
let isActive = false,timer = null;
const Gactive = (delay)=>{
    isActive = true;
    if(timer)clearTimeout(timer);
    timer = setTimeout(()=>{isActive = false},delay);
}
setInterval(()=>{
    if(!isActive && !(window.location.href).endsWith("login")){
        Gajax('POST','check',true,{},(responseText)=>{
            if(!(Boolean)((JSON.parse(responseText)).isActive)){
                Gfresh();
            }
        });
    }
},1000);
const Gfresh = ()=>{window.location = window.location;}
<!--GJSON-->
var JSON_fromServer = {};
var JSON_fromClient = {};
var JSON_rule = {};
function JSONLength(obj) {let size = 0, key;for (key in obj) {if (obj.hasOwnProperty(key)) size++;}return size;}
function parseExcel(obj){
    // <input type="file" onchange="parseExcel(this)" />
    if(!obj.files) return;
    const IMPORTFILE_MAXSIZE = 10 * 1024 * 1024;
    let suffix = obj.files[0].name.split('.')[1];
    if(suffix !== 'xls' && suffix !== 'xlsx'){ console.log("导入文件类型错误"); return; }
    if(obj.files[0].size > IMPORTFILE_MAXSIZE){ console.log("导入文件不能大于10MB"); return; }
    JSON_fromClient = {};
    JSON_fromClient.SheetNames= [];
    JSON_fromClient.Sheets = {};
    let file = obj.files[0];
    let reader = new FileReader();
    let rABS = typeof FileReader !== "undefined" && (FileReader.prototype || {}).readAsBinaryString;
    rABS ? reader.readAsBinaryString(file) : reader.readAsArrayBuffer(file);
    reader.onload = (e)=>{
        let data = e.target.result;
        if(!rABS) data = new Uint8Array(data);
        let workbook = XLSX.read(data, {type: rABS ? 'binary' : 'array'});
        console.log(workbook);
        workbook.SheetNames.forEach(
            name=>{
                let json_1 = XLSX.utils.sheet_to_json(workbook.Sheets[name],{raw:false,header:1});
                let header = json_1[0];
                let json_2 = [];
                for(let i = 1; i < json_1.length; i++){
                    let raw = {};
                    for(let j in header){raw[header[j]] = json_1[i-1][j];}
                    json_2.push(raw);
                }
                JSON_fromClient.SheetNames.push(name);
                JSON_fromClient.Sheets[name] = json_2;
            }
        )
        console.log(JSON_fromClient);
    }
}
function downloadExcel(origin,ignore=true){
    let book = XLSX.utils.book_new();
    let getCellWidth = (value)=>{return value.toString().replace(/[\u0391-\uff35]/g,"aa").length};
    for(index in origin.SheetNames){
        let sheet_name = origin.SheetNames[index];
        let data = [];
        for(let i = 0; i < origin.Sheets[sheet_name].length; i++){
            let raw = [];
            for(let j in origin.Sheets[sheet_name][i]){raw.push(origin.Sheets[sheet_name][i][j]);}
            data.push(raw);
        }
        let sheet = XLSX.utils.aoa_to_sheet(data);
        let colwidths = [];
        let datacount = 0;
        data.forEach(row=>{
            let cnt = 0;
            datacount +=1;
            row.forEach((index)=>{
                if(index){
                    if(colwidths[cnt]===undefined)colwidths[cnt] = getCellWidth(index);
                    else colwidths[cnt] = Math.max(colwidths[cnt],getCellWidth(index));
                }
                cnt++;
            });
        });
        sheet['!cols'] = [];
        colwidths.forEach((width,index)=>{sheet['!cols'].push({wch:Math.max(width,10)});});
        if(!ignore || datacount>1)XLSX.utils.book_append_sheet(book,sheet,sheet_name);
    }
    XLSX.writeFile(book,'export'+JSON_self.accountNumber+'.xlsx');
}
function downloadJSON(){
    let status = false;
    Gajax("POST","download",true,{},(responseText)=>{
        let json = JSON.parse(responseText);
        JSON_fromServer.SheetNames = json.SheetNames;
        JSON_fromServer.Sheets = json.Sheets;
        JSON_rule = json.rule;
        status = true;
    });
    let timer = setInterval(()=>{
        if(status){
            clearInterval(timer);
        }
    },10);
}
function showTable(json){
    let thead = "<thead>"+createrow(json[0],true)+"</thead>";
    let tbody = "<tbody>";
    if(json.length>1){
        for(let i = 1; i < json.length; i++){tbody += createrow(json[i],false);}
        tbody += "</tbody>";
    }else{
        return "<div class='alert alert-success' style='margin:25px 10px;'>\u6682\u65e0\u5bf9\u5e94\u6570\u636e</div>";// 暂无对应数据
    }
    return thead+tbody;
}
function createrow(json,isheader=false){
    let row = "<tr>";
    let cnt = JSONLength(json)-1;
    for(let i in json){if(cnt--)row += "<td>"+json[i]+"</td>";}
    if(isheader)row += "<td></td>";
    else row += "<td style='text-align: center;'><button class='btn btn-mini' data-toggle='modal' data-target='#IndexModal' onclick='IndexModel(this,true)'>\u64cd\u4f5c</button></td>";
    row += "</tr>";
    return row;
}