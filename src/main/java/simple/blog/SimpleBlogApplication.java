package simple.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ConfigurationPropertiesScan("simple.blog.config")
@EnableSwagger2
public class SimpleBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(SimpleBlogApplication.class, args);
    }
}
