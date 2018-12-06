package cn.bcm.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @ClassName Not999Validator
 * @Author beichunming
 * @Date 2018/11/17 下午12:16
 */
public class Not999Validator implements ConstraintValidator<Not999,Long>{

    @Override
    public void initialize(Not999 not999) {

    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext constraintValidatorContext) {
        if (value > 999){
            return false;
        } else {
            return  true;
        }

    }
}
