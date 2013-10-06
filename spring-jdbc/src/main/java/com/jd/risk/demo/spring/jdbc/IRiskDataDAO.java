package com.jd.risk.demo.spring.jdbc;

import java.util.List;

import com.jd.risk.demo.spring.bean.UserEntity;

public interface IRiskDataDAO {
	
	public void insert(UserEntity userEntity);
	
	public UserEntity meger(UserEntity userEntity);
	
	public void delete(UserEntity userEntity);
	
	public List<UserEntity> query();
}
