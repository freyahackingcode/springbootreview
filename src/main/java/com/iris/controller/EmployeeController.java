package com.iris.controller;

import com.iris.dao.DepartmentDao;
import com.iris.dao.EmployeeDao;
import com.iris.pojo.Department;
import com.iris.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.List;

/**
 * Description:
 * Author: zyq
 * Version: 1.0
 * Create Date Time: 2022/6/5 16:58.
 * Update Date Time:
 *
 * @see
 */
@Controller
public class EmployeeController {

    @Autowired
    public EmployeeDao employeeDao;

    @Autowired
    public DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String emps(Model model){
        Collection<Employee> emps = employeeDao.getAll();
        model.addAttribute("emps", emps);
        return "emp/list";
    }

    @RequestMapping("/toAddEmp")
    public String toAddEmp(Model model){
        Collection<Department> depts = departmentDao.getDepartments();
        model.addAttribute("depts", depts);
        return "emp/toAddEmp";
    }
    @RequestMapping("/addEmp")
    public String addEmp(Employee employee){
        System.out.println("save employee:" + employee);
        employeeDao.add(employee);
        return "redirect:/emps ";
    }


    @RequestMapping("/toEditEmp")
    public String toEditEmp(@RequestParam("id") String id, Model model){
        Employee employee = employeeDao.getEmployeeById(Integer.parseInt(id));
        model.addAttribute("emp", employee);
        Collection<Department> depts = departmentDao.getDepartments();
        model.addAttribute("depts", depts);
        return "emp/edit";
    }

    @RequestMapping("/editEmp")
    public String editEmp(Employee employee, Model model){

        System.out.println("editEmp:"+employee);
        employeeDao.add(employee);
        return "redirect:/emps";
    }
    @RequestMapping("/deleteEmp")
    public String deleteEmp(@RequestParam("id") String id){
        employeeDao.delete(Integer.parseInt(id));
        return "redirect:/emps";
    }
}
