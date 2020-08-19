package com.mars.citizen.service;

import com.mars.citizen.dto.UmsAdminParam;
import com.mars.citizen.model.UmsAdmin;
import com.mars.citizen.model.UmsPermission;
import com.mars.citizen.model.UmsResource;
import com.mars.citizen.model.UmsRole;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UmsAdminService {
    /**
     * 根据用户名获取后台管理员
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     */
    UmsAdmin register(UmsAdminParam umsAdminParam);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username,String password);

    /**
     * 根据用户id获取用户
     */
    UmsAdmin getItem(Long id);
    /**
     * 获取指定用户的可访问资源
     */
    List<UmsResource> getResourceList(Long adminId);
    /**
     * 获取用户信息
     */
    UserDetails loadUserByUsername(String username);
}
