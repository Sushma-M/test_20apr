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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import java.util.Arrays;

import javax.persistence.Transient;
import javax.persistence.CascadeType;
import javax.persistence.UniqueConstraint;



/**
 * SubInitiative generated by hbm2java
 */
@Entity
@Table(name="`SubInitiative`"
    ,schema="dbo"
)

public class SubInitiative  implements java.io.Serializable {

    
    private String subInitiativeId;
    
    private String subInitiativeName;
    
    private Set<KeyElement> keyElements = new HashSet<KeyElement>(0);
    
    private Initiative initiative;
    
    private Set<Investment> investments = new HashSet<Investment>(0);

    public SubInitiative() {
    }


    @Id 
    

    @Column(name="`SubInitiativeID`", length=36)
    public String getSubInitiativeId() {
        return this.subInitiativeId;
    }
    
    public void setSubInitiativeId(String subInitiativeId) {
        this.subInitiativeId = subInitiativeId;
    }

    

    @Column(name="`SubInitiativeName`")
    public String getSubInitiativeName() {
        return this.subInitiativeName;
    }
    
    public void setSubInitiativeName(String subInitiativeName) {
        this.subInitiativeName = subInitiativeName;
    }

    @OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="subInitiative")
    public Set<KeyElement> getKeyElements() {
        return this.keyElements;
    }
    
    public void setKeyElements(Set<KeyElement> keyElements) {
        this.keyElements = keyElements;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`InitiativeID`")
    public Initiative getInitiative() {
        return this.initiative;
    }
    
    public void setInitiative(Initiative initiative) {
        this.initiative = initiative;
    }

    @OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="subInitiative")
    public Set<Investment> getInvestments() {
        return this.investments;
    }
    
    public void setInvestments(Set<Investment> investments) {
        this.investments = investments;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof SubInitiative) )
		    return false;

		 SubInitiative that = (SubInitiative) o;

		 return ( (this.getSubInitiativeId()==that.getSubInitiativeId()) || ( this.getSubInitiativeId()!=null && that.getSubInitiativeId()!=null && this.getSubInitiativeId().equals(that.getSubInitiativeId()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getSubInitiativeId() == null ? 0 : this.getSubInitiativeId().hashCode() );

         return result;
    }


}

