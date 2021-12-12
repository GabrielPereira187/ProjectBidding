package br.com.ProjectLicitation.Service;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.security.auth.module.NTSystem;

import br.com.ProjectLicitation.model.HeaderFooterPageEvent;
import br.com.ProjectLicitation.model.Pedido;

import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


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
	        /*NTSystem infoSystem = new NTSystem();
	        Document documentoPDF = new Document();
	        String dt;
	        
	        dt = obterData();
	        try{
	            String sub_pasta = "C:\\Users\\"+infoSystem.getName()+"\\OneDrive\\Documents\\Gerador de Proposta - PDFs criados\\" + dt +"\\";
	            
	            
	            File Subpasta = new File(sub_pasta);
	            Subpasta.mkdirs();
	            
	            
	            
	            
	            
	      
	            
	            PdfWriter writer = PdfWriter.getInstance(documentoPDF, new FileOutputStream(sub_pasta + nomeDoc + ".pdf"));
	   
	            HeaderFooterPageEvent event = new HeaderFooterPageEvent();
	            writer.setPageEvent(event);
	            documentoPDF.open();
	            dados(documentoPDF,nomePenit,nomeSetor);
	            pregao(documentoPDF,hora,data,pregao,processo,obj);
	            declaracao(documentoPDF);
	            gerarASS(documentoPDF);
	            //inicio da segunda pagina
	            documentoPDF.newPage();
	            dados(documentoPDF,nomePenit,nomeSetor);
	            pregao(documentoPDF,hora,data,pregao,processo,obj);
	            declaracaomicro(documentoPDF);
	            gerarASS(documentoPDF);
	            documentoPDF.newPage();
	            dados(documentoPDF,nomePenit,nomeSetor);
	            pregao(documentoPDF,hora,data,pregao,processo,obj);
	            declaracaoindependente(documentoPDF);
	            gerarASS(documentoPDF);
	            documentoPDF.newPage();
	            dados(documentoPDF,nomePenit,nomeSetor);
	            pregao(documentoPDF,hora,data,pregao,processo,obj);
	            addTabela(documentoPDF);
	            gerarASS(documentoPDF);
	            documentoPDF.close();
	            
	            
	        
	            
	            //documentoPDF.setPageSize(PageSize.A4);
	            
	        
	            
	        //catch(DocumentException | IOException de){
	        //}finally{
	            
	        //}
*/
	
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
	                data + "-às " + hora + "\n\n",font2);
	        Paragraph obj = new Paragraph("OBJETO: " + objeto,font2);
	        docPDF.add(new Paragraph(rep));
	        docPDF.add(new Paragraph(obj));
	    }
	
	
}
