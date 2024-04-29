package miniProject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import miniProject.service.MainService;


@Controller
@SpringBootApplication
@MapperScan(value = {"miniProject"})
public class MiniProjectApplication {

   public static void main(String[] args) {
      SpringApplication.run(MiniProjectApplication.class, args);
   }
   
   @Autowired 
   MainService mainService;
   
   @GetMapping("/")
   public String index(Model model) {
	   mainService.execute(model);
	   return "thymeleaf/main";
   }

}