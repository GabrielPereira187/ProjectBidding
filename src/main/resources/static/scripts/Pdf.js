function ConsultaDados(){
	
	ConsultaVendedor();
	ConsultaEmpresa();
	ConsultaProdutos();
	
	
	
}

function ConsultaVendedor(){
	var url = "http://localhost:8080/todos-vendedores";
	var request = new XMLHttpRequest();
	
	request.open('GET', url);
	
	
	
	request.onload = () => {
		
		var response = [];
		response = JSON.parse(request.responseText);

		var select = document.getElementById("vendedores"); 
		
		for(var i = 0; i < response.length; i++) {
		    var opt = response[i].id + "-" +response[i].nome;
		    var el = document.createElement("option");
		    el.textContent = opt;
		    el.value = opt;
		    
		    select.appendChild(el);
		}
		
				
	}
	
	request.send();
}

function ConsultaEmpresa(){
	var url = "http://localhost:8080/todas-empresas";
	var request = new XMLHttpRequest();
	
	request.open('GET', url);
	
	
	
	request.onload = () => {
		
		var response = [];
		response = JSON.parse(request.responseText);
		var selectE = document.getElementById("empresas"); 
		
		for(var i = 0; i < response.length; i++) {
		    var opt = response[i].id + "-" +response[i].nome;
		    var el = document.createElement("option");
		    el.textContent = opt;
		    el.value = opt;
		    
		    selectE.appendChild(el);
		}
		
				
	}
	
	request.send();
	
}

function ConsultaProdutos(){
	var url = "http://localhost:8080/todos-produtos";
	var request = new XMLHttpRequest();
	
	request.open('GET', url);
	
	
	
	request.onload = () => {
		
		var response = [];
		response = JSON.parse(request.responseText);
		response.sort(compare);
		var selectE = document.getElementById("produtos"); 
		
		for(var i = 0; i < response.length; i++) {
		    var opt = response[i].item;
		    var el = document.createElement("option");
		    el.textContent = opt;
		    el.value = opt;
		    
		    selectE.appendChild(el);
		}
		
				
	}
	
	request.send();
	
}

function compare( a, b ) {
  if ( a.item < b.item ){
    return -1;
  }
  if ( a.item > b.item ){
    return 1;
  }
  return 0;
}