<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <script src="http://localhost:18000/CLodopfuncs.js?priority=0"/>
    <script src="http://localhost:8000/CLodopfuncs.js?priority=1"></script>
    <object  id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0>
        <embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0></embed>
    </object>
</head>
</head>
<script type="text/javascript">
    var socket;
    if(!window.WebSocket){

        window.WebSocket = window.MozWebSocket;
    }

    if(window.WebSocket){
        socket = new WebSocket("ws://localhost:1331/websocket");

        socket.onmessage = function(event){
            alert(typeof(event.data));

            var ta = document.getElementById('responseText');
            ta.value += event.data+"\r\n";
        };

        socket.onopen = function(event){

            var ta = document.getElementById('responseText');
            ta.value = "打开WebSoket 服务正常，浏览器支持WebSoket!"+"\r\n";

        };

        socket.onclose = function(event){

            var ta = document.getElementById('responseText');
            ta.value = "";
            ta.value = "WebSocket 关闭"+"\r\n";
        };
    }else{
        alert("您的浏览器不支持WebSocket协议！");
    }

    function send(message){
        if(!window.WebSocket){return;}
        if(socket.readyState == WebSocket.OPEN){
            socket.send(message);
        }else{
            alert("WebSocket 连接没有建立成功！");
        }

    }

</script>
<script type="application/javascript">
    var LODOP = window.LODOP;
    function CheckIsInstall() {
        try{
//            var LODOP=getLodop();
            if (LODOP.VERSION) {
                if (LODOP.CVERSION)
                    alert("当前有C-Lodop云打印可用!\n C-Lodop版本:"+LODOP.CVERSION+"(内含Lodop"+LODOP.VERSION+")");
                else
                    alert("本机已成功安装了Lodop控件！\n 版本号:"+LODOP.VERSION);

            };
            LODOP.PRINT_INIT("你好");
            LODOP.ADD_PRINT_HTM(0,0,"100%","100%",document.documentElement.innerHTML);
            LODOP.PREVIEW();
        }catch(err){
        }
    };


    function createModel() {

//        LODOP.PRINT_INITA(0,0,665,600,"打印控件功能演示_Lodop功能_演示文档式模板生成和使用");
//        LODOP.ADD_PRINT_TEXT(83,78,75,20,"寄件人姓名");
//        LODOP.ADD_PRINT_TEXT(134,75,238,35,"寄件人的详细地址");
//        LODOP.ADD_PRINT_TEXT(83,212,100,20,"寄件人电话");
//        LODOP.ADD_PRINT_TEXT(85,391,75,20,"收件人姓名");
//        LODOP.ADD_PRINT_TEXT(140,388,244,35,"收件人详细地址");
//        LODOP.ADD_PRINT_TEXT(80,554,75,20,"收件人电话");
//        LODOP.ADD_PRINT_TEXT(207,87,165,20,"新加文本7");//
//        LODOP.ADD_PRINT_RECT(61,61,593,328,2,1);
//        LODOP.ADD_PRINT_ELLIPSE(322,315,100,60,0,1);
//        LODOP.ADD_PRINT_RECT(244,159,400,60,0,1);
//        LODOP.ADD_PRINT_TEXT(344,318,100,20,"这是什么");
//        LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
//        LODOP.ADD_PRINT_TEXT(257,244,237,31,"新加文本13的点点滴滴多多多");
//        LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
        LODOP.SET_SHOW_MODE("DESIGN_IN_BROWSE",1);
        LODOP.PRINT_DESIGN();
    }

    function modelStr() {
        if (LODOP.CVERSION) LODOP.On_Return=function(TaskID,Value){ alert(Value);document.getElementById('S1').value=Value;};
        document.getElementById('S1').value=LODOP.GET_VALUE("ProgramData",0);
    }

    function loadmodel() {
        LODOP.ADD_PRINT_DATA("ProgramData",document.getElementById('S1').value); //装载模板
        //按类名赋值
        LODOP.SET_PRINT_STYLEA("1", "CONTENT","张三");
        LODOP.SET_PRINT_STYLEA("2","CONTENT","北京昌平昌盛路XX号");
        LODOP.SET_PRINT_STYLEA("3","CONTENT","18612345678");
        LODOP.SET_PRINT_STYLEA("4","CONTENT","李四");
        LODOP.SET_PRINT_STYLEA("5","CONTENT","山东泰安市泰山区青年路28号银泰大厦");
        LODOP.SET_PRINT_STYLEA("6","CONTENT","15612345678");
        LODOP.SET_PRINT_STYLEA("7", "CONTENT","15612345678-1");
        LODOP.SET_PRINT_STYLEA("11", "CONTENT","15612345678-2");
        LODOP.SET_PRINT_STYLEA("12", "CONTENT","15612345678-3");
        LODOP.SET_SHOW_MODE("DESIGN_IN_BROWSE",1);
        LODOP.PRINT_DESIGN();
    }
</script>
<body>
<form onSubmit="return false;">
    <input type = "text" name="message" value="Netty The Sinper"/>
    <br/><br/>
    <input type="button" value="发送 WebSocket 请求消息" onClick="send(this.form.message.value)"/><br/>
    <input type="button" value="测试lodop" onClick="CheckIsInstall()"/><br/>
    <input type="button" value="生成模板" onClick="createModel()"/>
    <input type="button" value="模板ID" onClick="modelStr()"/>
    <input type="button" value="加载模板" onClick="loadmodel()"/>
    <hr color="blue"/>
    <h3>服务端返回的应答消息</h3>
    <textarea id="responseText" style="width: 1024px;height: 300px;"></textarea>
    <textarea id="S1"></textarea>
</form>
</body>
</html>

<!--
LODOP.PRINT_INITA(0,0,665,600,"打印控件功能演示_Lodop功能_演示文档式模板生成和使用");
LODOP.ADD_PRINT_TEXTA("jj_xm",83,78,75,20,"张三");
LODOP.ADD_PRINT_TEXTA("jj_dz",134,75,238,35,"北京昌平昌盛路XX号");
LODOP.ADD_PRINT_TEXTA("jj_dh",83,212,100,20,"18612345678");
LODOP.ADD_PRINT_TEXTA("sj_xm",85,391,75,20,"李四");
LODOP.ADD_PRINT_TEXTA("sj_dz",140,388,244,35,"山东泰安市泰山区青年路28号银泰大厦");
LODOP.ADD_PRINT_TEXTA("sj_dh",80,554,75,20,"15612345678");
LODOP.ADD_PRINT_TEXTA("hh",207,87,165,20,"15612345678-1");
LODOP.ADD_PRINT_RECT(61,61,593,328,2,1);
LODOP.ADD_PRINT_ELLIPSE(322,315,100,60,0,1);
LODOP.ADD_PRINT_RECT(244,159,400,60,0,1);
LODOP.ADD_PRINT_TEXTA("ee",344,318,100,20,"15612345678-2");
LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
LODOP.ADD_PRINT_TEXTA("gg",257,244,237,31,"15612345678-3");
LODOP.SET_PRINT_STYLEA(0,"Alignment",2);
-->