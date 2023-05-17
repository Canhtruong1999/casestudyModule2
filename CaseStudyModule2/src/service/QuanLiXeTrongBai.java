package service;

import object.BaiGiuXe;
import view.View;

import static input.Input.nhapLuaChon;

public class QuanLiXeTrongBai {
    public void quanLiXeTrongBai() {
        BaiGiuXe baiGiuXe =new BaiGiuXe();
        View view =new View();
        int choose = -1;

        while (true) {
            while (choose != 0) {
                view.showQuanLiXeTrongBai();
                choose = nhapLuaChon();
                switch (choose) {
                    case 1:
                        int choose1 = -1;
                        baiGiuXe.timXeDoOBaiNao();
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
                        baiGiuXe.baiSoMayDoXeNao();
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
                        baiGiuXe.soLuongBaiDoConTrong();
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
                        baiGiuXe.soLuongXeDangGiuTaiBai();
                        while (choose4 != 0) {
                            view.showReturnOrBackMenu();
                            choose4 = nhapLuaChon();
                            if (choose4 == 10) {
                                choose = 0;
                                choose4 = 0;
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
