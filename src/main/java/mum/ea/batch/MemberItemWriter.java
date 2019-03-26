package mum.ea.batch;

import mum.ea.domain.Member;
import mum.ea.service.MemberService;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MemberItemWriter implements ItemWriter<Member> {

    @Autowired
    private MemberService memberService;

    public void write(List<? extends Member> list) throws Exception {
        for (Member member : list){
            memberService.save(member);
        }
    }
}
