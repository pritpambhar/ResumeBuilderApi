package com.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Education {

	private Secondary secondary;
	private HigherSecondary higherSecondary;
	private Graduation graduation;
}
