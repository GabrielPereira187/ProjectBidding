package br.com.ProjectLicitation.model;

import javax.persistence.Column;
//
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Produto {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "item")
	private int item;
	@Column(name = "description")
    private String descricao;
	@Column(nullable = false, name = "unity")
    private String unidade;
	@Column(nullable = false, name = "price")
    private double preco_unitario;
	
	

}
