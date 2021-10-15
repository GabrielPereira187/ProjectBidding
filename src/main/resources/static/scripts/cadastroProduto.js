/**
 * 
 */

function validateForm(){
	var item = document.getElementById("field_item").value;
	var desc = document.getElementById("field_descricao").value;
	var un = document.getElementById("field_unidade").value;
	var prec = document.getElementById("field_preco").value;


	if(item == null || item == "", prec == null || prec == "0.0", un == null || un == "", desc == null || desc == ""){
		alert("Preencha todos os campos de forma correta");
		return false;
	}
}

