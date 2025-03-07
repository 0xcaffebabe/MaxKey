/*
 * Copyright [2021] [MaxKey of copyright http://www.maxkey.top]
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
import org.hibernate.validator.constraints.Length;
@Entity
@Table(name = "MXK_SYNCHRONIZERS")
public class Synchronizers extends JpaBaseEntity implements Serializable {

    private static final long serialVersionUID = 4660258495864814777L;
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "snowflakeid")
    String id;

    @Length(max = 60)
    @Column
    String name;
    @Column
    String filters;
    @Column
    String sourceType;
    @Column
    String resumeTime; 
    @Column
    String suspendTime;
    @Column
    String scheduler;

    //同步时间范围（单位天）
	@Column
	Integer syncStartTime;

    @Column
    String providerUrl;
    @Column
    String driverClass;
    @Column
    String principal;
    @Column
    String credentials;
    @Column
    String basedn;
    @Column
    String msadDomain;
    @Column
    String sslSwitch;
    @Column
    String trustStore;
    @Column
    String trustStorePassword;
    @Column
    String description;
    @Column
    String createdBy;
    @Column
    String createdDate;
    @Column
    String modifiedBy;
    @Column
    String modifiedDate;
    @Column
    String status;
    
    String service;

    public Synchronizers() {
    }



    public Synchronizers(String id) {
        this.id = id;
    }

	public Integer getSyncStartTime() {
		return syncStartTime;
	}

	public void setSyncStartTime(Integer syncStartTime) {
		this.syncStartTime = syncStartTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFilters() {
		return filters;
	}

	public void setFilters(String filters) {
		this.filters = filters;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getResumeTime() {
		return resumeTime;
	}

	public void setResumeTime(String resumeTime) {
		this.resumeTime = resumeTime;
	}

	public String getSuspendTime() {
		return suspendTime;
	}

	public void setSuspendTime(String suspendTime) {
		this.suspendTime = suspendTime;
	}

	public String getScheduler() {
		return scheduler;
	}

	public void setScheduler(String scheduler) {
		this.scheduler = scheduler;
	}

	public String getProviderUrl() {
		return providerUrl;
	}

	public void setProviderUrl(String providerUrl) {
		this.providerUrl = providerUrl;
	}

	public String getDriverClass() {
		return driverClass;
	}

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getCredentials() {
		return credentials;
	}

	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}

	public String getBasedn() {
		return basedn;
	}

	public void setBasedn(String basedn) {
		this.basedn = basedn;
	}

	public String getMsadDomain() {
		return msadDomain;
	}

	public void setMsadDomain(String msadDomain) {
		this.msadDomain = msadDomain;
	}

	

	public String getSslSwitch() {
        return sslSwitch;
    }

    public void setSslSwitch(String sslSwitch) {
        this.sslSwitch = sslSwitch;
    }

    public String getTrustStore() {
		return trustStore;
	}

	public void setTrustStore(String trustStore) {
		this.trustStore = trustStore;
	}

	public String getTrustStorePassword() {
		return trustStorePassword;
	}

	public void setTrustStorePassword(String trustStorePassword) {
		this.trustStorePassword = trustStorePassword;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getService() {
		return service;
	}



	public void setService(String service) {
		this.service = service;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Synchronizers [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", filters=");
		builder.append(filters);
		builder.append(", sourceType=");
		builder.append(sourceType);
		builder.append(", resumeTime=");
		builder.append(resumeTime);
		builder.append(", suspendTime=");
		builder.append(suspendTime);
		builder.append(", scheduler=");
		builder.append(scheduler);
		builder.append(", providerUrl=");
		builder.append(providerUrl);
		builder.append(", driverClass=");
		builder.append(driverClass);
		builder.append(", principal=");
		builder.append(principal);
		builder.append(", credentials=");
		builder.append(credentials);
		builder.append(", basedn=");
		builder.append(basedn);
		builder.append(", msadDomain=");
		builder.append(msadDomain);
		builder.append(", sslSwitch=");
		builder.append(sslSwitch);
		builder.append(", trustStore=");
		builder.append(trustStore);
		builder.append(", trustStorePassword=");
		builder.append(trustStorePassword);
		builder.append(", description=");
		builder.append(description);
		builder.append(", createdBy=");
		builder.append(createdBy);
		builder.append(", createdDate=");
		builder.append(createdDate);
		builder.append(", modifiedBy=");
		builder.append(modifiedBy);
		builder.append(", modifiedDate=");
		builder.append(modifiedDate);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}

}
