package mum.ea.daoImpl;

import mum.ea.dao.LessonDao;
import mum.ea.dao.abstracts.GenericDaoImpl;
import mum.ea.domain.Lesson;
import org.springframework.stereotype.Repository;

@Repository
public class LessonDaoImpl extends GenericDaoImpl<Lesson> implements LessonDao {
    public LessonDaoImpl() {
        super.domainClass = Lesson.class;
    }
}
