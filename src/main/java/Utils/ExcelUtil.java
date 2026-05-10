package Utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

    public static Object[][] getTestData(
            String filePath,
            String sheetName) {

        Object[][] data = null;

        try {

            System.out.println("=================================");
            System.out.println("Reading Excel File...");
            System.out.println("File Path: " + filePath);
            System.out.println("Sheet Name: " + sheetName);
            System.out.println("=================================");

            FileInputStream fis =
                    new FileInputStream(filePath);

            Workbook workbook =
                    new XSSFWorkbook(fis);

            Sheet sheet =
                    workbook.getSheet(sheetName);

            if (sheet == null) {

                System.out.println("ERROR: Sheet not found!");

                workbook.close();
                fis.close();

                return null;
            }

            int rowCount =
                    sheet.getPhysicalNumberOfRows();

            System.out.println("Total Rows: " + rowCount);

            int colCount =
                    sheet.getRow(0)
                            .getPhysicalNumberOfCells();

            System.out.println("Total Columns: " + colCount);

            data =
                    new Object[rowCount - 1][colCount];

            DataFormatter formatter =
                    new DataFormatter();

            for (int i = 1; i < rowCount; i++) {

                Row row = sheet.getRow(i);

                System.out.println("---------------------------------");
                System.out.println("Reading Row: " + i);

                for (int j = 0; j < colCount; j++) {

                    Cell cell =
                            row.getCell(j);

                    String cellValue =
                            formatter.formatCellValue(cell);

                    data[i - 1][j] =
                            cellValue;

                    System.out.println(
                            "Column " + j +
                            " Value: " + cellValue);
                }
            }

            System.out.println("=================================");
            System.out.println("Excel Data Read Successfully");
            System.out.println("=================================");

            workbook.close();
            fis.close();

        } catch (IOException e) {

            System.out.println("ERROR while reading Excel file");

            e.printStackTrace();
        }

        return data;
    }
}