package mum.ea.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import mum.ea.enums.StatusCode;
import mum.ea.model.EaResultData;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class JwtUtil {

    private static final String secret = "eaSecret";

    public EaResultData<String> encode(JwtUserDetails jwtUserDetails) {
        Claims claims = Jwts.claims().setSubject(jwtUserDetails.getUsername());
        claims.put("username", jwtUserDetails.getUsername());
        claims.put("firstName", jwtUserDetails.getFirstName());
        claims.put("lastName", jwtUserDetails.getLastName());
        claims.put("roles", jwtUserDetails.getRoles());
        claims.put("id", jwtUserDetails.getId());
        EaResultData<String> result = new EaResultData<String>();
        result.setData(Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, secret).compact());
        result.makeSuccess();
        return result;
    }

    public EaResultData<JwtUserDetails> decode(String token) {
        EaResultData<JwtUserDetails> result = new EaResultData<JwtUserDetails>();
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            JwtUserDetails jwtUserDetails = new JwtUserDetails();
            jwtUserDetails.setUsername((String) body.get("username"));
            jwtUserDetails.setFirstName((String) body.get("firstName"));
            jwtUserDetails.setLastName((String) body.get("lastName"));
            jwtUserDetails.setRoles((List<String>) body.get("roles"));
            jwtUserDetails.setId(Long.parseLong(body.get("id").toString()));

            result.setData(jwtUserDetails);
            result.makeSuccess();
        } catch (Exception e) {
            result.setStatusCode(StatusCode.JWT_PARSE_ERROR);
        }
        return result;
    }

}
