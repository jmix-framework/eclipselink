/*
 * Copyright (c) 1998, 2021 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0,
 * or the Eclipse Distribution License v. 1.0 which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: EPL-2.0 OR BSD-3-Clause
 */

// Contributors:
//   Denise Smith - April 23/2009 - 2.0
package org.eclipse.persistence.testing.oxm.xmlconversionmanager;

import java.math.BigDecimal;
import java.math.BigInteger;

import junit.textui.TestRunner;

import org.eclipse.persistence.internal.oxm.XMLConversionManager;
import org.eclipse.persistence.oxm.XMLConstants;
import org.eclipse.persistence.testing.oxm.OXTestCase;

public class NumberTestCases extends OXTestCase {

    XMLConversionManager xmlConversionManager;

    @Override
    public void setUp() {
        xmlConversionManager = XMLConversionManager.getDefaultXMLManager();
    }

    public NumberTestCases(String name) {
        super(name);
    }

    public void testConvertWithPlusToByte() {
        Byte controlByte = Byte.valueOf("1");
        Byte testByte = xmlConversionManager.convertObject("+1", Byte.class);
        String testString = String.valueOf(testByte);
        String controlString = String.valueOf(controlByte);
        assertEquals(controlString, testString);
    }

    public void testConvertWithPlusToInteger() {
        Integer controlInteger = Integer.valueOf("1");
        Integer testInteger = xmlConversionManager.convertObject("+1", Integer.class);
        String testString = String.valueOf(testInteger);
        String controlString = String.valueOf(controlInteger);
        assertEquals(controlString, testString);
    }

    public void testConvertWithMinuToByte() {
        Byte controlByte = Byte.valueOf("-1");
        Byte testByte = xmlConversionManager.convertObject("-1", Byte.class);
        String testString = String.valueOf(testByte);
        String controlString = String.valueOf(controlByte);
        assertEquals(controlString, testString);
    }

    public void testConvertWithMinusToInteger() {
        Integer controlInteger = Integer.valueOf("-1");
        Integer testInteger = xmlConversionManager.convertObject("-1", Integer.class);
        String testString = String.valueOf(testInteger);
        String controlString = String.valueOf(controlInteger);
        assertEquals(controlString, testString);
    }

    public void testConvertEmptyStringTo_byte() {
        byte test = xmlConversionManager.convertObject(XMLConstants.EMPTY_STRING, byte.class);
        assertEquals(0, test);
    }

    public void testConvertEmptyStringTo_Byte() {
        Byte test = xmlConversionManager.convertObject(XMLConstants.EMPTY_STRING, Byte.class);
        assertEquals(0, test.byteValue());
    }

    public void testConvertEmptyStringTo_double() {
        double test = xmlConversionManager.convertObject(XMLConstants.EMPTY_STRING, double.class);
        assertEquals(0.0, test);
    }

    public void testConvertEmptyStringTo_Double() {
        Double test = xmlConversionManager.convertObject(XMLConstants.EMPTY_STRING, Double.class);
        assertEquals(0.0, test);
    }

    public void testConvertEmptyStringTo_float() {
        float test = xmlConversionManager.convertObject(XMLConstants.EMPTY_STRING, float.class);
        assertEquals(0.0, test, 0);
    }

    public void testConvertEmptyStringTo_Float() {
        Float test = xmlConversionManager.convertObject(XMLConstants.EMPTY_STRING, Float.class);
        assertEquals(0.0, test, 0);
    }

    public void testConvertEmptyStringTo_int() {
        int test = xmlConversionManager.convertObject(XMLConstants.EMPTY_STRING, int.class);
        assertEquals(0, test);
    }

    public void testConvertEmptyStringTo_Integer() {
        Integer test = xmlConversionManager.convertObject(XMLConstants.EMPTY_STRING, Integer.class);
        assertEquals(0, test.intValue());
    }

    public void testConvertEmptyStringTo_long() {
        long test = xmlConversionManager.convertObject(XMLConstants.EMPTY_STRING, long.class);
        assertEquals(0, test);
    }

    public void testConvertEmptyStringTo_Long() {
        Long test = xmlConversionManager.convertObject(XMLConstants.EMPTY_STRING, Long.class);
        assertEquals(0, test.longValue());
    }

    public void testConvertEmptyStringTo_short() {
        short test = xmlConversionManager.convertObject(XMLConstants.EMPTY_STRING, short.class);
        assertEquals(0, test);
    }

    public void testConvertEmptyStringTo_Short() {
        Short test = xmlConversionManager.convertObject(XMLConstants.EMPTY_STRING, Short.class);
        assertEquals(0, test.shortValue());
    }

    public void testConvertEmptyStringTo_BigDecimal() {
        BigDecimal test = xmlConversionManager.convertObject(XMLConstants.EMPTY_STRING, BigDecimal.class);
        assertNull(test);
    }

    public void testConvertEmptyStringTo_BigInteger() {
        BigInteger test = xmlConversionManager.convertObject(XMLConstants.EMPTY_STRING, BigInteger.class);
        assertNull(test);
    }

    // Bug 21561562 - xmlconversionmanager bigdecimal to xsd:decimal is wrong
    public void testConvertBigDecimalTo_String() {
        String controlString = "0.000000001";
        BigDecimal controlBigDecimal = new BigDecimal(controlString);
        String testString = xmlConversionManager.convertObject(controlBigDecimal, String.class);
        assertEquals(controlString, testString);
    }

    // Bug 21561562 - xmlconversionmanager bigdecimal to xsd:decimal is wrong
    public void testConvertBigDecimalWithQNameTo_String() {
        String controlString = "0.000000001";
        BigDecimal controlBigDecimal = new BigDecimal(controlString);
        String testString = xmlConversionManager.convertObject(controlBigDecimal, String.class, XMLConstants.STRING_QNAME);
        assertEquals(controlString, testString);
    }

    public static void main(String[] args) {
        String[] arguments = { "-c", "org.eclipse.persistence.testing.oxm.xmlconversionmanager.NumberTestCases" };
        TestRunner.main(arguments);
    }
}
