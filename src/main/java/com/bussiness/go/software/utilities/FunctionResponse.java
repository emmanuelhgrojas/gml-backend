package com.bussiness.go.software.utilities;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Estructura de la Respuesta que devuelve la funcion llamada")
public class FunctionResponse<T> {
	
	private Integer status;
    private String message;
    private Object result;

    public FunctionResponse() {
    }

    public FunctionResponse(String message, Object result) {
        this.message = message;
        this.result = result;
    }
    
    public FunctionResponse(Integer status, String message, Object result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public FunctionResponse(Integer status, String message, Object result, String idUsuario) {
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
