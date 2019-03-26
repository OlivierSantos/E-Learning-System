package mum.ea.domain;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import mum.ea.domain.abstracts.BaseDomain;
import mum.ea.validation.AdvancedGroup;
import mum.ea.validation.StandardGroup;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Member extends BaseDomain {

    @NotEmpty
    @Size(min = 5, max = 100)
    private String firstname;

    @NotEmpty
    @Size(min = 5, max = 100)
    private String lastname;

    @NotEmpty
    @Size(min = 5, max = 20)
    private String username;

    @Size(min = 6, max = 100)
    @NotEmpty
    @Column(name = "password_d")
    private String password;
    
    @Email(message= "Invalid Email")
    private String mail;

    @Transient
    private boolean isForBatch = false;

    @OneToOne
    @JoinColumn(name = "id_member_type")
    private MemberType memberType;

    @Transient
    private Long idMemberType;


    //@JsonIgnore
    // @JsonManagedReference(value = "courseList")
    @ManyToMany(mappedBy = "joinedMembers", fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
    @Fetch(value = FetchMode.SELECT)
    @BatchSize(size = 3)
    private List<Course> courseList;

    //@JsonIgnore
    //@JsonManagedReference(value = "teachingCourseList")
    @OneToMany(mappedBy = "instructor", fetch = FetchType.EAGER)
    private List<Course> teachingCourseList;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinTable(name = "member_role_rel", inverseJoinColumns = {@JoinColumn(unique = false)})
    private List<Roles> roleList;

    public Long getIdMemberType() {
        return idMemberType;
    }

    public void setIdMemberType(Long idMemberType) {
        this.idMemberType = idMemberType;
    }

    public boolean isForBatch() {
        return isForBatch;
    }

    public void setForBatch(boolean forBatch) {
        isForBatch = forBatch;
    }

    public List<Roles> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Roles> roleList) {
        this.roleList = roleList;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Course> getTeachingCourseList() {
        return teachingCourseList;
    }

    public void setTeachingCourseList(List<Course> teachingCourseList) {
        this.teachingCourseList = teachingCourseList;
    }
}
