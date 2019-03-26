package mum.ea.domain;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import mum.ea.domain.abstracts.BaseDomain;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Course extends BaseDomain {

    @Size(min = 6)
    @Column(name = "name_e")
    private String name;

    @Size(min = 10, max=20)
    private String description;

    @JsonIgnore
   // @JsonManagedReference(value = "lessonList")
    @OneToMany(mappedBy = "course" ,fetch = FetchType.EAGER)
    private Set<Lesson> lessonList;


    //@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "instuctor_id")
   // @JsonBackReference(value = "teachingCourseList")
    //@JsonIgnore
    private Member instructor;

    @JsonIgnore
   // @JsonBackReference(value = "courseList")
    @ManyToMany
    @JoinTable(name = "Enrollment",
            joinColumns = {@JoinColumn(name = "id_course")},
            inverseJoinColumns = {@JoinColumn(name = "id_member")})
    private List<Member> joinedMembers;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_sub_category")
    private SubCategory subCategory;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Lesson> getLessonList() {
        return lessonList;
    }

    public void setLessonList(Set<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    public Member getInstructor() {
        return instructor;
    }

    public void setInstructor(Member instructor) {
        this.instructor = instructor;
    }

    public List<Member> getJoinedMembers() {
        return joinedMembers;
    }

    public void setJoinedMembers(List<Member> joinedMembers) {
        this.joinedMembers = joinedMembers;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }
}
