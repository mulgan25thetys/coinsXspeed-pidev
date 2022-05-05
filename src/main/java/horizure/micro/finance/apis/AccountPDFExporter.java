package horizure.micro.finance.apis;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import horizure.micro.finance.entities.Account;

public class AccountPDFExporter {

	private List<Account> listAccounts;
    
    public AccountPDFExporter(List<Account> listAccounts) {
        this.listAccounts = listAccounts;
    }
 
    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.blue);
        cell.setPadding(7);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("Account number", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Type", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Capital", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Score", font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("Approved",font));
        table.addCell(cell);
        
        cell.setPhrase(new Phrase("State", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Date of Creation", font));
        table.addCell(cell);   
        
    }
     
    private void writeTableData(PdfPTable table) {
        for (Account account : listAccounts) {
            table.addCell(String.valueOf(account.getAccount_number()));
            table.addCell(String.valueOf(account.getType()));
            table.addCell(String.valueOf(String.format("%.2f", account.getCapital())+" DT"));
            table.addCell(String.valueOf(account.getScore()));
            table.addCell(String.valueOf(account.getIsApproved() == true?"Yes":"No"));
            table.addCell(String.valueOf(account.getState()));
            table.addCell(account.getCreated_at().toString());
            
        }
    }
     
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        
        document.open();
        
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(16);
        font.setColor(Color.GREEN);
         
        Paragraph p = new Paragraph("List of Accounts", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
         
        PdfPTable table = new PdfPTable(7);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {2.5f, 2.0f, 1.5f, 1.5f, 2.0f, 1.5f,2.0f});
        table.setSpacingBefore(10);
         
        writeTableHeader(table);
        writeTableData(table);
         
        document.add(table);
         
        document.close();
         
    }
}
