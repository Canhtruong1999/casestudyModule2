package service;

import object.BaiGiuXe;
import view.View;

import java.util.ArrayList;
import java.util.List;

import static input.Input.nhapLuaChon;

public class QuanLiDoanhThu {
    View view = new View();
    public static List<String> doanhThuNgay = new ArrayList<String>();

    public void quanLiDoanhThu() {
        BaiGiuXe baiGiuXe = new BaiGiuXe();
        int choose = -1;

        while (true) {
            while (choose != 0) {
                view.showQuanLiDoanhThu();
                choose = nhapLuaChon();
                switch (choose) {
                    case 1:
                        int choose1 = -1;
                        baiGiuXe.doanhThuCuaNgay();
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
                        baiGiuXe.doanhThuCuaThang();
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
                        baiGiuXe.doiGia();
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
