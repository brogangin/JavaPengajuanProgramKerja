
import java.util.ArrayList;

public class Mahasiswa {
    private String nim;
    private String nama;
    private String pin;
    private ArrayList<ProgramKerja> proker = new ArrayList<>();

//    Getter

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getPin() {
        return pin;
    }

    public ArrayList<ProgramKerja> getProker(){
        return proker;
    }

//    Setter

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNim(String nim) {
        if(nim.length() == 12){
            this.nim = nim;
        }
        else{
            System.out.println("NIM harus terdiri dari 12 angka");
        }
    }
    
    public void setPin(String pin) {
        this.pin = pin;
    }
    
}
