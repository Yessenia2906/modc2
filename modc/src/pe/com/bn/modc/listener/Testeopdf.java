package pe.com.bn.modc.listener;
import pe.com.bn.modc.dao.impl.ConsultaImagen;

import java.awt.image.BufferedImage;

import pe.com.bn.modc.common.Constante;
import pe.com.bn.modc.dao.impl.ConsultaImagen;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class Testeopdf {

		static ConsultaImagen dao = null ;
	    BufferedImage image  = null ;
	    static byte[] imageByte  = null ;
	    static byte[] imageByte2  = null ; 
	    static Image firm1;
	    static Image firm2;
	    
	public  static void tee() throws Exception{
	    	 dao = new ConsultaImagen();
	 	    String codFirma1 = Constante.FIRMA1;
	 	    String codFirma2 = Constante.FIRMA2;
	 	     imageByte =dao.consultarFirma1(codFirma1);
	 	    imageByte2 =dao.consultarFirma1(codFirma2);
	 	    firm1 = Image.getInstance(imageByte);
	 	    firm2 = Image.getInstance(imageByte2);
	 	   // firm2.setSpacingBefore(15f);
	 	    //firm1.setSpacingBefore(15f);
	 	    // firm1.scaleAbsoluteWidth(190f);		
	 	   //  firm2.scaleAbsoluteWidth(190f);		
	 	     firm1.scalePercent(30);
	 	     firm2.scalePercent(30);
	 	

	 	     
	 	   //  firm1.setBorder(Image.BOX);
	 	    // firm2.setBorder(Image.BOX);
	 	    // firm2.setBorderWidth(2);
	 	    // firm1.setBorderWidth(2);

 
	    }

	public static PdfPTable clausulasGPageFinal2(String fecha, String dni,String nombre, Image firma1,Image firma2, String agencia, String parametro, String agarante, String dnigarante) throws Exception{
		try {
			tee();
			System.out.println("exito imagenes");
		} catch (Exception e) {
			System.out.println("erro traer iamgenes");
		}
		
		
	
		
		String texto = "Las instrucciones que pudiera impartirle. Estas grabaciones ser�n mantenidas en reserva y utilizadas para aclarar cualquier " +
			    "discrepancia y/o litigio que pudiera presentarse al respecto. Asimismo, usted autoriza al banco a grabar cualquier tipo de " +
			    "conversaci�n, solicitud, autorizaci�n, instrucci�n, adquisici�n y en general cualquier otro tipo de orden o manifestaci�n de " +
			    "voluntad y/o consentimiento relacionado con el pr�stamo y los servicios adicionales asociados a ella, comprometi�ndose " +
			    "a mantener absoluta reserva de las mismas.";
		
		 String contenido = "Tributos: todos los tributos (impuestos) que graven el otorgamiento del pr�stamo y, en general, todos los servicios que le brinde el banco seg�n el contrato y deban ser pagados, ser�n asumidos por usted.";
		 String contenido2 = "Representante: su representante y/o apoderado podr� efectuar en su representaci�n operaciones relacionadas a pagos a las cuotas del pr�stamo o en caso de pagos anticipados o adelanto de cuotas, para este caso deber� considerarse lo se�alado en la cl�usula general N� 8, para lo cual deber� presentar una carta con su firma legalizada.\nPara realizar otro tipo de operaciones y/o servicios e incluso para solicitar informaci�n deber� acreditar su representaci�n mediante poder de acuerdo a las normas legales vigentes, para lo cual deber� presentarse la documentaci�n correspondiente, dicha documentaci�n ser� evaluada por el banco no siendo �ste �ltimo responsable en caso de rechazo por carecer de facultades suficientes o por no cumplir los requisitos de ley.";

		 
		 String contenido3 = "En caso que surja alguna disputa o controversia entre usted y el banco sobre la validez, la interpretaci�n o la ejecuci�n del contrato, usted y el banco se someter�n a la competencia de los jueces correspondientes del distrito judicial que corresponde al lugar en el cual se ha celebrado el presente contrato.\nTodos los costos y costas, incluidos los gastos, que ocasione la cobranza judicial, que disponga la autoridad judicial competente, del pr�stamo ser�n pagados �ntegramente por usted y/o por el fiador.";

		 String contenido4 = "Requerimiento de informaci�n adicional: usted reconoce que el banco podr� requerirle entre otros, informaci�n sobre su situaci�n personal, financiera y crediticia, la misma que usted se obliga a mantener permanentemente actualizada durante la vigencia de �ste contrato, especialmente en lo que se refiere a su nacionalidad, lugar de residencia, composici�n accionaria o situaci�n fiscal, comprometi�ndose tambi�n a comunicar a el banco cualquier cambio que se produzca al respecto. Usted se compromete a atender dichos requerimientos de informaci�n, entregando informaci�n veraz y oportuna con car�cter de declaraci�n jurada.";

		 String textoFecha = "FECHA: "+fecha;
		String textoClausula1 ="F.OP-452-A-V06-GPIF";
		String textoClausula2 = " Cl�usulas generales aprobadas mediante Resoluci�n SBS N� 00993-2022 \n ";
		String textoClausula3 = " P�g.09 de 09";
		String saltos = "  \n  \n \n   \n \n  \n \n    \n   \n \n \n \n  \n  \n  ";
	PdfPTable table = new PdfPTable(4);
	table.setTotalWidth(PageSize.A4.getWidth()-60);
	//table.setT(PageSize.A4.getWidth()-60);
	System.out.println("ancho tabla general "+ table.getWidthPercentage());

	table.setLockedWidth(true);
	table.getDefaultCell().setBorder(PdfPCell.BOX);
	table.getDefaultCell().setBorderColor(BaseColor.BLACK);
	table.getDefaultCell().setBorderWidth(PdfPCell.BOX);
	table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
	PdfPCell cell;



	
	// body

	cell = new PdfPCell(new Phrase(texto, FontFactory.getFont(FontFactory.HELVETICA, 10)));
	cell.setPaddingLeft(45f);
	cell.setPaddingRight(12f);
	cell.setBorder(Rectangle.TOP | Rectangle.LEFT | Rectangle.RIGHT );
	cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cell.setColspan(4);
	table.addCell(cell);

	// punto b
	float[] columnWidthscontenido = { 0.75f, 10f}; // Relative column widths
	PdfPTable table3 = new PdfPTable(columnWidthscontenido);
	table3.setTotalWidth(PageSize.A4.getWidth()-60);
	//table.setT(PageSize.A4.getWidth()-60);
	table3.setLockedWidth(true);
	
	
	cell = new PdfPCell(new Phrase("b)", FontFactory.getFont(FontFactory.HELVETICA, 10)));
	cell.setPaddingLeft(25f);
	//cell.setPaddingRight(5f);
	cell.setBorder(0 );
	cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cell.setColspan(1);
	table3.addCell(cell);
	
	cell = new PdfPCell(new Phrase(contenido, FontFactory.getFont(FontFactory.HELVETICA, 10)));
	cell.setPaddingRight(12f);
	cell.setPaddingLeft(5f);
	cell.setBorder(0 );
	cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cell.setColspan(1);
	table3.addCell(cell);
	
	cell = new PdfPCell();
	cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
	cell.setColspan(4);
	cell.addElement(table3);
	table.addCell(cell);
	
	
	
	// punto c
	
	float[] puntoc = { 0.75f, 10f}; // Relative column widths
	PdfPTable tabla4 = new PdfPTable(puntoc);
	tabla4.setTotalWidth(PageSize.A4.getWidth()-60);
	//table.setT(PageSize.A4.getWidth()-60);
	tabla4.setLockedWidth(true);
	
	
	cell = new PdfPCell(new Phrase("c)", FontFactory.getFont(FontFactory.HELVETICA, 10)));
	cell.setPaddingLeft(25f);
	//cell.setPaddingRight(5f);
	cell.setBorder(0 );
	cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cell.setColspan(1);
	tabla4.addCell(cell);
	
	cell = new PdfPCell(new Phrase(contenido2, FontFactory.getFont(FontFactory.HELVETICA, 10)));
	cell.setPaddingRight(12f);
	cell.setPaddingLeft(5f);
	cell.setBorder(0);
	cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cell.setColspan(1);
	tabla4.addCell(cell);
	
	cell = new PdfPCell();
	cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
	cell.setColspan(4);
	cell.addElement(tabla4);
	table.addCell(cell);
	
	// punto d 
	
		float[] puntod = { 0.75f, 10f}; // Relative column widths
		PdfPTable tabla5 = new PdfPTable(puntod);
		tabla5.setTotalWidth(PageSize.A4.getWidth()-60);
		//table.setT(PageSize.A4.getWidth()-60);
		tabla5.setLockedWidth(true);
		
		
		cell = new PdfPCell(new Phrase("d)", FontFactory.getFont(FontFactory.HELVETICA, 10)));
		cell.setPaddingLeft(25f);
		//cell.setPaddingRight(5f);
		cell.setBorder(0 );
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(1);
		tabla5.addCell(cell);
		
		cell = new PdfPCell(new Phrase(contenido4, FontFactory.getFont(FontFactory.HELVETICA, 10)));
		cell.setPaddingRight(12f);
		cell.setPaddingLeft(5f);
		cell.setBorder(0);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(1);
		tabla5.addCell(cell);
		
		cell = new PdfPCell();
		cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
		cell.setColspan(4);
		cell.addElement(tabla5);
		table.addCell(cell);
	
	

	
	cell = new PdfPCell(new Phrase(contenido3, FontFactory.getFont(FontFactory.HELVETICA, 10)));
	cell.setPaddingLeft(28f);
	cell.setPaddingRight(12f);
	cell.setBorder( Rectangle.LEFT | Rectangle.RIGHT );
	cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cell.setColspan(4);
	table.addCell(cell);

	cell = new PdfPCell(new Phrase(textoFecha + "\n \n ", FontFactory.getFont(FontFactory.HELVETICA, 10)));
	cell.setPaddingLeft(28f);
	cell.setPaddingTop(10f);
	cell.setBorder( Rectangle.LEFT | Rectangle.RIGHT );
	cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell.setColspan(4);
	table.addCell(cell);
	Phrase P;
	
	cell = new PdfPCell();
	cell.setBorder(Rectangle.BOX);
	cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell.setColspan(2);
	
	
	 P = new Phrase("\n \nSU FIRMA:", FontFactory.getFont(FontFactory.HELVETICA, 10));
	cell.addElement(P);
	 P = new Phrase("NOMBRE: "+nombre, FontFactory.getFont(FontFactory.HELVETICA, 10));
	cell.addElement(P);
	 P = new Phrase(dni+" \n ", FontFactory.getFont(FontFactory.HELVETICA, 10));
	 cell.addElement(P);
	 cell.setPaddingLeft(28f);
	 table.addCell(cell);
	
	 cell = new PdfPCell();
		cell.setBorder(Rectangle.BOX);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setColspan(2);
		
		
		 P = new Phrase("\n \nFIRMA FIADOR:", FontFactory.getFont(FontFactory.HELVETICA, 10));
		cell.addElement(P);
		 P = new Phrase("NOMBRE:" + agarante, FontFactory.getFont(FontFactory.HELVETICA, 10));
		cell.addElement(P);
		 P = new Phrase(dnigarante+" \n ", FontFactory.getFont(FontFactory.HELVETICA, 10));
		 cell.addElement(P);
		 cell.setPaddingLeft(28f);
		 table.addCell(cell);
		
			 	
			 
		 // metodo 2 firma 
		 
		 cell = new PdfPCell();
			cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
			cell.setColspan(4);
		
		//	ConsultaImagen dao11 = null;
			 String  agenDB = dao.consultarAgencia(agencia);
			 
			
		
				
				
				// para validar si es pre impreso, parametro = 1  , impreso parametro = 0
				
			
				if (parametro.equals("1")){
				
					 PdfPTable tabla = new PdfPTable(2);				 	
				       tabla.setWidthPercentage(100);
				       tabla.getDefaultCell().setBorder(Rectangle.RIGHT);
				      tabla.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
				      tabla.addCell(firm1);
				      tabla.addCell(firm2);
				       cell.addElement(tabla);
				       
				       PdfPTable linea = new PdfPTable(2);				 	
				       linea.setWidthPercentage(100);
				       linea.getDefaultCell().setBorder(Rectangle.RIGHT);
				       linea.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
				       linea.addCell("      _______________________________");
				       linea.addCell("      _______________________________");
				       cell.addElement(linea);
				       
				       Paragraph firma = new Paragraph("FIRMA DEL BANCO");
				       firma.getFont().setSize(10);
				       
				       
				       
				       PdfPTable banco = new PdfPTable(2);				 	
				       banco.setWidthPercentage(100); 
				       banco.getDefaultCell().setBorder(Rectangle.RIGHT); 
				       banco.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
				       banco.addCell(firma);
				       banco.addCell(firma);
				       cell.addElement(banco);
				       
				       String  nombre1 ="RENZO FABRICIO SPONZA TUESTA\n ";
				 	     
					 	
				 	   String  nombre2 = "PIERO ELLIS FLORES MIRANDA\n ";
				 	 			
				 	   Paragraph nom1 = new Paragraph(nombre1);
				 	   nom1.getFont().setSize(10);				 	   
				       Paragraph nom2 = new Paragraph(nombre2);
				       nom2.getFont().setSize(10);
				 	   
				       PdfPTable nombres = new PdfPTable(2);				 	
				       nombres.setWidthPercentage(100);
				       nombres.getDefaultCell().setBorder(Rectangle.RIGHT );
				       nombres.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
				       nombres.addCell(nom1);
				       nombres.addCell(nom2);
				       cell.addElement(nombres);
				       table.addCell(cell);
				       
				       
					
				}else {
					
	if(agencia.equals(agenDB)  ){
						
						
						// firma		
								
							 PdfPTable tabla = new PdfPTable(2);				 	
						       tabla.setWidthPercentage(100);
						       tabla.getDefaultCell().setBorder(Rectangle.RIGHT);
						      tabla.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
						      tabla.addCell(firm1);
						      tabla.addCell(firm2);
						       cell.addElement(tabla);
						       
						       PdfPTable linea = new PdfPTable(2);				 	
						       linea.setWidthPercentage(100);
						       linea.getDefaultCell().setBorder(Rectangle.RIGHT);
						       linea.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
						       linea.addCell("      _______________________________");
						       linea.addCell("      _______________________________");
						       cell.addElement(linea);
						       
						       Paragraph firma = new Paragraph("FIRMA DEL BANCO");
						       firma.getFont().setSize(10);
						       
						       
						       
						       PdfPTable banco = new PdfPTable(2);				 	
						       banco.setWidthPercentage(100); 
						       banco.getDefaultCell().setBorder(Rectangle.RIGHT); 
						       banco.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
						       banco.addCell(firma);
						       banco.addCell(firma);
						       cell.addElement(banco);
						       
						    
						       
						       String  nombre1 ="RENZO FABRICIO SPONZA TUESTA\n ";
						 	     
							 	
						 	   String  nombre2 = "PIERO ELLIS FLORES MIRANDA\n ";
						 	 			
						 	   Paragraph nom1 = new Paragraph(nombre1);
						 	   nom1.getFont().setSize(10);				 	   
						       Paragraph nom2 = new Paragraph(nombre2);
						       nom2.getFont().setSize(10);
						 	   
						       PdfPTable nombres = new PdfPTable(2);				 	
						       nombres.setWidthPercentage(100);
						       nombres.getDefaultCell().setBorder(Rectangle.RIGHT );
						       nombres.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
						       nombres.addCell(nom1);
						       nombres.addCell(nom2);
						       cell.addElement(nombres);
						       table.addCell(cell);
						       
					}else {
						    	   
						    	   PdfPTable tabla22 = new PdfPTable(2);				 	
									 tabla22.setWidthPercentage(100);
									 tabla22.getDefaultCell().setBorder(Rectangle.RIGHT);
									 tabla22.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
									 tabla22.addCell("        ");
									 tabla22.addCell("        ");
								       cell.addElement(tabla22);
								       
								       PdfPTable tabla111 = new PdfPTable(2);				 	
										 tabla111.setWidthPercentage(100);
										 tabla111.getDefaultCell().setBorder(Rectangle.RIGHT);
										 tabla111.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
										 tabla111.addCell("        ");
										 tabla111.addCell("        ");
									       cell.addElement(tabla111);	
								       
								       
								       PdfPTable linea = new PdfPTable(2);				 	
								       linea.setWidthPercentage(100);
								       linea.getDefaultCell().setBorder(Rectangle.RIGHT);
								       linea.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
								       linea.addCell("      _______________________________");
								       linea.addCell("      _______________________________");
								       cell.addElement(linea);
								       
								       Paragraph firma = new Paragraph("FIRMA DEL BANCO");
								       firma.getFont().setSize(10);
								       
								       
								       
								       PdfPTable banco = new PdfPTable(2);				 	
								       banco.setWidthPercentage(100); 
								       banco.getDefaultCell().setBorder(Rectangle.RIGHT); 
								       banco.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
								       banco.addCell(firma);
								       banco.addCell(firma);
								       cell.addElement(banco);
								       
								       
								       String  nombre1 ="\n ";
								 	     
									 	
								 	   String  nombre2 = "\n ";
								 	 			
								 	   Paragraph nom1 = new Paragraph(nombre1);
								 	   nom1.getFont().setSize(10);				 	   
								       Paragraph nom2 = new Paragraph(nombre2);
								       nom2.getFont().setSize(10);
								 	   
								       PdfPTable nombres = new PdfPTable(2);				 	
								       nombres.setWidthPercentage(100);
								       nombres.getDefaultCell().setBorder(Rectangle.RIGHT );
								       nombres.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
								       nombres.addCell(nom1);
								       nombres.addCell(nom2);
								       cell.addElement(nombres);
								       table.addCell(cell);
						       }
				}
				
				
				
				
				
	 	  
	
	
	
		
	cell = new PdfPCell(new Phrase(saltos, FontFactory.getFont(FontFactory.HELVETICA, 8)));
	cell.setBorder(Rectangle.BOX );
	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell.setColspan(4);
	table.addCell(cell);

	
	
	
	
	
	
	
// footer
	float[] columnWidths = {2f, 8f, 2f,}; // Relative column widths
	PdfPTable table2 = new PdfPTable(columnWidths);
	table2.setTotalWidth(PageSize.A4.getWidth()-60);
	//table.setT(PageSize.A4.getWidth()-60);
	table2.setLockedWidth(true);
	
	cell = new PdfPCell(new Phrase(textoClausula1, FontFactory.getFont(FontFactory.HELVETICA, 5)));
	cell.setBorder(0);
	cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	//cell.setColspan(1);
	table2.addCell(cell);

	cell = new PdfPCell(new Phrase(textoClausula2, FontFactory.getFont(FontFactory.HELVETICA, 10)));
	cell.setBorder(0);
	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	//cell.setColspan(1);
	table2.addCell(cell);

	cell = new PdfPCell(new Phrase(textoClausula3, FontFactory.getFont(FontFactory.HELVETICA, 5)));
	cell.setBorder(0);
	cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
	//cell.setColspan(1);
	table2.addCell(cell);
	
	cell = new PdfPCell();
	cell.setBorder(Rectangle.TOP);
	cell.setColspan(4);
	cell.addElement(table2);
	table.addCell(cell);
	


	return table;

	}

	public static PdfPTable clausulasGPageFinal3(String fecha, String dni,String nombre, Image firma1,Image firma2, String agen, String aGarante1, String dniGarante1,  String parametro) throws Exception{
		try {
			tee();
			System.out.println("exito imagenes");
		} catch (Exception e) {
			System.out.println("erro traer iamgenes");
		}
		

		 
		 String contenido3 = "La aceptaci�n de este beneficio por parte de usted consta en la hoja resumen.";


		 String texto = "usted podr� elegir no pagar el capital e intereses en los meses de abril y diciembre. "
		            + "De esta manera, (i) los intereses de esos meses se cancelar�n en los meses de mayo y enero "
		            + "respectivamente y (ii) el capital de esos meses ser� incorporado en los montos de las dem�s cuotas.";

		 
		 
		 
		 
		 
		 
		 String textoFecha = "FECHA: "+fecha;
		String textoClausula1 ="F.OP-433-B-V05-GPIF";
		String textoClausula2 = " Cl�usulas generales aprobadas mediante Resoluci�n SBS N� 00993-2022 \n ";
		String textoClausula3 = " P�g.02 de 02";
		String saltos = "  \n  \n \n \n \n  \n \n  \n \n \n    \n  \n \n \n \n \n \n  \n  \n    \n  \n \n \n \n  \n \n  \n \n \n \n    \n  \n \n \n \n \n \n  \n  \n \n \n ";
	PdfPTable table = new PdfPTable(4);
	table.setTotalWidth(PageSize.A4.getWidth()-60);
	//table.setT(PageSize.A4.getWidth()-60);
	System.out.println("ancho tabla general "+ table.getWidthPercentage());

	table.setLockedWidth(true);
	table.getDefaultCell().setBorder(PdfPCell.BOX);
	table.getDefaultCell().setBorderColor(BaseColor.BLACK);
	table.getDefaultCell().setBorderWidth(PdfPCell.BOX);

	PdfPCell cell;



	
	

	// punto a
	float[] columnWidthscontenido = { 0.75f, 10f}; // Relative column widths
	PdfPTable table3 = new PdfPTable(columnWidthscontenido);
	table3.setTotalWidth(PageSize.A4.getWidth()-60);
	//table.setT(PageSize.A4.getWidth()-60);
	table3.setLockedWidth(true);
	
	
	cell = new PdfPCell(new Phrase("a)", FontFactory.getFont(FontFactory.HELVETICA, 10)));
	cell.setPaddingLeft(25f);
	cell.setPaddingTop(20f);
	//cell.setPaddingRight(5f);
	cell.setBorder(0 );
	cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cell.setColspan(1);
	table3.addCell(cell);
	
	cell = new PdfPCell(new Phrase(texto, FontFactory.getFont(FontFactory.HELVETICA, 10)));
	cell.setPaddingRight(12f);
	cell.setPaddingLeft(5f);
	cell.setPaddingTop(20f);
	cell.setBorder(0 );
	cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cell.setColspan(1);
	table3.addCell(cell);
	
	cell = new PdfPCell();
	cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.TOP);
	cell.setColspan(4);
	cell.addElement(table3);
	table.addCell(cell);
	
	
	
	// punto c
	

	// punto d 
	


	
	cell = new PdfPCell(new Phrase(contenido3, FontFactory.getFont(FontFactory.HELVETICA, 10)));
	cell.setPaddingLeft(45f);
	cell.setPaddingRight(12f);
	cell.setBorder( Rectangle.LEFT | Rectangle.RIGHT );
	cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
	cell.setColspan(4);
	table.addCell(cell);

	cell = new PdfPCell(new Phrase(textoFecha + "\n \n ", FontFactory.getFont(FontFactory.HELVETICA, 10)));
	cell.setPaddingLeft(28f);
	cell.setPaddingTop(10f);
	cell.setBorder( Rectangle.LEFT | Rectangle.RIGHT );
	cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell.setColspan(4);
	table.addCell(cell);
	Phrase P;
	
	cell = new PdfPCell();
	cell.setBorder(Rectangle.BOX);
	cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	cell.setColspan(2);
	
	
	 P = new Phrase("\n \nSU FIRMA:", FontFactory.getFont(FontFactory.HELVETICA, 10));
	cell.addElement(P);
	 P = new Phrase("NOMBRE: " +nombre, FontFactory.getFont(FontFactory.HELVETICA, 10));
	cell.addElement(P);
	 P = new Phrase(dni+" \n ", FontFactory.getFont(FontFactory.HELVETICA, 10));
	 cell.addElement(P);
	 cell.setPaddingLeft(28f);
	 table.addCell(cell);
	
	 cell = new PdfPCell();
		cell.setBorder(Rectangle.BOX);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setColspan(2);
		
		
		 P = new Phrase("\n \nFIRMA FIADOR:" , FontFactory.getFont(FontFactory.HELVETICA, 10));
		cell.addElement(P);
		 P = new Phrase("NOMBRE:" + aGarante1, FontFactory.getFont(FontFactory.HELVETICA, 10));
		cell.addElement(P);
		 P = new Phrase(dniGarante1+" \n ", FontFactory.getFont(FontFactory.HELVETICA, 10));
		 cell.addElement(P);
		 cell.setPaddingLeft(28f);
		 table.addCell(cell);
		
 // metodo 2 firma 
		 
		 cell = new PdfPCell();
			cell.setBorder(Rectangle.LEFT | Rectangle.RIGHT);
			cell.setColspan(4);
			
			 String  agenDB = dao.consultarAgencia(agen);
			

			
			
			if (parametro.equals("1")){
				 PdfPTable tabla = new PdfPTable(2);				 	
			       tabla.setWidthPercentage(100);
			       tabla.getDefaultCell().setBorder(Rectangle.RIGHT);
			      tabla.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
			      tabla.addCell(firm1);
			      tabla.addCell(firm2);
			       cell.addElement(tabla); 	
			       
			       
			       PdfPTable linea = new PdfPTable(2);				 	
			       linea.setWidthPercentage(100);
			       linea.getDefaultCell().setBorder(Rectangle.RIGHT);
			       linea.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
			       linea.addCell("      _______________________________");
			       linea.addCell("      _______________________________");
			       cell.addElement(linea);
			       
			       
			       Paragraph firma = new Paragraph("FIRMA DEL BANCO");
			       firma.getFont().setSize(10);
			      PdfPTable banco = new PdfPTable(2);				 	
			       banco.setWidthPercentage(100); 
			       banco.getDefaultCell().setBorder(Rectangle.RIGHT); 
			       banco.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
			       banco.addCell(firma);
			       banco.addCell(firma);
			       cell.addElement(banco);  
				
		   	 String  nombre1 ="RENZO FABRICIO SPONZA TUESTA\n ";
	 	     
			 	
		 	   String  nombre2 = "PIERO ELLIS FLORES MIRANDA\n ";
		 	 			
		 	   Paragraph nom1 = new Paragraph(nombre1);
		 	   nom1.getFont().setSize(10);				 	   
		       Paragraph nom2 = new Paragraph(nombre2);
		       nom2.getFont().setSize(10);
		 	   
		       PdfPTable nombres = new PdfPTable(2);				 	
		       nombres.setWidthPercentage(100);
		       nombres.getDefaultCell().setBorder(Rectangle.RIGHT );
		       nombres.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
		       nombres.addCell(nom1);
		       nombres.addCell(nom2);
		       cell.addElement(nombres);
		       table.addCell(cell);	  
			       
				
			}else {
			
				
				if(agen.equals(agenDB)  ){
					
				 	
					
					 PdfPTable tabla = new PdfPTable(2);				 	
				       tabla.setWidthPercentage(100);
				       tabla.getDefaultCell().setBorder(Rectangle.RIGHT);
				      tabla.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
				      tabla.addCell(firm1);
				      tabla.addCell(firm2);
				       cell.addElement(tabla); 	
				       
				  	 
				       PdfPTable linea = new PdfPTable(2);				 	
				       linea.setWidthPercentage(100);
				       linea.getDefaultCell().setBorder(Rectangle.RIGHT);
				       linea.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
				       linea.addCell("      _______________________________");
				       linea.addCell("      _______________________________");
				       cell.addElement(linea);
				       
				       Paragraph firma = new Paragraph("FIRMA DEL BANCO");
				       firma.getFont().setSize(10);
				      PdfPTable banco = new PdfPTable(2);				 	
				       banco.setWidthPercentage(100); 
				       banco.getDefaultCell().setBorder(Rectangle.RIGHT); 
				       banco.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
				       banco.addCell(firma);
				       banco.addCell(firma);
				       cell.addElement(banco);  
					
			   	 String  nombre1 ="RENZO FABRICIO SPONZA TUESTA\n ";
		 	     
				 	
			 	   String  nombre2 = "PIERO ELLIS FLORES MIRANDA\n ";
			 	 			
			 	   Paragraph nom1 = new Paragraph(nombre1);
			 	   nom1.getFont().setSize(10);				 	   
			       Paragraph nom2 = new Paragraph(nombre2);
			       nom2.getFont().setSize(10);
			 	   
			       PdfPTable nombres = new PdfPTable(2);				 	
			       nombres.setWidthPercentage(100);
			       nombres.getDefaultCell().setBorder(Rectangle.RIGHT );
			       nombres.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
			       nombres.addCell(nom1);
			       nombres.addCell(nom2);
			       cell.addElement(nombres);
			       table.addCell(cell);	  
				       
				}else{
				    	   
				    	   PdfPTable tabla11 = new PdfPTable(2);				 	
							 tabla11.setWidthPercentage(100);
							 tabla11.getDefaultCell().setBorder(Rectangle.RIGHT);
							 tabla11.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
							 tabla11.addCell("        ");
							 tabla11.addCell("        ");
						       cell.addElement(tabla11);	
						       
						       
						       PdfPTable tabla111 = new PdfPTable(2);				 	
								 tabla111.setWidthPercentage(100);
								 tabla111.getDefaultCell().setBorder(Rectangle.RIGHT);
								 tabla111.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
								 tabla111.addCell("        ");
								 tabla111.addCell("        ");
							       cell.addElement(tabla111);	
						  	 
						       PdfPTable linea = new PdfPTable(2);				 	
						       linea.setWidthPercentage(100);
						       linea.getDefaultCell().setBorder(Rectangle.RIGHT);
						       linea.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
						       linea.addCell("      _______________________________");
						       linea.addCell("      _______________________________");
						       cell.addElement(linea);
						       
						       
						       Paragraph firma = new Paragraph("FIRMA DEL BANCO");
						       firma.getFont().setSize(10);
						      PdfPTable banco = new PdfPTable(2);				 	
						       banco.setWidthPercentage(100); 
						       banco.getDefaultCell().setBorder(Rectangle.RIGHT); 
						       banco.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
						       banco.addCell(firma);
						       banco.addCell(firma);
						       cell.addElement(banco);  
							
					   	 String  nombre1 ="\n ";
				 	     
						 	
					 	   String  nombre2 = "\n ";
					 	 			
					 	   Paragraph nom1 = new Paragraph(nombre1);
					 	   nom1.getFont().setSize(10);				 	   
					       Paragraph nom2 = new Paragraph(nombre2);
					       nom2.getFont().setSize(10);
					 	   
					       PdfPTable nombres = new PdfPTable(2);				 	
					       nombres.setWidthPercentage(100);
					       nombres.getDefaultCell().setBorder(Rectangle.RIGHT );
					       nombres.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
					       nombres.addCell(nom1);
					       nombres.addCell(nom2);
					       cell.addElement(nombres);
					       table.addCell(cell);	  
				       }
			     
			}
			
			
	 	  
	 	  	
	  
	       
	cell = new PdfPCell(new Phrase(saltos, FontFactory.getFont(FontFactory.HELVETICA, 8)));
	cell.setBorder(Rectangle.BOX);
	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	cell.setColspan(4);
	System.out.println("ancho celda saltos "+cell.getWidth());
	table.addCell(cell);

// footer
	float[] columnWidths = {2f, 8f, 2f,}; // Relative column widths
	PdfPTable table2 = new PdfPTable(columnWidths);
	table2.setTotalWidth(PageSize.A4.getWidth()-60);
	//table.setT(PageSize.A4.getWidth()-60);
	table2.setLockedWidth(true);
	
	cell = new PdfPCell(new Phrase(textoClausula1, FontFactory.getFont(FontFactory.HELVETICA, 5)));
	cell.setBorder(0);
	cell.setHorizontalAlignment(Element.ALIGN_LEFT);
	//cell.setColspan(1);
	table2.addCell(cell);

	cell = new PdfPCell(new Phrase(textoClausula2, FontFactory.getFont(FontFactory.HELVETICA, 10)));
	cell.setBorder(0);
	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
	//cell.setColspan(1);
	table2.addCell(cell);

	cell = new PdfPCell(new Phrase(textoClausula3, FontFactory.getFont(FontFactory.HELVETICA, 5)));
	cell.setBorder(0);
	cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
	//cell.setColspan(1);
	table2.addCell(cell);
	
	cell = new PdfPCell();
	cell.setBorder(Rectangle.TOP);
	cell.setColspan(4);
	cell.addElement(table2);
	table.addCell(cell);
	


	return table;

	}

	
	public static PdfPCell celdaFirma1(){
		Phrase P = null ;
		PdfPCell cell = new PdfPCell();
			cell.setBorder(Rectangle.BOX);
		
			cell.setColspan(2);
			
			
			 P = new Phrase(" \n \n", FontFactory.getFont(FontFactory.HELVETICA, 10));
			cell.addElement(P);
			//firma1.scaleToFit(cell.getWidth(),cell.getHeight());
			//firm1.setAlignment(Image.LEFT);

			
			cell.addElement(firm1);
			
			 P = new Phrase("_____________________________", FontFactory.getFont(FontFactory.HELVETICA, 7));
			cell.addElement(P);
			 P = new Phrase("           FIRMA DEL BANCO       ", FontFactory.getFont(FontFactory.HELVETICA, 7));
			 cell.addElement(P);
			 P = new Phrase("RENZO FABRICIO SPONZA TUESTA ", FontFactory.getFont(FontFactory.HELVETICA, 7));
			 cell.addElement(P);
			// cell.setPaddingLeft(70f);
			 cell.setPaddingBottom(15f);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			return cell;
		
	}
	
	
}
