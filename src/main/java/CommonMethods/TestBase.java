package CommonMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestBase 
{

	public HashMap<String,String> ReadExcel()
	{
		 
		 HashMap<String,String> data=new HashMap<String,String>();
		 String folderName=System.getProperty("user.dir");
		 
		File fileName =new File(folderName+"\\DataFiles\\Testcases.xlsx");
System.out.println(fileName);
		try {
			
			FileInputStream fis =new FileInputStream(fileName);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sheet=wb.getSheetAt(0);
			int RowCount=sheet.getLastRowNum();
			int ColumnCount=sheet.getRow(0).getLastCellNum();
		
			System.out.println("inside excel methd" + RowCount + ColumnCount);
			
			for(int i=1;i<=RowCount;i++)
				
			{		
			data.put(CheckDataTypeOfExcelSheet(sheet.getRow(i).getCell(1)),CheckDataTypeOfExcelSheet(sheet.getRow(i).getCell(3)));
			
			}
			wb.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage() + " File path is missing or incorrect " );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage() +"Workbook path or workbook not able to find" );
		}
		
		return data;
	}
	
	public String CheckDataTypeOfExcelSheet(XSSFCell cell)
	{
		String CellValue=null;
		if(cell!=null)
		{
		switch (cell.getCellTypeEnum()) 
		{
	    case STRING:
	        CellValue=cell.getStringCellValue();
	        break;
		case NUMERIC:  
			Double DoubleValue=cell.getNumericCellValue();
			 CellValue=DoubleValue.toString();
			 break;  
	    case BLANK:
	    	CellValue="";
	    	break;     
	    case BOOLEAN:
	    	Boolean BooleanValue=cell.getBooleanCellValue();
	    	CellValue=BooleanValue.toString();
	    	break;
	    default:
	        System.out.println("You have choosed wrong option");
	     }
		}
		return CellValue;
		
	
	}
	
	
}
