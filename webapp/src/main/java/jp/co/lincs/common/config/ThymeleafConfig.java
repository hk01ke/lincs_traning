package jp.co.lincs.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

@Configuration
public class ThymeleafConfig {

	@Bean
	public SpringResourceTemplateResolver templateResolver(){
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
                // テンプレートファイルがどのディレクトリの配下にあるかを指定。ここでは、/WEB-INF/views/配下
		templateResolver.setPrefix("/WEB-INF/views/");
                // 接尾字が何かを指定。ここでは.html
		templateResolver.setSuffix(".html");
                // テンプレートの種類は何かを指定。ここでhtml
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateResolver.setOrder(0);
		return templateResolver;
	}

	@Bean
	public SpringTemplateEngine templateEngine(){
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		templateEngine.setEnableSpringELCompiler(true);
		return templateEngine;
	}

	@Bean
	public ThymeleafViewResolver viewResolver(){
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		viewResolver.setCharacterEncoding("UTF-8");
                // ViewResolverを使う順序を指定。JSPより先にする。
		viewResolver.setOrder(1);
                // Controllerから返すView名がこの文字列であれば、ThymeleafViewResolverを使う
		viewResolver.setViewNames(new String[] {"thymeleaf/*"});
		return viewResolver;
	}
}
