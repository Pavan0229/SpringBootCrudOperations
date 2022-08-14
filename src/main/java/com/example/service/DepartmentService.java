package com.example.service;

import java.util.List;

import com.example.entity.Department;
import com.example.error.DepartmentNotFoundException;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchDepartmentList();

	public Department fetchById(Long id) throws DepartmentNotFoundException;

	public void deleteById(Long id);

	public Department updateDepartment(Long id, Department department);

	Department getByName(String departName);

	

}
