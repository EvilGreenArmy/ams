package com.ams.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

/**
 * Created by Evan on 2016/3/12.
 */
public class PageTag extends BodyTagSupport {
    String formName;
    boolean isExistForm;
    StringBuffer tag =null;
    public StringBuffer getTag() {
        return tag;
    }
    public boolean getIsExistForm() {
        return isExistForm;
    }
    public void setIsExistForm(boolean isExistForm) {
        this.isExistForm = isExistForm;
    }
    String actionUrl;
    String offerPageSize;
    boolean isOuterForm;
    String resultArea;
    public boolean getIsOuterForm() {
        return isOuterForm;
    }
    public void setIsOuterForm(boolean isOuterForm) {
        this.isOuterForm = isOuterForm;
    }
    public String getOfferPageSize() {
        return offerPageSize;
    }
    public void setOfferPageSize(String offerPageSize) {
        this.offerPageSize = offerPageSize;
    }
    int pageNum = 6;
    public int getPageNum() {
        return pageNum;
    }
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
    public String getActionUrl() {
        return actionUrl;
    }
    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }

    public String getResultArea() {
        return resultArea;
    }
    public void setResultArea(String resultArea) {
        this.resultArea = resultArea;
    }
    PageBean pageBean;

    public String getFormName() {
        return formName;
    }
    public void setFormName(String formName) {
        this.formName = formName;
    }
    public PageBean getPageBean() {
        return pageBean;
    }
    public void setPageBean(PageBean page) {
        this.pageBean = page;
    }
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public int doStartTag() throws JspException {
        tag = new StringBuffer();
        if(formName==null){
            formName = "defaultQueryForm";
        }
        if(!isExistForm){
            tag.append("<form id=\""+formName+"\" name=\""+formName+"\" action=\""+actionUrl+"\" method=\"post\">");
        }
        if(!isOuterForm){
            tag.append("<input type=\"hidden\" name=\"currentPage\" value=\""+pageBean.getCurrentPage()+"\"/>");
            tag.append("<input type=\"hidden\" name=\"pageSize\" value=\""+pageBean.getPageSize()+"\"/>");
        }


        if(pageBean.getTotalPage()==0){
            tag.append("<span class=\"dftxt\">无分页记录！</span>");
        }else{
            tag.append("<div class=\"viciao\">").append(displayPages());
            int gotonumber =pageBean.getTotalPage();
            if(pageBean.getCurrentPage()<pageBean.getTotalPage()){
                gotonumber = pageBean.getCurrentPage()+1;
            }
            tag.append("<span class=\"dftxt\"> 共"+pageBean.getTotalPage()+"页&nbsp;"+pageBean.getTotalRows()+"条&nbsp;到第 <input id=\"goNumberId\" value=\""+gotonumber+"\" size=\"1\" onKeyUp=\"this.value=this.value.replace(/\\D/g,'')\"/> 页</span><input type=\"button\"  value=\"确定\" onclick=\"javascript:"+getGoToSubmitString(pageBean.getTotalPage())+"\"></input>");
            tag.append("</div>");
        }
		 /*String submitString = getSubmitString(pageBean.getCurrentPage());
		 if(offerPageSize!=null){
			 tag.append("<select class=\"pageselectstyle\" name=\"choosePageSize\" onchange=\"document.forms."+this.formName+".pageSize.value=this.value;"+submitString+"\">");
			 String[] pageSizes = offerPageSize.split(",");
			 for(int i=0;i<pageSizes.length;i++){
				 if(pageSizes[i].trim().length()==0){
					 continue;
				 }
				tag.append("<option value=\""+pageSizes[i]+"\""+(pageSizes[i].equals(pageBean.getPageSize()+"")?" selected":"")+" >"+pageSizes[i]+"</option>");
			 }
			 tag.append("</select>");
		 }*/

        if(!isExistForm){
            tag.append("</form>");
        }
        try {
            JspWriter out = pageContext.getOut();
            out.print(tag.toString());
        } catch (IOException ex) {
            throw new JspException(ex);
        }
        return EVAL_BODY_INCLUDE;
    }

    public String displayPages(){
        StringBuffer displayString = new StringBuffer();

        if(pageBean.getCurrentPage() - pageNum >0){
            displayString.append(" <a class=\"previous\" href=\"javascript:"+getSubmitString(pageBean.getCurrentPage() >pageNum?(((pageBean.getCurrentPage()-1)/pageNum-1)*pageNum+pageNum):1)+"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a> ");
        }
        if(pageNum>pageBean.getCurrentPage()){
            for(int  i=1;i<pageNum+1&&i<pageBean.getTotalPage()+1;i++){
                if(i!=pageBean.getCurrentPage()){
                    displayString.append(" <a class=\"pagespacing\" href=\"javascript:"+getSubmitString(i)+"\"> "+i+" </a> ");
                }else{
                    displayString.append("<font class=\"currentpagespacing\"> "+i+" </font>");
                }
            }
            if(pageBean.getTotalPage()>pageNum){
                displayString.append(" <a class=\"next\" href=\"javascript:"+getSubmitString(((pageBean.getCurrentPage()-1)/pageNum+1)*pageNum+1)+"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a> ");
            }
        }else{
            //if(this.currentPage%pageNum==0){this.currentPage=this.currentPage-1;}
            for(int i=((pageBean.getCurrentPage()-1)/pageNum)*pageNum+1;i<((pageBean.getCurrentPage()-1)/pageNum)*pageNum+pageNum+1&&i<pageBean.getTotalPage()+1;i++){
                if(i!=pageBean.getCurrentPage()){
                    displayString.append(" <a class=\"pagespacing\" href=\"javascript:"+getSubmitString(i)+"\"> "+i+" </a> ");
                }else{
                    displayString.append("<font class=\"currentpagespacing\"> "+i+" </font>");
                }
            }
            if(pageBean.getTotalPage()>((pageBean.getCurrentPage()-1)/pageNum+1)*pageNum){
                displayString.append(" <a class=\"next\" href=\"javascript:"+getSubmitString(((pageBean.getCurrentPage()-1)/pageNum+1)*pageNum+1)+"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a> ");
            }
        }
        return displayString.toString();
    }
    public String getSubmitString(int currentPage){
        String submitString = "document.forms."+this.formName+".currentPage.value='"+currentPage+"';document.forms."+this.formName+".submit();";
        if(isOuterForm){
            submitString = "getFilterPageVariable(document.forms."+this.formName+","+pageBean.getPageSize()+","+currentPage+");document.forms."+this.formName+".submit();";
        }
        return submitString;
    }
    public String getGoToSubmitString(int totalPage){
        String submitString = "if(document.getElementById('goNumberId').value>0){if(document.getElementById('goNumberId').value>"+totalPage+"){document.forms."+this.formName+".currentPage.value="+totalPage+";}else{document.forms."+this.formName+".currentPage.value=document.getElementById('goNumberId').value;}}else{document.forms."+this.formName+".currentPage.value=1;}document.forms."+this.formName+".submit();";
        if(isOuterForm){
            submitString = "getFilterPageVariable(document.forms."+this.formName+","+pageBean.getPageSize()+",\"if(document.getElementById('goNumberId').value>0){if(document.getElementById('goNumberId').value>"+totalPage+"){return "+totalPage+";}else{return document.getElementById('goNumberId').value;}}else{return 1;}\");document.forms."+this.formName+".submit();";
        }
        return submitString;
    }
}
