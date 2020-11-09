package com.fast.trade.dao;

import com.fast.trade.entity.user.UserBaseInfo;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @title: UserRepository
 * @package com.fast.trade.dao
 * @description:
 * @author: wangbo
 * @date: 2020/6/21 15:11
 * @version: V1.0
 */
@Repository
public interface UserRepository extends CrudRepository<UserBaseInfo,Integer>, JpaSpecificationExecutor<UserBaseInfo> {



}
