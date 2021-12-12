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
		    var opt = response[i].id + "-" + response[i].nome;
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

function buscarVendedor(){
	var nomeV = document.getElementById("vendedores").value;
    nomeV = nomeV.replace(/\D+/g, '');
	
	var url = "http://localhost:8080/buscarVendedor/" + nomeV;
	var request = new XMLHttpRequest();
	
	request.open('GET', url);
	request.onload = () => {
		
		
		
		var response = JSON.parse(request.responseText);
		document.getElementById("rg").value = response.rg;
		document.getElementById("cpf").value = response.cpf;
		document.getElementById("cargo").value = response.cargo;			
	}
	request.send();
}

function buscarEmpresa(){
	var nomeE = document.getElementById("empresas").value;
    nomeE = nomeE.replace(/\D+/g, '');
	var url = "http://localhost:8080/buscarEmpresa/" + nomeE;
	var request = new XMLHttpRequest();
	request.open('GET', url);
	request.onload = () => {
		var response = JSON.parse(request.responseText);
		document.getElementById("cep").value = response.cep;
		document.getElementById("cnpj").value = response.cnpj;
		document.getElementById("tel").value = response.telefone;
		document.getElementById("uf").value = response.uf;
		document.getElementById("inscr").value = response.inscricao_estadual;
		document.getElementById("num").value = response.numero;
		document.getElementById("bairro").value = response.bairro;
		document.getElementById("logradouro").value = response.logradouro;
		document.getElementById("cidade").value = response.localidade;
		document.getElementById("email").value = response.email;			
	}
	
	request.send();
}


function addTbl(){
	
	var qtde = document.getElementById("Qtde").value;
	var nomeP = document.getElementById("produtos").value;
	var tbPedido = document.getElementById("tbPedido").value;
	
	var url = "http://localhost:8080/buscarItem/" + nomeP;
	var request = new XMLHttpRequest();
	
	request.open('GET', url);
	request.onload = () => {
		
		
		
		var response = JSON.parse(request.responseText);
		var tabela = document.getElementById("tbPedido");
		var numeroLinhas = tabela.rows.length;
		var linha = tabela.insertRow(numeroLinhas);
		var celula1 = linha.insertCell(0);
		var celula2 = linha.insertCell(1);   
		var celula3 = linha.insertCell(2); 
		var celula4 = linha.insertCell(3);
		var celula5 = linha.insertCell(4);   
		var celula6 = linha.insertCell(5);
		var celula7 = linha.insertCell(6);
		var r = response.preco_unitario * qtde;
		celula1.innerHTML = response.item; 
		celula2.innerHTML = response.descricao; 
		celula3.innerHTML = response.unidade;
		celula4.innerHTML = "R$" + response.preco_unitario.toFixed(2); 
		celula5.innerHTML = qtde; 
		celula6.innerHTML = "R$" + r.toFixed(2);
		celula7.innerHTML = `
					  		<a class="btn btn-danger" onclick="removeLinha(this)">
					  			<i class="fas fa-trash"></i> Excluir
					  		</a>`				
	}
	request.send();
	
}

function removeLinha(linha) {
              var i=linha.parentNode.parentNode.rowIndex;
              document.getElementById('tbPedido').deleteRow(i);
}
var cont = 0;


function table_to_array() {
	
		cont++;
		if(cont > 0){
          myData = document.getElementById("tbPedido").rows
	      //console.log(myData)
	        my_liste = []
	        for (i = 1 ; i < myData.length; i++) {
	                el = myData[i].children
	                my_el = []
	                for (var j = 0; j < el.length - 1; j++) {
	                        my_el.push(el[j].innerText);
	                }
	                my_liste.push(my_el)
					
	        }
		
		}
		return my_liste;
}

function teste(){
	var cnpj = document.getElementById("cnpj").value;
	var cep = document.getElementById("cep").value; 
	var tel = document.getElementById("tel").value;
	var uf = document.getElementById("uf").value;
	var inscr = document.getElementById("inscr").value;
	var num = document.getElementById("num").value;
	var bairro = document.getElementById("bairro").value;
	var logradouro = document.getElementById("logradouro").value;
	var cidade = document.getElementById("cidade").value;
	var email = document.getElementById("email").value;
	
	
	var nome_doc = document.getElementById("nome_doc").value;
	var nome_penit = document.getElementById("nome_penit").value;
	var nome_setor = document.getElementById("nome_setor").value;
	var data_hora = document.getElementById("data_hora").value;
	var dia = data_hora.substring(8,10);
	var mes = data_hora.substring(5,7);
	var ano = data_hora.substring(0,4);
	var hora = data_hora.substring(11,16);
	var data = dia + "/" + mes +  "/" + ano;
	
	var rg = document.getElementById("rg").value;
	var cpf = document.getElementById("cpf").value;
	var cargo = document.getElementById("cargo").value;	
	
	var nomeE = document.getElementById("empresas").value;
    nomeE = nomeE.replace(/\D+/g, '');

	var nomeV = document.getElementById("vendedores").value;
    nomeV = nomeV.replace(/\D+/g, '');

	var pregao = document.getElementById("pregao").value;
	var processo = document.getElementById("processo").value;
	var objeto = document.getElementById("objeto").value;
	
	var tb = []
	tb = table_to_array();
	console.log(tb);
	var url = "http://localhost:8080/gerar-pdf/" 
	+ tb 
	+ "/" + cnpj 
	+ "/" + inscr
	+ "/" + tel
	+ "/" + email
	+ "/" + cep
	+ "/" + cidade
	+ "/" + logradouro
	+ "/" + bairro
	+ "/" + num
	+ "/" + uf
	+ "/" + rg
	+ "/" + cpf
	+ "/" + cargo
	+ "/" + nomeE
	+ "/" + nomeV
	+ "/" + nome_doc
	+ "/" + nome_penit
	+ "/" + nome_setor
	+ "/" + data
	+ "/" + hora
	+ "/" + pregao
	+ "/" + processo
	+ "/" + objeto;
	
	var request = new XMLHttpRequest();
	
	request.open('GET', url);
	request.onload = () => {		
	}
	request.send();
}



    