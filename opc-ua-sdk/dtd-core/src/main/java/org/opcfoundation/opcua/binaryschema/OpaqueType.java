//
// 此文件是由 Eclipse Implementation of JAXB v4.0.9 生成的
// 请访问 https://eclipse-ee4j.github.io/jaxb-ri 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2026.11.21 时间 07:34:20 PM CST
//

package org.opcfoundation.opcua.binaryschema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>OpaqueType complex type的 Java 类。</p>
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。</p>
 * 
 * <pre>{@code
 * <complexType name="OpaqueType">
 *   <complexContent>
 *     <extension base="{http://opcfoundation.org/BinarySchema/}TypeDescription">
 *       <attribute name="LengthInBits" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       <attribute name="ByteOrderSignificant" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       <anyAttribute processContents='lax'/>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OpaqueType")
@XmlSeeAlso({
    EnumeratedType.class
})
public class OpaqueType
    extends TypeDescription
{

    @XmlAttribute(name = "LengthInBits")
    protected Integer lengthInBits;
    @XmlAttribute(name = "ByteOrderSignificant")
    protected Boolean byteOrderSignificant;

    /**
     * 获取lengthInBits属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLengthInBits() {
        return lengthInBits;
    }

    /**
     * 设置lengthInBits属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLengthInBits(Integer value) {
        this.lengthInBits = value;
    }

    /**
     * 获取byteOrderSignificant属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isByteOrderSignificant() {
        if (byteOrderSignificant == null) {
            return false;
        } else {
            return byteOrderSignificant;
        }
    }

    /**
     * 设置byteOrderSignificant属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setByteOrderSignificant(Boolean value) {
        this.byteOrderSignificant = value;
    }

}
