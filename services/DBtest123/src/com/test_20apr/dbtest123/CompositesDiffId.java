/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.test_20apr.dbtest123;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Date;
import javax.persistence.Embeddable;


import java.util.Arrays;

import javax.persistence.Transient;
import javax.persistence.CascadeType;
import javax.persistence.UniqueConstraint;



/**
 * CompositesDiffId generated by hbm2java
 */
@Embeddable
public class CompositesDiffId  implements java.io.Serializable {

    
    private Date date1;
    
    private Date timestamp2;
    
    private Date datetime2;
    
    private Date time2;
    
    private Integer id;
    
    private String column7;

    public CompositesDiffId() {
    }


    public Date getDate1() {
        return this.date1;
    }
    
    public void setDate1(Date date1) {
        this.date1 = date1;
    }
    public Date getTimestamp2() {
        return this.timestamp2;
    }
    
    public void setTimestamp2(Date timestamp2) {
        this.timestamp2 = timestamp2;
    }
    public Date getDatetime2() {
        return this.datetime2;
    }
    
    public void setDatetime2(Date datetime2) {
        this.datetime2 = datetime2;
    }
    public Date getTime2() {
        return this.time2;
    }
    
    public void setTime2(Date time2) {
        this.time2 = time2;
    }
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getColumn7() {
        return this.column7;
    }
    
    public void setColumn7(String column7) {
        this.column7 = column7;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof CompositesDiffId) )
		    return false;

		 CompositesDiffId that = (CompositesDiffId) o;

         return ( (this.getDate1()==that.getDate1()) || ( this.getDate1()!=null && that.getDate1()!=null && this.getDate1().equals(that.getDate1()) ) )
 && ( (this.getTimestamp2()==that.getTimestamp2()) || ( this.getTimestamp2()!=null && that.getTimestamp2()!=null && this.getTimestamp2().equals(that.getTimestamp2()) ) )
 && ( (this.getDatetime2()==that.getDatetime2()) || ( this.getDatetime2()!=null && that.getDatetime2()!=null && this.getDatetime2().equals(that.getDatetime2()) ) )
 && ( (this.getTime2()==that.getTime2()) || ( this.getTime2()!=null && that.getTime2()!=null && this.getTime2().equals(that.getTime2()) ) )
 && ( (this.getId()==that.getId()) || ( this.getId()!=null && that.getId()!=null && this.getId().equals(that.getId()) ) )
 && ( (this.getColumn7()==that.getColumn7()) || ( this.getColumn7()!=null && that.getColumn7()!=null && this.getColumn7().equals(that.getColumn7()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getDate1() == null ? 0 : this.getDate1().hashCode() );
         result = 37 * result + ( getTimestamp2() == null ? 0 : this.getTimestamp2().hashCode() );
         result = 37 * result + ( getDatetime2() == null ? 0 : this.getDatetime2().hashCode() );
         result = 37 * result + ( getTime2() == null ? 0 : this.getTime2().hashCode() );
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getColumn7() == null ? 0 : this.getColumn7().hashCode() );

         return result;
    }


}
