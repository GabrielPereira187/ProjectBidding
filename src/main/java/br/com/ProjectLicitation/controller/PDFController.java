package br.com.ProjectLicitation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Controller

public class PDFController {
	
	@GetMapping("/gerador-pdf")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("PDF/GeradorPDF");
		return mv;
	}
	

}
