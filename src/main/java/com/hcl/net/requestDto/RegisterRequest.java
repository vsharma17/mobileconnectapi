package com.hcl.net.requestDto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegisterRequest {
	@ApiModelProperty(notes = "Address information", example = "noida")
	private String address;
	@ApiModelProperty(notes = "adharcard number  16 digit", example = "2342,3234,4443,2234")
	private String adharcardno;
	@ApiModelProperty(notes = "alternative mobile number  10 digit", example = "9934323444")
	private String alternatemobileno;
	@ApiModelProperty(notes = "email address", example = "person@gmil.com")
	private String emailaddress;
	@ApiModelProperty(notes = "full name", example = "Mahendra bahubali")
	private String fullname;
	@ApiModelProperty(notes = "gender", example = "Male")
	private String gender;
	@ApiModelProperty(notes = "active type", example = "false")
	private Boolean mobilenumberactivation;
	@ApiModelProperty(notes = "pan card", example = "xep213c32c22")
	private String pancardno;
	@ApiModelProperty(notes = "requested no present in mobile company database", example = "9999999")
	private String requestedmobileno;
	@ApiModelProperty(notes = "useranmame as per request", example = "BahuMahendra01")
	private String username;
}
