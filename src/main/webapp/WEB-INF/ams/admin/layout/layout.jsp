<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<!-- saved from url=(0047)http://layout.jquery-dev.com/demos/example.html -->
<html style="overflow: hidden; height: 100%; border: none; padding: 0px; margin: 0px;">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>Layout Example</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/layout/jquery-latest.js"></script>
    <style type="text/css"></style>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/admin/layout/jquery.layout-latest.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('body').layout({applyDemoStyles: true});
        });
    </script>
</head>
<body class="ui-layout-container"
      style="zoom: 1; overflow: hidden; width: auto; height: auto; margin: 0px; position: absolute; top: 0px; bottom: 0px; left: 0px; right: 0px;">
<div class="ui-layout-center ui-layout-pane ui-layout-pane-center ui-layout-pane-hover ui-layout-pane-center-hover ui-layout-pane-open-hover ui-layout-pane-center-open-hover"
     style="position: absolute; margin: 0px; left: 206px; right: 6px; top: 46px; bottom: 46px; height: 585px; width: 1046px; z-index: 0; padding: 10px; border: 1px solid rgb(187, 187, 187); overflow: auto; display: block; visibility: visible; background: rgb(255, 255, 255);">
    Center
    <p><a href="http://layout.jquery-dev.com/demos.html">Go to the Demos page</a></p>

    <p>* Pane-resizing is disabled because ui.draggable.js is not linked</p>

    <p>* Pane-animation is disabled because ui.effects.js is not linked</p>
</div>
<div class="ui-layout-north ui-layout-pane ui-layout-pane-north"
     style="position: absolute; margin: 0px; top: 0px; bottom: auto; left: 0px; right: 0px; width: auto; z-index: 0; padding: 10px; border: 1px solid rgb(187, 187, 187); overflow: auto; height: 18px; display: block; visibility: visible; background: rgb(255, 255, 255);">
    North
</div>
<div class="ui-layout-south ui-layout-pane ui-layout-pane-south"
     style="position: absolute; margin: 0px; top: auto; bottom: 0px; left: 0px; right: 0px; width: auto; z-index: 0; padding: 10px; border: 1px solid rgb(187, 187, 187); overflow: auto; height: 18px; display: block; visibility: visible; background: rgb(255, 255, 255);">
    South
</div>
<div class="ui-layout-east ui-layout-pane ui-layout-pane-east"
     style="position: absolute; margin: 0px; left: auto; right: 0px; top: 46px; bottom: 46px; height: 585px; z-index: 0; padding: 10px; border: 1px solid rgb(187, 187, 187); overflow: auto; width: 178px; display: none; visibility: visible; background: rgb(255, 255, 255);">
    East
</div>
<div class="ui-layout-west ui-layout-pane ui-layout-pane-west"
     style="position: absolute; margin: 0px; left: 0px; right: auto; top: 46px; bottom: 46px; height: 585px; z-index: 0; padding: 10px; border: 1px solid rgb(187, 187, 187); overflow: auto; width: 178px; display: block; visibility: visible; background: rgb(255, 255, 255);">
    West
</div>

<div id="" class="ui-layout-resizer ui-layout-resizer-north ui-layout-resizer-open ui-layout-resizer-north-open"
     style="position: absolute; padding: 0px; margin: 0px; font-size: 1px; text-align: left; overflow: hidden; z-index: 2; border: none; top: 40px; cursor: default; width: 1280px; height: 6px; left: 0px; background: rgb(221, 221, 221);">
    <div id="" class="ui-layout-toggler ui-layout-toggler-north ui-layout-toggler-open ui-layout-toggler-north-open"
         title="Close"
         style="position: absolute; display: block; padding: 0px; margin: 0px; overflow: hidden; text-align: center; font-size: 1px; cursor: pointer; z-index: 1; visibility: visible; width: 50px; height: 6px; left: 615px; top: 0px; background: rgb(170, 170, 170);"></div>
</div>
<div id="" class="ui-layout-resizer ui-layout-resizer-south ui-layout-resizer-open ui-layout-resizer-south-open"
     style="position: absolute; padding: 0px; margin: 0px; font-size: 1px; text-align: left; overflow: hidden; z-index: 2; border: none; bottom: 40px; cursor: default; width: 1280px; height: 6px; left: 0px; background: rgb(221, 221, 221);">
    <div id="" class="ui-layout-toggler ui-layout-toggler-south ui-layout-toggler-open ui-layout-toggler-south-open"
         title="Close"
         style="position: absolute; display: block; padding: 0px; margin: 0px; overflow: hidden; text-align: center; font-size: 1px; cursor: pointer; z-index: 1; visibility: visible; width: 50px; height: 6px; left: 615px; top: 0px; background: rgb(170, 170, 170);"></div>
</div>
<div id="" class="ui-layout-resizer ui-layout-resizer-west ui-layout-resizer-open ui-layout-resizer-west-open"
     style="position: absolute; padding: 0px; margin: 0px; font-size: 1px; text-align: left; overflow: hidden; z-index: 2; border: none; left: 200px; cursor: default; height: 607px; width: 6px; top: 46px; background: rgb(221, 221, 221);">
    <div id="" class="ui-layout-toggler ui-layout-toggler-west ui-layout-toggler-open ui-layout-toggler-west-open"
         title="Close"
         style="position: absolute; display: block; padding: 0px; margin: 0px; overflow: hidden; text-align: center; font-size: 1px; cursor: pointer; z-index: 1; visibility: visible; height: 50px; width: 6px; top: 278px; left: 0px; background: rgb(170, 170, 170);"></div>
</div>
<div id="" class="ui-layout-resizer ui-layout-resizer-east ui-layout-resizer-closed ui-layout-resizer-east-closed"
     title="Slide Open"
     style="position: absolute; padding: 0px; margin: 0px; font-size: 1px; text-align: left; overflow: hidden; z-index: 2; border: none; right: 0px; cursor: pointer; height: 607px; width: 6px; top: 46px; background: rgb(221, 221, 221);">
    <div id="" class="ui-layout-toggler ui-layout-toggler-east ui-layout-toggler-closed ui-layout-toggler-east-closed"
         title="Open"
         style="position: absolute; display: block; padding: 0px; margin: 0px; overflow: hidden; text-align: center; font-size: 1px; cursor: pointer; z-index: 1; visibility: visible; height: 50px; width: 6px; top: 278px; left: 0px; background: rgb(170, 170, 170);"></div>
</div>
</body>
</html>