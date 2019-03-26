package mum.ea.batch;

import mum.ea.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberProcess {

    @Autowired
    MemberService memberService;

    public void start()  {


    }
}
