package com.jxy.remoteService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

/**
 * @Auther: jxy
 * @Date: 2019/3/15 16:15
 * @Description:
 */
@Configuration
@ComponentScan("com.jxy.remoteService")
public class RmiServiceExporterConfig {
    @Bean
    public RmiProxyFactoryBean proxyFactoryBean() {
        RmiProxyFactoryBean proxyFactoryBean = new RmiProxyFactoryBean();
        proxyFactoryBean.setServiceUrl("rmi://127.0.0.1:8081/testRemoteService");
        proxyFactoryBean.setServiceInterface(RmiRemoteService.class);
        return proxyFactoryBean;
    }
   /* @Bean
    public HessianProxyFactoryBean hessianProxyFactoryBean(){
        HessianProxyFactoryBean hessianProxyFactoryBean=new HessianProxyFactoryBean();
        hessianProxyFactoryBean.setServiceUrl("http://127.0.0.1:8080/rpc/hessianService.service");
        hessianProxyFactoryBean.setServiceInterface(HessionRemoteService.class);
        return hessianProxyFactoryBean;
    }*/
}
