package com.dantegg.sm.service;

import com.dantegg.sm.entity.Department;

import java.util.List;

/**
 * @author dantegg
 */
public interface DepartmentService {
    void add(Department department);
    void remove(Integer id);
    void edit(Department department);
    Department get(Integer id);
    List<Department> getAll();
}
