package service;

import quanLiFile.ReadWriteFile;
import view.View;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static input.Input.*;
import static object.BaiGiuXe.tinhSoNgay;

public class LichSuXeRaVaoBai {
    View view = new View();
    ReadWriteFile readWriteFile = new ReadWriteFile();
    public static List<String> lichSuRaVao = new ArrayList<String>();

    public void quanLiLichSu() {
        int choose = -1;

        while (true) {
            while (choose != 0) {
                view.showLichSuXeRaVaoBai();
                choose = nhapLuaChon();
                switch (choose) {
                    case 1:
                        int choose1 = -1;
                        showLichSu();
                        while (choose1 != 0) {
                            view.showReturnOrBackMenu();
                            choose1 = nhapLuaChon();
                            if (choose1 == 10) {
                                choose = 0;
                                choose1 = 0;
                            }
                        }
                        break;
                    case 2:
                        int choose2 = -1;
                        lichSuRaVaoCuaNgay();
                        while (choose2 != 0) {
                            view.showReturnOrBackMenu();
                            choose2 = nhapLuaChon();
                            if (choose2 == 10) {
                                choose = 0;
                                choose2 = 0;
                            }
                        }
                        break;
                    case 3:
                        int choose3 = -1;
                        lichSuRaVaoCuaThang();
                        while (choose3 != 0) {
                            view.showReturnOrBackMenu();
                            choose3 = nhapLuaChon();
                            if (choose3 == 10) {
                                choose = 0;
                                choose3 = 0;
                            }
                        }
                        break;
                    case 4:
                        int choose4 = -1;
                        lichSuRaKhoiBai();
                        while (choose4 != 0) {
                            view.showReturnOrBackMenu();
                            choose4 = nhapLuaChon();
                            if (choose4 == 10) {
                                choose = 0;
                                choose4 = 0;
                            }
                        }
                        break;
                    case 5:
                        int choose5 = -1;
                        lichSuVaoBai();
                        while (choose5 != 0) {
                            view.showReturnOrBackMenu();
                            choose5 = nhapLuaChon();
                            if (choose5 == 10) {
                                choose = 0;
                                choose5 = 0;
                            }
                        }
                        break;
                    default:
                        System.out.println("chọn lại");
                }
            }
            return;
        }
    }

    public void showLichSu() {
        System.out.println("\n ===== Lịch sử ra vào bãi giữ xe =====");
        System.out.printf("\t\t%-20s%-20s%-35s%-20s\n", "Biển số", "Hoạt động", "Thời gian", "Chủ xe");
        for (int i = lichSuRaVao.size()-1; i >=0 ; i--) {
            String[] strin = lichSuRaVao.get(i).split(",");
            System.out.printf("\t\t%-20s%-20s%-35s%-20s\n", strin[0], strin[1], strin[2], strin[3]);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime gioRaVaoBai = LocalDateTime.parse(strin[2],formatter);
            if ((tinhSoNgay(gioRaVaoBai, LocalDateTime.now())) > 90) {
                lichSuRaVao.remove(lichSuRaVao.get(i));
                readWriteFile.vietFileLichSu();
            }
        }
    }

    public static void addLichSu(String lichsu) {
        lichSuRaVao.add(lichsu);
    }

    public void lichSuRaVaoCuaNgay() {
        System.out.println("nhập ngày muốn kiểm tra lịch sử ra vào");
        String ngayThangKiemTra = nhapNgayThang();
        String ngayKiemTra = ngayThangKiemTra.substring(0, 2);
        String thangKiemTra = ngayThangKiemTra.substring(3, 5);
        System.out.println("\n ===== Lịch sử ra vào bãi giữ xe =====");
        for (String str : lichSuRaVao) {
            String[] value = str.split(",");
            String ngayDuocKiemTra = value[2].substring(8, 10);
            String thangDuocKiemTra = value[2].substring(5, 7);
            if (ngayKiemTra.equals(ngayDuocKiemTra) && thangKiemTra.equals(thangDuocKiemTra)) {
                System.out.printf("\t\t%-20s%-20s%-35s%-20s\n", value[0], value[1], value[2], value[3]);
            }
        }
    }

    public void lichSuRaVaoCuaThang() {
        System.out.println("nhập tháng muốn kiểm tra lịch sử ra vào");
        String thangKiemTra = nhapThang();
        System.out.println("\n ===== Lịch sử ra vào bãi giữ xe =====");
        for (String str : lichSuRaVao) {
            String[] value = str.split(",");
            String thangDuocKiemTra = value[2].substring(5, 7);
            if (thangKiemTra.equals(thangDuocKiemTra)) {
                System.out.printf("\t\t%-20s%-20s%-35s%-20s\n", value[0], value[1], value[2], value[3]);
            }
        }
    }

    public void lichSuRaKhoiBai() {
        System.out.println("nhập ngày tháng muốn kiểm tra lịch sử rời khỏi bãi");
        String ngayThangKiemTra = nhapNgayThang();
        String ngayKiemTra = ngayThangKiemTra.substring(0, 2);
        String thangKiemTra = ngayThangKiemTra.substring(3, 5);
        System.out.println("\n ===== Lịch sử rời bãi giữ xe =====");
        for (String str : lichSuRaVao) {
            String[] value = str.split(",");
            String ngayDuocKiemTra = value[2].substring(8, 10);
            String thangDuocKiemTra = value[2].substring(5, 7);
            if (ngayKiemTra.equals(ngayDuocKiemTra) && thangKiemTra.equals(thangDuocKiemTra) && value[1].equals("rời bãi")) {
                System.out.printf("\t\t%-20s%-20s%-35s%-20s\n", value[0], value[1], value[2], value[3]);
            }

        }
    }
    public void lichSuVaoBai(){
        System.out.println("nhập ngày tháng muốn kiểm tra lịch sử rời khỏi bãi");
        String ngayThangKiemTra = nhapNgayThang();
        String ngayKiemTra = ngayThangKiemTra.substring(0, 2);
        String thangKiemTra = ngayThangKiemTra.substring(3, 5);
        System.out.println("\n ===== Lịch sử rời bãi giữ xe =====");
        for (String str : lichSuRaVao) {
            String[] value = str.split(",");
            String ngayDuocKiemTra = value[2].substring(8, 10);
            String thangDuocKiemTra = value[2].substring(5, 7);
            if (ngayKiemTra.equals(ngayDuocKiemTra) && thangKiemTra.equals(thangDuocKiemTra) && value[1].equals("vào bãi")) {
                System.out.printf("\t\t%-20s%-20s%-35s%-20s\n", value[0], value[1], value[2], value[3]);
            }

        }
    }
}

