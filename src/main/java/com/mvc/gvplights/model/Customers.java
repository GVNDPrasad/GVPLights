package com.mvc.gvplights.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.mvc.gvplights.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Customers {
	
	@Id
	@GeneratedValue
	@Column(name="CUS_ID")
	private Integer cusId;
	
	@Column(name="FIRST_NAME")
	private String fname;
	
	@Column(name="LAST_NAME")
	private String lname;
	
	@Column(name="USER_NAME")
	private String uname;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="GENDER")
	@Enumerated(EnumType.STRING)
	private Gender gender;	
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="DOB")
	private Date dob;
	
	@Column(name="EMAIL_ID")
	private String email;
	
	@Column(name="CONTACT_NO")
	private String phone;
	
	@Column(name="ADDRESS")
	private String address; 
	
	@Column(name="TYPE_OF_ADDRESS")
	private String typeOfAddress; // Permanent or Temporary
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="CUSTOMERS_ID_PROOFS_TAB", joinColumns = @JoinColumn(name="CUS_ID"))
	@Column(name="ID_PROOF")
	private List<String> idProof; // Aadhar or Passport or Voter or Driving License or Pancard
	
	/*
	 * @ElementCollection
	 * 
	 * @CollectionTable(name="CUSTOMERS_TYPE_TAB",joinColumns
	 * = @JoinColumn(name="CUS_ID"))
	 */
	@Column(name="TYPE_OF_CUSTOMER")
	private String customerType; // Member or Normal
	
	

}
