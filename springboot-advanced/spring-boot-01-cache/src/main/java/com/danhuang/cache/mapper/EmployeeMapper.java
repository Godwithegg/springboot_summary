package com.danhuang.cache.mapper;

import com.danhuang.cache.bean.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where id = #{id}")
    Employee getEmpById(Integer id);

    @Update("update employee set lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{dId} where id=#{id}")
    void updateEmployee(Employee employee);

    @Delete("delete from employee where id=#{id}")
    void deleteEmpById(Integer id);

    @Insert("insert into employee(lastName,email,gender,d_id) values(#{lastName},#{email},#{gender},#{dId})")
    void insertEmployee(Employee employee);

    @Select("select * from employee where lastName=#{lastName}")
    Employee getEmpByLastName(String lastName);
}
