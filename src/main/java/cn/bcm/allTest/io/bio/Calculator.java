package cn.bcm.allTest.io.bio;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @ClassName Calculator
 * @Author beichunming
 * @Date 2018/11/20 下午7:35
 */
public final class Calculator {

    private final static ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");

    public static Object cal(String expression) throws ScriptException {
        return jse.eval(expression);
    }
}
