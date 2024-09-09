package com.payment.api.exceptions;

public class TransferNotFoundException extends  RuntimeException {

    public TransferNotFoundException() {
        super("Transfer not found");
    }
}
