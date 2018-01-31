package com.Adil.Service;

import com.Adil.Dao.MemberDao;
import com.Adil.Entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service
public class MemberService {

@Autowired
@Qualifier("postgres")
    private MemberDao memberDao;
    
    public Collection<Member> getAllMembers() { //Merging 2 different classes wtf
        return this.memberDao.getAllMembers();
    }    

    public  Member getMemberById(int id) {
        return this.memberDao.getMemberById(id);
    }

    public Member getMemberByName(String name) {
        return this.memberDao.getMemberByName(name);
    }
    
    public void removeMemberById(int id) {
        this.memberDao.removesMemberById(id);
    }

    public void updateMember(Member member) {
        this.memberDao.updateMember(member);
    }

    public void insertMember(Member member) {
        this.memberDao.insertMemberToDb(member);
    }
}