package cn.bcm.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 自定义validator标签(和 hibernate validator组合使用)
 *
 * @author beichunming
 *
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.FIELD})
@Constraint(validatedBy = Not999Validator.class)
public @interface Not999 {

    // 提示信息,可以写死,可以填写国际化的key
    String message() default "{com.yingjun.ssm.validator.not999}";

    // 下面这两个属性必须添加
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
