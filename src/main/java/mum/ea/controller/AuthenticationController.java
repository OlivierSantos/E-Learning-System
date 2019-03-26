package mum.ea.controller;


import mum.ea.controller.abstracts.EaController;
import mum.ea.domain.Member;
import mum.ea.dto.ExtendedLoginModel;
import mum.ea.dto.LoginModel;
import mum.ea.model.EaResult;
import mum.ea.model.EaResultData;
import mum.ea.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController extends EaController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping
    public EaResultData<ExtendedLoginModel> login(@RequestBody LoginModel loginModel) {
        return authenticationService.login(loginModel);
    }

    @PostMapping(path = "/register")
    public EaResult register(@RequestBody Member member) {
      // return new EaResult();
       return authenticationService.register(member);
    }

}
