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
 * AttributeGroup generated by hbm2java
 */
@Entity
@Table(name="`AttributeGroup`"
    ,schema="dbo"
)

public class AttributeGroup  implements java.io.Serializable {

    
    private String attributeGroupId;
    
    private String groupingName;

    public AttributeGroup() {
    }


    @Id 
    

    @Column(name="`AttributeGroupID`", length=36)
    public String getAttributeGroupId() {
        return this.attributeGroupId;
    }
    
    public void setAttributeGroupId(String attributeGroupId) {
        this.attributeGroupId = attributeGroupId;
    }

    

    @Column(name="`GroupingName`")
    public String getGroupingName() {
        return this.groupingName;
    }
    
    public void setGroupingName(String groupingName) {
        this.groupingName = groupingName;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof AttributeGroup) )
		    return false;

		 AttributeGroup that = (AttributeGroup) o;

		 return ( (this.getAttributeGroupId()==that.getAttributeGroupId()) || ( this.getAttributeGroupId()!=null && that.getAttributeGroupId()!=null && this.getAttributeGroupId().equals(that.getAttributeGroupId()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getAttributeGroupId() == null ? 0 : this.getAttributeGroupId().hashCode() );

         return result;
    }


}

