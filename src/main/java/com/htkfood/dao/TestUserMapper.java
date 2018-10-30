package com.htkfood.dao;

import com.htkfood.entity.TestUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hzz
 * @since 2018-10-30
 */
public interface TestUserMapper extends BaseMapper<TestUser> {
	
	public TestUser getUserAndRole(Criteria criteria);

}
