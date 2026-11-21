//
// 此文件是由 Eclipse Implementation of JAXB v4.0.9 生成的
// 请访问 https://eclipse-ee4j.github.io/jaxb-ri 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2026.11.21 时间 07:34:20 PM CST
//

package org.opcfoundation.opcua.binaryschema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>EnumeratedType complex type的 Java 类。</p>
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。</p>
 * 
 * <pre>{@code
 * <complexType name="EnumeratedType">
 *   <complexContent>
 *     <extension base="{http://opcfoundation.org/BinarySchema/}OpaqueType">
 *       <sequence>
 *         <element name="EnumeratedValue" type="{http://opcfoundation.org/BinarySchema/}EnumeratedValue" maxOccurs="unbounded"/>
 *       </sequence>
 *       <anyAttribute processContents='lax'/>
 *     </extension>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnumeratedType", propOrder = {
    "enumeratedValue"
})
public class EnumeratedType
    extends OpaqueType
{

    @XmlElement(name = "EnumeratedValue", required = true)
    protected List<EnumeratedValue> enumeratedValue;

    /**
     * Gets the value of the enumeratedValue property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore, any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the enumeratedValue property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getEnumeratedValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EnumeratedValue }
     * </p>
     * 
     * 
     * @return
     *     The value of the enumeratedValue property.
     */
    public List<EnumeratedValue> getEnumeratedValue() {
        if (enumeratedValue == null) {
            enumeratedValue = new ArrayList<>();
        }
        return this.enumeratedValue;
    }

}
