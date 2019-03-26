package mum.ea.security;

import mum.ea.exceptions.EaAuthenticationException;
import mum.ea.model.EaResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private JwtUtil jwtUtil;


    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken)
            throws AuthenticationException {

    }


    @Override
    public UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {

        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) usernamePasswordAuthenticationToken;
        String token = jwtAuthenticationToken.getToken();

        EaResultData<JwtUserDetails> jwtUserDetailsRes = jwtUtil.decode(token);
        if (!jwtUserDetailsRes.isSuccess()) {
            throw new EaAuthenticationException("ad-----------------------");
        }

        //TODO TEST
        String csvRoles = String.join(",", jwtUserDetailsRes.getData().getRoles());
        List<GrantedAuthority> grantedAuthorities =AuthorityUtils.commaSeparatedStringToAuthorityList(csvRoles);
        jwtUserDetailsRes.getData().setAuthorities(grantedAuthorities);


        return jwtUserDetailsRes.getData();
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return (JwtAuthenticationToken.class.isAssignableFrom(aClass));
    }
}
