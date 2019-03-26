package mum.ea.dto;

public class MailBuilder {

    private MailDto mailDto;

    public MailBuilder(){
        mailDto = new MailDto();
    }

    public MailBuilder buildTo(String to){
        mailDto.setTo(to);
        return this;
    }

    public MailBuilder buildName(String name){
        mailDto.setName(name);
        return this;
    }

    public MailBuilder buildSubject(String subject){
        mailDto.setSubject(subject);
        return this;
    }

    public MailBuilder buildTemplate(String template){
        mailDto.setTemplate(template);
        return this;
    }

    public MailDto build(){
        return mailDto;
    }

}
