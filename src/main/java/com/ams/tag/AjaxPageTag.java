package com.ams.tag;

import com.ams.util.StringUtil;

/**
 * Created by Evan on 2016/3/12.
 */
public class AjaxPageTag extends PageTag {
    private String showAreal = "workspace";//默认空间

    /**
     * 处理同一页面两个或多个分页列表
     * @return
     */
    private String getQueryPageFunction(){
        return "changePage('"
                + this.formName + "','"+(StringUtil.isNotBlank(this.resultArea) ?  this.resultArea : this.showAreal)+"')";
    }
    public String displayPages(){
        StringBuffer displayString = new StringBuffer();
        displayString.append("<a href=\"javascript:"+getSubmitString(1)+"\">首页</a>");
        if(pageBean.getCurrentPage()>1){

            displayString.append("<a href=\"javascript:"+getSubmitString(pageBean.getCurrentPage() -1)+"\">上一页</a>");
        }
        if((pageNum>pageBean.getCurrentPage())&&(pageBean.getCurrentPage()<pageNum-1)){
            for(int  i=1;i<pageNum+1&&i<pageBean.getTotalPage()+1;i++){
                if(i!=pageBean.getCurrentPage()){
                    displayString.append("<a href=\"javascript:"+getSubmitString(i)+"\">"+i+"</a>");
                }else{
                    displayString.append("<span class=\"current\">"+i+"</span>");
                }
            }
            /*if((pageBean.getTotalPage()>pageNum)&&(pageBean.getTotalPage()>pageBean.getCurrentPage()+2)){
            	displayString.append("...").append(" <span class=\"pagelink\"><a href=\"javascript:"+getSubmitString(pageBean.getTotalPage())+"\"> "+pageBean.getTotalPage()+" </a></span>");
            }*/
        }else{
            //if(this.currentPage%pageNum==0){this.currentPage=this.currentPage-1;}
            for(int i=((pageBean.getCurrentPage()+pageNum/2+pageNum%2)>pageBean.getTotalPage()?pageBean.getTotalPage()-pageNum+1:(pageBean.getCurrentPage()-(pageNum/2)));i<((pageBean.getCurrentPage()+pageNum/2+pageNum%2)>pageBean.getTotalPage()?pageBean.getTotalPage()+1:(pageBean.getCurrentPage()+pageNum/2+pageNum%2));i++){
                if(i!=pageBean.getCurrentPage()){
                    displayString.append("<a href=\"javascript:"+getSubmitString(i)+"\">"+i+"</a>");
                }else{
                    displayString.append("<span class=\"current\">"+i+"</span>");
                }
            }
            /*if(pageBean.getTotalPage()>(pageBean.getCurrentPage()+2)){
            	displayString.append("...").append(" <span class=\"pagelink\"><a href=\"javascript:"+getSubmitString(pageBean.getTotalPage())+"\"> "+pageBean.getTotalPage()+" </a></span>");
            }*/
        }
        if((pageBean.getTotalPage()!=pageBean.getCurrentPage())&&(pageBean.getTotalPage()>0)){
            displayString.append("...");
        }
        if(pageBean.getTotalPage()>pageBean.getCurrentPage()){
            displayString.append("<a href=\"javascript:"+getSubmitString(pageBean.getCurrentPage()+1)+"\">下一页</a>");
        }
        displayString.append("<a href=\"javascript:"+getSubmitString(pageBean.getTotalPage())+"\">尾页</a>");
        return displayString.toString();
    }
    public String getSubmitString(int currentPage){
//         String submitString = "document.forms."+this.formName+".currentPage.value='"+currentPage+"';changePage('"+this.formName+"')";
        String submitString = "document.forms."+this.formName+".currentPage.value='"+currentPage+"';"+getQueryPageFunction();
        if(isOuterForm){
//             submitString = "getFilterPageVariable(document.forms."+this.formName+","+pageBean.getPageSize()+","+currentPage+");changePage('"+this.formName+"')";
            submitString = "getFilterPageVariable(document.forms."+this.formName+","+pageBean.getPageSize()+","+currentPage+");"+getQueryPageFunction();
        }
        return submitString;
    }
    public String getGoToSubmitString(int totalPage){
//		 String submitString = "if(document.getElementById('goNumberId').value>0){if(document.getElementById('goNumberId').value>"+totalPage+"){document.forms."+this.formName+".currentPage.value="+totalPage+";}else{document.forms."+this.formName+".currentPage.value=document.getElementById('goNumberId').value;}}else{document.forms."+this.formName+".currentPage.value=1;}changePage('"+this.formName+"')";
        String submitString = "if(document.getElementById('goNumberId').value>0){if(document.getElementById('goNumberId').value>"+totalPage+"){document.forms."+this.formName+".currentPage.value="+totalPage+";}else{document.forms."+this.formName+".currentPage.value=document.getElementById('goNumberId').value;}}else{document.forms."+this.formName+".currentPage.value=1;}"+getQueryPageFunction();
        if(isOuterForm){
//             submitString = "getFilterPageVariable(document.forms."+this.formName+","+pageBean.getPageSize()+",\"if(document.getElementById('goNumberId').value>0){if(document.getElementById('goNumberId').value>"+totalPage+"){return "+totalPage+";}else{return document.getElementById('goNumberId').value;}}else{return 1;}\");changePage('"+this.formName+"')";
            submitString = "getFilterPageVariable(document.forms."+this.formName+","+pageBean.getPageSize()+",\"if(document.getElementById('goNumberId').value>0){if(document.getElementById('goNumberId').value>"+totalPage+"){return "+totalPage+";}else{return document.getElementById('goNumberId').value;}}else{return 1;}\");"+getQueryPageFunction();
        }
        return submitString;
    }
}
