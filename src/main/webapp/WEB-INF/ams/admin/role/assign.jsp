<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<link rel="stylesheet" href="${basePath}/css/admin/demo.css" type="text/css">
<link rel="stylesheet" href="${basePath}/css/admin/ztree/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="${basePath}/js/admin/ztree/jquery.ztree.core.min.js"></script>
<script type="text/javascript" src="${basePath}/js/admin/ztree/jquery.ztree.excheck.min.js"></script>
<script type="text/javascript">
  var setting = {
    check: {enable: true},
    data: {
      simpleData: {
        enable: true
      }
    },
    callback:{
      onCheck:onCheck
    }
  };
  var str = '${data}';
  var zNodes = JSON.parse(str);


  $(document).ready(function(){
    $.fn.zTree.init($("#treeDemo"), setting, zNodes);
  });
  function onCheck(e,treeId,treeNode){
    var treeObj=$.fn.zTree.getZTreeObj("treeDemo"),
            nodes=treeObj.getCheckedNodes(true),
            v="";
    var r = "";
    for(var i=0;i<nodes.length;i++){
      v+=nodes[i].name + ",";
      //alert(nodes[i].id); //获取选中节点的值
      r += nodes[i].id + ",";
    }
    $.ajax({
      type: "POST",
      url: "${basePath}/role/assign.do",
      data: {sources : r , role : "${roleId}"},
      success: function (result) {
        layer.msg('分派成功！');
      }
    });
  }
</script>
<div class="place">
  <span>位置：</span>
  <ul class="placeul">
    <li><a href="#">系统管理</a></li>
    <li><a href="#">角色管理</a></li>
    <li><a href="#">分派菜单</a></li>
  </ul>
</div>
<div class="content_wrap">
  <div class="zTreeDemoBackground left">
    <ul id="treeDemo" class="ztree"></ul>
  </div>
</div>