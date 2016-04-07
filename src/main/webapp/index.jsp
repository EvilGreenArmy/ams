<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- saved from url=(0025)http://www.xainfo.gov.cn/ -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"><HTML><HEAD><META
content="IE=11.0000" http-equiv="X-UA-Compatible">

<META http-equiv="Content-Type" content="text/html; charset=gb2312">
<TITLE>延安科技网</TITLE>
<META name="keywords" content="延安市科技局，延安市科学技术局">
<META name="description" content="延安市科学技术局是延安市政府综合管理全市科技工作的职能部门，延安科技网是延安市科学技术局的官方网站。">
<LINK href="${pageContext.request.contextPath}/img/front/default.css" rel="stylesheet" type="text/css">
<!-- Link Swiper's CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin/swiper/swiper.min.css">
<SCRIPT language="javascript" src="css/function.js"></SCRIPT>
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
<META name="GENERATOR" content="MSHTML 11.00.10586.162"></HEAD>
<BODY><LINK href="${pageContext.request.contextPath}/img/front/top.css" rel="stylesheet" type="text/css">
<TABLE width="100%" align="center" border="0" cellspacing="0" cellpadding="0">
    <TBODY>
    <TR>
        <TD height="26" style='background-image: url("${pageContext.request.contextPath}/image/top_bg.gif");'>
            <TABLE width="1004" align="center" border="0" cellspacing="0" cellpadding="0">
                <TBODY>
                <TR>
                    <TD width="20"><IMG width="16" height="16" src="${pageContext.request.contextPath}/img/front/icon_guohui.gif"></TD>
                    <TD width="70"><A href="http://www.most.gov.cn/" target="_blank">科学技术部</A></TD>
                    <TD width="20"><IMG width="16" height="16" src="${pageContext.request.contextPath}/img/front/icon_guohui.gif"></TD>
                    <TD width="70"><A href="http://www.sninfo.gov.cn/" target="_blank">陕西科技厅</A></TD>
                    <TD width="20"><IMG width="16" height="16" src="${pageContext.request.contextPath}/img/front/icon_guohui.gif"></TD>
                    <TD width="95"><A href="http://www.yanan.gov.cn/" target="_blank">延安市人民政府</A></TD>
                    <TD width="559" align="center">欢迎您访问延安市科学技术局（延安市知识产权局）官方网站！</TD>
                    <TD width="20"><IMG width="16" height="16" src="${pageContext.request.contextPath}/img/front/icon_home.gif"></TD>
                    <TD width="60"><A href="${pageContext.request.contextPath}/admin/index.do">登录</A></TD>
                    <TD width="20"><IMG width="16" height="16" src="${pageContext.request.contextPath}/img/front/icon_fav.gif"></TD>
                    <TD width="25" align="right"><A href="${pageContext.request.contextPath}/admin/register.do">注册</A>
                    </TD>
                </TR></TBODY></TABLE></TD></TR>
    <TR>
        <TD height="160" style=''>
            <TABLE width="1004" align="center" border="0" cellspacing="0" cellpadding="0">
                <TBODY>
                <TR>
                    <TD><IMG width="1004" height="160"
                             src="${pageContext.request.contextPath}/img/front/banner.jpg"></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE>
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
                            var today=new Date();
                            var week=["日","一","二","三","四","五","六"];
                            document.write(today.getFullYear()+"年"+(today.getMonth()+1)+"月"+today.getDate()+"日"+" 星期"+week[today.getDay()]);
                        </SCRIPT>
                    </TD>
                    <TD width="355">
                    </TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE>
<TABLE width="1004" align="center" border="0" cellspacing="0" cellpadding="0">
    <TBODY>
    <TR>
        <TD><A href="http://www.xainfo.gov.cn/admin/2015syss/index.asp" target="_blank"><IMG
                width="1004" height="70" src="${pageContext.request.contextPath}/img/front/2015syss.jpg"></A></TD></TR>
    <TR>
        <TD height="5"></TD></TR></TBODY></TABLE>
<TABLE width="1004" align="center" border="0" cellspacing="0" cellpadding="0">
    <TBODY>
    <TR>
        <TD height="5"></TD></TR>
    <TR>
        <TD><A href="http://www.xainfo.gov.cn/admin/2015sc/index.asp" target="_blank"><IMG
                width="1004" height="70" src="${pageContext.request.contextPath}/img/front/zckj.png"></A></TD></TR>
    <TR>
        <TD height="5"></TD></TR></TBODY></TABLE>
<TABLE width="1004" align="center" border="0" cellspacing="0" cellpadding="0">
    <TBODY>
    <TR>
        <TD>
            <TABLE width="100%" align="center" border="0" cellspacing="0" cellpadding="0">
                <TBODY>
                <TR>
                    <TD>
                        <TABLE width="100%" align="center" border="0" cellspacing="0"
                               cellpadding="0">
                            <TBODY>
                            <TR>
                                <TD width="458" class="border" valign="top" style="border-top-color: currentColor; border-top-width: 0px; border-top-style: none;">
                                    <TABLE width="100%" align="center" border="0" cellspacing="0"
                                           cellpadding="0">
                                        <TBODY>
                                        <TR>
                                            <TD>
                                                <!-- Swiper -->
                                                <div class="swiper-container">
                                                    <div class="swiper-wrapper">
                                                        <div class="swiper-slide">
                                                            <img style="width: 455px;height: 380px;" src="${pageContext.request.contextPath}/img/admin/swiper/swiper_1.jpg" />
                                                        </div>
                                                        <div class="swiper-slide">
                                                            <img style="width: 455px;height: 380px;" src="${pageContext.request.contextPath}/img/admin/swiper/swiper_2.jpg" />
                                                        </div>
                                                        <div class="swiper-slide">
                                                            <img style="width: 455px;height: 380px;" src="${pageContext.request.contextPath}/img/admin/swiper/swiper_3.jpg" />
                                                        </div>
                                                        <div class="swiper-slide">
                                                            <img style="width: 455px;height: 380px;" src="${pageContext.request.contextPath}/img/admin/swiper/swiper_4.jpg" />
                                                        </div>
                                                        <div class="swiper-slide">
                                                            <img style="width: 455px;height: 380px;" src="${pageContext.request.contextPath}/img/admin/swiper/swiper_5.jpg" />
                                                        </div>
                                                        <%--<div class="swiper-slide">Slide 6</div>
                                                        <div class="swiper-slide">Slide 7</div>
                                                        <div class="swiper-slide">Slide 8</div>
                                                        <div class="swiper-slide">Slide 9</div>
                                                        <div class="swiper-slide">Slide 10</div>--%>
                                                    </div>
                                                    <!-- Add Pagination -->
                                                    <div class="swiper-pagination"></div>
                                                    <!-- Add Arrows -->
                                                    <div class="swiper-button-next"></div>
                                                    <div class="swiper-button-prev"></div>
                                                </div>

                                                <!-- Swiper JS -->
                                                <script src="${pageContext.request.contextPath}/js/admin/swiper/swiper.min.js"></script>

                                                <!-- Initialize Swiper -->
                                                <script>
                                                    var swiper = new Swiper('.swiper-container', {
                                                        pagination: '.swiper-pagination',
                                                        paginationClickable: '.swiper-pagination',
                                                        nextButton: '.swiper-button-next',
                                                        prevButton: '.swiper-button-prev',
                                                        spaceBetween: 30,
                                                        autoplay: 2500
                                                    });
                                                </script>
                                            </TD>
                                        </TR></TBODY></TABLE></TD>
                                <TD width="5"></TD>
                                <TD width="517" class="border" valign="top" style="background: rgb(255, 255, 255); padding: 0px 10px;">
                                    <TABLE width="100%" align="center" border="0" cellspacing="0"
                                           cellpadding="0">
                                        <TBODY>
                                        <TR>
                                            <TD height="10"></TD></TR>
                                        <TR>
                                            <TD>
                                                <TABLE width="100%" align="center" border="0"
                                                       cellspacing="0" cellpadding="0">
                                                    <TBODY>
                                                    <TR>
                                                        <TD>
                                                            <DIV class="tags_kjdt_title">
                                                                <UL>
                                                                    <LI class="menuhover" id="tags_kjdt_title1" onmouseover="tags(1,5,'tags_kjdt',0)">科技成果</LI>
                                                                    <LI id="tags_kjdt_title2" onmouseover="tags(2,5,'tags_kjdt',0)">科技专利</LI>
                                                                </UL></DIV>
                                                            <DIV class="tags_kjdt_con" id="tags_kjdt_con1" style="display: block;">
                                                                <UL>
                                                                    <LI><SPAN>[2016-04-01]</SPAN><IMG width="9" height="9" src="${pageContext.request.contextPath}/img/front/doth.gif">
                                                                        <A title="关于2015年度企业研发费用加计扣除项目鉴定工作"
                                                                                                                                                href="/ams/admin/productDetail.do?id=13598"
                                                                                                                                                target="_blank">新型的竹木混合地板</A></LI>
                                                                    <LI><SPAN>[2016-04-01]</SPAN><IMG width="9"
                                                                                                      height="9" src="${pageContext.request.contextPath}/img/front/doth.gif"> <A title="关于组织申报2016年延安市级众创空间认定"
                                                                                                                                                href="/ams/admin/productDetail.do?id=13596"
                                                                                                                                                target="_blank">西部低碳生活体验旅游项目</A></LI>
                                                                    <LI><SPAN>[2016-03-30]</SPAN><IMG width="9"
                                                                                                      height="9" src="${pageContext.request.contextPath}/img/front/doth.gif"> <A title="延安市科学技术局关于2015年度市级众创空间考核结果公示"
                                                                                                                                                href="/ams/admin/productDetail.do?id=13588"
                                                                                                                                                target="_blank">城市生活垃圾及年产5万吨有机复混肥项目</A></LI>
                                                                    <LI><SPAN>[2016-03-23]</SPAN><IMG width="9"
                                                                                                      height="9" src="${pageContext.request.contextPath}/img/front/doth.gif"> <A title="关于开展2016年度延安市科技企业孵化器认定工作"
                                                                                                                                                href="/ams/admin/productDetail.do?id=13580"
                                                                                                                                                target="_blank">年产10万吨小麦专用粉及生物功能食品项目</A></LI>
                                                                    <LI><SPAN>[2016-03-21]</SPAN><IMG width="9"
                                                                                                      height="9" src="${pageContext.request.contextPath}/img/front/doth.gif"> <A title="关于开展2016年度第一批延安市高新技术企业认定工作"
                                                                                                                                                href="/ams/admin/productDetail.do?id=13579"
                                                                                                                                                target="_blank">年产1万吨脱水真空包装绿色蔬菜项目</A></LI>
                                                                    <LI><SPAN>[2016-03-16]</SPAN><IMG width="9"
                                                                                                      height="9" src="${pageContext.request.contextPath}/img/front/doth.gif"> <A title="延安市科学技术局  延安市财政局关于印发延安市支持市级众创空间发展的若干措施（试行）"
                                                                                                                                                href="/ams/admin/productDetail.do?id=13578"
                                                                                                                                                target="_blank">年产30万吨酒糟和秸秆混合发酵蛋白饲料项目 ...</A></LI>
                                                                    <LI><SPAN>[2016-03-10]</SPAN><IMG width="9"
                                                                                                      height="9" src="${pageContext.request.contextPath}/img/front/doth.gif"> <A title="延安市科学技术局关于组织推荐陕西省2016年创新人才推进计划的通知"
                                                                                                                                                href="/ams/admin/productDetail.do?id=13570"
                                                                                                                                                target="_blank">年产10万吨小麦专用粉及生物功能食品项目</A></LI>
                                                                    <LI><SPAN>[2016-03-10]</SPAN><IMG width="9"
                                                                                                      height="9" src="${pageContext.request.contextPath}/img/front/doth.gif"> <A title="关于公布第三批文化和科技融合示范园区示范企业的通知"
                                                                                                                                                href="/ams/admin/productDetail.do?id=13569"
                                                                                                                                                target="_blank">濮阳开发区科技城标准厂房招商项目</A></LI>
                                                                    <LI><SPAN>[2016-03-07]</SPAN><IMG width="9"
                                                                                                      height="9" src="${pageContext.request.contextPath}/img/front/doth.gif"> <A title="延安市人民政府关于2015年度市科学技术奖励的决定"
                                                                                                                                                href="/ams/admin/productDetail.do?id=13564"
                                                                                                                                                target="_blank">桦褐孔菌抗癌、降血糖及抗爱滋病的研究</A></LI>
                                                                    <LI><SPAN>[2016-03-04]</SPAN><IMG width="9"
                                                                                                      height="9" src="${pageContext.request.contextPath}/img/front/doth.gif"> <A title="延安市科学技术局2016年度工作要点"
                                                                                                                                                href="/ams/admin/productDetail.do?id=13560"
                                                                                                                                                target="_blank">蔬菜常见病害的农药防治方法</A></LI>
                                                                    </UL></DIV>
                                                            <DIV class="tags_kjdt_con" id="tags_kjdt_con2" style="display: none;">
                                                                <UL>
                                                                    <LI><SPAN>[2016-02-25]</SPAN><IMG width="9"
                                                                                                      height="9" src="${pageContext.request.contextPath}/img/front/doth.gif"> <A title="市科技局众创空间工作会议召开"
                                                                                                                                                href="/ams/admin/productDetail.do?id=13555"
                                                                                                                                                target="_blank">市科技局众创空间工作会议召开</A></LI>
                                                                    <LI><SPAN>[2016-02-14]</SPAN><IMG width="9"
                                                                                                      height="9" src="${pageContext.request.contextPath}/img/front/doth.gif"> <A title="市科技局组织春节后收假收心教育"
                                                                                                                                                href="/ams/admin/productDetail.do?id=13534"
                                                                                                                                                target="_blank">市科技局组织春节后收假收心教育</A></LI>
                                                                    <LI><SPAN>[2015-12-28]</SPAN><IMG width="9"
                                                                                                      height="9" src="${pageContext.request.contextPath}/img/front/doth.gif"> <A title="市科技局组织召开领导班子“三严三实”专题民主生活会"
                                                                                                                                                href="/ams/admin/productDetail.do?id=13474"
                                                                                                                                                target="_blank">市科技局组织召开领导班子“三严三实”专题民主生活会</A></LI>
                                                                    <LI><SPAN>[2015-12-28]</SPAN><IMG width="9"
                                                                                                      height="9" src="${pageContext.request.contextPath}/img/front/doth.gif"> <A title="延安市通过国家知识产权示范城市复核"
                                                                                                                                                href="/ams/admin/productDetail.do?id=13473"
                                                                                                                                                target="_blank">延安市通过国家知识产权示范城市复核</A></LI>
                                                                    <LI><SPAN>[2015-12-22]</SPAN><IMG width="9"
                                                                                                      height="9" src="${pageContext.request.contextPath}/img/front/doth.gif"> <A title="局系统举办财务业务法规培训"
                                                                                                                                                href="/ams/admin/productDetail.do?id=13470"
                                                                                                                                                target="_blank">局系统举办财务业务法规培训</A></LI>
                                                                    <LI><SPAN>[2015-12-18]</SPAN><IMG width="9"
                                                                                                      height="9" src="${pageContext.request.contextPath}/img/front/doth.gif"> <A title="推动知识产权质押融资  拓宽科技企业融资途径"
                                                                                                                                                href="/ams/admin/productDetail.do?id=13465"
                                                                                                                                                target="_blank">推动知识产权质押融资  拓宽科技企业融资途径</A></LI>
                                                                    <LI><SPAN>[2015-12-08]</SPAN><IMG width="9"
                                                                                                      height="9" src="${pageContext.request.contextPath}/img/front/doth.gif"> <A title="延安软件企业国税政策和科技金融服务讲解会顺利召开"
                                                                                                                                                href="/ams/admin/productDetail.do?id=13445"
                                                                                                                                                target="_blank">延安软件企业国税政策和科技金融服务讲解会顺利召开</A></LI>
                                                                    <LI><SPAN>[2015-12-04]</SPAN><IMG width="9"
                                                                                                      height="9" src="${pageContext.request.contextPath}/img/front/doth.gif"> <A title="延安市科学技术局2015年度政府信息公开工作总体情况"
                                                                                                                                                href="/ams/admin/productDetail.do?id=13436"
                                                                                                                                                target="_blank">延安市科学技术局2015年度政府信息公开工作总体情况</A></LI>
                                                                    <LI><SPAN>[2015-12-04]</SPAN><IMG width="9"
                                                                                                      height="9" src="${pageContext.request.contextPath}/img/front/doth.gif"> <A title="2015延安文化科技融合培训会召开"
                                                                                                                                                href="/ams/admin/productDetail.do?id=13430"
                                                                                                                                                target="_blank">2015延安文化科技融合培训会召开</A></LI>
                                                                    <LI><SPAN>[2015-12-04]</SPAN><IMG width="9"
                                                                                                      height="9" src="${pageContext.request.contextPath}/img/front/doth.gif"> <A title="2015延安文化科技融合交流会召开"
                                                                                                                                                href="/ams/admin/productDetail.do?id=13429"
                                                                                                                                                target="_blank">2015延安文化科技融合交流会召开</A></LI>
                                                                    <LI><SPAN><A href="http://www.xainfo.gov.cn/admin/class1.asp?text=科技工作信息"
                                                                                 target="_blank">更多&gt;&gt;</A></SPAN></LI></UL></DIV>
                                                        </TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE></TD></TR></TBODY></TABLE>
<TABLE width="1004" align="center" border="0" cellspacing="0" cellpadding="0">
    <TBODY>
    <TR>
        <TD height="5"></TD></TR>
    <TR>
        <TD><A href="http://www.xainfo.gov.cn/admin/2014xjr/index.asp" target="_blank"><IMG
                width="1004" height="70" src="${pageContext.request.contextPath}/img/front/banner_xjr.jpg"></A></TD></TR>
    <TR>
        <TD height="5"></TD></TR></TBODY></TABLE><!--<table width="1004" border="0" cellpadding="0" cellspacing="0"align="center">
	<tr><td height="5" colspan="3"></td></tr>
	<tr id="tab1" style="display:block;">
		<td width="500"><a href="http://www.xainfo.gov.cn/admin/2015ffdj/index.asp" target="_blank"><img src="image/ffjz.jpg" width="500" height="70" /></a></td>
		<td width="4"></td>
		<td width="500"><a href="http://www.xainfo.gov.cn/admin/2015azb/index.asp" target="_blank"><img src="image/azb.jpg" width="500" height="70" /></a></td>
	</tr>
	<tr id="tab2" style="display:none;"><td colspan="3"><a href="http://news.cntv.cn/special/kzsl70zn/index.shtml" target="_blank"><img src="image/krzz.png" width="1004" height="70" /></a></td></tr>
	<tr><td height="5" colspan="3"></td></tr>
</table>-->
<TABLE width="1004" align="center" border="0" cellspacing="0" cellpadding="0">
    <TBODY>
    <TR>
        <TD>
            <TABLE width="100%" align="center" border="0" cellspacing="0" cellpadding="0">
                <TBODY>
                <TR>
                    <TD height="80" align="center">
                        <SCRIPT type="text/javascript">document.write(unescape("%3Cspan id='_ideConac' %3E%3C/span%3E%3Cscript src='http://dcs.conac.cn/js/27/386/0000/60400486/CA273860000604004860001.js' type='text/javascript'%3E%3C/script%3E"));</SCRIPT>
                    </TD></TR>
                <TR>
                    <TD height="20" align="center"
                        style="color: rgb(40, 40, 40);">版权所有：延安市科学技术局 延安市知识产权局</TD></TR>
                <TR>
                    <TD height="20" align="center"
                        style="color: rgb(40, 40, 40);">技术支持：延安市科学技术信息研究所 网络信息中心</TD></TR>
                <TR>
                    <TD height="20" align="center" style="color: rgb(40, 40, 40); font-family: Arial,Helvetica,sans-serif;">Copyright &copy; 2016-2016 Yanan Science Technology Bureau, All Rights Reserved</TD></TR>
                <TR>
                    <TD height="20" align="center"><A style="color: rgb(40, 40, 40);" href="http://www.miibeian.gov.cn/" target="_blank">备案序号：陕ICP备06008550号</A>
                        <SCRIPT language="JavaScript" src="http://s175.cnzz.com/stat.php?id=1882140&amp;web_id=1882140&amp;show=pic" charset="gb2312"></SCRIPT>
                    </TD></TR>
                <TR>
                    <TD height="15"></TD>
                </TR>
                </TBODY>
            </TABLE>
        </TD>
    </TR>
    </TBODY>
</TABLE>
</BODY>
</HTML>

