package com.user.dao;

import com.user.vo.User;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserDao {
	User getUserByUsername(String username);

    List getUserList(Map paramsMap);

    Set getUserRolesSet(String username);

    Set getRolePermissionsSet(String role_name);

    User getUserAnthenticaition(Map map);

	String getQueryConditions(Map map);
}
