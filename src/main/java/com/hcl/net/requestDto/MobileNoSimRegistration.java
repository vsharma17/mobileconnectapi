package com.hcl.net.requestDto;

import java.math.BigInteger;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MobileNoSimRegistration {

	@ApiModelProperty(notes = "Assign  information", example = "false" ,required = true)
	private Boolean assigned;
	@ApiModelProperty(notes = "Company information", example = "XYZ company" ,required = true)
	private String companyname;
	@ApiModelProperty(notes = "10 digit  mobilenumber", example = "9892382822", required=true)
	private BigInteger mobilenumber;
	@ApiModelProperty(notes = "Sim  information", example = "sew2322323223231222", required=true)
	private String simNo;
	
}
