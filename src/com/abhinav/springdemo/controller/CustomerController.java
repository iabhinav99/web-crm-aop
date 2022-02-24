package com.abhinav.springdemo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.abhinav.springdemo.entity.Customer;
import com.abhinav.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// Need to inject CustomerService
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String getCustomer(Model theModel) {
		
		//Get Customers from DAO
		List<Customer> theCustomers=customerService.getCustomer();
		
		// Add customers to the Model
		theModel.addAttribute("customers",theCustomers);
			
		return "customer-list";
	}
	
	// Display page to Add Customer
	@GetMapping("/showSaveForm")
	public String showCustomerForm(Model theModel) {
		
		Customer theCustomer= new Customer();
		theModel.addAttribute("customerform", theCustomer);
		
		return "customer-form";
	}
	
	// Add customer and display all the customer
	@PostMapping("/processForm")
	public String saveCustomerForm(@ModelAttribute("customerform") Customer theCustomer ) {
		
		customerService.saveCustomer(theCustomer);
	 
		return "redirect:/customer/list";
	}
	
	//Show the Updated form 
	@GetMapping("/showUpdateForm")
    public String showUpdateForm(@RequestParam(name="customer_id") int theId, Model theModel) {
		
		Customer theCustomer=customerService.getCustomer(theId);
		theModel.addAttribute("customerform", theCustomer);
		return "customer-form";
	}
	
	// Delete the Customer
	@GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam(name="customer_id") int theId) {
		
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
	
	
	// Show the Updated form via Button
	@PostMapping("/updateForm")
    public String UpdateForm(HttpServletRequest request, Model theModel) {
		
		String requstId=request.getParameter("id");
		int theId=Integer.parseInt(requstId);
		Customer theCustomer=customerService.getCustomer(theId);
		theModel.addAttribute("customerform", theCustomer);
		return "customer-form";
	}
	
	
	
}
