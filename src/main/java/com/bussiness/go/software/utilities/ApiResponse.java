package com.bussiness.go.software.utilities;



//@Schema(description = "Estructura de la Respuesta que devuelve el servicio")
public class ApiResponse<T> {

    private int status;
    private String message;
    private Object result;

    public ApiResponse() {
    }

    public ApiResponse(int status, String message, Object result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public ApiResponse(int status, String message, Object result, String idUsuario) {
        this.status = status;
        this.message = message;
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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
