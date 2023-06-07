package br.com.fafic.ppi.nossaBiblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@EnableWebMvc
@EnableSwagger2
@SpringBootApplication
public class NossaBibliotecaApplication implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedMethods("GET","PUT","POST","DELETE");
	}

	public static void main(String[] args) {
		SpringApplication.run(NossaBibliotecaApplication.class, args);
	}

}
