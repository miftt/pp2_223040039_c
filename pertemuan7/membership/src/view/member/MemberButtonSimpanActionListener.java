package pertemuan7.membership.src.view.member;

import pertemuan7.membership.src.dao.MemberDao;
import pertemuan7.membership.src.model.JenisMember;
import pertemuan7.membership.src.model.Member;

import java.awt.event.*;
import java.util.UUID;

public class MemberButtonSimpanActionListener implements ActionListener {
    private MemberFrame memberFrame;
    private MemberDao memberDao;

    public MemberButtonSimpanActionListener(MemberFrame memberFrame, MemberDao memberDao) {
        this.memberFrame = memberFrame;
        this.memberDao = memberDao;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String nama = this.memberFrame.getNama();
        if(nama.isEmpty()){
            this.memberFrame.showAlert("Nama tidak boleh kosong");
        }else{
            JenisMember jenisMember = this.memberFrame.getJenisMember();
            Member member = new Member();
            member.setId(UUID.randomUUID().toString());
            member.setNama(nama);
            member.setJenisMember(jenisMember);

            this.memberDao.insert(member);
            this.memberFrame.addMember(member);
        }
    }
}
