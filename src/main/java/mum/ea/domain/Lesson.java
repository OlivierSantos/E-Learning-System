package mum.ea.domain;


import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import mum.ea.domain.abstracts.BaseDomain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Lesson extends BaseDomain {


    @Size(min = 6)
    @Column(name = "name_e")
    private String name;

    @Size(min = 10)
    private String description;

    //@JsonIgnore
  //  @JsonBackReference(value = "lessonList")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_course")
    private Course course;

    @JsonIgnore
   // @JsonManagedReference(value = "materialList")
    @OneToMany(mappedBy = "lesson",fetch = FetchType.EAGER)
    private List<Material> materialList;

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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Material> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<Material> materialList) {
        this.materialList = materialList;
    }
}
