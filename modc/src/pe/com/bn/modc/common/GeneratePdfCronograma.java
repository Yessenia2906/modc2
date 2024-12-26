package pe.com.bn.modc.common;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import pe.com.bn.modc.domain.mapper.BnLetraCambio;
import pe.com.bn.modc.domain.mapper.BnPase;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePdfCronograma {

	public static ByteArrayOutputStream PdfReporteSoft(BnLetraCambio letraCambio) throws DocumentException {
  		 ByteArrayOutputStream baos = new ByteArrayOutputStream();

	        Document document = new Document();
	        PdfWriter.getInstance(document, baos);

	        document.open();
	     
            document.add(creaPDFCronogramaRepro(  letraCambio));
            	 
            // Cerrar el documento
            document.close();

	        return baos;
	}
	
	public static ByteArrayOutputStream PdfPaseJudicial(BnPase pase) throws DocumentException, ParseException {
 		 ByteArrayOutputStream baos = new ByteArrayOutputStream();

	        Document document = new Document();
	        PdfWriter.getInstance(document, baos);

	        document.open();
	     
           document.add(creaPDFPASE(pase));
           	 
           // Cerrar el documento
           document.close();

	        return baos;
	}
	
	





	private static Element creaPDFPASE(BnPase pase) throws ParseException {

		final int AnchoTotal = 14;
		PdfPTable table = new PdfPTable(AnchoTotal);
		table.setTotalWidth(PageSize.A4.getWidth() - 50);

		table.setLockedWidth(true);
		// the cell object
		PdfPCell cell;
		// we add a cell with colspan 3

		 // TITULO
 
		cell = new PdfPCell(new Phrase(
				"Pase a Judicial Préstamos Multired con LCV",
				FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setColspan(11);
		table.addCell(cell);
		
		//table.addCell(tituloPre("PASE A JUDICIAL PRESTAMOS MULTIRED CON LCV",11));
		
		cell = new PdfPCell(new Phrase( Funciones.fechaDelDia(),
				FontFactory.getFont(FontFactory.HELVETICA, 15, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setColspan(3);
		table.addCell(cell);
		
		
		 // TITULO
		
		
		table.addCell(espacioBlanco(AnchoTotal));
		table.addCell(espacioBlanco(AnchoTotal));
		
		cell = new PdfPCell(new Phrase("Nro. CUENTA", FontFactory.getFont(
				FontFactory.HELVETICA, 9, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(2);
		table.addCell(cell);
		// Formatear Número de Préstamo para Cronograma
			
		
		
		cell = new PdfPCell(new Phrase(": " + formatoCuenta(pase.getCCUENTA()) + "",
				FontFactory.getFont(FontFactory.HELVETICA, 10)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(6);
		table.addCell(cell);
	
		
		cell = new PdfPCell(new Phrase("F. PASE JUD", FontFactory.getFont(
				FontFactory.HELVETICA, 8, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setColspan(2);
		table.addCell(cell);
		// Formatear Número de Préstamo para Cronograma
 
		String fdemanda = pase.getFDEMANDA();
		//20230303
		String añod = fdemanda.substring(0, 4);
        String mesd = fdemanda.substring(4, 6);
        String díad = fdemanda.substring(6, 8);

        // Concatenar las partes con "/"
        String fechaFormateadad = añod + "/" + mesd + "/" + díad;
		
		
		
		cell = new PdfPCell(new Phrase(":"+fechaFormateadad,
				FontFactory.getFont(FontFactory.HELVETICA, 10)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setColspan(2);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("PM LCV", FontFactory.getFont(
				FontFactory.HELVETICA, 8, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setColspan(1);
		table.addCell(cell);
		// Formatear Número de Préstamo para Cronograma
 
		String pres = pase.getNPRESTAMO();
		
		String numpres = pres.substring(11);
		
		cell = new PdfPCell(new Phrase(": " + numpres ,
				FontFactory.getFont(FontFactory.HELVETICA, 10)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setColspan(1);
		table.addCell(cell);
		table.addCell(espacioBlanco(AnchoTotal));
 		//---------------------DATOS SALDO
		
		cell = new PdfPCell(new Phrase("Pagare", FontFactory.getFont(
				FontFactory.HELVETICA, 9, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(3);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("Préstamo", FontFactory.getFont(
				FontFactory.HELVETICA, 9, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(2);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("Sld. Actual", FontFactory.getFont(
				FontFactory.HELVETICA, 9, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(2);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("Plz", FontFactory.getFont(
				FontFactory.HELVETICA, 9, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(1);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("Pag", FontFactory.getFont(
				FontFactory.HELVETICA, 9, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(1);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("Cuota", FontFactory.getFont(
				FontFactory.HELVETICA, 9, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(1);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("Tasa", FontFactory.getFont(
				FontFactory.HELVETICA, 9, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(1);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("Fvencmto", FontFactory.getFont(
				FontFactory.HELVETICA, 9, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(2);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("Agen", FontFactory.getFont(
				FontFactory.HELVETICA, 9, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(1);
		table.addCell(cell);
		
		
		
		
		
		//------------------------
		
		
		cell = new PdfPCell(new Phrase(prestamoForm(pase.getNPRESTAMO()), FontFactory.getFont(
				FontFactory.HELVETICA, 8 )));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(3);
		table.addCell(cell);
		
		// Formatear Monto de Préstamo
		String deudaTotal = pase.getSPRESTAMO();

	

		deudaTotal = formatearDeuda(deudaTotal,pase.getSPRESTAMO());
		
		cell = new PdfPCell(new Phrase("S/"+deudaTotal, FontFactory.getFont(
				FontFactory.HELVETICA, 8 )));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(2);
		table.addCell(cell);
		
		// Formatear Monto de Préstamo
		String SACTUAL = pase.getSACTUAL();

	

		SACTUAL = formatearDeuda(SACTUAL,pase.getSACTUAL());
		
		cell = new PdfPCell(new Phrase("S/"+SACTUAL, FontFactory.getFont(
				FontFactory.HELVETICA, 8 )));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(2);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase(Funciones.eliminarCerosAlaIzquierda(pase.getNCUOTAS()), FontFactory.getFont(
				FontFactory.HELVETICA, 8 )));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(1);
		table.addCell(cell);
		
		String ncuota = Funciones.eliminarCerosAlaIzquierda(pase.getNCUOTAS_PAG());
		
		cell = new PdfPCell(new Phrase(ncuota, FontFactory.getFont(
				FontFactory.HELVETICA, 8 )));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(1);
		table.addCell(cell);
		
		String cuotap= pase.getSCUOTAS();

		cuotap = formatearDeuda(cuotap,pase.getSCUOTAS());
		cell = new PdfPCell(new Phrase("S/"+cuotap, FontFactory.getFont(
				FontFactory.HELVETICA, 8 )));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(1);
		table.addCell(cell);
		
		// Formatear Tasa Int.
		String tasa = pase.getTASA();

		
		tasa = formatearTasa(tasa,pase.getTASA());
		
		cell = new PdfPCell(new Phrase(tasa+"%", FontFactory.getFont(
				FontFactory.HELVETICA, 8 )));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(1);
		table.addCell(cell);
		
		String fecv = pase.getFVENCMTO();
		//20230303
		String año = fecv.substring(0, 4);
        String mes = fecv.substring(4, 6);
        String día = fecv.substring(6, 8);

        // Concatenar las partes con "/"
        String fechaFormateada = año + "/" + mes + "/" + día;
		
		
		cell = new PdfPCell(new Phrase(fechaFormateada, FontFactory.getFont(
				FontFactory.HELVETICA, 8 )));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(2);
		table.addCell(cell);
		
		
		String agencia = Funciones.eliminarCerosAlaIzquierda(pase.getCAGENCIA());
		
		cell = new PdfPCell(new Phrase(agencia, FontFactory.getFont(
				FontFactory.HELVETICA, 8 )));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(1);
		table.addCell(cell);
		
	
		cell = new PdfPCell(new Phrase("___________________________________________________________________________________________________________", FontFactory.getFont(
				FontFactory.HELVETICA, 9, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setColspan(AnchoTotal);
		table.addCell(cell);
		
		table.addCell(espacioBlanco(AnchoTotal));
		table.addCell(espacioBlanco(AnchoTotal));


		
		final int ANCHO_TITULO = 3;
		final int ANCHO_CONTENIDO = 4;
		// Formatear Número de Préstamo para Cronograma
 
		table.addCell(tituloPre("Cliente", ANCHO_TITULO));
		
 
		table.addCell(contenido(":"+pase.getACLIENTE(),AnchoTotal-ANCHO_TITULO));
		
		table.addCell(tituloPre("Documento", ANCHO_TITULO));
		
		 
		table.addCell(contenido(":"+pase.getDOCUMENTO(),ANCHO_CONTENIDO));
		
		
		table.addCell(tituloPre("F. Nacimiento", ANCHO_TITULO));
		
		 
		table.addCell(contenido(":"+fechaConAspas(pase.getFNACMTO()),ANCHO_CONTENIDO));
		
		
		table.addCell(tituloPre("Nro.", ANCHO_TITULO));
		
		 
		table.addCell(contenido(":"+pase.getCCUENTA(),ANCHO_CONTENIDO));
		
		table.addCell(tituloPre("Sexo", ANCHO_TITULO));
		
		 
		table.addCell(contenido(":"+pase.getSEXO(),ANCHO_CONTENIDO));
		
		table.addCell(tituloPre("Dirección", ANCHO_TITULO));
		
		 
		table.addCell(contenido(":"+pase.getDCLIENTE(),AnchoTotal-ANCHO_TITULO));
		
		table.addCell(tituloPre("Unidad", ANCHO_TITULO));
		
		 
		table.addCell(contenido(":"+pase.getENTIDAD(),ANCHO_CONTENIDO));
	 
		
		table.addCell(tituloPre("Cond. Laboral", ANCHO_TITULO));
		
		 
		table.addCell(contenido(":" +pase.getSCONLAB() ,ANCHO_CONTENIDO));
		
		
		table.addCell(espacioBlanco(AnchoTotal));
 		
		table.addCell(tituloPre("Prom. Abono." , ANCHO_TITULO));
		
		 String promedio = pase.getSABONOS();
		 
		 promedio = formatearDeuda(promedio, pase.getSABONOS());
		 
		table.addCell(contenido(":"+promedio,ANCHO_CONTENIDO));
		
 
		table.addCell(tituloPre("Calif. SBS" , ANCHO_TITULO));
		
		 
		table.addCell(contenido(":" +pase.getQSBS(),ANCHO_CONTENIDO));
		
		
		
		
		table.addCell(espacioBlanco(AnchoTotal));	
		
		table.addCell(tituloPre("Prest. Pase Judic." , ANCHO_TITULO));
		
		 
		table.addCell(contenido(":"+ prestamoForm(pase.getNPRESTAMO()),ANCHO_CONTENIDO));
		
		table.addCell(tituloPre("F.Dsbolso" , ANCHO_TITULO));
		
		 
		table.addCell(contenido(":S/"+fechaConAspas(pase.getFDSBOLSO()),ANCHO_CONTENIDO));
		
		
		table.addCell(tituloPre("Importe Préstamo" , ANCHO_TITULO));
		
		 
		table.addCell(contenido(":S/"+deudaTotal,ANCHO_CONTENIDO));
		
		 cell = new PdfPCell(new Phrase(
				 "Interes/Seguro desgravamen" ,
					FontFactory.getFont(FontFactory.HELVETICA, 8, Font.BOLD)));
			cell.setBorder(Rectangle.NO_BORDER);
			cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
			cell.setColspan(ANCHO_TITULO);
		
		table.addCell(cell);
		
		String sinteres = pase.getSINTERES();
		sinteres = formatearDeuda(sinteres, pase.getSINTERES());
		
		String sdesgrav = pase.getSDESGRAV();
		sdesgrav = formatearDeuda(sdesgrav, pase.getSDESGRAV());
		 
		table.addCell(contenido(":S/"+ sinteres +"/ S/"+sdesgrav,ANCHO_CONTENIDO));
		
		table.addCell(tituloPre("Saldo Actual " , ANCHO_TITULO));
		
		 
		table.addCell(contenido(":S/"+SACTUAL,ANCHO_CONTENIDO));
		
		table.addCell(tituloPre("Saldo Judicializado" , ANCHO_TITULO));
		// Formatear Monto de Préstamo
		String JUDICIALIZADO = pase.getSJUDICIAL();

	

		JUDICIALIZADO = formatearDeuda(SACTUAL,pase.getSJUDICIAL());
		 
		table.addCell(contenido(":S/"+JUDICIALIZADO,ANCHO_CONTENIDO));	
		table.addCell(tituloPre("Plazo/cuotas Pdte" , ANCHO_TITULO));
		
		 
		table.addCell(contenido(":"+Funciones.eliminarCerosAlaIzquierda(pase.getNCUOTAS())+"/"+Funciones.eliminarCerosAlaIzquierda(pase.getNCUOTAS_PDTS()),ANCHO_CONTENIDO));
		table.addCell(tituloPre("" , ANCHO_TITULO));
		
		 
		table.addCell(contenido("  ",ANCHO_CONTENIDO));
		table.addCell(tituloPre("Cuota" , ANCHO_TITULO));
		
		
		 
		table.addCell(contenido(":S/"+ cuotap,ANCHO_CONTENIDO));
		table.addCell(tituloPre("" , ANCHO_TITULO));
		
		 
		table.addCell(contenido("  ",ANCHO_CONTENIDO));
		
		table.addCell(tituloPre("TEA" , ANCHO_TITULO));
		
		 
		table.addCell(contenido(":"+tasa+" %",ANCHO_CONTENIDO));
		table.addCell(tituloPre("Tasa.Seg.Desgrav" , ANCHO_TITULO));
		table.addCell(contenido(":  "+tasa+" %",ANCHO_CONTENIDO));
		 
		
		// Formatear Tasa Int.
				String TCEA = pase.getTCEA();

				
				TCEA = formatearTasa(tasa,pase.getTCEA());
		
		
		
		
		table.addCell(tituloPre("Fecha Vencimiento" , ANCHO_TITULO));
		
		 
		table.addCell(contenido(":"+fechaConAspas(pase.getFVENCMTO()),ANCHO_CONTENIDO));
		
		table.addCell(tituloPre("" , ANCHO_TITULO));
		
		 
		table.addCell(contenido(":",ANCHO_CONTENIDO));
		
		
		table.addCell(espacioBlanco(AnchoTotal));
		
		
		table.addCell(tituloPre("Nro. Cta. Cte. ", ANCHO_TITULO));
		
		 
		table.addCell(contenido(": "+ pase.getNCTACTE(),AnchoTotal-ANCHO_TITULO));
		
		table.addCell(tituloPre("Fecha Demanda ", ANCHO_TITULO));
		
		 
		table.addCell(contenido(":  ",AnchoTotal-ANCHO_TITULO));
		
		table.addCell(tituloPre("Referencia 1", ANCHO_TITULO));
		
		 
		table.addCell(contenido(":  ",AnchoTotal-ANCHO_TITULO));
		
		
		
		table.addCell(tituloPre("Referencia 2", ANCHO_TITULO));
		
		 
		table.addCell(contenido(":  ",AnchoTotal-ANCHO_TITULO));	
		
		
		
		
		
		
		
		
		
		return table;
		
	}

	private static String prestamoForm(String cadenaOriginal) {
		 // Cadena original
 
        // Dividir la cadena en partes
        String parte1 = cadenaOriginal.substring(0, 11);    // "04009361028"
        String parte2 = cadenaOriginal.substring(11);       // "17"

        // Formar la cadena en el nuevo formato
        String cadenaEnNuevoFormato = parte1 + "-" + parte2;
        return cadenaEnNuevoFormato;
	}

	private static String formatoCuenta(String ccuenta) {
		if (ccuenta.length()!= 11 ) {
			return ccuenta;
		} else {
			   // Dividir la cadena en partes
	        String parte1 = ccuenta.substring(0, 2);     // "04"
	        String parte2 = ccuenta.substring(2, 5);     // "009"
	        String parte3 = ccuenta.substring(5);        // "361028"

	        // Formar la cadena en el nuevo formato
	        String cadenaEnNuevoFormato = parte1 + " " + parte2 + " " + parte3;
	        return cadenaEnNuevoFormato;
		}
	}

	private static String fechaConAspas(String fvencmto) throws ParseException {
		if (fvencmto.length()!=8) {
			return fvencmto;
		} else {
			  SimpleDateFormat formatoOriginal = new SimpleDateFormat("yyyyMMdd");
			  Date fecha = formatoOriginal.parse(fvencmto);
			   // Crear un objeto SimpleDateFormat para el nuevo formato
	            SimpleDateFormat formatoNuevo = new SimpleDateFormat("dd/MM/yyyy");

	            // Formatear la fecha en el nuevo formato
	            String fechaEnFormatoNuevo = formatoNuevo.format(fecha);
 
			return fechaEnFormatoNuevo;
		}
 
	}

	private static PdfPCell contenido(String mesanje, int cancolum) {
		PdfPCell cell = new PdfPCell(new Phrase(
				mesanje.toUpperCase(),
				FontFactory.getFont(FontFactory.HELVETICA, 8)));
		  cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(cancolum);
		
		return cell;
	}

	private static PdfPCell tituloPre(String mesanje, int cancolum) {


		PdfPCell cell = new PdfPCell(new Phrase(
				mesanje ,
				FontFactory.getFont(FontFactory.HELVETICA, 8, Font.BOLD)));
		  cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(cancolum);
		
		return cell;
	}

	public static PdfPTable creaPDFCronogramaRepro(BnLetraCambio letraCambio) {

		final int AnchoTotal = 10;
		PdfPTable table = new PdfPTable(AnchoTotal);
		table.setTotalWidth(PageSize.A4.getWidth() - 60);

		table.setLockedWidth(true);
		// the cell object
		PdfPCell cell;
		// we add a cell with colspan 3

		 
		table.addCell(espacioBlanco(AnchoTotal));

 

	 

		cell = new PdfPCell(new Phrase(
				"CONSULTA EN LINEA DE DEUDA DEL DIA",
				FontFactory.getFont(FontFactory.HELVETICA, 13, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setColspan(8);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase( Funciones.fechaDelDia()));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setColspan(2);
		table.addCell(cell);

	 
		table.addCell(espacioBlanco(AnchoTotal));
	 
		table.addCell(espacioBlanco(AnchoTotal));
		
		
		cell = new PdfPCell(new Phrase("     Apellidos y Nombres",
				FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(3);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase(": " +letraCambio.getACLIENTE() + "",
				FontFactory.getFont(FontFactory.HELVETICA, 10)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(7);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("     Documento Identidad",
				FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(3);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase(": " +letraCambio.getDOCUMENTO() + "",
				FontFactory.getFont(FontFactory.HELVETICA, 10)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(7);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("     Nro. Préstamo", FontFactory.getFont(
				FontFactory.HELVETICA, 10, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(3);
		table.addCell(cell);
		// Formatear Número de Préstamo para Cronograma

		String nPrestamoCronograma = letraCambio.getNPRESTAMO();
		

		
		
		nPrestamoCronograma = FormatearPrestamo(nPrestamoCronograma,letraCambio.getNPRESTAMO());
		
		
		cell = new PdfPCell(new Phrase(": " + nPrestamoCronograma + "",
				FontFactory.getFont(FontFactory.HELVETICA, 10)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("        Fecha Liquidación",
				FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(3);
		table.addCell(cell);
		
		String fvalor= letraCambio.getFVALOR();
		

		String dia1 = fvalor.substring(0, 2);
        String mes1 = fvalor.substring(2, 4);
        String año1 = fvalor.substring(4, 8);

        // Concatenar las partes con "/"
        String fechaFormateada1 = año1 + "/" + mes1 + "/" + dia1;
		
		

		cell = new PdfPCell(new Phrase(": " + fechaFormateada1 + "",
				FontFactory.getFont(FontFactory.HELVETICA, 10)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(2);
		table.addCell(cell);

		
		
		
		
		
		cell = new PdfPCell(new Phrase("     Fecha de desembolso", FontFactory.getFont(
				FontFactory.HELVETICA, 10, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(3);
		table.addCell(cell);
		// Formatear Número de Préstamo para Cronograma

		
		String fdese = letraCambio.getFDSBOLSO();
		
		
		String año = fdese.substring(0, 4);
        String mes = fdese.substring(4, 6);
        String día = fdese.substring(6, 8);

        // Concatenar las partes con "/"
        String fechaFormateada = año + "/" + mes + "/" + día;
		
		
		cell = new PdfPCell(new Phrase(": " + fechaFormateada + "",
				FontFactory.getFont(FontFactory.HELVETICA, 10)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("        Saldo de préstamo",
				FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(3);
		table.addCell(cell);
		
		// Formatear Monto de Préstamo
		String sactual= letraCambio.getSACTUAL();
		sactual = formatearDeuda(sactual,letraCambio.getSACTUAL());
		

		cell = new PdfPCell(new Phrase(": S/" + sactual + "",
				FontFactory.getFont(FontFactory.HELVETICA, 10)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(2);
		table.addCell(cell);
		
		
		
		
		
		cell = new PdfPCell(new Phrase("     Monto de préstamo", FontFactory.getFont(
				FontFactory.HELVETICA, 10, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(3);
		table.addCell(cell);
		
		String sprestamo= letraCambio.getSPRESTAMO();
		sprestamo = formatearDeuda(sprestamo,letraCambio.getSPRESTAMO());
		
		
		cell = new PdfPCell(new Phrase(": S/" + sprestamo + "",
				FontFactory.getFont(FontFactory.HELVETICA, 10)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("        Interés Vencido",
				FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(3);
		table.addCell(cell);
		
         String VENCIDO = letraCambio.getSINTVENC();

		
		VENCIDO = formatearTasa(VENCIDO,letraCambio.getSINTVENC());
		
		cell = new PdfPCell(new Phrase(": S/" + VENCIDO+ "",
				FontFactory.getFont(FontFactory.HELVETICA, 10)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(2);
		table.addCell(cell);
		
		
		
		cell = new PdfPCell(new Phrase("     Importe recuperado", FontFactory.getFont(
				FontFactory.HELVETICA, 10, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(3);
		table.addCell(cell);
		
		
		//float f1 = Float.parseDo(sprestamo);
	//	BigDecimal doble1 = new BigDecimal(sprestamo);
	//	BigDecimal doble2 = new BigDecimal(sactual);
		
	
		
	//float	saldoAmortizacion = ((String) letraCambio.getSAMORTIZACION().get(i));

	//	resta1 = Float.parseFloat((sprestamo).replace(",", ""));
		//resta1 = Float.parseFloat((sactual).replace(",", ""));
		
		//restaT = resta1 - resta2;
		float resta11 = 0;
		float resta22 = 0;
		float rest =0;
		
		String resta1 = "";
		String resta2 = "";
		resta1 = ((String) letraCambio.getSPRESTAMO());
		
		resta2 = ((String) letraCambio.getSACTUAL());


		resta11 = Float.parseFloat(resta1);
		resta22 = Float.parseFloat(resta2);
		
		rest = resta11- resta22;
		
		System.out.print("resta" +rest);
		
		
	
	String RESST1 = "";
	BigDecimal saldoAmortizacionParaSuma1 = BigDecimal.ZERO;
	
	String RESST2 = "";
	BigDecimal saldoAmortizacionParaSuma2 = BigDecimal.ZERO;
	
	float saldoAmortizacionParaSumaFloat11 = 0;
	
	float saldoAmortizacionParaSumaFloat22 = 0;
	
	float restaaa = 0;
	
	String sprestamo1 = "";
	
	String sactual1 = "";
	
	sprestamo1 = ((String) letraCambio.getSPRESTAMO());
	
	sactual1 = ((String) letraCambio.getSACTUAL());
	
	RESST1 = Funciones.formatearMonto(Funciones.tramaToBigDecimal(sprestamo1, 2));
	saldoAmortizacionParaSuma1 = Funciones.tramaToBigDecimal(sprestamo1, 2);
	saldoAmortizacionParaSumaFloat11 = saldoAmortizacionParaSuma1.floatValue();
	
	
	RESST2 = Funciones.formatearMonto(Funciones.tramaToBigDecimal(sactual1, 2));
	saldoAmortizacionParaSuma2 = Funciones.tramaToBigDecimal(sactual1, 2);
	saldoAmortizacionParaSumaFloat22 = saldoAmortizacionParaSuma2.floatValue();
	
	
	
	
	restaaa = saldoAmortizacionParaSumaFloat11 - saldoAmortizacionParaSumaFloat22;
	
	
	
	String str = Float.toString(restaaa);
	
//	String sdeuda1 = letraCambio.getSDEUDA_D();				
	//sdeuda1 = formatearDeuda(sdeuda1,letraCambio.getSDEUDA_D());
	
	 BigDecimal numeroBigDecimal = new BigDecimal(str);
	
	String formatorest = Funciones.formatearMonto(numeroBigDecimal);
	
//	String fo = Funciones.formatearMonto(Funciones.tramaToBigDecimal(numeroBigDecimal, 2));
	
	//ff = 2302.6719
	System.out.print("f" + formatorest);
//	saldoAmortizacion = Funciones.formatearMonto(Funciones.tramaToBigDecimal(sAmortizacion, 2));
	//saldoAmortizacionParaSuma = Funciones.tramaToBigDecimal(sAmortizacion, 2);
	//saldoAmortizacionParaSumaFloat = saldoAmortizacionParaSuma.floatValue();
	
		
		cell = new PdfPCell(new Phrase(": S/" +  formatorest+ "",
				FontFactory.getFont(FontFactory.HELVETICA, 10)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("        Interés Compensatorio",
				FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(3);
		table.addCell(cell);
		
		// Formatear Tasa Int.
				String COMEPENSAI = letraCambio.getSINTCOMP();

				
				COMEPENSAI = formatearTasa(COMEPENSAI,letraCambio.getSINTCOMP());
				
				cell = new PdfPCell(new Phrase(": "  + COMEPENSAI + " %" , FontFactory.getFont(
						FontFactory.HELVETICA, 10)));
				cell.setBorder(Rectangle.NO_BORDER);
				cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
				cell.setColspan(2);
				table.addCell(cell);
		
		
				
				

				cell = new PdfPCell(new Phrase("     Tasa de interés compensatorio", FontFactory.getFont(
						FontFactory.HELVETICA, 9, Font.BOLD)));
				cell.setBorder(Rectangle.NO_BORDER);
				cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
				cell.setColspan(3);
				table.addCell(cell);
				
				
				String tasa1 = letraCambio.getTASA();				
				tasa1 = formatearTasa(tasa1,letraCambio.getTASA());
				
				cell = new PdfPCell(new Phrase(": " + tasa1 + " %",
						FontFactory.getFont(FontFactory.HELVETICA, 10)));
				cell.setBorder(Rectangle.NO_BORDER);
				cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
				cell.setColspan(2);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase("        Interés Moratorio",
						FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
				cell.setBorder(Rectangle.NO_BORDER);
				cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
				cell.setColspan(3);
				table.addCell(cell);
				
				String MORATORIO = letraCambio.getSINTMORA();				
				MORATORIO = formatearTasa(MORATORIO,letraCambio.getSINTMORA());
				
				cell = new PdfPCell(new Phrase(": " + MORATORIO + " %",
						FontFactory.getFont(FontFactory.HELVETICA, 10)));
				cell.setBorder(Rectangle.NO_BORDER);
				cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
				cell.setColspan(2);
				table.addCell(cell);
				
				
				
				
				
				cell = new PdfPCell(new Phrase("     Tasa de interés moratorio", FontFactory.getFont(
						FontFactory.HELVETICA, 10, Font.BOLD)));
				cell.setBorder(Rectangle.NO_BORDER);
				cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
				cell.setColspan(3);
				table.addCell(cell);
				
				
				String tseg1 = letraCambio.getTSEG();				
				tseg1 = formatearTasa(tseg1,letraCambio.getTSEG());
				
				cell = new PdfPCell(new Phrase(": " + tseg1 + " %",
						FontFactory.getFont(FontFactory.HELVETICA, 10)));
				cell.setBorder(Rectangle.NO_BORDER);
				cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
				cell.setColspan(2);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase("        Seguro de Desgravamen",
						FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
				cell.setBorder(Rectangle.NO_BORDER);
				cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
				cell.setColspan(3);
				table.addCell(cell);
				
				String DESGRAV = letraCambio.getSSEGURO();

				
				DESGRAV = formatearTasa(DESGRAV,letraCambio.getSSEGURO());
				cell = new PdfPCell(new Phrase(": "+ DESGRAV + " %",
						FontFactory.getFont(FontFactory.HELVETICA, 10)));
				cell.setBorder(Rectangle.NO_BORDER);
				cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
				cell.setColspan(2);
				table.addCell(cell);
				
				
				cell = new PdfPCell(new Phrase("     Tasa Seguro desgravamen", FontFactory.getFont(
						FontFactory.HELVETICA, 10, Font.BOLD)));
				cell.setBorder(Rectangle.NO_BORDER);
				cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
				cell.setColspan(3);
				table.addCell(cell);
				
				
				String tcea1 = letraCambio.getTCEA();				
				tcea1 = formatearTasa(tcea1,letraCambio.getTCEA());
				
				cell = new PdfPCell(new Phrase(": " + tcea1 + " %",
						FontFactory.getFont(FontFactory.HELVETICA, 10)));
				cell.setBorder(Rectangle.NO_BORDER);
				cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
				cell.setColspan(2);
				table.addCell(cell);

			
				
				cell = new PdfPCell(new Phrase("        Deuda Total",
						FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD)));
				cell.setBorder(Rectangle.NO_BORDER);
				cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
				cell.setColspan(3);
				table.addCell(cell);
				
				String sdeuda1 = letraCambio.getSDEUDA_D();				
				sdeuda1 = formatearDeuda(sdeuda1,letraCambio.getSDEUDA_D());
				
				
				
				cell = new PdfPCell(new Phrase(": S/" + sdeuda1, FontFactory.getFont(
						FontFactory.HELVETICA, 10)));
				cell.setBorder(Rectangle.NO_BORDER);
				cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
				cell.setColspan(2);
				table.addCell(cell);
				
				
		
		
		
	 
		table.addCell(espacioBlanco(AnchoTotal));
		
		cell = new PdfPCell(
				new Phrase(
						"      --------------------------------------------------------------------------------------------------------------------------"));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(AnchoTotal);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Nro Cuota", FontFactory.getFont(
				FontFactory.HELVETICA, 8, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setColspan(1);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Fecha Vencimiento", FontFactory.getFont(
				FontFactory.HELVETICA, 8, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setColspan(2);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Amortización", FontFactory.getFont(
				FontFactory.HELVETICA, 7, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setColspan(1);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Interés Vencido", FontFactory.getFont(
				FontFactory.HELVETICA, 7, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setColspan(1);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Interés Compensa.", FontFactory.getFont(
				FontFactory.HELVETICA, 7, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setColspan(1);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Interés Moratorio", FontFactory.getFont(
				FontFactory.HELVETICA, 7, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setColspan(1);
		table.addCell(cell);
		
	
		
 

		cell = new PdfPCell(new Phrase("Seguro de Desgravamen", FontFactory.getFont(
				FontFactory.HELVETICA, 7, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setColspan(1);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("Cuota", FontFactory.getFont(
				FontFactory.HELVETICA, 8, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setColspan(1);
		table.addCell(cell);
		cell = new PdfPCell(new Phrase("Situacion", FontFactory.getFont(
				FontFactory.HELVETICA, 8, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setColspan(1);
		table.addCell(cell);
		
		cell = new PdfPCell(
				new Phrase(
						"      --------------------------------------------------------------------------------------------------------------------------"));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(AnchoTotal);
		table.addCell(cell);

		int numCuotas = 0;

		numCuotas = Integer.parseInt(letraCambio.getNCUOTAS());

		String fechaVencimiento = "";
		String diaVencimiento = "";
		String mesVencimiento = "";
		String annioVencimiento = "";

		// String saldoAmortizacion = "";

		float montoPrestamo = 0;
		float saldoAmortizacion_Numero = 0;
		float[] saldoDeuda = new float[numCuotas];

		int parteEnteraSaldoDeuda = 0;
		float parteFloatSaldoDeuda = 0;

		String sAmortizacion = "";
		String sIntereses = "";
		String sInteresesMora = "";
		String sInteresesComp = "";
		String sDesgravamen = "";
	
		
		String sSaldo = "";
		String sCuota = "";

		String saldoAmortizacion = "";
		BigDecimal saldoAmortizacionParaSuma = BigDecimal.ZERO;
		String saldoIntereses = "";
		BigDecimal saldoInteresesParaSuma = BigDecimal.ZERO;
		
		
		String saldoDesgravamen = "";
		String intMora = "";
		String intComp = "";
		
	
		String saldoDesgravamenComp = "";
		
		BigDecimal saldoInteresesMoraParaSuma = BigDecimal.ZERO;
		BigDecimal saldoInteresesCompParaSuma = BigDecimal.ZERO;
		String saldoDesgravamenMora = "";
		
		BigDecimal saldoDesgravamenParaSuma = BigDecimal.ZERO;
		BigDecimal saldoIntMoraParaSuma = BigDecimal.ZERO;
		BigDecimal saldoIntCompParaSuma = BigDecimal.ZERO;
		
		String saldoSaldo = "";
		BigDecimal saldoSaldoParaSuma = BigDecimal.ZERO;
		String saldoCuota = "";
		BigDecimal saldoCuotaParaSuma = BigDecimal.ZERO;

		float saldoAmortizacionParaSumaFloat = 0;
		float saldoInteresesParaSumaFloat = 0;
		float saldoInteresesCompParaSumaFloat = 0;
		float saldoInteresesMoraParaSumaFloat = 0;
		float saldoDesgravamenParaSumaFloat = 0;
		float saldoSaldoParaSumaFloat = 0;
		float saldoCuotaParaSumaFloat = 0;

		float saldAmorti = 0;
		float saldInter = 0;
		float saldInterComp = 0;
		float saldInterMora = 0;
		float saldDesgrav = 0;
		float saldCuot = 0;

		for (int i = 0; i < numCuotas; i++) {

			annioVencimiento = ((String) letraCambio.getFVCTO().get(i)).substring(0, 4);
			mesVencimiento = ((String) letraCambio.getFVCTO().get(i)).substring(4, 6);
			diaVencimiento = ((String) letraCambio.getFVCTO().get(i)).substring(6, 8);

			fechaVencimiento = diaVencimiento + "-" + mesVencimiento + "-"
					+ annioVencimiento;
			
			if (i == 0) {
				saldoAmortizacion = ((String) letraCambio.getSAMORTIZACION().get(i));

				montoPrestamo = Float.parseFloat(letraCambio.getSPRESTAMO());
				saldoAmortizacion_Numero = Float.parseFloat(saldoAmortizacion);
		 
			} else {
				saldoAmortizacion = ((String) letraCambio.getSAMORTIZACION().get(i));

				saldoAmortizacion_Numero = Float.parseFloat(saldoAmortizacion);
				saldoDeuda[i] = saldoDeuda[i - 1] - saldoAmortizacion_Numero;

			}
	 

			sAmortizacion = ((String) letraCambio.getSAMORTIZACION().get(i));
			sIntereses = ((String) letraCambio.getSINTERES().get(i));
			
			sInteresesComp = ((String) letraCambio.getSINTCOMP1().get(i));
			sInteresesMora = ((String) letraCambio.getSINTMORA1().get(i));
			
			
			sDesgravamen = ((String) letraCambio.getSDESGRAVAMEN().get(i));
			sSaldo = ((String)  letraCambio.getSDESGRAVAMEN().get(i));
			sCuota = ((String)  letraCambio.getSDCUOTA().get(i));
			
		

			saldoAmortizacion = Funciones.formatearMonto(Funciones.tramaToBigDecimal(sAmortizacion, 2));
			saldoAmortizacionParaSuma = Funciones.tramaToBigDecimal(sAmortizacion, 2);
			saldoAmortizacionParaSumaFloat = saldoAmortizacionParaSuma.floatValue();

			saldoIntereses = Funciones.formatearMonto(Funciones.tramaToBigDecimal(sIntereses, 2));
			saldoInteresesParaSuma = Funciones.tramaToBigDecimal(sIntereses, 2);
			saldoInteresesParaSumaFloat = saldoInteresesParaSuma.floatValue();
			
			
			intComp = Funciones.formatearMonto(Funciones.tramaToBigDecimal(sInteresesComp, 2));
			saldoIntCompParaSuma = Funciones.tramaToBigDecimal(sInteresesComp, 2);
			saldoInteresesCompParaSumaFloat = saldoIntCompParaSuma.floatValue();
			
			
			intMora = Funciones.formatearMonto(Funciones.tramaToBigDecimal(sInteresesMora, 2));
			saldoIntMoraParaSuma = Funciones.tramaToBigDecimal(sInteresesMora, 2);
			saldoInteresesMoraParaSumaFloat = saldoIntMoraParaSuma.floatValue();
			
	
			saldoDesgravamen = Funciones.formatearMonto(Funciones
					.tramaToBigDecimal(sDesgravamen, 2));
			saldoDesgravamenParaSuma = Funciones.tramaToBigDecimal(
					sDesgravamen, 2);
			saldoDesgravamenParaSumaFloat = saldoDesgravamenParaSuma
					.floatValue();

			saldoSaldo = Funciones.formatearMonto(Funciones.tramaToBigDecimal(
					sSaldo, 2));
			saldoSaldoParaSuma = Funciones.tramaToBigDecimal(sSaldo, 2);
			saldoSaldoParaSumaFloat = saldoSaldoParaSuma.floatValue();

			saldoCuota = Funciones.formatearMonto(Funciones.tramaToBigDecimal(
					sCuota, 2));
			saldoCuotaParaSuma = Funciones.tramaToBigDecimal(sCuota, 2);
			saldoCuotaParaSumaFloat = saldoCuotaParaSuma.floatValue();

			cell = new PdfPCell(new Phrase("" + String.format("%02d", i + 1)
					+ "", FontFactory.getFont(FontFactory.HELVETICA, 10)));
			cell.setBorder(Rectangle.NO_BORDER);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setColspan(1);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("" + fechaVencimiento + "",
					FontFactory.getFont(FontFactory.HELVETICA, 10)));
			cell.setBorder(Rectangle.NO_BORDER);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setColspan(2);
			table.addCell(cell);

		
			saldoAmortizacion = validarSaldoAmortizacion(saldoAmortizacion,sAmortizacion);
			
			cell = new PdfPCell(new Phrase("" + saldoAmortizacion + "",FontFactory.getFont(FontFactory.HELVETICA, 10)));
			cell.setBorder(Rectangle.NO_BORDER);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setColspan(1);
			table.addCell(cell);

			
			
		
			saldoIntereses = validarSaldoIntereses(saldoIntereses,sIntereses);
			cell = new PdfPCell(new Phrase("" + saldoIntereses + "",FontFactory.getFont(FontFactory.HELVETICA, 10)));
			cell.setBorder(Rectangle.NO_BORDER);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setColspan(1);
			table.addCell(cell);
			
			
		
			
			
			cell = new PdfPCell(new Phrase("" + intComp + "",
					FontFactory.getFont(FontFactory.HELVETICA, 10)));
			cell.setBorder(Rectangle.NO_BORDER);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setColspan(1);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase("" + intMora + "",
					FontFactory.getFont(FontFactory.HELVETICA, 10)));
			cell.setBorder(Rectangle.NO_BORDER);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setColspan(1);
			table.addCell(cell);
			
		
			
	

			cell = new PdfPCell(new Phrase("" + saldoDesgravamen + "",
					FontFactory.getFont(FontFactory.HELVETICA, 10)));
			cell.setBorder(Rectangle.NO_BORDER);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setColspan(1);
			table.addCell(cell);

		
			saldoCuota = validarSaldoCuota(saldoCuota,sCuota);
			
			cell = new PdfPCell(new Phrase("" + saldoCuota + "",
					FontFactory.getFont(FontFactory.HELVETICA, 10)));
			cell.setBorder(Rectangle.NO_BORDER);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setColspan(1);
			table.addCell(cell);

		 

	
			
			cell = new PdfPCell(new Phrase("" +  letraCambio.getACUOTA().get(i) + "",
					FontFactory.getFont(FontFactory.HELVETICA, 10)));
			cell.setBorder(Rectangle.NO_BORDER);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setColspan(1);
			table.addCell(cell);
 
			                          
			saldAmorti = saldAmorti + saldoAmortizacionParaSumaFloat;
			saldInter = saldInter + saldoInteresesParaSumaFloat;
			
			
			                                
			saldInterComp = saldInterComp + saldoInteresesCompParaSumaFloat;
			saldInterMora = saldInterMora + saldoInteresesMoraParaSumaFloat;
			saldDesgrav = saldDesgrav + saldoDesgravamenParaSumaFloat;
			saldCuot = saldCuot + saldoCuotaParaSumaFloat;

	 
		}

	 

		cell = new PdfPCell(
				new Phrase(
						"      --------------------------------------------------------------------------------------------------------------------------"));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(AnchoTotal);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase("     TOTALES", FontFactory.getFont(
				FontFactory.HELVETICA, 10, Font.BOLD)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setColspan(3);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase(""
				+ Funciones.formatearMonto111(saldAmorti) + "",
				FontFactory.getFont(FontFactory.HELVETICA, 10)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setColspan(1);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase(""
				+ Funciones.formatearMonto111(saldInter) + "",
				FontFactory.getFont(FontFactory.HELVETICA, 10)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setColspan(1);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase(""
				+ Funciones.formatearMonto111(saldInterComp) + "",
				FontFactory.getFont(FontFactory.HELVETICA, 10)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setColspan(1);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase(""
				+ Funciones.formatearMonto111(saldInterMora) + "",
				FontFactory.getFont(FontFactory.HELVETICA, 10)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setColspan(1);
		table.addCell(cell);
		
		

		cell = new PdfPCell(new Phrase(""
				+ Funciones.formatearMonto111(saldDesgrav) + "",
				FontFactory.getFont(FontFactory.HELVETICA, 10)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setColspan(1);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase(""
				+ Funciones.formatearMonto111(saldCuot) + "",
				FontFactory.getFont(FontFactory.HELVETICA, 10)));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setColspan(1);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase(" "));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setColspan(1);
		table.addCell(cell);

 

		cell = new PdfPCell(
				new Phrase(
						"      --------------------------------------------------------------------------------------------------------------------------"));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(AnchoTotal);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase(" "));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(AnchoTotal);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase(" "));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(AnchoTotal);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase(" "));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(AnchoTotal);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase(" "));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(AnchoTotal);
		table.addCell(cell);

		cell = new PdfPCell(new Phrase(" "));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(AnchoTotal);
		table.addCell(cell);

	 

 

		return table;

	}

	private static String FormatearPrestamo(String nPrestamoCronograma,
			String nprestamo) {
		String valor11 = "";
		String valor2 = "";

		if (nPrestamoCronograma.equals("")) {
			nPrestamoCronograma = "";
		} else {
			valor11 = (nprestamo).substring(0, 11);
			valor2 = (nprestamo).substring(11, 13);

			nPrestamoCronograma = valor11 + "-" + valor2;
		}
		return nPrestamoCronograma;
		
	}

	private static String formatearDeuda(String deudaTotal, String sprestamo) {
		if (deudaTotal.equals("")) {
			deudaTotal = "";
		} else {
			deudaTotal = Funciones.formatearMonto(Funciones.tramaToBigDecimal(
					sprestamo, 2));
		}
		return deudaTotal;
	}



	private static String formatearTasa(String tasa ,String tasaCRONO) {
		if (tasa.equals("")) {
			tasa = "";
		} else {
			tasa = Funciones.formatearMonto(Funciones.tramaToBigDecimal(
					tasaCRONO, 7));
		}
		return tasa;
	}


	private static String validarSaldoCuota(String saldoCuota, String sCuota) {
		if (saldoCuota.length() == 4 || saldoCuota.length() == 5) {

			if (saldoCuota.equals("0.00")) {
				saldoCuota = "    " + saldoCuota;
			} else {
				saldoCuota = "  " + saldoCuota;
			}

		} else {
			saldoCuota = Funciones.formatearMonto(Funciones
					.tramaToBigDecimal(sCuota, 2));
		}
		return saldoCuota;
	}

	private static String validarSaldoIntereses(String saldoIntereses,
			String sIntereses) {
		if (saldoIntereses.length() == 4) {

			saldoIntereses = "     " + saldoIntereses;

		} else if (saldoIntereses.length() == 5) {

			saldoIntereses = "   " + saldoIntereses;

		} else {

			saldoIntereses = " "
					+ Funciones.formatearMonto(Funciones.tramaToBigDecimal(
							sIntereses, 2));
		}
		return saldoIntereses;
	}
	
	
	private static String validarSaldoInteresesComp(String saldoInteresesComp,
			String sIntereses) {
		if (saldoInteresesComp.length() == 4) {

			saldoInteresesComp = "     " + saldoInteresesComp;

		} else if (saldoInteresesComp.length() == 5) {

			saldoInteresesComp = "   " + saldoInteresesComp;

		} else {

			saldoInteresesComp = " "
					+ Funciones.formatearMonto(Funciones.tramaToBigDecimal(
							sIntereses, 2));
		}
		return saldoInteresesComp;
	}
	
	private static String validarSaldoInteresesMora(String saldoInteresesMora,
			String sIntereses) {
		if (saldoInteresesMora.length() == 4) {

			saldoInteresesMora = "     " + saldoInteresesMora;

		} else if (saldoInteresesMora.length() == 5) {

			saldoInteresesMora = "   " + saldoInteresesMora;

		} else {

			saldoInteresesMora = " "
					+ Funciones.formatearMonto(Funciones.tramaToBigDecimal(
							sIntereses, 2));
		}
		return saldoInteresesMora;
	}
	
	
	


	private static String validarSaldoAmortizacion(String saldoAmortizacion, String sAmortizacion) {
		if (saldoAmortizacion.length() == 4
				|| saldoAmortizacion.length() == 5) {

			if (saldoAmortizacion.equals("0.00")) {
				saldoAmortizacion = "    " + saldoAmortizacion;
			} else {
				saldoAmortizacion = "  " + saldoAmortizacion;
			}

		} else {
			saldoAmortizacion = Funciones.formatearMonto(Funciones
					.tramaToBigDecimal(sAmortizacion, 2));
		}
		return saldoAmortizacion;
	}


	private static PdfPCell espacioBlanco(int anchoTotal) {
		PdfPCell cell = new PdfPCell(new Phrase(" "));
		cell.setBorder(Rectangle.NO_BORDER);
		cell.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
		cell.setColspan(anchoTotal);
		return cell;
	}
	

}
