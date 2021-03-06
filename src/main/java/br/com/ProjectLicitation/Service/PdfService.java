package br.com.ProjectLicitation.Service;

import java.time.LocalDate;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.security.auth.module.NTSystem;

import br.com.ProjectLicitation.model.HeaderFooterPageEvent;
import br.com.ProjectLicitation.model.Pedido;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class PdfService {

	public void gerarPDF(ArrayList<Pedido> produtos, 
			String cnpj,
			String inscricao,
			String telefone,
			String email,
			String cep,
			String cidade,
			String rua,
			String bairro,
			String numero,
			String estado,
			String rg,
			String cpf,
			String cargo,
			String nomeE,
			String nomeV,
			String nomeD,
			String nomeP,
			String nomeS,
			String data,
			String hora,
			String pregao,
			String processo,
			String objeto
			) 
	{
			System.out.print(nomeE);
	        NTSystem infoSystem = new NTSystem();
	        Document documentoPDF = new Document();
	        String dt;
	        
	        dt = obterData();
	        try{
	            String sub_pasta = "C:\\Users\\"+infoSystem.getName()+"\\Documentos\\Pdfs Criadoss\\" + dt +"\\";
	            
	            
	            File Subpasta = new File(sub_pasta);
	            Subpasta.mkdirs();
	            
	            
	            
	            cnpj = cnpj.replaceFirst("-", "/");
	            inscricao = inscricao.replace("-", "/");
	            data = data.replace("-", "/");
	            data = data.substring(0, 7);
	            
	      
	            
	            PdfWriter writer = PdfWriter.getInstance(documentoPDF, new FileOutputStream(sub_pasta + nomeD + ".pdf"));
	   
	            HeaderFooterPageEvent event = new HeaderFooterPageEvent(nomeE,bairro,estado,cidade,telefone,inscricao,cnpj,email,numero,rua);
	            writer.setPageEvent(event);
	            documentoPDF.open();
	            dados(documentoPDF,nomeP,nomeS);
	            pregao(documentoPDF,hora,data,pregao,processo,objeto);
	            declaracao(documentoPDF,pregao,nomeE,processo,rg, cpf, nomeV);
	            gerarASS(documentoPDF,pregao,nomeE,processo,rg, cpf, nomeV,cargo);
	            //inicio da segunda pagina
	            documentoPDF.newPage();
	            dados(documentoPDF,nomeP,nomeS);
	            pregao(documentoPDF,hora,data,pregao,processo,objeto);
	            declaracaomicro(documentoPDF,pregao,nomeE,processo,rg, cpf, nomeV);
	            gerarASS(documentoPDF,pregao,nomeE,processo,rg, cpf, nomeV,cargo);
	            documentoPDF.newPage();
	            dados(documentoPDF,nomeP,nomeS);
	            pregao(documentoPDF,hora,data,pregao,processo,objeto);
	            declaracaoindependente(documentoPDF,pregao,nomeE,processo,rg, cpf, nomeV);
	            gerarASS(documentoPDF,pregao,nomeE,processo,rg, cpf, nomeV,cargo);
	            documentoPDF.newPage();
	            dados(documentoPDF,nomeP,nomeS);
	            pregao(documentoPDF,hora,data,pregao,processo,objeto);
	            addTabela(documentoPDF,produtos);
	            gerarASS(documentoPDF,pregao,nomeE,processo,rg, cpf, nomeV,cargo);
	            documentoPDF.close();
	            
	            
	        
	            
	            documentoPDF.setPageSize(PageSize.A4);
	            System.out.print("aaaaaa");
	        }
	            
	        
	            
	        catch(DocumentException | IOException de){
	        }finally{
	            
	        }

	
	    
	
}

	public static String obterData(){
	    Calendar c = Calendar.getInstance();
	    
	    //obten????o da data atual
	    Date data = c.getTime();
	    
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    String dt = sdf.format(data);
	     
	    return dt; 
	}
	
	
	public static void dados(Document docPDF,String nm,String nmS) throws DocumentException{
        Font font2 = new Font();
        font2.setSize(12);
        Paragraph rep = new Paragraph("\n??\n" +
        "SECRETARIA DE ESTADO DA ADMINISTRA????O PENITENCI??RIA",font2);
        Paragraph d = new Paragraph(nmS + "\n" + nm,font2);
        docPDF.add(new Paragraph(rep));
        docPDF.add(new Paragraph(d));
        
    }
	
	
	 public static void pregao(Document docPDF,String hora,String data,String pregao,String processo,String objeto)throws DocumentException{
	        Font font2 = new Font();
	        font2.setSize(12);
	        Paragraph rep = new Paragraph("PREG??O ELETR??NICO " + pregao + "\nPROCESSO " + processo + "\nDATA E HORA DA ABERTURA DA SESS??O P??BLICA: " + 
	                data + " ??s " + hora + "\n\n",font2);
	        Paragraph objetos = new Paragraph("objeto: " + objeto,font2);
	        docPDF.add(new Paragraph(rep));
	        docPDF.add(new Paragraph(objetos));
	    }
	
	 public void declaracao(Document docPDF, String pregao, String nomeE, String processo, String rg, String cpf, String nomeV) throws DocumentException{
	      
	       
	        
	        Font font3 = new Font();
	        
	        font3.setSize(12);
	        font3.setStyle("bold");
	        
	        
	        Paragraph rep = new Paragraph("\nDECLARA????O\n",font3);
	        rep.setAlignment(Element.ALIGN_CENTER);
	        Paragraph dec = new Paragraph("\n"+nomeV.toUpperCase()+", RG n?? "+rg+", CPF n?? "+cpf+", DECLARO, sob as penas da Lei, que o licitante "+nomeE.toUpperCase()+", interessado em participar do PREG??O ELETR??NICO "+pregao+" - PROCESSO "+processo+":",font3);
	        Paragraph buc = new Paragraph("a) est?? em situa????o regular perante o Minist??rio do Trabalho no que se refere a observ??ncia do disposto no inciso XXXIII do artigo 7.?? da Constitui????o Federal, na forma do Decreto Estadual n??. 42.911/1998; \n" +
	        "b) n??o possui impedimento legal para licitar ou contratar com a Administra????o;\n\n\n",font3);
	        docPDF.add(rep);
	        docPDF.add(new Paragraph(dec));
	        docPDF.add(new Paragraph(buc));
	        
	        

	    }
	    public void declaracaomicro(Document docPDF, String pregao, String nomeE, String processo, String rg, String cpf, String nomeV) throws DocumentException{
	    	Font font2 = new Font();
	        String x = "bold";
	        font2.setSize(12);
	        font2.setStyle(x);
	        
	        Font font3 = new Font();
	        
	        font3.setSize(12);
	        
	        Paragraph rep = new Paragraph("\nDECLARA????O DE ENQUADRAMENTO COMO MICROEMPRESA OU EMPRESA DE PEQUENO PORTE\n",font3);
	        rep.setAlignment(Element.ALIGN_CENTER);
	        Paragraph dec = new Paragraph("\nEu, "+nomeV.toUpperCase()+", portador do RG n?? "+rg+" e do CPF n?? "+cpf+", representante legal do licitante "+nomeE.toUpperCase()+", interessado em participar do PREG??O ELETR??NICO "+pregao+" - PROCESSO "+processo+","
	                + "DECLARO, sob as penas da Lei, o seu enquadramento na condi????o de Microempresa ou Empresa de Pequeno Porte, "
	                + "nos crit??rios previstos no artigo 3?? da Lei Complementar Federal n?? 123/2006, "
	                + "bem como sua n??o inclus??o nas veda????es previstas no mesmo diploma legal.\n\n\n ",font3);
	        docPDF.add(rep);
	        docPDF.add(new Paragraph(dec));
	        

	    }
	    public void declaracaoindependente(Document docPDF, String pregao, String nomeE, String processo, String rg, String cpf, String nomeV) throws DocumentException{
	    	Font font2 = new Font();
	        String x = "bold";
	        font2.setSize(12);
	        font2.setStyle(x);
	        
	        Font font3 = new Font();
	        
	        font3.setSize(12);
	        
	        
	        
	        Paragraph rep = new Paragraph("\nDECLARA????O DE ENQUADRAMENTO COMO MICROEMPRESA OU EMPRESA DE PEQUENO PORTE\n",font3);
	        rep.setAlignment(Element.ALIGN_CENTER);
	        Paragraph dec = new Paragraph("\nEu, "+nomeV.toUpperCase()+", portador do RG n?? "+rg+" e do CPF n?? "+cpf+", representante legal do licitante "+nomeE.toUpperCase()+", interessado em participar do PREG??O ELETR??NICO "+pregao+" - PROCESSO "+processo+".",font3);
	        Paragraph buc = new Paragraph("DECLARO, sob as penas da Lei, especialmente o artigo 299 do C??digo Penal Brasileiro, que:\n" +
	"a) a proposta apresentada foi elaborada de maneira independente e o seu conte??do n??o foi, no todo ou em parte, direta ou indiretamente, informado ou discutido com qualquer outro licitante ou interessado, em potencial ou de fato, no presente procedimento licitat??rio;\n" +
	"b) a inten????o de apresentar a proposta n??o foi informada ou discutida com qualquer outro licitante ou interessado, em potencial ou de fato, no presente procedimento licitat??rio;\n" +
	"c) o licitante n??o tentou, por qualquer meio ou por qualquer pessoa, influir na decis??o de qualquer outro licitante ou interessado, em potencial ou de fato, no presente procedimento licitat??rio;\n" +
	"d) o conte??do da proposta apresentada n??o ser??, no todo ou em parte, direta ou indiretamente, comunicado ou discutido com qualquer outro licitante ou interessado, em potencial ou de fato, no presente procedimento licitat??rio antes da adjudica????o do objeto;\n" +
	"e) o conte??do da proposta apresentada n??o foi, no todo ou em parte, informado, discutido ou recebido de qualquer integrante relacionado, direta ou indiretamente, ao ??rg??o licitante antes da abertura oficial das propostas; e\n" +
	"f) o representante legal do licitante est?? plenamente ciente do teor e da extens??o desta declara????o e que det??m plenos poderes e informa????es para firm??-la.\n" +
	"DECLARO, ainda, que a pessoa jur??dica que represento conduz seus neg??cios de forma a coibir fraudes, corrup????o e a pr??tica de quaisquer outros atos lesivos ?? Administra????o P??blica, nacional ou estrangeira, em atendimento ?? Lei Federal n?? 12.846/ 2013 e ao Decreto Estadual n?? 60.106/2014, tais como:\n" +
	"I ??? prometer, oferecer ou dar, direta ou indiretamente, vantagem indevida a agente p??blico, ou a terceira pessoa a ele relacionada; \n" +
	"II ??? comprovadamente, financiar, custear, patrocinar ou de qualquer modo subvencionar a pr??tica dos atos il??citos previstos em Lei; \n" +
	"III ??? comprovadamente, utilizar-se de interposta pessoa f??sica ou jur??dica para ocultar ou dissimular seus reais interesses ou a identidade dos benefici??rios dos atos praticados; \n" +
	"IV ??? no tocante a licita????es e contratos: \n" +
	"a)frustrar  ou  fraudar,  mediante  ajuste,  combina????o  ou  qualquer  outro  expediente,  o  car??ter  competitivo  de procedimento licitat??rio p??blico; \n" +
	"b) impedir, perturbar ou fraudar a realiza????o de qualquer ato de procedimento licitat??rio p??blico; \n" +
	"c) afastar ou procurar afastar licitante, por meio de fraude ou oferecimento de vantagem de qualquer tipo; \n" +
	"d) fraudar licita????o p??blica ou contrato dela decorrente; \n" +
	"e) criar, de modo fraudulento ou irregular, pessoa jur??dica para participar de licita????o p??blica ou celebrar contrato administrativo; \n" +
	"f)obter  vantagem  ou  benef??cio  indevido,  de  modo  fraudulento,  de  modifica????es  ou  prorroga????es  de  contratos celebrados com a administra????o p??blica, sem autoriza????o em lei, no ato convocat??rio da licita????o p??blica ou nos respectivos instrumentos contratuais; ou \n" +
	"g) manipular ou fraudar o equil??brio econ??mico-financeiro dos contratos celebrados com a administra????o p??blica; \n" +
	"V ??? dificultar atividade de investiga????o ou fiscaliza????o de ??rg??os, entidades ou agentes p??blicos, ou intervir em sua atua????o, inclusive no ??mbito das ag??ncias reguladoras e dos ??rg??os de fiscaliza????o do sistema financeiro nacional.\n\n\n\n",font3);
	        docPDF.add(rep);
	        docPDF.add(new Paragraph(dec));
	        docPDF.add(new Paragraph(buc));
	    
	    
	    }
	    
	    public void gerarASS(Document docPDF, String pregao, String nomeE, String processo, String rg, String cpf, String nomeV,String cargo) throws DocumentException{
	    	Font font2 = new Font();
	        String x = "bold";
	        font2.setSize(12);
	        font2.setStyle(x);
	        
	        Font font3 = new Font();
	        
	        font3.setSize(12);
	        LocalDate todaysDate = LocalDate.now();
	        int dia = todaysDate.getDayOfMonth();
	        
	        int mes = todaysDate.getMonthValue();
	        
	        int ano = todaysDate.getYear();
	        String m = null;
	        switch(mes){
	            case 1:
	                m = "janeiro";
	                break;
	            case 2:
	                m = "fevereiro";
	                break;
	            case 3:
	                m = "mar??o";
	                break;
	            case 4:
	                m = "abril";
	                break;
	            case 5:
	                m = "maio";
	                break;
	            case 6:
	                m = "junho";
	                break;
	            case 7:
	                m = "julho";
	                break;
	            case 8:
	                m = "agosto";
	                break;
	            case 9:
	                m = "setembro";
	                break;
	            case 10:
	                m = "outubro";
	                break;
	            case 11:
	                m = "novembro";
	                break;
	            case 12:
	                m = "dezembro";
	                break;
	        }
	        String fMaiuscula = toTitledCase(nomeE);
	        Paragraph dat = new Paragraph("Sorocaba,"+dia+" de "+m+" de "+ano+"\n\n\n\n",font3);
	        Paragraph ass = new Paragraph("__________________________________________\n"
	                + ""+fMaiuscula+"\n"
	                + ""+nomeV+"-"+cargo+"\n"
	                + "RG. "+rg+" - SSP\n"
	                + "CPF "+cpf+"\n",font3);
	        docPDF.add(new Paragraph(dat));
	        docPDF.add(new Paragraph(ass));
	        
	        
	        
	    }
	    
	    public static String toTitledCase(String str){
			String[] words = str.split("\\s");
			StringBuilder sb = new StringBuilder();
	 
			for(int i = 0; i < words.length; i++){
				sb.append(words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase());
				sb.append(" ");
			}
	 
			return sb.toString();
		}
	    
	    public void addTabela(Document doc, ArrayList<Pedido> pedidos) throws DocumentException{
	        DecimalFormat df = new DecimalFormat("#,##0.00");
	        PdfPTable tbl = new PdfPTable(6);
	        Font font2 = new Font();
	        String x = "bold";
	        font2.setSize(12);
	        font2.setStyle(x);
	        
	        Font fon = new Font();
	        
	        font2.setSize(11);
	        
	        Paragraph prop = new Paragraph("\nProposta Comercial\n\n",font2);
	        prop.setAlignment(Element.ALIGN_CENTER);
	        doc.add(prop);
	        
	        
	        tbl.addCell("Item");
	        tbl.addCell("Descri????o");
	        tbl.addCell("Unidade");
	        tbl.addCell("Pre??o Unit??rio");
	        tbl.addCell("Quantidade");
	        tbl.addCell("Valor");
	        
	        double resp = 0;
	        
	        for(int y = 0; y < pedidos.size();y++){
	            String item = pedidos.get(y).getItem();
	            String desc = pedidos.get(y).getDescricao();
	            String uni = pedidos.get(y).getUnidade();
	            String prec = pedidos.get(y).getPreco_unitario();
	            String qtd = pedidos.get(y).getQtde();
	            String val = pedidos.get(y).getVtotal();
	            
	            resp += Double.parseDouble(pedidos.get(y).getVtotal().replace("R$", ""));
	            tbl.addCell(item);
	            tbl.addCell(desc);
	            tbl.addCell(uni);
	            tbl.addCell(prec);
	            tbl.addCell(qtd);
	            tbl.addCell(val);
	            
	        }
	      
	        Paragraph tot = new Paragraph("Valor Total = R$" + df.format(resp));
	        tot.setAlignment(Element.ALIGN_RIGHT);
	        doc.add(tbl);
	        doc.add(tot);
	        
	        Paragraph p = new Paragraph("\nProced??ncia: nacional - Marca: Ceagesp\n" +
	        "Nos pre??os propostos est??o inclusos, al??m do lucro, todas as despesas e custos diretos ou indiretos relacionados ao fornecimento do objeto da presente licita????o, tais como tributos, remunera????es, despesas financeiras e quaisquer outras necess??rias ao cumprimento do objeto desta licita????o, inclusive gastos com transporte. \n" +
	        "O pre??o ofertado permanecer?? fixo e irreajust??vel. \n" +
	        "Validade da proposta: 60 (sessenta) dias contados a partir da data de sua apresenta????o.\n" +
	        "Declaramos expressamente que conhecemos e aceitamos todas as exig??ncias do edital e das Leis que regem a esp??cie.",fon);
	        doc.add(p);
	        
	        
	    }
}
