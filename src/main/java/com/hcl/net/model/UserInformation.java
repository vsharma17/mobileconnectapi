package com.hcl.net.model;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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
	@GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(unique = true,name="user_id", columnDefinition = "VARCHAR(36)")
	private String userId;

	private String address;

	private String adharcardno;

	private String alternatemobileno;

	private ZonedDateTime createdat;

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

	public Object thenReturn(Class<UserInformation> class1) {
		UserInformation userinfo=new UserInformation();
		return userinfo;
	}





}