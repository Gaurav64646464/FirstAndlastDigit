package com.appointmentbooking.appointmentbooking.service;

import com.appointmentbooking.appointmentbooking.model.Doctor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.print.Doc;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExportDataToExcel {
    private Workbook workbook;
    private Sheet sheet;

    private List<Doctor> doctors;
    private  List<Exception> exceptions=new ArrayList<>();


    public ExportDataToExcel(List<Doctor> doctors){
        this.doctors=doctors;
        workbook=new XSSFWorkbook();
    }
    public void createCell(Row row, int columncount,Object value){
        sheet.autoSizeColumn(columncount);
        Cell cell= row.createCell(columncount);
        if(value instanceof Long){
            cell.setCellValue((Long)value);
        }else if(value instanceof Integer){
            cell.setCellValue((Integer) value);
        }else if(value instanceof Boolean){
            cell.setCellValue((Double) value);
        }else {
            cell.setCellValue((String) value);
        }
    }

    private void writeHeaderLine(){
        sheet=workbook.createSheet("Doctor");
        Row row=sheet.createRow(0);
        createCell(row,0,"id");
        createCell(row,1,"firstName");
        createCell(row,2,"lastName");
        createCell(row,3,"speciality");
        createCell(row,4,"area");
        createCell(row,5,"phone");
        createCell(row,6,"email");
        createCell(row,7,"address");

    }
    private void writeDataLines(){
        int rowcount=1;
        for(Doctor doctor:doctors){
            Row row=sheet.createRow(rowcount++);
            int columncount=0;
            Long id=doctor.getId();
            String firstName=doctor.getFirstName();
            String lastName=doctor.getLastName();
            String speciality=doctor.getSpeciality();
            String area=doctor.getArea();
            String phone=doctor.getPhone();
            String email=doctor.getEmail();
            String address=doctor.getAddress();

            if(id<0 || !firstName.isBlank() || !lastName.isBlank() || !speciality.isBlank() || !area.isBlank() || !phone.isBlank() || !email.isBlank() || !address.isBlank()){
                createCell(row,columncount++,id);
                createCell(row,columncount++,firstName);
                createCell(row,columncount++,lastName );
                createCell(row,columncount++,speciality);
                createCell(row,columncount++,area);
                createCell(row,columncount++,phone);
                createCell(row,columncount++,email);
                createCell(row,columncount++,address);
            }else{
                this.exceptions.add(new Exception("wrong values"));
            }

        }
    }
    public void export(HttpServletResponse response) throws IOException{
        writeHeaderLine();
        writeDataLines();
        ServletOutputStream out = response.getOutputStream();
        workbook.write(out);
        workbook.close();
        out.close();
    }
}
