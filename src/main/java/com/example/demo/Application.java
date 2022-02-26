package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication // 和同时用这三个一样 @Configuration @EnableAutoConfiguration @ComponentScan
public class Application {

    @RequestMapping("/hello")
    String hello() {
        System.out.println("Hello World.");
        return "Hello World.";
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
//        app.setBannerMode(Banner.Mode.OFF);

        /**
         *
         app.addListeners(new ApplicationListener<ApplicationEvent>() {
        @Override public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("ApplicationEvent.onApplicationEvent is running.");
        }
        });*/

        app.addListeners((event) -> {
            System.out.println("ApplicationEvent.onApplicationEvent is running.");
        });
        app.run(args);
        /**
         * SpringApplication.run(Main.class, args);
         */
    }
}
