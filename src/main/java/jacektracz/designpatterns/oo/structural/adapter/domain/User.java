package jacektracz.designpatterns.oo.structural.adapter.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

// This would normally be placed in a 'domain model' package
@Data // i'm sorry
@AllArgsConstructor 
public class User {
	private String username;
	private String fullName;
	private String workEmail;
	public User( String uname,String fn, String pworkEmail) {
		username = uname;
		this.fullName = fn;
		this.workEmail = pworkEmail;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getWorkEmail() {
		return workEmail;
	}
	public void setWorkEmail(String workEmail) {
		this.workEmail = workEmail;
	}
}
