package com.dantegg.sm.dao;


import com.dantegg.sm.entity.Staff;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author dantegg
 */
@Repository("staffDao")
public interface StaffDao {

    void insert(Staff staff);
    void delete(Integer id);
    void update(Staff staff);
    Staff selectById(Integer id);
    List<Staff> selectAll();
}
