<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>科技成果交易撮合系统登录</title>
    <!-- BOOTSTRAP STYLES-->
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="${pageContext.request.contextPath}/css/font-awesome.css" rel="stylesheet" />

</head>
<body style="background-color: #E2E2E2;">
<div class="container">
    <div class="row text-center " style="padding-top:100px;">
        <div class="col-md-12">
            <%--<img src="${pageContext.request.contextPath}/img/logo-invoice.png" />--%>

        </div>
    </div>
    <div class="row ">

        <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1">

            <div class="panel-body">
                <form role="form">
                    <hr />
                    <h5>登录</h5>
                    <br />
                    <div class="form-group input-group">
                        <span class="input-group-addon"><i class="fa fa-tag"  ></i></span>
                        <input type="text" class="form-control" placeholder="Your Username " />
                    </div>
                    <div class="form-group input-group">
                        <span class="input-group-addon"><i class="fa fa-lock"  ></i></span>
                        <input type="password" class="form-control"  placeholder="Your Password" />
                    </div>
                    <div class="form-group">
                        <label class="checkbox-inline">
                            <input type="checkbox" /> Remember me
                        </label>
                                            <span class="pull-right">
                                                   <a href="index.html" >Forget password ? </a>
                                            </span>
                    </div>

                    <a href="index.html" class="btn btn-primary ">Login Now</a>
                    <hr />
                    Not register ? <a href="index.html" >click here </a> or go to <a href="index.html">Home</a>
                </form>
            </div>

        </div>


    </div>
</div>

</body>
</html>
