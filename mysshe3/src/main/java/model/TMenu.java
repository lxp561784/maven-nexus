package model;
// default package

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


/**
 * TMenu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_menu"
    ,catalog="sshe"
)

public class TMenu  implements java.io.Serializable {


    // Fields    

     private String id;
     private TMenu TMenu;
     private String iconClx;
     private String text;
     private String url;
     private Set<TMenu> TMenus = new HashSet<TMenu>(0);


    // Constructors

    /** default constructor */
    public TMenu() {
    }

    
    /** full constructor */
    public TMenu(TMenu TMenu, String iconClx, String text, String url, Set<TMenu> TMenus) {
        this.TMenu = TMenu;
        this.iconClx = iconClx;
        this.text = text;
        this.url = url;
        this.TMenus = TMenus;
    }

   
    // Property accessors
    @GenericGenerator(name="generator", strategy="uuid.string")@Id 
    
    @Column(name="id", unique=true, nullable=false, length=36)

    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
	@ManyToOne(fetch=FetchType.LAZY)
        @JoinColumn(name="pid")

    public TMenu getTMenu() {
        return this.TMenu;
    }
    
    public void setTMenu(TMenu TMenu) {
        this.TMenu = TMenu;
    }
    
    @Column(name="iconClx", length=50)

    public String getIconClx() {
        return this.iconClx;
    }
    
    public void setIconClx(String iconClx) {
        this.iconClx = iconClx;
    }
    
    @Column(name="text", length=1000)

    public String getText() {
        return this.text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    @Column(name="url", length=200)

    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="TMenu")

    public Set<TMenu> getTMenus() {
        return this.TMenus;
    }
    
    public void setTMenus(Set<TMenu> TMenus) {
        this.TMenus = TMenus;
    }
   








}