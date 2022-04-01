package com.appointmentbooking.appointmentbooking.service;




import com.appointmentbooking.appointmentbooking.model.Doctor;



import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;


@Service
public class DoctorService {

    private long id;
    private String firstName;
    private String lastName;
    private String speciality;
    private String area;
    private String phone;
    private String email;
    private String address;

    public List<Doctor> tempDoctorList;
    private final List<Doctor> resultList;


    public DoctorService() {
        tempDoctorList = new ArrayList<>();
        resultList = new ArrayList<>();

    }

    public void upload(MultipartFile file) {

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
            XSSFSheet worksheet = workbook.getSheetAt(0);
            Iterator iterator = worksheet.rowIterator();
            iterator.next();
            while (iterator.hasNext()) {
                Row row = (Row) iterator.next();
                Iterator cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell nextCell = (Cell) cellIterator.next();
                    int columnIndex = nextCell.getColumnIndex();

                    switch (columnIndex) {
                        case 0:
                            id = (long) nextCell.getNumericCellValue();
                            break;
                        case 1:
                            firstName = nextCell.getStringCellValue();
                            break;
                        case 2:
                            lastName = nextCell.getStringCellValue();
                            break;
                        case 3:
                            speciality = nextCell.getStringCellValue();
                            break;
                        case 4:
                            area = nextCell.getStringCellValue();
                            break;
                        case 5:
                            phone = nextCell.getStringCellValue();
                            break;
                        case 6:
                            email = nextCell.getStringCellValue();
                            break;
                        case 7:
                            address = nextCell.getStringCellValue();
                            break;
                        default:
                            break;
                    }
                }
                Doctor doctor = new Doctor(id, firstName, lastName, speciality, area, phone, email, address);
                tempDoctorList.add(doctor);


            }
            tempDoctorList.forEach(doctor1 -> System.out.println(doctor1));
            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public List<Doctor> getTempDoctorList() {
        System.out.println(tempDoctorList);
        return tempDoctorList;

    }

    public List<Doctor> retreiveDoctorbySpeciality(String speciality) {
        tempDoctorList.forEach(doctor -> {
            if (doctor.getSpeciality().equalsIgnoreCase(speciality)) {
                resultList.add(doctor);
            }
        });
        return resultList;
    }


    public void write() throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Doctor");
        String[] columnHeadings = {"id", "firstName", "lastName", "speciality", "area", "phone", "email", "address"};
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(headerFont);
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < columnHeadings.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columnHeadings[i]);
            cell.setCellStyle(headerStyle);
        }
        sheet.createFreezePane(0, 1);

        ArrayList<Doctor> doctor = createData();
        CreationHelper creationHelper = workbook.getCreationHelper();
        int rowNum = 1;
        for (Doctor d : doctor) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(d.getId());
            row.createCell(1).setCellValue(d.getFirstName());
            row.createCell(2).setCellValue(d.getLastName());
            row.createCell(3).setCellValue(d.getSpeciality());
            row.createCell(4).setCellValue(d.getArea());
            row.createCell(5).setCellValue(d.getPhone());
            row.createCell(6).setCellValue(d.getEmail());
            row.createCell(7).setCellValue(d.getAddress());
        }
        for (int i = 0; i < columnHeadings.length; i++) {
            sheet.autoSizeColumn(i);
        }
        XSSFSheet sh2 = workbook.createSheet("Second");
        FileOutputStream fileout = new FileOutputStream("C:\\Users\\admin\\Desktop\\doctor14.xlsx");
        workbook.write(fileout);


    }

    private static ArrayList<Doctor> createData() {
        ArrayList<Doctor> doctor = new ArrayList<Doctor>();
        doctor.add(new Doctor(1L, "Gaurav", "Sarodkar", "Gynaclogist", "madgi nagar", "9975032364", "sarodkargaurav@gmail.com", "qtr number 36/3 bajaj colony wcl saoner"));
        doctor.add(new Doctor(2L, "mithilesh", "Sarodkar", "Physician", "Narendra Nagar", "9923276432", "Mithileshsarodkar@gamil.com", "qtr number 36/3 bajaj colony wcl saoner"));
        doctor.add(new Doctor(3L, "Prachi", "Sarodkar", "Surgeon", "Chatrapati Nagar", "9503302364", "prachikanoje06.com", "qtr number 36/3 bajaj colony wcl saoner"));
        doctor.add(new Doctor(4L, "Mitali", "Nagpure", "Dentist", "Rameshwari", "7304296290", "mitunagpure@gmail.com", "qtr number 36/3 bajaj colony wcl saoner"));
        doctor.add(new Doctor(5L, "Ashika", "Nagpure", "neurosurgoun", "Rameshwari", "7304296290", "mitunagpure@gmail.com", "qtr number 36/3 bajaj colony wcl saoner"));
        doctor.add(new Doctor(6L, "Mangesh", "Nagpure", "neurosurgoun", "Rameshwari", "73042236290", "mitunagpure123@gmail.com", "qtr number 36/3 bajaj colony wcl saoner"));
        System.out.println(doctor);
        return doctor;

    }


    public void updatePhonenumber() throws IOException {
        FileInputStream fis = new FileInputStream(new File("C:\\Users\\admin\\Desktop\\doctor14.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Doctor");
        System.out.println(sheet.getRow(4).getCell(5).getStringCellValue());
        XSSFCell cell = sheet.getRow(4).getCell(5);
        cell.setCellType(CellType.STRING);
        cell.setCellValue("9888823452");
        // Write the output to the file
        System.out.println(cell);

        FileOutputStream fileOut = new FileOutputStream(new File("C:\\Users\\admin\\Desktop\\doctor14.xlsx"));
        workbook.write(fileOut);

        System.out.println("phone column in doctor.xlsx is updated successfully");
        fileOut.close();

        workbook.close();
    }

    public List<Doctor> searchDoctorByfirstname(String firstname) {
        tempDoctorList.forEach(doctor -> {
            if (doctor.getFirstName().equalsIgnoreCase(firstname)) {
                System.out.println("get the list");
                resultList.add(doctor);
            }
        });
        return resultList;
    }


    public List<Doctor> searchDoctorByLastname(String lastname) {
        tempDoctorList.forEach(doctor -> {
            if (doctor.getLastName().equalsIgnoreCase(lastname)) {
                System.out.println("get the list");
                resultList.add(doctor);
            }
        });
        return resultList;
    }

    public List<Doctor> searchDoctorByArea(String area) {
        tempDoctorList.forEach(doctor -> {
            if (doctor.getArea().equalsIgnoreCase(area)) {
                System.out.println("get the list");
                resultList.add(doctor);
            }
        });
        return resultList;
    }

}
