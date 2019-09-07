package com.mycompany.myapp.web.rest.errors;

public class CaptchaNotValidException extends BadRequestAlertException  {

    private static final long serialVersionUID = 1;

    public CaptchaNotValidException() {
        super(ErrorConstants.CAPTCHA_INVALID_TYPE, "Captcha not valid!", "userManagement","captchanotvalid");
    }
}


