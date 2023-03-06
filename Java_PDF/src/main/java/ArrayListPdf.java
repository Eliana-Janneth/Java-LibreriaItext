import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class ArrayListPdf{
    public static void main(String[] args) {
        Document document = new Document(PageSize.A4);

        try {
            PdfWriter.getInstance(document, new FileOutputStream("ArrayListToPDFExample.pdf"));

            document.open();
            document.add(new Paragraph("ArrayList to PDF Example"));

            ArrayList<String> list = new ArrayList<>();
            list.add("Item 1");
            list.add("Item 2");
            list.add("Item 3");
            list.add("Item 4");
            list.add("Item 5");

            for (String item : list) {
                document.add(new Paragraph(item));
            }

            document.close();

            System.out.println("PDF Creado Exitosamente.");
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
