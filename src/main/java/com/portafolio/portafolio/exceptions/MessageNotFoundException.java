package com.portafolio.portafolio.exceptions;

public class MessageNotFoundException extends RuntimeException {
      // Constructor sin mensaje
    public MessageNotFoundException() {
        super();
    }

    // Constructor con mensaje
    public MessageNotFoundException(String message) {
        super(message);
    }

    // Constructor con mensaje y causa
    public MessageNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor con causa
    public MessageNotFoundException(Throwable cause) {
        super(cause);
    }
}

