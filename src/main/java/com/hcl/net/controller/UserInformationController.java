package com.hcl.net.controller;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.net.config.CustomerAppResponse;
import com.hcl.net.model.UserInformation;
import com.hcl.net.repository.UserInformationRepository;
import com.hcl.net.requestDto.RegisterRequest;


@ControllerAdvice
@RestController
@RequestMapping("/userInfomation")
public class UserInformationController {
	
	@Autowired UserInformationRepository userRepository;
	
	@PostMapping
	@ExceptionHandler(value = {ConstraintViolationException.class})
	public CustomerAppResponse<?> registerUser(@RequestBody RegisterRequest registerRequest) {
		UserInformation userinfo=new UserInformation();
		ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("UTC"));
		BeanUtils.copyProperties(registerRequest, userinfo);
		userinfo.setCreatedby(registerRequest.getUsername());
		userinfo.setCreatedat(zdt);
		return new CustomerAppResponse<>(HttpStatus.OK.value(),
				"You have been registered successfully. registration confirmation will send you on  email or phone number.",
				userRepository.save(userinfo));
	}

}
