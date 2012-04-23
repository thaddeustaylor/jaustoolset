/***********           LICENSE HEADER   *******************************JAUS Tool SetCopyright (c)  2010, United States GovernmentAll rights reserved.Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.Neither the name of the United States Government nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. *********************  END OF LICENSE ***********************************/import java.nio.ByteBuffer;import src.urn_org_jts_test_Sequence3_1_0.Messages.MsgIn;import junit.textui.TestRunner;import junit.framework.TestCase;public class Sequence3_utst extends TestCase {    private MsgIn m_MsgIn1;    private MsgIn m_MsgIn2;    public Sequence3_utst(String message) {        super(message);    }    @Override    protected void setUp() {        m_MsgIn1 = new MsgIn();        m_MsgIn2 = new MsgIn();    }    @Override    protected void tearDown() {    }    public void testConstructionDefaults() {        System.out.println("");        System.out.print("[executing test (testConstructionDefaults)]: ");        // verifying MsgIn constructs with correct default MessageID"        assertEquals(1, m_MsgIn1.getHeader().getHeaderRec().getMessageID());        assertEquals(1, m_MsgIn2.getHeader().getHeaderRec().getMessageID());        //test assignment and compare operators.        MsgIn temp1 = new MsgIn();        MsgIn temp2 = new MsgIn();        MsgIn temp3 = new MsgIn();        temp1.getBody().getSequence3().getVariant1().getEventTypeRec().setEventType((short)1);        temp1.getBody().getSequence3().getVariant1().setFieldValue((short)1);        temp2.getBody().getSequence3().getVariant1().getEventTypeRec().setEventType((short)1);        temp2.getBody().getSequence3().getVariant1().setFieldValue((short)1);        assertTrue(temp2.isEqual(temp1));        temp3 = temp1;        assertTrue(temp3.isEqual(temp1));        assertEquals(1, temp3.getBody().getSequence3().getVariant1().getFieldValue());    }    public void testSetGetOperations() {        System.out.println("");        System.out.print("[executing test (testSetGetOperations)(TP_3.3.5.1)]: ");        // verifying setMessageID/getMessageID reciprocity"        m_MsgIn1.getHeader().getHeaderRec().setMessageID(5);        assertEquals(5, m_MsgIn1.getHeader().getHeaderRec().getMessageID());        m_MsgIn1.getHeader().getHeaderRec().setMessageID(1);        assertEquals(1, m_MsgIn1.getHeader().getHeaderRec().getMessageID());        // verifying setField1/getField1 reciprocity"            m_MsgIn1.getBody().getSequence3().getVariant1().getMessageIDRec().setMessageCode(65535);        m_MsgIn2.getBody().getSequence3().getVariant1().getMessageIDRec().setMessageCode(0);        assertEquals(65535, m_MsgIn1.getBody().getSequence3().getVariant1().getMessageIDRec().getMessageCode());        assertEquals(0, m_MsgIn2.getBody().getSequence3().getVariant1().getMessageIDRec().getMessageCode());        m_MsgIn1.getBody().getSequence3().getVariant1().getEventTypeRec().setEventType((short)1);        //this should fail as event type may only be 0 or 1        m_MsgIn1.getBody().getSequence3().getVariant1().getEventTypeRec().setEventType((short)129);        m_MsgIn2.getBody().getSequence3().getVariant1().getEventTypeRec().setEventType((short)0);        //this should fail as event type may only be 0 or 1        m_MsgIn2.getBody().getSequence3().getVariant1().getEventTypeRec().setEventType((short)251);        assertEquals(1, m_MsgIn1.getBody().getSequence3().getVariant1().getEventTypeRec().getEventType());        assertEquals(0, m_MsgIn2.getBody().getSequence3().getVariant1().getEventTypeRec().getEventType());        m_MsgIn1.getBody().getSequence3().getVariant1().getEventIDRec().setEventID((short)0);        m_MsgIn2.getBody().getSequence3().getVariant1().getEventIDRec().setEventID((short)1);        assertEquals(0, m_MsgIn1.getBody().getSequence3().getVariant1().getEventIDRec().getEventID());        assertEquals(1, m_MsgIn2.getBody().getSequence3().getVariant1().getEventIDRec().getEventID());        m_MsgIn1.getBody().getSequence3().getVariant1().getAllEventsRec().setAllEvents((short)0);        //this should fail as allevents may only be 0        m_MsgIn1.getBody().getSequence3().getVariant1().getAllEventsRec().setAllEvents((short)33);        m_MsgIn2.getBody().getSequence3().getVariant1().getAllEventsRec().setAllEvents((short)0);        m_MsgIn2.getBody().getSequence3().getVariant1().getAllEventsRec().setAllEvents((short)64);        assertEquals(0, m_MsgIn1.getBody().getSequence3().getVariant1().getAllEventsRec().getAllEvents());        assertEquals(0, m_MsgIn2.getBody().getSequence3().getVariant1().getAllEventsRec().getAllEvents());    }    public void testEncodeToSpec() {        ByteBuffer buff = ByteBuffer.allocate(1024);        int i;        System.out.println("");        System.out.print("[executing test (testEncodeToSpec)(TP_3.3.5.2)]: ");        m_MsgIn1.getHeader().getHeaderRec().setMessageID(256);        // verifying message level encode is AS-5684 compliant"        //case 1 - variant containing MessageIDRec        m_MsgIn1.getBody().getSequence3().getVariant1().getMessageIDRec().setMessageCode(1027);        m_MsgIn1.getBody().getSequence3().getVariant1().setFieldValue((short)0);        m_MsgIn1.encode(buff, 0);        assertEquals(5, m_MsgIn1.getSize());        assertEquals(0, buff.get(0));  //lsb of MessageID        assertEquals(1, buff.get(1));  //msb of MessageID        assertEquals(0, buff.get(2));  //vtag_field (run time record type)        assertEquals(3, buff.get(3));  //lsb of MessageCode        assertEquals(4, buff.get(4));  //msb of MessageCode        //case 2 - variant containing EventTypeRec        m_MsgIn1.getBody().getSequence3().getVariant1().getEventTypeRec().setEventType((short)1);        m_MsgIn1.getBody().getSequence3().getVariant1().setFieldValue((short)1);        m_MsgIn1.encode(buff, 0);        assertEquals(4, m_MsgIn1.getSize());        assertEquals(0, buff.get(0));  //lsb of MessageID        assertEquals(1, buff.get(1));  //msb of MessageID        assertEquals(1, buff.get(2));  //vtag_field (run time record type)        assertEquals(1, buff.get(3));  //EventType        //case 3 - variant containing EventIDRec        m_MsgIn1.getBody().getSequence3().getVariant1().getEventIDRec().setEventID((short)4);        m_MsgIn1.getBody().getSequence3().getVariant1().setFieldValue((short)2);        m_MsgIn1.encode(buff, 0);        assertEquals(4, m_MsgIn1.getSize());        assertEquals(0, buff.get(0));  //lsb of MessageID        assertEquals(1, buff.get(1));  //msb of MessageID        assertEquals(2, buff.get(2));  //vtag_field (run time record type)        assertEquals(4, buff.get(3));  //EventID        //case 4 - variant containing AllEventsRec        m_MsgIn1.getBody().getSequence3().getVariant1().getAllEventsRec().setAllEvents((short)0);        m_MsgIn1.getBody().getSequence3().getVariant1().setFieldValue((short)3);        m_MsgIn1.encode(buff, 0);        assertEquals(4, m_MsgIn1.getSize());        assertEquals(0, buff.get(0));  //lsb of MessageID        assertEquals(1, buff.get(1));  //msb of MessageID        assertEquals(3, buff.get(2));  //vtag_field (run time record type)        assertEquals(0, buff.get(3));  //allEvents    }    public void testEncodeDecodeOperations() {        ByteBuffer buff = ByteBuffer.allocate(1024);        int i;        for (i = 0; i < 1024; i++) {            buff.put(i, (byte) (((4101 * i) + 65543) % 256));        }        System.out.println("");        System.out.print("[executing test (testEncodeDecodeOperations)(TP_3.3.5.3)]: ");        // verifying message level encode/decode reciprocity"        m_MsgIn1.getHeader().getHeaderRec().setMessageID(121);        m_MsgIn1.getBody().getSequence3().getVariant1().setFieldValue((short)0);        m_MsgIn2.getHeader().getHeaderRec().setMessageID(127);        m_MsgIn1.encode(buff, 0);        m_MsgIn2.decode(buff, 0);        assertEquals(121, m_MsgIn2.getHeader().getHeaderRec().getMessageID());        assertEquals(0, m_MsgIn2.getBody().getSequence3().getVariant1().getFieldValue());        m_MsgIn2.getBody().getSequence3().getVariant1().getMessageIDRec().setMessageCode(127);        m_MsgIn2.getHeader().getHeaderRec().setMessageID(127);        m_MsgIn1.encode(buff, 0);        m_MsgIn2.decode(buff, 0);        assertEquals(121, m_MsgIn2.getHeader().getHeaderRec().getMessageID());        assertEquals(0, m_MsgIn2.getBody().getSequence3().getVariant1().getFieldValue());        m_MsgIn1.getBody().getSequence3().getVariant1().getEventTypeRec().setEventType((short)1);        m_MsgIn1.getBody().getSequence3().getVariant1().setFieldValue((short)1);        m_MsgIn2.getHeader().getHeaderRec().setMessageID(127);        m_MsgIn2.getBody().getSequence3().getVariant1().getMessageIDRec().setMessageCode(127);        m_MsgIn1.encode(buff, 0);        m_MsgIn2.decode(buff, 0);        assertEquals(121, m_MsgIn2.getHeader().getHeaderRec().getMessageID());        assertEquals(1, m_MsgIn2.getBody().getSequence3().getVariant1().getFieldValue());        assertEquals(1, m_MsgIn2.getBody().getSequence3().getVariant1().getEventTypeRec().getEventType());        m_MsgIn1.getBody().getSequence3().getVariant1().getEventIDRec().setEventID((short)101);        m_MsgIn1.getBody().getSequence3().getVariant1().setFieldValue((short)2);        m_MsgIn2.getHeader().getHeaderRec().setMessageID(127);        m_MsgIn2.getBody().getSequence3().getVariant1().getMessageIDRec().setMessageCode(127);        m_MsgIn1.encode(buff, 0);        m_MsgIn2.decode(buff, 0);        assertEquals(121, m_MsgIn2.getHeader().getHeaderRec().getMessageID());        assertEquals(2, m_MsgIn2.getBody().getSequence3().getVariant1().getFieldValue());        assertEquals(101, m_MsgIn2.getBody().getSequence3().getVariant1().getEventIDRec().getEventID());        // verifying header level encode/decode reciprocity"        m_MsgIn2.getHeader().getHeaderRec().setMessageID(0);        m_MsgIn1.getHeader().encode(buff, 0);        m_MsgIn2.getHeader().decode(buff, 0);        assertEquals(121, m_MsgIn2.getHeader().getHeaderRec().getMessageID());        m_MsgIn2.getHeader().getHeaderRec().setMessageID(0);        m_MsgIn1.getHeader().getHeaderRec().encode(buff, 0);        m_MsgIn2.getHeader().getHeaderRec().decode(buff, 0);        assertEquals(121, m_MsgIn2.getHeader().getHeaderRec().getMessageID());        // verifying record level encode/decode reciprocity"        m_MsgIn2.getBody().getSequence3().getVariant1().getMessageIDRec().setMessageCode(0);        m_MsgIn1.getBody().encode(buff, 0);        m_MsgIn2.getBody().decode(buff, 0);//    assertEquals(3, m_MsgIn2.getBody().getSequence3().getVariant1().getFieldValue());        assertEquals(101, m_MsgIn2.getBody().getSequence3().getVariant1().getEventIDRec().getEventID());        m_MsgIn2.getBody().getSequence3().getVariant1().getMessageIDRec().setMessageCode(0);        m_MsgIn1.getBody().getSequence3().getVariant1().encode(buff, 0);        m_MsgIn2.getBody().getSequence3().getVariant1().decode(buff, 0);//    assertEquals(3, m_MsgIn2.getBody().getSequence3().getVariant1().getFieldValue());        assertEquals(101, m_MsgIn2.getBody().getSequence3().getVariant1().getEventIDRec().getEventID());    }    public void testEquality() {        System.out.println("");        System.out.print("[executing test (testEquality)]: ");        // verifying message equality operator"            assertTrue(m_MsgIn1.isEqual(m_MsgIn1));        assertTrue(m_MsgIn1.isEqual(m_MsgIn2));        assertTrue(m_MsgIn2.isEqual(m_MsgIn1));    }    public void testInequality() {        System.out.println("");        System.out.print("[executing test (testInequality)]: ");        // verifying message inequality operator"            assertFalse(m_MsgIn1.notEquals(m_MsgIn2));        assertFalse(m_MsgIn2.notEquals(m_MsgIn1));    }    public static void main(String[] args) {        System.out.println("Executing suite JTSSequence3MessageTest");        TestRunner.run(Sequence3_utst.class);        System.out.println("Completed suite JTSSequence3MessageTest");        System.out.println("------------------------------------------------");    }}