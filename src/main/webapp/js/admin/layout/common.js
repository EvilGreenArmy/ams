/**
 * Created by Evan on 2016/3/27.
 */
/**
 *Show error message.
 *Example data:{key:"value"}
 *Please modify it according to yourself UI need.
 *@param errorInfo is a JSON object containing key and value properties.
 *@return null
 */
$.ajaxSetup({cache:false,
    complete:function(XMLHttpRequest,textStatus){
        //通过XMLHttpRequest取得响应头，sessionstatus
        var sessionstatus=XMLHttpRequest.getResponseHeader("sessionstatus");
        if(sessionstatus=="timeout"){
           //这里跳转的登录页面
            window.location.href = "admin/index.do";

        }
    }
});

function showErrorMessage(errorInfo){
    //$('#info_box').hide();
    //$('#error_box').html('');
    //$('#error_box').show();
    var str = '';
    var count = 0;
    $.each(errorInfo,function(key,value){
        if(count>0){
            str+=',';
        }
        count++;
        str+=value;
    });
    var  data = str;
    $('#errorarea').show();
    if(str.indexOf('Error.unpass.permit.check') >= 0){
        data = "没有操作权限";
    }
    $('#errormsg').html(data);
}
/**
 * Redirect show error message.
 * @return
 */
function showErrorDirect(errorMessage){
    $('#error_box').html('');
    $('#error_box').show();
    $('#error_box').append(errorMessage);
}
/**
 * Hidden the error message box.
 * @return null
 */
function hidenErrorMessage(){
    $('#error_box').hide();
}
/**
 *@See Show error message.
 */
function showInfoMessage(inforMessage){
    $('#error_box').hide();
    $('#info_box').html('');
    $('#info_box').show();
    var count = 0;
    $.each(errorInfo,function(key,value){
        if(count>0){
            $('#info_box').append(',');
        }
        count++;
        $('#info_box').append(value);
    });
}
/**
 * @param actionUrl action URL
 * @param dataString post data string. example: name=value&key=value
 * @param resultArea The area for showing success page.
 * @return
 */

function postDataByURL(actionUrl,dataString,resultArea,doSuccess,doError){
    try{
        showProcess();
        $.ajax({
            type: "POST",
            url: actionUrl,
            data: dataString,
            dataType: "html",
            success: function(data,statuText,responseObj) {
                hiddenProcess();
                if(doSuccess){
                    eval(doSuccess);
                }
                if(data.indexOf('loginForm')>0){
                    window.location.reload();
                    return;
                }
                hidenErrorMessage();
                if(data.indexOf('错误') >= 0){
                    $('#errorarea').show();
                    if(data.indexOf('Error.unpass.permit.check') >= 0){
                        data = "没有操作权限";
                    }
                    if(data.indexOf('Error') >= 0){
                        data = data.substring(0, data.indexOf('Error'));
                    }
                    $('#errormsg').html("");
                    $('#errormsg').html(data);
                }else{
                    $('#'+resultArea).html("");
                    $('#'+resultArea).html(data);
                    $('#errormsg').html("");
                    $('#errorarea').hide();
                    try{
                        pageReload();
                    }catch(e){
                        //不处理
                    }
                }
                auto_heightleft();

            },
            error : function(msg) {
                hiddenProcess();
                if(doError){
                    eval(doError);
                }
                if((msg.status==3000)||(msg.status==500)){
                    var dataObj=eval("("+msg.responseText+")");
                    showErrorMessage(dataObj);
                    return;
                }else if(msg.status==0){
                    showErrorDirect(cannot_connect_server);
                }else{
                    $('#'+resultArea).html(msg.responseText);
                }
            }
        });
    }catch(e){
        hiddenProcess();
        alert('Find error:'+e);
    }
}

var mouseleft = 0;
var mousetop = 0;
document.onmousemove = mouseMove;
function mouseMove(e){
    if(!document.all){
        mouseleft=e.pageX;
        mousetop=e.pageY;
    }else if(event && document.body && document.body.scrollLeft){
        mouseleft=document.body.scrollLeft+event.clientX;
        mousetop=document.body.scrollTop+event.clientY;
    }

}

function showProcess(){
    showDiv("loading");

}
function hiddenProcess(){
    hideDiv("loading");
}

function showDiv(div_id) {
    if(!$("#"+div_id)[0]){
        $("<div id='"+div_id+"' style='display: none;'><img src='images/loading.gif' alt='正在加载.....' /></div>").appendTo("body");
    }
    var div_obj = $("#"+div_id);
    var windowWidth = document.body.clientWidth;
    var windowHeight = document.body.clientHeight;
    var popupHeight = div_obj.height();
    var popupWidth = div_obj.width();
    if(!$("#mask")[0]){
        $("<div id='mask' style='display: none; left: 0; top: 0'></div>").appendTo("body");
    }
    //添加并显示遮罩层
    $("#mask").css({"z-index":"99999","opacity":"0.6","display":"block","position": "absolute","background-color":"#fff"})
        .width(windowWidth)
        .height(windowHeight);
    // .click(function() {hideDiv(div_id); })
    //.fadeIn(100);
    div_obj.css({"z-index":"100000","position": "absolute","left":mouseleft,"top":mousetop,"display":"block"});
    //.animate({left: mouseleft, top: mousetop, opacity: "show" }, "fast");
}

function hideDiv(div_id) {
    $("#mask").css({"display":"none"});
    $("#" + div_id).css({"display":"none"});//.animate({left: 0, top: 0, opacity: "hide" }, "slow");
}

/**
 * Post data by AJAX
 * @param formName the form name
 * @param resultArea The area for showing success page.
 * @return null
 */

function postDataByFormName(formName,resultArea,doSuccess,doError){
    var dataString = $("#"+formName).serialize();
    actionUrl = $("#"+formName)[0].action;
    postDataByURL(actionUrl,dataString,resultArea,doSuccess,doError);
}
/**
 * Post data for delete
 * @param formName the form name
 * @param actionUrl Action URL
 * @param resultArea The area for showing success page.
 * @return
 */
function postDataForDelete(formName,actionUrl,resultArea){
    var dataString = $("#"+formName).serialize();
    postDataByURL(actionUrl,dataString,resultArea);
}
/**
 * Get data by URL.
 * @param actionURL Action URL
 * @param dataString Post data string
 * @param resultArea The area for showing success page.
 * @return
 */
function getData(actionUrl,dataString,resultArea,doSuccess){
    try{
        if(actionUrl.indexOf("?") != -1) {
            actionUrl = actionUrl + '&t=' + new Date().getTime();
        } else {
            actionUrl = actionUrl + '?t=' + new Date().getTime();
        }
        $('#errorarea').hide();
        showProcess();
        $.ajax({
            type: "GET",
            url: actionUrl,
            data: dataString,
            dataType: "html",
            success: function(data,statuText,responseObj) {
                hiddenProcess();
                if(this.url.indexOf('actionMethod=logout')>0){
                    window.location.reload();
                    return;
                }
                if(data.indexOf('loginForm')>0){
                    window.location.reload();
                    return;
                }
                hidenErrorMessage();
                if(data.indexOf('错误') >= 0){
                    $('#errorarea').show();
                    if(data.indexOf('Error.unpass.permit.check') >= 0){
                        data = "没有操作权限";
                    }
                    if(data.indexOf('Error') >= 0){
                        data = data.substring(0, data.indexOf('Error'));
                    }
                    $('#errormsg').html("");
                    $('#errormsg').html(data);
                }else{
                    $('#'+resultArea).html("");
                    $('#'+resultArea).html(data);
                    $('#errormsg').html("");
                    $('#errorarea').hide();
                }
                auto_heightleft();
                if(doSuccess){
                    eval(doSuccess);
                }
            },
            error : function(msg) {
                hiddenProcess();
                if((msg.status==3000)||(msg.status==500)){
                    var dataObj=eval("("+msg.responseText+")");
                    showErrorMessage(dataObj);
                    //$('#'+resultArea).html("");
                    return;
                }else  if(msg.status==0){
                    showErrorDirect(cannot_connect_server);
                    //$('#'+resultArea).html("");
                }
                else{
                    $('#'+resultArea).html(msg.responseText);
                }
            },
            headers: {
                "If-Modified-Since":"0",
                "Cache-Control":"no-cache"
            }
        });
    }catch(e){
        alert('Find error:'+e);
    }
}
/**
 *Used for previous page or next page query.
 * @param formName Form name
 * @return
 */
function changePage(formName){
    postDataByFormName(formName,'workspace');
}

function changePostPage(formName){
    document.forms[1].submit();
}
/***
 * @param formName the form name
 * @param methodName Method name
 * @return urlString
 */
function getActionUrl(formName,methodName){
    var urlString = document.forms[formName].action;
    if(urlString.indexOf("actionMethod=")>0){
        postion = urlString.indexOf("&",urlString.indexOf("actionMethod="));
        if(postion<0){
            postion = urlString.length - 1;
        }
        urlString = urlString.substring(0,urlString.indexOf("actionMethod="))+urlString.substring(postion);
    }
    urlString = urlString+(urlString.indexOf("?")>0?"&":"?")+"actionMethod="+methodName;
    return urlString;
}
/***
 *
 * @param formName the form name
 * @param resultArea The area for showing success page.
 * @return
 */
function deleteDatas(formName,resultArea){
    var checkName = getCheckName(formName);
    if(checkName==''){
        return ;
    }
    var checkValue = getCheckValue(checkName);
    if(!checkValue){
        jAlert(msg_delete_select);
        return;
    }
    jConfirm(msg_delete_warn,null,function(result){
        if(result){
            postDataForDelete(formName,getActionUrl(formName,'delete'),resultArea);
        }
    });
}
function deleteData(actionUrl,dataString,resultArea){
    jConfirm(msg_delete_warn,null,function(result){
        if(result){
            postDataByURL(actionUrl,dataString,resultArea);
        }
    });
}

function trimForm(formName){
    for(var i=0;i<document.forms[formName].elements.length;i++){
        var formField = document.forms[formName].elements[i];
        var formFieldType=formField.type;
        if(formFieldType=="text"||formFieldType=="hidden"||formFieldType=="select"||formFieldType=="textarea"){
            if(formField.value!=null&&formField.value.length>0){
                formField.value = formField.value.trim();
            }
        }
    }
}

//Div自适应高度
function auto_heightleft(){
    var a=document.getElementById("cntleftdiv");
    var b=document.getElementById("cntrightdiv");
    if(a != null){
        a.style.height = '600px';
        if(a.clientHeight<b.clientHeight){
            a.style.height=b.clientHeight+"px";
        }else{
            //b.style.height=a.clientHeight+"px";
        }
    }
}

function isSelectData(checkName){
    var checkValue = getCheckValue(checkName);
    if(checkValue==""||checkValue=="undefine"||checkValue==null){
        alert("没有选择任何数据!");
        return false;
    }
    return true;
}

function isMultiSelectData(checkName){
    var checkList = document.getElementsByName(checkName);
    var totalChecked = 0;
    for(var i=0;i<checkList.length;i++){
        if(checkList[i].checked){
            totalChecked++;
        }
    }
    if(totalChecked>1){
        alert("不能选择多个进行修改！");
        return false;
    }
    return true;
}

function pageEditData(url,param,value,area){
    var queryParam="";
    var checkList = document.getElementsByName(value);
    for(var i=0;i<checkList.length;i++){
        if(checkList[i].checked){
            queryParam = queryParam + param+'='+checkList[i].value + "&";
        }
    }
    queryParam = queryParam.substring(0, queryParam.length-1);
    if(queryParam != ''){
        getData(url,queryParam,area);
    }
}

function clearFormById(formId,n){
    $.each($("#"+formId+" :input"),function(i,o){
        if(i<n)
            o.value="";
    });
}

function getCheckValue(checkName){
    var checkValue="";
    var checkList = document.getElementsByName(checkName);
    for(var i=0;i<checkList.length;i++){
        if(checkList[i].checked){
            checkValue = checkList[i].value;
            break;
        }
    }
    return checkValue;
}
function replaceFormById(formId,n){
    $.each($("#"+formId+" :input"),function(i,o){
        if(i<n){
            var cutValue = replaceQueryHtml(o.value);
            o.value = cutValue ;
        }
    });
}
function replaceQueryHtml(content){
    if(content == null){
        return "" ;
    }
    var html = content ;
    html = html.replace("&", "&amp;");
    html = html.replace("\"", "&quot;");  //"
    html = html.replace("\t", "&nbsp;&nbsp;");// 替换跳格
    html = html.replace(" ", "&nbsp;");// 替换空格
    html = html.replace("<", "&lt;");
    html = html.replace("\'", "&#39;");
    html = html.replace( ">", "&gt;");

    return html;
}


