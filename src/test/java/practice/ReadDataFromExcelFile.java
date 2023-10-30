package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		//Step 1: Open the document in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step 2: Create workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step 3: navigate to required sheet 
	    Sheet sh = wb.getSheet("Contact");
		
		//Step 4: Navigate to required row
	    Row rw =  sh.getRow(0);
		
		//Step 5: Navigate to required cell
	    Cell cl = rw.getCell(0);
		
		//Step 6: Capture the value and print
	    String value = cl.getStringCellValue();
	    System.out.println(value);
	}

}
