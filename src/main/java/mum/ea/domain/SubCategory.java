package mum.ea.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import mum.ea.domain.abstracts.BaseDomain;

import javax.persistence.*;
import java.util.List;

@Entity
public class SubCategory extends BaseDomain {

    @Column(name = "name_e")
    private String name;

    @JsonIgnore
    //@JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_category")
    private Category category;

//    @OneToMany(mappedBy = "subCategory")
//    private List<Course> courseList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

//    public List<Course> getCourseList() {
//        return courseList;
//    }
//
//    public void setCourseList(List<Course> courseList) {
//        this.courseList = courseList;
//    }
}
