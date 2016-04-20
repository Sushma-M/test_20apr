/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.test_20apr.bmgf_investments2;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import java.util.Arrays;

import javax.persistence.Transient;
import javax.persistence.CascadeType;
import javax.persistence.UniqueConstraint;



/**
 * AttributeCategory generated by hbm2java
 */
@Entity
@Table(name="`AttributeCategory`"
    ,schema="dbo"
)

public class AttributeCategory  implements java.io.Serializable {

    
    private String attributeCategoryId;
    
    private String programId;
    
    private String strategyId;
    
    private String attributeGroupId;
    
    private String categoryName;
    
    private Boolean mandatoryAttribute;
    
    private Integer categoryDisplayOrder;

    public AttributeCategory() {
    }


    @Id 
    

    @Column(name="`AttributeCategoryID`", length=36)
    public String getAttributeCategoryId() {
        return this.attributeCategoryId;
    }
    
    public void setAttributeCategoryId(String attributeCategoryId) {
        this.attributeCategoryId = attributeCategoryId;
    }

    

    @Column(name="`ProgramID`", length=36)
    public String getProgramId() {
        return this.programId;
    }
    
    public void setProgramId(String programId) {
        this.programId = programId;
    }

    

    @Column(name="`StrategyID`", length=36)
    public String getStrategyId() {
        return this.strategyId;
    }
    
    public void setStrategyId(String strategyId) {
        this.strategyId = strategyId;
    }

    

    @Column(name="`AttributeGroupID`", length=36)
    public String getAttributeGroupId() {
        return this.attributeGroupId;
    }
    
    public void setAttributeGroupId(String attributeGroupId) {
        this.attributeGroupId = attributeGroupId;
    }

    

    @Column(name="`CategoryName`")
    public String getCategoryName() {
        return this.categoryName;
    }
    
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    

    @Column(name="`MandatoryAttribute`")
    public Boolean getMandatoryAttribute() {
        return this.mandatoryAttribute;
    }
    
    public void setMandatoryAttribute(Boolean mandatoryAttribute) {
        this.mandatoryAttribute = mandatoryAttribute;
    }

    

    @Column(name="`CategoryDisplayOrder`", precision=10)
    public Integer getCategoryDisplayOrder() {
        return this.categoryDisplayOrder;
    }
    
    public void setCategoryDisplayOrder(Integer categoryDisplayOrder) {
        this.categoryDisplayOrder = categoryDisplayOrder;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof AttributeCategory) )
		    return false;

		 AttributeCategory that = (AttributeCategory) o;

		 return ( (this.getAttributeCategoryId()==that.getAttributeCategoryId()) || ( this.getAttributeCategoryId()!=null && that.getAttributeCategoryId()!=null && this.getAttributeCategoryId().equals(that.getAttributeCategoryId()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getAttributeCategoryId() == null ? 0 : this.getAttributeCategoryId().hashCode() );

         return result;
    }


}
