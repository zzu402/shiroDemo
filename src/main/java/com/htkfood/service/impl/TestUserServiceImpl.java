package com.htkfood.service.impl;

import com.htkfood.entity.TestUser;
import com.htkfood.dao.Criteria;
import com.htkfood.dao.TestUserMapper;
import com.htkfood.service.ITestUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hzz
 * @since 2018-10-30
 */
@Service
public class TestUserServiceImpl extends ServiceImpl<TestUserMapper, TestUser> implements ITestUserService {
	
	@Autowired
	private TestUserMapper  mapper;

	@Override
	public TestUser getUserAndRole(Criteria criteria) {
		return mapper.getUserAndRole(criteria);
	}

}
