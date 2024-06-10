package com.myxz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author myxz
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class myxzApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(myxzApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  明裕学长博客服务启动成功   ლ(´ڡ`ლ)ﾞ");
    }
}
