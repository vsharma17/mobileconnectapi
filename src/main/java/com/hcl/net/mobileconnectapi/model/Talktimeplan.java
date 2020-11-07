package com.hcl.net.mobileconnectapi.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the talktimeplan database table.
 * 
 */
@Data
@Setter
@Getter
@NoArgsConstructor
@Entity
@NamedQuery(name="Talktimeplan.findAll", query="SELECT t FROM Talktimeplan t")
public class Talktimeplan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="plan_id")
	private String planId;

	private String planname;

	private BigDecimal value;

	//bi-directional many-to-one association to UserInformation
	@OneToMany(mappedBy="talktimeplan")
	private List<UserInformation> userInformations;


}