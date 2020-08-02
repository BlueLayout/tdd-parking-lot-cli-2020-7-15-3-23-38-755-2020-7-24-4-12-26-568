package com.oocl.cultivation.Constant;

public enum  ExceptionMessage {

    NO_ENOUGH_POSITION("Not enough position."),
    NO_PARKING_TICKET("Please provide your parking ticket."),
    UNRECOGNIZED_PARKING_TICKET("Unrecognized parking ticket."),
    NO_AVAILABLE_PARKABLE("No available parkable");

    String exceptionMessage;

    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getMessage(){
        return exceptionMessage;
    }

}
