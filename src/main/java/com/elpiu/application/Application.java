package com.elpiu.application;

import com.elpiu.application.persistence.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class Application implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(
						"/webjars/**",
						"/img/**",
						"/css/**",
						"/js/**",
						"/bootstrap",
						"/fonts")
				.addResourceLocations(
						"classpath:/META-INF/resources/webjars/",
						"classpath:/static/img/",
						"classpath:/static/css/",
						"classpath:/static/js/",
						"classpath:/static/*");
	}

}