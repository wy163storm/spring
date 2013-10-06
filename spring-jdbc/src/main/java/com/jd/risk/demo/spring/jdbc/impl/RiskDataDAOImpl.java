package com.jd.risk.demo.spring.jdbc.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jd.risk.demo.spring.bean.UserEntity;
import com.jd.risk.demo.spring.jdbc.IRiskDataDAO;

@Repository
public class RiskDataDAOImpl implements IRiskDataDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insert(UserEntity userEntity) {

		String sql = "insert into demo_usr(usr_name)values(?) ";

		this.jdbcTemplate.update(sql.toString(), userEntity.getUserName());

	}

	@Override
	public UserEntity meger(UserEntity userEntity) {

		String sql = "update demo_usr set usr_name =? where usr_id = ? ";

		this.jdbcTemplate.update(sql, new Object[] { userEntity.getUserName(),
				userEntity.getUserId() });

		return userEntity;
	}

	@Override
	public void delete(UserEntity userEntity) {

		String sql = "delete from demo_usr where usr_id ? ";
		Long args = userEntity.getUserId();
		this.jdbcTemplate.update(sql, args);
	}

	@Override
	public List<UserEntity> query() {
		String sql = "select usr_id,usr_name from demo_usr ";
		List<UserEntity> result = this.jdbcTemplate.query(sql,
				new RowMapper<UserEntity>() {

					@Override
					public UserEntity mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						UserEntity entity = new UserEntity();
						entity.setUserId(rs.getLong("usr_id"));
						entity.setUserName(rs.getString("usr_name"));
						return entity;
					}
				});
		return result;
	}

}
