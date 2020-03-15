package com;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient//通过添加@EnableEurekaClient 注解来表明自己是一个 eureka 客户端
@RestController
@SpringBootApplication
public class Application {

	@Value("${server.port}")//获取端口号
	private String port;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@RequestMapping("/yang")
	public String zhengxixi() throws InterruptedException {
		//Thread.sleep(2000); //这个是让程序休眠2000毫秒
		return "我是来自生产者的杨清林,端口号是:"+port;
	}

}
