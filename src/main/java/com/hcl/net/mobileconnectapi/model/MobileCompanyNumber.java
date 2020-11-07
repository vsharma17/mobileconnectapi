package com.hcl.net.mobileconnectapi.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mobile_company_numbers database table.
 * 
 */
@Data
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="mobile_company_numbers")
@NamedQuery(name="MobileCompanyNumber.findAll", query="SELECT m FROM MobileCompanyNumber m")
public class MobileCompanyNumber implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="mobileno_id")
	private String mobilenoId;

	private Boolean assigned;

	private String companyname;

	private String createdat;

	private String createdby;

	private Integer mobilenumber;



}