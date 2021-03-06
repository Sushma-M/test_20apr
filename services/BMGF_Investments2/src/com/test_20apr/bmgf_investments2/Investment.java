/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.test_20apr.bmgf_investments2;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import java.util.Arrays;

import javax.persistence.Transient;
import javax.persistence.CascadeType;
import javax.persistence.UniqueConstraint;



/**
 * Investment generated by hbm2java
 */
@Entity
@Table(name="`Investment`"
    ,schema="dbo"
)

public class Investment  implements java.io.Serializable {

    
    private String investmentId;
    
    private String investmentIdentifier;
    
    private String investmentName;
    
    private String notes;
    
    private KeyElement keyElement;
    
    private Status status;
    
    private Initiative initiative;
    
    private Program program;
    
    private Strategy strategy;
    
    private SubInitiative subInitiative;

    public Investment() {
    }


    @Id 
    

    @Column(name="`InvestmentID`", length=36)
    public String getInvestmentId() {
        return this.investmentId;
    }
    
    public void setInvestmentId(String investmentId) {
        this.investmentId = investmentId;
    }

    

    @Column(name="`InvestmentIdentifier`")
    public String getInvestmentIdentifier() {
        return this.investmentIdentifier;
    }
    
    public void setInvestmentIdentifier(String investmentIdentifier) {
        this.investmentIdentifier = investmentIdentifier;
    }

    

    @Column(name="`InvestmentName`")
    public String getInvestmentName() {
        return this.investmentName;
    }
    
    public void setInvestmentName(String investmentName) {
        this.investmentName = investmentName;
    }

    

    @Column(name="`Notes`")
    public String getNotes() {
        return this.notes;
    }
    
    public void setNotes(String notes) {
        this.notes = notes;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`KeyElementID`")
    public KeyElement getKeyElement() {
        return this.keyElement;
    }
    
    public void setKeyElement(KeyElement keyElement) {
        this.keyElement = keyElement;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`StatusID`")
    public Status getStatus() {
        return this.status;
    }
    
    public void setStatus(Status status) {
        this.status = status;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`InitiativeID`")
    public Initiative getInitiative() {
        return this.initiative;
    }
    
    public void setInitiative(Initiative initiative) {
        this.initiative = initiative;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`ProgramID`")
    public Program getProgram() {
        return this.program;
    }
    
    public void setProgram(Program program) {
        this.program = program;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`StrategyID`")
    public Strategy getStrategy() {
        return this.strategy;
    }
    
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="`SubInitiativeID`")
    public SubInitiative getSubInitiative() {
        return this.subInitiative;
    }
    
    public void setSubInitiative(SubInitiative subInitiative) {
        this.subInitiative = subInitiative;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof Investment) )
		    return false;

		 Investment that = (Investment) o;

		 return ( (this.getInvestmentId()==that.getInvestmentId()) || ( this.getInvestmentId()!=null && that.getInvestmentId()!=null && this.getInvestmentId().equals(that.getInvestmentId()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getInvestmentId() == null ? 0 : this.getInvestmentId().hashCode() );

         return result;
    }


}

