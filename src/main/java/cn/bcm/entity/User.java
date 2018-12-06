package cn.bcm.entity;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName User
 * @Author beichunming
 * @Date 2018/11/17 上午11:10
 */
@Data
public class User {

    private long userId;

    private String userName;

    private String userPhone;

    private Date createTime;

    private int score;

    @Override
    public String toString() {
        return "User [userId=" + userId +
                ", userName=" + userName +
                ", userPhone=" + userPhone +
                ", createTime=" + createTime +
                ", score=" + score
                + "]";
    }
}
