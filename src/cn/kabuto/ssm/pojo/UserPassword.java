package cn.kabuto.ssm.pojo;

import javax.validation.constraints.Size;

public class UserPassword  {
	private String password;
	
	@Size(min=6,max=15,message="{user.password.length.error}")
	private String firstPassword;
	
	@Size(min=6,max=15,message="{user.password.length.error}")
	private String SecondPassword;
	public String getFirstPassword() {
		return firstPassword;
	}
	public void setFirstPassword(String firstPassword) {
		this.firstPassword = firstPassword;
	}
	public String getSecondPassword() {
		return SecondPassword;
	}
	public void setSecondPassword(String secondPassword) {
		SecondPassword = secondPassword;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
