package com.tagman.sandbox.app;

import com.tagman.sandbox.service.IHelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by antoine on 02/05/14.
 */
@Component
public class HelloWorld {

    private IHelloWorldService service;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "/META-INF/application-context.xml");
        HelloWorld p = context.getBean(HelloWorld.class);
        p.run(args);
    }

    public void run(String[] args) {
        if (args == null || args.length == 0) {
            // Get generic greetings
            System.out.println(service.greeting());
        } else {
            // Get specific greetings
            for (String name : args) {
                System.out.println(service.greeting(name));
            }
        }
    }

    @Autowired
    public void setService(IHelloWorldService service) {
        this.service = service;
    }

}
