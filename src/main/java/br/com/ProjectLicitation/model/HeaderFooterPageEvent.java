package br.com.ProjectLicitation.model;

//import java.awt.Color;
import java.util.logging.Logger;
import java.util.logging.Level;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
//import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class HeaderFooterPageEvent extends PdfPageEventHelper {
	
	
		private String nomeEmp;
		private String bairro;
		private String uf; 
		private String cid; 
		private String tel;
		private String insc;
		private String cnpj;
		private String email;
		private String num;
		private String end;
	
	
	public void onStartPage(PdfWriter writer,Document document) {
    	String traco = "______________________________________________________";
    	Font font2 = new Font();
        font2.setSize(20);
        font2.setColor(new BaseColor(105,105,105));
        font2.setStyle("italic");
        
        Paragraph cabecalhor = new Paragraph(nomeEmp.toUpperCase(),font2);
        cabecalhor.setAlignment(Element.ALIGN_CENTER);
        try {
            document.add(cabecalhor);
        } catch (DocumentException ex) {
            Logger.getLogger(HeaderFooterPageEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            document.add(new Paragraph(traco));
        } catch (DocumentException ex) {
            Logger.getLogger(HeaderFooterPageEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void onEndPage(PdfWriter writer,Document document) {
    	Font font2 = new Font();
        font2.setSize(10);
        font2.setColor(new BaseColor(105,105,105));
        String traco = "______________________________________________________";
        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_LEFT, new Phrase(traco,font2), 5, 30, 0);
        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_LEFT, new Phrase(end + ","+ num +"-"+bairro+"-"+ cid +"("+ uf+") - "+"CNPJ n°"+ cnpj +" - "+"Inscr.Estadual n°" +insc,font2), 5, 18, 0);
        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_LEFT, new Phrase("TEL: " +tel+ " - Email:" + email,font2), 5, 7, 0);
    }
	

	
	
	

}
