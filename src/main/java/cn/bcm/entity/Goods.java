package cn.bcm.entity;

import cn.bcm.util.CustomDateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import javax.validation.constraints.Min;
import java.util.Date;

/**
 * @ClassName Goods
 * @Author beichunming
 * @Date 2018/11/17 上午11:29
 */
@Data
public class Goods {
    @Min(900)
    private long goodsId;

    private String title;

    private float price;

    private short state;//0表示下架 1表示正常

    private int number;

    //这里展示了jackson封装好的以及自定义的对时间格式的转换方式
    //后续对于一些复杂的转换可以自定义转换方式
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    @JsonSerialize(using = CustomDateSerializer.class)
    private Date updateTime;

    @Override
    public String toString() {
        return "Goods [goodsId=" + goodsId + ", title=" + title + ", price=" + price + ", state=" + state + ", number=" + number + ", createTime="
                + createTime + ", updateTime=" + updateTime + "]";
    }
}
