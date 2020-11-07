package com.hcl.net.controller;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.hcl.net.config.CustomerAppResponse;
import com.hcl.net.model.MobileCompanyNumber;
import com.hcl.net.repository.MobileNoRepository;
import com.hcl.net.requestDto.MobileNoSimRegistration;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/mobileNoInfo")
public class MobileCompanyNumberController {

	
	@Autowired 
     MobileNoRepository mobileNoRepository;
	
	@PostMapping
	@ExceptionHandler
	public CustomerAppResponse<?> addMobileNumberWithSimDetail(@RequestBody MobileNoSimRegistration mobileNoSimRegistration) {
		MobileCompanyNumber mobileCompanyNumber=new MobileCompanyNumber();
		ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("UTC"));
		BeanUtils.copyProperties(mobileNoSimRegistration, mobileCompanyNumber);
		mobileCompanyNumber.setCreatedby("Admin");
		mobileCompanyNumber.setCreatedat(zdt);
		return new CustomerAppResponse<>(HttpStatus.OK.value(),
				"Provided mobile number details is successfully added by Admin",
				mobileNoRepository.save(mobileCompanyNumber));
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(httpMethod = "GET", value = "Accept a GET request to fetcch all Mobile number.", response = ResponseEntity.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Ok"),
			@ApiResponse(code = 202, message = "Your request is acceptd for further processing"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource") })
	public CustomerAppResponse<?> getAllCategory() {
		List<MobileCompanyNumber> response = mobileNoRepository.findAll();
		return new CustomerAppResponse<>(HttpStatus.OK.value(), "Mobile no list fetched successfully.", response);

	}
}
