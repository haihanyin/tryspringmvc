package p.hh.trymvc.tma.controller.openid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthnController {

    @GetMapping("/authorize")
    public void authorize(@Valid @ModelAttribute RawAuthnRequest rawAuthnRequest, BindingResult result) {
        System.out.println(rawAuthnRequest);
        for (ObjectError allError : result.getAllErrors()) {
            System.out.println(allError);
        }
    }

}
