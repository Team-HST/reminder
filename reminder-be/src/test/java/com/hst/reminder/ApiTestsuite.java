package com.hst.reminder;

import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.nio.charset.StandardCharsets;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;


/**
 * @author dlgusrb0808@gmail.com
 */
public class ApiTestsuite {
	protected MockMvc mockMvc;
	protected RestDocumentationResultHandler document;

	public void setUp(RestDocumentationContextProvider restDocumentation, Object targetController) {
		this.document = document("{class-name}/{method-name}",
				preprocessResponse(prettyPrint()));

		this.mockMvc = MockMvcBuilders.standaloneSetup(targetController)
				.addFilter(new CharacterEncodingFilter(StandardCharsets.UTF_8.name(), true))	// 한글 처리를 위해 추가
				.apply(
					documentationConfiguration(restDocumentation)
						.uris()
						.withScheme("https")
						.withHost("api.reminder.com")
						.withPort(8000)
				)
				.alwaysDo(document)
				.build();
	}
}
