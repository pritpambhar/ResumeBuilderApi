package com.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GeneralInfo {
	private String firstName;
	private String lastName;
	private String email;
	private String mobileNo;
	private String address;
}
