package System.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : yahyai
 * @mailto : yibrahim.py@gmail.com
 * @created : 12/19/23
 **/
@Configuration
public class SwaggerConfig {

    @Value("${swagger.server:}")
    private String serverUrl;

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .addServersItem(new Server().url(serverUrl))
                .info(new Info()
                                .title("User Post Story APIs")
                                .version("1.0.0"));
    }
}
