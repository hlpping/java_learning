package cn.test.behavior.interpreter;
public class SimpleExpression extends Expression {

    void interpret(Context ctx) {
        System.out.println("这是普通解析器!");
    }
}
