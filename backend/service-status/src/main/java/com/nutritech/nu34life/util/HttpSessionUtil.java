package com.nutritech.nu34life.util;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class HttpSessionUtil {
	
	public static HttpSession getSession() {
		return ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes())
    	.getRequest().getSession();
	}

}
