package com.nutritech.nu34life.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.nutritech.nu34life.service.UserService;
import com.nutritech.nu34life.util.UserResponse;

@Component
public class InfoAditionalToken  implements TokenEnhancer{


	@Autowired
	private UserService userService;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Map<String, Object> info = new HashMap<String, Object>();
		
		UserResponse user = userService.findByUsername(authentication.getName());
		info.put("email", user.getEmail());
		info.put("profileId", user.getProfileId());
		info.put("profileCreated", user.getProfileCreated());
		info.put("userName", user.getUsername());
		info.put("id", user.getUserId());
		// ingrese cualquier atributo mas para mostrar en el token
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}

}
