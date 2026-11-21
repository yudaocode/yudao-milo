//
// 此文件是由 Eclipse Implementation of JAXB v4.0.9 生成的
// 请访问 https://eclipse-ee4j.github.io/jaxb-ri 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2026.11.21 时间 07:34:20 PM CST
//

package org.opcfoundation.opcua.binaryschema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 
 * <p>SwitchOperand的 Java 类。</p>
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。</p>
 * <pre>{@code
 * <simpleType name="SwitchOperand">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     <enumeration value="Equals"/>
 *     <enumeration value="GreaterThan"/>
 *     <enumeration value="LessThan"/>
 *     <enumeration value="GreaterThanOrEqual"/>
 *     <enumeration value="LessThanOrEqual"/>
 *     <enumeration value="NotEqual"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "SwitchOperand")
@XmlEnum
public enum SwitchOperand {

    @XmlEnumValue("Equals")
    EQUALS("Equals"),
    @XmlEnumValue("GreaterThan")
    GREATER_THAN("GreaterThan"),
    @XmlEnumValue("LessThan")
    LESS_THAN("LessThan"),
    @XmlEnumValue("GreaterThanOrEqual")
    GREATER_THAN_OR_EQUAL("GreaterThanOrEqual"),
    @XmlEnumValue("LessThanOrEqual")
    LESS_THAN_OR_EQUAL("LessThanOrEqual"),
    @XmlEnumValue("NotEqual")
    NOT_EQUAL("NotEqual");
    private final String value;

    SwitchOperand(String v) {
        value = v;
    }

    /**
     * Gets the value associated to the enum constant.
     * 
     * @return
     *     The value linked to the enum.
     */
    public String value() {
        return value;
    }

    /**
     * Gets the enum associated to the value passed as parameter.
     * 
     * @param v
     *     The value to get the enum from.
     * @return
     *     The enum which corresponds to the value, if it exists.
     * @throws IllegalArgumentException
     *     If no value matches in the enum declaration.
     */
    public static SwitchOperand fromValue(String v) {
        for (SwitchOperand c: SwitchOperand.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
