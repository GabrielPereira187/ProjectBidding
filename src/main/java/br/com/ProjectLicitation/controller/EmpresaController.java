package br.com.ProjectLicitation.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ProjectLicitation.Repositories.EmpresaRepository;

import br.com.ProjectLicitation.model.Empresa;



@Controller
public class EmpresaController {

	@Autowired
	EmpresaRepository repositorio;
	
	@GetMapping("/insertEmpresa")
	public ModelAndView empresa(Empresa empresa) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Empresa/formEmpresa");
		mv.addObject("empresa", new Empresa());
		return mv;
	}
	
	@GetMapping("/ListaEmpresa")
	public ModelAndView ListEmpresa(Empresa empresa) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Empresa/ListaEmpresas");
		mv.addObject("empresa", new Empresa());
		return mv;
	}
	
	@PostMapping("/cadastrarEmpresa")
	public ModelAndView inserirEmpresa(Empresa empresa) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/ListaEmpresa");
		repositorio.save(empresa);
		return mv;
	}
}