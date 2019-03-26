package mum.ea.amqp;

import mum.ea.dto.CourseDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class CourseNotifierImpl implements CourseNotifier {

    public void publish(RabbitTemplate rabbitTemplate, CourseDto courseDto) {
        //  rabbitTemplate.convertAndSend("newCourseNotifier",courseDto);
        rabbitTemplate.convertAndSend("newCourseNotifier", courseDto.getName());

    }
}
