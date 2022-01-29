package com.student.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	private int id;

	private String name;

	private int roll_no;

	private String college;

	private float physics;

	private float chemistry;

	private float biology;

	private float Maths;

	private float english;

	private float computers;

	private float percentage;
	
	private String ranking;

	public Student() {

	}

	/**
	 * @param id
	 * @param name
	 * @param roll_no
	 * @param college
	 * @param physics
	 * @param chemistry
	 * @param biology
	 * @param maths
	 * @param english
	 * @param computers
	 * @param percentage
	 */
	public Student(int id, String name, int roll_no, String college, float physics, float chemistry, float biology,
			float maths, float english, float computers, float percentage) {
		super();
		this.id = id;
		this.name = name;
		this.roll_no = roll_no;
		this.college = college;
		this.physics = physics;
		this.chemistry = chemistry;
		this.biology = biology;
		Maths = maths;
		this.english = english;
		this.computers = computers;
		this.percentage = percentage;
	}
	
	

	/**
	 * @param physics
	 * @param chemistry
	 * @param biology
	 * @param maths
	 * @param english
	 * @param computers
	 */
	public Student(float physics, float chemistry, float biology, float maths, float english, float computers) {
		super();
		this.physics = physics;
		this.chemistry = chemistry;
		this.biology = biology;
		Maths = maths;
		this.english = english;
		this.computers = computers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRoll_no() {
		return roll_no;
	}

	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public float getPhysics() {
		return physics;
	}

	public void setPhysics(float physics) {
		this.physics = physics;
	}

	public float getChemistry() {
		return chemistry;
	}

	public void setChemistry(float chemistry) {
		this.chemistry = chemistry;
	}

	public float getBiology() {
		return biology;
	}

	public void setBiology(float biology) {
		this.biology = biology;
	}

	public float getMaths() {
		return Maths;
	}

	public void setMaths(float maths) {
		Maths = maths;
	}

	public float getEnglish() {
		return english;
	}

	public void setEnglish(float english) {
		this.english = english;
	}

	public float getComputers() {
		return computers;
	}

	public void setComputers(float computers) {
		this.computers = computers;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public String getRankings() {
		return ranking;
	}

	public void setRankings(String rankings) {
		this.ranking = rankings;
	}
	
	
}
