package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.metadata.DerbyCallMetaDataProvider;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Department;
import com.example.error.DepartmentNotFoundException;
import com.example.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		logger.info("inside Save Department of DepartmentController");
		return departmentService.saveDepartment(department);
	}

	@GetMapping("/departments")
	public List<Department> fetchDepartmentList() {
		logger.info("inside getAll Department of DepartmentController");
		return departmentService.fetchDepartmentList();
	}

	@GetMapping("/departments/{id}")
	public Department fetchDepartmentId(@PathVariable(name = "id") Long id) throws DepartmentNotFoundException {
		logger.info("inside getId Department of DepartmentController");
		return departmentService.fetchById(id);
	}

	@DeleteMapping("/departments/{id}")
	public String departmentbyId(@PathVariable(name = "id") Long id) {
		departmentService.deleteById(id);
		return "Delete Department Successfully";
	}

	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable(name = "id") Long id, @RequestBody Department department) {
		return departmentService.updateDepartment(id, department);
	}

	@GetMapping("/departments/name/{name}")
	public Department getByName(@PathVariable(name = "name") String departmentName) {
		return departmentService.getByName(departmentName);
	}
}
