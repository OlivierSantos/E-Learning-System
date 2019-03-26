package mum.ea.service;

import mum.ea.domain.Member;
import mum.ea.dto.ExtendedLoginModel;
import mum.ea.dto.LoginModel;
import mum.ea.model.EaResult;
import mum.ea.model.EaResultData;

public interface AuthenticationService {
    EaResultData<ExtendedLoginModel> login(LoginModel loginModel);
    EaResult register(Member member);
}
