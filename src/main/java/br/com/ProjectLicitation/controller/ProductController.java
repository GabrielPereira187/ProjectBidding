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

import br.com.ProjectLicitation.Repositories.ProdutoRepository;
import br.com.ProjectLicitation.model.Produto;


@RestController
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
	
	
	@GetMapping("/ListaProduto")
	public ModelAndView Listproduct(Produto produto) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Produto/ListaProdutos");
		mv.addObject("ListaProdutos", repository.findAll());
		return mv;
	}
	
	@PostMapping("insertProduct")
	public ModelAndView inserirProduto(Produto produto) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/ListaProduto");
		repository.save(produto);
		return mv;
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Produto/AlterarProduto");
		Optional <Produto> produto = repository.findById(id);
		mv.addObject("produto", produto);
		return mv;
		
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Produto produto) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/ListaProduto");
		repository.save(produto);
		return mv;
	}
	
	@GetMapping("/deletar/{id}")
	public ModelAndView deletar(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView();
		repository.deleteById(id);
		mv.setViewName("redirect:/ListaProduto");
		return mv;
	}
	
	@GetMapping("/buscarItem/{item}")
	public List<Produto> buscarItem(@PathVariable("item") int item) {
		return repository.findByitem(item);
	}
	
	@GetMapping("/todos-produtos")
	public List<Produto> listarProdutos() {
		return repository.findAll();
	}

	

}
