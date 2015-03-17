package model;
// default package

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;


/**
 * TUser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_user"
    ,catalog="sshe"
)

public class TUser  implements java.io.Serializable {


    // Fields    

     private String id;
     private Date createdate;
     private Date modifydate;
     private String name;
     private String password;


    // Constructors

    /** default constructor */
    public TUser() {
    }

    
    /** full constructor */
    public TUser(Date createdate, Date modifydate, String name, String password) {
        this.createdate = createdate;
        this.modifydate = modifydate;
        this.name = name;
        this.password = password;
    }

   
    // Property accessors
    @GenericGenerator(name="generator", strategy="uuid.string")@Id 
    
    @Column(name="id", unique=true, nullable=false)

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="createdate", length=10)

    public Date getCreatedate() {
        return this.createdate;
    }
    
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="modifydate", length=10)

    public Date getModifydate() {
        return this.modifydate;
    }
    
    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }
    
    @Column(name="name", length=20)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="password", length=36)

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
   








}