package com.xe.demo.confing;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author ChengLei
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    /**
     * 可以定义多个组，比如本类中定义把test和demo区分开了
     * （访问页面就可以看到效果了）
     *
     */
    @Bean
    public Docket testApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(false)
                .pathMapping("/")
                .select()
//                .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
                .apis(Predicates.not(RequestHandlerSelectors.basePackage("com.xe.demo.controller")))
                
                .build()
                .apiInfo(testApiInfo());
    }


    private ApiInfo testApiInfo() {
        ApiInfo apiInfo = new ApiInfo("API服务接口",
                //小标题
                "",
                //版本
                "0.1",
                "/swagger-ui.html",
                //作者
                new Contact("zhumj", "", ""),
                //链接显示文字
                "demo",
                //网站链接
                "",
                new ArrayList<VendorExtension>()
        );
        return apiInfo;
    }


}
