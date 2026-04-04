package com.example.demo.service;

import com.example.demo.dto.EmpDTO;
import java.util.List;

public interface EmpService {

	List<EmpDTO> getAllEmployees();

	EmpDTO getEmployeeById(Integer id);

	void updateEmployee(EmpDTO dto);

	void deleteEmployee(Integer id);
}