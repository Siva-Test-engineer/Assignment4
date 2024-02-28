package Assignment4.Testcomponent;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class datadrivenn {

	public ArrayList<String> getdata(String testcases) throws IOException {
		ArrayList<String> a = new ArrayList<String>();
		FileInputStream fi = new FileInputStream("C:\\Users\\USER\\Downloads\\data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fi);
		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("data")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				Row first_row = rows.next();
				Iterator<Cell> ce = first_row.cellIterator();
				int k = 0;
				int column = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();
					if (value.getStringCellValue().equalsIgnoreCase("testcases")) {
						column = k;
					}
					k++;
				}
				while (rows.hasNext()) {
					Row r = rows.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testcases)) {
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {
							a.add(cv.next().getStringCellValue());
						}
					}
				}
			}

		}
		System.out.println(a);
		return a;
	}
}