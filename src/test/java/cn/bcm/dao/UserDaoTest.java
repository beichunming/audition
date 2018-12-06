package cn.bcm.dao;

import cn.bcm.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:cn/bcm/config/spring/application/spring-dao.xml")
@Slf4j
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void queryByPhone() {

        User user = userDao.queryByPhone("18768128888");

        System.out.println(user);

        Assert.assertNotNull(user);
    }
}