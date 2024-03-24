package tTUGASGITHUB;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    private static List<DataMahasiswa> daftarKHSMahasiswa = new ArrayList<>();

    public static void main(String[] args) {
        Scanner ven = new Scanner(System.in);
        int pilihMenu;
        boolean lanjutMenu = true;

        while (lanjutMenu) {
            while (true) {
                System.out.println("============ Program KHS ============");
                System.out.println("1. Input KHS Mahasiswa");
                System.out.println("2. Cetak KHS Mahasiswa");
                System.out.println("3. Keluar");
                System.out.print("Pilihan: ");
                pilihMenu = ven.nextInt();
                ven.nextLine();

                switch (pilihMenu) {
                    case 1:
                        inputKHS(ven);
                        break;
                    case 2:
                        cetakKHS(ven);
                        break;
                    case 3:
                        System.out.println("SISTEM BERHENTI");
                        lanjutMenu = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan pilih 1-3.");
                }

                if (!lanjutMenu) {
                    break;
                }
            }
        }
    }

    private static void inputKHS(Scanner ven) {
        // Input data mahasiswa
        System.out.print("NIM Mahasiswa: ");
        String nim = ven.nextLine();
        System.out.print("Nama Mahasiswa: ");
        String nama = ven.nextLine();

        DataMahasiswa mahasiswa = new DataMahasiswa();
        mahasiswa.setMhs_nim(nim);
        mahasiswa.setMhs_nama(nama);
        mahasiswa.setDaftarMataKuliah(new ArrayList<>());

        daftarKHSMahasiswa.add(mahasiswa);

        while (true) {
            // Input data mata kuliah
            MataKuliah mataKuliah = new MataKuliah();
            System.out.print("Kode Mata Kuliah Mahasiswa: ");
            String kodeMk = ven.nextLine();
            mataKuliah.setMk_kode(kodeMk);
            System.out.print("Nama Mata Kuliah Mahasiswa: ");
            String namaMk = ven.nextLine();
            mataKuliah.setMk_nama(namaMk);

            System.out.print("Nilai (0.0-4.0): ");
            double nilaiAngka = Double.parseDouble(ven.nextLine());
            if (nilaiAngka < 0.0 || nilaiAngka > 4.0) {
                System.out.println("Nilai harus dalam rentang 0.0 hingga 4.0.");
                return;
            }

            String nilaiHuruf;
            if (nilaiAngka >= 3.7) {
                nilaiHuruf = "A";
            } else if (nilaiAngka >= 3.2) {
                nilaiHuruf = "B+";
            } else if (nilaiAngka >= 2.7) {
                nilaiHuruf = "B";
            } else if (nilaiAngka >= 2.2) {
                nilaiHuruf = "C+";
            } else if (nilaiAngka >= 1.7) {
                nilaiHuruf = "C";
            } else if (nilaiAngka >= 1.2) {
                nilaiHuruf = "D";
            } else {
                nilaiHuruf = "E";
            }

            mataKuliah.setMk_nilai(nilaiHuruf);
            mahasiswa.getDaftarMataKuliah().add(mataKuliah);

            System.out.print("mata kuliah lain? (Y/n) ");
            String opsi = ven.nextLine();
            if (!opsi.equalsIgnoreCase("y")) {
                break;
            }
        }
    }

    private static void cetakKHS(Scanner ven) {
        System.out.print("Masukkan NIM: ");
        String inputNIM = ven.nextLine();
        boolean nimDapat = false;
        for (DataMahasiswa mhs : daftarKHSMahasiswa) {
            if (mhs.getMhs_nim().equals(inputNIM)) {
                nimDapat = true;
                System.out.println("Kartu Hasil Studi untuk Mahasiswa dengan NIM " + inputNIM + ":");
                System.out.println("Nama Mahasiswa: " + mhs.getMhs_nama());
                for (MataKuliah mk : mhs.getDaftarMataKuliah()) {
                    System.out.println("Kode Mata Kuliah: " + mk.getMk_kode());
                    System.out.println("Nama Mata Kuliah: " + mk.getMk_nama());
                    System.out.println("Nilai: " + mk.getMk_nilai());
                    System.out.println();
                }
                break;
            }
        }
        if (!nimDapat) {
            System.out.println("Mahasiswa dengan NIM " + inputNIM + " tidak ditemukan.");
        }
    }
}
