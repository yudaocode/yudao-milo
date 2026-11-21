//
// 此文件是由 Eclipse Implementation of JAXB v4.0.9 生成的
// 请访问 https://eclipse-ee4j.github.io/jaxb-ri 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2026.11.21 时间 07:34:20 PM CST
//

package org.opcfoundation.opcua.binaryschema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。</p>
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。</p>
 * 
 * <pre>{@code
 * <complexType>
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element ref="{http://opcfoundation.org/BinarySchema/}Documentation" minOccurs="0"/>
 *         <element name="Import" type="{http://opcfoundation.org/BinarySchema/}ImportDirective" maxOccurs="unbounded" minOccurs="0"/>
 *         <choice maxOccurs="unbounded" minOccurs="0">
 *           <element name="OpaqueType" type="{http://opcfoundation.org/BinarySchema/}OpaqueType"/>
 *           <element name="EnumeratedType" type="{http://opcfoundation.org/BinarySchema/}EnumeratedType"/>
 *           <element name="StructuredType" type="{http://opcfoundation.org/BinarySchema/}StructuredType"/>
 *         </choice>
 *       </sequence>
 *       <attribute name="TargetNamespace" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="DefaultByteOrder" type="{http://opcfoundation.org/BinarySchema/}ByteOrder" />
 *       <anyAttribute processContents='lax'/>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "documentation",
    "_import",
    "opaqueTypeOrEnumeratedTypeOrStructuredType"
})
@XmlRootElement(name = "TypeDictionary")
public class TypeDictionary {

    @XmlElement(name = "Documentation")
    protected Documentation documentation;
    @XmlElement(name = "Import")
    protected List<ImportDirective> _import;
    @XmlElements({
        @XmlElement(name = "OpaqueType", type = OpaqueType.class),
        @XmlElement(name = "EnumeratedType", type = EnumeratedType.class),
        @XmlElement(name = "StructuredType", type = StructuredType.class)
    })
    protected List<TypeDescription> opaqueTypeOrEnumeratedTypeOrStructuredType;
    @XmlAttribute(name = "TargetNamespace", required = true)
    protected String targetNamespace;
    @XmlAttribute(name = "DefaultByteOrder")
    protected ByteOrder defaultByteOrder;
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
     * Gets the value of the import property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore, any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the import property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getImport().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportDirective }
     * </p>
     * 
     * 
     * @return
     *     The value of the import property.
     */
    public List<ImportDirective> getImport() {
        if (_import == null) {
            _import = new ArrayList<>();
        }
        return this._import;
    }

    /**
     * Gets the value of the opaqueTypeOrEnumeratedTypeOrStructuredType property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore, any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the opaqueTypeOrEnumeratedTypeOrStructuredType property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getOpaqueTypeOrEnumeratedTypeOrStructuredType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EnumeratedType }
     * {@link OpaqueType }
     * {@link StructuredType }
     * </p>
     * 
     * 
     * @return
     *     The value of the opaqueTypeOrEnumeratedTypeOrStructuredType property.
     */
    public List<TypeDescription> getOpaqueTypeOrEnumeratedTypeOrStructuredType() {
        if (opaqueTypeOrEnumeratedTypeOrStructuredType == null) {
            opaqueTypeOrEnumeratedTypeOrStructuredType = new ArrayList<>();
        }
        return this.opaqueTypeOrEnumeratedTypeOrStructuredType;
    }

    /**
     * 获取targetNamespace属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetNamespace() {
        return targetNamespace;
    }

    /**
     * 设置targetNamespace属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetNamespace(String value) {
        this.targetNamespace = value;
    }

    /**
     * 获取defaultByteOrder属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ByteOrder }
     *     
     */
    public ByteOrder getDefaultByteOrder() {
        return defaultByteOrder;
    }

    /**
     * 设置defaultByteOrder属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ByteOrder }
     *     
     */
    public void setDefaultByteOrder(ByteOrder value) {
        this.defaultByteOrder = value;
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
