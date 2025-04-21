package com.dailypractice.service;

import java.util.List;

import com.dailypractice.dto.EmployeeDto;

public interface EmployeeService {

	public EmployeeDto add(EmployeeDto dto);

	public List<EmployeeDto> getAll();

	public EmployeeDto getById(long empId);

	public EmployeeDto deleteById(long empId);

	public EmployeeDto update(EmployeeDto dto);

}
