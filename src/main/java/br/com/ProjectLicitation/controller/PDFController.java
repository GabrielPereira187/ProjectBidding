package br.com.ProjectLicitation.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.ProjectLicitation.Service.PdfService;
import br.com.ProjectLicitation.model.Pedido;


@RestController
@Controller

public class PDFController {
	
	
	@Autowired
	private PdfService service;
	
	@GetMapping("/gerador-pdf")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("PDF/GeradorPDF");
		return mv;
	}
	
	@RequestMapping(value="/gerar-pdf/{firstNameIds}/{cnpj}/{inscr}/{tel}/{email}/{cep}/{cidade}/{rua}/{bairro}/{numero}/{uf}/{rg}/{cpf}/{nome_empresa}/{nome_vendedor}"
			+ "/{nome_doc}/{nome_penit}/{nome_setor/{data}/{hora}/{pregao}/{processo}/{objeto}", method=RequestMethod.GET)
	@ResponseBody
	public void gerar(@PathVariable String[] firstNameIds,
			@PathVariable("cnpj") String cnpj,
			@PathVariable("inscr") String inscr,
			@PathVariable("tel") String tel,
			@PathVariable("email") String email,
			@PathVariable("cep") String cep,
			@PathVariable("cidade") String cidade,
			@PathVariable("rua") String rua,
			@PathVariable("bairro") String bairro,
			@PathVariable("numero") String numero,
			@PathVariable("uf") String estado,
			@PathVariable("rg") String rg,
			@PathVariable("cpf") String cpf,
			@PathVariable("cargo") String cargo,
			@PathVariable("nome_empresa") String nomeE,
			@PathVariable("nome_vendedor") String nomeV,
			@PathVariable("nome_doc") String nomeD,
			@PathVariable("nome_penit") String nomeP,
			@PathVariable("nome_setor") String nomeS,
			@PathVariable("data") String data,
			@PathVariable("hora") String hora,
			@PathVariable("pregao") String pregao,
			@PathVariable("processo") String processo,
			@PathVariable("objeto") String objeto
			) 
	{
		ArrayList<Pedido> produtos = new ArrayList<Pedido>();
		
		int cont = 0;
		for(int i = 0; i < firstNameIds.length + 6; i++) {
		
			if(cont==6) {
				Pedido pedido = new Pedido();
				pedido.setItem(firstNameIds[cont - 6]);
				pedido.setDescricao(firstNameIds[cont - 5]);
				pedido.setUnidade(firstNameIds[cont - 4]);
				pedido.setPreco_unitario(firstNameIds[cont - 3]);
				pedido.setQtde(firstNameIds[cont - 2]);
				pedido.setVtotal(firstNameIds[cont - 1]);
				produtos.add(pedido);
				cont=0;
			}
			
			if(cont < 6) {
				cont++;
			}
			
		}
		
		service.gerarPDF(produtos,
				cnpj,
				inscr,
				tel,
				email,
				cep,
				cidade,
				rua,
				bairro,
				numero,
				estado,
				rg,
				cpf,
				cargo,
				nomeE,
				nomeV,
				nomeD,
				nomeP,
				nomeS,
				data,
				hora,
				pregao,
				processo,
				objeto); 
	}

}
