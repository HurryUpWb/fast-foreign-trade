package com.fast.trade.dao;


import com.fast.trade.entity.user.UserAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, Integer> {


    @Query(value = "select * from t_user_account_info where user_account = ?", nativeQuery = true)
    UserAccount getUserAccountByAccount(String account);

    @Query(value = "select * from t_user_account_info where user_account = ? and user_password = ?", nativeQuery = true)
    UserAccount getUserAccountByAccountAndpassWord(String account, String password);

}

