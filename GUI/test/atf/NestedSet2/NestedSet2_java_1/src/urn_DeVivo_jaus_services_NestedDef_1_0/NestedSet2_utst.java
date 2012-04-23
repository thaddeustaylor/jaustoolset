/***********           LICENSE HEADER   *******************************JAUS Tool SetCopyright (c)  2010, United States GovernmentAll rights reserved.Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.Neither the name of the United States Government nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. *********************  END OF LICENSE ***********************************/package src.urn_DeVivo_jaus_services_NestedDef_1_0;import junit.textui.TestRunner;import junit.framework.TestCase;public class NestedSet2_utst extends TestCase {    class TestFlagsClass {        public byte LastState;        public byte[] StateHistory = new byte[255];    }    class NestedStateMachnImpl extends NestedDef2_NestedStateMachn {        NestedStateMachnImpl() {            TFC = new TestFlagsClass();        }        /// Action Methods        public void EnteredStandbyStateAction() {        }        public void Entered_K1Action() {            TFC.StateHistory[TFC.LastState++] = 1;        }        public void Entered_K2Action() {            TFC.StateHistory[TFC.LastState++] = 2;        }        public void Entered_K3Action() {            TFC.StateHistory[TFC.LastState++] = 3;        }        public void Entered_PAAction() {        }        public void Entered_PBAction() {        }        public void Entered_PCAction() {            TFC.StateHistory[TFC.LastState++] = 4;        }        public void Exited_K1Action() {            TFC.StateHistory[TFC.LastState++] = 5;        }        public void Exited_K2Action() {            TFC.StateHistory[TFC.LastState++] = 6;        }        public void Exited_K3Action() {            TFC.StateHistory[TFC.LastState++] = 7;        }        public void Exited_PAAction() {        }        public void Exited_PBAction() {        }        public void Exited_PCAction() {            TFC.StateHistory[TFC.LastState++] = 8;        }        public void FromK1ToK2_SimpleAction() {            TFC.StateHistory[TFC.LastState++] = 9;        }        public void FromK1ToPC_PushAction() {            TFC.StateHistory[TFC.LastState++] = 20;        }        public void FromK1ToPC_SimpleAction() {            TFC.StateHistory[TFC.LastState++] = 10;        }        public void FromK1_PopAction() {            TFC.StateHistory[TFC.LastState++] = 11;        }        public void FromK2ToK3_SimpleAction() {            TFC.StateHistory[TFC.LastState++] = 12;        }        public void FromK2ToPA_PushAction() {            TFC.StateHistory[TFC.LastState++] = 13;        }        public void FromK3ToK1_PushAction() {            TFC.StateHistory[TFC.LastState++] = 14;        }        public void FromK3ToPC_SimpleAction() {            TFC.StateHistory[TFC.LastState++] = 15;        }        public void FromPCToK1_PushAction() {            TFC.StateHistory[TFC.LastState++] = 16;        }        public void FromPCToK1_SimpleAction() {            TFC.StateHistory[TFC.LastState++] = 17;        }        public void FromPC_PopAction() {            TFC.StateHistory[TFC.LastState++] = 18;        }        public void FromStandbyToK3Action() {            TFC.StateHistory[TFC.LastState++] = 19;        }        // user-variables        TestFlagsClass TFC;    }    NestedStateMachnImpl fsm;    public NestedSet2_utst(String name) {        super(name);        // Create the FSM and call the entry action manually        fsm = new NestedStateMachnImpl();        fsm.EnteredStandbyStateAction();    }    @Override    protected void setUp() {        fsm.TFC.LastState = 0;        int i;        for (i = 0; i < 255; i++) {            fsm.TFC.StateHistory[i] = (byte) 255;        }        // trigger the test transitions        fsm.context.StandbyToK3_SimpleTransition();        fsm.context.K3ToPC_SimpleTransition();        fsm.context.PCToK1_PushTransition();        fsm.context.K1_PopTransition();        fsm.context.PCToK1_SimpleTransition();        fsm.context.K1ToPC_PushTransition();        fsm.context.PC_PopTransition();    }    public void testProtocol() {        int i;        System.out.println("");        System.out.print("log message yo: ");        System.out.println(String.format("[fsm.TFC.LastState, %d]\n", fsm.TFC.LastState));        for (i = 0; i < fsm.TFC.LastState + 1; i++) {            System.out.println(String.format("[fsm.TFC.StateHistory[%d], %d]\n", i, fsm.TFC.StateHistory[i]));        }        /*        (1)fsm.TFC.StateHistory[0] == 19 	FromStandbyToK3Action        (1)fsm.TFC.StateHistory[1] == 3	Entered_K3Action        (2)fsm.TFC.StateHistory[2] == 7	Exited_K3Action        (2)fsm.TFC.StateHistory[3] == 15	FromK3ToPC_SimpleAction        (2)fsm.TFC.StateHistory[4] == 4	Entered_PCAction        --stops here, should see:        (3)fsm.TFC.StateHistory[5] == 16	FromPCToK1_PushAction        (3)fsm.TFC.StateHistory[6] == 1	EnteredK1_Action        (4)fsm.TFC.StateHistory[7] == 5	ExitedK1_Action        (4)fsm.TFC.StateHistory[8] == 11	FromK1_PopAction        (5)fsm.TFC.StateHistory[9] == 8	Exited_PCAction        (5)fsm.TFC.StateHistory[10] == 17	FromPCToK1_SimpleAction        (5)fsm.TFC.StateHistory[11] == 1	EnteredK1_Action        (6)                             FromK1ToPC_PushAction        ----code generator never produced stub for FromK1ToPC_PushAction        (6)fsm.TFC.StateHistory[13] == 4	EnteredPC_Action        (7)fsm.TFC.StateHistory[14] == 8	ExitedPC_Action        (7)fsm.TFC.StateHistory[15] == 18	FromPC_PopAction         */        assertEquals((byte) 19, fsm.TFC.StateHistory[0]); //FromStandbyToK3Action        assertEquals((byte) 3, fsm.TFC.StateHistory[1]); //Entered_K3Action        assertEquals((byte) 7, fsm.TFC.StateHistory[2]); //Exited_K3Action        assertEquals((byte) 15, fsm.TFC.StateHistory[3]); //FromK3ToPC_SimpleAction        assertEquals((byte) 4, fsm.TFC.StateHistory[4]); //Entered_PCAction        assertEquals((byte) 16, fsm.TFC.StateHistory[5]); //FromPCToK1_PushAction        assertEquals((byte) 1, fsm.TFC.StateHistory[6]); //EnteredK1_Action        assertEquals((byte) 5, fsm.TFC.StateHistory[7]); //ExitedK1_Action        assertEquals((byte) 11, fsm.TFC.StateHistory[8]); //FromK1_PopAction        assertEquals((byte) 8, fsm.TFC.StateHistory[9]); //Exited_PCAction        assertEquals((byte) 17, fsm.TFC.StateHistory[10]); //FromPCToK1_SimpleAction        assertEquals((byte) 1, fsm.TFC.StateHistory[11]); //EnteredK1_Action        assertEquals((byte) 20, fsm.TFC.StateHistory[12]); //FromK1ToPC_PushAction        assertEquals((byte) 4, fsm.TFC.StateHistory[13]); //EnteredPC_Action        assertEquals((byte) 8, fsm.TFC.StateHistory[14]); //ExitedPC_Action        assertEquals((byte) 18, fsm.TFC.StateHistory[15]); //FromPC_PopAction    }    public static void main(String[] args) {        System.out.println("Executing suite JTSNestedDefMessageTest 2");        TestRunner.run(NestedSet2_utst.class);        System.out.println("Completed suite JTSNestedDefMessageTest 2");        System.out.println("------------------------------------------------");    }}