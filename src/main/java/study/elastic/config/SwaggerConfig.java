package study.elastic.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title("ElasticSearch Study API Docs")
                        .version("v1")
                        .description("ElasticSearch를 공부하며 테스트용으로 작성한 API들입니다.")
                );
    }
}


