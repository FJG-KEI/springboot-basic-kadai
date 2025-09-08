package com.example.springkadaiform.controller;

import org.springframework.core.Conventions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaiform.form.ContactForm;

@Controller
public class ContactFormController {
	
	@GetMapping("/form")
	public String contactForm(Model model) {
		
		if(!model.containsAttribute("contactForm")) {
			model.addAttribute("contactForm", new ContactForm());
		}
		
		return "contactFormView";
	}
	
	@PostMapping("/confirm")
	public String confirmView(RedirectAttributes redirectAttributes,
			@Validated ContactForm contactForm, BindingResult result) {
		
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("contactForm", contactForm);
			redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX
					+ Conventions.getVariableName(contactForm), result);
			
			return "redirect:/form";
		}
		
		redirectAttributes.addFlashAttribute("contactForm", contactForm);
		return "confirmView";
	}
	
}
