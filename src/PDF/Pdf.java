/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PDF;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;




/**
 *
 * @author Agustin Colongne
 */
public class Pdf {
    
    public void pdf(){
        try {
            FileOutputStream archivo;
            File file = new File("src/Pdf/presupuesto.pdf");
            archivo = new FileOutputStream(file);
            Document documento = new Document();
            PdfWriter.getInstance(documento, archivo);
            documento.open();
            Image imagen = Image.getInstance("src/posiblesVistas/logo sin fondo ni letras.png");
            
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD, BaseColor.BLUE);
            fecha.add(Chunk.NEWLINE);
            Date date = new Date();
            fecha.add("Fecha: "+ new SimpleDateFormat("dd/mm/yyyy").format(date)+"\n\n" );
            
            PdfPTable Encabesado = new PdfPTable(4);
            Encabesado.setWidthPercentage(100);
            Encabesado.getDefaultCell().setBorder(0);
            float[] columnaEncabesado = new float[]{20f, 30f, 70f, 40f};
            Encabesado.setWidths(columnaEncabesado);
            Encabesado.setHorizontalAlignment(Element.ALIGN_LEFT);
            
            Encabesado.addCell(imagen);
            String nombre = "TAGUS - Viajá, conocé y disfrutá";
            String numero = "Contactanos al 351-000-0000";
            String ra = "Agencia de viaje S.A";
            
            Encabesado.addCell("");
            Encabesado.addCell("\n\n " + nombre  + "\n\nRazón Social: " + ra + "\n\nNúmero: " + numero);
            Encabesado.addCell(fecha);
            documento.add(Encabesado);
            
            
            //datos Cliente
            Paragraph datosCliente = new Paragraph();
            datosCliente.add(Chunk.NEWLINE);
            datosCliente.add("Datos de nuestro cliente "+"\n\n");
            documento.add(datosCliente);
            
            PdfPTable tablaCliente = new PdfPTable(6);
            tablaCliente.setWidthPercentage(100);
            tablaCliente.getDefaultCell().setBorder(0);
            float[] columnaCliente = new float[]{30f, 45f,35f,70f, 40f,30f};
            tablaCliente.setWidths(columnaCliente);
            tablaCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cliente1 = new PdfPCell(new Phrase("DNI", negrita));
            PdfPCell cliente2 = new PdfPCell(new Phrase("Nombre Completo", negrita));
            PdfPCell cliente3 = new PdfPCell(new Phrase("Teléfono", negrita));
            PdfPCell cliente4 = new PdfPCell(new Phrase("Mail", negrita));
            PdfPCell cliente5 = new PdfPCell(new Phrase("Financiación", negrita));
            PdfPCell cliente6 = new PdfPCell(new Phrase("Cuotas", negrita));
            
//            cliente1.setBorder(0);
//            cliente2.setBorder(0);
//            cliente3.setBorder(0);
//            cliente4.setBorder(0);
//            cliente5.setBorder(0);
//            cliente3.setBorder(0);
            
            cliente1.setBackgroundColor(BaseColor.ORANGE);
            cliente2.setBackgroundColor(BaseColor.ORANGE);
            cliente3.setBackgroundColor(BaseColor.ORANGE);
            cliente4.setBackgroundColor(BaseColor.ORANGE);
            cliente5.setBackgroundColor(BaseColor.ORANGE);
            cliente6.setBackgroundColor(BaseColor.ORANGE);
            
            
            
            tablaCliente.addCell(cliente1);
            tablaCliente.addCell(cliente2);
            tablaCliente.addCell(cliente3);
            tablaCliente.addCell(cliente4);
            tablaCliente.addCell(cliente5);
            tablaCliente.addCell(cliente6);
            
            //for (int i = 0; i < tabla; i++) {
              //recorre cliente//  
           // }*/
            tablaCliente.addCell("54645612");
            tablaCliente.addCell("Agustin Colongne");
            tablaCliente.addCell("3512305123");
            tablaCliente.addCell("aguscolongne@gmail.com");
            tablaCliente.addCell("Efectivo");
            tablaCliente.addCell("0");
            
            documento.add(tablaCliente);
            // final datos cliente
            
            
            //Datos Pasaje y Hotel
           PdfPTable tablaPasajeHotel = new PdfPTable(5);
           tablaPasajeHotel.setWidthPercentage(100);
           tablaPasajeHotel.getDefaultCell().setBorder(0);
           float[] columnaPasajeHotel = new float[]{25f, 25f, 30f, 30f,30f};
           tablaPasajeHotel.setWidths(columnaPasajeHotel);
           tablaPasajeHotel.setHorizontalAlignment(Element.ALIGN_LEFT);
           PdfPCell pasajeHotel1 = new PdfPCell(new Phrase("Desde", negrita));
           PdfPCell pasajeHotel2 = new PdfPCell(new Phrase("Hasta", negrita));
           PdfPCell pasajeHotel3 = new PdfPCell(new Phrase("Fecha de viaje", negrita));
           PdfPCell pasajeHotel4 = new PdfPCell(new Phrase("Fecha de regreso", negrita));
           PdfPCell pasajeHotel5 = new PdfPCell(new Phrase("Cant.personas", negrita));
           
            
            pasajeHotel1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            pasajeHotel2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            pasajeHotel3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            pasajeHotel4.setBackgroundColor(BaseColor.LIGHT_GRAY);
            pasajeHotel5.setBackgroundColor(BaseColor.LIGHT_GRAY);
            
            
           tablaPasajeHotel.addCell(pasajeHotel1);
           tablaPasajeHotel.addCell(pasajeHotel2);
           tablaPasajeHotel.addCell(pasajeHotel3);
           tablaPasajeHotel.addCell(pasajeHotel4);
           tablaPasajeHotel.addCell(pasajeHotel5);
           tablaPasajeHotel.addCell("cordoba,cordoba,argentina");
           tablaPasajeHotel.addCell("florianopolis,florianopolis,brasil");
           tablaPasajeHotel.addCell("23/12/2023");
           tablaPasajeHotel.addCell("10/1/2024");
           tablaPasajeHotel.addCell("4");
           
         
            
           documento.add(tablaPasajeHotel);
           // Fin datos Pasaje  y Hotel    
           
            
            
           //completar formas de pago, importe, cantidad de dias

            documento.close();
            archivo.close();
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error " + e);
        }
    
    
    }
    
    
    
}
