package com.hst.reminder.configuration;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

/**
 * @author dlgusrb0808@gmail.com
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	public static final String CODE_API_TAG = "Code API";
	public static final String MEMBER_API_TAG = "Member API";

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(Predicates.not(RequestHandlerSelectors.
						basePackage("org.springframework.boot")))
				.paths(PathSelectors.any())
				.build()
				.tags(
					new Tag(CODE_API_TAG, "전체 시스템에서 사용하는 코드 관련 API", 1),
					new Tag(MEMBER_API_TAG, "회원(사용자) 관련 API", 2)
				)
				.apiInfo(apiInfo())
				.useDefaultResponseMessages(false);
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
				"RE:Minder Service API",
				"이 문서는 RE:Minder 개발을 위한 Service API 명세서입니다.",
				"1.0.0",
				"",
				new Contact("Team HST", "", "dl_hst@gmail.com"),
				"",
				"", Collections.emptyList());
	}

}
