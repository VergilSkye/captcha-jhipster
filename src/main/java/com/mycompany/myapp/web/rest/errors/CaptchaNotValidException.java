package com.mycompany.myapp.web.rest.errors;

public class CaptchaNotValidException extends BadRequestAlertException  {

    private static final long serialVersionUID = 1;

    public CaptchaNotValidException() {
        super(ErrorConstants.PROBLEM_BASE_URL, "Captcha not valid!", "captchanotvalid");
    }
}


