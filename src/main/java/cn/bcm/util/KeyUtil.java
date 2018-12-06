package cn.bcm.util;

import java.util.Random;

/**
 * @ClassName KeyUtil
 * @Author beichunming
 * @Date 2018/11/17 下午12:28
 */

public class KeyUtil {

    /**
     * @Author beichunming
     * @Description 生成唯一主键
     * @Date 下午12:31 2018/11/17
     * @Param []
     * @return java.lang.String
     **/

    public static synchronized String genUniqueKey(){

        Random random = new Random();

        Integer number = random.nextInt(900000)+100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
