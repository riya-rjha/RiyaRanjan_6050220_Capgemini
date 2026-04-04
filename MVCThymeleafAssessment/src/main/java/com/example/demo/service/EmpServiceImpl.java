package com.example.demo.service;

import com.example.demo.dto.EmpDTO;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmpRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpServiceImpl implements EmpService {

	private final EmpRepository repo;

	public EmpServiceImpl(EmpRepository repo) {
		this.repo = repo;
	}

	private EmpDTO convertToDTO(Employee emp) {
		if (emp == null)
			return null;

		EmpDTO dto = new EmpDTO();
		dto.setEmpId(emp.getEmpId());
		dto.setEmpName(emp.getEmpName());
		dto.setEmpSal(emp.getEmpSal());
		dto.setDeptName(emp.getDeptName());

		return dto;
	}

	private Employee convertToEntity(EmpDTO dto) {
		if (dto == null)
			return null;

		Employee emp = new Employee();
		emp.setEmpId(emp.getEmpId());
		emp.setEmpName(emp.getEmpName());
		emp.setEmpSal(emp.getEmpSal());
		emp.setDeptName(emp.getDeptName());

		return emp;
	}
	@Override
	public List<EmpDTO> getAllEmployees() {
		List<Employee> employeeList = repo.findAll();
		List<EmpDTO> dtoList = new ArrayList<>();
		for (Employee emp : employeeList) {
			EmpDTO dto = convertToDTO(emp);
			dtoList.add(dto);
		}

		return dtoList;
	}
	
	@Override
	public EmpDTO getEmployeeById(Integer id) {
		Employee emp = repo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

		return convertToDTO(emp);
	}

	@Override
	public void updateEmployee(EmpDTO dto) {
		Employee emp = convertToEntity(dto);
		repo.save(emp);
	}

	@Override
	public void deleteEmployee(Integer id) {
		repo.deleteById(id);
	}
}