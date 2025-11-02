package com.example.Crm.model;

public class UserModel {

	public String userName;
	public String password;
	public String useratype;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUseratype() {
		return useratype;
	}

	public void setUseratype(String useratype) {
		this.useratype = useratype;
	}

	@Override
	public String toString() {
		return "UserModel [userName=" + userName + ", password=" + password + ", useratype=" + useratype + "]";
	}

}
