/**
 * 
 */
package com.hcl.net.mobileconnectapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.net.controller.UserInformationController;
import com.hcl.net.model.UserInformation;
import com.hcl.net.repository.MobileNoRepository;
import com.hcl.net.repository.UserInformationRepository;
import com.hcl.net.requestDto.RegisterRequest;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = UserInformationController.class)
class UserInformationControllerTest {

	/**
	 * Test method for
	 * {@link com.hcl.net.controller.UserInformationController#registerUser(com.hcl.net.requestDto.RegisterRequest)}.
	 */
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
	@MockBean
	private UserInformationRepository userInformationRepository;
	@MockBean
	private MobileNoRepository mobileNoRepository;

	@Before(value = "")
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testRegisterUser() throws Exception {
		RegisterRequest mockRegistration = new RegisterRequest("noida", "2342,3234,4443,2234", "9934323444",
				"2020-11-07T07:53:45.0664556Z", "BahuMahendra01", "person@gmil.com", false, "xep213c32c22", "9999999",
				"BahuMahendra01");
		UserInformation userInfo = new UserInformation();
		BeanUtils.copyProperties(mockRegistration, userInfo);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/userInfo").accept(MediaType.APPLICATION_JSON)
				.content(toJson(mockRegistration)).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());

		assertEquals("http://localhost:9999/mobileconnect/api/v1/userInfo", response.getHeader(HttpHeaders.LOCATION));
	}

	private byte[] toJson(Object r) throws Exception {
		ObjectMapper map = new ObjectMapper();
		return map.writeValueAsString(r).getBytes();
	}
}
