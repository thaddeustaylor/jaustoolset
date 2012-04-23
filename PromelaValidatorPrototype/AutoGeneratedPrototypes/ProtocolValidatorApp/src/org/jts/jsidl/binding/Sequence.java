//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.02.04 at 04:33:14 PM EST 
//


package org.jts.jsidl.binding;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
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
 *       &lt;sequence>
 *         &lt;element ref="{urn:jaus:jsidl:1.0}presence_vector" minOccurs="0"/>
 *         &lt;choice maxOccurs="unbounded">
 *           &lt;element ref="{urn:jaus:jsidl:1.0}record"/>
 *           &lt;element ref="{urn:jaus:jsidl:1.0}declared_record"/>
 *           &lt;element ref="{urn:jaus:jsidl:1.0}list"/>
 *           &lt;element ref="{urn:jaus:jsidl:1.0}declared_list"/>
 *           &lt;element ref="{urn:jaus:jsidl:1.0}variant"/>
 *           &lt;element ref="{urn:jaus:jsidl:1.0}declared_variant"/>
 *           &lt;element ref="{urn:jaus:jsidl:1.0}sequence"/>
 *           &lt;element ref="{urn:jaus:jsidl:1.0}declared_sequence"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{urn:jaus:jsidl:1.0}identifier" />
 *       &lt;attribute name="optional" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="interpretation" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "presenceVector",
    "recordOrDeclaredRecordOrList"
})
@XmlRootElement(name = "sequence")
public class Sequence {

    @XmlElement(name = "presence_vector")
    protected PresenceVector presenceVector;
    @XmlElements({
        @XmlElement(name = "variant", type = Variant.class),
        @XmlElement(name = "list", type = org.jts.jsidl.binding.List.class),
        @XmlElement(name = "declared_record", type = DeclaredRecord.class),
        @XmlElement(name = "declared_sequence", type = DeclaredSequence.class),
        @XmlElement(name = "record", type = Record.class),
        @XmlElement(name = "sequence", type = Sequence.class),
        @XmlElement(name = "declared_list", type = DeclaredList.class),
        @XmlElement(name = "declared_variant", type = DeclaredVariant.class)
    })
    protected java.util.List<Object> recordOrDeclaredRecordOrList;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "optional", required = true)
    protected boolean optional;
    @XmlAttribute(name = "interpretation")
    @XmlSchemaType(name = "anySimpleType")
    protected String interpretation;

    /**
     * Gets the value of the presenceVector property.
     * 
     * @return
     *     possible object is
     *     {@link PresenceVector }
     *     
     */
    public PresenceVector getPresenceVector() {
        return presenceVector;
    }

    /**
     * Sets the value of the presenceVector property.
     * 
     * @param value
     *     allowed object is
     *     {@link PresenceVector }
     *     
     */
    public void setPresenceVector(PresenceVector value) {
        this.presenceVector = value;
    }

    /**
     * Gets the value of the recordOrDeclaredRecordOrList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the recordOrDeclaredRecordOrList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecordOrDeclaredRecordOrList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Variant }
     * {@link org.jts.jsidl.binding.List }
     * {@link DeclaredRecord }
     * {@link DeclaredSequence }
     * {@link Record }
     * {@link Sequence }
     * {@link DeclaredList }
     * {@link DeclaredVariant }
     * 
     * 
     */
    public java.util.List<Object> getRecordOrDeclaredRecordOrList() {
        if (recordOrDeclaredRecordOrList == null) {
            recordOrDeclaredRecordOrList = new ArrayList<Object>();
        }
        return this.recordOrDeclaredRecordOrList;
    }

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
     * Gets the value of the optional property.
     * 
     */
    public boolean isOptional() {
        return optional;
    }

    /**
     * Sets the value of the optional property.
     * 
     */
    public void setOptional(boolean value) {
        this.optional = value;
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
