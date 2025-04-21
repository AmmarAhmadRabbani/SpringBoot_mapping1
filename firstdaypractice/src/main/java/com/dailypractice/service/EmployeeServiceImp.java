package com.dailypractice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dailypractice.dto.EmployeeDto;
import com.dailypractice.entity.Employee;
import com.dailypractice.exception.UserNotFoundException;
import com.dailypractice.repositoer.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto add(EmployeeDto dto) {
		if (dto != null) {
			Employee employee = new Employee();
			BeanUtils.copyProperties(dto, employee);
			Employee save = employeeRepository.save(employee);
			EmployeeDto employeeDto = new EmployeeDto();
			BeanUtils.copyProperties(save, employeeDto);
			return employeeDto;

		}

		throw new UserNotFoundException("invalied feilds");
	}

	@Override
	public List<EmployeeDto> getAll() {
		List<EmployeeDto> dtos = new ArrayList<>();
		List<Employee> findAll = employeeRepository.findAll();
		if (!findAll.isEmpty()) {
			findAll.forEach(i -> {
				EmployeeDto employeeDto = new EmployeeDto();
				BeanUtils.copyProperties(i, employeeDto);
				dtos.add(employeeDto);
			});
			return dtos;
		}
		throw new UserNotFoundException("details not available");
	}

	@Override
	public EmployeeDto getById(long empId) {
		Employee orElseThrow = employeeRepository.findById(empId)
				.orElseThrow(() -> new UserNotFoundException("invalid id"));
		EmployeeDto employeeDto = new EmployeeDto();
		BeanUtils.copyProperties(orElseThrow, employeeDto);
		return employeeDto;
	}

	@Override
	public EmployeeDto deleteById(long empId) {
		Employee orElseThrow = employeeRepository.findById(empId)
				.orElseThrow(() -> new UserNotFoundException("invalid id"));
		employeeRepository.deleteById(empId);
		return new EmployeeDto();
	}

	@Override
	public EmployeeDto update(EmployeeDto dto) {
		Employee orElseThrow = employeeRepository.findById(dto.getEmpId())
				.orElseThrow(() -> new UserNotFoundException("updation failed"));
		BeanUtils.copyProperties(dto, orElseThrow);
		employeeRepository.save(orElseThrow);
		BeanUtils.copyProperties(orElseThrow, dto);
		return dto;
	}

}
