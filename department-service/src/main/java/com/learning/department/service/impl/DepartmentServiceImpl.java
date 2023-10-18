package com.learning.department.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.department.dtos.DepartmentResponse;
import com.learning.department.model.Department;
import com.learning.department.repository.DepartmentRepository;
import com.learning.department.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public DepartmentResponse save(DepartmentResponse departmentResponse) {
		
		return modelMapper.map(departmentRepository.save(modelMapper.map(departmentResponse, Department.class)), 
							DepartmentResponse.class);
	}

	@Override
	public List<DepartmentResponse> getAllDepartments() {
		return departmentRepository.findAll().stream().map(d -> modelMapper.map(d, DepartmentResponse.class)).toList();
	}

	@Override
	public DepartmentResponse findByDepartmentCode(String code) {
		return modelMapper.map(departmentRepository.findByDepartmentCode(code), DepartmentResponse.class);
	}

}
