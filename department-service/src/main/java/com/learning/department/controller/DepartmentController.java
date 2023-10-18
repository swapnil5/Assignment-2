package com.learning.department.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.department.dtos.DepartmentResponse;
import com.learning.department.service.DepartmentService;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping
	public ResponseEntity<DepartmentResponse> save(@RequestBody DepartmentResponse departmentResponse) {
		
		return new ResponseEntity<>(departmentService.save(departmentResponse), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<DepartmentResponse>> getDepartments() {
		
		return ResponseEntity.ok(departmentService.getAllDepartments());
	}
	
	@GetMapping("/{code}")
	public ResponseEntity<DepartmentResponse> getByDepartmentCode(@PathVariable String code) {
		
		return ResponseEntity.ok(departmentService.findByDepartmentCode(code));
	}
	
}
