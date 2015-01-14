package com.github.popemay.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.popemay.controller.model.ChangePassRequest;
import com.github.popemay.controller.model.UserRequest;
import com.github.popemay.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService service;

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public String createUser(@ModelAttribute("user") UserRequest user, BindingResult result, ModelMap model) {
		service.validate(user, result);
		if (result.hasErrors()) {
			return "createUser";
		} else {
			model.addAttribute("user", user);
			model.addAttribute("message", "Your account has been created successfully");
			service.save(user);
			return "mainPage";
		}
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		UserRequest user = new UserRequest();
		model.addAttribute("user", user);
		return "login";
	}

	@RequestMapping(value = "/users/create", method = RequestMethod.GET)
	public String showCreateUserPage(ModelMap model) {
		UserRequest user = new UserRequest();
		model.addAttribute("user", user);
		return "createUser";
	}

	@RequestMapping(value = "/users/update", method = RequestMethod.POST)
	public String updateInfo(UserRequest user, ModelMap model) {
		service.update(user);
		model.addAttribute("message", "Your information has been updated successfully");
		model.addAttribute("user", user);
		return "userInfo";
	}

	@RequestMapping(value = "/users/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("user") UserRequest user, ModelMap model) {
		if (service.rightInfo(user.getUsername(), user.getPassword())) {
			model.addAttribute("welcomeMessage", "Welcome to toyexchange, " + user.getUsername());
			return "mainPage";
		} else {
			model.addAttribute("user", user);
			model.addAttribute("errorInfo",
					"There was an error with your E-Mail/Password combination. Please try again.");
			return "login";
		}
	}

	@RequestMapping(value = "/users/userinfo", method = RequestMethod.GET)
	public String getInfo(@RequestParam("email") String email, ModelMap model) {
		model.addAttribute("user", service.find(email));
		return "userInfo";
	}

	@RequestMapping(value = "/users/privacy", method = RequestMethod.GET)
	public String getPrivacy(@RequestParam("email") String email, ModelMap model) {
		model.addAttribute("user", service.find(email));
		return "privacy";
	}

	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	@Produces(MediaType.TEXT_PLAIN_VALUE)
	@RequestMapping(value = "/users/updatePrivacy", method = RequestMethod.POST)
	public @ResponseBody String updatePrivacy(@RequestBody ChangePassRequest user) {
		System.out.println("ji");
		if (service.rightInfo(user.getUsername(), user.getOldPass())) {
			service.changePass(user);
			return "success";
		} else {
			return "failure";
		}
	}

	@RequestMapping(value = "/users/preference", method = RequestMethod.GET)
	public String getPreference(@RequestParam("email") String email, ModelMap model) {
		model.addAttribute("user", service.find(email));
		return "preference";
	}
}
