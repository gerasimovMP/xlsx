package org.example.xlsxapi.service;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.xlsxapi.exception.ArgumentNumberException;
import org.example.xlsxapi.util.SelectionAlgorithm;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class XlsxService {

    public int findMin(String filePath, int n) throws Exception {
        List<Integer> numbers = extractNumbersFromXlsx(filePath);
        if (numbers.size() < n) {
            throw new ArgumentNumberException("N > numbers");
        }
        return SelectionAlgorithm.select(numbers, 0, numbers.size() - 1, n - 1);
    }

    private List<Integer> extractNumbersFromXlsx(String filePath) throws IOException {
        List<Integer> numbers = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.iterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if (cell.getCellType() == CellType.NUMERIC) {
                        numbers.add((int) cell.getNumericCellValue());
                    }
                }
            }
        }

        return numbers;
    }
}