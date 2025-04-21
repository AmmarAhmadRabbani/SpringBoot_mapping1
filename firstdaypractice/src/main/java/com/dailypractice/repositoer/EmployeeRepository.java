package com.dailypractice.repositoer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailypractice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
