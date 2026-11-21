//
// 此文件是由 Eclipse Implementation of JAXB v4.0.9 生成的
// 请访问 https://eclipse-ee4j.github.io/jaxb-ri 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2026.11.21 时间 07:34:20 PM CST
//

package org.opcfoundation.opcua.binaryschema;

import java.util.HashMap;
import java.util.Map;
import javax.xml.namespace.QName;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>FieldType complex type的 Java 类。</p>
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。</p>
 * 
 * <pre>{@code
 * <complexType name="FieldType">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element ref="{http://opcfoundation.org/BinarySchema/}Documentation" minOccurs="0"/>
 *       </sequence>
 *       <attribute name="Name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="TypeName" type="{http://www.w3.org/2001/XMLSchema}QName" />
 *       <attribute name="Length" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *       <attribute name="LengthField" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="IsLengthInBytes" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       <attribute name="SwitchField" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="SwitchValue" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *       <attribute name="SwitchOperand" type="{http://opcfoundation.org/BinarySchema/}SwitchOperand" />
 *       <attribute name="Terminator" type="{http://www.w3.org/2001/XMLSchema}hexBinary" />
 *       <anyAttribute processContents='lax'/>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FieldType", propOrder = {
    "documentation"
})
public class FieldType {

    @XmlElement(name = "Documentation")
    protected Documentation documentation;
    @XmlAttribute(name = "Name", required = true)
    protected String name;
    @XmlAttribute(name = "TypeName")
    protected QName typeName;
    @XmlAttribute(name = "Length")
    @XmlSchemaType(name = "unsignedInt")
    protected Long length;
    @XmlAttribute(name = "LengthField")
    protected String lengthField;
    @XmlAttribute(name = "IsLengthInBytes")
    protected Boolean isLengthInBytes;
    @XmlAttribute(name = "SwitchField")
    protected String switchField;
    @XmlAttribute(name = "SwitchValue")
    @XmlSchemaType(name = "unsignedInt")
    protected Long switchValue;
    @XmlAttribute(name = "SwitchOperand")
    protected SwitchOperand switchOperand;
    @XmlAttribute(name = "Terminator")
    @XmlJavaTypeAdapter(HexBinaryAdapter.class)
    @XmlSchemaType(name = "hexBinary")
    protected byte[] terminator;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<>();

    /**
     * 获取documentation属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Documentation }
     *     
     */
    public Documentation getDocumentation() {
        return documentation;
    }

    /**
     * 设置documentation属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Documentation }
     *     
     */
    public void setDocumentation(Documentation value) {
        this.documentation = value;
    }

    /**
     * 获取name属性的值。
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
     * 设置name属性的值。
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
     * 获取typeName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getTypeName() {
        return typeName;
    }

    /**
     * 设置typeName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setTypeName(QName value) {
        this.typeName = value;
    }

    /**
     * 获取length属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLength() {
        return length;
    }

    /**
     * 设置length属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLength(Long value) {
        this.length = value;
    }

    /**
     * 获取lengthField属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLengthField() {
        return lengthField;
    }

    /**
     * 设置lengthField属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLengthField(String value) {
        this.lengthField = value;
    }

    /**
     * 获取isLengthInBytes属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isIsLengthInBytes() {
        if (isLengthInBytes == null) {
            return false;
        } else {
            return isLengthInBytes;
        }
    }

    /**
     * 设置isLengthInBytes属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsLengthInBytes(Boolean value) {
        this.isLengthInBytes = value;
    }

    /**
     * 获取switchField属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSwitchField() {
        return switchField;
    }

    /**
     * 设置switchField属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSwitchField(String value) {
        this.switchField = value;
    }

    /**
     * 获取switchValue属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSwitchValue() {
        return switchValue;
    }

    /**
     * 设置switchValue属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSwitchValue(Long value) {
        this.switchValue = value;
    }

    /**
     * 获取switchOperand属性的值。
     * 
     * @return
     *     possible object is
     *     {@link SwitchOperand }
     *     
     */
    public SwitchOperand getSwitchOperand() {
        return switchOperand;
    }

    /**
     * 设置switchOperand属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link SwitchOperand }
     *     
     */
    public void setSwitchOperand(SwitchOperand value) {
        this.switchOperand = value;
    }

    /**
     * 获取terminator属性的值。
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getTerminator() {
        return terminator;
    }

    /**
     * 设置terminator属性的值。
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setTerminator(byte[] value) {
        this.terminator = value;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
