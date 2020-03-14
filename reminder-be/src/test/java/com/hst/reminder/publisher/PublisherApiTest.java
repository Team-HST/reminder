package com.hst.reminder.publisher;

import com.hst.reminder.ApiTestsuite;
import com.hst.reminder.publisher.application.PublisherService;
import com.hst.reminder.publisher.domain.Publisher;
import com.hst.reminder.publisher.domain.PublisherDestination;
import com.hst.reminder.publisher.domain.PublisherProtocol;
import com.hst.reminder.publisher.ui.PublisherController;
import com.hst.reminder.publisher.ui.response.PublisherListResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.pathParameters;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author dlgusrb0808@gmail.com
 */
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@DisplayName("발행자 API 테스트")
public class PublisherApiTest extends ApiTestsuite {

	@Mock
	private PublisherService publisherService;

	@InjectMocks
	private PublisherController publisherController;

	@BeforeEach
	public void setUp(RestDocumentationContextProvider restDocumentation) {
		super.setUp(restDocumentation, publisherController);
	}

	@Test
	@DisplayName("발행자 목록 조회")
	public void getPublishersTest() throws Exception {
	    // given
		List<Publisher> publishers = mockPublisherList(5);
		PublisherListResponse mockResponse = PublisherListResponse.from(publishers);
		BDDMockito.given(publisherService.getPublishersByMemberId(anyLong())).willReturn(mockResponse);

	    // when
		ResultActions resultActions = this.mockMvc.perform(
			get("/publishers/by-member/{publisherId}", 1)
		);

	    // then
		resultActions.andExpect(status().isOk())
			.andDo(this.document.document(
					pathParameters(
						parameterWithName("publisherId").description("발행자 ID")
					)
				)
			)
		;
//		assertNotNull(response);
//		assertThat(response.getStatusCode(), is(HttpStatus.OK));
//		assertThat(response.getBody(), is(mockResponse));
	}

	private List<Publisher> mockPublisherList(int size) {
		List<Publisher> publishers = new ArrayList<>();
		for (int i = 1; i <= size; i++) {
			publishers.add(mockPublisher(i));
		}
		return publishers;
	}

	private Publisher mockPublisher(int id) {
		Publisher publisher = new Publisher();
		ReflectionTestUtils.setField(publisher, "id", (long) id);
		ReflectionTestUtils.setField(publisher, "protocol", PublisherProtocol.EMAIL);
		ReflectionTestUtils.setField(publisher, "destination", PublisherDestination.of("target", "params"));
		ReflectionTestUtils.setField(publisher, "description", "설명");
		return publisher;
	}
}
