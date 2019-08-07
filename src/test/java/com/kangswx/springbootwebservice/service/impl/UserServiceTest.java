package com.kangswx.springbootwebservice.service.impl;

import com.kangswx.springbootwebservice.service.UserService;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.Test;

/**
 * 两种不同的方式来调用webservice服务
 *     1：代理工厂方式
 *     2：动态调用webservice
 */
public class UserServiceTest {

    /**
     * 代理工厂的方式，需要拿到对方的接口地址
     */
    @Test
    public void getUserTest1() {
        // 接口地址
        String address = "http://192.168.9.187:8081/soap/user?wsdl";

        // 代理工厂
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();

        // 设置代理地址
        jaxWsProxyFactoryBean.setAddress(address);

        // 设置接口类型
        jaxWsProxyFactoryBean.setServiceClass(UserService.class);

        // 创建一个代理接口实现
        UserService us = (UserService) jaxWsProxyFactoryBean.create();

        //测试数据
        int id = 2;

        // 调用代理接口的方法调用并返回结果
        String userName = us.getUserName(id);
        System.out.println("返回结果: "+userName);
    }

    /**
     * 动态调用
     */
    @Test
    public void getUserNameTest2() {
        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://192.168.9.187:8081/soap/user?wsdl");

        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME, PASS_WORD));

        Object[] objects = new Object[0];
        try {
            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke("getUserName", 2);
            System.out.println("返回数据:" + objects[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}