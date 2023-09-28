package se.systementor.stengameserver.debug;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanInspector {
    public static void main(String[] args) {
        // Initialize the Spring application context
        ApplicationContext context = new AnnotationConfigApplicationContext("se.systementor.stengameserver");

        // Get the list of bean names in the application context
        String[] beanNames = context.getBeanDefinitionNames();

        // Print the list of beans
        for (String beanName : beanNames) {
            System.out.println("Bean Name: " + beanName);
        }
    }
}
