package com.answer1991.mvc.controller.root;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Servlet级别的错误
 * @author Joe
 *
 */
@Controller
public class ErrorController {
	private static final String ATTR_STATUS_CODE_NAME = "javax.servlet.error.status_code";
	private static final String ATTR_ERROR_MESSAGE_NAME = "javax.servlet.error.message";
	
	@RequestMapping("/servletError")
	public String redirect(RedirectAttributes model, HttpServletRequest request) {
		model.addFlashAttribute("code", request.getAttribute(ATTR_STATUS_CODE_NAME));
		model.addFlashAttribute("message", request.getAttribute(ATTR_ERROR_MESSAGE_NAME));
		return "redirect:/error";
	}

	@RequestMapping("/error")
	public String redirect(Model model) {
		return "error";
	}
}
