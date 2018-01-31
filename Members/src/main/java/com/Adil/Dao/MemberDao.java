package com.Adil.Dao;
 
import java.util.Collection;
import com.Adil.Entity.Member;
 
public interface MemberDao {
    	
	/**
	 * Abstract methods to be used in "PostgresMemberDaoImpl.java" class
	 * @return respective methods that are used in above stated class.
	 */
            
	Collection<Member> getAllMembers();// Gets all members in our DB       
 
    Member getMemberById(int id);
 
    void removesMemberById(int id);
 
    void updateMember(Member member);
 
    void insertMemberToDb(Member member);

	Member getMemberByName(String name);
			
}