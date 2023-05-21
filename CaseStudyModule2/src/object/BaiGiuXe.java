package object;

import quanLiFile.ReadWriteFile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

import static input.Input.*;
import static service.LichSuXeRaVaoBai.addLichSu;
import static service.QuanLiDoanhThu.doanhThuNgay;

public class BaiGiuXe {
    ReadWriteFile readWriteFile =new ReadWriteFile();
    public static int soLuongBaiDoXe = 20;
    public static ArrayList<Xe> danhSachXe = new ArrayList<Xe>();
    public static int giaTienGiuXe;
    public static boolean[] cacBaiDoXe = new boolean[soLuongBaiDoXe];

    public int getSoLuongBaiDoXe() {
        return soLuongBaiDoXe;
    }

    public int getGiaTienGiuXe() {
        return giaTienGiuXe;
    }

    public static void setGiaTienGiuXe(int giaTienGiuXe) {
        BaiGiuXe.giaTienGiuXe = giaTienGiuXe;
    }

    public void setSoLuongBaiDoXe(int soLuongBaiDoXe) {
        BaiGiuXe.soLuongBaiDoXe = soLuongBaiDoXe;
    }

    public BaiGiuXe() {
    }

    public void showXeTrongBai() {
        if (danhSachXe.size() == 0) {
            System.out.println("Bãi đỗ xe trống.");
        } else {
            System.out.println("Danh sách xe đang đỗ:");
            System.out.println("     Bãi số         Id xe          Biển số        Hãng xe         Thời gian vào bãi    ");
            for (int i = 0; i < cacBaiDoXe.length; i++) {
                if (cacBaiDoXe[i]) {
                    for (Xe x : danhSachXe) {
                        if (x.getBaiDoXe() == i + 1) {
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
                            String dateString = x.getGioVaoBai().format(formatter);
                            System.out.printf("       %-13s%-15s%-15s%-15s%-15s\n", x.getBaiDoXe(), x.getId(), x.getBienSo(), x.getLoaiXe(), dateString);
                        }
                    }
                } else {
                    System.out.printf("       %-13s:trống\n", (i + 1));
                }
            }
        }
    }

    public void themXe() {
        if (danhSachXe.size() == soLuongBaiDoXe) {
            System.out.println("bãi xe đầy");
        } else {
            String bienSo = nhapBienSoOTo();
            System.out.println("nhập loại xe");
            String loaiXe = nhapChuoi();
            System.out.println("nhập tên chủ xe");
            String chuXe = nhapChuoi();
            System.out.print("các bãi đỗ còn trống là :");
            for (int i = 0; i < cacBaiDoXe.length; i++) {
                if (!cacBaiDoXe[i]) {
                    System.out.print(i + 1 + ",");
                }
            }
            System.out.println("chọn bãi đỗ");
            int baiDo =chonBaiDangTrong();
            cacBaiDoXe[baiDo - 1] = true;
            danhSachXe.add(new Xe(bienSo, loaiXe, chuXe, baiDo));
            readWriteFile.vietFileDanhSachXe();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
            String dateString = LocalDateTime.now().format(formatter);
            String lichSu = bienSo + ",vào bãi," + dateString + "," + chuXe;
            addLichSu(lichSu);
            readWriteFile.vietFileLichSu();
            System.out.println("Thêm xe thành công.");
            inPhieuXeTheoBienSo(bienSo);
        }
    }

    public void layXeTheoBienSo() {
        String bienSo = nhapBienSoOTo();
        for (Xe xe : danhSachXe) {
            if (Objects.equals(bienSo, xe.getBienSo())) {
                inHoaDontheoBienSo(xe.getBienSo());
                danhSachXe.remove(xe);
                readWriteFile.vietFileDanhSachXe();
                cacBaiDoXe[xe.getBaiDoXe() - 1] = false;
                System.out.println("lấy xe thành công");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
                String dateString = LocalDateTime.now().format(formatter);
                String lichSu = xe.getBienSo() + ",rời bãi," + dateString + "," + xe.getChuXe();
                addLichSu(lichSu);
                readWriteFile.vietFileLichSu();
                String doanhthu = LocalDateTime.now() + "," + (tinhSoNgay(xe.getGioVaoBai(), LocalDateTime.now())) * giaTienGiuXe;
                doanhThuNgay.add(doanhthu);
                readWriteFile.vietFileDoanhThuNgay();
                return;
            }
        }
        System.out.println("không tìm thấy xe");
    }

    public void layXeTheoID() {
        System.out.println("nhập ID của xe :");
        int id = nhapSo();
        for (Xe xe : danhSachXe) {
            if (Objects.equals(id, xe.getId())) {
                inHoaDontheoBienSo(xe.getBienSo());
                danhSachXe.remove(xe);
                readWriteFile.vietFileDanhSachXe();
                cacBaiDoXe[xe.getBaiDoXe() - 1] = false;
                System.out.println("lấy xe thành công");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
                String dateString = LocalDateTime.now().format(formatter);
                String lichSu = xe.getBienSo() + ",rời bãi," + dateString + "," + xe.getChuXe();
                addLichSu(lichSu);
                readWriteFile.vietFileLichSu();
                String doanhthu = LocalDateTime.now() + "," + (tinhSoNgay(xe.getGioVaoBai(), LocalDateTime.now())) * giaTienGiuXe;
                doanhThuNgay.add(doanhthu);
                readWriteFile.vietFileDoanhThuNgay();
                return;
            }
        }
        System.out.println("không tìm thấy xe");
    }
    public void timXeDoOBaiNao() {
        System.out.println("nhập biển số xe cần tìm");
        String bienSo = nhapBienSoOTo();
        for (Xe xe : danhSachXe) {
            if (Objects.equals(xe.getBienSo(), bienSo)) {
                System.out.println("xe đang đỗ ở bãi số: " + xe.getBaiDoXe());
                return;
            }
        }
        System.out.println("không tìm thấy xe trong bãi");
    }
    public void baiSoMayDoXeNao() {
        System.out.println("nhập bãi đỗ mà bạn muốn tìm (1-20)");
        int baiDoXe = nhapSo();
        for (Xe xe : danhSachXe) {
            if (xe.getBaiDoXe() == baiDoXe) {
                System.out.println("Bãi đang có xe đỗ lại");
                System.out.println("Id: " + xe.getId() + "\n Biển số: " + xe.getBienSo() + "\n Chủ xe: " + xe.getChuXe() + "\n Loại xe: " + xe.getLoaiXe() + "\n thời gian vào bãi: " + xe.getGioVaoBai());
                return;
            }
        }
        System.out.println("Bãi đang trống");
    }
    public  void soLuongBaiDoConTrong() {
        System.out.println("Có " + (getSoLuongBaiDoXe() - danhSachXe.size()) + " bãi đỗ xe còn trống");
        System.out.print("các bãi đỗ còn trống là :");
        for (int i = 0; i < cacBaiDoXe.length; i++) {
            if (!cacBaiDoXe[i]) {
                System.out.print(i + 1 + ",");
            }
        }
        System.out.println();
    }
    public  void soLuongXeDangGiuTaiBai() {
        System.out.println("Có " + danhSachXe.size() + " xe đang ỗ tại bãi");
    }
    public void inPhieuXeTheoBienSo(String bienSo) {
        for (Xe xe : danhSachXe) {
            if (Objects.equals(xe.getBienSo(), bienSo)) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
                String dateString = xe.getGioVaoBai().format(formatter);
                System.out.println("\n=============== Phiếu xe của quý khách ===============");
                System.out.printf("=      Bãi số: %-38s=\n", xe.getBaiDoXe());
                System.out.printf("=      Id: %-42s=\n", xe.getId());
                System.out.printf("=      BIển số: %-37s=\n", xe.getBienSo());
                System.out.printf("=      Chủ xe: %-38s=\n", xe.getChuXe());
                System.out.printf("=      thời gian vào: %-31s=\n", dateString);
                System.out.printf("=      số điện thoại liên hệ : %-22d=\n", 123456789);
                System.out.println("=      giá tiền:" +giaTienGiuXe+"/ngày                            =");
                System.out.println("=                  Cảm ơn quý khách!                 =");
                System.out.println("======================================================");
                return;
            }
        }
        System.out.println("không tìm thấy biển số này");
    }
    public  void inPhieuXe() {
        System.out.println("nhập biển số xe cần in phiếu xe:");
        String bienSo =nhapBienSoOTo();
        inPhieuXeTheoBienSo(bienSo);
    }
    public  void inHoaDontheoBienSo(String bienSo) {
        for (Xe xe : danhSachXe) {
            if (Objects.equals(xe.getBienSo(), bienSo)) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
                String dateString = xe.getGioVaoBai().format(formatter);
                String ngayRa=LocalDateTime.now().format(formatter);
                System.out.println("================================================================");
                System.out.println("=                        BÃI GIỮ XE LCT                        =");
                System.out.println("=                        HOÁ ĐƠN GIỮ XE                        =");
                System.out.printf("=      Chủ xe: %-48s=\n", xe.getChuXe());
                System.out.printf("=      Biển số: %-47s=\n", xe.getBienSo());
                System.out.printf("=      Thời gian vào bãi: %-37s=\n", dateString);
                System.out.printf("=      Thời gian ra bãi: %-38s=\n", ngayRa);
                System.out.printf("=      Số ngày giữ xe tại bãi: %-32s=\n", tinhSoNgay(xe.getGioVaoBai(), LocalDateTime.now()));
                System.out.printf("=      Thành tiền: %-7sđ                                    =\n", (tinhSoNgay(xe.getGioVaoBai(), LocalDateTime.now())) * giaTienGiuXe);
                System.out.println("=      Người trông xe: Lê Cảnh Trường                          =");
                System.out.println("=                        Cảm Ơn Quý Khách!                     =");
                System.out.println("================================================================");
            }
        }
    }
    public static int tinhSoNgay(LocalDateTime gioVao, LocalDateTime giora) {
        int ngay = 0;
        if (giora.getYear() > gioVao.getYear()) {
            ngay = (365 - gioVao.getDayOfYear()) + giora.getDayOfYear();
        } else {
            ngay = giora.getDayOfYear() - gioVao.getDayOfYear();
        }
        return ngay+1;
    }
    public void inHoaDon() {
        String bienSo = nhapBienSoOTo();
        inHoaDontheoBienSo(bienSo);
    }
    public  void doanhThuCuaNgay() {
        int sum = 0;
        System.out.println("nhập ngày muốn kiểm tra doanh thu ( theo định dạng dd-mm)");
        String ngayThangKiemTra = nhapNgayThang();
        String ngayKiemTra = ngayThangKiemTra.substring(0, 2);
        String thangKiemTra = ngayThangKiemTra.substring(3, 5);
        System.out.println(" ===== Lịch sử giao dịch =====");
        for (String str : doanhThuNgay) {
            String thangDuocKiemTra = str.substring(5, 7);
            String ngayDuocKiemTra = str.substring(8, 10);
            if (ngayKiemTra.equals(ngayDuocKiemTra) && thangKiemTra.equals(thangDuocKiemTra)) {
                String[] ngayVaTien = str.split(",");
                LocalDateTime ngay= LocalDateTime.parse(ngayVaTien[0]);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
                String dateString = ngay.format(formatter);
                System.out.printf("%-25s%s\n",dateString,ngayVaTien[1]);
                sum += Integer.parseInt(ngayVaTien[1]);
            }
        }
        System.out.println("=============================================");
        System.out.print("Tổng doanh thu của ngày " + ngayThangKiemTra + " là:");
        System.out.println(sum);
    }

    public  void doanhThuCuaThang() {
        int sum = 0;
        System.out.println("nhập tháng muốn kiểm tra doanh thu (theo định dạng mm)");
        String thangKiemTra = nhapThang();
        System.out.println(" ===== Lịch sử giao dịch =====");
        for (String str : doanhThuNgay) {
            String thangDuocKiemTra = str.substring(5, 7);
            if (thangKiemTra.equals(thangDuocKiemTra)) {
                String[] ngayVaTien = str.split(",");
                LocalDateTime ngay= LocalDateTime.parse(ngayVaTien[0]);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
                String dateString = ngay.format(formatter);
                System.out.printf("%-25s%s\n",dateString,ngayVaTien[1]);
                sum += Integer.parseInt(ngayVaTien[1]);
            }
        }
        System.out.println("=============================================");
        System.out.print("Tổng doanh thu của ngày " + thangKiemTra + " là:");
        System.out.println(sum);
    }
    public void doiGia(){
        System.out.println("giá hiện tại là"+giaTienGiuXe+"/ngày");
        System.out.println("nhập giá đỗ xe mới: ");
        int giaMoi=nhapSo();
        setGiaTienGiuXe(giaMoi);
        System.out.println("đổi giá thành công");
        readWriteFile.vietFileGia();
    }

}
