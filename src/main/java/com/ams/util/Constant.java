package com.ams.util;

/**
 * 常量类.
 *
 * @author Evan
 */
public interface Constant {

    /**
     * 邮箱验证正则表达式.
     */
    String REGULAR_EXPRESSION_EMAIL = "^([a-zA-Z0-9]+[_|\\-|\\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\\-|\\.]?)*[a-zA-Z0-9]+\\.[a-zA-Z]{2,3}$";

    /**
     * 手机验证正则表达式.
     */
    String REGULAR_EXPRESSION_MOBILENO = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

    /**
     * 银行帐号正则表达式.
     */
    String REGULAR_EXPRESSION_BANK = "^\\d+$";

    /**
     * 时间验证正则表达式.
     */
    String REGULAR_EXPRESSION_TIME = "(([0-1][0-9])|2[0-3]):[0-5][0-9]:[0-5][0-9]";

    /**
     * 整型验证正则表达式.正整数
     */
    String REGULAR_EXPRESSION_INTEGER = "^[0-9]*[1-9][0-9]*$";

    /**
     * 整型验证正则表达式.非负
     */
    String REGULAR_EXPRESSION_INTEGER_HAS0 = "^\\d+$";

    /**
     * 浮点型验证正则表达式.
     */
    String REGULAR_EXPRESSION_FLOAT = "[0-9]*(\\.?)[0-9]*";

    /**
     * 浮点型验证正则表达式.非负
     */
    String REGULAR_EXPRESSION_FLOAT_HAS0 = "^\\d+(\\.\\d+)?$";

    /**
     * 单据编码正则表达式.
     */
    String REGULAR_EXPRESSION_TICKET_STUB = "^([A-Za-z0-9](\\w|\\-)*)?[A-Za-z0-9]$";

    /**
     * 金额正则表达式.
     */
    String CASH_EXPRESSION = "^(([1-9]\\d{0,9})|0)(\\.\\d{1,2})?$";

    /**
     * 操作返回值0.
     */
    int RETURNVALUE_0 = 0;

    /**
     * 操作返回值1.
     */
    int RETURNVALUE_1 = 1;

    /**
     * 操作返回值2.
     */
    int RETURNVALUE_2 = 2;

    /**
     * 操作返回值3.
     */
    int RETURNVALUE_3 = 3;

    /**
     * 生效.
     */
    String STATUS_ACTIVE = "A";

    /**
     * 失效.
     */
    String STATUS_INACTIVE = "D";

    /**
     * 用户及买方在数据表中的标识.
     */
    Long USER_BUYER_CODE = Long.valueOf(5);

    /**
     * 手机号码最大长度11.
     */
    Integer MODILE_MAX_LENGTH = Integer.valueOf(11);

    /**
     * 默认字符集.
     */
    String DEFAULT_CHARSET = "utf-8";

    /**
     * session 中用户信息key
     */
    String SESSION_LOGIN_USER = "login_user";

    /**
     * 待审核状态.
     */
    String NO_STATUS = "N";
    /**
     * 激活状态.
     */
    String ACTIVE_STATUS = "A";
    /**
     * 禁用状态.
     */
    String DISABLE_STATUS = "D";
    /**
     * 系统路径.
     * */
    String BASE_PATH = "basePath";
    /**
     * 默认密码：111111.
     * */
    String DEFAULT_PASSWORD = "111111";
  }
