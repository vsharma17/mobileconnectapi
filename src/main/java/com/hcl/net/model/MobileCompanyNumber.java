package com.hcl.net.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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
	@GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(unique = true,name="mobileno_id", columnDefinition = "VARCHAR(36)")
	private String mobilenoId;
	private Boolean assigned;
	private String companyname;
	private ZonedDateTime createdat;
	private String  createdby;
	private BigInteger mobilenumber;
	private String simNo;

}