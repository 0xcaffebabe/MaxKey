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
package org.maxkey.entity.apps;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Crystal.Sea
 *
 */
@Entity
@Table(name = "MXK_APPS_JWT_DETAILS") 
public class AppsJwtDetails  extends Apps {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1717427271305620545L;

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO,generator="snowflakeid")
	protected String id;
	/**
	 * 
	 */
	@Column
	private String redirectUri;
	//
	@Column
	private String tokenType;
	@Column
	private String cookieName;
	@Column
	private String algorithm;
	@Column
	private String algorithmKey;
	@Column
	private String expires;
		
	
	public AppsJwtDetails() {
		super();
	}


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getRedirectUri() {
        return redirectUri;
    }


    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }


    public String getTokenType() {
        return tokenType;
    }


    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }


    public String getCookieName() {
        return cookieName;
    }


    public void setCookieName(String cookieName) {
        this.cookieName = cookieName;
    }


    public String getAlgorithm() {
        return algorithm;
    }


    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }


    public String getAlgorithmKey() {
        return algorithmKey;
    }


    public void setAlgorithmKey(String algorithmKey) {
        this.algorithmKey = algorithmKey;
    }


    public String getExpires() {
        return expires;
    }


    public void setExpires(String expires) {
        this.expires = expires;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AppsTokenBasedDetails [id=");
        builder.append(id);
        builder.append(", redirectUri=");
        builder.append(redirectUri);
        builder.append(", tokenType=");
        builder.append(tokenType);
        builder.append(", cookieName=");
        builder.append(cookieName);
        builder.append(", algorithm=");
        builder.append(algorithm);
        builder.append(", algorithmKey=");
        builder.append(algorithmKey);
        builder.append(", expires=");
        builder.append(expires);
        builder.append("]");
        return builder.toString();
    }

}
