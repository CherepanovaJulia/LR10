package Sample;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ReadExcel {
    public static void main(String[] args) throws IOException {
        // открываем файл для чтения
        String filePath = "FileExcel.xlsx";
        FileInputStream inputStream = new FileInputStream(filePath);

        // Создаем экземпляр книги Excel из файла

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        // Получаем лист из книги по его имени
        XSSFSheet sheet = workbook.getSheet("Товары");

        //Перебираем строки и ячейки листа
        for (Row row: sheet) {
            for(Cell cell : row) {
                // Выводим значение ячейки на экран
                System.out.println(cell.toString() + "\t");
            }
            System.out.println();
        }
        // закрываем файл и освобождаем ресурсы
        workbook.close();
        inputStream.close();

    }
}

