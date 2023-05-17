package input;

import java.util.Scanner;
import java.util.regex.Pattern;

import static object.BaiGiuXe.cacBaiDoXe;

public class Input {
    public static int nhapLuaChon() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("nhập lựa chọn:");
            int num = scanner.nextInt();
            return num;
        } catch (Exception e) {
            System.out.println("nhập lại số:");
            return nhapLuaChon();
        }
    }

    public static String nhapBienSoOTo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập biển số: Vd: 12T345.67");
        String bienSo = scanner.nextLine();
        final String mauBienSo = "[0-9]{2}[A-Z]\\d{3}[.]\\d{2}";
        if (Pattern.compile(mauBienSo).matcher(bienSo).matches()) {
            return bienSo;
        } else {
            System.out.println("nhập lại đúng định dạng biển số ô tô");
            return nhapBienSoOTo();
        }
    }

    public static String nhapChuoi() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (str != null&& str.trim()!=null) {
            return str;
        } else {
            System.out.println("không được để trống");
            return nhapChuoi();
        }
    }

    public static int nhapSo() {
        Scanner scanner = new Scanner(System.in);
        try {
            int num = scanner.nextInt();
            return num;
        } catch (Exception e) {
            System.out.println("nhập sai! Hãy nhập lại");
            return nhapSo();
        }
    }

    public static int chonBaiDangTrong() {

        int number = nhapSo();
        for (int i = 0; i < cacBaiDoXe.length; i++) {
            if ((i + 1) == number) {
                if (!cacBaiDoXe[i]) {
                    return number;
                }
            }
        }
        System.out.println("chỉ đuọc chọn bãi đỗ còn trống");
        return chonBaiDangTrong();
    }

    public static String nhapNgayThang() {
        String ngayThang = nhapChuoi();
        String ngayThangFormat = "\\d{2}[-]\\d{2}";
        if (Pattern.compile(ngayThangFormat).matcher(ngayThang).matches()) {
            return ngayThang;
        } else {
            System.out.println("nhập lại đúng định dạng của ngày tháng: dd-mm");
            return nhapNgayThang();
        }
    }

    public static String nhapThang() {
        String thang = nhapChuoi();
        String thangformat = "\\d{2}";
        if (Pattern.compile(thangformat).matcher(thang).matches()) {
            return thang;
        } else {
            System.out.println("nhập lại đúng định dạng của tháng: mm");
            return nhapThang();
        }
    }
}
