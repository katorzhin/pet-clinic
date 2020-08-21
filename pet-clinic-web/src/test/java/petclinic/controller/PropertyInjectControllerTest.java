package petclinic.controller;

import com.katorzhin.spring.petclinic.service.ConstructorGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropertyInjectControllerTest {
    PropertyInjectController controller;

    @BeforeEach
    void setUp() {
        controller = new PropertyInjectController();

        controller.greetingService= new ConstructorGreetingService();
    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());
    }
}