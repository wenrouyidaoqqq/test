package com.lsw.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class RootEntity extends BaseEntity{
	//绑定自己的适配器类，适配希望包含在CData数据块中的javabean成员变量。
	//这里的空值是为了测试，无其他涵义。
	    @XmlJavaTypeAdapter(CDataAdapter.class)
	    private String name;
	    @XmlJavaTypeAdapter(CDataAdapter.class)
	    private String surname;
	    @XmlJavaTypeAdapter(CDataAdapter.class)
	    private String id;
	    @XmlElement(name = "Music") 
	    Music mu;
	    @XmlElement(name = "Video") 
	    Video vd;
	    
	    
	    
	    
	    public Video getVd() {
			return vd;
		}
		public void setVd(Video vd) {
			this.vd = vd;
		}
		public Music getMu() {
			return mu;
		}
		public void setMu(Music mu) {
			this.mu = mu;
		}
		public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    public String getSurname() {
	        return surname;
	    }
	    public void setSurname(String surname) {
	        this.surname = surname;
	    }
	    public String getId() {
	        return id;
	    }
	    public void setId(String id) {
	        this.id = id;
	    }
}
