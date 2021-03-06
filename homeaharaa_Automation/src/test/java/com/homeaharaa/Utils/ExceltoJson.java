package com.homeaharaa.Utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;

public class ExceltoJson {
	static Workbook excelWorkBook;
	public static void main(String[] args) {
		// You can specify your excel file path.
		String excelFilePath = "./src/main/resources/SellingPRICEOFEACHPRODUCT Full.xlsx";
		// This method will read each sheet data from above excel file and create a JSON
		// and a text file to save the sheet data.
		creteJSONAndTextFileFromExcel(excelFilePath);
	}

	/*
	 * Read data from an excel file and output each sheet data to a json file and a
	 * text file. filePath : The excel file store path.
	 */
	private static void creteJSONAndTextFileFromExcel(String filePath) {
		try {
			/* First need to open the file. */
			FileInputStream fInputStream = new FileInputStream(filePath.trim());

			/* Create the workbook object to access excel file. */
			// Workbook excelWookBook = new XSSFWorkbook(fInputStream)
			/*
			 * Because this example use .xls excel file format, so it should use
			 * HSSFWorkbook class. For .xlsx format excel file use XSSFWorkbook class.
			 */;
			 excelWorkBook = new XSSFWorkbook(fInputStream);
			// Get all excel sheet count.
			int totalSheetNumber = excelWorkBook.getNumberOfSheets();
			// Loop in all excel sheet.
			for (int i = 0; i < totalSheetNumber; i++) {
				// Get current sheet.
				Sheet sheet = excelWorkBook.getSheetAt(i);
				// Get sheet name.
				String sheetName = sheet.getSheetName();
				if (sheetName != null && sheetName.length() > 0) {
					// Get current sheet data in a list table.
					List<List<String>> sheetDataTable = getSheetDataList(sheet);
					// Generate JSON format of above sheet data and write to a JSON file.
					String jsonString = getJSONStringFromList(sheetDataTable);
					String jsonFileName = sheet.getSheetName() + ".json";
					writeStringToFile(jsonString, jsonFileName);
					// Generate text table format of above sheet data and write to a text file.
					/*
					 * String textTableString = getTextTableStringFromList(sheetDataTable); String
					 * textTableFileName = sheet.getSheetName() + ".txt";
					 * writeStringToFile(textTableString, textTableFileName);
					 */
				}
			}
			// Close excel work book object.
			excelWorkBook.close();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

	/*
	 * Return sheet data in a two dimensional list. Each element in the outer list
	 * is represent a row, each element in the inner list represent a column. The
	 * first row is the column name row.
	 */
	private static List<List<String>> getSheetDataList(Sheet sheet) {
		List<List<String>> ret = new ArrayList<List<String>>();
		// Get the first and last sheet row number.
		int firstRowNum = sheet.getFirstRowNum();
		int lastRowNum = sheet.getLastRowNum();
		if (lastRowNum > 0) {
			// Loop in sheet rows.
			for (int i = firstRowNum; i < lastRowNum+1; i++) {
				// Get current row object.
				Row row = sheet.getRow(i);
				// Get first and last cell number.
				int firstCellNum = row.getFirstCellNum();
				int lastCellNum = row.getLastCellNum();
				// Create a String list to save column data in a row.
				List<String> rowDataList = new ArrayList<String>();
				// Loop in the row cells.
				for (int j = firstCellNum; j < lastCellNum; j++) {
					// Get current cell.
					Cell cell = row.getCell(j);
					// Get cell type.
					CellType cellType = cell.getCellType();
					switch (cellType) {
					case NUMERIC:
						double numberValue = cell.getNumericCellValue();
						// BigDecimal is used to avoid double value is counted use Scientific counting
						// method.
						// For example the original double variable value is 12345678, but jdk
						// translated the value to 1.2345678E7.
						String stringCellValue = BigDecimal.valueOf(numberValue).toPlainString();
						rowDataList.add(stringCellValue);
						System.out.println(stringCellValue);
						break;
					case STRING:
						String cellValue = cell.getStringCellValue();
						rowDataList.add(cellValue);
						System.out.println(cellValue);			
						break;
					case BOOLEAN:
						boolean numberValue1 = cell.getBooleanCellValue();
						String stringCellValue1 = String.valueOf(numberValue1);
						rowDataList.add(stringCellValue1);
						System.out.println(stringCellValue1);
						break;
					case FORMULA:
						FormulaEvaluator evaluator = excelWorkBook.getCreationHelper().createFormulaEvaluator(); 
						evaluator.evaluateFormulaCell(cell);
						double numberValue2 = cell.getNumericCellValue();
						String stringCellValue2 = BigDecimal.valueOf(numberValue2).toPlainString();
						rowDataList.add(stringCellValue2);
						System.out.println(stringCellValue2);
						break;
						
					case BLANK:
						System.out.println("Blank Data");
						break;
					default:
						System.out.println("Null Data");

					}
				}
				// Add current row data list in the return list.
				if(!rowDataList.isEmpty()) {
				ret.add(rowDataList);
				}
			}
		}
		return ret;
	}

	/* Return a JSON string from the string list. */
	@SuppressWarnings("unchecked")
	private static String getJSONStringFromList(List<List<String>> dataTable) {
		String ret = "";
		if (dataTable != null) {
			int rowCount = dataTable.size();
			if (rowCount > 1) {
				// Create a JSONObject to store table data.
				JSONObject tableJsonObject = new JSONObject();
				// The first row is the header row, store each column name.
				List<String> headerRow = dataTable.get(0);
				int columnCount = headerRow.size();
				// Loop in the row data list.
				for (int i = 1; i < rowCount; i++) {
					// Get current row data.
					List<String> dataRow = dataTable.get(i);
					// Create a JSONObject object to store row data.
					JSONObject rowJsonObject = new JSONObject();
					for (int j = 0; j < columnCount; j++) {
						String columnName = headerRow.get(j);
						String columnValue = dataRow.get(j);
						rowJsonObject.put(columnName, columnValue);
					}
					tableJsonObject.put("Row " + i, rowJsonObject);
				}
				// Return string format data of JSONObject object.
				ret = tableJsonObject.toString();
			}
		}
		return ret;
	}

	/* Return a text table string from the string list. */
	@SuppressWarnings("unused")
	private static String getTextTableStringFromList(List<List<String>> dataTable) {
		StringBuffer strBuf = new StringBuffer();
		if (dataTable != null) {
			// Get all row count.
			int rowCount = dataTable.size();
			// Loop in the all rows.
			for (int i = 0; i < rowCount; i++) {
				// Get each row.
				List<String> row = dataTable.get(i);
				// Get one row column count.
				int columnCount = row.size();
				// Loop in the row columns.
				for (int j = 0; j < columnCount; j++) {
					// Get column value.
					String column = row.get(j);
					// Append column value and a white space to separate value.
					strBuf.append(column);
					strBuf.append("    ");
				}
				// Add a return character at the end of the row.
				strBuf.append("\r\n");
			}
		}
		return strBuf.toString();
	}

	/* Write string data to a file. */
	private static void writeStringToFile(String data, String fileName) {
		try {
			// Get current executing class working directory.
			String currentWorkingFolder = System.getProperty("user.dir")
					+ "/src/main/resources/itempricedetailsjsonfiles";
			// Get file path separator.
			String filePathSeperator = System.getProperty("file.separator");
			// Get the output file absolute path.
			String filePath = currentWorkingFolder + filePathSeperator + fileName;
			// Create File, FileWriter and BufferedWriter object.
			File file = new File(filePath);
			FileWriter fw = new FileWriter(file);
			BufferedWriter buffWriter = new BufferedWriter(fw);
			// Write string data to the output file, flush and close the buffered writer
			// object.
			buffWriter.write(data);
			buffWriter.flush();
			buffWriter.close();
			System.out.println(filePath + " has been created.");
		} catch (IOException ex) {
			System.err.println(ex.getMessage());
		}
	}

}
