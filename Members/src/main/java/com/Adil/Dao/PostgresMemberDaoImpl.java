 
package com.Adil.Dao;
 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.Adil.Entity.Member;
 
@Repository("postgres")
public class PostgresMemberDaoImpl implements MemberDao{             
	
	

private static class MemberRowMapper implements RowMapper<Member>{                          

@Override
     public Member mapRow(ResultSet resultSet, int i) throws SQLException {
        Member member = new Member();
	    member.setId(resultSet.getInt("id"));
	    member.setName(resultSet.getString("name"));
	    member.setSurname(resultSet.getString("surname"));
	    member.setAge(resultSet.getInt("age"));
	    member.setJobrole(resultSet.getString("jobrole"));
	 return member; 
     }
}
               
@Autowired
     private JdbcTemplate jdbcTemplate;
     
     @Override
     public Collection<Member> getAllMembers() {
        final String sql = "SELECT * FROM Info";
        List<Member> members = jdbcTemplate.query(sql, new MemberRowMapper());
     return members;
     }
 
     @Override
     public Member getMemberById(int id) {
        final String sql = "SELECT * FROM Info WHERE id = ?";
        Member member = jdbcTemplate.queryForObject(sql,new MemberRowMapper(), id);                                                               
     return member;
     }
                
     @Override
     public Member getMemberByName(String name) {
        final String sql = "SELECT * FROM Info WHERE name = ?";
        Member member = jdbcTemplate.queryForObject(sql,new MemberRowMapper(), name);                                                               
     return member;
     }
 
     @Override
     public void removesMemberById(int id) {
        final String sql = "DELETE FROM Info WHERE id = ?";
        jdbcTemplate.update(sql, id);                        
     }
 
     @Override
     public void updateMember(Member member) {
        final String sql = "UPDATE Info SET name = ?, surname = ?, age = ?, jobrole =? WHERE id =?";
        final int id = member.getId();
        final String name = member.getName();
        final String surname = member.getSurname();
        final int age = member.getAge();
        final String jobrole = member.getJobrole();
        jdbcTemplate.update(sql,new Object[] {name,surname,age,jobrole,id});                                      
     }
 
     @Override
     public void insertMemberToDb(Member member) {
        final String sql = "INSERT INTO Info (name, surname, age, jobrole) VALUES ( ?, ?, ?, ?)"; 
        final String name = member.getName();
        final String surname = member.getSurname();
        final int age = member.getAge();
        final String jobrole = member.getJobrole();
        jdbcTemplate.update(sql,new Object[] {name,surname,age,jobrole});                      
     }	
}
 