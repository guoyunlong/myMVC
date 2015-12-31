package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTest {
	public static void main(String args[]) throws IOException {

		String basePath = "D:\\phone\\41";
		String inFile = basePath + ".xlsx";
		String outFile = basePath + "_1.xlsx";
		
		FileInputStream fis = new FileInputStream(inFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		SXSSFWorkbook workbook = new SXSSFWorkbook(workbook);
//		fis.close();
//		List<XSSFPictureData> pictures = workbook.getAllPictures();
//		for (int i = 0; i < pictures.size(); i++) {
//			XSSFPictureData pictureData = pictures.get(i);
//			byte[] data = pictureData.getData();
//			String ext = pictureData.suggestFileExtension();// 获取扩展名
//
//			FileOutputStream out = new FileOutputStream(basePath + "img_" + i
//					+ "." + ext);
//			out.write(data);
//			out.close();
//		}/* 读EXCEL图片完毕 */

		/* 读EXCEL文字内容 */
		
		for(int j=0;j<workbook.getNumberOfSheets();j++){
			
			
			XSSFSheet sheet = workbook.getSheetAt(j);
//			Iterator<Row> rows = sheet.rowIterator();
			XSSFRow  row;
			XSSFCell cell;
			for(int i=0;i<20000000;i++){
				row = sheet.getRow(i);
				if(row == null){
					System.out.println("完成");
					break;
				}
				row.getCell(0).setCellType(XSSFCell.CELL_TYPE_STRING);
				
				cell = row.createCell(1);
				cell.setCellType(XSSFCell.CELL_TYPE_STRING);
				cell.setCellType(XSSFCell.CELL_TYPE_STRING);

				if("".equals(row.getCell(0).getStringCellValue())){
					continue;
				}
				
				System.out.println(i+"_"+row.getCell(0).getStringCellValue());
				String cellValue = row.getCell(0).getStringCellValue().substring(0, 3);

				System.out.println(i+"_"+cellValue);
				if("134".equals(cellValue)){
					cell.setCellValue("移动");
				}else if("135".equals(cellValue)){
					cell.setCellValue("移动");
					
				}else if("136".equals(cellValue)){
					cell.setCellValue("移动");
					
				}else if("137".equals(cellValue)){
					cell.setCellValue("移动");
					
				}else if("138".equals(cellValue)){
					cell.setCellValue("移动");
					
				}else if("139".equals(cellValue)){
					cell.setCellValue("移动");
					
				}else if("147".equals(cellValue)){
					cell.setCellValue("移动");
					
				}else if("150".equals(cellValue)){
					cell.setCellValue("移动");
					
				}else if("151".equals(cellValue)){
					cell.setCellValue("移动");
					
				}else if("152".equals(cellValue)){
					cell.setCellValue("移动");
					
				}else if("157".equals(cellValue)){
					cell.setCellValue("移动");
					
				}else if("158".equals(cellValue)){
					cell.setCellValue("移动");
					
				}else if("159".equals(cellValue)){
					cell.setCellValue("移动");
					
				}else if("182".equals(cellValue)){
					cell.setCellValue("移动");
					
				}else if("187".equals(cellValue)){
					cell.setCellValue("移动");
					
				}else if("188".equals(cellValue)){
					cell.setCellValue("移动");
					
				}else if("133".equals(cellValue)){//电信开始
					cell.setCellValue("电信");
					
				}else if("153".equals(cellValue)){
					cell.setCellValue("电信");
					
				}else if("180".equals(cellValue)){
					cell.setCellValue("电信");
					
				}else if("189".equals(cellValue)){
					cell.setCellValue("电信");

				}else if("130".equals(cellValue)){//联通开始
					cell.setCellValue("联通");
					
				}else if("131".equals(cellValue)){
					cell.setCellValue("联通");
					
				}else if("132".equals(cellValue)){
					cell.setCellValue("联通");
					
				}else if("155".equals(cellValue)){
					cell.setCellValue("联通");
					
				}else if("156".equals(cellValue)){
					cell.setCellValue("联通");
					
				}else if("185".equals(cellValue)){
					cell.setCellValue("联通");
					
				}else if("186".equals(cellValue)){
					cell.setCellValue("联通");
				}
				
			}
		}

		workbook.write(new FileOutputStream(new File(outFile))  );  
		
		
//		while (rows.hasNext()) {
//			row = rows.next();
//			Iterator<Cell> cells = row.cellIterator();
//			while (cells.hasNext()) {
//				cell = cells.next();
//				System.out.println("RowIndex:" + cell.getRowIndex());
//				System.out.println("ColumnIndex:" + cell.getColumnIndex());
//				System.out.println("值:" + cell.getStringCellValue());
//			}
//		}

	}
}
