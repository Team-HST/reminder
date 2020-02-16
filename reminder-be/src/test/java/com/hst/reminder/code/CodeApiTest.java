package com.hst.reminder.code;

import com.hst.reminder.code.application.CodeService;
import com.hst.reminder.code.ui.CodeController;
import com.hst.reminder.code.ui.response.CodeGroupResponse;
import com.hst.reminder.publisher.domain.PublisherProtocol;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author dlgusrb0808@gmail.com
 */
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
public class CodeApiTest {

	@Mock
	private CodeService mockCodeService;

	@InjectMocks
	private CodeController codeController;

	private MockMvc mockMvc;

	private RestDocumentationResultHandler document;

	@BeforeEach
	public void setUp(RestDocumentationContextProvider restDocumentation) {
		this.document = document("{class-name}/{method-name}",
				preprocessResponse(prettyPrint()));

		this.mockMvc = MockMvcBuilders.standaloneSetup(codeController)
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

	@DisplayName("코드그룹 조회")
	@Test
	public void getCodeGroup() throws Exception {
		// given
		String codeGroup = "MOCKCODEGROUP";
		CodeGroupResponse response = mockCodeGroupResponse(codeGroup);
		Mockito.when(mockCodeService.getCodeGroup(anyString())).thenReturn(response);
		// when
		ResultActions resultActions = this.mockMvc.perform(
			get("/codes/{codeGroup}", codeGroup)
		);

		// then
		resultActions.andExpect(status().isOk())
			.andDo(this.document.document(
					pathParameters(
						parameterWithName("codeGroup").description("코드그룹")
					)
				)
			)
			.andExpect(jsonPath("codeGroup").value(codeGroup))
			.andExpect(jsonPath("codes", hasSize(2)));
	}

	private CodeGroupResponse mockCodeGroupResponse(String codeGroup) {
		Set<PublisherProtocol> codes = new HashSet<>();
		codes.add(PublisherProtocol.EMAIL);
		codes.add(PublisherProtocol.SLACK);
		return CodeGroupResponse.of(codeGroup, codes);
	}

}
