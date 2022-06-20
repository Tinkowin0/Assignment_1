package com.jdc.assignment.modle;

import java.util.List;

import com.jdc.assignment.domain.OpenClass;

public interface OpenClassModel {

	public List<OpenClass> findByCourse(int courseId);

	void creat(OpenClass openClass);

	OpenClass findByOPId(int op_id);

}
