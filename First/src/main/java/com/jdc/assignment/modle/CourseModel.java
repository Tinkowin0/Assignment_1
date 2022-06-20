package com.jdc.assignment.modle;

import java.util.List;

import com.jdc.assignment.domain.Course;

public interface CourseModel {

	List<Course> getAll();

	public void save(Course course);

	Course findById(int id);
}
