package com.Adil.Controller;

import com.Adil.Entity.Member;
import com.Adil.Service.APICall;
import com.Adil.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



import java.util.Collection;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    
    @Autowired
    private MemberService memberService;
    
    /**
     * GET's data from Rickmanworth DB as JSON format.
     * @return		"memberService.getAllMembers" method in "MemberService.java" package.
     */
    @RequestMapping(method = RequestMethod.GET )
    public Collection<Member> getAllMembers(){           					     
    		return memberService.getAllMembers();          
    } 
    
    /**
     * GET's specfic data set using its ID as a JSON format.
     * @param id		The ID of the data set.
     * @return		"memberService.getMemberById(id)" in Service package.
     */
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Member getMemberById(@PathVariable("id") int id){
        return memberService.getMemberById(id);
    }
    
    /**
     * GET's specific data set using its NAME as a JSON format.
     * @param name		The NAME of the data set.
     * @return			"mmeberService.getMemberByName(name)" in Service package.
     */
    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public Member getMemberByName(@PathVariable("name") String name){
        return memberService.getMemberByName(name);
    }
    
    /**
     * DELETE's specific data set using its ID.
     * @param id		The ID of the data set.
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public static void deleteMemberById(@PathVariable("id")int id){
    		APICall.deleteEntity(id);
      //  memberService.removeMemberById(id);
    }
    
    /**
     * PUT's a data set accoding to its ID.
     * @param member		Assigns the data chosen by ID in a member object.
     * @param id			Retrieves the relevant data using the ID.
     */
    @RequestMapping(value = "/put/{id}", method = RequestMethod.PUT)
    public void updateMemberById(@RequestBody Member member, @PathVariable("id") int id){
        memberService.updateMember(member);
    }
    
    /**
     * POST's new data to the DB.
     * @param member		Creates a new "member" object to contain the new data.
     */
    @RequestMapping(method = RequestMethod.POST)
    public void insertMemberById(@RequestBody Member member){
        memberService.insertMember(member);
    }
}