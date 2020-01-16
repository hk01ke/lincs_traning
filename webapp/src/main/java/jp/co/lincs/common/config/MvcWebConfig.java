package jp.co.lincs.common.config;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan("jp.co.lincs.app")
@Import({ThymeleafConfig.class})
public class MvcWebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/static/**")
//	            .addResourceLocations("classpath:/WEB-INF/static/")
        .addResourceLocations("/WEB-INF/static/")
//        .addResourceLocations("classpath:/static/")
	            .setCacheControl(
	                    CacheControl.maxAge(7, TimeUnit.DAYS)
	                            .sMaxAge(14, TimeUnit.DAYS)
	                            .cachePrivate()
	                            .cachePublic()
	                            .mustRevalidate()
	                            .noTransform()
	                            .proxyRevalidate()
	            );
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp()
				.prefix("/WEB-INF/views/")
				.suffix(".jsp")
				.viewNames("jsp/*");
		registry.order(2);
	}

}