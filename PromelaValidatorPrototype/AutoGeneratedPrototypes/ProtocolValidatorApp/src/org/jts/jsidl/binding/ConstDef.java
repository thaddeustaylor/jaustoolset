//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.02.04 at 04:33:14 PM EST 
//


package org.jts.jsidl.binding;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attGroup ref="{urn:jaus:jsidl:1.0}attribute_field_units"/>
 *       &lt;attribute name="name" use="required" type="{urn:jaus:jsidl:1.0}identifier" />
 *       &lt;attribute name="const_type" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="byte"/>
 *             &lt;enumeration value="short integer"/>
 *             &lt;enumeration value="integer"/>
 *             &lt;enumeration value="long integer"/>
 *             &lt;enumeration value="unsigned byte"/>
 *             &lt;enumeration value="unsigned short integer"/>
 *             &lt;enumeration value="unsigned integer"/>
 *             &lt;enumeration value="unsigned long integer"/>
 *             &lt;enumeration value="float"/>
 *             &lt;enumeration value="long float"/>
 *             &lt;enumeration value="string"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="const_value" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="interpretation" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "const_def")
public class ConstDef {

    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "const_type", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String constType;
    @XmlAttribute(name = "const_value", required = true)
    protected String constValue;
    @XmlAttribute(name = "interpretation")
    @XmlSchemaType(name = "anySimpleType")
    protected String interpretation;
    @XmlAttribute(name = "field_units", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String fieldUnits;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the constType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConstType() {
        return constType;
    }

    /**
     * Sets the value of the constType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConstType(String value) {
        this.constType = value;
    }

    /**
     * Gets the value of the constValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConstValue() {
        return constValue;
    }

    /**
     * Sets the value of the constValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConstValue(String value) {
        this.constValue = value;
    }

    /**
     * Gets the value of the interpretation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterpretation() {
        return interpretation;
    }

    /**
     * Sets the value of the interpretation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterpretation(String value) {
        this.interpretation = value;
    }

    /**
     * Gets the value of the fieldUnits property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldUnits() {
        return fieldUnits;
    }

    /**
     * Sets the value of the fieldUnits property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldUnits(String value) {
        this.fieldUnits = value;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    @Override
    public boolean equals(Object that) {
        String[] ignore={"interpretation"};
		return EqualsBuilder.reflectionEquals(this, that, ignore);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

}
