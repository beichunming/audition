package cn.bcm.dao;

import cn.bcm.entity.User;

/**
 * @ClassName UserDao
 * @Author beichunming
 * @Date 2018/11/17 下午12:37
 */
public interface UserDao {

    /**
     * @Author beichunming
     * @Description 根据手机号查询用户
     * @Date 下午12:38 2018/11/17
     * @Param [userPhone]
     * @return cn.bcm.entity.User
     **/

    User queryByPhone(String userPhone);
}
