package com.mycompany.myapp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties specific to Captcha.
 * <p>
 * Properties are configured in the {@code application.yml} file.
 * See {@link io.github.jhipster.config.JHipsterProperties} for a good example.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {
    public final ApplicationProperties.Recaptcha recaptcha = new ApplicationProperties.Recaptcha();

    public ApplicationProperties(){

    }

    public ApplicationProperties.Recaptcha getRecaptcha() {
        return this.recaptcha;
    }

    public static class Recaptcha {
        private String site;
        private String secret;
        private String verify;
        public Recaptcha(){

        }

        public String getSite() {
            return site;
        }

        public void setSite(String site) {
            this.site = site;
        }

        public String getSecret() {
            return secret;
        }

        public void setSecret(String secret) {
            this.secret = secret;
        }

        public String getVerify() {
            return verify;
        }

        public void setVerify(String verify) {
            this.verify = verify;
        }
    }

}
