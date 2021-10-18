package br.com.ProjectLicitation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.ProjectLicitation.model.Vendedor;

@Controller
public class VendedorController {
	
	
	
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
		mv.addObject("vendedor", new Vendedor());
		return mv;
	}

}
