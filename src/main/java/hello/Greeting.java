package hello;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class Greeting extends ResourceSupport {

    private final String message;
    private final Child child;

    @JsonCreator
    public Greeting(
            @JsonProperty("message") String name,
            @JsonProperty("child") String childName) {

        this.message = String.format("Hello, %s!", name);
        this.child = new Child(childName);
        this.add(linkTo(methodOn(GreetingController.class).greet(name, childName)).withSelfRel());
    }

    public String getMessage() {
        return message;
    }

    public Child getChild() {
        return child;
    }
}