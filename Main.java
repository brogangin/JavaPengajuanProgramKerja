
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static String pilString = "";
    public static int pilInt = 0;
    public static boolean cekPilihan = false;
    public static boolean run = true;
    public static String login = null;
    public static ArrayList<Mahasiswa> mahasiswa = new ArrayList<>();
    public static Dosen[] dosen = {new Rektor(), new Dekan(), new Kaprodi()};

    public static void main(String[] args) {
        
        do{
            
            while(login == null){
            
                System.out.println("---------------------------------------------------");
                System.out.println("\tSistem Pengajuan Program Kerja");
                System.out.println("---------------------------------------------------");
                cekPilihan = false;
                while(cekPilihan == false){
                    System.out.println("Masuk sebagai ?\n(1) Mahasiswa | (2) Dosen");
                    System.out.print("Pilihan : ");
                    String peran = input.nextLine();
                    System.out.println();

                    switch(peran){
                        case "1" -> {
                            System.out.println("---------------------------------------------------");
                            System.out.println("- - - - - - - - - - Mahasiswa - - - - - - - - - -");

                            Mahasiswa user = null;

                            System.out.println("(1)Masuk / (2)Daftar / (0)Kembali");
                            cekPilihan = false;
                            while (cekPilihan == false){
                                System.out.print("Pilihan : ");
                                pilString = input.nextLine(); 
                                switch(pilString){
                                    case "1":
                                        System.out.println("---------------------------------------------------");
                                        user = mhsMasuk();
                                        cekPilihan = true;
                                        break;

                                    case "2":
                                        System.out.println("---------------------------------------------------");
                                        mhsDaftar();
                                        cekPilihan = true;
                                        break;
                                        
                                    case "0":
                                        System.out.println("---------------------------------------------------");
                                        login = null;
                                        cekPilihan = true;
                                        break;

                                    default :
                                        System.out.println("Input tidak ada dalam opsi, silahkan pilih opsi yang tersedia");
                                        break;
                                }
                            }

                            
                            while ( login == "true") {

                                ArrayList<ProgramKerja> proker = user.getProker();
                                
                                System.out.println("Pilihan Menu Mahasiswa:");
                                System.out.println("1 | Pengajuan Baru");
                                System.out.println("2 | Daftar Pengajuan");
                                System.out.println("0 | Keluar");
                                cekPilihan = false;
                                while(cekPilihan == false){
                                    System.out.print("Pilihan : ");
                                    pilString = input.nextLine();
            
                                    switch(pilString){
                                        case "1" -> {
                                            System.out.println("---------------------------------------------------");
                                            proker.add(new ProgramKerja());
                                            proker.get(proker.size() - 1).setDataMahasiswa(user);
                                            System.out.print("Nama proker : ");
                                            proker.get(proker.size() - 1).setNamaProgramKerja(input.nextLine());
                                            System.out.println("Nama organisasi\n1 | BEM Universitas\n2 | BEM Fakultas\n3 | HIMA Prodi");
                                            cekPilihan = false;
                                            while(cekPilihan == false){
                                                System.out.print("Pilihan : ");
                                                pilString = input.nextLine();

                                                switch(pilString){
                                                    case "1" -> {
                                                        proker.get(proker.size() - 1).setNamaOrganisasi("BEM Universitas");
                                                        dosen[0].getProker().add(proker.get(proker.size() - 1));
                                                        cekPilihan = true;
                                                    }
                                                    case "2" -> {
                                                        proker.get(proker.size() - 1).setNamaOrganisasi("BEM Fakultas");
                                                        dosen[1].getProker().add(proker.get(proker.size() - 1));
                                                        cekPilihan = true;
                                                    }
                                                    case "3" -> {
                                                        proker.get(proker.size() - 1).setNamaOrganisasi("HIMA Prodi");
                                                        dosen[2].getProker().add(proker.get(proker.size() - 1));
                                                        cekPilihan = true;
                                                    }
                                                    default -> System.out.println("Input tidak ada dalam opsi, silahkan pilih opsi yang tersedia");
                                                }
                                            }
                                            System.out.print("Tema : ");
                                            proker.get(proker.size() - 1).setTemaProker(input.nextLine());
                                            System.out.print("Tujuan : ");
                                            proker.get(proker.size() - 1).setTujuanProker(input.nextLine());
                                            System.out.print("Deskripsi : ");
                                            proker.get(proker.size() - 1).setDeskripsiProker(input.nextLine());
                                            System.out.print("Pengeluaran : ");
                                            proker.get(proker.size() - 1).setPengeluaran(input.nextInt());
                                            System.out.print("Pemasukan : ");
                                            proker.get(proker.size() - 1).setPemasukan(input.nextInt());
                                            input.nextLine();
                                            System.out.println("---------------------------------------------------");
                                            System.out.println("- - - - - - - - - Program Diajukan - - - - - - - - -");
                                            System.out.println("---------------------------------------------------");
                                            cekPilihan = true;
                                        }
            
                                        case "2" -> {
                                            System.out.println("---------------------------------------------------");
                                            System.out.println("- - - - - - - - - Status Pengajuan - - - - - - - - -");
                                            System.out.println("No.\tNama Program Kerja\t<->\tStatus Pengajuan\n");
                                            if(proker.isEmpty()) System.out.println("Tidak ada data pengajuan\n");
                                            else{
                                                for(int i=1; i<=proker.size(); i++){
                                                    System.out.println(i + ".\t" + proker.get(i - 1).getNamaProgramKerja() + " <-> " + proker.get(i - 1).getStatus());
                                                }
                                                System.out.println("---------------------------------------------------");
                                                System.out.println("(a)Detail\t(b)Kembali");
                                                cekPilihan = false;
                                                while(cekPilihan == false){
                                                    System.out.print("Pilihan : ");
                                                    pilString = input.nextLine();
                                                    switch (pilString) {
                                                        case "a" -> {
                                                            System.out.println("---------------------------------------------------");
                                                            cekPilihan = false;
                                                            while(cekPilihan == false){
                                                                System.out.print("Pilih Nomor Program Kerja :");
                                                                pilInt = input.nextInt();
                                                                input.nextLine();
                                                                if(pilInt > 0 && pilInt <= proker.size()){
                                                                    System.out.println("- - - - - - - - - - Detail Program - - - - - - - - - -");
                                                                    System.out.println("Nama organisasi\t\t: " + proker.get(pilInt - 1).getNamaOrganisasi());
                                                                    System.out.println("Nama program kerja\t: " + proker.get(pilInt - 1).getNamaProgramKerja());
                                                                    System.out.println("Tema\t\t: " + proker.get(pilInt - 1).getTemaProker());
                                                                    System.out.println("Tujuan\t\t: " + proker.get(pilInt - 1).getTujuanProker());
                                                                    System.out.println("Deskripsi\t\t: " + proker.get(pilInt - 1).getDeskripsiProker());
                                                                    System.out.println("Pengeluaran\t\t: " + proker.get(pilInt - 1).getPengeluaran());
                                                                    System.out.println("Pemasukan\t\t: " + proker.get(pilInt - 1).getPemasukan());
                                                                    System.out.println("Status Pengajuan\t: " + proker.get(pilInt - 1).getStatus());
                                                                    if(!proker.get(pilInt - 1).getStatus().equals("Diproses")){
                                                                        System.out.println(proker.get(pilInt - 1).getStatus() + " oleh " + proker.get(pilInt - 1).getDataDosen().getNama() + "(" + proker.get(pilInt - 1).getDataDosen().getNidn() + ")");
                                                                    }
                                                                    System.out.println("---------------------------------------------------");
                                                                    cekPilihan = true;
                                                                }
                                                                else System.out.println("Input tidak ada dalam opsi, silahkan pilih opsi yang tersedia");
                                                            }
                                                            cekPilihan = true;
                                                        }
                                                        case "b" -> {
                                                            System.out.println("---------------------------------------------------");
                                                            cekPilihan = true;
                                                        }
                                                        default -> System.out.println("Input tidak ada dalam opsi, silahkan pilih opsi yang tersedia");
                                                    }
                                                }
                                            }
                                            cekPilihan = true;
                                        }
            
                                        case "0" -> {
                                            System.out.println("---------------------------------------------------\n\n\n");
                                            login = null;
                                            cekPilihan = true;
                                        }

                                        default -> System.out.println("Input tidak ada dalam opsi, silahkan pilih opsi yang tersedia");
                                    }
                                }
                            }
                            cekPilihan = true;
                        }
                            
                        case "2" -> {
                            cekPilihan = false;

                            System.out.println("---------------------------------------------------");
                            System.out.println("- - - - - - - - - - Dosen - - - - - - - - - -");
                            Dosen user = masukDosen();

                            
                            while(login == "true"){                                
                                ArrayList<ProgramKerja> proker = user.getProker();
                                
                                System.out.println("---------------------------------------------------");
                                
                                System.out.println("Pilihan Menu Dosen :");
                                System.out.println("1 | Daftar Pengajuan");
                                System.out.println("2 | Keluar");
                                System.out.println("3 | Hentikan Sistem");
                                cekPilihan = false;
                                while(cekPilihan == false){
                                    System.out.print("Pilihan : ");
                                    pilString = input.nextLine();
                                    
                                    switch(pilString){
                                        case "1" -> {
                                            System.out.println("---------------------------------------------------");
                                            System.out.println("- - - - - - - - - Daftar Pengajuan - - - - - - - - -");
                                            System.out.println("No.\tNama Program Kerja\t<->\tStatus Pengajuan\n");
                                            
                                            if(proker.isEmpty()) System.out.println("Tidak ada data pengajuan\n");
                                            else{
                                                for(int i=1; i<=proker.size(); i++){
                                                    
                                                    System.out.println(i + ".\t" + proker.get(i - 1).getNamaProgramKerja() + " -> " + proker.get(i - 1).getStatus());
                                                    
                                                }
                                                System.out.println("---------------------------------------------------");
                                                System.out.println("(a)Detail\t(b)Kembali");
                                                cekPilihan = false;
                                                while( cekPilihan == false){
                                                    System.out.print("Pilihan : ");
                                                    pilString = input.nextLine();
                                                    switch (pilString) {
                                                        case "a" -> {
                                                            cekPilihan = false;
                                                            while(cekPilihan == false){
                                                                System.out.println("---------------------------------------------------");
                                                                System.out.println("Pilih nomor Program Kerja :");
                                                                pilInt = input.nextInt();
                                                                input.nextLine();
                                                                if(pilInt > 0 && pilInt <= proker.size()){
                                                                    System.out.println("- - - - - - - - - - Detail Program - - - - - - - - - -");
                                                                    System.out.println("Nama Organisasi\t\t: " + proker.get(pilInt - 1).getNamaOrganisasi());
                                                                    System.out.println("Nama program kerja\t: " + proker.get(pilInt - 1).getNamaProgramKerja());
                                                                    System.out.println("Deskripsi\t\t: " + proker.get(pilInt - 1).getTemaProker());
                                                                    System.out.println("Deskripsi\t\t: " + proker.get(pilInt - 1).getTujuanProker());
                                                                    System.out.println("Deskripsi\t\t: " + proker.get(pilInt - 1).getDeskripsiProker());
                                                                    System.out.println("Pengeluaran\t\t: " + proker.get(pilInt - 1).getPengeluaran());
                                                                    System.out.println("Pemasukan\t\t: " + proker.get(pilInt - 1).getPemasukan());
                                                                    System.out.println("Diajukan oleh\t\t: " + proker.get(pilInt - 1).getDataMahasiswa().getNama() + "(" + proker.get(pilInt - 1).getDataMahasiswa().getNim() + ")");
                                                                    System.out.println();
                                                                    System.out.println("---------------------------------------------------");
                                                                    
                                                                    System.out.println("(1)Setuju\t(2)Tolak\t(0)Kembali");
                                                                    while(cekPilihan == false){
                                                                        System.out.print("Pilihan : ");
                                                                        pilString = input.nextLine();
                        
                                                                        switch (pilString) {
                                                                            case "1":
                                                                                proker.get(pilInt - 1).setStatus("Disetujui");
                                                                                proker.get(pilInt - 1).setDataDosen(user);
                                                                                System.out.println("---------------------------------------------------");
                                                                                System.out.println("- - - - - - - - - Program Disetujui - - - - - - - - -");
                                                                                System.out.println("---------------------------------------------------");
                                                                                cekPilihan = true;
                                                                                break;
                                                                            case "2":
                                                                                proker.get(pilInt - 1).setStatus("Ditolak");
                                                                                proker.get(pilInt - 1).setDataDosen(user);
                                                                                System.out.println("---------------------------------------------------");
                                                                                System.out.println("- - - - - - - - - Program Ditolak - - - - - - - - -");
                                                                                System.out.println("---------------------------------------------------");
                                                                                System.out.println();
                                                                                cekPilihan = true;
                                                                                break;
                                                                            case "0":
                                                                                System.out.println("---------------------------------------------------");
                                                                                cekPilihan = true;
                                                                                break;
                                                                            default:
                                                                                System.out.println("Input tidak ada dalam opsi, silahkan pilih opsi yang tersedia");
                                                                                break;
                                                                        }
                                                                    }
                                                                    cekPilihan = true;
                                                                }
                                                                else System.out.println("Input tidak ada dalam opsi, silahkan pilih opsi yang tersedia");
                                                            }
                                                            cekPilihan = true;
                                                        }
                                                        case "b" -> {
                                                            System.out.println("---------------------------------------------------");
                                                            cekPilihan = true;
                                                        }
                                                        default -> System.out.println("Input tidak ada dalam opsi, silahkan pilih opsi yang tersedia");
                                                    }
                                                }
                                            }
                                            cekPilihan = true;
                                        }
                                            
                                        case "2" -> {
                                            System.out.println("---------------------------------------------------\n\n\n");
                                            login = null;
                                            cekPilihan = true;
                                        }
                                        
                                        case "3" -> {
                                            System.out.println("---------------------------------------------------\n\n\n");
                                            System.out.println("- - - - - - - - - - Program Dihentikan - - - - - - - - - -");
                                            System.out.println("---------------------------------------------------\n\n\n");
                                            login = "false";
                                            run = false;
                                            cekPilihan = true;
                                        }
                                        default -> System.out.println("Input tidak ada dalam opsi, silahkan pilih opsi yang tersedia");
                                    }
                                }
                            }
                            cekPilihan = true;
                        }

                        default -> {
                            System.out.println("Input tidak ada dalam opsi, silahkan pilih opsi yang tersedia");
                        }
                    }
                }
                
            }

        }while(run == true);

        input.close();

    }

    private static Mahasiswa mhsMasuk(){
            Mahasiswa mhs = null;
            System.out.print("NIM : ");
            String nim = input.nextLine();
            System.out.print("Pin : ");
            String pin = input.nextLine();
            if(mahasiswa != null){
                for (Mahasiswa m : mahasiswa) {
                    if(nim.equals(m.getNim())){
                        if(pin.equals(m.getPin())){
                            login = "true";
                            mhs = m;
                            System.out.println("---------------------------------------------------");
                            System.out.println("Selamat Datang " + m.getNama());
                        }
                        break;
                    }
                }
            }
            if(login != "true"){
                System.out.println("Nim atau Pin salah!");
                cekPilihan = false;
                while(cekPilihan == false){
                    System.out.println("(1)Coba lagi / (2)Kembali");
                    System.out.print("Pilihan : ");
                    pilString = input.nextLine();
                    
                    switch (pilString) {
                        case "1":
                            System.out.println("---------------------------------------------------");
                            mhs = mhsMasuk();
                            cekPilihan = true;
                            break;
                    
                        case "2":
                            System.out.println("---------------------------------------------------");
                            cekPilihan = true;
                            login = null;
                            mhs = null;
                            break;
                        default :
                            System.out.println("Input tidak ada dalam opsi, silahkan pilih opsi yang tersedia");
                            break;
                    }
                }
            }
            
        
        return mhs;
    }
    
    private static void mhsDaftar(){
        boolean cekNim = true;

        System.out.println("---------------------------------------------------");
        System.out.print("NIM : ");
        String nim = input.nextLine();
        if(mahasiswa != null){
            for(Mahasiswa m:mahasiswa){
                if(m.getNim() == nim){
                    cekNim = false;
                    System.out.println("NIM telah digunakan!");
                    cekPilihan = false;
                    while(cekPilihan == false){
                        System.out.println("(1)Coba lagi / (2)Kembali");
                        System.out.print("Pilihan : ");
                        pilString = input.nextLine();
                        switch (pilString) {
                            case "1":
                                System.out.println("---------------------------------------------------");
                                cekPilihan = true;
                                mhsDaftar();
                                break;
                        
                            case "2":
                                System.out.println("---------------------------------------------------");
                                cekPilihan = true;
                                login = null;
                                break;
                            default:
                                System.out.println("Input tidak ada dalam opsi");
                                break;
                        }
                    }
                    break;
                }
            }
        }
        
        if(cekNim == true){
            if(mahasiswa.isEmpty() || !mahasiswa.get(mahasiswa.size() - 1).equals(null)) mahasiswa.add(new Mahasiswa());
            mahasiswa.get(mahasiswa.size() - 1).setNim(nim);
            if(mahasiswa.get(mahasiswa.size() - 1).getNim() != null){ 
                cekNim = true;
                System.out.print("Nama : ");
                mahasiswa.get(mahasiswa.size() - 1).setNama(input.nextLine());
                System.out.print("Pin : ");
                mahasiswa.get(mahasiswa.size() - 1).setPin(input.nextLine());
            }
            else {
                cekPilihan = false;
                while(cekPilihan == false){
                    System.out.println("(1)Coba lagi / (2)Kembali");
                    System.out.print("Pilihan : ");
                    pilString = input.nextLine();
                    switch(pilString){
                        case "1":
                            System.out.println("---------------------------------------------------");
                            cekPilihan = true;
                            mhsDaftar();
                            break;

                        case "2": 
                            System.out.println("---------------------------------------------------");
                            cekPilihan = true;
                            login = null;
                            break;
                        default :
                            System.out.println("Input tidak ada dalam opsi, silahkan pilih opsi yang tersedia");
                            break;
                    }
                }
                
            }
        }
            
        
    }
    
    private static Dosen masukDosen(){
        Dosen dos = null;
        boolean cek = false;
        System.out.print("Kode Akses : ");
        String kodeAkses = input.nextLine();
        
        for(int i=0; i<dosen.length; i++){
            if(dosen[i].getKodeAkses().equals(kodeAkses)){
                cek = true;
                login = "true";
                dos = dosen[i];
                System.out.println("---------------------------------------------------");
                System.out.println("Selamat Datang " + dosen[i].getNama());
            }
        }
        if(cek == false){
            System.out.println("Kode akses salah!");
            cekPilihan = false;
            while(cekPilihan == false){
                System.out.println("(1)Coba lagi / (2)Kembali");
                pilString = input.nextLine();
                switch(pilString){
                    case "1" -> {
                        System.out.println("---------------------------------------------------");
                        dos = masukDosen();
                        cekPilihan = true;
                        break;
                    }
                    case "2" -> {
                        System.out.println("---------------------------------------------------");
                        cekPilihan = true;
                        login = null;
                        dos = null;
                        break;
                    }
                    default -> {
                        System.out.println("Input tidak ada dalam opsi, silahkan pilih opsi yang tersedia");
                        break;
                    }
                }
            }
        }
        return dos;
    }
    
}
