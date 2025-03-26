package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	private static final String FILE_PATH = "C:\\Users\\yoges\\OneDrive\\Desktop\\capstoneReg.xlsx";
	 public static String getData(int row,int col) throws IOException {
		 FileInputStream fis = new FileInputStream(FILE_PATH);
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		 XSSFSheet sheet = workBook.getSheetAt(0);
		 XSSFRow excelRow = sheet.getRow(row);
		// System.out.println(row);
		 XSSFCell cell = excelRow.getCell(col);
		// System.out.println(cell);
		 String data = cell.getStringCellValue();
		 return data;
	}

}

