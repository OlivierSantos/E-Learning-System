package mum.ea.amqp;

import mum.ea.dto.CourseDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public interface CourseNotifier {
     void publish(RabbitTemplate rabbitTemplate, CourseDto courseDto);
}
