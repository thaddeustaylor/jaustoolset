/***********           LICENSE HEADER   *******************************JAUS Tool SetCopyright (c)  2010, United States GovernmentAll rights reserved.Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:       Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.       Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.       Neither the name of the United States Government nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.*********************  END OF LICENSE ***********************************/import java.nio.ByteBuffer;import src.urn_org_jts_test_Array3_1_0.Messages.MsgIn;import junit.textui.TestRunner;import junit.framework.TestCase;public class Array3_utst extends TestCase {  private MsgIn m_MsgIn1;  private MsgIn m_MsgIn2;    public Array3_utst(String name) {     super(name);  }              protected void setUp()  {        m_MsgIn1 = new MsgIn();        m_MsgIn2 = new MsgIn();  }  protected void tearDown()   {  }  public void testConstructionDefaults()  {      System.out.println("");        System.out.print("[executing test (testConstructionDefaults)]: ");        // verifying MsgIn constructs with correct default MessageID"    assertEquals(1, m_MsgIn1.getHeader().getHeaderRec().getMessageID());    assertEquals(1, m_MsgIn2.getHeader().getHeaderRec().getMessageID());        // verifying MsgIn constructs with correct default DimensionSize"    assertEquals(9, m_MsgIn1.getBody().getRecord().getArray3().getRowSize());    assertEquals(3, m_MsgIn1.getBody().getRecord().getArray3().getColSize());        assertEquals(9, m_MsgIn2.getBody().getRecord().getArray3().getRowSize());    assertEquals(3, m_MsgIn2.getBody().getRecord().getArray3().getColSize());  }    public void testSetGetOperations()  {      System.out.println("");        System.out.print("[executing test (testSetGetOperations)(TP_3.3.5.1)]: ");            // verifying setMessageID/getMessageID reciprocity"    m_MsgIn1.getHeader().getHeaderRec().setMessageID(5);    assertEquals(5, m_MsgIn1.getHeader().getHeaderRec().getMessageID());    m_MsgIn1.getHeader().getHeaderRec().setMessageID(1);    assertEquals(1, m_MsgIn1.getHeader().getHeaderRec().getMessageID());        // verifying setField/getField reciprocity"        int i,j;    byte val = 0;    for (i=0;i<m_MsgIn1.getBody().getRecord().getArray3().getRowSize();i++)       for (j=0;j<m_MsgIn1.getBody().getRecord().getArray3().getColSize();j++)    {        m_MsgIn1.getBody().getRecord().getArray3().setField1(i,j,val);        val++;        m_MsgIn2.getBody().getRecord().getArray3().setField1(i,j,val);        val++;    }        val = 0;    int r;    for (i=0;i<m_MsgIn1.getBody().getRecord().getArray3().getRowSize();i++)       for (j=0;j<m_MsgIn1.getBody().getRecord().getArray3().getColSize();j++)    {        assertEquals(val, m_MsgIn1.getBody().getRecord().getArray3().getField1(i,j));        val++;         assertEquals(val, m_MsgIn2.getBody().getRecord().getArray3().getField1(i,j));        val++;    }  }  public void testEncodeToSpec()  {    ByteBuffer buff = ByteBuffer.allocate(40000);    int i,j;    byte val;    System.out.println("");        System.out.print("[executing test (testEncodeToSpec)(TP_3.3.5.2)]: ");        m_MsgIn1.getHeader().getHeaderRec().setMessageID(256);    val = 2;    for (j=0;j<m_MsgIn1.getBody().getRecord().getArray3().getColSize();j++)       for (i=0;i<m_MsgIn1.getBody().getRecord().getArray3().getRowSize();i++)                 {        m_MsgIn1.getBody().getRecord().getArray3().setField1(i,j, val);        val++;    }                // verifying message level encode is AS-5684 compliant"    m_MsgIn1.encode(buff, 0);    for (i=0,val=0;i<m_MsgIn1.getSize();i++,val++)        assertEquals(val, buff.get(i));  }    public void testEncodeDecodeOperations()  {    ByteBuffer buff = ByteBuffer.allocate(40000);    int i,j;    byte val;        for (i=0;i<1024;i++)       buff.put(i, (byte)(((4101*i)+65543) % 256));      System.out.println("");        System.out.print("[executing test (testEncodeDecodeOperations)(TP_3.3.5.3)]: ");            // verifying message level encode/decode reciprocity"    m_MsgIn1.getHeader().getHeaderRec().setMessageID(41);    m_MsgIn2.getHeader().getHeaderRec().setMessageID(0);    val = 0;    for (i=0;i<m_MsgIn1.getBody().getRecord().getArray3().getRowSize();i++)       for (j=0;j<m_MsgIn1.getBody().getRecord().getArray3().getColSize();j++)    {        m_MsgIn1.getBody().getRecord().getArray3().setField1(i,j,val);        val+=7;        m_MsgIn2.getBody().getRecord().getArray3().setField1(i,j,(byte)0);    }    m_MsgIn1.encode(buff, 0);    m_MsgIn2.decode(buff, 0);        assertEquals(41, m_MsgIn2.getHeader().getHeaderRec().getMessageID());    val = 0;    for (i=0;i<m_MsgIn2.getBody().getRecord().getArray3().getRowSize();i++)       for (j=0;j<m_MsgIn2.getBody().getRecord().getArray3().getColSize();j++)    {        assertEquals(val, m_MsgIn2.getBody().getRecord().getArray3().getField1(i,j));        val+=7;    }            // verifying header level encode/decode reciprocity"        m_MsgIn2.getHeader().getHeaderRec().setMessageID(0);    m_MsgIn1.getHeader().encode(buff, 0);    m_MsgIn2.getHeader().decode(buff, 0);    assertEquals(41, m_MsgIn2.getHeader().getHeaderRec().getMessageID());    m_MsgIn2.getHeader().getHeaderRec().setMessageID(0);    m_MsgIn1.getHeader().getHeaderRec().encode(buff, 0);    m_MsgIn2.getHeader().getHeaderRec().decode(buff, 0);    assertEquals(41, m_MsgIn2.getHeader().getHeaderRec().getMessageID());        // verifying record level encode/decode reciprocity"    for (i=0;i<m_MsgIn1.getBody().getRecord().getArray3().getRowSize();i++)       for (j=0;j<m_MsgIn1.getBody().getRecord().getArray3().getColSize();j++)        m_MsgIn2.getBody().getRecord().getArray3().setField1(i,j,(byte)0);            m_MsgIn1.getBody().encode(buff, 0);    m_MsgIn2.getBody().decode(buff, 0);        val = 0;    for (i=0;i<m_MsgIn2.getBody().getRecord().getArray3().getRowSize();i++)       for (j=0;j<m_MsgIn2.getBody().getRecord().getArray3().getColSize();j++)    {        assertEquals(val, m_MsgIn2.getBody().getRecord().getArray3().getField1(i,j));        val+=7;    }    for (i=0;i<m_MsgIn1.getBody().getRecord().getArray3().getRowSize();i++)       for (j=0;j<m_MsgIn1.getBody().getRecord().getArray3().getColSize();j++)        m_MsgIn2.getBody().getRecord().getArray3().setField1(i,j,(byte)0);            m_MsgIn1.getBody().getRecord().encode(buff, 0);    m_MsgIn2.getBody().getRecord().decode(buff, 0);        val = 0;    for (i=0;i<m_MsgIn2.getBody().getRecord().getArray3().getRowSize();i++)       for (j=0;j<m_MsgIn2.getBody().getRecord().getArray3().getColSize();j++)    {        assertEquals(val, m_MsgIn2.getBody().getRecord().getArray3().getField1(i,j));        val+=7;    }            for (i=0;i<m_MsgIn1.getBody().getRecord().getArray3().getRowSize();i++)       for (j=0;j<m_MsgIn1.getBody().getRecord().getArray3().getColSize();j++)        m_MsgIn2.getBody().getRecord().getArray3().setField1(i,j,(byte)0);            m_MsgIn1.getBody().getRecord().getArray3().encode(buff, 0);    m_MsgIn2.getBody().getRecord().getArray3().decode(buff, 0);        val = 0;    for (i=0;i<m_MsgIn2.getBody().getRecord().getArray3().getRowSize();i++)       for (j=0;j<m_MsgIn2.getBody().getRecord().getArray3().getColSize();j++)    {        assertEquals(val, m_MsgIn2.getBody().getRecord().getArray3().getField1(i,j));        val+=7;    }         }  public void testEquality()  {        System.out.println("[executing test (testEquality)]");        // verifying message equality operator"            assertTrue(m_MsgIn1.isEqual(m_MsgIn1));        assertTrue(m_MsgIn1.isEqual(m_MsgIn2));        assertTrue(m_MsgIn2.isEqual(m_MsgIn1));  }    public void testInequality()  {        System.out.println("[executing test (testInequality)]");        // verifying message inequality operator"                   assertFalse(m_MsgIn1.notEquals(m_MsgIn2));        assertFalse(m_MsgIn2.notEquals(m_MsgIn1));  }    public static void main(String[] args) {        System.out.println("Executing suite JTSSequence1MessageTest");        TestRunner.run(Array3_utst.class);        System.out.println("Completed suite JTSSequence1MessageTest");        System.out.println("------------------------------------------------");    }}