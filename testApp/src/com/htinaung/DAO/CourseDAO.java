package com.htinaung.DAO;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.htinaung.entities.Course;
import com.htinaung.mapper.MAPPER_COURSE;

@Repository(value = "courseDAO")
public class CourseDAO implements CourseDAOInterface {
	@Autowired
	MAPPER_COURSE mappercourse;

	@Transactional(propagation = Propagation.REQUIRED)
	public String insert(Course course) throws SQLException {
		mappercourse.INSERT(course);
		return "success";
	}
}
