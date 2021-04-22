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
 

package org.maxkey.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.mybatis.jpa.persistence.JpaBaseEntity;


/**
 * @author Crystal.Sea
 *
 */
@Entity
@Table(name = "MXK_HISTORY_LOGIN")  
public class HistoryLogin  extends JpaBaseEntity  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1321470643357719383L;
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO,generator="snowflakeid")
	String id;
	@Column
	String sessionId;
	@Column
	String uid;
	@Column
	String username;
	@Column
	String displayName;
	@Column
	String loginType;
	@Column
	String message;
	@Column
	String code;
	@Column
	String provider;
	@Column
	String sourceIp;
	@Column
	String browser;
	@Column
	String platform;
	@Column
	String application;
	@Column
	String loginUrl;
	@Column
	String loginTime;
	@Column
	String logoutTime;
	
	String startDate;
	String endDate;
	
	public HistoryLogin() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getSourceIp() {
		return sourceIp;
	}

	public void setSourceIp(String sourceIp) {
		this.sourceIp = sourceIp;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getLoginUrl() {
		return loginUrl;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public String getLogoutTime() {
		return logoutTime;
	}

	public void setLogoutTime(String logoutTime) {
		this.logoutTime = logoutTime;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("HistoryLogin [id=");
        builder.append(id);
        builder.append(", sessionId=");
        builder.append(sessionId);
        builder.append(", uid=");
        builder.append(uid);
        builder.append(", username=");
        builder.append(username);
        builder.append(", displayName=");
        builder.append(displayName);
        builder.append(", loginType=");
        builder.append(loginType);
        builder.append(", message=");
        builder.append(message);
        builder.append(", code=");
        builder.append(code);
        builder.append(", provider=");
        builder.append(provider);
        builder.append(", sourceIp=");
        builder.append(sourceIp);
        builder.append(", browser=");
        builder.append(browser);
        builder.append(", platform=");
        builder.append(platform);
        builder.append(", application=");
        builder.append(application);
        builder.append(", loginUrl=");
        builder.append(loginUrl);
        builder.append(", loginTime=");
        builder.append(loginTime);
        builder.append(", logoutTime=");
        builder.append(logoutTime);
        builder.append(", startDate=");
        builder.append(startDate);
        builder.append(", endDate=");
        builder.append(endDate);
        builder.append("]");
        return builder.toString();
    }


}
