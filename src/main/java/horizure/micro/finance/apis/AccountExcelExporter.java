package horizure.micro.finance.apis;

import horizure.micro.finance.entities.Account;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AccountExcelExporter {

	private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Account> listAccounts;
     
    public  AccountExcelExporter(List<Account> listAccounts) {
        this.listAccounts = listAccounts;
        workbook = new XSSFWorkbook();
    }
 
 
    private void writeHeaderLine() {
        sheet = workbook.createSheet("Accounts");
         
        Row row = sheet.createRow(0);
         
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
         
        createCell(row, 0, "Username", style);      
        createCell(row, 1, "Email", style);
        createCell(row, 2, "Role", style);       
        createCell(row, 3, "Phone", style);    
        createCell(row, 4, "Level", style);
        createCell(row, 5, "Account Number", style);    
        createCell(row, 6, "Type", style);
        createCell(row, 7, "State", style);
        createCell(row, 8, "Capital", style);    
        createCell(row, 9, "Score", style);
        createCell(row, 10, "Date of creation", style);
        createCell(row, 11, "Approved", style);
         
    }
     
    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else if (value instanceof Long) {
            cell.setCellValue((Long) value);
        }else if (value instanceof Date) {
            cell.setCellValue((Date) value);
        }else if (value instanceof Double) {
            cell.setCellValue((Double) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
     
    private void writeDataLines() {
        int rowCount = 1;
 
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
                 
        for (Account account : listAccounts) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
             
            createCell(row, columnCount++, account.getUser().getUserName(), style);
            createCell(row, columnCount++, account.getUser().getEmail(), style);
            createCell(row, columnCount++, account.getUser().getRole(), style);
            createCell(row, columnCount++, account.getUser().getPhone(), style);
            //createCell(row, columnCount++, account.getUser().getStatus().name(), style);
            createCell(row, columnCount++, account.getUser().getLevel().name(), style);
            createCell(row, columnCount++, account.getAccount_number(), style);
            createCell(row, columnCount++, account.getType().name(), style);
            createCell(row, columnCount++, account.getState().name(), style);
            createCell(row, columnCount++, account.getCapital(), style);
            createCell(row, columnCount++, account.getScore(), style);
            createCell(row, columnCount++, account.getCreated_at().toString(), style);
            createCell(row, columnCount++, account.getIsApproved(), style);
             
        }
    }
     
    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();
         
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
         
        outputStream.close();
         
    }
}
