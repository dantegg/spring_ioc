package com.dantegg.sm.service.impl;

import com.dantegg.sm.dao.DepartmentDao;
import com.dantegg.sm.entity.Department;
import com.dantegg.sm.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dantegg
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    public void add(Department department) {
        departmentDao.insert(department);
    }

    public void remove(Integer id) {
        departmentDao.delete(id);
    }

    public void edit(Department department) {
        departmentDao.update(department);
    }

    public Department get(Integer id) {
        return departmentDao.searchById(id);
    }

    public List<Department> getAll() {
        return departmentDao.selectAll();
    }
}
