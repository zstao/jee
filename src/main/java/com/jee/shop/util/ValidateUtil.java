package com.jee.shop.util;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZSt on 2016/2/7.
 */
public class ValidateUtil {

    public static boolean validateNull(HttpServletRequest request, String[] fields){
        Map<String, String> errorMsg = new HashMap<String, String>();
        boolean validate = true;
        for(String field: fields){
            String requestParameter = request.getParameter(field);
            if(requestParameter==null||"".equals(requestParameter.trim())){
                validate = false;
                errorMsg.put(field, field+"不能为空");
            }
        }
        if(!validate) request.setAttribute("errorMsg", errorMsg);
        return validate;
    }

    @SuppressWarnings("unchecked")
    public static String showError(HttpServletRequest request, String field){
        Map<String, String> errorMsg = (Map<String, String>) request.getAttribute("errorMsg");
        if(errorMsg==null) return "";
        String msg = errorMsg.get(field);
        if(msg==null) return "";
        return msg;
    }
}
