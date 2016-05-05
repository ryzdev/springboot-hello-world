package hello;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @RequestMapping("/greet")
    public HttpEntity<Greeting> greet(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name,
            @RequestParam(value = "childName", required = false, defaultValue = "childName") String childName) {
        Greeting greeting = new Greeting(name, childName);
        return new ResponseEntity<Greeting>(greeting, HttpStatus.OK);
    }

    @RequestMapping("/greet/child")
    public HttpEntity<Child> childGreet(@RequestParam(value = "name", required = false, defaultValue = "childName") String name) {
        Child child = new Child(name);
        return new ResponseEntity<Child>(child, HttpStatus.OK);
    }
}