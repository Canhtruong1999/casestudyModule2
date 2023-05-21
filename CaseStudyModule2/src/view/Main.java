package view;

import quanLiFile.ReadWriteFile;

import static service.UserManager.LogIn;

public class Main {
    public static void main(String[] args) {
        ReadWriteFile readWriteFile=new ReadWriteFile();
        readWriteFile.docFileDanhSachXe();
        readWriteFile.docFileLichSu();
        readWriteFile.docFileDoanhThuNgay();
        readWriteFile.docFileGia();
        readWriteFile.docFileTaiKhoan();

        LogIn();
    }
}

