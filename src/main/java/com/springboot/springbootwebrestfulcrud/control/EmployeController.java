package com.springboot.springbootwebrestfulcrud.control;

import com.springboot.springbootwebrestfulcrud.dao.DepartmentDao;
import com.springboot.springbootwebrestfulcrud.dao.EmployeeDao;
import com.springboot.springbootwebrestfulcrud.entities.Department;
import com.springboot.springbootwebrestfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

/**
 * 员工管理控制类
 */
@Controller
public class EmployeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;


    /**
     * 查询所有员工信息返回列表页面
     * get请求方式
     * @return
     */
    @GetMapping("/emps")
    public String getEmpList(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps",all);
        return "/emp/list";
    }

    /**
     * 跳转到员工添加界面
     * @return
     */
    @GetMapping("/emp")
    public String toAddEmp(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "/emp/add";
    }

    /**
     * 添加员工
     * @return
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        //重定向到/emps 请求
        return "redirect:/emps";
    }

    /**
     * 跳转到员工修改页面
     * 先根据id查询员工信息，在跳转到修改新增二合一页面显示
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/emp/{id}")
    public String toEdit(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        //查询出所有部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //add页面是修改添加二合一页面
        return "/emp/add";
    }

    /**
     * 员工信息修改
     * 采用put请求方式
     * @param employee
     * @return
     */
    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    /**
     * 根据id删除员工信息
     * 采用delete请求方式
     * @param id
     * @return
     */
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
