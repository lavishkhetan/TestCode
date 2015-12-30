package testLogin;

import org.testng.annotations.Test;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadInputTest {
  
public static void main(String[] args) throws Exception{
File excel = new File("C:\\Users\\lkhetan\\Downloads\\DataFile.xlsx");
FileInputStream fis = new FileInputStream(excel);
XSSFWorkbook wb= new XSSFWorkbook(fis);
XSSFSheet ws = wb.getSheet("Input");

int rowNum = ws.getLastRowNum() +1;
int colNum = ws.getRow(0).getLastCellNum();
String[][] data = new String[rowNum][colNum];

for(int i=0; i<rowNum; i++)
{
XSSFRow row= ws.getRow(i);
	for(int j= 0; j<colNum; j++)
	{
		XSSFCell cell = row.getCell(j);
		String value = cell.toString();
		data[i][j] = value;
		System.out.println("the value is" + value);
		}
	}
}

public static String celltoString(XSSFCell cell){

int type;
Object result;
type = cell.getCellType();

switch(type){

case 0:
result = cell.getNumericCellValue();
break;
case 1:
result= cell.getStringCellValue();
break;
default:
throw new RuntimeException("there are no support for this type of cell");
}
return result.toString();
}
}