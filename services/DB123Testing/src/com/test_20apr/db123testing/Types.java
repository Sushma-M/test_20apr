/*Copyright (c) 2016-2017 testing.com All Rights Reserved.
 This software is the confidential and proprietary information of testing.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing.com*/

package com.test_20apr.db123testing;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/


import javax.persistence.PrimaryKeyJoinColumn;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import java.util.Arrays;

import javax.persistence.Transient;
import javax.persistence.CascadeType;
import javax.persistence.UniqueConstraint;



/**
 * Types generated by hbm2java
 */
@Entity
@Table(name="`Types_`"
    ,schema="dbo"
)

public class Types  implements java.io.Serializable {

    
    private Integer id;
    
    private Byte byteCol;
    
    private Short shortCol;
    
    private Integer intCol;
    
    private BigInteger longCol;
    
    private BigInteger bigIntCol;
    
    private Float floatCol;
    
    private BigInteger doubleCol;
    
    private BigDecimal bigdecCol;
    
    private Character charCol;
    
    private String stringCol;
    
    private String textCol;
    
    private String clobCol;
    
    private Date dateCol;
    
    private Date datetimeCol;
    
    private Date timeCol;
    
    private Date timestampCol;
    
    private Boolean booleanCol;
    
    private byte[] blobCol;

    public Types() {
    }


    @Id @GeneratedValue(strategy=IDENTITY)
    

    @Column(name="`ID`", precision=10)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    

    @Column(name="`ByteCol_`", precision=2)
    public Byte getByteCol() {
        return this.byteCol;
    }
    
    public void setByteCol(Byte byteCol) {
        this.byteCol = byteCol;
    }

    

    @Column(name="`ShortCol_`", precision=4)
    public Short getShortCol() {
        return this.shortCol;
    }
    
    public void setShortCol(Short shortCol) {
        this.shortCol = shortCol;
    }

    

    @Column(name="`IntCol_`", precision=8)
    public Integer getIntCol() {
        return this.intCol;
    }
    
    public void setIntCol(Integer intCol) {
        this.intCol = intCol;
    }

    

    @Column(name="`LongCol_`", precision=18)
    public BigInteger getLongCol() {
        return this.longCol;
    }
    
    public void setLongCol(BigInteger longCol) {
        this.longCol = longCol;
    }

    

    @Column(name="`BigIntCol_`", precision=35)
    public BigInteger getBigIntCol() {
        return this.bigIntCol;
    }
    
    public void setBigIntCol(BigInteger bigIntCol) {
        this.bigIntCol = bigIntCol;
    }

    

    @Column(name="`FloatCol_`", precision=8, scale=4)
    public Float getFloatCol() {
        return this.floatCol;
    }
    
    public void setFloatCol(Float floatCol) {
        this.floatCol = floatCol;
    }

    

    @Column(name="`DoubleCol_`", precision=18)
    public BigInteger getDoubleCol() {
        return this.doubleCol;
    }
    
    public void setDoubleCol(BigInteger doubleCol) {
        this.doubleCol = doubleCol;
    }

    

    @Column(name="`BigdecCol_`", precision=35, scale=10)
    public BigDecimal getBigdecCol() {
        return this.bigdecCol;
    }
    
    public void setBigdecCol(BigDecimal bigdecCol) {
        this.bigdecCol = bigdecCol;
    }

    

    @Column(name="`CharCol_`", length=1)
    public Character getCharCol() {
        return this.charCol;
    }
    
    public void setCharCol(Character charCol) {
        this.charCol = charCol;
    }

    

    @Column(name="`StringCol_`")
    public String getStringCol() {
        return this.stringCol;
    }
    
    public void setStringCol(String stringCol) {
        this.stringCol = stringCol;
    }

    

    @Column(name="`TextCol_`", length=500)
    public String getTextCol() {
        return this.textCol;
    }
    
    public void setTextCol(String textCol) {
        this.textCol = textCol;
    }

    

    @Column(name="`ClobCol_`", length=600)
    public String getClobCol() {
        return this.clobCol;
    }
    
    public void setClobCol(String clobCol) {
        this.clobCol = clobCol;
    }

    @Temporal(TemporalType.DATE)

    @Column(name="`DateCol_`", length=10)
    public Date getDateCol() {
        return this.dateCol;
    }
    
    public void setDateCol(Date dateCol) {
        this.dateCol = dateCol;
    }

    @Temporal(TemporalType.TIMESTAMP)

    @Column(name="`DatetimeCol_`", length=23)
    public Date getDatetimeCol() {
        return this.datetimeCol;
    }
    
    public void setDatetimeCol(Date datetimeCol) {
        this.datetimeCol = datetimeCol;
    }

    @Temporal(TemporalType.TIME)

    @Column(name="`TimeCol_`", length=16)
    public Date getTimeCol() {
        return this.timeCol;
    }
    
    public void setTimeCol(Date timeCol) {
        this.timeCol = timeCol;
    }

    @Temporal(TemporalType.TIMESTAMP)

    @Column(name="`TimestampCol_`", length=27)
    public Date getTimestampCol() {
        return this.timestampCol;
    }
    
    public void setTimestampCol(Date timestampCol) {
        this.timestampCol = timestampCol;
    }

    

    @Column(name="`BooleanCol_`")
    public Boolean getBooleanCol() {
        return this.booleanCol;
    }
    
    public void setBooleanCol(Boolean booleanCol) {
        this.booleanCol = booleanCol;
    }

    

    @Column(name="`BlobCol_`")
    public byte[] getBlobCol() {
        return this.blobCol;
    }
    
    public void setBlobCol(byte[] blobCol) {
        this.blobCol = blobCol;
    }





    public boolean equals(Object o) {
         if (this == o) return true;
		 if ( (o == null )) return false;
		 if ( !(o instanceof Types) )
		    return false;

		 Types that = (Types) o;

		 return ( (this.getId()==that.getId()) || ( this.getId()!=null && that.getId()!=null && this.getId().equals(that.getId()) ) );
    }

    public int hashCode() {
         int result = 17;

         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );

         return result;
    }


}

