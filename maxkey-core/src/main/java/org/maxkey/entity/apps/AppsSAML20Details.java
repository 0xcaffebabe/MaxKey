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
 

package org.maxkey.entity.apps;

import java.security.cert.X509Certificate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Crystal.Sea
 *
 */
@Entity
@Table(name = "MXK_APPS_SAML_V20_DETAILS")
public class AppsSAML20Details extends Apps {

    /**
     * 
     */
    private static final long serialVersionUID = -291159876339333345L;
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "snowflakeid")
    protected String id;
    @Column
    private String certIssuer;
    @Column
    private String certSubject;
    @Column
    private String certExpiration;
    @Column
    private String signature;
    @Column
    private String digestMethod;
    @Column
    private byte[] keyStore;
    @Column
    private String entityId;
    @Column
    private String spAcsUrl;
    @Column
    private String issuer;
    @Column
    private String audience;
    @Column
    private String nameidFormat;
    @Column
    private String validityInterval;
    /**
     * Redirect-Post Post-Post IdpInit-Post Redirect-PostSimpleSign
     * Post-PostSimpleSign IdpInit-PostSimpleSign
     */
    @Column
    private String binding;

    /**
     * 0 false 1 true
     */
    @Column
    private int encrypted;

    /**
     * for upload
     */
    private MultipartFile metaFile;
    /**
     * metadata_file metadata_url or certificate
     */
    private String fileType;
    
    X509Certificate trustCert = null;
    /**
     * metadata Url
     */
    @Column
    private String metaUrl;

    /**
     * 0 original 1 uppercase 2 lowercase
     */
    @Column
    private int nameIdConvert;
    
    @Column
    private String nameIdSuffix;

    public static final class BindingType {
        public static final  String Redirect_Post = "Redirect-Post";
        public static final  String Post_Post = "Post-Post";
        public static final  String IdpInit_Post = "IdpInit-Post";
        public static final  String Redirect_PostSimpleSign = "Redirect-PostSimpleSign";
        public static final  String Post_PostSimpleSign = "Post-PostSimpleSign";
        public static final  String IdpInit_PostSimpleSign = "IdpInit-PostSimpleSign";
    }

    /**
     * 
     */
    public AppsSAML20Details() {
        super();

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the certIssuer
     */
    public String getCertIssuer() {
        return certIssuer;
    }

    /**
     * @param certIssuer the certIssuer to set
     */
    public void setCertIssuer(String certIssuer) {
        this.certIssuer = certIssuer;
    }

    /**
     * @return the certSubject
     */
    public String getCertSubject() {
        return certSubject;
    }

    /**
     * @param certSubject the certSubject to set
     */
    public void setCertSubject(String certSubject) {
        this.certSubject = certSubject;
    }

    /**
     * @return the certExpiration
     */
    public String getCertExpiration() {
        return certExpiration;
    }

    /**
     * @param certExpiration the certExpiration to set
     */
    public void setCertExpiration(String certExpiration) {
        this.certExpiration = certExpiration;
    }

    /**
     * @return the keyStore
     */
    public byte[] getKeyStore() {
        return keyStore;
    }

    /**
     * @param keyStore the keyStore to set
     */
    public void setKeyStore(byte[] keyStore) {
        this.keyStore = keyStore;
    }

    /**
     * @return the entityId
     */
    public String getEntityId() {
        return entityId;
    }

    /**
     * @param entityId the entityId to set
     */
    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    /**
     * @return the spAcsUrl
     */
    public String getSpAcsUrl() {
        return spAcsUrl;
    }

    /**
     * @param spAcsUrl the spAcsUrl to set
     */
    public void setSpAcsUrl(String spAcsUrl) {
        this.spAcsUrl = spAcsUrl;
    }

    /**
     * @return the issuer
     */
    public String getIssuer() {
        return issuer;
    }

    /**
     * @param issuer the issuer to set
     */
    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    /**
     * @return the audience
     */
    public String getAudience() {
        return audience;
    }

    /**
     * @param audience the audience to set
     */
    public void setAudience(String audience) {
        this.audience = audience;
    }

    /**
     * @return the nameidFormat
     */
    public String getNameidFormat() {
        return nameidFormat;
    }

    /**
     * @param nameidFormat the nameidFormat to set
     */
    public void setNameidFormat(String nameidFormat) {
        this.nameidFormat = nameidFormat;
    }

    public X509Certificate getTrustCert() {
        return trustCert;
    }

    public void setTrustCert(X509Certificate trustCert) {
        this.trustCert = trustCert;
    }

    /**
     * @return the validityInterval
     */
    public String getValidityInterval() {
        return validityInterval;
    }

    /**
     * @param validityInterval the validityInterval to set
     */
    public void setValidityInterval(String validityInterval) {
        this.validityInterval = validityInterval;
    }

  

    public MultipartFile getMetaFile() {
        return metaFile;
    }

    public void setMetaFile(MultipartFile metaFile) {
        this.metaFile = metaFile;
    }

    /**
     * @return the fileType
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * @param fileType the fileType to set
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    public int getEncrypted() {
        return encrypted;
    }

    public void setEncrypted(int encrypted) {
        this.encrypted = encrypted;
    }

    public int getNameIdConvert() {
        return nameIdConvert;
    }

    public void setNameIdConvert(int nameIdConvert) {
        this.nameIdConvert = nameIdConvert;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getDigestMethod() {
        return digestMethod;
    }

    public void setDigestMethod(String digestMethod) {
        this.digestMethod = digestMethod;
    }
    
    public String getNameIdSuffix() {
        return nameIdSuffix;
    }

    public void setNameIdSuffix(String nameIdSuffix) {
        this.nameIdSuffix = nameIdSuffix;
    }

    public String getMetaUrl() {
        return metaUrl;
    }

    public void setMetaUrl(String metaUrl) {
        this.metaUrl = metaUrl;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("AppsSAML20Details [id=");
        builder.append(id);
        builder.append(", certIssuer=");
        builder.append(certIssuer);
        builder.append(", certSubject=");
        builder.append(certSubject);
        builder.append(", certExpiration=");
        builder.append(certExpiration);
        builder.append(", signature=");
        builder.append(signature);
        builder.append(", digestMethod=");
        builder.append(digestMethod);
        builder.append(", entityId=");
        builder.append(entityId);
        builder.append(", spAcsUrl=");
        builder.append(spAcsUrl);
        builder.append(", issuer=");
        builder.append(issuer);
        builder.append(", audience=");
        builder.append(audience);
        builder.append(", nameidFormat=");
        builder.append(nameidFormat);
        builder.append(", validityInterval=");
        builder.append(validityInterval);
        builder.append(", binding=");
        builder.append(binding);
        builder.append(", encrypted=");
        builder.append(encrypted);
        builder.append(", fileType=");
        builder.append(fileType);
        builder.append(", metaUrl=");
        builder.append(metaUrl);
        builder.append(", nameIdConvert=");
        builder.append(nameIdConvert);
        builder.append(", nameIdSuffix=");
        builder.append(nameIdSuffix);
        builder.append("]");
        return builder.toString();
    }

 

}
