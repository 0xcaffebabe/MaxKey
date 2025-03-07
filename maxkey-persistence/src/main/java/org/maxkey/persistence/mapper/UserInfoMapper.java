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
 

package org.maxkey.persistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.mybatis.jpa.persistence.IJpaBaseMapper;
import org.maxkey.entity.Organizations;
import org.maxkey.entity.UserInfo;
import org.maxkey.entity.UserInfoAdjoint;


/**
 * @author Crystal.Sea
 *
 */
public interface UserInfoMapper  extends IJpaBaseMapper<UserInfo>{
	
	//login query
	
	public UserInfo loadByAppIdAndUsername(UserInfo userInfo);
	
	public int logisticDeleteAllByCid(String cid);
	
	public UserInfo loadByUsername(String username);
	
	public void locked(UserInfo userInfo);

	public void unlock(UserInfo userInfo);

	public void updateBadPWDCount(UserInfo userInfo);
	
	public int changePassword(UserInfo userInfo);
	
	public int changeAppLoginPassword(UserInfo userInfo);
	
	public int updateProtectedApps(UserInfo userInfo);
	
	public int changeSharedSecret(UserInfo userInfo);
	
	public int changePasswordQuestion(UserInfo userInfo);
	
	public int changeAuthnType(UserInfo userInfo);
	
	public int changeEmail(UserInfo userInfo);
	
	public int changeMobile(UserInfo userInfo);
	
	public int updateProfile(UserInfo userInfo);
	
	public List<Organizations> loadDeptsByUserId(String userId);
	
	public List<UserInfoAdjoint> loadAdjointsByUserId(String userId);
	   
    @Select("select * from  mxk_userinfo where   email = #{value} or mobile= #{value}")
    public UserInfo queryUserInfoByEmailMobile(String emailMobile);
    
    @Update("update mxk_userinfo set gridlist =  #{gridList} where id = #{id}")
	public int updateGridList(UserInfo userInfo) ;
}
