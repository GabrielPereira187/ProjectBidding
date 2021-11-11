function ConsultaCep(){
	var $cep = document.getElementById("cep").value.replace("-","");
	var url = "https://viacep.com.br/ws/" + $cep + "/json";
	var request = new XMLHttpRequest();
	
	request.open('GET', url);
	
	request.onerror = function (e) {
		alert("CEP INVALIDO");
	}
	
	
	request.onload = () => {
		
		
		
		var response = JSON.parse(request.responseText);
		document.getElementById("logradouro").value = response.logradouro;
		document.getElementById("complemento").value = response.complemento;
		document.getElementById("bairro").value = response.bairro;
		document.getElementById("uf").value = response.uf;
		document.getElementById("cidade").value = response.localidade;		
	}
	
	request.send();
}






