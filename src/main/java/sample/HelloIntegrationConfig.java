package sample;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource ("/META-INF/helloIntegration.xml")
@ComponentScan
public class HelloIntegrationConfig {
}
