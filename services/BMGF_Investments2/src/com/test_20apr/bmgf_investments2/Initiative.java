/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.test_20apr.bmgf_investments2;

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
 * Initiative generated by hbm2java
 */
@Entity
@Table(name="`Initiative`"
    ,schema="dbo"
)

public class Initiative  implements java.io.Serializable {

    
    private String initiativeId;
    
    private String strategyId;
    
    private String initiativeName;
    
    private Set<Investment> investments = new HashSet<Investment>(0);

    public Initiative() {
    }


    @Id 
    

    @Column(name="`InitiativeID`", length=36)
    public String getInitiativeId() {
        return this.initiativeId;
    }
    
    public void setInitiativeId(String initiativeId) {
        this.initiativeId = initiativeId;
    }

    

    @Column(name="`StrategyID`", length=36)
    public String getStrategyId() {
        return this.strategyId;
    }
    
    public void setStrategyId(String strategyId) {
        this.strategyId = strategyId;
    }

    

    @Column(name="`InitiativeName`")
    public String getInitiativeName() {
        return this.initiativeName;
    }
    
    public void setInitiativeName(String initiativeName) {
        this.initiativeName = initiativeName;
    }

    @OneToMany(fetch=FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy="initiative")
    public Set<Investment> getInvestments() {
        return this.investments;
    }
    
    public void setInvestments(Set<Investment> investments) {
        this.investments = investments;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof Initiative) )
		    return false;

		 Initiative that = (Initiative) o;

		 return ( (this.getInitiativeId()==that.getInitiativeId()) || ( this.getInitiativeId()!=null && that.getInitiativeId()!=null && this.getInitiativeId().equals(that.getInitiativeId()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getInitiativeId() == null ? 0 : this.getInitiativeId().hashCode() );

         return result;
    }


}

