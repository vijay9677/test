package com.nacre.online_assesment.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nacre.online_assesment.form_bean.LoginBean;
 
public class MyEmailValidationProcess {
 
    private static Pattern emailNamePtrn = Pattern.compile(
    "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
     
    public static boolean validateEmailAddress(String userName){
    	LoginBean b=new LoginBean();
         
        Matcher mtch = emailNamePtrn.matcher(userName);
        if(mtch.matches()){
            return true;
        }
        return false;
    }
}
