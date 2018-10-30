package com.htkfood.service;

import com.htkfood.dao.Criteria;
import com.htkfood.entity.TestUser;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hzz
 * @since 2018-10-30
 */
public interface ITestUserService extends IService<TestUser> {
	
	public TestUser getUserAndRole(Criteria criteria);

}
