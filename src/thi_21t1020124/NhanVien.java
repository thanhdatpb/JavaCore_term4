package thi_21t1020124;

public class NhanVien {
    private String employeeCode;
    private String fullName;
    private String contractType;
    private double salaryCoefficient;

    public NhanVien(String employeeCode, String fullName, String contractType, double salaryCoefficient) {
        this.employeeCode = employeeCode;
        this.fullName = fullName;
        this.contractType = contractType;
        this.salaryCoefficient = salaryCoefficient;
    }

    // Các getter và setter

    public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getContractType() {
		return contractType;
	}

	public void setContractType(String contractType) {
		this.contractType = contractType;
	}

	public double getSalaryCoefficient() {
		return salaryCoefficient;
	}

	public void setSalaryCoefficient(double salaryCoefficient) {
		this.salaryCoefficient = salaryCoefficient;
	}

	// Phương thức toString để hiển thị thông tin của nhân viên
    @Override
    public String toString() {
        return "Mã nhân viên: " + employeeCode + ", Họ và tên: " + fullName +
                ", Loại hợp đồng: " + contractType + ", Hệ số lương: " + salaryCoefficient;
    }
}
