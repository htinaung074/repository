package com.htinaung.DAO;

import java.sql.SQLException;


import com.htinaung.entities.Course;


public interface CourseDAOInterface {
	
	public String insert(Course course)throws SQLException;
}
