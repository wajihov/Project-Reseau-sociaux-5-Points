package com.fivePoints.security.jwt;

public class JwtResponse {
    private String token;
    //private String user;

    private String type = "Bearer";

    public JwtResponse(String accessToken, String user) {
        this.token = accessToken;
        //this.user = user;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

	/*public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}*/
    
}