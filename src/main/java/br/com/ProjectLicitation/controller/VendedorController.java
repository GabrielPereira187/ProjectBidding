package br.com.ProjectLicitation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.ProjectLicitation.Repositories.VendedorRepository;
import br.com.ProjectLicitation.model.Vendedor;
@RestController
@Controller
public class VendedorController {
	
	
	@Autowired
	VendedorRepository repositorio;
	
	@GetMapping("/insertVendedor")
	public ModelAndView vendedor(Vendedor vendedor) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Vendedor/formVendedor");
		mv.addObject("vendedor", new Vendedor());
		return mv;
	}
	
	@GetMapping("/ListaVendedor")
	public ModelAndView ListVendedor(Vendedor vendedor) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Vendedor/ListaVendedores");
		mv.addObject("ListaVendedores", repositorio.findAll());
		return mv;
	}
	
	@PostMapping("/cadastrarVendedor")
	public ModelAndView insertVendedor(Vendedor vendedor) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/ListaVendedor");
		repositorio.save(vendedor);
		return mv;
	}
	
	
	@GetMapping("/alterarVendedor/{id}")
	public ModelAndView alterar(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Vendedor/alterarVendedor");
		Optional <Vendedor> vendedor = repositorio.findById(id);
		mv.addObject("vendedor", vendedor);
		return mv;
	}
	
	@PostMapping("/alterarVendedor")
	public ModelAndView alterar(Vendedor vendedor) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/ListaVendedor");
		repositorio.save(vendedor);
		return mv;
	}
	
	@GetMapping("/deletarVendedor/{id}")
	public ModelAndView deletar(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView();
		repositorio.deleteById(id);
		mv.setViewName("redirect:/ListaVendedor");
		return mv;
	}
	
	@GetMapping("/todos-vendedores")
	public List<Vendedor> listarVendedores(){
		return repositorio.findAll();
	}

}
