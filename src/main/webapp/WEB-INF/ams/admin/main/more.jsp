<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- saved from url=(0025)http://www.xainfo.gov.cn/ -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"><HTML><HEAD>
<META content="IE=11.0000" http-equiv="X-UA-Compatible"/>

<META http-equiv="Content-Type" content="text/html; charset=gb2312"/>
<TITLE>延安科技网</TITLE>
<META name="keywords" content="延安市科技局，延安市科学技术局"/>
<META name="description" content="延安市科学技术局是延安市政府综合管理全市科技工作的职能部门，延安科技网是延安市科学技术局的官方网站。"/>
<LINK href="${pageContext.request.contextPath}/img/front/default.css" rel="stylesheet" type="text/css"/>
<!-- Link Swiper's CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin/swiper/swiper.min.css"/>
<script language="javascript" src="${pageContext.request.contextPath}/css/function.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/js/admin/jquery.js"></script>
<style>
  .swiper-container {
    width: 458px;
    height: 345px;
  }

  .swiper-slide {
    text-align: center;
    font-size: 18px;
    background: #fff;

    /* Center slide text vertically */
    display: -webkit-box;
    display: -ms-flexbox;
    display: -webkit-flex;
    display: flex;
    -webkit-box-pack: center;
    -ms-flex-pack: center;
    -webkit-justify-content: center;
    justify-content: center;
    -webkit-box-align: center;
    -ms-flex-align: center;
    -webkit-align-items: center;
    align-items: center;
  }
</style>
<META name="GENERATOR" content="MSHTML 11.00.10586.162">
<script type="application/javascript">
  function tags(slttit,sltcon,n){
    $(slttit).each(function(i){
      if(n == i){
        $(this).addClass("menuhover");
      }else{
        $(this).removeClass("menuhover");
      }
    });
    $(sltcon).each(function(i){
      if(n == i){
        $(this).show();
      }else{
        $(this).hide();
      }
    });
  }
</script>
</HEAD>

<BODY>
<LINK href="${pageContext.request.contextPath}/img/front/top.css" rel="stylesheet" type="text/css">
<TABLE width="100%" align="center" border="0" cellspacing="0" cellpadding="0">
  <TBODY>
  <TR>
    <TD height="26" style='background-image: url("${pageContext.request.contextPath}/img/front/top_bg.gif");'>
      <TABLE width="1004" align="center" border="0" cellspacing="0" cellpadding="0">
        <TBODY>
        <TR>
          <TD width="20"><IMG width="16" height="16"
                              src="${pageContext.request.contextPath}/img/front/icon_guohui.gif"></TD>
          <TD width="70"><A href="http://www.most.gov.cn/" target="_blank">科学技术部</A></TD>
          <TD width="20"><IMG width="16" height="16"
                              src="${pageContext.request.contextPath}/img/front/icon_guohui.gif"></TD>
          <TD width="70"><A href="http://www.sninfo.gov.cn/" target="_blank">陕西科技厅</A></TD>
          <TD width="20"><IMG width="16" height="16"
                              src="${pageContext.request.contextPath}/img/front/icon_guohui.gif"></TD>
          <TD width="95"><A href="http://www.yanan.gov.cn/" target="_blank">延安市人民政府</A></TD>
          <TD width="559" align="center">欢迎您访问延安市科学技术局官方网站！</TD>
          <TD width="20"><IMG width="16" height="16"
                              src="${pageContext.request.contextPath}/img/front/icon_home.gif"></TD>
          <TD width="60"><A href="${pageContext.request.contextPath}/admin/index.do">登录</A></TD>
          <TD width="20"><IMG width="16" height="16"
                              src="${pageContext.request.contextPath}/img/front/icon_fav.gif"></TD>
          <TD width="25" align="right"><A href="${pageContext.request.contextPath}/admin/register.do">注册</A>
          </TD>
        </TR>
        </TBODY>
      </TABLE>
    </TD>
  </TR>
  <TR>
    <TD height="160" style=''>
      <TABLE width="1004" align="center" border="0" cellspacing="0" cellpadding="0">
        <TBODY>
        <TR>
          <TD><IMG width="1004" height="160"
                   src="${pageContext.request.contextPath}/img/front/banner.jpg"></TD>
        </TR>
        </TBODY>
      </TABLE>
    </TD>
  </TR>
  </TBODY>
</TABLE>
<TABLE width="1004" align="center" border="0" cellspacing="0" cellpadding="0">
  <TBODY>
  <TR>
    <TD height="30" style=''>
      <TABLE width="100%" align="center" border="0" cellspacing="0" cellpadding="0">
        <TBODY>
        <TR>
          <TD width="10"></TD>
          <TD width="639" style="color: rgb(40, 40, 40);">
            <SCRIPT language="javascript">
              var today = new Date();
              var week = ["日", "一", "二", "三", "四", "五", "六"];
              document.write(today.getFullYear() + "年" + (today.getMonth() + 1) + "月" + today.getDate() + "日" + " 星期" + week[today.getDay()]);
            </SCRIPT>
          </TD>
          <TD width="355">
          </TD>
        </TR>
        </TBODY>
      </TABLE>
    </TD>
  </TR>
  </TBODY>
</TABLE>
<table width="1004" height="30" border="0" align="center" cellpadding="0" cellspacing="0" background="${pageContext.request.contextPath}/img/front/about_04.jpg">
  <tbody><tr>
    <td width="43" align="center"><img src="${pageContext.request.contextPath}/img/front/about_03.jpg" width="11" height="11"></td>
    <td width="961">您当前位置：首页 &gt;&gt;
    <c:if  test="${'1' eq type}">创新孵化服务</c:if>
      <c:if  test="${'2' eq type}">科技咨询服务</c:if>
      <c:if  test="${'3' eq type}">知识产权服务</c:if>
      <c:if  test="${'4' eq type}">科技金融服务</c:if>
      <c:if  test="${'5' eq type}">找场地</c:if>
      <c:if  test="${'6' eq type}">找资金</c:if>
      <c:if  test="${'7' eq type}">找代理</c:if>
      <c:if  test="${'8' eq type}">找培训</c:if>
    </td>
  </tr>
  </tbody></table>
<table border="0" cellpadding="0" cellspacing="0" width="1004" align="center">
  <tbody><tr>
    <td width="214" valign="top">
      <img src="${pageContext.request.contextPath}/img/front/about_24.jpg"><br>
      <table width="214" border="0" cellpadding="0" cellspacing="0">
        <tbody><tr><td height="3"></td></tr>
        <tr>
          <td height="26" background="${pageContext.request.contextPath}/img/front/about_05.jpg">
            <table width="160" border="0" align="center" cellpadding="0" cellspacing="0">
              <tbody><tr>
                <td width="20"><img src="${pageContext.request.contextPath}/img/front/m.gif" width="7" height="7"></td>
                <td width="140"><a href="/ams/index/more.do?type=1" target="_top" >创新孵化服务</a></td>
              </tr>
              </tbody></table>
          </td>
        </tr>
        <tr><td height="3"></td></tr>
        <tr>
          <td height="26" background="${pageContext.request.contextPath}/img/front/about_05.jpg">
            <table width="160" border="0" align="center" cellpadding="0" cellspacing="0">
              <tbody><tr>
                <td width="20"><img src="${pageContext.request.contextPath}/img/front/m.gif" width="7" height="7"></td>
                <td width="140"><a href="/ams/index/more.do?type=2" target="_top">科技咨询服务</a></td>
              </tr>
              </tbody></table>
          </td>
        </tr>
        <tr><td height="3"></td></tr>
        <tr>
          <td height="26" background="${pageContext.request.contextPath}/img/front/about_05.jpg">
            <table width="160" border="0" align="center" cellpadding="0" cellspacing="0">
              <tbody><tr>
                <td width="20"><img src="${pageContext.request.contextPath}/img/front/m.gif" width="7" height="7"></td>
                <td width="140"><a href="/ams/index/more.do?type=3" target="_top">知识产权服务</a></td>
              </tr>
              </tbody></table>
          </td>
        </tr>
        <tr><td height="3"></td></tr>
        <tr>
          <td height="26" background="${pageContext.request.contextPath}/img/front/about_05.jpg">
            <table width="160" border="0" align="center" cellpadding="0" cellspacing="0">
              <tbody><tr>
                <td width="20"><img src="${pageContext.request.contextPath}/img/front/m.gif" width="7" height="7"></td>
                <td width="140"><a href="/ams/index/more.do?type=4" target="_top">科技金融服务</a></td>
              </tr>
              </tbody></table>
          </td>
        </tr>
        <tr><td height="3"></td></tr>
        <tr>
          <td height="26" background="${pageContext.request.contextPath}/img/front/about_05.jpg">
            <table width="160" border="0" align="center" cellpadding="0" cellspacing="0">
              <tbody><tr>
                <td width="20"><img src="${pageContext.request.contextPath}/img/front/m.gif" width="7" height="7"></td>
                <td width="140"><a href="/ams/index/more.do?type=5" target="_top">找场地</a></td>
              </tr>
              </tbody></table>
          </td>
        </tr>
        <tr><td height="3"></td></tr>
        <tr>
          <td height="26" background="${pageContext.request.contextPath}/img/front/about_05.jpg">
            <table width="160" border="0" align="center" cellpadding="0" cellspacing="0">
              <tbody><tr>
                <td width="20"><img src="${pageContext.request.contextPath}/img/front/m.gif" width="7" height="7"></td>
                <td width="140"><a href="/ams/index/more.do?type=6" target="_top">找资金</a></td>
              </tr>
              </tbody></table>
          </td>
        </tr>
        <tr><td height="3"></td></tr>
        <tr>
          <td height="26" background="${pageContext.request.contextPath}/img/front/about_05.jpg">
            <table width="160" border="0" align="center" cellpadding="0" cellspacing="0">
              <tbody><tr>
                <td width="20"><img src="${pageContext.request.contextPath}/img/front/m.gif" width="7" height="7"></td>
                <td width="140"><a href="/ams/index/more.do?type=7" target="_top">找代理</a></td>
              </tr>
              </tbody></table>
          </td>
        </tr>
        <tr><td height="3"></td></tr>
        <tr>
          <td height="26" background="${pageContext.request.contextPath}/img/front/about_05.jpg">
            <table width="160" border="0" align="center" cellpadding="0" cellspacing="0">
              <tbody><tr>
                <td width="20"><img src="${pageContext.request.contextPath}/img/front/m.gif" width="7" height="7"></td>
                <td width="140"><a href="/ams/index/more.do?type=8" target="_top">找培训</a></td>
              </tr>
              </tbody></table>
          </td>
        </tr>
          <tr><td height="3"></td></tr>
        </tbody></table>
    </td>
    <td width="790" valign="top">
<table border="0" cellpadding="0" cellspacing="0" width="100%">
  <tbody><tr><td height="5" colspan="2"></td></tr>
  <tr>
    <c:if test="${page.totalPage > 0}">
      <td width="790" colspan="2" height="30" style="padding-left:20px;">
        第${page.currentPage}页 共${page.totalPage}页 <a href="/ams/index/more.do?type=${type}&currentPage=1" style="color:#0033CC;">首页</a>
        <c:if test="${page.currentPage - 1 <= 0}">
          <a href="javascript:;">上一页</a>
        </c:if>
        <c:if test="${page.currentPage - 1 > 0}" >
          <a href="/ams/index/more.do?type=${type}&currentPage=${page.currentPage - 1}" style="color:#0033CC;">下一页</a>
        </c:if>&nbsp;

        <c:if test="${page.currentPage + 1 >= page.totalPage}">
          <a href="javascript:;">下一页</a>
        </c:if>
        <c:if test="${page.currentPage + 1 < page.totalPage}" >
          <a href="/ams/index/more.do?type=${type}&currentPage=${page.currentPage + 1}" style="color:#0033CC;">下一页</a>
        </c:if>
        <a href="/ams/index/more.do?type=${type}&currentPage=${page.totalPage}" style="color:#0033CC;">末页</a>
      </td>
    </c:if>
  <c:if test="${page.totalPage <= 0}">
    <td width="790" colspan="2" height="30" style="padding-left:20px;">
        抱歉，该栏目暂无数据！
      </td>
  </c:if>
  </tr>
  <tr>
    <td width="5"></td>
    <td width="785" bgcolor="#f6fafd">
      <table>

        <tbody>
      <c:forEach var="obj" items="${page.resultList}">
        <tr>
          <td width="660">·<a href="/ams/index/news.do?id=${obj.id}" title="${obj.title}" target="_blank">${obj.title}</a>
            <span style="float:right;">[<fmt:formatDate value="${obj.createTime}" pattern="yyyy-MM-dd"/>]</span></td>
          <%--<td width="125" align="left">
            <a style="color:#0033CC;" href="http://www.xainfo.gov.cn/admin/class1.asp?text=%BF%C6%BC%BC%BE%D6%B9%AB%B8%E6">[科技局公告]</a></td>--%>
        </tr>
        </c:forEach>
        </tbody>
        </table>
  </td>
  </tr>
  </tbody>
  </table>
  </td>
  </tr>
  </tbody>
  </table>
</BODY>
</HTML>

