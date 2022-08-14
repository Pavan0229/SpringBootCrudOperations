package com.example.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Department;
import com.example.error.DepartmentNotFoundException;
import com.example.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> fetchDepartmentList() {
		return departmentRepository.findAll();
	}

	@Override
	public Department fetchById(Long id) throws DepartmentNotFoundException {
		Optional<Department> department = departmentRepository.findById(id);
			if (!department.isPresent()) {
				throw new DepartmentNotFoundException("Department Not Avaiable");
			}
			return department.get();
	}

	@Override
	public void deleteById(Long id) {
		departmentRepository.deleteById(id);

	}

	@Override
	public Department updateDepartment(Long id, Department department) {
		Department deptDb = departmentRepository.findById(id).get();

		if (Objects.nonNull(department.getDepartementName()) && !"".equalsIgnoreCase(department.getDepartementName())) {
			deptDb.setDepartementName(department.getDepartementName());
		}
		if (Objects.nonNull(department.getDepartmentAddress())
				&& !"".equalsIgnoreCase(department.getDepartmentAddress())) {
			deptDb.setDepartmentAddress(department.getDepartmentAddress());
		}
		if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
			deptDb.setDepartmentCode(department.getDepartmentCode());
		}

		return departmentRepository.save(deptDb);
	}

	@Override
	public Department getByName(String departName) {

		return departmentRepository.findByDepartementNameIgnoreCase(departName);
	}

}
