package jp.co.lincs.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/")
    public String index(Model model) {
//		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-dispatcher-servlet.xml");
//		for (String string : ctx.getBeanDefinitionNames()) {
//			if (string.indexOf("spring") == -1)
//				System.out.println(string);
//		}
//		ctx.close();
		model.addAttribute("message", "Hello Spring MVC 5!");
        // jspのファイル名
//        return "sample.html";
//		return "test.jsp";
//		return "jsp/test2";
		return "thymeleaf/login/login";

	}


}
