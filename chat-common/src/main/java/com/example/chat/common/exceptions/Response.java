package com.example.chat.common.exceptions;

import lombok.Data;

@Data
public class Response<T> {

    private int code;
    private String message;
    private T data;

    public static <T> Response<T> ok() {
        return new Response(0, "ok", (Object)null);
    }

    public static <T> Response<T> ok(T result) {
        return new Response(0, "ok", result);
    }

    public static <T> Response<T> fail(String message) {
        return new Response(-1, message, (Object)null);
    }

    public static <T> Response<T> fail(int code, String message) {
        return new Response(code, message, (Object)null);
    }
    private Response(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
