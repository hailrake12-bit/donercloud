package doner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(OrderProperties.class)
@SpringBootApplication
public class DonerСloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(DonerСloudApplication.class, args);
    }

}
