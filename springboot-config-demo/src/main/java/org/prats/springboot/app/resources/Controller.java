package org.prats.springboot.app.resources;

import org.prats.springboot.app.config.DBSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RefreshScope
public class Controller {

    @Value("${my.greeting: Default Hello World}")
    private String greetingMessage;

    @Value("Static text message")
    private String staticMessage;

    @Value("${my.list.values}")
    private List<String> listMessage;

//    @Value("#{${my.keyvalue}}")
//    private Map<String, String> mapMessage;

    @Autowired
    private DBSettings dbSettings;

    @Autowired
    private Environment environment;

    @GetMapping("/greeting")
    public String greeting() {
        return greetingMessage;
    }

    @GetMapping("/static")
    public String staticMessage() {
        return staticMessage;
    }

    @GetMapping("/list")
    public List<String> listMessage() {
        return listMessage;
    }

//    @GetMapping("/map")
//    public Map<String, String> mapMessage() {
//        return mapMessage;
//    }

    @GetMapping("/db")
    public String getDbSettings() {
        return dbSettings.toString();
    }

    @GetMapping("/env")
    public String getEnv() {
        return environment.toString();
    }
}
