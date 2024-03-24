package tTUGASGITHUB;
import java.util.ArrayList;

public class DataMahasiswa {
    

    private String mhs_nim;
    public String getMhs_nim() {
        return mhs_nim;
    }

    public void setMhs_nim(String mhs_nim) {
        this.mhs_nim = mhs_nim;
    }
    private String mhs_nama;
    public String getMhs_nama() {
        return mhs_nama;
    }

    public void setMhs_nama(String mhs_nama) {
        this.mhs_nama = mhs_nama;
    }

    private ArrayList<MataKuliah> daftarMataKuliah;
    public ArrayList<MataKuliah> getDaftarMataKuliah() {
        return daftarMataKuliah;
    }

    public void setDaftarMataKuliah(ArrayList daftarMataKuliah) {
        this.daftarMataKuliah = daftarMataKuliah;
    }
}