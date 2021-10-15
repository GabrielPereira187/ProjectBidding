package br.com.ProjectLicitation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ProjectLicitation.Repositories.ProdutoRepository;
import br.com.ProjectLicitation.model.Produto;

@Controller
public class ProductController {
	
	@Autowired
	private ProdutoRepository repository;
	
	
	@GetMapping("/insertProduto")
	public ModelAndView product(Produto produto) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Produto/formProduct");
		mv.addObject("produto", new Produto());
		return mv;
	}
	
	@PostMapping("insertProduct")
	public ModelAndView inserirProduto(Produto produto) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/Home/index");
		repository.save(produto);
		return mv;
	}

}
