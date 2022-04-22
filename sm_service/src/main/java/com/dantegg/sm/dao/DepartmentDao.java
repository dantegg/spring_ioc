package com.dantegg.sm.dao;

import com.dantegg.sm.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author dantegg
 */
@Repository("departmentDao")
public interface DepartmentDao {

    void insert(Department department);
    void delete(Integer id);
    void update(Department department);
    Department searchById(Integer id);
    List<Department> selectAll();
}
