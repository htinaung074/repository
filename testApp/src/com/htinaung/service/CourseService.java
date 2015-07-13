package com.htinaung.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.htinaung.DAO.CourseDAOInterface;
import com.htinaung.entities.Course;

@Service(value="courseService")
public class CourseService implements CourseServiceInterface {
	@Autowired
	private CourseDAOInterface courseDAO;

	@Transactional(propagation=Propagation.REQUIRED)
	public void saveCourse(Course course) {
		try {
			courseDAO.insert(course);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
