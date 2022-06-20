package com.jdc.assignment.modle;

import java.util.List;

import com.jdc.assignment.domain.Registration;

public interface RegistrationModel {

	public List<Registration> findByClass(int open_class_id);

	void input(Registration reg);
}
