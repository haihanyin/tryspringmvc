package p.hh.trymvc.tma.controller.openid;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RawAuthnRequest {

    @NotNull
    private String[] scope;
    @NotNull
    @Size(max = 1)
    private String[] response_type;
    @NotNull
    @Size(max = 1)
    private String[] client_id;
    @NotNull
    @Size(max = 1)
    private String[] redirect_uri;
    @Size(max = 1)
    private String[] state;
    @Size(max = 1)
    private String[] response_mode;
    @Size(max = 1)
    private String[] nonce;
    @Size(max = 1)
    private String[] display;
    @Size(max = 1)
    private String[] prompt;
    @Size(max = 1)
    private String[] max_age;
    @Size(max = 1)
    private String[] uiLocales;
    @Size(max = 1)
    private String[] id_token_hint;
    @Size(max = 1)
    private String[] login_hint;
    @Size(max = 1)
    private String[] acr_values;
}
