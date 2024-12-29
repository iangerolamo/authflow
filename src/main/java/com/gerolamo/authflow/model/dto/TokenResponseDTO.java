package com.gerolamo.authflow.model.dto;
import java.util.Date;

public class TokenResponseDTO {

    private String token;
    private String tokenType;
    private Date expiration;

    public TokenResponseDTO() {
    }

    public TokenResponseDTO(String token, String tokenType, Date expiration) {
        this.token = token;
        this.tokenType = tokenType;
        this.expiration = expiration;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }
}
