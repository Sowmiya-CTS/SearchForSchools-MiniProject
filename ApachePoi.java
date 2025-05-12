package MiniProject;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import java.io.*;
public class ApachePoi {
	
	public static void main(String... args)throws Exception {
		try {
		FileInputStream file=new FileInputStream(new File("abc.xlsx"));
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("files");
		XSSFRow row=sheet.getRow(0);
		int col=row.getLastCellNum();
		
		for(int i=0;i<col;i++) {
			XSSFRow curr=sheet.getRow(i);
			
			
		}
		
		
		
		
		}catch(Exception e) {
			throw new Exception("error");
		}
	}
}
