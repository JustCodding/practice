package com.practice.eidtclass;

import javassist.*;

public class Test {
    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();

        //创建类
        CtClass cc = pool.makeClass("com.practice.bean.User");

        //创建属性
        CtField f1 = CtField.make("private int idno;",cc);
        CtField f2 = CtField.make("private String name;",cc);
        cc.addField(f1);
        cc.addField(f2);

        //创建方法
        CtMethod m1 = CtMethod.make("public int getIdno(){return this.idno;}",cc);
        CtMethod m2 = CtMethod.make("public String getName(){return this.name;}",cc);
        CtMethod m3 = CtMethod.make("public void setName(String name){this.name = name;}",cc);
        cc.addMethod(m1);
        cc.addMethod(m2);
        cc.addMethod(m3);

        /*
        创建构造方法
        第一个参数是 要创建的构造方法的参数CtClass数组
        CtClass类中只带有基本类型的CtClass,其他引用类型对应的CtClass需要ClassPool来
        获取
        */
        CtConstructor ctConstructor = new CtConstructor(new CtClass[]{CtClass.intType,pool.get("java.lang.String")},cc);
        ctConstructor.setBody("{this.idno = idno;this.name = name;}");
        cc.addConstructor(ctConstructor);

        //输出class文件
        cc.writeFile("e:/myjava");

    }
}
