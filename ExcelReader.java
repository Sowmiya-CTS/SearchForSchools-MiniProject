package MiniProject;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class ExcelReader {
    public static List<Map<String, String>> getTestData(String filePath, String sheetName) throws Exception {
        List<Map<String, String>> testData = new ArrayList<>();
        filePath="C:\\Users\\2393068\\OneDrive - Cognizant\\Documents";
        sheetName="SearchForSchhols.xlsx";
        try (FileInputStream file = new FileInputStream(new File(filePath));
             XSSFWorkbook workbook = new XSSFWorkbook(file)) {
            
            XSSFSheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new Exception("Sheet not found: " + sheetName);
            }
            
            int rowCount = sheet.getLastRowNum();
            if (rowCount < 1) {
                throw new Exception("No data in sheet");
            }
            
            XSSFRow headerRow = sheet.getRow(0);
            int colCount = headerRow.getLastCellNum();
            
            for (int i = 1; i <= rowCount; i++) {
                XSSFRow currentRow = sheet.getRow(i);
                if (currentRow == null) continue;
                
                Map<String, String> rowData = new HashMap<>();
                for (int j = 0; j < colCount; j++) {
                    String key = headerRow.getCell(j).getStringCellValue();
                    String value = currentRow.getCell(j) != null ? 
                                    currentRow.getCell(j).getStringCellValue() : "";
                    rowData.put(key, value);
                }
                testData.add(rowData);
            }
        } catch (Exception e) {
            throw new Exception("Error reading excel file: " + e.getMessage());
        }
        
        return testData;
    }
}
