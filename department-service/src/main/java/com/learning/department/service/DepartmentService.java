package com.learning.department.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learning.department.dtos.DepartmentResponse;

@Service
public interface DepartmentService {

	DepartmentResponse save(DepartmentResponse departmentResponse);
	
	List<DepartmentResponse> getAllDepartments();

	DepartmentResponse findByDepartmentCode(String code);
}
