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
import br.com.ProjectLicitation.Repositories.EmpresaRepository;
import br.com.ProjectLicitation.model.Empresa;



@RestController
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
		mv.addObject("ListaEmpresas", repositorio.findAll());
		return mv;
	}
	
	@PostMapping("/cadastrarEmpresa")
	public ModelAndView inserirEmpresa(Empresa empresa) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/ListaEmpresa");
		repositorio.save(empresa);
		return mv;
	}
	
	@GetMapping("/alterarEmpresa/{id}")
	public ModelAndView alterar(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Empresa/alterarEmpresa");
		Optional <Empresa> empresa = repositorio.findById(id);
		mv.addObject("empresa", empresa);
		return mv;
	}
	
	@PostMapping("/alterarEmpresa")
	public ModelAndView alterar(Empresa empresa) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/ListaEmpresa");
		repositorio.save(empresa);
		return mv;
	}
	
	@GetMapping("/deletarEmpresa/{id}")
	public ModelAndView deletar(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView();
		repositorio.deleteById(id);
		mv.setViewName("redirect:/ListaEmpresa");
		return mv;
	}
	
	@GetMapping("/todas-empresas")
	public List<Empresa> listarEmpresas(){
		return repositorio.findAll();
	}
	
	@GetMapping("/buscarEmpresa/{id}")
	public Empresa buscar(@PathVariable("id") int id) {
		Empresa empresa = repositorio.findById(id).get();
		return empresa;
	}
	
	
}
