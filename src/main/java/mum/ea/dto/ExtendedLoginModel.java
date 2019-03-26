package mum.ea.dto;

import java.util.List;

public class ExtendedLoginModel extends LoginModel {
    private String token;
    private Long id;
    private Long memberType;
    private List<String> roleList;

    public List<String> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<String> roleList) {
        this.roleList = roleList;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

	public void setId(Long id) {
		
	    this.id=id;
		
	}
	
	public Long getId() {
		return id;
	}

	public Long getMemberType() {
		return memberType;
	}

	public void setMemberType(Long memberType) {
		this.memberType = memberType;
	}
	
	
}
