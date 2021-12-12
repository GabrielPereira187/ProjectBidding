package br.com.ProjectLicitation.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
	
	private String item;
    private String descricao;
    private String unidade;
    private String preco_unitario;
    private String qtde;
    private String vtotal;

}
