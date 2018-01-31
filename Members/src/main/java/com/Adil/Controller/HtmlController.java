package com.Adil.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.Adil.Entity.Member;
import com.Adil.Entity.ThealeMember;
import com.Adil.Service.APICall;
import com.Adil.Service.MemberService;


    	
	@Controller
	public class HtmlController {
	@Autowired
	MemberService memberService;		  
	
	//Theale End to End Endpoints (See Rickmansworth End to End for documentation).
	
    @GetMapping("/AddProfilePage")
    public String AddProfileForm(Model model) {
    		ThealeMember m = new ThealeMember();
	   	model.addAttribute("InfoToSubmit", m);
    	return "AddProfilePage";
    }
        
    @PostMapping("/AddProfilePage")	
	public String AddProfileSubmit(@ModelAttribute ThealeMember m, Model model) {    
	    APICall.postEntity(m);
	    model.addAttribute("UserInfo",APICall.getAllEntity());
	return "ViewAll";    
	}   	
    
    @GetMapping("/ViewAll")
    public String ViewProfilesFetch (Model model) {
		model.addAttribute("UserInfo", APICall.getAllEntity());
   	return "ViewAll";
    } 

    @GetMapping(value = "/DeleteConfirm/{name}")
    public String DeleteConfirm(Model model, @PathVariable String name) {
    		model.addAttribute("DelUserInfo",APICall.getEntity(name));    
    return "DeleteConfirm";
    }
    
    @RequestMapping(value="/DeleteConfirm/{id}",method = RequestMethod.DELETE)
    public String DeleteInfo(ThealeMember m, Model model, @PathVariable int id) {
    		APICall.deleteEntity(id);
    	return "DeleteCompleted";
    }
    
    @GetMapping("/ThealeDirectory")
    public String ThealeDirectoryFetch(Model model) { 	
   	return "ThealeDirectory";
    }
  
    @GetMapping(value = "/EditProfile/{name}") 
    public String EditProfileFetch( @PathVariable String name, Model model, ThealeMember m){	
    	 	ThealeMember[] member;
    	 	member = APICall.getEntity(name);
    	 	m = member[0];
    	 	model.addAttribute("EditInfo", m);
    return "EditProfile";
    }  
   
    @PostMapping("/EditProfileComplete/{id}")	
  	public String EditProfileSubmitPage(@PathVariable int id,@ModelAttribute ThealeMember m, Model model) { 
      	System.out.println("Part 3 Reached");
 	    APICall.putEntity(id, m);
  	    model.addAttribute("UserInfo",APICall.getAllEntity());
  	return "ViewAll";    
  	}   	
    
    @GetMapping("/EditProfile")
    public String EditProfileFetch(Model model) {
   		model.addAttribute("ThealeDirectory", new Member ());
   	return "EditProfile";
    }
     
    @PostMapping("/EditProfile")                
    public String EditProfileForm(@ModelAttribute Member m, Model model) {
    	return "ViewAll";
    }
    
    //Rickmansworth End to End Endpoints
    
    /**
     * GET'S RickyDirectory.html page (Home page).
     * @param model	n/a
     * @return 		RickyDirectory.html (templates folder) uses Thymeleaf.
     */
    @GetMapping("/RickyDirectory")
    public String RickyDirectoryFetch(Model model) {
   		model.addAttribute("RickyDirectory", new Member ());
   	return "RickyDirectory";
    }
    
    /**
     * GET's AddProfilePageRicky.html (Form page)
     * @param model	Allows user info data to be used in HTML pages.
     * @return		AddProfilePageRicky.html with empty Entity object "m".
     */
	@GetMapping("/AddProfilePageRicky")
    public String AddProfileFormRicky(Model model) {
		Member m = new Member ();
		model.addAttribute("AddProfilePageRicky", m );
    	return "AddProfilePageRicky";
    } 
	
	/**
	 * POST's user info in object "m" through API to DB using memberService method for Ricky DB.
	 * @param m		Contains user info in variables instantiated in Member.java
	 * @param model	Assigns all DB entries to Table RickyInfo
	 * @return		ViewAllRicky.html page containing table
	 */
	@PostMapping("/AddProfilePageRicky")
	public String AddProfileRickySubmit(@ModelAttribute Member m, Model model) {
		memberService.insertMember(m);
		model.addAttribute("RickyInfo", memberService.getAllMembers());
	return "ViewAllRicky";
	}
	
	/**
	 * GET's a particular user data according to ID.
	 * @param id			ID that is given to data in DB.			
	 * @param model		Fills text boxes with correct data using ID.	
	 * @param member		Object containing new data to be sent to DB.
	 * @return			EditProfileRicky.html containing the textboxes.
	 */
    @GetMapping(value = "/EditProfileRicky/{id}")
    public String EditConfirmRicky (@PathVariable int id,Model model,Member member) {
    		member = memberService.getMemberById(id);
    		model.addAttribute("EditInfo", member);  
    return "EditProfileRicky";  
    }
	
    /**
     * POST's new data to replace old to DB.
     * @param member		Object containing new data for user
     * @param model		Populates table in "ViewAllRicky" with data in object "member"
     * @return			"ViewAllRicky.html" showing all data in DB, including new added data.
     */
    @PostMapping("/EditProfileRicky")
 	public String EditRickySubmit(@ModelAttribute Member member, Model model) {
 		memberService.updateMember(member);
 		model.addAttribute("RickInfo", memberService.getAllMembers());
 	return "ViewAllRicky";
 	}
    
    /**
     * GET's data to be deleted by id.
     * @param model		Selected data populates table in "DeleteConfirmRicky.html.
     * @param id			Retrieves ID of selected data to be deleted.
     * @return			"DeleteConfirmRicky.html" showing the data to be deleted as a confirmation page.
     */
    @GetMapping(value = "/DeleteConfirmRicky/{id}")
    public String DeleteConfirmRicky(Model model, @PathVariable int id) {
    		model.addAttribute("DelUserInfoRicky", memberService.getMemberById(id));  
    return "DeleteConfirmRicky";
    }
    
    /**
     * DELETE'S data referred to with ID.
     * @param m			Contains the data to be deleted according to ID.
     * @param model		n/a
     * @param id			ID of chosen data to be deleted, showing the full data overview.
     * @return			"DeleteCompletedRicky.html" confirming the success of method.
     */
    @RequestMapping(value="/DeleteConfirmRicky/{id}",method = RequestMethod.DELETE)
    public String DeleteInfoRicky(Member m, Model model, @PathVariable int id) {
    		memberService.removeMemberById(id);
    return "DeleteCompletedRicky";
    }
    
    /**
     * GET's html page showing data in DB (Rickmansworth).
     * @param model		Populates tale in "ViewAllRicky.html" with all data in DB.
     * @return			"ViewAllRicky.html" with all data in DB.
     */
    @GetMapping("/ViewAllRicky")
    public String ViewProfilesFetchRicky (Model model) {
    		model.addAttribute("RickyInfo", memberService.getAllMembers());
   	return "ViewAllRicky";
    }         
}
