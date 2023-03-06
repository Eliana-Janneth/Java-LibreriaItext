import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;


public class GenerarPdf {

    public static void main(String[] args) {
        Document document = new Document(PageSize.A4);

        try {
            PdfWriter.getInstance(document, new FileOutputStream("ejemplo.pdf"));
            document.open();

            // Añadir imagen
            URL imageURL = new URL("https://picsum.photos/700/400?random");
            Image image = Image.getInstance(imageURL);
            image.scaleToFit(300f, 300f);
            image.setAlignment(Chunk.ALIGN_MIDDLE);

            document.add(image);

            // Agregar titulo
            Paragraph title = new Paragraph("Ejemplo de PDF con iText");
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            // Agregar tabla
            PdfPTable table = new PdfPTable(3);// Crea una tabla con 3 columnas
            table.setWidthPercentage(100); // La tabla ocupa el ancho completo de la página
            table.setSpacingBefore(10f); // Espacio antes de la tabla
            table.setSpacingAfter(10f); // Espacio después de la tabla

            // Agregar encabezado
            Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            PdfPCell cell1 = new PdfPCell(new Paragraph("Ciudad", font));
            PdfPCell cell2 = new PdfPCell(new Paragraph("País", font));
            PdfPCell cell3 = new PdfPCell(new Paragraph("Población", font));

            // Agrega filas a la tabla
            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);

            // Agregar datos a las celdas
            table.addCell("Londres");
            table.addCell("Reino Unido");
            table.addCell("8,9 millones");

            table.addCell("Tokio");
            table.addCell("Japón");
            table.addCell("13,9 millones");

            table.addCell("Nueva York");
            table.addCell("Estados Unidos");
            table.addCell("8,3 millones");

            document.add(table);

            // Agregar formulario
            Paragraph formTitle = new Paragraph("Formulario de contacto");
            formTitle.setAlignment(Element.ALIGN_CENTER);
            document.add(formTitle);

            Paragraph formParagraph = new Paragraph("Por favor, complete el siguiente formulario:");
            document.add(formParagraph);

            PdfPTable formTable = new PdfPTable(2);
            formTable.setWidthPercentage(100);
            formTable.setSpacingBefore(10f);
            formTable.setSpacingAfter(10f);

            formTable.addCell("Nombre:");
            formTable.addCell(new PdfPCell());

            formTable.addCell("Apellido:");
            formTable.addCell(new PdfPCell());

            formTable.addCell("Correo electrónico:");
            formTable.addCell(new PdfPCell());

            formTable.addCell("Mensaje:");
            PdfPCell messageCell = new PdfPCell();
            messageCell.setRowspan(3);
            formTable.addCell(messageCell);

            document.add(formTable);

            document.close();
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

