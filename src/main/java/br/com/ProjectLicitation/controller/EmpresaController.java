package br.com.ProjectLicitation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ProjectLicitation.model.Empresa;
import br.com.ProjectLicitation.model.Produto;

@Controller
public class EmpresaController {

	
	@GetMapping("/insertEmpresa")
	public ModelAndView empresa(Empresa empresa) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Empresa/formEmpresa");
		mv.addObject("empresa", new Empresa());
		return mv;
	}
	
	@GetMapping("/ListaEmpresa")
	public ModelAndView ListEmpresa(Produto produto) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Empresa/ListaEmpresas");
		mv.addObject("empresa", new Empresa());
		return mv;
	}
}
