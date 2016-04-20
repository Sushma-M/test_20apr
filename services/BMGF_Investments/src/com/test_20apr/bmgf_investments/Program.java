/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.test_20apr.bmgf_investments;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import javax.persistence.PrimaryKeyJoinColumn;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import java.util.Arrays;

import javax.persistence.Transient;
import javax.persistence.CascadeType;
import javax.persistence.UniqueConstraint;



/**
 * Program generated by hbm2java
 */
@Entity
@Table(name="`Program`"
    ,schema="dbo"
)

public class Program  implements java.io.Serializable {

    
    private String programId;
    
    private String programName;
    
    private Set<AttributeCategory> attributeCategories = new HashSet<AttributeCategory>(0);
    
    private Set<Investment> investments = new HashSet<Investment>(0);
    
    private Set<Strategy> strategies = new HashSet<Strategy>(0);

    public Program() {
    }


    @Id 
    

    @Column(name="`ProgramID`", length=36)
    public String getProgramId() {
        return this.programId;
    }
    
    public void setProgramId(String programId) {
        this.programId = programId;
    }

    

    @Column(name="`ProgramName`")
    public String getProgramName() {
        return this.programName;
    }
    
    public void setProgramName(String programName) {
        this.programName = programName;
    }

    @OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="program")
    public Set<AttributeCategory> getAttributeCategories() {
        return this.attributeCategories;
    }
    
    public void setAttributeCategories(Set<AttributeCategory> attributeCategories) {
        this.attributeCategories = attributeCategories;
    }

    @OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="program")
    public Set<Investment> getInvestments() {
        return this.investments;
    }
    
    public void setInvestments(Set<Investment> investments) {
        this.investments = investments;
    }

    @OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="program")
    public Set<Strategy> getStrategies() {
        return this.strategies;
    }
    
    public void setStrategies(Set<Strategy> strategies) {
        this.strategies = strategies;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof Program) )
		    return false;

		 Program that = (Program) o;

		 return ( (this.getProgramId()==that.getProgramId()) || ( this.getProgramId()!=null && that.getProgramId()!=null && this.getProgramId().equals(that.getProgramId()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getProgramId() == null ? 0 : this.getProgramId().hashCode() );

         return result;
    }


}

