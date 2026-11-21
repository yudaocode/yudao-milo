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
 * <p>StructuredType complex type的 Java 类。</p>
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。</p>
 * 
 * <pre>{@code
 * <complexType name="StructuredType">
 *   <complexContent>
 *     <extension base="{http://opcfoundation.org/BinarySchema/}TypeDescription">
 *       <sequence>
 *         <element name="Field" type="{http://opcfoundation.org/BinarySchema/}FieldType" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "StructuredType", propOrder = {
    "field"
})
public class StructuredType
    extends TypeDescription
{

    @XmlElement(name = "Field")
    protected List<FieldType> field;

    /**
     * Gets the value of the field property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore, any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the field property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getField().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FieldType }
     * </p>
     * 
     * 
     * @return
     *     The value of the field property.
     */
    public List<FieldType> getField() {
        if (field == null) {
            field = new ArrayList<>();
        }
        return this.field;
    }

}
