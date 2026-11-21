/*
 * Copyright (c) 2025 the Eclipse Milo Authors
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.milo.opcua.stack.core.encoding.xml.args;

import java.util.UUID;
import java.util.stream.Stream;
import org.eclipse.milo.opcua.stack.core.encoding.DefaultEncodingContext;
import org.eclipse.milo.opcua.stack.core.encoding.xml.OpcUaDefaultXmlEncoding;
import org.eclipse.milo.opcua.stack.core.types.builtin.ByteString;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.DateTime;
import org.eclipse.milo.opcua.stack.core.types.builtin.DiagnosticInfo;
import org.eclipse.milo.opcua.stack.core.types.builtin.ExpandedNodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.ExtensionObject;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.builtin.Matrix;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.QualifiedName;
import org.eclipse.milo.opcua.stack.core.types.builtin.StatusCode;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.builtin.XmlElement;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UByte;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.ULong;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UShort;
import org.eclipse.milo.opcua.stack.core.types.enumerated.ApplicationType;
import org.eclipse.milo.opcua.stack.core.types.enumerated.NodeClass;
import org.eclipse.milo.opcua.stack.core.types.structured.AccessLevelType;
import org.eclipse.milo.opcua.stack.core.types.structured.Argument;
import org.eclipse.milo.opcua.stack.core.types.structured.AttributeWriteMask;
import org.eclipse.milo.opcua.stack.core.types.structured.XVType;
import org.junit.jupiter.params.provider.Arguments;

@SuppressWarnings("unused")
public class VariantArguments {

  public static Stream<Arguments> variantOfScalarArguments() {
    return Stream.of(
        // Boolean
        Arguments.of(
            Variant.of(false),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:Boolean>false</uax:Boolean>\n  </uax:Value>\n</Test>\n"),

        // SByte
        Arguments.of(
            Variant.of((byte) 0),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:SByte>0</uax:SByte>\n  </uax:Value>\n</Test>\n"),

        // Byte
        Arguments.of(
            Variant.of(UByte.MIN),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:Byte>0</uax:Byte>\n  </uax:Value>\n</Test>\n"),

        // Int16
        Arguments.of(
            Variant.of((short) 0),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:Int16>0</uax:Int16>\n  </uax:Value>\n</Test>\n"),

        // UInt16
        Arguments.of(
            Variant.of(UShort.MIN),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:UInt16>0</uax:UInt16>\n  </uax:Value>\n</Test>\n"),

        // Int32
        Arguments.of(
            Variant.of(0),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:Int32>0</uax:Int32>\n  </uax:Value>\n</Test>\n"),

        // UInt32
        Arguments.of(
            Variant.of(UInteger.MIN),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:UInt32>0</uax:UInt32>\n  </uax:Value>\n</Test>\n"),

        // Int64
        Arguments.of(
            Variant.of(0L),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:Int64>0</uax:Int64>\n  </uax:Value>\n</Test>\n"),

        // UInt64
        Arguments.of(
            Variant.of(ULong.MIN),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:UInt64>0</uax:UInt64>\n  </uax:Value>\n</Test>\n"),

        // Float
        Arguments.of(
            Variant.of(0.0f),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:Float>0.0</uax:Float>\n  </uax:Value>\n</Test>\n"),

        // Double
        Arguments.of(
            Variant.of(0.0),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:Double>0.0</uax:Double>\n  </uax:Value>\n</Test>\n"),

        // String
        Arguments.of(
            Variant.of(""),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:String></uax:String>\n  </uax:Value>\n</Test>\n"),

        // DateTime
        Arguments.of(
            Variant.of(DateTime.NULL_VALUE),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:DateTime>1601-01-01T00:00:00Z</uax:DateTime>\n  </uax:Value>\n</Test>\n"),

        // Guid
        Arguments.of(
            Variant.of(new UUID(0L, 0L)),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:Guid>00000000-0000-0000-0000-000000000000</uax:Guid>\n  </uax:Value>\n</Test>\n"),

        // ByteString
        Arguments.of(
            Variant.of(ByteString.NULL_VALUE),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:ByteString></uax:ByteString>\n  </uax:Value>\n</Test>\n"),

        // XmlElement
        Arguments.of(
            Variant.of(XmlElement.NULL_VALUE),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:XmlElement></uax:XmlElement>\n  </uax:Value>\n</Test>\n"),

        // NodeId
        Arguments.of(
            Variant.of(NodeId.NULL_VALUE),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:NodeId>\n      <uax:Identifier>i=0</uax:Identifier>\n    </uax:NodeId>\n  </uax:Value>\n</Test>\n"),

        // ExpandedNodeId
        Arguments.of(
            Variant.of(ExpandedNodeId.NULL_VALUE),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:ExpandedNodeId>\n      <uax:Identifier>i=0</uax:Identifier>\n    </uax:ExpandedNodeId>\n  </uax:Value>\n</Test>\n"),

        // StatusCode
        Arguments.of(
            Variant.of(StatusCode.GOOD),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:StatusCode>\n      <uax:Code>0</uax:Code>\n    </uax:StatusCode>\n  </uax:Value>\n</Test>\n"),

        // QualifiedName
        Arguments.of(
            Variant.of(QualifiedName.NULL_VALUE),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:QualifiedName>\n      <uax:NamespaceIndex>0</uax:NamespaceIndex>\n    </uax:QualifiedName>\n  </uax:Value>\n</Test>\n"),

        // LocalizedText
        Arguments.of(
            Variant.of(LocalizedText.NULL_VALUE),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:LocalizedText>\n    </uax:LocalizedText>\n  </uax:Value>\n</Test>\n"),

        // ExtensionObject (Argument)
        Arguments.of(
            Variant.of(
                ExtensionObject.encode(
                    new DefaultEncodingContext(),
                    new Argument(
                        "name",
                        NodeId.parse("i=1"),
                        -1,
                        null,
                        LocalizedText.english("description")),
                    OpcUaDefaultXmlEncoding.getInstance())),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\"\n  xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <uax:Value>\n    <uax:ExtensionObject>\n      <uax:TypeId>\n        <uax:Identifier>i=297</uax:Identifier>\n      </uax:TypeId>\n      <uax:Body>\n        <uax:Argument>\n          <uax:Name>name</uax:Name>\n          <uax:DataType>\n            <uax:Identifier>i=1</uax:Identifier>\n          </uax:DataType>\n          <uax:ValueRank>-1</uax:ValueRank>\n          <uax:ArrayDimensions xsi:nil=\"true\"></uax:ArrayDimensions>\n          <uax:Description>\n            <uax:Locale>en</uax:Locale>\n            <uax:Text>description</uax:Text>\n          </uax:Description>\n        </uax:Argument>\n      </uax:Body>\n    </uax:ExtensionObject>\n  </uax:Value>\n</Test>\n"),

        // DataValue
        Arguments.of(
            Variant.of(DataValue.valueOnly(Variant.NULL_VALUE)),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:DataValue>\n    </uax:DataValue>\n  </uax:Value>\n</Test>\n"),

        // UaStructuredType (Argument)
        Arguments.of(
            Variant.of(
                new Argument(
                    "name", NodeId.parse("i=1"), -1, null, LocalizedText.english("description"))),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\"\n  xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <uax:Value>\n    <uax:ExtensionObject>\n      <uax:TypeId>\n        <uax:Identifier>i=297</uax:Identifier>\n      </uax:TypeId>\n      <uax:Body>\n        <uax:Argument>\n          <uax:Name>name</uax:Name>\n          <uax:DataType>\n            <uax:Identifier>i=1</uax:Identifier>\n          </uax:DataType>\n          <uax:ValueRank>-1</uax:ValueRank>\n          <uax:ArrayDimensions xsi:nil=\"true\"></uax:ArrayDimensions>\n          <uax:Description>\n            <uax:Locale>en</uax:Locale>\n            <uax:Text>description</uax:Text>\n          </uax:Description>\n        </uax:Argument>\n      </uax:Body>\n    </uax:ExtensionObject>\n  </uax:Value>\n</Test>\n"),

        // Enum (NodeClass)
        Arguments.of(
            Variant.of(NodeClass.Variable),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:Int32>2</uax:Int32>\n  </uax:Value>\n</Test>\n"),

        // OptionSet (AttributeWriteMask)
        Arguments.of(
            Variant.of(AttributeWriteMask.of(AttributeWriteMask.Field.DisplayName)),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:UInt32>64</uax:UInt32>\n  </uax:Value>\n</Test>\n"));
  }

  public static Stream<Arguments> variantOfArrayArguments() {
    return Stream.of(
        // Boolean array (boxed)
        Arguments.of(
            Variant.ofBooleanArray(new Boolean[] {false, true, false, true}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:ListOfBoolean>\n      <uax:Boolean>false</uax:Boolean>\n      <uax:Boolean>true</uax:Boolean>\n      <uax:Boolean>false</uax:Boolean>\n      <uax:Boolean>true</uax:Boolean>\n    </uax:ListOfBoolean>\n  </uax:Value>\n</Test>\n"),

        // Boolean array (primitive)
        Arguments.of(
            Variant.of(new boolean[] {false, true, false, true}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:ListOfBoolean>\n      <uax:Boolean>false</uax:Boolean>\n      <uax:Boolean>true</uax:Boolean>\n      <uax:Boolean>false</uax:Boolean>\n      <uax:Boolean>true</uax:Boolean>\n    </uax:ListOfBoolean>\n  </uax:Value>\n</Test>\n"),

        // SByte array (boxed)
        Arguments.of(
            Variant.of(new Byte[] {0, 0}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:ListOfSByte>\n      <uax:SByte>0</uax:SByte>\n      <uax:SByte>0</uax:SByte>\n    </uax:ListOfSByte>\n  </uax:Value>\n</Test>\n"),

        // SByte array (primitive)
        Arguments.of(
            Variant.of(new byte[] {0, 0}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:ListOfSByte>\n      <uax:SByte>0</uax:SByte>\n      <uax:SByte>0</uax:SByte>\n    </uax:ListOfSByte>\n  </uax:Value>\n</Test>\n"),

        // Byte array
        Arguments.of(
            Variant.of(new UByte[] {UByte.MIN, UByte.MIN}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:ListOfByte>\n      <uax:Byte>0</uax:Byte>\n      <uax:Byte>0</uax:Byte>\n    </uax:ListOfByte>\n  </uax:Value>\n</Test>\n"),

        // Int16 array (boxed)
        Arguments.of(
            Variant.of(new Short[] {0, 0}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:ListOfInt16>\n      <uax:Int16>0</uax:Int16>\n      <uax:Int16>0</uax:Int16>\n    </uax:ListOfInt16>\n  </uax:Value>\n</Test>\n"),

        // Int16 array (primitive)
        Arguments.of(
            Variant.of(new short[] {0, 0}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:ListOfInt16>\n      <uax:Int16>0</uax:Int16>\n      <uax:Int16>0</uax:Int16>\n    </uax:ListOfInt16>\n  </uax:Value>\n</Test>\n"),

        // UInt16 array
        Arguments.of(
            Variant.of(new UShort[] {UShort.MIN, UShort.MIN}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:ListOfUInt16>\n      <uax:UInt16>0</uax:UInt16>\n      <uax:UInt16>0</uax:UInt16>\n    </uax:ListOfUInt16>\n  </uax:Value>\n</Test>\n"),

        // Int32 array (boxed)
        Arguments.of(
            Variant.of(new Integer[] {0, 0}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:ListOfInt32>\n      <uax:Int32>0</uax:Int32>\n      <uax:Int32>0</uax:Int32>\n    </uax:ListOfInt32>\n  </uax:Value>\n</Test>\n"),

        // Int32 array (primitive)
        Arguments.of(
            Variant.of(new int[] {0, 0}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:ListOfInt32>\n      <uax:Int32>0</uax:Int32>\n      <uax:Int32>0</uax:Int32>\n    </uax:ListOfInt32>\n  </uax:Value>\n</Test>\n"),

        // UInt32 array
        Arguments.of(
            Variant.of(new UInteger[] {UInteger.MIN, UInteger.MIN}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:ListOfUInt32>\n      <uax:UInt32>0</uax:UInt32>\n      <uax:UInt32>0</uax:UInt32>\n    </uax:ListOfUInt32>\n  </uax:Value>\n</Test>\n"),

        // Int64 array (boxed)
        Arguments.of(
            Variant.of(new Long[] {0L, 0L}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:ListOfInt64>\n      <uax:Int64>0</uax:Int64>\n      <uax:Int64>0</uax:Int64>\n    </uax:ListOfInt64>\n  </uax:Value>\n</Test>\n"),

        // Int64 array (primitive)
        Arguments.of(
            Variant.of(new long[] {0L, 0L}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:ListOfInt64>\n      <uax:Int64>0</uax:Int64>\n      <uax:Int64>0</uax:Int64>\n    </uax:ListOfInt64>\n  </uax:Value>\n</Test>\n"),

        // UInt64 array
        Arguments.of(
            Variant.of(new ULong[] {ULong.MIN, ULong.MIN}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:ListOfUInt64>\n      <uax:UInt64>0</uax:UInt64>\n      <uax:UInt64>0</uax:UInt64>\n    </uax:ListOfUInt64>\n  </uax:Value>\n</Test>\n"),

        // Float array (boxed)
        Arguments.of(
            Variant.of(new Float[] {0.0f, 0.0f}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:ListOfFloat>\n      <uax:Float>0.0</uax:Float>\n      <uax:Float>0.0</uax:Float>\n    </uax:ListOfFloat>\n  </uax:Value>\n</Test>\n"),

        // Float array (primitive)
        Arguments.of(
            Variant.of(new float[] {0.0f, 0.0f}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:ListOfFloat>\n      <uax:Float>0.0</uax:Float>\n      <uax:Float>0.0</uax:Float>\n    </uax:ListOfFloat>\n  </uax:Value>\n</Test>\n"),

        // Double array (boxed)
        Arguments.of(
            Variant.of(new Double[] {0.0, 0.0}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:ListOfDouble>\n      <uax:Double>0.0</uax:Double>\n      <uax:Double>0.0</uax:Double>\n    </uax:ListOfDouble>\n  </uax:Value>\n</Test>\n"),

        // Double array (primitive)
        Arguments.of(
            Variant.of(new double[] {0.0, 0.0}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:ListOfDouble>\n      <uax:Double>0.0</uax:Double>\n      <uax:Double>0.0</uax:Double>\n    </uax:ListOfDouble>\n  </uax:Value>\n</Test>\n"),

        // String array
        Arguments.of(
            Variant.ofStringArray(new String[] {"", ""}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:ListOfString>\n      <uax:String></uax:String>\n      <uax:String></uax:String>\n    </uax:ListOfString>\n  </uax:Value>\n</Test>\n"),

        // DateTime array
        Arguments.of(
            Variant.ofDateTimeArray(new DateTime[] {DateTime.NULL_VALUE, DateTime.NULL_VALUE}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:ListOfDateTime>\n      <uax:DateTime>1601-01-01T00:00:00Z</uax:DateTime>\n      <uax:DateTime>1601-01-01T00:00:00Z</uax:DateTime>\n    </uax:ListOfDateTime>\n  </uax:Value>\n</Test>\n"),

        // Guid array
        Arguments.of(
            Variant.ofGuidArray(new UUID[] {new UUID(0L, 0L), new UUID(0L, 0L)}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:ListOfGuid>\n      <uax:Guid>00000000-0000-0000-0000-000000000000</uax:Guid>\n      <uax:Guid>00000000-0000-0000-0000-000000000000</uax:Guid>\n    </uax:ListOfGuid>\n  </uax:Value>\n</Test>\n"),

        // ByteString array
        Arguments.of(
            Variant.ofByteStringArray(
                new ByteString[] {ByteString.NULL_VALUE, ByteString.NULL_VALUE}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:ListOfByteString>\n      <uax:ByteString></uax:ByteString>\n      <uax:ByteString></uax:ByteString>\n    </uax:ListOfByteString>\n  </uax:Value>\n</Test>\n"),

        // XmlElement array
        Arguments.of(
            Variant.ofXmlElementArray(
                new XmlElement[] {XmlElement.NULL_VALUE, XmlElement.NULL_VALUE}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:ListOfXmlElement>\n      <uax:XmlElement></uax:XmlElement>\n      <uax:XmlElement></uax:XmlElement>\n    </uax:ListOfXmlElement>\n  </uax:Value>\n</Test>\n"),

        // NodeId array
        Arguments.of(
            Variant.of(new NodeId[] {NodeId.NULL_VALUE, NodeId.NULL_VALUE}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:ListOfNodeId>\n      <uax:NodeId>\n        <uax:Identifier>i=0</uax:Identifier>\n      </uax:NodeId>\n      <uax:NodeId>\n        <uax:Identifier>i=0</uax:Identifier>\n      </uax:NodeId>\n    </uax:ListOfNodeId>\n  </uax:Value>\n</Test>\n"),

        // ExpandedNodeId array
        Arguments.of(
            Variant.of(new ExpandedNodeId[] {ExpandedNodeId.NULL_VALUE, ExpandedNodeId.NULL_VALUE}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:ListOfExpandedNodeId>\n      <uax:ExpandedNodeId>\n        <uax:Identifier>i=0</uax:Identifier>\n      </uax:ExpandedNodeId>\n      <uax:ExpandedNodeId>\n        <uax:Identifier>i=0</uax:Identifier>\n      </uax:ExpandedNodeId>\n    </uax:ListOfExpandedNodeId>\n  </uax:Value>\n</Test>\n"),

        // StatusCode array
        Arguments.of(
            Variant.of(new StatusCode[] {StatusCode.GOOD, StatusCode.GOOD}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:ListOfStatusCode>\n      <uax:StatusCode>\n        <uax:Code>0</uax:Code>\n      </uax:StatusCode>\n      <uax:StatusCode>\n        <uax:Code>0</uax:Code>\n      </uax:StatusCode>\n    </uax:ListOfStatusCode>\n  </uax:Value>\n</Test>\n"),

        // QualifiedName array
        Arguments.of(
            Variant.of(new QualifiedName[] {QualifiedName.NULL_VALUE, QualifiedName.NULL_VALUE}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:ListOfQualifiedName>\n      <uax:QualifiedName>\n        <uax:NamespaceIndex>0</uax:NamespaceIndex>\n      </uax:QualifiedName>\n      <uax:QualifiedName>\n        <uax:NamespaceIndex>0</uax:NamespaceIndex>\n      </uax:QualifiedName>\n    </uax:ListOfQualifiedName>\n  </uax:Value>\n</Test>\n"),

        // LocalizedText array
        Arguments.of(
            Variant.of(new LocalizedText[] {LocalizedText.NULL_VALUE, LocalizedText.NULL_VALUE}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:ListOfLocalizedText>\n      <uax:LocalizedText>\n      </uax:LocalizedText>\n      <uax:LocalizedText>\n      </uax:LocalizedText>\n    </uax:ListOfLocalizedText>\n  </uax:Value>\n</Test>\n"),

        // DataValue array
        Arguments.of(
            Variant.of(
                new DataValue[] {
                  DataValue.valueOnly(Variant.NULL_VALUE), DataValue.valueOnly(Variant.NULL_VALUE)
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:ListOfDataValue>\n      <uax:DataValue>\n      </uax:DataValue>\n      <uax:DataValue>\n      </uax:DataValue>\n    </uax:ListOfDataValue>\n  </uax:Value>\n</Test>\n"),

        // ExtensionObject array
        Arguments.of(
            Variant.of(
                new ExtensionObject[] {
                  ExtensionObject.encode(
                      new DefaultEncodingContext(),
                      new Argument(
                          "name",
                          NodeId.parse("i=1"),
                          -1,
                          null,
                          LocalizedText.english("description")),
                      OpcUaDefaultXmlEncoding.getInstance()),
                  ExtensionObject.encode(
                      new DefaultEncodingContext(),
                      new Argument(
                          "name",
                          NodeId.parse("i=1"),
                          -1,
                          null,
                          LocalizedText.english("description")),
                      OpcUaDefaultXmlEncoding.getInstance())
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\"\n  xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <uax:Value>\n    <uax:ListOfExtensionObject>\n      <uax:ExtensionObject>\n        <uax:TypeId>\n          <uax:Identifier>i=297</uax:Identifier>\n        </uax:TypeId>\n        <uax:Body>\n          <uax:Argument>\n            <uax:Name>name</uax:Name>\n            <uax:DataType>\n              <uax:Identifier>i=1</uax:Identifier>\n            </uax:DataType>\n            <uax:ValueRank>-1</uax:ValueRank>\n            <uax:ArrayDimensions xsi:nil=\"true\"></uax:ArrayDimensions>\n            <uax:Description>\n              <uax:Locale>en</uax:Locale>\n              <uax:Text>description</uax:Text>\n            </uax:Description>\n          </uax:Argument>\n        </uax:Body>\n      </uax:ExtensionObject>\n      <uax:ExtensionObject>\n        <uax:TypeId>\n          <uax:Identifier>i=297</uax:Identifier>\n        </uax:TypeId>\n        <uax:Body>\n          <uax:Argument>\n            <uax:Name>name</uax:Name>\n            <uax:DataType>\n              <uax:Identifier>i=1</uax:Identifier>\n            </uax:DataType>\n            <uax:ValueRank>-1</uax:ValueRank>\n            <uax:ArrayDimensions xsi:nil=\"true\"></uax:ArrayDimensions>\n            <uax:Description>\n              <uax:Locale>en</uax:Locale>\n              <uax:Text>description</uax:Text>\n            </uax:Description>\n          </uax:Argument>\n        </uax:Body>\n      </uax:ExtensionObject>\n    </uax:ListOfExtensionObject>\n  </uax:Value>\n</Test>\n"),

        // Variant array
        Arguments.of(
            Variant.of(new Variant[] {Variant.of(0), Variant.of(0)}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:ListOfVariant>\n      <uax:Variant>\n        <uax:Value>\n          <uax:Int32>0</uax:Int32>\n        </uax:Value>\n      </uax:Variant>\n      <uax:Variant>\n        <uax:Value>\n          <uax:Int32>0</uax:Int32>\n        </uax:Value>\n      </uax:Variant>\n    </uax:ListOfVariant>\n  </uax:Value>\n</Test>\n"),

        // Enum array (NodeClass)
        Arguments.of(
            Variant.of(new NodeClass[] {NodeClass.Variable, NodeClass.Object}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:ListOfInt32>\n      <uax:Int32>2</uax:Int32>\n      <uax:Int32>1</uax:Int32>\n    </uax:ListOfInt32>\n  </uax:Value>\n</Test>\n"),

        // Struct array (Argument)
        Arguments.of(
            Variant.of(
                new Argument[] {
                  new Argument(
                      "name1",
                      NodeId.parse("i=1"),
                      -1,
                      null,
                      LocalizedText.english("description1")),
                  new Argument(
                      "name2",
                      NodeId.parse("i=1"),
                      -1,
                      null,
                      LocalizedText.english("description2")),
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\"\n  xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <uax:Value>\n    <uax:ListOfExtensionObject>\n      <uax:ExtensionObject>\n        <uax:TypeId>\n          <uax:Identifier>i=297</uax:Identifier>\n        </uax:TypeId>\n        <uax:Body>\n          <uax:Argument>\n            <uax:Name>name1</uax:Name>\n            <uax:DataType>\n              <uax:Identifier>i=1</uax:Identifier>\n            </uax:DataType>\n            <uax:ValueRank>-1</uax:ValueRank>\n            <uax:ArrayDimensions xsi:nil=\"true\"></uax:ArrayDimensions>\n            <uax:Description>\n              <uax:Locale>en</uax:Locale>\n              <uax:Text>description1</uax:Text>\n            </uax:Description>\n          </uax:Argument>\n        </uax:Body>\n      </uax:ExtensionObject>\n      <uax:ExtensionObject>\n        <uax:TypeId>\n          <uax:Identifier>i=297</uax:Identifier>\n        </uax:TypeId>\n        <uax:Body>\n          <uax:Argument>\n            <uax:Name>name2</uax:Name>\n            <uax:DataType>\n              <uax:Identifier>i=1</uax:Identifier>\n            </uax:DataType>\n            <uax:ValueRank>-1</uax:ValueRank>\n            <uax:ArrayDimensions xsi:nil=\"true\"></uax:ArrayDimensions>\n            <uax:Description>\n              <uax:Locale>en</uax:Locale>\n              <uax:Text>description2</uax:Text>\n            </uax:Description>\n          </uax:Argument>\n        </uax:Body>\n      </uax:ExtensionObject>\n    </uax:ListOfExtensionObject>\n  </uax:Value>\n</Test>\n"),

        // OptionSet array (AttributeWriteMask)
        Arguments.of(
            Variant.of(
                new AttributeWriteMask[] {
                  AttributeWriteMask.of(AttributeWriteMask.Field.DisplayName),
                  AttributeWriteMask.of(AttributeWriteMask.Field.Description)
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:ListOfUInt32>\n      <uax:UInt32>64</uax:UInt32>\n      <uax:UInt32>32</uax:UInt32>\n    </uax:ListOfUInt32>\n  </uax:Value>\n</Test>\n"));
  }

  public static Stream<Arguments> variantOfMatrixArguments() {
    return Stream.of(
        // Boolean matrix (2D)
        Arguments.of(
            Variant.ofMatrix(Matrix.ofBoolean(new boolean[][] {{false, true}, {true, false}})),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <uax:Value>\n    <uax:Matrix>\n      <uax:Dimensions>\n        <uax:Int32>2</uax:Int32>\n        <uax:Int32>2</uax:Int32>\n      </uax:Dimensions>\n      <uax:Elements>\n        <uax:Boolean>false</uax:Boolean>\n        <uax:Boolean>true</uax:Boolean>\n        <uax:Boolean>true</uax:Boolean>\n        <uax:Boolean>false</uax:Boolean>\n      </uax:Elements>\n    </uax:Matrix>\n  </uax:Value>\n</Test>\n"),

        // SByte matrix (2D)
        Arguments.of(
            Variant.ofMatrix(Matrix.ofSByte(new byte[][] {{0, 1}, {2, 3}})),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <uax:Value>\n    <uax:Matrix>\n      <uax:Dimensions>\n        <uax:Int32>2</uax:Int32>\n        <uax:Int32>2</uax:Int32>\n      </uax:Dimensions>\n      <uax:Elements>\n        <uax:SByte>0</uax:SByte>\n        <uax:SByte>1</uax:SByte>\n        <uax:SByte>2</uax:SByte>\n        <uax:SByte>3</uax:SByte>\n      </uax:Elements>\n    </uax:Matrix>\n  </uax:Value>\n</Test>\n"),

        // Byte matrix (2D)
        Arguments.of(
            Variant.ofMatrix(
                Matrix.ofByte(
                    new UByte[][] {
                      {UByte.MIN, UByte.valueOf(1)}, {UByte.valueOf(2), UByte.valueOf(3)}
                    })),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <uax:Value>\n    <uax:Matrix>\n      <uax:Dimensions>\n        <uax:Int32>2</uax:Int32>\n        <uax:Int32>2</uax:Int32>\n      </uax:Dimensions>\n      <uax:Elements>\n        <uax:Byte>0</uax:Byte>\n        <uax:Byte>1</uax:Byte>\n        <uax:Byte>2</uax:Byte>\n        <uax:Byte>3</uax:Byte>\n      </uax:Elements>\n    </uax:Matrix>\n  </uax:Value>\n</Test>\n"),

        // Int16 matrix (2D)
        Arguments.of(
            Variant.ofMatrix(Matrix.ofInt16(new short[][] {{0, 1}, {2, 3}})),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <uax:Value>\n    <uax:Matrix>\n      <uax:Dimensions>\n        <uax:Int32>2</uax:Int32>\n        <uax:Int32>2</uax:Int32>\n      </uax:Dimensions>\n      <uax:Elements>\n        <uax:Int16>0</uax:Int16>\n        <uax:Int16>1</uax:Int16>\n        <uax:Int16>2</uax:Int16>\n        <uax:Int16>3</uax:Int16>\n      </uax:Elements>\n    </uax:Matrix>\n  </uax:Value>\n</Test>\n"),

        // UInt16 matrix (2D)
        Arguments.of(
            Variant.ofMatrix(
                Matrix.ofUInt16(
                    new UShort[][] {
                      {UShort.MIN, UShort.valueOf(1)}, {UShort.valueOf(2), UShort.valueOf(3)}
                    })),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <uax:Value>\n    <uax:Matrix>\n      <uax:Dimensions>\n        <uax:Int32>2</uax:Int32>\n        <uax:Int32>2</uax:Int32>\n      </uax:Dimensions>\n      <uax:Elements>\n        <uax:UInt16>0</uax:UInt16>\n        <uax:UInt16>1</uax:UInt16>\n        <uax:UInt16>2</uax:UInt16>\n        <uax:UInt16>3</uax:UInt16>\n      </uax:Elements>\n    </uax:Matrix>\n  </uax:Value>\n</Test>\n"),

        // Int32 matrix (2D)
        Arguments.of(
            Variant.ofMatrix(Matrix.ofInt32(new int[][] {{0, 1}, {2, 3}})),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <uax:Value>\n    <uax:Matrix>\n      <uax:Dimensions>\n        <uax:Int32>2</uax:Int32>\n        <uax:Int32>2</uax:Int32>\n      </uax:Dimensions>\n      <uax:Elements>\n        <uax:Int32>0</uax:Int32>\n        <uax:Int32>1</uax:Int32>\n        <uax:Int32>2</uax:Int32>\n        <uax:Int32>3</uax:Int32>\n      </uax:Elements>\n    </uax:Matrix>\n  </uax:Value>\n</Test>\n"),

        // UInt32 matrix (2D)
        Arguments.of(
            Variant.ofMatrix(
                Matrix.ofUInt32(
                    new UInteger[][] {
                      {UInteger.MIN, UInteger.valueOf(1)},
                      {UInteger.valueOf(2), UInteger.valueOf(3)}
                    })),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <uax:Value>\n    <uax:Matrix>\n      <uax:Dimensions>\n        <uax:Int32>2</uax:Int32>\n        <uax:Int32>2</uax:Int32>\n      </uax:Dimensions>\n      <uax:Elements>\n        <uax:UInt32>0</uax:UInt32>\n        <uax:UInt32>1</uax:UInt32>\n        <uax:UInt32>2</uax:UInt32>\n        <uax:UInt32>3</uax:UInt32>\n      </uax:Elements>\n    </uax:Matrix>\n  </uax:Value>\n</Test>\n"),

        // Int64 matrix (2D)
        Arguments.of(
            Variant.ofMatrix(Matrix.ofInt64(new long[][] {{0L, 1L}, {2L, 3L}})),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <uax:Value>\n    <uax:Matrix>\n      <uax:Dimensions>\n        <uax:Int32>2</uax:Int32>\n        <uax:Int32>2</uax:Int32>\n      </uax:Dimensions>\n      <uax:Elements>\n        <uax:Int64>0</uax:Int64>\n        <uax:Int64>1</uax:Int64>\n        <uax:Int64>2</uax:Int64>\n        <uax:Int64>3</uax:Int64>\n      </uax:Elements>\n    </uax:Matrix>\n  </uax:Value>\n</Test>\n"),

        // UInt64 matrix (2D)
        Arguments.of(
            Variant.ofMatrix(
                Matrix.ofUInt64(
                    new ULong[][] {
                      {ULong.MIN, ULong.valueOf(1)}, {ULong.valueOf(2), ULong.valueOf(3)}
                    })),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <uax:Value>\n    <uax:Matrix>\n      <uax:Dimensions>\n        <uax:Int32>2</uax:Int32>\n        <uax:Int32>2</uax:Int32>\n      </uax:Dimensions>\n      <uax:Elements>\n        <uax:UInt64>0</uax:UInt64>\n        <uax:UInt64>1</uax:UInt64>\n        <uax:UInt64>2</uax:UInt64>\n        <uax:UInt64>3</uax:UInt64>\n      </uax:Elements>\n    </uax:Matrix>\n  </uax:Value>\n</Test>\n"),

        // String matrix (2D)
        Arguments.of(
            Variant.ofMatrix(Matrix.ofString(new String[][] {{"a", "b"}, {"c", "d"}})),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <uax:Value>\n    <uax:Matrix>\n      <uax:Dimensions>\n        <uax:Int32>2</uax:Int32>\n        <uax:Int32>2</uax:Int32>\n      </uax:Dimensions>\n      <uax:Elements>\n        <uax:String>a</uax:String>\n        <uax:String>b</uax:String>\n        <uax:String>c</uax:String>\n        <uax:String>d</uax:String>\n      </uax:Elements>\n    </uax:Matrix>\n  </uax:Value>\n</Test>\n"),

        // Float matrix (2D)
        Arguments.of(
            Variant.ofMatrix(Matrix.ofFloat(new float[][] {{0.0f, 1.0f}, {2.0f, 3.0f}})),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <uax:Value>\n    <uax:Matrix>\n      <uax:Dimensions>\n        <uax:Int32>2</uax:Int32>\n        <uax:Int32>2</uax:Int32>\n      </uax:Dimensions>\n      <uax:Elements>\n        <uax:Float>0.0</uax:Float>\n        <uax:Float>1.0</uax:Float>\n        <uax:Float>2.0</uax:Float>\n        <uax:Float>3.0</uax:Float>\n      </uax:Elements>\n    </uax:Matrix>\n  </uax:Value>\n</Test>\n"),

        // DateTime matrix (2D)
        Arguments.of(
            Variant.ofMatrix(
                Matrix.ofDateTime(
                    new DateTime[][] {
                      {DateTime.NULL_VALUE, DateTime.NULL_VALUE},
                      {DateTime.NULL_VALUE, DateTime.NULL_VALUE}
                    })),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <uax:Value>\n    <uax:Matrix>\n      <uax:Dimensions>\n        <uax:Int32>2</uax:Int32>\n        <uax:Int32>2</uax:Int32>\n      </uax:Dimensions>\n      <uax:Elements>\n        <uax:DateTime>1601-01-01T00:00:00Z</uax:DateTime>\n        <uax:DateTime>1601-01-01T00:00:00Z</uax:DateTime>\n        <uax:DateTime>1601-01-01T00:00:00Z</uax:DateTime>\n        <uax:DateTime>1601-01-01T00:00:00Z</uax:DateTime>\n      </uax:Elements>\n    </uax:Matrix>\n  </uax:Value>\n</Test>\n"),

        // Guid matrix (2D)
        Arguments.of(
            Variant.ofMatrix(
                Matrix.ofGuid(
                    new UUID[][] {
                      {new UUID(0L, 0L), new UUID(0L, 0L)}, {new UUID(0L, 0L), new UUID(0L, 0L)}
                    })),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <uax:Value>\n    <uax:Matrix>\n      <uax:Dimensions>\n        <uax:Int32>2</uax:Int32>\n        <uax:Int32>2</uax:Int32>\n      </uax:Dimensions>\n      <uax:Elements>\n        <uax:Guid>00000000-0000-0000-0000-000000000000</uax:Guid>\n        <uax:Guid>00000000-0000-0000-0000-000000000000</uax:Guid>\n        <uax:Guid>00000000-0000-0000-0000-000000000000</uax:Guid>\n        <uax:Guid>00000000-0000-0000-0000-000000000000</uax:Guid>\n      </uax:Elements>\n    </uax:Matrix>\n  </uax:Value>\n</Test>\n"),

        // Double matrix (2D)
        Arguments.of(
            Variant.ofMatrix(Matrix.ofDouble(new double[][] {{0.0, 1.0}, {2.0, 3.0}})),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <uax:Value>\n    <uax:Matrix>\n      <uax:Dimensions>\n        <uax:Int32>2</uax:Int32>\n        <uax:Int32>2</uax:Int32>\n      </uax:Dimensions>\n      <uax:Elements>\n        <uax:Double>0.0</uax:Double>\n        <uax:Double>1.0</uax:Double>\n        <uax:Double>2.0</uax:Double>\n        <uax:Double>3.0</uax:Double>\n      </uax:Elements>\n    </uax:Matrix>\n  </uax:Value>\n</Test>\n"),

        // ByteString matrix (2D)
        Arguments.of(
            Variant.ofMatrix(
                Matrix.ofByteString(
                    new ByteString[][] {
                      {ByteString.NULL_VALUE, ByteString.NULL_VALUE},
                      {ByteString.NULL_VALUE, ByteString.NULL_VALUE}
                    })),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <uax:Value>\n    <uax:Matrix>\n      <uax:Dimensions>\n        <uax:Int32>2</uax:Int32>\n        <uax:Int32>2</uax:Int32>\n      </uax:Dimensions>\n      <uax:Elements>\n        <uax:ByteString></uax:ByteString>\n        <uax:ByteString></uax:ByteString>\n        <uax:ByteString></uax:ByteString>\n        <uax:ByteString></uax:ByteString>\n      </uax:Elements>\n    </uax:Matrix>\n  </uax:Value>\n</Test>\n"),

        // XmlElement matrix (2D)
        Arguments.of(
            Variant.ofMatrix(
                Matrix.ofXmlElement(
                    new XmlElement[][] {
                      {XmlElement.NULL_VALUE, XmlElement.NULL_VALUE},
                      {XmlElement.NULL_VALUE, XmlElement.NULL_VALUE}
                    })),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <uax:Value>\n    <uax:Matrix>\n      <uax:Dimensions>\n        <uax:Int32>2</uax:Int32>\n        <uax:Int32>2</uax:Int32>\n      </uax:Dimensions>\n      <uax:Elements>\n        <uax:XmlElement></uax:XmlElement>\n        <uax:XmlElement></uax:XmlElement>\n        <uax:XmlElement></uax:XmlElement>\n        <uax:XmlElement></uax:XmlElement>\n      </uax:Elements>\n    </uax:Matrix>\n  </uax:Value>\n</Test>\n"),

        // NodeId matrix (2D)
        Arguments.of(
            Variant.ofMatrix(
                Matrix.ofNodeId(
                    new NodeId[][] {
                      {NodeId.NULL_VALUE, NodeId.NULL_VALUE}, {NodeId.NULL_VALUE, NodeId.NULL_VALUE}
                    })),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <uax:Value>\n    <uax:Matrix>\n      <uax:Dimensions>\n        <uax:Int32>2</uax:Int32>\n        <uax:Int32>2</uax:Int32>\n      </uax:Dimensions>\n      <uax:Elements>\n        <uax:NodeId>\n          <uax:Identifier>i=0</uax:Identifier>\n        </uax:NodeId>\n        <uax:NodeId>\n          <uax:Identifier>i=0</uax:Identifier>\n        </uax:NodeId>\n        <uax:NodeId>\n          <uax:Identifier>i=0</uax:Identifier>\n        </uax:NodeId>\n        <uax:NodeId>\n          <uax:Identifier>i=0</uax:Identifier>\n        </uax:NodeId>\n      </uax:Elements>\n    </uax:Matrix>\n  </uax:Value>\n</Test>\n"),

        // ExpandedNodeId matrix (2D)
        Arguments.of(
            Variant.ofMatrix(
                Matrix.ofExpandedNodeId(
                    new ExpandedNodeId[][] {
                      {ExpandedNodeId.NULL_VALUE, ExpandedNodeId.NULL_VALUE},
                      {ExpandedNodeId.NULL_VALUE, ExpandedNodeId.NULL_VALUE}
                    })),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <uax:Value>\n    <uax:Matrix>\n      <uax:Dimensions>\n        <uax:Int32>2</uax:Int32>\n        <uax:Int32>2</uax:Int32>\n      </uax:Dimensions>\n      <uax:Elements>\n        <uax:ExpandedNodeId>\n          <uax:Identifier>i=0</uax:Identifier>\n        </uax:ExpandedNodeId>\n        <uax:ExpandedNodeId>\n          <uax:Identifier>i=0</uax:Identifier>\n        </uax:ExpandedNodeId>\n        <uax:ExpandedNodeId>\n          <uax:Identifier>i=0</uax:Identifier>\n        </uax:ExpandedNodeId>\n        <uax:ExpandedNodeId>\n          <uax:Identifier>i=0</uax:Identifier>\n        </uax:ExpandedNodeId>\n      </uax:Elements>\n    </uax:Matrix>\n  </uax:Value>\n</Test>\n"),

        // StatusCode matrix (2D)
        Arguments.of(
            Variant.ofMatrix(
                Matrix.ofStatusCode(
                    new StatusCode[][] {
                      {StatusCode.GOOD, StatusCode.GOOD}, {StatusCode.GOOD, StatusCode.GOOD}
                    })),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <uax:Value>\n    <uax:Matrix>\n      <uax:Dimensions>\n        <uax:Int32>2</uax:Int32>\n        <uax:Int32>2</uax:Int32>\n      </uax:Dimensions>\n      <uax:Elements>\n        <uax:StatusCode>\n          <uax:Code>0</uax:Code>\n        </uax:StatusCode>\n        <uax:StatusCode>\n          <uax:Code>0</uax:Code>\n        </uax:StatusCode>\n        <uax:StatusCode>\n          <uax:Code>0</uax:Code>\n        </uax:StatusCode>\n        <uax:StatusCode>\n          <uax:Code>0</uax:Code>\n        </uax:StatusCode>\n      </uax:Elements>\n    </uax:Matrix>\n  </uax:Value>\n</Test>\n"),

        // QualifiedName matrix (2D)
        Arguments.of(
            Variant.ofMatrix(
                Matrix.ofQualifiedName(
                    new QualifiedName[][] {
                      {QualifiedName.NULL_VALUE, QualifiedName.NULL_VALUE},
                      {QualifiedName.NULL_VALUE, QualifiedName.NULL_VALUE}
                    })),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <uax:Value>\n    <uax:Matrix>\n      <uax:Dimensions>\n        <uax:Int32>2</uax:Int32>\n        <uax:Int32>2</uax:Int32>\n      </uax:Dimensions>\n      <uax:Elements>\n        <uax:QualifiedName>\n          <uax:NamespaceIndex>0</uax:NamespaceIndex>\n        </uax:QualifiedName>\n        <uax:QualifiedName>\n          <uax:NamespaceIndex>0</uax:NamespaceIndex>\n        </uax:QualifiedName>\n        <uax:QualifiedName>\n          <uax:NamespaceIndex>0</uax:NamespaceIndex>\n        </uax:QualifiedName>\n        <uax:QualifiedName>\n          <uax:NamespaceIndex>0</uax:NamespaceIndex>\n        </uax:QualifiedName>\n      </uax:Elements>\n    </uax:Matrix>\n  </uax:Value>\n</Test>\n"),

        // LocalizedText matrix (2D)
        Arguments.of(
            Variant.ofMatrix(
                Matrix.ofLocalizedText(
                    new LocalizedText[][] {
                      {LocalizedText.NULL_VALUE, LocalizedText.NULL_VALUE},
                      {LocalizedText.NULL_VALUE, LocalizedText.NULL_VALUE}
                    })),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <uax:Value>\n    <uax:Matrix>\n      <uax:Dimensions>\n        <uax:Int32>2</uax:Int32>\n        <uax:Int32>2</uax:Int32>\n      </uax:Dimensions>\n      <uax:Elements>\n        <uax:LocalizedText>\n        </uax:LocalizedText>\n        <uax:LocalizedText>\n        </uax:LocalizedText>\n        <uax:LocalizedText>\n        </uax:LocalizedText>\n        <uax:LocalizedText>\n        </uax:LocalizedText>\n      </uax:Elements>\n    </uax:Matrix>\n  </uax:Value>\n</Test>\n"),

        // ExtensionObject matrix (2D)
        Arguments.of(
            Variant.ofMatrix(
                Matrix.ofExtensionObject(new ExtensionObject[][] {{null, null}, {null, null}})),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <uax:Value>\n    <uax:Matrix>\n      <uax:Dimensions>\n        <uax:Int32>2</uax:Int32>\n        <uax:Int32>2</uax:Int32>\n      </uax:Dimensions>\n      <uax:Elements>\n      </uax:Elements>\n    </uax:Matrix>\n  </uax:Value>\n</Test>\n"),

        // DataValue matrix (2D)
        Arguments.of(
            Variant.ofMatrix(
                Matrix.ofDataValue(
                    new DataValue[][] {
                      {
                        DataValue.valueOnly(Variant.NULL_VALUE),
                        DataValue.valueOnly(Variant.NULL_VALUE)
                      },
                      {
                        DataValue.valueOnly(Variant.NULL_VALUE),
                        DataValue.valueOnly(Variant.NULL_VALUE)
                      }
                    })),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <uax:Value>\n    <uax:Matrix>\n      <uax:Dimensions>\n        <uax:Int32>2</uax:Int32>\n        <uax:Int32>2</uax:Int32>\n      </uax:Dimensions>\n      <uax:Elements>\n        <uax:DataValue>\n        </uax:DataValue>\n        <uax:DataValue>\n        </uax:DataValue>\n        <uax:DataValue>\n        </uax:DataValue>\n        <uax:DataValue>\n        </uax:DataValue>\n      </uax:Elements>\n    </uax:Matrix>\n  </uax:Value>\n</Test>\n"),

        // Variant matrix (2D)
        Arguments.of(
            Variant.ofMatrix(
                Matrix.ofVariant(
                    new Variant[][] {
                      {Variant.NULL_VALUE, Variant.NULL_VALUE},
                      {Variant.NULL_VALUE, Variant.NULL_VALUE}
                    })),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <uax:Value>\n    <uax:Matrix>\n      <uax:Dimensions>\n        <uax:Int32>2</uax:Int32>\n        <uax:Int32>2</uax:Int32>\n      </uax:Dimensions>\n      <uax:Elements>\n        <uax:Variant>\n          <uax:Value xsi:nil=\"true\"/>\n        </uax:Variant>\n        <uax:Variant>\n          <uax:Value xsi:nil=\"true\"/>\n        </uax:Variant>\n        <uax:Variant>\n          <uax:Value xsi:nil=\"true\"/>\n        </uax:Variant>\n        <uax:Variant>\n          <uax:Value xsi:nil=\"true\"/>\n        </uax:Variant>\n      </uax:Elements>\n    </uax:Matrix>\n  </uax:Value>\n</Test>\n"),

        // DiagnosticInfo matrix (2D)
        Arguments.of(
            Variant.ofMatrix(
                Matrix.ofDiagnosticInfo(
                    new DiagnosticInfo[][] {
                      {DiagnosticInfo.NULL_VALUE, DiagnosticInfo.NULL_VALUE},
                      {DiagnosticInfo.NULL_VALUE, DiagnosticInfo.NULL_VALUE}
                    })),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <uax:Value>\n    <uax:Matrix>\n      <uax:Dimensions>\n        <uax:Int32>2</uax:Int32>\n        <uax:Int32>2</uax:Int32>\n      </uax:Dimensions>\n      <uax:Elements>\n        <uax:DiagnosticInfo>\n          <uax:SymbolicId>-1</uax:SymbolicId>\n          <uax:NamespaceUri>-1</uax:NamespaceUri>\n          <uax:Locale>-1</uax:Locale>\n          <uax:LocalizedText>-1</uax:LocalizedText>\n        </uax:DiagnosticInfo>\n        <uax:DiagnosticInfo>\n          <uax:SymbolicId>-1</uax:SymbolicId>\n          <uax:NamespaceUri>-1</uax:NamespaceUri>\n          <uax:Locale>-1</uax:Locale>\n          <uax:LocalizedText>-1</uax:LocalizedText>\n        </uax:DiagnosticInfo>\n        <uax:DiagnosticInfo>\n          <uax:SymbolicId>-1</uax:SymbolicId>\n          <uax:NamespaceUri>-1</uax:NamespaceUri>\n          <uax:Locale>-1</uax:Locale>\n          <uax:LocalizedText>-1</uax:LocalizedText>\n        </uax:DiagnosticInfo>\n        <uax:DiagnosticInfo>\n          <uax:SymbolicId>-1</uax:SymbolicId>\n          <uax:NamespaceUri>-1</uax:NamespaceUri>\n          <uax:Locale>-1</uax:Locale>\n          <uax:LocalizedText>-1</uax:LocalizedText>\n        </uax:DiagnosticInfo>\n      </uax:Elements>\n    </uax:Matrix>\n  </uax:Value>\n</Test>\n"),

        // Structure matrix (2D)
        Arguments.of(
            Variant.ofMatrix(
                Matrix.ofStruct(
                    new XVType[][] {
                      {new XVType(1.0, 2.0f), new XVType(3.0, 4.0f)},
                      {new XVType(5.0, 6.0f), new XVType(7.0, 8.0f)}
                    })),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\"\n  xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <uax:Value>\n    <uax:Matrix>\n      <uax:Dimensions>\n        <uax:Int32>2</uax:Int32>\n        <uax:Int32>2</uax:Int32>\n      </uax:Dimensions>\n      <uax:Elements>\n        <uax:ExtensionObject>\n          <uax:TypeId>\n            <uax:Identifier>i=12082</uax:Identifier>\n          </uax:TypeId>\n          <uax:Body>\n            <uax:XVType>\n              <uax:X>1.0</uax:X>\n              <uax:Value>2.0</uax:Value>\n            </uax:XVType>\n          </uax:Body>\n        </uax:ExtensionObject>\n        <uax:ExtensionObject>\n          <uax:TypeId>\n            <uax:Identifier>i=12082</uax:Identifier>\n          </uax:TypeId>\n          <uax:Body>\n            <uax:XVType>\n              <uax:X>3.0</uax:X>\n              <uax:Value>4.0</uax:Value>\n            </uax:XVType>\n          </uax:Body>\n        </uax:ExtensionObject>\n        <uax:ExtensionObject>\n          <uax:TypeId>\n            <uax:Identifier>i=12082</uax:Identifier>\n          </uax:TypeId>\n          <uax:Body>\n            <uax:XVType>\n              <uax:X>5.0</uax:X>\n              <uax:Value>6.0</uax:Value>\n            </uax:XVType>\n          </uax:Body>\n        </uax:ExtensionObject>\n        <uax:ExtensionObject>\n          <uax:TypeId>\n            <uax:Identifier>i=12082</uax:Identifier>\n          </uax:TypeId>\n          <uax:Body>\n            <uax:XVType>\n              <uax:X>7.0</uax:X>\n              <uax:Value>8.0</uax:Value>\n            </uax:XVType>\n          </uax:Body>\n        </uax:ExtensionObject>\n      </uax:Elements>\n    </uax:Matrix>\n  </uax:Value>\n</Test>\n"),

        // Enum matrix (2D)
        Arguments.of(
            Variant.ofMatrix(
                Matrix.ofEnum(
                    new ApplicationType[][] {
                      {ApplicationType.Server, ApplicationType.Client},
                      {ApplicationType.ClientAndServer, ApplicationType.DiscoveryServer}
                    })),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:Matrix>\n      <uax:Dimensions>\n        <uax:Int32>2</uax:Int32>\n        <uax:Int32>2</uax:Int32>\n      </uax:Dimensions>\n      <uax:Elements>\n        <uax:Int32>0</uax:Int32>\n        <uax:Int32>1</uax:Int32>\n        <uax:Int32>2</uax:Int32>\n        <uax:Int32>3</uax:Int32>\n      </uax:Elements>\n    </uax:Matrix>\n  </uax:Value>\n</Test>\n"),

        // OptionSetUI8 (AccessLevelType) 2D Matrix
        Arguments.of(
            Variant.ofMatrix(
                Matrix.ofOptionSetUI(
                    new AccessLevelType[][] {
                      {
                        AccessLevelType.of(AccessLevelType.Field.CurrentRead),
                        AccessLevelType.of(AccessLevelType.Field.CurrentWrite)
                      },
                      {
                        AccessLevelType.of(AccessLevelType.Field.HistoryRead),
                        AccessLevelType.of(AccessLevelType.Field.HistoryWrite)
                      }
                    })),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Value>\n    <uax:Matrix>\n      <uax:Dimensions>\n        <uax:Int32>2</uax:Int32>\n        <uax:Int32>2</uax:Int32>\n      </uax:Dimensions>\n      <uax:Elements>\n        <uax:Byte>1</uax:Byte>\n        <uax:Byte>2</uax:Byte>\n        <uax:Byte>4</uax:Byte>\n        <uax:Byte>8</uax:Byte>\n      </uax:Elements>\n    </uax:Matrix>\n  </uax:Value>\n</Test>\n"));
  }
}
