package object;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Xe {
    private String bienSo;
    private String loaiXe;
    private String chuXe;

    public int getBaiDoXe() {
        return baiDoXe;
    }

    public void setBaiDoXe(int baiDoXe) {
        this.baiDoXe = baiDoXe;
    }

    private int baiDoXe;
    private LocalDateTime gioVaoBai;
    private int id;

    public Xe(String bienSo, String loaiXe, String chuXe,int baiDoXe) {
        this.bienSo = bienSo;
        this.loaiXe = loaiXe;
        this.chuXe = chuXe;
        this.baiDoXe=baiDoXe;
        this.gioVaoBai=LocalDateTime.now();
        this.id= LocalTime.now().getNano();
    }
    public Xe(String bienSo, String loaiXe, String chuXe,int baiDoXe,LocalDateTime gioVaoBai,int id) {
        this.bienSo = bienSo;
        this.loaiXe = loaiXe;
        this.chuXe = chuXe;
        this.baiDoXe=baiDoXe;
        this.gioVaoBai=gioVaoBai;
        this.id=id;
    }

    public String getBienSo() {
        return this.bienSo;
    }

    public String getLoaiXe() {
        return this.loaiXe;
    }

    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }

    public String getChuXe() {
        return this.chuXe;
    }

    public Xe setChuXe(String chuXe) {
        this.chuXe = chuXe;
        return this;
    }

    public Xe setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
        return this;
    }

    public LocalDateTime getGioVaoBai() {
        return gioVaoBai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Xe setGioVaoBai(LocalDateTime gioVaoBai) {
        this.gioVaoBai = gioVaoBai;
        return this;
    }
}
