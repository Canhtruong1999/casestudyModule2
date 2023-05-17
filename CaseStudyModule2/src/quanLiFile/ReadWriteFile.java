package quanLiFile;

import object.Xe;

import java.io.*;
import java.time.LocalDateTime;

import static object.BaiGiuXe.*;
import static service.LichSuXeRaVaoBai.addLichSu;
import static service.LichSuXeRaVaoBai.lichSuRaVao;
import static service.QuanLiDoanhThu.doanhThuNgay;

public class ReadWriteFile {
    //BaiGiuXe baiGiuXe=new BaiGiuXe();
    public  void vietFileDanhSachXe() {
        File file = new File("D:\\workSpace\\caseStudyModule2\\CaseStudyModule2\\src\\data\\quanLiXe.txt");
        try {
            BufferedWriter nhapDuLieu = new BufferedWriter(new FileWriter(file));
            for (Xe x : danhSachXe) {
                nhapDuLieu.write(x.getChuXe() + "\n");
                nhapDuLieu.write(x.getBaiDoXe() + "\n");
                nhapDuLieu.write(x.getId() + "\n");
                nhapDuLieu.write(x.getBienSo() + "\n");
                nhapDuLieu.write(x.getLoaiXe() + "\n");
                nhapDuLieu.write(x.getGioVaoBai() + "\n");
            }
            nhapDuLieu.close();
        } catch (Exception e) {
            System.out.println("file ko tồn tại");
        }
    }
    public void docFileDanhSachXe() {
        File file = new File("D:\\workSpace\\caseStudyModule2\\CaseStudyModule2\\src\\data\\quanLiXe.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = (reader.readLine())) != null) {
                int baiDoXe = Integer.parseInt(reader.readLine());
                int id = Integer.parseInt(reader.readLine());
                String bienSo = reader.readLine();
                String loaiXe = reader.readLine();
                LocalDateTime gioVaoBai = LocalDateTime.parse(reader.readLine());

                danhSachXe.add(new Xe(bienSo, loaiXe, line, baiDoXe, gioVaoBai, id));
                cacBaiDoXe[baiDoXe - 1] = true;
            }
        } catch (Exception e) {

        }
    }
    public  void vietFileLichSu() {
        File file = new File("D:\\workSpace\\caseStudyModule2\\CaseStudyModule2\\src\\data\\lichSu.txt");
        try {
            BufferedWriter nhapDuLieu = new BufferedWriter(new FileWriter(file));
            for (String str : lichSuRaVao) {
                nhapDuLieu.write(str + "\n");
            }
            nhapDuLieu.close();
        } catch (Exception e) {

        }
    }
    public  void docFileLichSu() {
        File file = new File("D:\\workSpace\\caseStudyModule2\\CaseStudyModule2\\src\\data\\lichSu.txt");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                addLichSu(line);
            }
            bufferedReader.close();
        } catch (Exception e) {

        }
    }
    public  void vietFileDoanhThuNgay() {
        File file = new File("D:\\workSpace\\caseStudyModule2\\CaseStudyModule2\\src\\data\\doanhThuNgay.txt");
        try {
            BufferedWriter nhapDuLieu = new BufferedWriter(new FileWriter(file));
            for (String str : doanhThuNgay) {
                nhapDuLieu.write(str + "\n");
            }
            nhapDuLieu.close();
        } catch (Exception e) {

        }
    }

    public  void docFileDoanhThuNgay() {
        File file = new File("D:\\workSpace\\caseStudyModule2\\CaseStudyModule2\\src\\data\\doanhThuNgay.txt");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                doanhThuNgay.add(line);
            }
            bufferedReader.close();
        } catch (Exception e) {

        }
    }
    public  void vietFileGia(){
        File file= new File("D:\\workSpace\\caseStudyModule2\\CaseStudyModule2\\src\\data\\giaGiuXe.txt");
        try {
            BufferedWriter nhapDuLieu = new BufferedWriter(new FileWriter(file));
            String gia = String.valueOf(giaTienGiuXe);
            nhapDuLieu.write(gia);
            nhapDuLieu.close();
        } catch (Exception e) {

        }
    }
    public  void docFileGia(){
        File file = new File("D:\\workSpace\\caseStudyModule2\\CaseStudyModule2\\src\\data\\giaGiuXe.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int gia = Integer.parseInt(reader.readLine());
            setGiaTienGiuXe(gia);
            reader.close();
        } catch (Exception e) {

        }
    }
}
