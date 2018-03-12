package com.portfolio.yshome.domain;

public class MemberDTO {

	private String id;
	private String pw;
	private String name;
	private String nick;
	private String addr;
	private String email;
	private String birth;
	private String status;
	
	public MemberDTO() {
	}

	public MemberDTO(String id, String pw, String name, String nick, String addr, String email, String birth,
			String status) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.nick = nick;
		this.addr = addr;
		this.email = email;
		this.birth = birth;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "MemberDTO [id = " + id + ", pw = " + pw + ", name = " + name 
				+ ", nick = " + nick + ", addr = " + addr + ", email = " + email 
				+ ", birth = " + birth + ", status = " + status 
				+ "]";
	}
}
