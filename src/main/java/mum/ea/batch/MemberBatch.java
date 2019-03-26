package mum.ea.batch;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MemberBatch {

    @Autowired
    private Job saveMembers;

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private MemberProcess memberProcess;

    public void startjob() {

        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();

            JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
            jobParametersBuilder.addDate("date", new Date());
            JobParameters jobParameters = jobParametersBuilder.toJobParameters();
            JobExecution jobExecution = jobLauncher.run(saveMembers, jobParameters);
            BatchStatus batchStatus = jobExecution.getStatus();
            JobInstance jobInstance = jobExecution.getJobInstance();

            memberProcess.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
