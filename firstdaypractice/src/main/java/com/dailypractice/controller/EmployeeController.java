package com.dailypractice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dailypractice.dto.EmployeeDto;
import com.dailypractice.response.SuccessResponse;
import com.dailypractice.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("add")
	public ResponseEntity<SuccessResponse> add(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto add = employeeService.add(employeeDto);
		if (add != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "added successfully", add), HttpStatus.OK);
		}
		return new ResponseEntity<>(new SuccessResponse(true, "adding failed", null), HttpStatus.BAD_REQUEST);
	}

	@GetMapping("getAll")
	public ResponseEntity<SuccessResponse> getAll() {
		List<EmployeeDto> all = employeeService.getAll();
		if (all != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "successfull", all), HttpStatus.OK);
		}
		return new ResponseEntity<>(new SuccessResponse(true, "getting failed", null), HttpStatus.BAD_REQUEST);
	}

	@GetMapping("get/{empId}")
	public ResponseEntity<SuccessResponse> getById(@PathVariable long empId) {
		EmployeeDto byId = employeeService.getById(empId);
		if (byId != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "get successfully", byId), HttpStatus.OK);
		}
		return new ResponseEntity<>(new SuccessResponse(true, "failed", null), HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("delete/{empId}")
	public ResponseEntity<SuccessResponse> deleteById(@PathVariable long empId) {
		EmployeeDto deleteById = employeeService.deleteById(empId);
		if (deleteById != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "deleted", deleteById), HttpStatus.OK);
		}
		return new ResponseEntity<>(new SuccessResponse(true, "deletion failed", null), HttpStatus.BAD_REQUEST);
	}

	@PutMapping("update")
	public ResponseEntity<SuccessResponse> updateEmployee(@RequestBody EmployeeDto dto) {
		EmployeeDto update = employeeService.update(dto);
		if (update != null) {
			return new ResponseEntity<>(new SuccessResponse(false, "updated", update), HttpStatus.OK);
		}
		return new ResponseEntity<>(new SuccessResponse(true, "updation failed", null), HttpStatus.BAD_REQUEST);
	}

}
