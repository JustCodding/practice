package com.practice.oom;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;
public class MetaspaceOOMTest {
    static class OOMTest{}
    public static void main(String[] args) {
        int i = 0;
        try {
            while (true){
                i++;
                Enhancer enhancer = new Enhancer();
                enhancer.setSuperclass(OOMTest.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return method.invoke(o,objects);
                    }
                });
                enhancer.create();
            }
        }catch (Throwable e){
            System.out.println("*************i:"+i);
            e.printStackTrace();
        }
    }
}