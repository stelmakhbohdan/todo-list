package myAcademy.learning.controller;

import lombok.extern.slf4j.Slf4j;
import myAcademy.learning.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class DemoController {

    private final DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @ResponseBody
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("welcome")
    public String welcome(@RequestParam String user,@RequestParam int age, Model model){
        model.addAttribute("helloMessage",demoService.getHelloMessage(user));
        model.addAttribute("age",age);
        log.info("model= {}",model);
        return "welcome";
    }

    @ModelAttribute("welcomeMessage")
    public String welcomeMessage(){
        log.info("welcomeMessage() called");
        return demoService.getWelcomeMessage();
    }

}
