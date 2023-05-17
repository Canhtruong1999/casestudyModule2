package view;

import quanLiFile.ReadWriteFile;
import service.*;

import static input.Input.nhapLuaChon;

public class Main {
    public static void main(String[] args) {
        QuanLiHoatDong quanLiHoatDong=new QuanLiHoatDong();
        QuanLiXeTrongBai quanLiXeTrongBai=new QuanLiXeTrongBai();
        InVeXeVaHoaDon inVeXeVaHoaDon =new InVeXeVaHoaDon();
        ReadWriteFile readWriteFile=new ReadWriteFile();
        LichSuXeRaVaoBai lichSuXeRaVaoBai=new LichSuXeRaVaoBai();
        QuanLiDoanhThu quanLiDoanhThu=new QuanLiDoanhThu();
        View view=new View();
        readWriteFile.docFileDanhSachXe();
        readWriteFile.docFileLichSu();
        readWriteFile.docFileDoanhThuNgay();
        readWriteFile.docFileGia();
        int check = -1;
        while (true) {
            view.showMainMenu();
            check = nhapLuaChon();
            switch (check) {
                case 1:
                    quanLiHoatDong.quanLiHoatDong();
                    break;
                case 2:
                    quanLiXeTrongBai.quanLiXeTrongBai();
                    break;
                case 3:
                    inVeXeVaHoaDon.inVeXeVaHoaDon();
                    break;
                case 4:
                   lichSuXeRaVaoBai.quanLiLichSu();
                    break;
                case 5:
                    quanLiDoanhThu.quanLiDoanhThu();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("chọn lại");
            }
        }
    }
}

