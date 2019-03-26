package mum.ea.serviceImpl;

import mum.ea.dao.AuthenticationDao;
import mum.ea.dao.MemberDao;
import mum.ea.domain.Member;
import mum.ea.domain.Roles;
import mum.ea.dto.ExtendedLoginModel;
import mum.ea.dto.LoginModel;
import mum.ea.dto.MailBuilder;
import mum.ea.dto.MailDto;
import mum.ea.mail.EaMailSender;
import mum.ea.model.EaResult;
import mum.ea.model.EaResultData;
import mum.ea.security.JwtUserDetails;
import mum.ea.security.JwtUtil;
import mum.ea.service.AuthenticationService;
import mum.ea.utilities.email.ApplicationMailer;
import mum.ea.validation.EaValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private AuthenticationDao authenticationDao;

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private EaMailSender eaMailSender;
    
    
    @Autowired
	ApplicationMailer applicationMailer;
	

    @EaValidate
    public EaResult register(Member member) {

        if (member.getIdMemberType() == 1) {
            List<Roles> roles = new ArrayList<Roles>();

            Roles roles1 = new Roles();
            roles1.setId(1L);
            roles.add(roles1);

            Roles roles2 = new Roles();
            roles2.setId(2L);
            roles.add(roles2);

            Roles roles3 = new Roles();
            roles3.setId(3L);
            roles.add(roles3);

            Roles roles4 = new Roles();
            roles4.setId(4L);
            roles.add(roles4);

            member.setRoleList(roles);
        } else {
            List<Roles> roles = new ArrayList<Roles>();

            Roles roles1 = new Roles();
            roles1.setId(4L);
            roles.add(roles1);

            member.setRoleList(roles);
        }


        EaResult result = memberDao.save(member);

        if (result.isSuccess()) {
//            MailBuilder mailBuilder = new MailBuilder();
//            MailDto mailDto = mailBuilder.buildTo(member.getMail())
//                    .buildName(member.getFirstname() + " " + member.getLastname())
//                    .buildSubject("Welcome to TA TEAM")
//                    .buildTemplate("welcomeTemp")
//                    .build();
//            eaMailSender.sendMail(mailDto);
        	
        	applicationMailer.sendMail(member.getMail(), "Welcome", "Tomorrow meeting is necessary");
    		
        }

        return result;
    }

    public EaResultData<ExtendedLoginModel> login(LoginModel loginModel) {
        EaResultData<ExtendedLoginModel> result = authenticationDao.login(loginModel);
        if (result.isSuccess()) {
            // generate token
            JwtUserDetails jwtUserDetails = new JwtUserDetails();
            jwtUserDetails.setUsername(loginModel.getUsername());
            jwtUserDetails.setId(result.getData().getId());

            //fetch roles

            jwtUserDetails.setRoles(result.getData().getRoleList());
            EaResultData<String> tokenRes = jwtUtil.encode(jwtUserDetails);
            if (tokenRes.isSuccess()) {
                result.getData().setToken(tokenRes.getData());
                result.makeSuccess();
            }

        }
        return result;
    }
}
