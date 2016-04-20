/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.test_20apr.bmgf_investments;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;


import java.util.Arrays;

import javax.persistence.Transient;
import javax.persistence.CascadeType;
import javax.persistence.UniqueConstraint;



/**
 * Sysdiagrams generated by hbm2java
 */
@Entity
@Table(name="`sysdiagrams`"
    ,schema="dbo"
)

public class Sysdiagrams  implements java.io.Serializable {

    
    private Integer diagramId;
    
    private String name;
    
    private Integer principalId;
    
    private Integer version;
    
    private byte[] definition;

    public Sysdiagrams() {
    }


    @Id @GeneratedValue(strategy=IDENTITY)
    

    @Column(name="`diagram_id`", precision=10)
    public Integer getDiagramId() {
        return this.diagramId;
    }
    
    public void setDiagramId(Integer diagramId) {
        this.diagramId = diagramId;
    }

    

    @Column(name="`name`")
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    

    @Column(name="`principal_id`", precision=10)
    public Integer getPrincipalId() {
        return this.principalId;
    }
    
    public void setPrincipalId(Integer principalId) {
        this.principalId = principalId;
    }

    

    @Column(name="`version`", precision=10)
    public Integer getVersion() {
        return this.version;
    }
    
    public void setVersion(Integer version) {
        this.version = version;
    }

    

    @Column(name="`definition`")
    public byte[] getDefinition() {
        return this.definition;
    }
    
    public void setDefinition(byte[] definition) {
        this.definition = definition;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof Sysdiagrams) )
		    return false;

		 Sysdiagrams that = (Sysdiagrams) o;

		 return ( (this.getDiagramId()==that.getDiagramId()) || ( this.getDiagramId()!=null && that.getDiagramId()!=null && this.getDiagramId().equals(that.getDiagramId()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getDiagramId() == null ? 0 : this.getDiagramId().hashCode() );

         return result;
    }


}
