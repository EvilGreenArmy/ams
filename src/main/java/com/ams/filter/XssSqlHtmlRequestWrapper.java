package com.ams.filter;

import com.ams.util.StringEscapeUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * XSS跨站脚本攻击，SQL注入，HTML代码处理
 * Created by Evan on 2016/3/18.
 */
public class XssSqlHtmlRequestWrapper extends HttpServletRequestWrapper {
    public XssSqlHtmlRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    public String getQueryString() {
        String value = super.getQueryString();
        if (value != null) {
            value = xssEncode(value);
        }
        return value;
    }

    /**
     * 覆盖getParameter
     */
    public String getParameter(String name) {
        String value = super.getParameter(xssEncode(name));
        if (value != null) {
            value = xssEncode(value);
        }
        return value;
    }

    public String[] getParameterValues(String name) {
        String[] parameters = super.getParameterValues(name);
        if (parameters == null || parameters.length == 0) {
            return null;
        }
        for (int i = 0; i < parameters.length; i++) {
            parameters[i] = xssEncode(parameters[i]);
        }
        return parameters;
    }

    /**
     * 覆盖getHeader方法
     */
    public String getHeader(String name) {

        String value = super.getHeader(xssEncode(name));
        if (value != null) {
            value = xssEncode(value);
        }
        return value;
    }

    /**
     * 转义js,html,sql漏洞的半角字符直接替换成全角字符
     *
     * @param s
     * @return
     */
    private String xssEncode(String s) {
        if (s == null || s.equals("")) {
            return s;
        }
        return StringEscapeUtil.escapeJavaScript(StringEscapeUtil
                .escapeJavaScript(StringEscapeUtil.escapeSql(s)));
    }
}
