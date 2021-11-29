package com.home.restful.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author preetham
 */
@XmlRootElement
public class ErrorMessage {

    private String errorCode;
    private String errorMessage;

    public ErrorMessage() {

    }

    public ErrorMessage(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
