$(document).keydown(function(){
	$("#telefone").mask("99 9999-9999");
	$("#celular").mask("99 9 9999-9999");
  	$("#estadual").mask("999.999.999/9999"); 
	$("#cpfcnpj").mask("99.999.999/9999-99");  
});

function validaForm(){
	
	var nome = document.getElementById("nome").value;
	var telefone = document.getElementById("telefone").value;
	var cnpj = document.getElementById("cpfcnpj").value;
	var email = document.getElementById("email").value;
	var inscr = document.getElementById("estadual").value;
	var cep = document.getElementById("cep").value;
	var numero = document.getElementById("num").value;
	var cidade = document.getElementById("cidade").value;

	if(nome == null || nome == "", telefone == null || telefone == ""
	,cnpj == null || cnpj == "", email == null || email == "" 
	,inscr == null || inscr == "", cep == null || cep == ""
	,numero == null || numero == ""){
		alert("Preencha todos os campos de forma correta");
		return false;
	}
	if(cidade == ""){
		alert("Entre com um CEP");
		return false;
	}
	document.getElementById("cidade").disabled = false;
	document.getElementById("bairro").disabled = false;
	document.getElementById("uf").disabled = false;
	document.getElementById("logradouro").disabled = false;
	
}