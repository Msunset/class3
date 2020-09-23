package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
@MapperScan("com.example.demo.mapper")
@EnableSwagger2
public class ClassApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClassApplication.class, args);



	}
	private CorsConfiguration buildConfig() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.addAllowedOrigin("*");
		corsConfiguration.addAllowedHeader("*");
		corsConfiguration.addAllowedMethod("*");
		corsConfiguration.setAllowCredentials(true);
		return corsConfiguration;
	}
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", buildConfig()); //
		return new CorsFilter(source);
	}


//	public static final int MACHINE_ID = 1;


	public static String getOrderNumber() {
//		int machineId = MACHINE_ID;
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		System.out.println("hashCodeV：" + hashCodeV);
		if (hashCodeV < 0) {
			hashCodeV = -hashCodeV;
		}
//		 0 代表前面补充0
//		 4 代表长度为4
//		 d 代表参数为正整型
//		edit---20181203 hzj
//		Date date=new Date();
//		System.out.println( machineId + String.format("%015d", hashCodeV)+date.getTime());



		return "";
	}

}
