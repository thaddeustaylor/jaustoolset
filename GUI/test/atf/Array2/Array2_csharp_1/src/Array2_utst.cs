/***********           LICENSE HEADER   *******************************
JAUS Tool Set
Copyright (c)  2010, United States Government
All rights reserved.

Redistribution and use in source and binary forms, with or without 
modification, are permitted provided that the following conditions are met:

       Redistributions of source code must retain the above copyright notice, 
this list of conditions and the following disclaimer.

       Redistributions in binary form must reproduce the above copyright 
notice, this list of conditions and the following disclaimer in the 
documentation and/or other materials provided with the distribution.

       Neither the name of the United States Government nor the names of 
its contributors may be used to endorse or promote products derived from 
this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE 
IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE 
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE 
LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR 
CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF 
SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS 
INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN 
CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
POSSIBILITY OF SUCH DAMAGE.
*********************  END OF LICENSE ***********************************/

using System;
using NUnit.Framework;
using urn_org_jts_test_Array2_1_0;

[TestFixture]
public class Array2_utst
{
    private MsgIn m_MsgIn1;
    private MsgIn m_MsgIn2;

    public Array2_utst()
    {
    }

    [SetUp]
    public void setUp()
    {
        m_MsgIn1 = new MsgIn();
        m_MsgIn2 = new MsgIn();
    }

    void tearDown()
    {
    }

    [Test]
    public void testConstructionDefaults()
    {
        Console.WriteLine("[executing test (testConstructionDefaults)]");

        // verifying MsgIn constructs with correct default MessageID"
        Assert.AreEqual(1, m_MsgIn1.getHeader().getHeaderRec().getMessageID());
        Assert.AreEqual(1, m_MsgIn2.getHeader().getHeaderRec().getMessageID());

        // verifying MsgIn constructs with correct default DimensionSize"
        Assert.AreEqual(3, m_MsgIn1.getBody().getRecord().getArray2().getRGBSize());
        Assert.AreEqual(1, m_MsgIn1.getBody().getRecord().getArray2().getColor_VectorSize());
        Assert.AreEqual(100, m_MsgIn1.getBody().getRecord().getArray2().getWidthSize());
        Assert.AreEqual(100, m_MsgIn1.getBody().getRecord().getArray2().getHeightSize());

        Assert.AreEqual(3, m_MsgIn2.getBody().getRecord().getArray2().getRGBSize());
        Assert.AreEqual(1, m_MsgIn2.getBody().getRecord().getArray2().getColor_VectorSize());
        Assert.AreEqual(100, m_MsgIn2.getBody().getRecord().getArray2().getWidthSize());
        Assert.AreEqual(100, m_MsgIn2.getBody().getRecord().getArray2().getHeightSize());
    }

    [Test]
    public void testSetGetOperations()
    {
        Console.WriteLine("[executing test (testSetGetOperations)(TP_3.3.5.1)]");

        // verifying setMessageID/getMessageID reciprocity"
        m_MsgIn1.getHeader().getHeaderRec().setMessageID(5);
        Assert.AreEqual(5, m_MsgIn1.getHeader().getHeaderRec().getMessageID());
        m_MsgIn1.getHeader().getHeaderRec().setMessageID(1);
        Assert.AreEqual(1, m_MsgIn1.getHeader().getHeaderRec().getMessageID());

        // verifying setPixel/getPixel reciprocity"    
        int i, j, k, l;
        sbyte val = 0;

        for (i = 0; i < m_MsgIn1.getBody().getRecord().getArray2().getRGBSize(); i++)
            for (j = 0; j < m_MsgIn1.getBody().getRecord().getArray2().getColor_VectorSize(); j++)
                for (k = 0; k < m_MsgIn1.getBody().getRecord().getArray2().getWidthSize(); k++)
                    for (l = 0; l < m_MsgIn1.getBody().getRecord().getArray2().getHeightSize(); l++)
                    {
                        m_MsgIn1.getBody().getRecord().getArray2().setPixel(i, j, k, l, val);
                        val++;
                        m_MsgIn2.getBody().getRecord().getArray2().setPixel(i, j, k, l, val);
                        val++;
                    }

        val = 0;
        int r;
        for (i = 0; i < m_MsgIn1.getBody().getRecord().getArray2().getRGBSize(); i++)
            for (j = 0; j < m_MsgIn1.getBody().getRecord().getArray2().getColor_VectorSize(); j++)
                for (k = 0; k < m_MsgIn1.getBody().getRecord().getArray2().getWidthSize(); k++)
                    for (l = 0; l < m_MsgIn1.getBody().getRecord().getArray2().getHeightSize(); l++)
                    {
                        if (m_MsgIn1.getBody().getRecord().getArray2().getPixel(i, j, k, l) != val)
                        {
                            r = m_MsgIn1.getBody().getRecord().getArray2().getPixel(i, j, k, l);
                            Console.Out.WriteLine("at MsgIn1 (" + i + ", " + j + ", " + k + ", " + l + "), expected " + val + ", found " + r);
                        }
                        Assert.AreEqual(val, m_MsgIn1.getBody().getRecord().getArray2().getPixel(i, j, k, l));
                        val++;
                        if (m_MsgIn2.getBody().getRecord().getArray2().getPixel(i, j, k, l) != val)
                        {
                            r = m_MsgIn2.getBody().getRecord().getArray2().getPixel(i, j, k, l);
                            Console.Out.WriteLine("at MsgIn2 (" + i + ", " + j + ", " + k + ", " + l + "), expected " + val + ", found " + r);
                        }
                        Assert.AreEqual(val, m_MsgIn2.getBody().getRecord().getArray2().getPixel(i, j, k, l));
                        val++;
                    }
    }

    [Test]
    public void testEncodeToSpec()
    {
        byte[] buff = new byte[40000];
        int i, j, k, l;
        sbyte val;

        Console.WriteLine("[executing test (testEncodeToSpec)(TP_3.3.5.2)]");

        m_MsgIn1.getHeader().getHeaderRec().setMessageID(256);
        val = 2;
        for (l = 0; l < m_MsgIn1.getBody().getRecord().getArray2().getHeightSize(); l++)
            for (k = 0; k < m_MsgIn1.getBody().getRecord().getArray2().getWidthSize(); k++)
                for (j = 0; j < m_MsgIn1.getBody().getRecord().getArray2().getColor_VectorSize(); j++)
                    for (i = 0; i < m_MsgIn1.getBody().getRecord().getArray2().getRGBSize(); i++)
                    {
                        m_MsgIn1.getBody().getRecord().getArray2().setPixel(i, j, k, l, val);
                        val++;
                    }

        // verifying message level encode is AS-5684 compliant"
        m_MsgIn1.encode(buff, 0);
        for (i = 0, val = 0; i < m_MsgIn1.getSize(); i++, val++)
            Assert.AreEqual(val, (sbyte)buff[i]);
    }

    [Test]
    public void testEncodeDecodeOperations()
    {
        byte[] buff = new byte[40000];
        int i, j, k, l;
        sbyte val;

        for (i = 0; i < 1024; i++)
            buff[i] = (byte)(((4101 * i) + 65543) % 256);

        Console.WriteLine("[executing test (testEncodeDecodeOperations)(TP_3.3.5.3)]");

        // verifying message level encode/decode reciprocity"

        m_MsgIn1.getHeader().getHeaderRec().setMessageID(41);
        m_MsgIn2.getHeader().getHeaderRec().setMessageID(0);
        val = 0;
        for (i = 0; i < m_MsgIn1.getBody().getRecord().getArray2().getRGBSize(); i++)
            for (j = 0; j < m_MsgIn1.getBody().getRecord().getArray2().getColor_VectorSize(); j++)
                for (k = 0; k < m_MsgIn1.getBody().getRecord().getArray2().getWidthSize(); k++)
                    for (l = 0; l < m_MsgIn1.getBody().getRecord().getArray2().getHeightSize(); l++)
                    {
                        m_MsgIn1.getBody().getRecord().getArray2().setPixel(i, j, k, l, val);
                        val += 7;
                        m_MsgIn2.getBody().getRecord().getArray2().setPixel(i, j, k, l, 0);
                    }
        m_MsgIn1.encode(buff, 0);
        m_MsgIn2.decode(buff, 0);

        Assert.AreEqual(41, m_MsgIn2.getHeader().getHeaderRec().getMessageID());
        val = 0;
        for (i = 0; i < m_MsgIn2.getBody().getRecord().getArray2().getRGBSize(); i++)
            for (j = 0; j < m_MsgIn2.getBody().getRecord().getArray2().getColor_VectorSize(); j++)
                for (k = 0; k < m_MsgIn2.getBody().getRecord().getArray2().getWidthSize(); k++)
                    for (l = 0; l < m_MsgIn2.getBody().getRecord().getArray2().getHeightSize(); l++)
                    {
                        Assert.AreEqual(val, m_MsgIn2.getBody().getRecord().getArray2().getPixel(i, j, k, l));
                        val += 7;
                    }

        // verifying header level encode/decode reciprocity"

        m_MsgIn2.getHeader().getHeaderRec().setMessageID(0);
        m_MsgIn1.getHeader().encode(buff, 0);
        m_MsgIn2.getHeader().decode(buff, 0);
        Assert.AreEqual(41, m_MsgIn2.getHeader().getHeaderRec().getMessageID());

        m_MsgIn2.getHeader().getHeaderRec().setMessageID(0);
        m_MsgIn1.getHeader().getHeaderRec().encode(buff, 0);
        m_MsgIn2.getHeader().getHeaderRec().decode(buff, 0);
        Assert.AreEqual(41, m_MsgIn2.getHeader().getHeaderRec().getMessageID());

        // verifying record level encode/decode reciprocity"

        for (i = 0; i < m_MsgIn1.getBody().getRecord().getArray2().getRGBSize(); i++)
            for (j = 0; j < m_MsgIn1.getBody().getRecord().getArray2().getColor_VectorSize(); j++)
                for (k = 0; k < m_MsgIn1.getBody().getRecord().getArray2().getWidthSize(); k++)
                    for (l = 0; l < m_MsgIn1.getBody().getRecord().getArray2().getHeightSize(); l++)
                        m_MsgIn2.getBody().getRecord().getArray2().setPixel(i, j, k, l, 0);

        m_MsgIn1.getBody().encode(buff, 0);
        m_MsgIn2.getBody().decode(buff, 0);

        val = 0;
        for (i = 0; i < m_MsgIn2.getBody().getRecord().getArray2().getRGBSize(); i++)
            for (j = 0; j < m_MsgIn2.getBody().getRecord().getArray2().getColor_VectorSize(); j++)
                for (k = 0; k < m_MsgIn2.getBody().getRecord().getArray2().getWidthSize(); k++)
                    for (l = 0; l < m_MsgIn2.getBody().getRecord().getArray2().getHeightSize(); l++)
                    {
                        Assert.AreEqual(val, m_MsgIn2.getBody().getRecord().getArray2().getPixel(i, j, k, l));
                        val += 7;
                    }

        for (i = 0; i < m_MsgIn1.getBody().getRecord().getArray2().getRGBSize(); i++)
            for (j = 0; j < m_MsgIn1.getBody().getRecord().getArray2().getColor_VectorSize(); j++)
                for (k = 0; k < m_MsgIn1.getBody().getRecord().getArray2().getWidthSize(); k++)
                    for (l = 0; l < m_MsgIn1.getBody().getRecord().getArray2().getHeightSize(); l++)
                        m_MsgIn2.getBody().getRecord().getArray2().setPixel(i, j, k, l, 0);

        m_MsgIn1.getBody().getRecord().encode(buff, 0);
        m_MsgIn2.getBody().getRecord().decode(buff, 0);

        val = 0;
        for (i = 0; i < m_MsgIn2.getBody().getRecord().getArray2().getRGBSize(); i++)
            for (j = 0; j < m_MsgIn2.getBody().getRecord().getArray2().getColor_VectorSize(); j++)
                for (k = 0; k < m_MsgIn2.getBody().getRecord().getArray2().getWidthSize(); k++)
                    for (l = 0; l < m_MsgIn2.getBody().getRecord().getArray2().getHeightSize(); l++)
                    {
                        Assert.AreEqual(val, m_MsgIn2.getBody().getRecord().getArray2().getPixel(i, j, k, l));
                        val += 7;
                    }

        for (i = 0; i < m_MsgIn1.getBody().getRecord().getArray2().getRGBSize(); i++)
            for (j = 0; j < m_MsgIn1.getBody().getRecord().getArray2().getColor_VectorSize(); j++)
                for (k = 0; k < m_MsgIn1.getBody().getRecord().getArray2().getWidthSize(); k++)
                    for (l = 0; l < m_MsgIn1.getBody().getRecord().getArray2().getHeightSize(); l++)
                        m_MsgIn2.getBody().getRecord().getArray2().setPixel(i, j, k, l, 0);

        m_MsgIn1.getBody().getRecord().getArray2().encode(buff, 0);
        m_MsgIn2.getBody().getRecord().getArray2().decode(buff, 0);

        val = 0;
        for (i = 0; i < m_MsgIn2.getBody().getRecord().getArray2().getRGBSize(); i++)
            for (j = 0; j < m_MsgIn2.getBody().getRecord().getArray2().getColor_VectorSize(); j++)
                for (k = 0; k < m_MsgIn2.getBody().getRecord().getArray2().getWidthSize(); k++)
                    for (l = 0; l < m_MsgIn2.getBody().getRecord().getArray2().getHeightSize(); l++)
                    {
                        Assert.AreEqual(val, m_MsgIn2.getBody().getRecord().getArray2().getPixel(i, j, k, l));
                        val += 7;
                    }
    }

    [Test]
    public void testEquality()
    {
        Console.WriteLine("[executing test (testEquality)]");
        // verifying message equality operator"    
        Assert.IsTrue(m_MsgIn1.isEqual(m_MsgIn1));
        Assert.IsTrue(m_MsgIn2.isEqual(m_MsgIn1));
        Assert.IsTrue(m_MsgIn1.isEqual(m_MsgIn2));
    }

    [Test]
    public void testInequality()
    {
        Console.WriteLine("[executing test (testInequality)]");
        // verifying message inequality operator"    

        Assert.IsFalse(m_MsgIn1.notEquals(m_MsgIn2));
        Assert.IsFalse(m_MsgIn2.notEquals(m_MsgIn1));
    }

    public static void Main()
    {
    }
}
