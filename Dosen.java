
import java.util.ArrayList;

public class Dosen {
    private String nama;
    private String nidn;
    private String kodeAkses;
    private ArrayList<ProgramKerja> proker = new ArrayList<>();

//    Getter
    public String getNama() {
        return nama;
    }

    public String getNidn() {
        return nidn;
    }

    public String getKodeAkses() {
        return kodeAkses;
    }

    public ArrayList<ProgramKerja> getProker(){
        return proker;
    }
    
//    Setter

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNidn(String nidn) {
        this.nidn = nidn;
    }

    public void setKodeAkses(String kodeAkses) {
        this.kodeAkses = kodeAkses;
    }
    

}
