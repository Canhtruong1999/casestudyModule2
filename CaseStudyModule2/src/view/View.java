package view;

public class View {
    public  void showMainMenu() {
        System.out.println("\n===== Quản lý bãi giữ xe =====");
        System.out.println("1. Quản lí hoạt động của bãi giữ xe");
        System.out.println("2. Quản lí xe trong bãi");
        System.out.println("3. In phiếu xe và hoá đơn");
        System.out.println("4. Quản lí lịch sử xe ra vào sữ dụng bãi");
        System.out.println("5. Quản lí doanh thu");
        System.out.println("6. Quản lí tài khoản đăng nhập");
        System.out.println("7. Đăng xuất");
        System.out.println("0. Để thoát chương trình");
    }
    public void showMainMenuOfStaff(){
        System.out.println("\n===== Quản lý bãi giữ xe =====");
        System.out.println("1. Quản lí hoạt động của bãi giữ xe");
        System.out.println("2. Quản lí xe trong bãi");
        System.out.println("3. In phiếu xe và hoá đơn");
        System.out.println("4. Dăng xuất");
        System.out.println("0. Để thoát chương trình");
    }
    public  void showReturnOrBackMenu() {
        System.out.println("nhấn 0 để quay lại");
        System.out.println("nhấn 10 để về menu");
    }
    public  void showQuanLiHoatDong() {
        System.out.println("\n===== Quản lí hoạt động bãi giữ xe =====");
        System.out.println("1. Hiển thị danh sách các xe trong bãi đỗ");
        System.out.println("2. Thêm xe vào bãi");
        System.out.println("3. lấy xe ra khỏi bãi bằng biển số xe");
        System.out.println("4. lấy xe ra khỏi bãi bằng ID của xe");
        System.out.println("0. Để quay lại Menu");
    }
    public  void showQuanLiXeTrongBai(){
        System.out.println("\n===== Quản lí xe và các bãi đỗ =====");
        System.out.println("1. tìm xe đỗ ở bãi nào");
        System.out.println("2. bãi đổ số mấy chứa xe nào");
        System.out.println("3. số lượng bãi đổ còn trống");
        System.out.println("4. số lượng xe đang giữ tại bãi");
        System.out.println("0. Để quay lại Menu");
    }
    public  void ShowInPhieuXeVaHoaDon(){
        System.out.println("\n===== In phiếu xe và hoá đơn =====");
        System.out.println("1. In phiếu xe");
        System.out.println("2. In hoá đơn");
        System.out.println("0. Để quay lại Menu");
    }
    public  void showQuanLiDoanhThu(){
        System.out.println("\n===== Quản lí doanh thu =====");
        System.out.println("1. Tính tổng doanh thu theo ngày");
        System.out.println("2. Tính tổng doanh thu theo tháng");
        System.out.println("3. thay đổi giá giữ xe");
        System.out.println("0. Để quay lại Menu");
    }
    public void showLichSuXeRaVaoBai(){
        System.out.println("\n===== Quản lí lịch sử xe ra vào bãi =====");
        System.out.println("1. Lịch sử xe ra vào trong 3 tháng gần nhất");
        System.out.println("2. Lịch sử xe ra vào trong ngày");
        System.out.println("3. Lịch sử xe ra vào trong tháng");
        System.out.println("4. Lịch sử xe rời bãi trong ngày");
        System.out.println("5. Lịch sử xe vào bãi trong ngày");
        System.out.println("0. Để quay lại Menu");
    }
    public void showQuanLiTaiKhoan(){
        System.out.println("\n===== Quản lí tài khoản =====");
        System.out.println("1. Danh sách tài khoản");
        System.out.println("2. tạo tài khoản");
        System.out.println("3. Xoá tài khoản");
        System.out.println("0. Để quay lại");
    }
}
