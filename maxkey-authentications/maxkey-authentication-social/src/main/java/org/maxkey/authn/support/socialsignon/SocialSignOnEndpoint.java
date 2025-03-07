/*
 * Copyright [2020] [MaxKey of copyright http://www.maxkey.top]
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
 

/**
 * 
 */
package org.maxkey.authn.support.socialsignon;

import javax.servlet.http.HttpServletRequest;

import org.maxkey.authn.support.socialsignon.service.SocialSignOnProvider;
import org.maxkey.authn.support.socialsignon.service.SocialsAssociate;
import org.maxkey.constants.ConstantsLoginType;
import org.maxkey.web.WebContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Crystal.Sea
 *
 */
@Controller
@RequestMapping(value = "/logon/oauth20")
public class SocialSignOnEndpoint  extends AbstractSocialSignOnEndpoint{
	final static Logger _logger = LoggerFactory.getLogger(SocialSignOnEndpoint.class);
	
    public  ModelAndView socialSignOnAuthorize(HttpServletRequest request,String provider){
    	_logger.trace("SocialSignOn provider : "+provider);
    	String authorizationUrl=buildAuthRequest(provider).authorize(request.getSession().getId());
		_logger.trace("authorize SocialSignOn : "+authorizationUrl);
		return WebContext.redirect(authorizationUrl);
    }
    
	@RequestMapping(value={"/authorize/{provider}"}, method = RequestMethod.GET)
	public ModelAndView authorize(HttpServletRequest request,
									@PathVariable String provider) {
		WebContext.setAttribute(SOCIALSIGNON_TYPE_SESSION, SOCIALSIGNON_TYPE.SOCIALSIGNON_TYPE_LOGON);
		return socialSignOnAuthorize(request,provider);
	}
	
	@RequestMapping(value={"/bind/{provider}"}, method = RequestMethod.GET)
	public ModelAndView bind(HttpServletRequest request,
								@PathVariable String provider) {
		WebContext.setAttribute(SOCIALSIGNON_SESSION_REDIRECT_URI, request.getParameter(SOCIALSIGNON_REDIRECT_URI));
		WebContext.setAttribute(SOCIALSIGNON_TYPE_SESSION, SOCIALSIGNON_TYPE.SOCIALSIGNON_TYPE_BIND);
		return socialSignOnAuthorize(request,provider);
	}
	
	@RequestMapping(value={"/unbind/{provider}"}, method = RequestMethod.GET)
	public ModelAndView unbind(HttpServletRequest request,
				@PathVariable String provider) {
		WebContext.setAttribute(SOCIALSIGNON_SESSION_REDIRECT_URI, request.getParameter(SOCIALSIGNON_REDIRECT_URI));
		SocialsAssociate socialSignOnUser =new SocialsAssociate();
		socialSignOnUser.setProvider(provider);
		socialSignOnUser.setUid(WebContext.getUserInfo().getId());
		socialSignOnUser.setUsername(WebContext.getUserInfo().getUsername());
		_logger.debug("Social Sign On unbind "+provider+" from user "+WebContext.getUserInfo().getUsername());
		
		socialsAssociateService.delete(socialSignOnUser);
		
		if(WebContext.getAttribute(SOCIALSIGNON_SESSION_REDIRECT_URI)!=null){
			return WebContext.redirect(WebContext.getAttribute(SOCIALSIGNON_SESSION_REDIRECT_URI).toString());
		}else{
			return WebContext.forward("/socialsignon/list");
		}
		
	}
	
	@RequestMapping(value={"/authorize/{provider}/{appid}"}, method = RequestMethod.GET)
	public ModelAndView authorize2AppId(HttpServletRequest request,
										@PathVariable("provider") String provider,
										@PathVariable("appid") String appid) {
		WebContext.setAttribute(SOCIALSIGNON_SESSION_REDIRECT_URI, "/authorize/"+appid);
		return authorize(request,provider);
	}
	
	@RequestMapping(value={"/scanqrcode/{provider}"}, method = RequestMethod.GET)
	@ResponseBody
	public SocialSignOnProvider scanQRCode(
							HttpServletRequest request,
							@PathVariable("provider") String provider) {
		socialSignOnAuthorize(request,provider);
		SocialSignOnProvider socialSignOnProvider = socialSignOnProviderService.get(provider);
		socialSignOnProvider.setState(request.getSession().getId());
		socialSignOnProvider.setRedirectUri(applicationConfig.getServerPrefix()+ "/logon/oauth20/callback/"+provider);
		return socialSignOnProvider;
	}
	
	
	@RequestMapping(value={"/callback/{provider}"}, method = RequestMethod.GET)
	public ModelAndView callback(@PathVariable String provider) {
		 //auth call back may exception 
	    try {
	    	SocialsAssociate socialsAssociate = null;
    		this.provider=provider;
    		this.authCallback();
    		_logger.debug(this.accountId);
    		socialsAssociate =new SocialsAssociate();
    		socialsAssociate.setProvider(provider);
    		socialsAssociate.setSocialuid(this.accountId);
    		
    		//for login
    		String socialSignOnType= "";
    		if(WebContext.getAttribute(SOCIALSIGNON_TYPE_SESSION)!=null){
    			socialSignOnType=WebContext.getAttribute(SOCIALSIGNON_TYPE_SESSION).toString();
    		}
    		
    		if(socialSignOnType.equals(SOCIALSIGNON_TYPE.SOCIALSIGNON_TYPE_LOGON)||socialSignOnType.equals("")){
    			socialSignOn(socialsAssociate);
    			return WebContext.redirect("/index");
    		}else{
    			socialBind(socialsAssociate);
    		}
    		
    		if(WebContext.getAttribute(SOCIALSIGNON_SESSION_REDIRECT_URI)!=null){
    			return WebContext.redirect(WebContext.getAttribute(SOCIALSIGNON_SESSION_REDIRECT_URI).toString());
    		}else{
    			return WebContext.forward("/socialsignon/list");
    		}
    		
	    }catch(Exception e) {
	        _logger.error("callback Exception  ",e);
	    }
	    
	    return WebContext.redirect("/login");
	}
	
	public boolean socialBind(SocialsAssociate socialsAssociate){
	    if(null == socialsAssociate) {
	        return false;
	    }
	    
	    socialsAssociate.setSocialUserInfo(accountJsonString);
	    socialsAssociate.setUid(WebContext.getUserInfo().getId());
		socialsAssociate.setUsername(WebContext.getUserInfo().getUsername());
		//socialsAssociate.setAccessToken(JsonUtils.object2Json(accessToken));
		//socialsAssociate.setExAttribute(JsonUtils.object2Json(accessToken.getResponseObject()));
		_logger.debug("Social Bind : "+socialsAssociate);
		this.socialsAssociateService.delete(socialsAssociate);
		this.socialsAssociateService.insert(socialsAssociate);
		return true;
	}
	
	public boolean socialSignOn(SocialsAssociate socialsAssociate){
		
	    socialsAssociate=this.socialsAssociateService.get(socialsAssociate);
		
		_logger.debug("Loaded SocialSignOn Socials Associate : "+socialsAssociate);
		
		if(null == socialsAssociate) {
		    WebContext.getRequest().getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, new BadCredentialsException(WebContext.getI18nValue("login.error.social")));
            return false;
		}
		
		_logger.debug("Social Sign On from "+socialsAssociate.getProvider()+" mapping to user "+socialsAssociate.getUsername());
		
		authenticationProvider.trustAuthentication(socialsAssociate.getUsername(), ConstantsLoginType.SOCIALSIGNON,this.socialSignOnProvider.getProviderName(),"xe00000004","success");
		//socialsAssociate.setAccessToken(JsonUtils.object2Json(this.accessToken));
		socialsAssociate.setSocialUserInfo(accountJsonString);
		//socialsAssociate.setExAttribute(JsonUtils.object2Json(accessToken.getResponseObject()));
		
		this.socialsAssociateService.update(socialsAssociate);
		return true;
	}
}
