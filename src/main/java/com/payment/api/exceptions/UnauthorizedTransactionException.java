package com.payment.api.exceptions;

public class UnauthorizedTransactionException extends RuntimeException {

    public UnauthorizedTransactionException()  {
        super("Unauthorized transaction");
    }
}
