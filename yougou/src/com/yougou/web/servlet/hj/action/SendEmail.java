package com.yougou.web.servlet.hj.action;

import org.apache.commons.mail.HtmlEmail;

public class SendEmail {
    public static boolean sendEmail(String emailaddress,String msg) {
        try {
            HtmlEmail email = new HtmlEmail();//不用更改
            email.setHostName("smtp.qq.com");//需要修改，126邮箱为smtp.126.com,163邮箱为163.smtp.com，QQ为smtp.qq.com
            email.setCharset("UTF-8");
            email.addTo(emailaddress);// 收件地址

            email.setFrom("2475444561@qq.com", "yougou商城");//此处填邮箱地址和用户名,用户名可以任意填写

            email.setAuthentication("2475444561@qq.com", "aavosqjxudkweajd");

            email.setSubject("yougou");//此处填写邮件名，邮件名可任意填写
            email.setMsg("您的验证码是:"+msg);
            email.send();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}