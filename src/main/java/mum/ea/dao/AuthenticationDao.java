package mum.ea.dao;

import mum.ea.dto.ExtendedLoginModel;
import mum.ea.dto.LoginModel;
import mum.ea.model.EaResultData;

public interface AuthenticationDao{
    EaResultData<ExtendedLoginModel> login(LoginModel loginModel);
}
