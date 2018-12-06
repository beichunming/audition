package cn.bcm.allTest.poi;

import cn.bcm.util.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName ContentValueEntity
 * @Author beichunming
 * @Date 2018/11/20 上午11:00
 */
@Data
public class ContentValueEntity {

    @JsonSerialize(using = CustomDateSerializer.class)
    private Date nowTime;

    private int secondValue;

    private String thirdValue;

    private boolean fourthValue;

    private int fivthValue;

    private boolean sixthValue;
}
