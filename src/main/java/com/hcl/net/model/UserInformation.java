package com.hcl.net.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_information database table.
 * 
 */
@Data
@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="user_information")
@NamedQuery(name="UserInformation.findAll", query="SELECT u FROM UserInformation u")
public class UserInformation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_id")
	private String userId;

	private String address;

	private String adharcardno;

	private String alternatemobileno;

	private String createdat;

	private String createdby;

	private String emailaddress;

	private String fullname;

	private String gender;

	private Boolean mobilenumberactivation;

	private String pancardno;

	private String requestedmobileno;

	private String username;

	//bi-directional many-to-one association to Talktimeplan
	@ManyToOne
	@JoinColumn(name="plan_id")
	private Talktimeplan talktimeplan;



}