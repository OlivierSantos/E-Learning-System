package mum.ea.controller;

import mum.ea.batch.MemberBatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/batch")
public class BatchController {

    @Autowired
    private MemberBatch memberBatch;

    @PostMapping
    public void startBatch() {
        memberBatch.startjob();
    }

}
