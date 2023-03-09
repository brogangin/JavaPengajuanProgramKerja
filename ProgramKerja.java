
public class ProgramKerja {
    private Mahasiswa dataMahasiswa;
    private Dosen dataDosen;
    private String namaOrganisasi;
    private String namaProgramKerja;
    private String temaProker;
    private String tujuanProker;
    private String deskripsiProker;
    private int pengeluaran;
    private int pemasukan;
    private String status;

    public ProgramKerja(){
        setStatus("Diproses");
    }
    
//    Getter

    public Mahasiswa getDataMahasiswa() {
        return dataMahasiswa;
    }

    public Dosen getDataDosen(){
        return dataDosen;
    }

    public String getNamaOrganisasi() {
        return namaOrganisasi;
    }

    public String getNamaProgramKerja() {
        return namaProgramKerja;
    }

    public String getTemaProker(){
        return temaProker;
    }

    public String getTujuanProker(){
        return tujuanProker;
    }

    public String getDeskripsiProker() {
        return deskripsiProker;
    }

    public int getPengeluaran() {
        return pengeluaran;
    }

    public int getPemasukan() {
        return pemasukan;
    }
    
    public String getStatus() {
        return status;
    }
    
//    Setter

    public void setDataMahasiswa(Mahasiswa dataMahasiswa) {
        this.dataMahasiswa = dataMahasiswa;
    }
    
    public void setDataDosen(Dosen dataDosen) {
        this.dataDosen = dataDosen;
    }

    public void setNamaOrganisasi(String namaOrganisasi) {
        this.namaOrganisasi = namaOrganisasi;
    }

    public void setNamaProgramKerja(String namaProgramKerja) {
        this.namaProgramKerja = namaProgramKerja;
    }

    public void setTemaProker(String temaProker){
        this.temaProker = temaProker;
    }

    public void setTujuanProker(String tujuanProker){
        this.tujuanProker = tujuanProker;
    }

    public void setDeskripsiProker(String deskripsiProker) {
        this.deskripsiProker = deskripsiProker;
    }

    public void setPengeluaran(int pengeluaran) {
        this.pengeluaran = pengeluaran;
    }

    public void setPemasukan(int pemasukan) {
        this.pemasukan = pemasukan;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
}
