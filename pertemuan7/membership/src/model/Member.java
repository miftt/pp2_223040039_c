package pertemuan7.membership.src.model;

public class Member {
    private String id;
    private String nama;
    private JenisMember jenisMember;

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getNama() {
        return nama;
    }

    public void setJenisMember(JenisMember JenisMember) {
        this.jenisMember = JenisMember;
    }
    public JenisMember getJenisMember() {
        return jenisMember;
    }
}
