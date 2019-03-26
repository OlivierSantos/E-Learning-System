package mum.ea.amqp;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.ea.domain.Command; 
import mum.ea.domain.Material;
import mum.ea.dto.ResourceDto; 
@Service
public class ResourceSvrNotifierImpl implements ResourceSvrNotifier{

//	 ApplicationContext context = new GenericXmlApplicationContext("classpath:META-INF/spring/order-app-context.xml");
	 
	@Autowired
    RabbitTemplate resdirectTemplate; //=  context.getBean("restopicTemplate",RabbitTemplate.class);

	public String getPayload(Long materialID) {
		// TODO Auto-generated method stub
		ResourceDto dto=new ResourceDto();
		dto.setPayLoad(materialID.toString());
		dto.setCommand(Command.GET);
		
		publish(dto);
		
		return "Payload";
	}

	public void savePayload(Material material) {
		// TODO Auto-generated method stub
		ResourceDto dto=new ResourceDto();
		dto.setPayLoad(material.getName().toString());
		dto.setCommand(Command.SAVE);
		
		publish(dto);
	}

	public void deletePayload(Long materialID) {
		// TODO Auto-generated method stub
		ResourceDto dto=new ResourceDto();
		dto.setPayLoad(materialID.toString());
		dto.setCommand(Command.REMOVE);
		
		publish(dto);
	}

	private String publishAndGetResponse(ResourceDto dto) {
		
		 Queue queueReply = new Queue("myQueue_reply");
		 resdirectTemplate.setReplyQueue(queueReply);     
		 Object test = resdirectTemplate.convertSendAndReceive(dto);
		 
		 return (String)test;
	}
	 
	private void publish(ResourceDto dto) {
		resdirectTemplate.convertAndSend(dto);
	}

}
