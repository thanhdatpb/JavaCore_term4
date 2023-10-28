package thi_21t1020124;

public class GiangVien extends NhanVien {
    private double allowance;

    public GiangVien(String employeeCode, String fullName, String contractType, double salaryCoefficient,double allowance) {
        super(employeeCode, fullName,contractType, salaryCoefficient);
        this.allowance = allowance;
    }

    // Getter và setter cho phụ cấp

    public double getphucap() {
		return allowance;
	}

	public void setphucap(double allowance) {
		this.allowance = allowance;
	}

	// Ghi đè phương thức toString để hiển thị thông tin của giảng viên
    @Override
    public String toString() {
        return super.toString() + ", Phụ cấp: " + allowance;
    }
}
