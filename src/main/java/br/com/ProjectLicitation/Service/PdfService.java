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
	    
	    //obtenção da data atual
	    Date data = c.getTime();
	    
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    String dt = sdf.format(data);
	     
	    return dt; 
	}
	
	
	public static void dados(Document docPDF,String nm,String nmS) throws DocumentException{
        Font font2 = new Font();
        font2.setSize(12);
        Paragraph rep = new Paragraph("\nÀ\n" +
        "SECRETARIA DE ESTADO DA ADMINISTRAÇÃO PENITENCIÁRIA",font2);
        Paragraph d = new Paragraph(nmS + "\n" + nm,font2);
        docPDF.add(new Paragraph(rep));
        docPDF.add(new Paragraph(d));
        
    }
	
	
	 public static void pregao(Document docPDF,String hora,String data,String pregao,String processo,String objeto)throws DocumentException{
	        Font font2 = new Font();
	        font2.setSize(12);
	        Paragraph rep = new Paragraph("PREGÃO ELETRÔNICO " + pregao + "\nPROCESSO " + processo + "\nDATA E HORA DA ABERTURA DA SESSÃO PÚBLICA: " + 
	                data + " às " + hora + "\n\n",font2);
	        Paragraph objetos = new Paragraph("objeto: " + objeto,font2);
	        docPDF.add(new Paragraph(rep));
	        docPDF.add(new Paragraph(objetos));
	    }
	
	 public void declaracao(Document docPDF, String pregao, String nomeE, String processo, String rg, String cpf, String nomeV) throws DocumentException{
	      
	       
	        
	        Font font3 = new Font();
	        
	        font3.setSize(12);
	        font3.setStyle("bold");
	        
	        
	        Paragraph rep = new Paragraph("\nDECLARAÇÃO\n",font3);
	        rep.setAlignment(Element.ALIGN_CENTER);
	        Paragraph dec = new Paragraph("\n"+nomeV.toUpperCase()+", RG nº "+rg+", CPF nº "+cpf+", DECLARO, sob as penas da Lei, que o licitante "+nomeE.toUpperCase()+", interessado em participar do PREGÃO ELETRÔNICO "+pregao+" - PROCESSO "+processo+":",font3);
	        Paragraph buc = new Paragraph("a) está em situação regular perante o Ministério do Trabalho no que se refere a observância do disposto no inciso XXXIII do artigo 7.º da Constituição Federal, na forma do Decreto Estadual nº. 42.911/1998; \n" +
	        "b) não possui impedimento legal para licitar ou contratar com a Administração;\n\n\n",font3);
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
	        
	        Paragraph rep = new Paragraph("\nDECLARAÇÃO DE ENQUADRAMENTO COMO MICROEMPRESA OU EMPRESA DE PEQUENO PORTE\n",font3);
	        rep.setAlignment(Element.ALIGN_CENTER);
	        Paragraph dec = new Paragraph("\nEu, "+nomeV.toUpperCase()+", portador do RG nº "+rg+" e do CPF nº "+cpf+", representante legal do licitante "+nomeE.toUpperCase()+", interessado em participar do PREGÃO ELETRÔNICO "+pregao+" - PROCESSO "+processo+","
	                + "DECLARO, sob as penas da Lei, o seu enquadramento na condição de Microempresa ou Empresa de Pequeno Porte, "
	                + "nos critérios previstos no artigo 3º da Lei Complementar Federal n° 123/2006, "
	                + "bem como sua não inclusão nas vedações previstas no mesmo diploma legal.\n\n\n ",font3);
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
	        
	        
	        
	        Paragraph rep = new Paragraph("\nDECLARAÇÃO DE ENQUADRAMENTO COMO MICROEMPRESA OU EMPRESA DE PEQUENO PORTE\n",font3);
	        rep.setAlignment(Element.ALIGN_CENTER);
	        Paragraph dec = new Paragraph("\nEu, "+nomeV.toUpperCase()+", portador do RG nº "+rg+" e do CPF nº "+cpf+", representante legal do licitante "+nomeE.toUpperCase()+", interessado em participar do PREGÃO ELETRÔNICO "+pregao+" - PROCESSO "+processo+".",font3);
	        Paragraph buc = new Paragraph("DECLARO, sob as penas da Lei, especialmente o artigo 299 do Código Penal Brasileiro, que:\n" +
	"a) a proposta apresentada foi elaborada de maneira independente e o seu conteúdo não foi, no todo ou em parte, direta ou indiretamente, informado ou discutido com qualquer outro licitante ou interessado, em potencial ou de fato, no presente procedimento licitatório;\n" +
	"b) a intenção de apresentar a proposta não foi informada ou discutida com qualquer outro licitante ou interessado, em potencial ou de fato, no presente procedimento licitatório;\n" +
	"c) o licitante não tentou, por qualquer meio ou por qualquer pessoa, influir na decisão de qualquer outro licitante ou interessado, em potencial ou de fato, no presente procedimento licitatório;\n" +
	"d) o conteúdo da proposta apresentada não será, no todo ou em parte, direta ou indiretamente, comunicado ou discutido com qualquer outro licitante ou interessado, em potencial ou de fato, no presente procedimento licitatório antes da adjudicação do objeto;\n" +
	"e) o conteúdo da proposta apresentada não foi, no todo ou em parte, informado, discutido ou recebido de qualquer integrante relacionado, direta ou indiretamente, ao órgão licitante antes da abertura oficial das propostas; e\n" +
	"f) o representante legal do licitante está plenamente ciente do teor e da extensão desta declaração e que detém plenos poderes e informações para firmá-la.\n" +
	"DECLARO, ainda, que a pessoa jurídica que represento conduz seus negócios de forma a coibir fraudes, corrupção e a prática de quaisquer outros atos lesivos à Administração Pública, nacional ou estrangeira, em atendimento à Lei Federal nº 12.846/ 2013 e ao Decreto Estadual nº 60.106/2014, tais como:\n" +
	"I – prometer, oferecer ou dar, direta ou indiretamente, vantagem indevida a agente público, ou a terceira pessoa a ele relacionada; \n" +
	"II – comprovadamente, financiar, custear, patrocinar ou de qualquer modo subvencionar a prática dos atos ilícitos previstos em Lei; \n" +
	"III – comprovadamente, utilizar-se de interposta pessoa física ou jurídica para ocultar ou dissimular seus reais interesses ou a identidade dos beneficiários dos atos praticados; \n" +
	"IV – no tocante a licitações e contratos: \n" +
	"a)frustrar  ou  fraudar,  mediante  ajuste,  combinação  ou  qualquer  outro  expediente,  o  caráter  competitivo  de procedimento licitatório público; \n" +
	"b) impedir, perturbar ou fraudar a realização de qualquer ato de procedimento licitatório público; \n" +
	"c) afastar ou procurar afastar licitante, por meio de fraude ou oferecimento de vantagem de qualquer tipo; \n" +
	"d) fraudar licitação pública ou contrato dela decorrente; \n" +
	"e) criar, de modo fraudulento ou irregular, pessoa jurídica para participar de licitação pública ou celebrar contrato administrativo; \n" +
	"f)obter  vantagem  ou  benefício  indevido,  de  modo  fraudulento,  de  modificações  ou  prorrogações  de  contratos celebrados com a administração pública, sem autorização em lei, no ato convocatório da licitação pública ou nos respectivos instrumentos contratuais; ou \n" +
	"g) manipular ou fraudar o equilíbrio econômico-financeiro dos contratos celebrados com a administração pública; \n" +
	"V – dificultar atividade de investigação ou fiscalização de órgãos, entidades ou agentes públicos, ou intervir em sua atuação, inclusive no âmbito das agências reguladoras e dos órgãos de fiscalização do sistema financeiro nacional.\n\n\n\n",font3);
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
	                m = "março";
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
	        tbl.addCell("Descrição");
	        tbl.addCell("Unidade");
	        tbl.addCell("Preço Unitário");
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
	        
	        Paragraph p = new Paragraph("\nProcedência: nacional - Marca: Ceagesp\n" +
	        "Nos preços propostos estão inclusos, além do lucro, todas as despesas e custos diretos ou indiretos relacionados ao fornecimento do objeto da presente licitação, tais como tributos, remunerações, despesas financeiras e quaisquer outras necessárias ao cumprimento do objeto desta licitação, inclusive gastos com transporte. \n" +
	        "O preço ofertado permanecerá fixo e irreajustável. \n" +
	        "Validade da proposta: 60 (sessenta) dias contados a partir da data de sua apresentação.\n" +
	        "Declaramos expressamente que conhecemos e aceitamos todas as exigências do edital e das Leis que regem a espécie.",fon);
	        doc.add(p);
	        
	        
	    }
}
