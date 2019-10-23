package com.nutritech.nu34life.audit;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.data.domain.AuditorAware;

import com.nutritech.nu34life.util.HttpSessionUtil;

public class AuditorAwareImpl implements AuditorAware<Long> {

    @Override
    public Optional<Long> getCurrentAuditor() {
    	
    	HttpSession session = HttpSessionUtil.getSession();
    	
    	Long userId = (Long) session.getAttribute("userId");
    	
        return Optional.of(userId);
    }
}