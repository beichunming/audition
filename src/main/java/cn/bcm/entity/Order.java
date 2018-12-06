package cn.bcm.entity;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName Order
 * @Author beichunming
 * @Date 2018/11/17 下午12:26
 */
@Data
public class Order {

    private String orderId;

    private User user;

    private long goodsId;

    private String title;

    private Date createTime;

    @Override
    public String toString() {
        return "Order [user=" + user + ", orderId=" + orderId + ", goodsId=" + goodsId + ", title=" + title + ", createTime=" + createTime + "]";
    }
}
