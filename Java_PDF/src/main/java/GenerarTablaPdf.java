
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

    public class GenerarTablaPdf {

        public static void main(String[] args) {
            Document document = new Document(PageSize.A4, 50, 50, 50, 50);
            try {
                PdfWriter.getInstance(document, new FileOutputStream("C:/Users/Eliana/Documents/JAVA/tabla.pdf"));
                document.open();
                PdfPTable table = new PdfPTable(3); // Crea una tabla con 3 columnas
                table.setWidthPercentage(100); // La tabla ocupa el ancho completo de la página
                table.setSpacingBefore(10f); // Espacio antes de la tabla
                table.setSpacingAfter(10f); // Espacio después de la tabla

                // Agrega encabezados a la tabla
                PdfPCell cell1 = new PdfPCell(new Paragraph("Ciudad"));
                PdfPCell cell2 = new PdfPCell(new Paragraph("País"));
                PdfPCell cell3 = new PdfPCell(new Paragraph("Población"));
                table.addCell(cell1);
                table.addCell(cell2);
                table.addCell(cell3);

                // Agrega filas a la tabla
                List<String[]> ciudades = obtenerCiudades();
                for (String[] ciudad : ciudades) {
                    table.addCell(ciudad[0]);
                    table.addCell(ciudad[1]);
                    table.addCell(ciudad[2]);
                }
                document.add(table); // Agrega la tabla al documento

                document.close();
            } catch (DocumentException | FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        // Retorna una lista de ciudades como array de strings
        public static List<String[]> obtenerCiudades() {
            List<String[]> ciudades = new ArrayList<>();
            ciudades.add(new String[]{"Nueva York", "Estados Unidos", "8.4 millones"});
            ciudades.add(new String[]{"Tokio", "Japón", "9.2 millones"});
            ciudades.add(new String[]{"Londres", "Reino Unido", "8.9 millones"});
            ciudades.add(new String[]{"París", "Francia", "2.1 millones"});
            return ciudades;
        }
    }


