package com.htinaung.entities;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.htinaung.DTO.CourseDTO;

public class Course {

	public Course(CourseDTO courseDTO) {
		this.setCourseNumber(courseDTO.getCourseNumber());
		this.setCourseName(courseDTO.getCourseName());
		this.setCourseDateYYYYMMDD(courseDTO.getYear() + "/" + courseDTO.getMonth()
				+ "/" + courseDTO.getDay());
		this.setTimeOfOpen(courseDTO.getOpenHr() + ":" + courseDTO.getOpenMin());
		this.setTimeOfEnd(courseDTO.getEndHr() + ":" + courseDTO.getEndMin());
		this.setCapicity(Integer.valueOf(courseDTO.getCapicity()));
	}

	private String courseNumber;
	private String courseName;
	private Date courseDate;
	private String timeOfOpen;
	private String timeOfEnd;
	private int capicity;
	private Date createDate;
	private Date updateDate;

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Date getCourseDate() {
		return courseDate;
	}

	public void setCourseDate(Date courseDate) {
		this.courseDate = courseDate;
	}

	public void setCourseDateYYYYMMDD(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
			this.courseDate = new Date(sdf.parse(date).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public String getTimeOfOpen() {
		return timeOfOpen;
	}

	public void setTimeOfOpen(String timeOfOpen) {
		this.timeOfOpen = timeOfOpen;
	}

	public String getTimeOfEnd() {
		return timeOfEnd;
	}

	public void setTimeOfEnd(String timeOfEnd) {
		this.timeOfEnd = timeOfEnd;
	}

	public int getCapicity() {
		return capicity;
	}

	public void setCapicity(int capicity) {
		this.capicity = capicity;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


}
