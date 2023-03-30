package com.bichcon.pe.app.dto;

public class TokenDTO {
    private String tipoToken;
    private String token;

    public TokenDTO() {

    }

    public String getTipoToken() {
        return tipoToken;
    }

    public void setTipoToken(String tipoToken) {
        this.tipoToken = tipoToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public TokenDTO(String tipoToken, String token) {
        this.tipoToken = tipoToken;
        this.token = token;
    }
}
