//Full URL for the Swagger main home page for Theale Project: http://10.31.193.73/swagger/ui/index#/Member <http://10.31.193.73/swagger/ui/index#/Member>
package com.Adil.Service;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.Adil.Entity.ThealeMember;

//HTTP Requests for Theale DB.
@Service
public class APICall {
	RestTemplate restTemplate;
		
	public APICall(){
	restTemplate = new RestTemplate();
	}
	   
	/**
	 * GET's all user info from Theale DB.
	 * @return		An array of "member" objects containing the data.
	 */
	public static ThealeMember[] getAllEntity() {
		RestTemplate restTemplate = new RestTemplate();
		String getUrl = "http://10.31.193.73/api/members"; 
		ThealeMember[] members = restTemplate.getForObject(getUrl, ThealeMember[].class);
	return(members);
	}
	
	/**
	 * POST's data inputted to UI form. 
	 * @param member		Object that contains new data to be sent.
	 */
	public static void postEntity(ThealeMember member) {
		String postUrl = "http://10.31.193.73/api/members";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(postUrl, member, ThealeMember.class);
	}
	
	/**
	 * PUT's data inputted to "EditProfile.html"
	 * @param id		Gets and updates particular data using ID.
	 * @param m		Object containing new data to replace.
	 */
	public static void putEntity(int id, ThealeMember m) {
		String putUrl = String.format("http://10.31.193.73/api/members/%d",id);
		ThealeMember Edit = m;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(putUrl, Edit);
	}
	
	/**
	 * DELETE's data using the ID.
	 * @param id		ID of the chosen data to be used to retrieve for visibility and to delete.
	 */
	public static void deleteEntity(int id) {															
		String deleteUrl = String.format("http://10.31.193.73/api/members/%d",id);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(deleteUrl);
	}
	
	/**
	 * GET's user info using NAME.
	 * @param name		NAME of the chosen data set.
	 * @return			The rest of the data associated with the NAME.
	 */
	public static ThealeMember[] getEntity(String name) {
		RestTemplate restTemplate = new RestTemplate();
		String getUrl = String.format("http://10.31.193.73/api/members/name/%s",name);
		ThealeMember[] member = restTemplate.getForObject(getUrl, ThealeMember[].class);
	return(member);
	}
}