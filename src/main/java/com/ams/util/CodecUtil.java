package com.ams.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;




/**
 * 提供与编码、解码相关的工具方法。
 *
 * @author Evan
 * @version 1.0
 */
public class CodecUtil {

    /** 15位身份证号模式 */
    private Pattern             idCardNumberPattern15 = Pattern.compile("^([0-9]){15}$");

    /** 18位身份证号模式 */
    private Pattern             idCardNumberPattern18 = Pattern.compile("^([0-9]){17}[0-9Xx]{1}$");

    private static final String MD5                   = "MD5";

    private static final String SHA1                  = "SHA-1";

    private static final String DES                   = "DES";



    /**
     * 取自动生成的随机新密码确认码。
     *
     * <p>
     * 自动生成的随机新密码确认码长度为6，其中只包括数字。
     * </p>
     *
     * @return 自动生成的随机新密码确认码。
     */
    public String getNewPasswordAckNum() {
        return getRandomString(6, false);
    }

    /**
     * 取自动生成的随机新密码。
     *
     * <p>
     * 自动生成的随机新密码长度为8，其中包括数字和小写字母。
     * </p>
     *
     * @return 自动生成的随机新密码。
     */
    public String getNewPassword() {
        return getRandomString(8, true);
    }

    /**
     * 取自动随机生成的新邮件地址确认码。
     *
     * <p>
     * 自动随机生成的新邮件地址确认码长度为6，其中只包括数字。
     * </p>
     *
     * @return 自动随机生成的新邮件地址确认码。
     */
    public String getNewEmailAckNum() {
        return getRandomString(6, false);
    }

    /**
     * 获取一个随机字符串。
     *
     * @param length
     *            随机字符串的长度
     * @param allowLetter
     *            是否允许使用字母
     *
     * @return 一个随机字符串
     */
    public String getRandomString(int length, boolean allowLetter) {
        if (length < 1) {
            return "";
        }

        StringBuffer sb = new StringBuffer(length);

        for (int i = 0; i < length; i++) {
            sb.append(allowLetter ? genRandomChar(i != 0) : genRandomDigit(i != 0));
        }

        return sb.toString();
    }

    /**
     * 获取一个随机字符（允许数字0-9和小写字母）。
     *
     * @return 一个随机字符
     */
    protected char genRandomChar(boolean allowZero) {
        int randomNumber = 0;

        do {
            randomNumber = (int) (Math.random() * 36);
        } while ((randomNumber == 0) && !allowZero);

        if (randomNumber < 10) {
            return (char) (randomNumber + '0');
        } else {
            return (char) (randomNumber - 10 + 'a');
        }
    }

    /**
     * 获取一个随机字符（只允许数字0-9）。
     *
     * @return 一个随机字符
     */
    protected char genRandomDigit(boolean allowZero) {
        int randomNumber = 0;

        do {
            randomNumber = (int) (Math.random() * 10);
        } while ((randomNumber == 0) && !allowZero);

        return (char) (randomNumber + '0');
    }

    /**
     * 将点分数字形式的IP地址编码成16进制形式。
     *
     * <p>
     * 例如：点分数字形式的IP地址为<code>10.0.28.57</code>，则16进制形式的IP地址形式为<code>0a001c39</code>。
     * </p>
     *
     * @param ip
     *            点分数字形式的IP地址
     *
     * @return 16进制形式的IP地址。如果IP地址形式无效，则返回null。
     */
    public String encodeIP(String ip) {
        if (StringUtil.isEmpty(ip)) {
            return null;
        }

        String[] ipParts = ip.split("\\.");

        if (ipParts.length != 4) {
            return null;
        }

        String encodedIP = "";

        try {
            for (int i = 0; i < 4; i++) {
                int ipPart = Integer.parseInt(ipParts[i]);
                String hex = Integer.toHexString(ipPart);

                if (hex.length() == 1) {
                    hex = "0" + hex;
                }

                encodedIP += hex;
            }
        } catch (Exception e) {
            return null;
        }

        return encodedIP;
    }

    /**
     * 将身份证号规格化为18位。
     *
     * @param idCardNumber
     *            15或18位的身份证号
     *
     * @return 18位规格化的身份证号
     */
    public String getIdCardNumber18(String idCardNumber) {
        if (StringUtil.isEmpty(idCardNumber)) {
            return null;
        }
        /*
         * BUGFIX:18位身份证最后一位应该是X
         */
        if (idCardNumber.length() == 18) {
            return idCardNumber.toUpperCase();
        } else if (idCardNumber.length() != 15) {
            return null;
        }

        /* 首先将身份证号码扩展至17位: 将出生年扩展为19XX的形式 */
        String idCardNumber17 = idCardNumber.substring(0, 6) + "19" + idCardNumber.substring(6);

        /* 计算校验码 */
        int nSum = 0;

        try {
            for (int nCount = 0; nCount < 17; nCount++) {
                nSum += (Integer.parseInt(idCardNumber17.substring(nCount, nCount + 1)) * (Math
                        .pow(2, 17 - nCount) % 11));
            }
        } catch (Exception e) {
        }

        nSum %= 11;

        if (nSum <= 1) {
            nSum = 1 - nSum;
        } else {
            nSum = 12 - nSum;
        }
        /*
         * BUGFIX:18位身份证最后一位应该是X
         */
        if (nSum == 10) {
            return idCardNumber17 + "X";
        } else {
            return idCardNumber17 += nSum;
        }
    }

    /**
     * 将身份证号规格化为15位。
     *
     * @param idCardNumber
     *            15或18位的身份证号
     *
     * @return 15位规格化的身份证号
     */
    public String getIdCardNumber15(String idCardNumber) {
        if (StringUtil.isEmpty(idCardNumber)) {
            return null;
        }

        if (idCardNumber.length() == 15) {
            return idCardNumber;
        } else if (idCardNumber.length() == 18) {
            return idCardNumber.substring(0, 6) + idCardNumber.substring(8, 17);
        }

        return null;
    }

    /**
     * 判断两个身份证号码是否一致，可以屏蔽15＆18区分，直接可以判断身份证是否一致
     *
     *
     * @param newCertNo
     * @param oldCertNo
     * @return
     */
    public boolean checkCertNoEquals(String newCertNo, String oldCertNo) {
        if (StringUtil.isBlank(oldCertNo) || StringUtil.isBlank(newCertNo)) {
            return false;
        }

        if (!checkIdCardNumber(newCertNo) || !checkIdCardNumber(oldCertNo)) {
            return false;
        }

        if (StringUtil.equalsIgnoreCase(oldCertNo, getIdCardNumber15(newCertNo))
                || StringUtil.equalsIgnoreCase(oldCertNo, getIdCardNumber18(newCertNo))) {
            return true;
        }

        return false;
    }

    /**
     * 从身份证号析取年龄。
     *
     * @param idCardNumber
     *            15或18位的身份证号
     *
     * @return 在身份证中析取出的年龄
     */
    public int getAgeFromIdCardNumber(String idCardNumber) {
        if (StringUtil.isEmpty(idCardNumber)) {
            return 0;
        }

        String strYear = null;

        if (idCardNumber.length() == 15) {
            strYear = "19" + idCardNumber.substring(6, 8);
        } else if (idCardNumber.length() == 18) {
            strYear = idCardNumber.substring(6, 10);
        } else {
            return 0;
        }

        int year = 0;

        try {
            year = Integer.parseInt(strYear);
        } catch (Exception e) {
            return 0;
        }

        int thisYear = (new GregorianCalendar()).get(Calendar.YEAR);

        return (thisYear - year);
    }

    /**
     * 从身份证号判断是否成年１８周岁
     * @param idCardNumber
     *            15或18位的身份证号
     *
     * @return 在身份证中析取出的年龄
     */
    public boolean checkAgeIsAdult(String idCardNumber) {
        if (StringUtil.isEmpty(idCardNumber)) {
            return false;
        }

        String birthYear = null;
        String birthDateAnMouth = null;

        if (idCardNumber.length() == 15) {
            birthYear = "19" + idCardNumber.substring(6, 8);
            birthDateAnMouth = idCardNumber.substring(8, 12);
        } else if (idCardNumber.length() == 18) {
            birthYear = idCardNumber.substring(6, 10);
            birthDateAnMouth = idCardNumber.substring(10, 14);
        } else {
            return false;
        }

        birthYear = Integer.parseInt(birthYear) + 18 + "";

        String adultDay = birthYear + birthDateAnMouth;

        String today = DateUtil.getTodayString();

        boolean a = !(Integer.parseInt(adultDay) > Integer.parseInt(today));
        //DateUtil.parseDateNoTime(sDate)

        return a;
    }

    /**
     * 检查身份证号是否有效。
     *
     * @param idCardNumber
     * @return
     */
    public boolean checkIdCardNumber(String idCardNumber) {
        return checkIdCardNumber(idCardNumber, -1);
    }

    /**
     * 根据身份证号码判断是不是男性，在这个方法之前一点要确定传入的号码一定是身份证号码
     * @param idCardNumber
     * @return
     */
    public boolean checkIsGenderManByIdCardNumber(String idCardNumber) {
        int n = 0;
        if (StringUtil.isBlank(idCardNumber)) {
            return false;
        }
        if (idCardNumber.length() == 18) {
            n = Integer.parseInt(StringUtil.substring(idCardNumber, 16, 17));
        } else {
            n = Integer.parseInt(StringUtil.substring(idCardNumber, 14, 15));
        }

        return n % 2 == 1;
    }

    /**
     * 检查身份证号是否有效。
     *
     * @param idCardNumber
     * @param age
     * @return
     */
    public boolean checkIdCardNumber(String idCardNumber, int age) {
        Matcher matcher = null;

        matcher = idCardNumberPattern15.matcher(idCardNumber);

        if (!matcher.find()) {
            matcher = idCardNumberPattern18.matcher(idCardNumber);

            if (!matcher.find()) {
                return false;
            }
        }

        String idCardNumber18 = getIdCardNumber18(idCardNumber);

        if (idCardNumber18 == null) {
            return false;
        }

        try {
            int year = Integer.parseInt(idCardNumber18.substring(6, 10));
            int month = Integer.parseInt(idCardNumber18.substring(10, 12));
            int day = Integer.parseInt(idCardNumber18.substring(12, 14));

            if (!checkDate(year, month, day)) {
                return false;
            }

            if (age > (getCurrentYear() - year)) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

        if (idCardNumber.length() == 18) {
            if (!idCardNumber.equalsIgnoreCase(getIdCardNumber18(getIdCardNumber15(idCardNumber)))) {
                return false;
            }
        }

        return true;
    }

    /**
     * 检查日期是否有效。
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public boolean checkDate(int year, int month, int day) {
        if ((year < 1900) || (year > getCurrentYear())) {
            return false;
        }

        if ((month < 1) || (month > 12)) {
            return false;
        }

        Calendar cal = new GregorianCalendar();

        cal.set(year, month - 1, 1);

        if ((day < 1) || (day > cal.getActualMaximum(Calendar.DAY_OF_MONTH))) {
            return false;
        }

        return true;
    }

    /**
     * 取得当前年份。
     *
     * @return
     */
    protected int getCurrentYear() {
        Calendar cal = new GregorianCalendar();

        cal.setTime(new Date());
        return cal.get(Calendar.YEAR);
    }

    /**
     * 计算校验码。
     *
     * <p>
     * 校验码规则: 1-15位做异或，并用10取模。
     *
     * @param string
     * @return
     */
    public int computeChecksum(String string) {
        // 计算校验码
        int checksum = 0;

        // 计算校验和
        for (int i = 0; i < string.length(); i++) {
            checksum ^= (string.charAt(i) - '0');
        }

        return checksum % 10;
    }





    /**
     * 对字符串进行mask，保持其长度不变，但当中的字符使用*号代替。
     *
     * @param text
     * @return
     */
    public String maskText(String text) {
        if (text == null) {
            return null;
        }

        if (text.length() <= 2) {
            return StringUtil.repeat("*", text.length());
        }

        return text.charAt(0) + StringUtil.repeat("*", text.length() - 2)
                + text.charAt(text.length() - 1);
    }

    /**
     * sha1算法的实现
     *
     * @return String
     * @param
     */
    public String SHA1Encrypt(String inStr) {
        return Encrypt(inStr, SHA1);
    }

    /**
     * md5加密算法的实现
     *
     * @return String
     * @param
     */
    public String MD5Encrypt(String inStr) {
        return Encrypt(inStr, MD5);
    }

    public String Encrypt(String strSrc, String encName) {
        // parameter strSrc is a string will be encrypted,
        // parameter encName is the algorithm name will be used.
        // encName dafault to "MD5"
        MessageDigest md = null;
        String strDes = null;

        byte[] bt = strSrc.getBytes();
        try {
            if (encName == null || encName.equals("")) {
                encName = "MD5";
            }
            md = MessageDigest.getInstance(encName);
            md.update(bt);
            strDes = bytes2Hex(md.digest()); // to HexString
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Invalid algorithm.");
            return null;
        }
        return strDes;
    }

    public String bytes2Hex(byte[] bts) {
        String des = "";
        String tmp = null;
        for (int i = 0; i < bts.length; i++) {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) {
                des += "0";
            }
            des += tmp;
        }
        return des;
    }



    /**
     * des加密算法
     *
     * @return String
     * @param
     */
    public String desEncode(String str, String key) {
        return encrypt(str, key, DES);
    }

    /**
     * des解密算法
     *
     * @return String
     * @param
     */
    public String desDecode(String str, String key) {
        return decrypt(str, key, DES);
    }

    /**
     *
     * @return String
     * @param
     */
    public String encrypt(String str, String key, String desName) {

        try {
            SecretKey skey = new SecretKeySpec(key.getBytes(), desName);
            Cipher ecipher = Cipher.getInstance(desName);
            ecipher.init(Cipher.ENCRYPT_MODE, skey);

            byte[] utf8 = str.getBytes("UTF8");

            byte[] enc = ecipher.doFinal(utf8);

            return new sun.misc.BASE64Encoder().encode(enc);
        } catch (Exception e) {
        }

        return null;
    }

    /**
     *
     * @return String
     * @param
     */
    public String decrypt(String str, String key, String desName) {

        try {
            SecretKey skey = new SecretKeySpec(key.getBytes(), desName);
            Cipher dcipher = Cipher.getInstance(desName);
            dcipher.init(Cipher.DECRYPT_MODE, skey);

            //
            byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);

            //
            byte[] utf8 = dcipher.doFinal(dec);

            //
            return new String(utf8, "UTF8");
        } catch (Exception e) {
        }

        return null;
    }


}
