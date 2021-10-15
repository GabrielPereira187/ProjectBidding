package br.com.ProjectLicitation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empresa {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    private String nome;
    private String cnpj;
    private String inscricao_estadual;
    private String telefone;
    private String email;
    private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;
}
