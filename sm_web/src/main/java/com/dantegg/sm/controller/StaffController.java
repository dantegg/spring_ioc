package com.dantegg.sm.controller;

import com.dantegg.sm.entity.Department;
import com.dantegg.sm.entity.Staff;
import com.dantegg.sm.service.DepartmentService;
import com.dantegg.sm.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller("staffController")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private DepartmentService departmentService;

    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Staff> list= staffService.getAll();
        request.setAttribute("LIST", list);
        request.getRequestDispatcher("../staff_list.jsp").forward(request, response);
    }

    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> list= departmentService.getAll();
        request.setAttribute("DLIST", list);
        request.getRequestDispatcher("../staff_add.jsp").forward(request, response);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String idNumber = request.getParameter("idNumber");
        String info = request.getParameter("info");
        Integer did = Integer.parseInt(request.getParameter("did"));
        Date bornDate = null;
        try {
            bornDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("bornDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Staff staff = new Staff();
        staff.setAccount(account);
        staff.setName(name);
        staff.setSex(sex);
        staff.setIdNumber(idNumber);
        staff.setInfo(info);
        staff.setBornDate(bornDate);
        staff.setDid(did);
        staffService.add(staff);
        response.sendRedirect("list.do");
    }

    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffService.get(id);
        List<Department> dlist= departmentService.getAll();
        request.setAttribute("DLIST", dlist);
        request.setAttribute("OBJ", staff);
        request.getRequestDispatcher("../staff_edit.jsp").forward(request, response);
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String sex = request.getParameter("sex");
        String name = request.getParameter("name");
        String info = request.getParameter("info");
        String idNumber = request.getParameter("idNumber");
        Date bornDate = null ;
        try {
            bornDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("bornDate"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Integer id = Integer.parseInt(request.getParameter("id"));
        Staff staff =staffService.get(id);
        staff.setAccount(account);
        staff.setSex(sex);
        staff.setName(name);
        staff.setInfo(info);
        staff.setIdNumber(idNumber);
        staff.setBornDate(bornDate);
        staffService.edit(staff);
        response.sendRedirect("list.do");
    }

    public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        staffService.remove(id);
        response.sendRedirect("list.do");
    }

    public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffService.get(id);
        request.setAttribute("OBJ", staff);
        request.getRequestDispatcher("../staff_detail.jsp").forward(request, response);
    }
}
