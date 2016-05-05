package hello;

import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class Child extends ResourceSupport {

    private String message;

    public Child(String name) {
        this.message = String.format("hello, I'm %s", name);
        this.add(linkTo(methodOn(GreetingController.class).childGreet(name)).withSelfRel());
    }

    public String getMessage() {
        return message;
    }
}
