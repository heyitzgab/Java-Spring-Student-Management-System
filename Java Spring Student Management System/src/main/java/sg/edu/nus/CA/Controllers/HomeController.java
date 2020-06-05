package sg.edu.nus.CA.Controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import sg.edu.nus.CA.Model.Staff;
import sg.edu.nus.CA.Model.Student;
import sg.edu.nus.CA.Model.UserSession;
import sg.edu.nus.CA.Repository.*;

@Controller
@RequestMapping("/sms")
public class HomeController {

	@Autowired
	StudentRepository stdrepo;

	@Autowired
	FacultyRepository Frepo;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		
	}

	@GetMapping("/home")
	public String getHome() {
		return "home";
	}

	@GetMapping("/Studentlogin")
	public String StudentLoginPage(Model model) {
		model.addAttribute("student", new Student());
		return "Studentlogin";
	}

	@GetMapping("/logout")
	public String getLogoutPage(SessionStatus status) {
		status.setComplete();
		return "home";
	}

	@PostMapping("/Sauthenticate")
	public String getSAuthentication(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult,Errors E,
			HttpSession session)
	{
		if(E.hasErrors()) {
			System.out.println("start!");
			return "Studentlogin";
		}
		else {
		//int userId = student.getId();
			String username= student.getEmailID();
		String Password = student.getPassword();
		Student s = stdrepo.findStudentByEmailID(username);
		if(s==null) {
			return "Studentlogin";
		}
		if (s.getPassword().equals(Password)) {
			session.setAttribute("userinfo", student);
			stdrepo.updateSessionId(s.getId(), session.getId());
			return "redirect:/student/Home";
		} else
			return "Studentlogin";
	}
	}

	@GetMapping("/Facultylogin")
	public String FacultyLoginPage(Model model) {
		model.addAttribute("staff", new Staff());
		return "Facultylogin";
	}

	@PostMapping("/Fauthenticate")
	public String getFAuthentication(@Valid @ModelAttribute("staff") Staff staff, BindingResult bindingResult,Errors E,HttpSession session) 
	{
		if(E.hasErrors()) {
			System.out.println("start!");
			return "Facultylogin";
			}
		else {
		
		String userId = staff.getName();
		String Password = staff.getPassword();

//		Staff st = Frepo.findStaffByid(userId);
		Staff st = Frepo.findStaffByname(userId);
		if(st==null) {
			return "Facultylogin";
		}
		if (st.getPassword().equals(Password) && st.getRole() == 2) {
			String username=st.getName();
			session.setAttribute("fsession", username);
			return "redirect:/faculty/masterlist";
		} else {
			System.out.println("Not a valid user!");
			return "Facultylogin";
		}
	}
	}

	@GetMapping("/Adminlogin")
	public String AdminLoginPage(Model model) {

		model.addAttribute("staff", new Staff());
		return "Adminlogin";
	}

	@PostMapping("/Adauthenticate")
	public String getAdAuthentication(@Valid @ModelAttribute("staff") Staff staff, BindingResult bindingResult, Errors E) 
	{
		if(E.hasErrors()) {
			System.out.println("start!");
			return "Facultylogin";
			}
		else {
		//String userId = staff.getId();
		String userId = staff.getName();
		String Password = staff.getPassword();

		Staff st = Frepo.findStaffByname(userId);
		if(st == null) {
			return "Adminlogin";
		}
		if (st.getPassword().equals(Password) && st.getRole() == 1) {
			return "redirect:/Admin/AdminHome";
		} else {
			System.out.println("Not a valid user!");
			return "Adminlogin";
		}
	}
	}

}
