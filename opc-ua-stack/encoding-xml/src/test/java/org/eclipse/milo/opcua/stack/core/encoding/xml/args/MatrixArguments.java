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
import java.util.function.Function;
import java.util.stream.Stream;
import org.eclipse.milo.opcua.stack.core.encoding.DefaultEncodingContext;
import org.eclipse.milo.opcua.stack.core.encoding.xml.OpcUaDefaultXmlEncoding;
import org.eclipse.milo.opcua.stack.core.types.builtin.*;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UByte;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.ULong;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UShort;
import org.eclipse.milo.opcua.stack.core.types.enumerated.BrowseDirection;
import org.eclipse.milo.opcua.stack.core.types.structured.XVType;
import org.junit.jupiter.params.provider.Arguments;

@SuppressWarnings("unused")
public class MatrixArguments {

  public static Stream<Arguments> matrixOfBuiltinTypeArguments() {
    Stream<Stream<Arguments>> ss =
        Stream.of(
            booleanMatrixArguments(),
            sByteMatrixArguments(),
            byteMatrixArguments(),
            int16MatrixArguments(),
            uInt16MatrixArguments(),
            int32MatrixArguments(),
            uInt32MatrixArguments(),
            int64MatrixArguments(),
            uInt64MatrixArguments(),
            floatMatrixArguments(),
            doubleMatrixArguments(),
            stringMatrixArguments(),
            dateTimeMatrixArguments(),
            guidMatrixArguments(),
            byteStringMatrixArguments(),
            xmlElementMatrixArguments(),
            nodeIdMatrixArguments(),
            expandedNodeIdMatrixArguments(),
            statusCodeMatrixArguments(),
            qualifiedNameMatrixArguments(),
            localizedTextMatrixArguments(),
            extensionObjectMatrixArguments(),
            dataValueMatrixArguments(),
            variantMatrixArguments(),
            diagnosticInfoMatrixArguments());

    return ss.flatMap(Function.identity());
  }

  public static Stream<Arguments> matrixOfStructuredTypeArguments() {
    return Stream.of(
        Arguments.of(
            Matrix.ofStruct(
                new XVType[][] {
                  {new XVType(0.0, 1.0f), new XVType(2.0, 3.0f)},
                  {new XVType(4.0, 5.0f), new XVType(6.0, 7.0f)}
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\"\n  xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:ExtensionObject>\n      <uax:TypeId>\n        <uax:Identifier>i=12082</uax:Identifier>\n      </uax:TypeId>\n      <uax:Body>\n        <uax:XVType>\n          <uax:X>0.0</uax:X>\n          <uax:Value>1.0</uax:Value>\n        </uax:XVType>\n      </uax:Body>\n    </uax:ExtensionObject>\n    <uax:ExtensionObject>\n      <uax:TypeId>\n        <uax:Identifier>i=12082</uax:Identifier>\n      </uax:TypeId>\n      <uax:Body>\n        <uax:XVType>\n          <uax:X>2.0</uax:X>\n          <uax:Value>3.0</uax:Value>\n        </uax:XVType>\n      </uax:Body>\n    </uax:ExtensionObject>\n    <uax:ExtensionObject>\n      <uax:TypeId>\n        <uax:Identifier>i=12082</uax:Identifier>\n      </uax:TypeId>\n      <uax:Body>\n        <uax:XVType>\n          <uax:X>4.0</uax:X>\n          <uax:Value>5.0</uax:Value>\n        </uax:XVType>\n      </uax:Body>\n    </uax:ExtensionObject>\n    <uax:ExtensionObject>\n      <uax:TypeId>\n        <uax:Identifier>i=12082</uax:Identifier>\n      </uax:TypeId>\n      <uax:Body>\n        <uax:XVType>\n          <uax:X>6.0</uax:X>\n          <uax:Value>7.0</uax:Value>\n        </uax:XVType>\n      </uax:Body>\n    </uax:ExtensionObject>\n  </uax:Elements>\n</Test>\n"));
  }

  private static Stream<Arguments> booleanMatrixArguments() {
    return Stream.of(
        // Boolean 2D Matrix
        Arguments.of(
            Matrix.ofBoolean(new boolean[][] {{true, false}, {false, true}}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:Boolean>true</uax:Boolean>\n    <uax:Boolean>false</uax:Boolean>\n    <uax:Boolean>false</uax:Boolean>\n    <uax:Boolean>true</uax:Boolean>\n  </uax:Elements>\n</Test>\n"),

        // Boolean 3D Matrix
        Arguments.of(
            Matrix.ofBoolean(
                new boolean[][][] {{{true, false}, {false, true}}, {{false, false}, {true, true}}}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:Boolean>true</uax:Boolean>\n    <uax:Boolean>false</uax:Boolean>\n    <uax:Boolean>false</uax:Boolean>\n    <uax:Boolean>true</uax:Boolean>\n    <uax:Boolean>false</uax:Boolean>\n    <uax:Boolean>false</uax:Boolean>\n    <uax:Boolean>true</uax:Boolean>\n    <uax:Boolean>true</uax:Boolean>\n  </uax:Elements>\n</Test>\n"));
  }

  private static Stream<Arguments> sByteMatrixArguments() {
    return Stream.of(
        // SByte 2D Matrix
        Arguments.of(
            Matrix.ofSByte(new byte[][] {{-128, 0}, {0, 127}}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:SByte>-128</uax:SByte>\n    <uax:SByte>0</uax:SByte>\n    <uax:SByte>0</uax:SByte>\n    <uax:SByte>127</uax:SByte>\n  </uax:Elements>\n</Test>\n"),

        // SByte 3D Matrix
        Arguments.of(
            Matrix.ofSByte(new byte[][][] {{{-128, 0}, {0, 127}}, {{-1, -2}, {1, 2}}}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:SByte>-128</uax:SByte>\n    <uax:SByte>0</uax:SByte>\n    <uax:SByte>0</uax:SByte>\n    <uax:SByte>127</uax:SByte>\n    <uax:SByte>-1</uax:SByte>\n    <uax:SByte>-2</uax:SByte>\n    <uax:SByte>1</uax:SByte>\n    <uax:SByte>2</uax:SByte>\n  </uax:Elements>\n</Test>\n"));
  }

  private static Stream<Arguments> byteMatrixArguments() {
    return Stream.of(
        // Byte 2D Matrix
        Arguments.of(
            Matrix.ofByte(
                new UByte[][] {{UByte.MIN, UByte.valueOf(0)}, {UByte.valueOf(127), UByte.MAX}}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:Byte>0</uax:Byte>\n    <uax:Byte>0</uax:Byte>\n    <uax:Byte>127</uax:Byte>\n    <uax:Byte>255</uax:Byte>\n  </uax:Elements>\n</Test>\n"),

        // Byte 3D Matrix
        Arguments.of(
            Matrix.ofByte(
                new UByte[][][] {
                  {{UByte.MIN, UByte.valueOf(0)}, {UByte.valueOf(127), UByte.MAX}},
                  {{UByte.valueOf(10), UByte.valueOf(20)}, {UByte.valueOf(30), UByte.valueOf(40)}}
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:Byte>0</uax:Byte>\n    <uax:Byte>0</uax:Byte>\n    <uax:Byte>127</uax:Byte>\n    <uax:Byte>255</uax:Byte>\n    <uax:Byte>10</uax:Byte>\n    <uax:Byte>20</uax:Byte>\n    <uax:Byte>30</uax:Byte>\n    <uax:Byte>40</uax:Byte>\n  </uax:Elements>\n</Test>\n"));
  }

  private static Stream<Arguments> int16MatrixArguments() {
    return Stream.of(
        // Int16 2D Matrix
        Arguments.of(
            Matrix.ofInt16(new short[][] {{Short.MIN_VALUE, 0}, {0, Short.MAX_VALUE}}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:Int16>-32768</uax:Int16>\n    <uax:Int16>0</uax:Int16>\n    <uax:Int16>0</uax:Int16>\n    <uax:Int16>32767</uax:Int16>\n  </uax:Elements>\n</Test>\n"),

        // Int16 3D Matrix
        Arguments.of(
            Matrix.ofInt16(
                new short[][][] {
                  {{Short.MIN_VALUE, 0}, {0, Short.MAX_VALUE}},
                  {{-100, -200}, {100, 200}}
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:Int16>-32768</uax:Int16>\n    <uax:Int16>0</uax:Int16>\n    <uax:Int16>0</uax:Int16>\n    <uax:Int16>32767</uax:Int16>\n    <uax:Int16>-100</uax:Int16>\n    <uax:Int16>-200</uax:Int16>\n    <uax:Int16>100</uax:Int16>\n    <uax:Int16>200</uax:Int16>\n  </uax:Elements>\n</Test>\n"));
  }

  private static Stream<Arguments> uInt16MatrixArguments() {
    return Stream.of(
        // UInt16 2D Matrix
        Arguments.of(
            Matrix.ofUInt16(
                new UShort[][] {
                  {UShort.MIN, UShort.valueOf(0)}, {UShort.valueOf(1000), UShort.MAX}
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:UInt16>0</uax:UInt16>\n    <uax:UInt16>0</uax:UInt16>\n    <uax:UInt16>1000</uax:UInt16>\n    <uax:UInt16>65535</uax:UInt16>\n  </uax:Elements>\n</Test>\n"),

        // UInt16 3D Matrix
        Arguments.of(
            Matrix.ofUInt16(
                new UShort[][][] {
                  {{UShort.MIN, UShort.valueOf(0)}, {UShort.valueOf(1000), UShort.MAX}},
                  {
                    {UShort.valueOf(100), UShort.valueOf(200)},
                    {UShort.valueOf(300), UShort.valueOf(400)}
                  }
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:UInt16>0</uax:UInt16>\n    <uax:UInt16>0</uax:UInt16>\n    <uax:UInt16>1000</uax:UInt16>\n    <uax:UInt16>65535</uax:UInt16>\n    <uax:UInt16>100</uax:UInt16>\n    <uax:UInt16>200</uax:UInt16>\n    <uax:UInt16>300</uax:UInt16>\n    <uax:UInt16>400</uax:UInt16>\n  </uax:Elements>\n</Test>\n"));
  }

  private static Stream<Arguments> int32MatrixArguments() {
    return Stream.of(
        // Int32 2D Matrix
        Arguments.of(
            Matrix.ofInt32(new int[][] {{Integer.MIN_VALUE, 0}, {0, Integer.MAX_VALUE}}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:Int32>-2147483648</uax:Int32>\n    <uax:Int32>0</uax:Int32>\n    <uax:Int32>0</uax:Int32>\n    <uax:Int32>2147483647</uax:Int32>\n  </uax:Elements>\n</Test>\n"),

        // Int32 3D Matrix
        Arguments.of(
            Matrix.ofInt32(
                new int[][][] {
                  {{Integer.MIN_VALUE, 0}, {0, Integer.MAX_VALUE}},
                  {{-1000, -2000}, {1000, 2000}}
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:Int32>-2147483648</uax:Int32>\n    <uax:Int32>0</uax:Int32>\n    <uax:Int32>0</uax:Int32>\n    <uax:Int32>2147483647</uax:Int32>\n    <uax:Int32>-1000</uax:Int32>\n    <uax:Int32>-2000</uax:Int32>\n    <uax:Int32>1000</uax:Int32>\n    <uax:Int32>2000</uax:Int32>\n  </uax:Elements>\n</Test>\n"));
  }

  private static Stream<Arguments> uInt32MatrixArguments() {
    return Stream.of(
        // UInt32 2D Matrix
        Arguments.of(
            Matrix.ofUInt32(
                new UInteger[][] {
                  {UInteger.MIN, UInteger.valueOf(0)},
                  {UInteger.valueOf(1000000), UInteger.MAX}
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:UInt32>0</uax:UInt32>\n    <uax:UInt32>0</uax:UInt32>\n    <uax:UInt32>1000000</uax:UInt32>\n    <uax:UInt32>4294967295</uax:UInt32>\n  </uax:Elements>\n</Test>\n"),

        // UInt32 3D Matrix
        Arguments.of(
            Matrix.ofUInt32(
                new UInteger[][][] {
                  {{UInteger.MIN, UInteger.valueOf(0)}, {UInteger.valueOf(1000000), UInteger.MAX}},
                  {
                    {UInteger.valueOf(1000), UInteger.valueOf(2000)},
                    {UInteger.valueOf(3000), UInteger.valueOf(4000)}
                  }
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:UInt32>0</uax:UInt32>\n    <uax:UInt32>0</uax:UInt32>\n    <uax:UInt32>1000000</uax:UInt32>\n    <uax:UInt32>4294967295</uax:UInt32>\n    <uax:UInt32>1000</uax:UInt32>\n    <uax:UInt32>2000</uax:UInt32>\n    <uax:UInt32>3000</uax:UInt32>\n    <uax:UInt32>4000</uax:UInt32>\n  </uax:Elements>\n</Test>\n"));
  }

  private static Stream<Arguments> int64MatrixArguments() {
    return Stream.of(
        // Int64 2D Matrix
        Arguments.of(
            Matrix.ofInt64(new long[][] {{Long.MIN_VALUE, 0}, {0, Long.MAX_VALUE}}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:Int64>-9223372036854775808</uax:Int64>\n    <uax:Int64>0</uax:Int64>\n    <uax:Int64>0</uax:Int64>\n    <uax:Int64>9223372036854775807</uax:Int64>\n  </uax:Elements>\n</Test>\n"),

        // Int64 3D Matrix
        Arguments.of(
            Matrix.ofInt64(
                new long[][][] {
                  {{Long.MIN_VALUE, 0}, {0, Long.MAX_VALUE}},
                  {{-1000000, -2000000}, {1000000, 2000000}}
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:Int64>-9223372036854775808</uax:Int64>\n    <uax:Int64>0</uax:Int64>\n    <uax:Int64>0</uax:Int64>\n    <uax:Int64>9223372036854775807</uax:Int64>\n    <uax:Int64>-1000000</uax:Int64>\n    <uax:Int64>-2000000</uax:Int64>\n    <uax:Int64>1000000</uax:Int64>\n    <uax:Int64>2000000</uax:Int64>\n  </uax:Elements>\n</Test>\n"));
  }

  private static Stream<Arguments> uInt64MatrixArguments() {
    return Stream.of(
        // UInt64 2D Matrix
        Arguments.of(
            Matrix.ofUInt64(
                new ULong[][] {
                  {ULong.MIN, ULong.valueOf(0)},
                  {ULong.valueOf(1000000000L), ULong.MAX}
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:UInt64>0</uax:UInt64>\n    <uax:UInt64>0</uax:UInt64>\n    <uax:UInt64>1000000000</uax:UInt64>\n    <uax:UInt64>18446744073709551615</uax:UInt64>\n  </uax:Elements>\n</Test>\n"),

        // UInt64 3D Matrix
        Arguments.of(
            Matrix.ofUInt64(
                new ULong[][][] {
                  {{ULong.MIN, ULong.valueOf(0)}, {ULong.valueOf(1000000000L), ULong.MAX}},
                  {
                    {ULong.valueOf(1000), ULong.valueOf(2000)},
                    {ULong.valueOf(3000), ULong.valueOf(4000)}
                  }
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:UInt64>0</uax:UInt64>\n    <uax:UInt64>0</uax:UInt64>\n    <uax:UInt64>1000000000</uax:UInt64>\n    <uax:UInt64>18446744073709551615</uax:UInt64>\n    <uax:UInt64>1000</uax:UInt64>\n    <uax:UInt64>2000</uax:UInt64>\n    <uax:UInt64>3000</uax:UInt64>\n    <uax:UInt64>4000</uax:UInt64>\n  </uax:Elements>\n</Test>\n"));
  }

  private static Stream<Arguments> floatMatrixArguments() {
    return Stream.of(
        // Float 2D Matrix
        Arguments.of(
            Matrix.ofFloat(
                new float[][] {
                  {Float.MIN_VALUE, 0.0f},
                  {Float.MAX_VALUE, Float.POSITIVE_INFINITY}
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:Float>1.4E-45</uax:Float>\n    <uax:Float>0.0</uax:Float>\n    <uax:Float>3.4028235E38</uax:Float>\n    <uax:Float>INF</uax:Float>\n  </uax:Elements>\n</Test>\n"),

        // Float 3D Matrix
        Arguments.of(
            Matrix.ofFloat(
                new float[][][] {
                  {{Float.MIN_VALUE, 0.0f}, {Float.MAX_VALUE, Float.POSITIVE_INFINITY}},
                  {{Float.NaN, Float.NEGATIVE_INFINITY}, {1.0f, 2.0f}}
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:Float>1.4E-45</uax:Float>\n    <uax:Float>0.0</uax:Float>\n    <uax:Float>3.4028235E38</uax:Float>\n    <uax:Float>INF</uax:Float>\n    <uax:Float>NaN</uax:Float>\n    <uax:Float>-INF</uax:Float>\n    <uax:Float>1.0</uax:Float>\n    <uax:Float>2.0</uax:Float>\n  </uax:Elements>\n</Test>\n"));
  }

  private static Stream<Arguments> doubleMatrixArguments() {
    return Stream.of(
        // Double 2D Matrix
        Arguments.of(
            Matrix.ofDouble(
                new double[][] {
                  {Double.MIN_VALUE, 0.0},
                  {Double.MAX_VALUE, Double.POSITIVE_INFINITY}
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:Double>4.9E-324</uax:Double>\n    <uax:Double>0.0</uax:Double>\n    <uax:Double>1.7976931348623157E308</uax:Double>\n    <uax:Double>INF</uax:Double>\n  </uax:Elements>\n</Test>\n"),

        // Double 3D Matrix
        Arguments.of(
            Matrix.ofDouble(
                new double[][][] {
                  {{Double.MIN_VALUE, 0.0}, {Double.MAX_VALUE, Double.POSITIVE_INFINITY}},
                  {{Double.NaN, Double.NEGATIVE_INFINITY}, {1.0, 2.0}}
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:Double>4.9E-324</uax:Double>\n    <uax:Double>0.0</uax:Double>\n    <uax:Double>1.7976931348623157E308</uax:Double>\n    <uax:Double>INF</uax:Double>\n    <uax:Double>NaN</uax:Double>\n    <uax:Double>-INF</uax:Double>\n    <uax:Double>1.0</uax:Double>\n    <uax:Double>2.0</uax:Double>\n  </uax:Elements>\n</Test>\n"));
  }

  private static Stream<Arguments> stringMatrixArguments() {
    return Stream.of(
        // String 2D Matrix
        Arguments.of(
            Matrix.ofString(new String[][] {{"Hello", "World"}, {"Foo", "Bar"}}),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:String>Hello</uax:String>\n    <uax:String>World</uax:String>\n    <uax:String>Foo</uax:String>\n    <uax:String>Bar</uax:String>\n  </uax:Elements>\n</Test>\n"),

        // String 3D Matrix
        Arguments.of(
            Matrix.ofString(
                new String[][][] {
                  {{"Hello", "World"}, {"Foo", "Bar"}},
                  {{"Fizz", "Buzz"}, {"Ping", "Pong"}}
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:String>Hello</uax:String>\n    <uax:String>World</uax:String>\n    <uax:String>Foo</uax:String>\n    <uax:String>Bar</uax:String>\n    <uax:String>Fizz</uax:String>\n    <uax:String>Buzz</uax:String>\n    <uax:String>Ping</uax:String>\n    <uax:String>Pong</uax:String>\n  </uax:Elements>\n</Test>\n"));
  }

  private static Stream<Arguments> dateTimeMatrixArguments() {
    return Stream.of(
        // DateTime 2D Matrix
        Arguments.of(
            Matrix.ofDateTime(
                new DateTime[][] {
                  {
                    new DateTime(java.time.Instant.parse("2023-01-01T12:34:56Z")),
                    DateTime.MIN_DATE_TIME
                  },
                  {
                    DateTime.MAX_DATE_TIME,
                    new DateTime(java.time.Instant.parse("2022-02-02T00:00:00Z"))
                  }
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:DateTime>2023-01-01T12:34:56Z</uax:DateTime>\n    <uax:DateTime>0001-01-01T00:00:00Z</uax:DateTime>\n    <uax:DateTime>9999-12-31T23:59:59Z</uax:DateTime>\n    <uax:DateTime>2022-02-02T00:00:00Z</uax:DateTime>\n  </uax:Elements>\n</Test>\n"),

        // DateTime 3D Matrix
        Arguments.of(
            Matrix.ofDateTime(
                new DateTime[][][] {
                  {
                    {
                      new DateTime(java.time.Instant.parse("2023-01-01T12:34:56Z")),
                      DateTime.MIN_DATE_TIME
                    },
                    {
                      DateTime.MAX_DATE_TIME,
                      new DateTime(java.time.Instant.parse("2022-02-02T00:00:00Z"))
                    }
                  },
                  {
                    {
                      new DateTime(java.time.Instant.parse("2020-03-03T03:33:33Z")),
                      new DateTime(java.time.Instant.parse("2021-04-04T04:44:44Z"))
                    },
                    {
                      new DateTime(java.time.Instant.parse("2019-05-05T05:55:55Z")),
                      new DateTime(java.time.Instant.parse("2018-06-06T06:06:06Z"))
                    }
                  }
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:DateTime>2023-01-01T12:34:56Z</uax:DateTime>\n    <uax:DateTime>0001-01-01T00:00:00Z</uax:DateTime>\n    <uax:DateTime>9999-12-31T23:59:59Z</uax:DateTime>\n    <uax:DateTime>2022-02-02T00:00:00Z</uax:DateTime>\n    <uax:DateTime>2020-03-03T03:33:33Z</uax:DateTime>\n    <uax:DateTime>2021-04-04T04:44:44Z</uax:DateTime>\n    <uax:DateTime>2019-05-05T05:55:55Z</uax:DateTime>\n    <uax:DateTime>2018-06-06T06:06:06Z</uax:DateTime>\n  </uax:Elements>\n</Test>\n"));
  }

  private static Stream<Arguments> guidMatrixArguments() {
    return Stream.of(
        // Guid 2D Matrix
        Arguments.of(
            Matrix.ofGuid(
                new UUID[][] {
                  {
                    UUID.fromString("12345678-1234-1234-1234-123456789012"),
                    UUID.fromString("00000000-0000-0000-0000-000000000000")
                  },
                  {
                    UUID.fromString("AAAAAAAA-AAAA-AAAA-AAAA-AAAAAAAAAAAA"),
                    UUID.fromString("BBBBBBBB-BBBB-BBBB-BBBB-BBBBBBBBBBBB")
                  }
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:Guid>12345678-1234-1234-1234-123456789012</uax:Guid>\n    <uax:Guid>00000000-0000-0000-0000-000000000000</uax:Guid>\n    <uax:Guid>AAAAAAAA-AAAA-AAAA-AAAA-AAAAAAAAAAAA</uax:Guid>\n    <uax:Guid>BBBBBBBB-BBBB-BBBB-BBBB-BBBBBBBBBBBB</uax:Guid>\n  </uax:Elements>\n</Test>\n"),

        // Guid 3D Matrix
        Arguments.of(
            Matrix.ofGuid(
                new UUID[][][] {
                  {
                    {
                      UUID.fromString("12345678-1234-1234-1234-123456789012"),
                      UUID.fromString("00000000-0000-0000-0000-000000000000")
                    },
                    {
                      UUID.fromString("AAAAAAAA-AAAA-AAAA-AAAA-AAAAAAAAAAAA"),
                      UUID.fromString("BBBBBBBB-BBBB-BBBB-BBBB-BBBBBBBBBBBB")
                    }
                  },
                  {
                    {
                      UUID.fromString("CCCCCCCC-CCCC-CCCC-CCCC-CCCCCCCCCCCC"),
                      UUID.fromString("DDDDDDDD-DDDD-DDDD-DDDD-DDDDDDDDDDDD")
                    },
                    {
                      UUID.fromString("EEEEEEEE-EEEE-EEEE-EEEE-EEEEEEEEEEEE"),
                      UUID.fromString("FFFFFFFF-FFFF-FFFF-FFFF-FFFFFFFFFFFF")
                    }
                  }
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:Guid>12345678-1234-1234-1234-123456789012</uax:Guid>\n    <uax:Guid>00000000-0000-0000-0000-000000000000</uax:Guid>\n    <uax:Guid>AAAAAAAA-AAAA-AAAA-AAAA-AAAAAAAAAAAA</uax:Guid>\n    <uax:Guid>BBBBBBBB-BBBB-BBBB-BBBB-BBBBBBBBBBBB</uax:Guid>\n    <uax:Guid>CCCCCCCC-CCCC-CCCC-CCCC-CCCCCCCCCCCC</uax:Guid>\n    <uax:Guid>DDDDDDDD-DDDD-DDDD-DDDD-DDDDDDDDDDDD</uax:Guid>\n    <uax:Guid>EEEEEEEE-EEEE-EEEE-EEEE-EEEEEEEEEEEE</uax:Guid>\n    <uax:Guid>FFFFFFFF-FFFF-FFFF-FFFF-FFFFFFFFFFFF</uax:Guid>\n  </uax:Elements>\n</Test>\n"));
  }

  private static Stream<Arguments> byteStringMatrixArguments() {
    return Stream.of(
        // ByteString 2D Matrix
        Arguments.of(
            Matrix.ofByteString(
                new ByteString[][] {
                  {ByteString.of(new byte[] {1, 2, 3, 4}), ByteString.of(new byte[0])},
                  {ByteString.NULL_VALUE, ByteString.of(new byte[] {5, 6, 7, 8})}
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:ByteString>AQIDBA==</uax:ByteString>\n    <uax:ByteString></uax:ByteString>\n    <uax:ByteString></uax:ByteString>\n    <uax:ByteString>BQYHCA==</uax:ByteString>\n  </uax:Elements>\n</Test>\n"),

        // ByteString 3D Matrix
        Arguments.of(
            Matrix.ofByteString(
                new ByteString[][][] {
                  {
                    {ByteString.of(new byte[] {1, 2, 3, 4}), ByteString.of(new byte[0])},
                    {ByteString.NULL_VALUE, ByteString.of(new byte[] {5, 6, 7, 8})}
                  },
                  {
                    {
                      ByteString.of(new byte[] {9, 10, 11, 12}),
                      ByteString.of(new byte[] {13, 14, 15, 16})
                    },
                    {
                      ByteString.of(new byte[] {17, 18, 19, 20}),
                      ByteString.of(new byte[] {21, 22, 23, 24})
                    }
                  }
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:ByteString>AQIDBA==</uax:ByteString>\n    <uax:ByteString></uax:ByteString>\n    <uax:ByteString></uax:ByteString>\n    <uax:ByteString>BQYHCA==</uax:ByteString>\n    <uax:ByteString>CQoLDA==</uax:ByteString>\n    <uax:ByteString>DQ4PEA==</uax:ByteString>\n    <uax:ByteString>ERITFA==</uax:ByteString>\n    <uax:ByteString>FRYXGA==</uax:ByteString>\n  </uax:Elements>\n</Test>\n"));
  }

  private static Stream<Arguments> xmlElementMatrixArguments() {
    return Stream.of(
        Arguments.of(
            Matrix.ofXmlElement(
                new XmlElement[][] {
                  {
                    XmlElement.of("<SimpleElement>Hello, World!</SimpleElement>"),
                    XmlElement.of("<Empty></Empty>")
                  },
                  {
                    XmlElement.NULL_VALUE,
                    XmlElement.of("<Complex><Nested>Value</Nested></Complex>")
                  }
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:XmlElement><SimpleElement>Hello, World!</SimpleElement></uax:XmlElement>\n    <uax:XmlElement><Empty></Empty></uax:XmlElement>\n    <uax:XmlElement></uax:XmlElement>\n    <uax:XmlElement><Complex><Nested>Value</Nested></Complex></uax:XmlElement>\n  </uax:Elements>\n</Test>\n"));
  }

  private static Stream<Arguments> nodeIdMatrixArguments() {
    return Stream.of(
        // NodeId 2D Matrix
        Arguments.of(
            Matrix.ofNodeId(
                new NodeId[][] {
                  {new NodeId(0, 123), new NodeId(1, "Hello")},
                  {
                    new NodeId(2, UUID.fromString("12345678-1234-1234-1234-123456789012")),
                    new NodeId(3, ByteString.of(new byte[] {1, 2, 3, 4}))
                  }
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:NodeId>\n        <uax:Identifier>i=123</uax:Identifier>\n      </uax:NodeId>\n      <uax:NodeId>\n        <uax:Identifier>ns=1;s=Hello</uax:Identifier>\n      </uax:NodeId>\n      <uax:NodeId>\n        <uax:Identifier>ns=2;g=12345678-1234-1234-1234-123456789012</uax:Identifier>\n      </uax:NodeId>\n      <uax:NodeId>\n        <uax:Identifier>ns=3;b=AQIDBA==</uax:Identifier>\n      </uax:NodeId>\n  </uax:Elements>\n</Test>\n"),

        // NodeId 3D Matrix
        Arguments.of(
            Matrix.ofNodeId(
                new NodeId[][][] {
                  {
                    {new NodeId(0, 123), new NodeId(1, "Hello")},
                    {
                      new NodeId(2, UUID.fromString("12345678-1234-1234-1234-123456789012")),
                      new NodeId(3, ByteString.of(new byte[] {1, 2, 3, 4}))
                    }
                  },
                  {
                    {new NodeId(4, 456), new NodeId(5, "World")},
                    {
                      new NodeId(6, UUID.fromString("AAAAAAAA-AAAA-AAAA-AAAA-AAAAAAAAAAAA")),
                      new NodeId(7, ByteString.of(new byte[] {5, 6, 7, 8}))
                    }
                  }
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:NodeId>\n        <uax:Identifier>i=123</uax:Identifier>\n      </uax:NodeId>\n      <uax:NodeId>\n        <uax:Identifier>ns=1;s=Hello</uax:Identifier>\n      </uax:NodeId>\n      <uax:NodeId>\n        <uax:Identifier>ns=2;g=12345678-1234-1234-1234-123456789012</uax:Identifier>\n      </uax:NodeId>\n      <uax:NodeId>\n        <uax:Identifier>ns=3;b=AQIDBA==</uax:Identifier>\n      </uax:NodeId>\n      <uax:NodeId>\n        <uax:Identifier>ns=4;i=456</uax:Identifier>\n      </uax:NodeId>\n      <uax:NodeId>\n        <uax:Identifier>ns=5;s=World</uax:Identifier>\n      </uax:NodeId>\n      <uax:NodeId>\n        <uax:Identifier>ns=6;g=AAAAAAAA-AAAA-AAAA-AAAA-AAAAAAAAAAAA</uax:Identifier>\n      </uax:NodeId>\n      <uax:NodeId>\n        <uax:Identifier>ns=7;b=BQYHCA==</uax:Identifier>\n      </uax:NodeId>\n  </uax:Elements>\n</Test>\n"));
  }

  private static Stream<Arguments> expandedNodeIdMatrixArguments() {
    return Stream.of(
        Arguments.of(
            Matrix.ofExpandedNodeId(
                new ExpandedNodeId[][] {
                  {ExpandedNodeId.of(0, 123L), ExpandedNodeId.of(UShort.valueOf(1), "Hello")},
                  {
                    ExpandedNodeId.of(
                        UShort.valueOf(2), UUID.fromString("12345678-1234-1234-1234-123456789012")),
                    ExpandedNodeId.of("http://example.org/UA/", 123L)
                  }
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:ExpandedNodeId>\n        <uax:Identifier>i=123</uax:Identifier>\n      </uax:ExpandedNodeId>\n      <uax:ExpandedNodeId>\n        <uax:Identifier>ns=1;s=Hello</uax:Identifier>\n      </uax:ExpandedNodeId>\n      <uax:ExpandedNodeId>\n        <uax:Identifier>ns=2;g=12345678-1234-1234-1234-123456789012</uax:Identifier>\n      </uax:ExpandedNodeId>\n      <uax:ExpandedNodeId>\n        <uax:Identifier>nsu=http://example.org/UA/;i=123</uax:Identifier>\n      </uax:ExpandedNodeId>\n  </uax:Elements>\n</Test>\n"));
  }

  private static Stream<Arguments> statusCodeMatrixArguments() {
    return Stream.of(
        Arguments.of(
            Matrix.ofStatusCode(
                new StatusCode[][] {
                  {StatusCode.GOOD, StatusCode.BAD},
                  {
                    // Bad_InvalidState, Bad_UnexpectedError
                    new StatusCode(0x80340000L), new StatusCode(0x80020000L)
                  }
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:StatusCode>\n        <uax:Code>0</uax:Code>\n      </uax:StatusCode>\n      <uax:StatusCode>\n        <uax:Code>2147483648</uax:Code>\n      </uax:StatusCode>\n      <uax:StatusCode>\n        <uax:Code>2150891520</uax:Code>\n      </uax:StatusCode>\n      <uax:StatusCode>\n        <uax:Code>2147614720</uax:Code>\n      </uax:StatusCode>\n  </uax:Elements>\n</Test>\n"));
  }

  private static Stream<Arguments> qualifiedNameMatrixArguments() {
    return Stream.of(
        Arguments.of(
            Matrix.ofQualifiedName(
                new QualifiedName[][] {
                  {new QualifiedName(1, "TestName"), new QualifiedName(0, "DefaultNamespace")},
                  {new QualifiedName(2, ""), QualifiedName.NULL_VALUE}
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:QualifiedName>\n      <uax:NamespaceIndex>1</uax:NamespaceIndex>\n      <uax:Name>TestName</uax:Name>\n    </uax:QualifiedName>\n    <uax:QualifiedName>\n      <uax:NamespaceIndex>0</uax:NamespaceIndex>\n      <uax:Name>DefaultNamespace</uax:Name>\n    </uax:QualifiedName>\n    <uax:QualifiedName>\n      <uax:NamespaceIndex>2</uax:NamespaceIndex>\n      <uax:Name></uax:Name>\n    </uax:QualifiedName>\n    <uax:QualifiedName>\n      <uax:NamespaceIndex>0</uax:NamespaceIndex>\n    </uax:QualifiedName>\n  </uax:Elements>\n</Test>\n"));
  }

  private static Stream<Arguments> localizedTextMatrixArguments() {
    return Stream.of(
        Arguments.of(
            Matrix.ofLocalizedText(
                new LocalizedText[][] {
                  {new LocalizedText("en-US", "Hello, World!"), new LocalizedText("en-US", "")},
                  {new LocalizedText("", "Text Only"), LocalizedText.NULL_VALUE}
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:LocalizedText>\n      <uax:Locale>en-US</uax:Locale>\n      <uax:Text>Hello, World!</uax:Text>\n    </uax:LocalizedText>\n    <uax:LocalizedText>\n      <uax:Locale>en-US</uax:Locale>\n      <uax:Text></uax:Text>\n    </uax:LocalizedText>\n    <uax:LocalizedText>\n      <uax:Locale></uax:Locale>\n      <uax:Text>Text Only</uax:Text>\n    </uax:LocalizedText>\n    <uax:LocalizedText>\n    </uax:LocalizedText>\n  </uax:Elements>\n</Test>\n"));
  }

  private static Stream<Arguments> extensionObjectMatrixArguments() {
    return Stream.of(
        Arguments.of(
            Matrix.ofExtensionObject(
                new ExtensionObject[][] {
                  {
                    ExtensionObject.encode(
                        DefaultEncodingContext.INSTANCE,
                        new XVType(1.0, 2.0f),
                        OpcUaDefaultXmlEncoding.getInstance()),
                    ExtensionObject.encode(
                        DefaultEncodingContext.INSTANCE,
                        new XVType(3.0, 4.0f),
                        OpcUaDefaultXmlEncoding.getInstance())
                  },
                  {
                    ExtensionObject.encode(
                        DefaultEncodingContext.INSTANCE,
                        new XVType(5.0, 6.0f),
                        OpcUaDefaultXmlEncoding.getInstance()),
                    ExtensionObject.encode(
                        DefaultEncodingContext.INSTANCE,
                        new XVType(7.0, 8.0f),
                        OpcUaDefaultXmlEncoding.getInstance())
                  }
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\"\n  xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:ExtensionObject>\n      <uax:TypeId>\n        <uax:Identifier>i=12082</uax:Identifier>\n      </uax:TypeId>\n      <uax:Body>\n        <uax:XVType>\n          <uax:X>1.0</uax:X>\n          <uax:Value>2.0</uax:Value>\n        </uax:XVType>\n      </uax:Body>\n    </uax:ExtensionObject>\n    <uax:ExtensionObject>\n      <uax:TypeId>\n        <uax:Identifier>i=12082</uax:Identifier>\n      </uax:TypeId>\n      <uax:Body>\n        <uax:XVType>\n          <uax:X>3.0</uax:X>\n          <uax:Value>4.0</uax:Value>\n        </uax:XVType>\n      </uax:Body>\n    </uax:ExtensionObject>\n    <uax:ExtensionObject>\n      <uax:TypeId>\n        <uax:Identifier>i=12082</uax:Identifier>\n      </uax:TypeId>\n      <uax:Body>\n        <uax:XVType>\n          <uax:X>5.0</uax:X>\n          <uax:Value>6.0</uax:Value>\n        </uax:XVType>\n      </uax:Body>\n    </uax:ExtensionObject>\n    <uax:ExtensionObject>\n      <uax:TypeId>\n        <uax:Identifier>i=12082</uax:Identifier>\n      </uax:TypeId>\n      <uax:Body>\n        <uax:XVType>\n          <uax:X>7.0</uax:X>\n          <uax:Value>8.0</uax:Value>\n        </uax:XVType>\n      </uax:Body>\n    </uax:ExtensionObject>\n  </uax:Elements>\n</Test>\n"));
  }

  private static Stream<Arguments> dataValueMatrixArguments() {
    return Stream.of(
        Arguments.of(
            Matrix.ofDataValue(
                new DataValue[][] {
                  {DataValue.valueOnly(Variant.of(true)), DataValue.valueOnly(Variant.of(42))},
                  {
                    DataValue.valueOnly(Variant.of("Hello, World!")),
                    DataValue.valueOnly(Variant.of(new Double[] {1.0, 2.0, 3.0}))
                  }
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:DataValue>\n      <uax:Value>\n        <uax:Value>\n          <uax:Boolean>true</uax:Boolean>\n        </uax:Value>\n      </uax:Value>\n    </uax:DataValue>\n    <uax:DataValue>\n      <uax:Value>\n        <uax:Value>\n          <uax:Int32>42</uax:Int32>\n        </uax:Value>\n      </uax:Value>\n    </uax:DataValue>\n    <uax:DataValue>\n      <uax:Value>\n        <uax:Value>\n          <uax:String>Hello, World!</uax:String>\n        </uax:Value>\n      </uax:Value>\n    </uax:DataValue>\n    <uax:DataValue>\n      <uax:Value>\n        <uax:Value>\n          <uax:ListOfDouble>\n            <uax:Double>1.0</uax:Double>\n            <uax:Double>2.0</uax:Double>\n            <uax:Double>3.0</uax:Double>\n          </uax:ListOfDouble>\n        </uax:Value>\n      </uax:Value>\n    </uax:DataValue>\n  </uax:Elements>\n</Test>\n"));
  }

  private static Stream<Arguments> variantMatrixArguments() {
    return Stream.of(
        Arguments.of(
            Matrix.ofVariant(
                new Variant[][] {
                  {Variant.of(true), Variant.of(42)},
                  {Variant.of("Hello, World!"), Variant.of(new Double[] {1.0, 2.0, 3.0})}
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:Variant>\n      <uax:Value>\n        <uax:Boolean>true</uax:Boolean>\n      </uax:Value>\n    </uax:Variant>\n    <uax:Variant>\n      <uax:Value>\n        <uax:Int32>42</uax:Int32>\n      </uax:Value>\n    </uax:Variant>\n    <uax:Variant>\n      <uax:Value>\n        <uax:String>Hello, World!</uax:String>\n      </uax:Value>\n    </uax:Variant>\n    <uax:Variant>\n      <uax:Value>\n        <uax:ListOfDouble>\n          <uax:Double>1.0</uax:Double>\n          <uax:Double>2.0</uax:Double>\n          <uax:Double>3.0</uax:Double>\n        </uax:ListOfDouble>\n      </uax:Value>\n    </uax:Variant>\n  </uax:Elements>\n</Test>\n"));
  }

  private static Stream<Arguments> diagnosticInfoMatrixArguments() {
    return Stream.of(
        Arguments.of(
            Matrix.ofDiagnosticInfo(
                new DiagnosticInfo[][] {
                  {
                    new DiagnosticInfo(1, 2, 3, 4, "Additional Info", new StatusCode(5), null),
                    new DiagnosticInfo(-1, -1, -1, -1, "Only Additional Info", null, null)
                  },
                  {
                    new DiagnosticInfo(
                        -1,
                        -1,
                        -1,
                        -1,
                        null,
                        null,
                        new DiagnosticInfo(1, 2, 3, 4, "Additional Info", new StatusCode(5), null)),
                    new DiagnosticInfo(5, 6, 7, 8, "More Info", new StatusCode(9), null)
                  }
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:DiagnosticInfo>\n      <uax:SymbolicId>2</uax:SymbolicId>\n      <uax:NamespaceUri>1</uax:NamespaceUri>\n      <uax:Locale>3</uax:Locale>\n      <uax:LocalizedText>4</uax:LocalizedText>\n      <uax:AdditionalInfo>Additional Info</uax:AdditionalInfo>\n      <uax:InnerStatusCode>\n        <uax:Code>5</uax:Code>\n      </uax:InnerStatusCode>\n    </uax:DiagnosticInfo>\n    <uax:DiagnosticInfo>\n      <uax:SymbolicId>-1</uax:SymbolicId>\n      <uax:NamespaceUri>-1</uax:NamespaceUri>\n      <uax:Locale>-1</uax:Locale>\n      <uax:LocalizedText>-1</uax:LocalizedText>\n      <uax:AdditionalInfo>Only Additional Info</uax:AdditionalInfo>\n    </uax:DiagnosticInfo>\n    <uax:DiagnosticInfo>\n      <uax:SymbolicId>-1</uax:SymbolicId>\n      <uax:NamespaceUri>-1</uax:NamespaceUri>\n      <uax:Locale>-1</uax:Locale>\n      <uax:LocalizedText>-1</uax:LocalizedText>\n      <uax:InnerDiagnosticInfo>\n        <uax:SymbolicId>2</uax:SymbolicId>\n        <uax:NamespaceUri>1</uax:NamespaceUri>\n        <uax:Locale>3</uax:Locale>\n        <uax:LocalizedText>4</uax:LocalizedText>\n        <uax:AdditionalInfo>Additional Info</uax:AdditionalInfo>\n        <uax:InnerStatusCode>\n          <uax:Code>5</uax:Code>\n        </uax:InnerStatusCode>\n      </uax:InnerDiagnosticInfo>\n    </uax:DiagnosticInfo>\n    <uax:DiagnosticInfo>\n      <uax:SymbolicId>6</uax:SymbolicId>\n      <uax:NamespaceUri>5</uax:NamespaceUri>\n      <uax:Locale>7</uax:Locale>\n      <uax:LocalizedText>8</uax:LocalizedText>\n      <uax:AdditionalInfo>More Info</uax:AdditionalInfo>\n      <uax:InnerStatusCode>\n        <uax:Code>9</uax:Code>\n      </uax:InnerStatusCode>\n    </uax:DiagnosticInfo>\n  </uax:Elements>\n</Test>\n"));
  }

  public static Stream<Arguments> matrixOfEnumeratedTypeArguments() {
    return Stream.of(
        // BrowseDirection 2D Matrix
        Arguments.of(
            Matrix.ofEnum(
                new BrowseDirection[][] {
                  {BrowseDirection.Forward, BrowseDirection.Inverse},
                  {BrowseDirection.Both, BrowseDirection.Invalid}
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\"\n  xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:BrowseDirection>Forward_0</uax:BrowseDirection>\n    <uax:BrowseDirection>Inverse_1</uax:BrowseDirection>\n    <uax:BrowseDirection>Both_2</uax:BrowseDirection>\n    <uax:BrowseDirection>Invalid_3</uax:BrowseDirection>\n  </uax:Elements>\n</Test>\n"),

        // BrowseDirection 3D Matrix
        Arguments.of(
            Matrix.ofEnum(
                new BrowseDirection[][][] {
                  {
                    {BrowseDirection.Forward, BrowseDirection.Inverse},
                    {BrowseDirection.Both, BrowseDirection.Invalid}
                  },
                  {
                    {BrowseDirection.Inverse, BrowseDirection.Both},
                    {BrowseDirection.Forward, BrowseDirection.Invalid}
                  }
                }),
            "<Test xmlns:uax=\"http://opcfoundation.org/UA/2008/02/Types.xsd\"\n  xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n  <uax:Dimensions>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n    <uax:Int32>2</uax:Int32>\n  </uax:Dimensions>\n  <uax:Elements>\n    <uax:BrowseDirection>Forward_0</uax:BrowseDirection>\n    <uax:BrowseDirection>Inverse_1</uax:BrowseDirection>\n    <uax:BrowseDirection>Both_2</uax:BrowseDirection>\n    <uax:BrowseDirection>Invalid_3</uax:BrowseDirection>\n    <uax:BrowseDirection>Inverse_1</uax:BrowseDirection>\n    <uax:BrowseDirection>Both_2</uax:BrowseDirection>\n    <uax:BrowseDirection>Forward_0</uax:BrowseDirection>\n    <uax:BrowseDirection>Invalid_3</uax:BrowseDirection>\n  </uax:Elements>\n</Test>\n"));
  }
}
