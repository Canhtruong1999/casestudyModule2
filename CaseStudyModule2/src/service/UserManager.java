package service;

import object.User;
import view.View;

import java.util.ArrayList;
import java.util.List;

import static input.Input.*;
import static quanLiFile.ReadWriteFile.vietFileTaikhoan;

public class UserManager {
    public static List<User> userList =new ArrayList<>();
    public static void viewDanhSachTaiKhoan(){
        System.out.println("\n ===== Danh sách tài khoản =====");
        System.out.printf("%-20s%-20s%-20s%-20s\n","Tên người dùng", "UserName","PassWord","chức vụ");
        for (User u:userList) {
            System.out.printf("%-20s%-20s%-20s%-20s\n",u.getFullName(),u.getUserName(),u.getPassWord(),(u.getType()==1?"quản lí":"nhân viên"));
        }
    }

    public static void creatAccount(){
        System.out.println("nhập tên người sử dùng");
        String fullName =nhapChuoi();
        System.out.println("nhập tên tài khoản");
        String userName =nhapChuoi();
        System.out.println("nhập mật khẩu");
        String password=nhapChuoi();
        System.out.println("chọn loại quyền hạn của tài khoản ");
        System.out.println("1. tài khoản của quản lí\n 2. tài khoản của nhân viên");
        int type =nhapSo();
        userList.add(new User().setFullName(fullName).
                                setUserName(userName).
                                setPassWord(password).
                                setType(type));
        vietFileTaikhoan();
    }
    public static void deleteAccount() {
        System.out.println(" nhập tài khoản muốn xoá");
        String username =nhapChuoi();
        for (int i = 0; i < userList.size(); i++) {
            if(username.equals(userList.get(i).getUserName())){
                userList.remove(userList.get(i));
                System.out.println("xoá thành công");
            }
        }
        vietFileTaikhoan();
    }
    public static void LogIn(){
        System.out.println("===============================================");
        System.out.println("Đăng nhập");
        int dangNhap=DangNhap();
        if(dangNhap==1){
            System.out.println("\n===== Bãi Đỗ Xe 20 Chỗ LCT =====");
            managerService();
        }else if(dangNhap==2){
            System.out.println("\n===== Bãi Đỗ Xe 20 Chỗ LCT =====");

            staffService();
        }
    }
    public static void managerService(){
        QuanLiHoatDong quanLiHoatDong=new QuanLiHoatDong();
        QuanLiXeTrongBai quanLiXeTrongBai=new QuanLiXeTrongBai();
        InVeXeVaHoaDon inVeXeVaHoaDon =new InVeXeVaHoaDon();
        LichSuXeRaVaoBai lichSuXeRaVaoBai=new LichSuXeRaVaoBai();
        QuanLiDoanhThu quanLiDoanhThu=new QuanLiDoanhThu();
        View view=new View();
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
                case 6:
                    quanLiTaiKhoan();
                    break;
                case 7:
                    LogIn();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("chọn lại");
            }
        }
    }
    public static void staffService(){
        QuanLiHoatDong quanLiHoatDong=new QuanLiHoatDong();
        QuanLiXeTrongBai quanLiXeTrongBai=new QuanLiXeTrongBai();
        InVeXeVaHoaDon inVeXeVaHoaDon =new InVeXeVaHoaDon();
        View view=new View();
        int check = -1;
        while (true) {
            view.showMainMenuOfStaff();
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
                    LogIn();
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("chọn lại");
            }
        }
    }
    public static void quanLiTaiKhoan(){
        View view =new View();
            int choose = -1;

            while (true) {
                while (choose != 0) {
                    view.showQuanLiTaiKhoan();
                    choose = nhapLuaChon();
                    switch (choose) {
                        case 1:
                            int choose1 = -1;
                            viewDanhSachTaiKhoan();
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
                            creatAccount();
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
                            deleteAccount();
                            while (choose3 != 0) {
                                view.showReturnOrBackMenu();
                                choose3 = nhapLuaChon();
                                if (choose3 == 10) {
                                    choose = 0;
                                    choose3 = 0;
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
    }


