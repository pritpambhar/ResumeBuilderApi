package com.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

@Document
public class Resume {

	@Id
	private String id;
	private GeneralInfo generalInfo;
	private PublicProfile profile;
	private Education education;
	private Internships internships;
	private Projects projects;
	private Skills skills;
	private Achievements achievements;
	private Certifications certifications;
	private Extracurriculars extracurriculars;
	private Interests interests;
	private Positions positions;
}
