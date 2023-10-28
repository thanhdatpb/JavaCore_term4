package thi_21t1020124;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import thi_21t1020124.NhanVien;
import thi_21t1020124.GiangVien;
public class QuanLy {
	    public static void saveToDatabase(ArrayList<NhanVien> employees, ArrayList<GiangVien> lecturers) {
	        try (Connection connection = DatabaseConnection.getConnection()) {
	            // Lưu danh sách nhân viên
	            for (NhanVien employee : employees) {
	                String query = "INSERT INTO NhanVien (employeeCode, fullName, contractType, salaryCoefficient) VALUES (?, ?, ?, ?)";
	                PreparedStatement statement = connection.prepareStatement(query);
	                statement.setString(1, employee.getEmployeeCode());
	                statement.setString(2, employee.getFullName());
	                statement.setString(3, employee.getContractType());
	                statement.setDouble(4, employee.getSalaryCoefficient());
	                statement.executeUpdate();
	            }

	            // Lưu danh sách giảng viên
	            for (GiangVien lecturer : lecturers) {
	                String query = "INSERT INTO GiangVien (employeeCode, fullName, contractType, salaryCoefficient, allowance) VALUES (?, ?, ?, ?, ?)";
	                PreparedStatement statement = connection.prepareStatement(query);
	                statement.setString(1, lecturer.getEmployeeCode());
	                statement.setString(2, lecturer.getFullName());
	                statement.setString(3, lecturer.getContractType());
	                statement.setDouble(4, lecturer.getSalaryCoefficient());
	                statement.setDouble(5, lecturer.getphucap());
	                statement.executeUpdate();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
    public static void main(String[] args) {
        ArrayList<NhanVien> employees = new ArrayList<>();
        ArrayList<GiangVien> lecturers = new ArrayList<>();

        // Đọc file ds.txt và lưu thông tin vào các ArrayList tương ứng
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\ds.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] info = line.split(",");
                if (info.length == 4) {  // Thông tin nhân viên
                    String employeeCode = info[0].trim();
                    String fullName = info[1].trim();
                    String contractType = info[2].trim();
                    double salaryCoefficient = Double.parseDouble(info[3].trim());
                    NhanVien employee = new NhanVien(employeeCode, fullName, contractType, salaryCoefficient);
                    employees.add(employee);
                } else if (info.length == 5) {  // Thông tin giảng viên
                    String employeeCode = info[0].trim();
                    String fullName = info[1].trim();
                    String contractType = info[2].trim();
                    double salaryCoefficient = Double.parseDouble(info[3].trim());
                    double allowance = Double.parseDouble(info[4].trim());
                    GiangVien lecturer = new GiangVien(employeeCode, fullName, contractType, salaryCoefficient,allowance);
                    lecturers.add(lecturer);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Hiển thị danh sách nhân viên và giảng viên
        System.out.println("Danh sách nhân viên:");
        for (NhanVien employee : employees) {
            System.out.println(employee);
        }

        System.out.println("\nDanh sách giảng viên:");
        for (GiangVien lecturer : lecturers) {
            System.out.println(lecturer);
        }
        saveToDatabase(employees,lecturers);
    }
}

