package Utilities;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.format.CellDateFormatter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.*;
//org.apache.poi.xssf.usermodel.XSSFWorkbook.XSSFWorkbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	FileInputStream scriptFile = null;
	Workbook workbook = null;
	
	public Workbook getScriptWorkbook(File file)
	{
		if (file.getName().endsWith(".xls"))
		{
			try {
				scriptFile = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				workbook = new HSSFWorkbook(scriptFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(file.getName().endsWith(".xlsx"))
		{
			try {
				scriptFile = new FileInputStream(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				workbook = new XSSFWorkbook(scriptFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return workbook;
	}
	
	public String getCellValue(Cell cell)
	{
		String cellValue="";
		if (cell !=null)
		{
			int cellType = cell.getCellType() ;
			switch(cellType)
			{
				case Cell.CELL_TYPE_STRING:
					cellValue = cell.getStringCellValue();
					break;
				case Cell.CELL_TYPE_BLANK:
					cellValue = "";
					break;
				case Cell.CELL_TYPE_NUMERIC:
					if (HSSFDateUtil.isCellDateFormatted(cell))
					{
						Date dateValue = cell.getDateCellValue();
						String dateFormatter = cell.getCellStyle().getDataFormatString();
						cellValue = new CellDateFormatter(dateFormatter).format(dateValue);
					} else
					{
						cell.setCellType(HSSFCell.CELL_TYPE_STRING);
						cellValue = cell.getStringCellValue();
					}
					break;
				default:
					return cellValue;
			}
			
		}
		return cellValue;
	}

}

