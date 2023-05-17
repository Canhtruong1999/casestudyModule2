package service;

import object.BaiGiuXe;
import view.View;

import static input.Input.nhapLuaChon;

public class InVeXeVaHoaDon {
    BaiGiuXe baiGiuXe=new BaiGiuXe();
    View view =new View();
    public  void inVeXeVaHoaDon() {
        int choose = -1;

        while (true) {
            while (choose != 0) {
                view.ShowInPhieuXeVaHoaDon();
                choose = nhapLuaChon();
                switch (choose) {
                    case 1:
                        int choose1 = -1;
                        baiGiuXe.inPhieuXe();
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
                        baiGiuXe.inHoaDon();
                        while (choose2 != 0) {
                            view.showReturnOrBackMenu();
                            choose2 = nhapLuaChon();
                            if (choose2 == 10) {
                                choose = 0;
                                choose2 = 0;
                            }
                        }
                        break;
                }
            }
            return;
        }
    }
}
