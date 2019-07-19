package com.danhuang.springboot.mapper;

import com.danhuang.springboot.bean.Employee;

//@Mapper或者MapperScan将接口扫描装配到容器中
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);
}
