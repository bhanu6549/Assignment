package com.mindtree.Employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.Employee.entity.Employee;
import com.mindtree.Employee.service.EmployeeService;

@Controller
public class AppController {
	@Autowired
	EmployeeService empSer;

	@RequestMapping("/")
	public String vieHomePage(Model model) {
		List<Employee> listOfEmployee = empSer.listAll();
		model.addAttribute("listOfEmployees", listOfEmployee);
		return "index";
	}

	@RequestMapping("/new")
	public String showNeEmployeePage(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);

		return "newEmployee";
	}

	@RequestMapping(value = "/save", method = { RequestMethod.GET, RequestMethod.POST })
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		empSer.save(employee);

		return "redirect:/";
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductpage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_employee");
		Employee employee = empSer.get(id);
		mav.addObject("employee", employee);
		return mav;
	}

	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		empSer.delete(id);
		return "redirect:/";
	}

}
