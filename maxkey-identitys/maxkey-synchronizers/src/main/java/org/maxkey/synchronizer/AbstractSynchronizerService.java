package org.maxkey.synchronizer;

import java.util.HashMap;
import java.util.List;

import org.maxkey.entity.Organizations;
import org.maxkey.entity.Synchronizers;
import org.maxkey.persistence.service.HistorySynchronizerService;
import org.maxkey.persistence.service.OrganizationsService;
import org.maxkey.persistence.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractSynchronizerService {
    private static final Logger _logger = 
            LoggerFactory.getLogger(AbstractSynchronizerService.class);
    
    @Autowired
    protected OrganizationsService organizationsService;
    
    @Autowired
    protected UserInfoService userInfoService;
    
    @Autowired
    protected HistorySynchronizerService historySynchronizerService;
    
    protected Synchronizers synchronizer;
    
    protected HashMap<String,Organizations> orgsNamePathMap;
     
    protected Organizations rootOrganization = null;
    
    
    public void loadOrgsById(String orgId) {
        List<Organizations> orgsList = organizationsService.query(null);
        if(orgId== null || orgId.equals("")) {
            orgId="1";
        }
        
        for(Organizations org : orgsList) {
           if(org.getId().equals(orgId)&&orgId.equals("1")) {
               rootOrganization = org; 
               rootOrganization.setNamePath("/"+rootOrganization.getName());
               rootOrganization.setCodePath("/1");
               rootOrganization.setParentId("-1");
               rootOrganization.setParentName("");
           }else if(org.getId().equals(orgId)){
               rootOrganization = org; 
           }
        }
        
        orgsNamePathMap =new HashMap<String,Organizations>();
        orgsNamePathMap.put(rootOrganization.getNamePath(), rootOrganization);
        push(orgsNamePathMap,orgsList,rootOrganization);
        
        _logger.trace("orgsNamePathMap " + orgsNamePathMap);
        
    }
    
    public void push(HashMap<String,Organizations> orgsNamePathMap,
                     List<Organizations> orgsList,
                     Organizations parentOrg) {
        for(Organizations org : orgsList) {
            if(org.getParentId().equals(parentOrg.getId())) {
                if(org.getNamePath() == null 
                        || !org.getNamePath().equals(parentOrg.getNamePath()+"/"+org.getName())) {
                    org.setParentName(parentOrg.getName());
                    org.setNamePath(parentOrg.getNamePath()+"/"+org.getName());
                    org.setCodePath(parentOrg.getCodePath()+"/"+org.getId());
                    organizationsService.update(org);
                }
                orgsNamePathMap.put(org.getNamePath(), org);
                push(orgsNamePathMap,orgsList,org);
            }
        }
        return;
    }

    public OrganizationsService getOrganizationsService() {
        return organizationsService;
    }

    public void setOrganizationsService(OrganizationsService organizationsService) {
        this.organizationsService = organizationsService;
    }

    public UserInfoService getUserInfoService() {
        return userInfoService;
    }

    public void setUserInfoService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    public HashMap<String, Organizations> getOrgsNamePathMap() {
        return orgsNamePathMap;
    }

    public void setOrgsNamePathMap(HashMap<String, Organizations> orgsNamePathMap) {
        this.orgsNamePathMap = orgsNamePathMap;
    }

    public Organizations getRootOrganization() {
        return rootOrganization;
    }

    public void setRootOrganization(Organizations rootOrganization) {
        this.rootOrganization = rootOrganization;
    }

    public Synchronizers getSynchronizer() {
        return synchronizer;
    }

    public void setSynchronizer(Synchronizers synchronizer) {
        this.synchronizer = synchronizer;
    }

    public HistorySynchronizerService getHistorySynchronizerService() {
        return historySynchronizerService;
    }

    public void setHistorySynchronizerService(HistorySynchronizerService historySynchronizerService) {
        this.historySynchronizerService = historySynchronizerService;
    }
    
    
}
