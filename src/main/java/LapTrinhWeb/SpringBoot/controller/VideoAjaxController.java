package LapTrinhWeb.SpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import LapTrinhWeb.SpringBoot.service.CategoryService;
import LapTrinhWeb.SpringBoot.util.JwtUtils;

@Controller
@RequestMapping("/admin/videos-ajax")
public class VideoAjaxController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private JwtUtils jwtUtils;

	@GetMapping
	public String videosAjaxPage(Model model) {
		// Truyền danh sách categories để dùng trong form
		model.addAttribute("categories", categoryService.findAll());
		
		// Generate JWT for the current session user to use in AJAX calls
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			String username = ((UserDetails) principal).getUsername();
			String token = jwtUtils.generateToken(username);
			model.addAttribute("jwtToken", token);
		}
		
		return "admin/videos/ajax-list";
	}
}
