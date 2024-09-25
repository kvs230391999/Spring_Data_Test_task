package org.example.app.network;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseMessage {

    SMTH_WRONG("Something wrong!"),
    NO_DATA("No data."),
    DELETED("Deleted.");

    private final String resMsg;
}
