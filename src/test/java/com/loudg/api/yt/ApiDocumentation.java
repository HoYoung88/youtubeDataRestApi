package com.loudg.api.yt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.RequestDispatcher;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
public class ApiDocumentation {
  
  @Autowired
  private WebApplicationContext context;
  
  private RestDocumentationResultHandler documentationHandler;
  
  private MockMvc mockMvc;
  
  @BeforeEach
  public void setUp(RestDocumentationContextProvider restDocumentation) {
    this.documentationHandler = document("{method-name}",
        preprocessRequest(prettyPrint()),
        preprocessResponse(prettyPrint()));
  
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
        .apply(documentationConfiguration(restDocumentation).uris().withPort(3000))
        .alwaysDo(this.documentationHandler)
        .build();
  }
  
  @Test
  public void errorExample() throws Exception {
    this.mockMvc
        .perform(get("/error")
            .requestAttr(RequestDispatcher.ERROR_STATUS_CODE, 400)
            .requestAttr(RequestDispatcher.ERROR_REQUEST_URI, "/notes")
            .requestAttr(RequestDispatcher.ERROR_MESSAGE, "The tag 'http://localhost:8080/tags/123' does not exist"))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("error", is("Bad Request")))
        .andExpect(jsonPath("timestamp", is(notNullValue())))
        .andExpect(jsonPath("status", is(400)))
        .andExpect(jsonPath("path", is(notNullValue())))
        .andDo(this.documentationHandler.document(
            responseFields(
                fieldWithPath("error").description("The HTTP error that occurred, e.g. `Bad Request`"),
                fieldWithPath("message").description("A description of the cause of the error"),
                fieldWithPath("path").description("The path to which the request was made"),
                fieldWithPath("status").description("The HTTP status code, e.g. `400`"),
                fieldWithPath("timestamp").description("The time, in milliseconds, at which the error occurred"))));
  }
  
}
