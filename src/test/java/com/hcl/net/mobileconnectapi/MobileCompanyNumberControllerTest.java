package com.hcl.net.mobileconnectapi;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.hcl.net.controller.MobileCompanyNumberController;
import com.hcl.net.repository.MobileNoRepository;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = MobileCompanyNumberController.class)
class MobileCompanyNumberControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private MobileNoRepository mobileNoRepository;
	@Autowired
	private WebApplicationContext webApplicationContext;
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
