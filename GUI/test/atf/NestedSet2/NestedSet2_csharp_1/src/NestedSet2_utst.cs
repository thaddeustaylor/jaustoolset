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

[TestFixture]
public class NestedSet2_utst
{
    public class TestFlagsClass
    {
        public byte LastState;
        public byte[] StateHistory = new byte[255];
    };

    public class NestedStateMachnImpl : urn_DeVivo_jaus_services_NestedDef_1_0.NestedDef2_NestedStateMachn
    {
        public NestedStateMachnImpl()
        {
            TFC = new TestFlagsClass();
        }

        /// Action Methods
        public override void EnteredStandbyStateAction() { }
        public override void Entered_K1Action() { TFC.StateHistory[TFC.LastState++] = 1; }
        public override void Entered_K2Action() { TFC.StateHistory[TFC.LastState++] = 2; }
        public override void Entered_K3Action() { TFC.StateHistory[TFC.LastState++] = 3; }
        public override void Entered_PAAction() { }
        public override void Entered_PBAction() { }
        public override void Entered_PCAction() { TFC.StateHistory[TFC.LastState++] = 4; }
        public override void Exited_K1Action() { TFC.StateHistory[TFC.LastState++] = 5; }
        public override void Exited_K2Action() { TFC.StateHistory[TFC.LastState++] = 6; }
        public override void Exited_K3Action() { TFC.StateHistory[TFC.LastState++] = 7; }
        public override void Exited_PAAction() { }
        public override void Exited_PBAction() { }
        public override void Exited_PCAction() { TFC.StateHistory[TFC.LastState++] = 8; }
        public override void FromK1ToK2_SimpleAction() { TFC.StateHistory[TFC.LastState++] = 9; }
        public override void FromK1ToPC_PushAction() { TFC.StateHistory[TFC.LastState++] = 20; }
        public override void FromK1ToPC_SimpleAction() { TFC.StateHistory[TFC.LastState++] = 10; }
        public override void FromK1_PopAction() { TFC.StateHistory[TFC.LastState++] = 11; }
        public override void FromK2ToK3_SimpleAction() { TFC.StateHistory[TFC.LastState++] = 12; }
        public override void FromK2ToPA_PushAction() { TFC.StateHistory[TFC.LastState++] = 13; }
        public override void FromK3ToK1_PushAction() { TFC.StateHistory[TFC.LastState++] = 14; }
        public override void FromK3ToPC_SimpleAction() { TFC.StateHistory[TFC.LastState++] = 15; }
        public override void FromPCToK1_PushAction() { TFC.StateHistory[TFC.LastState++] = 16; }
        public override void FromPCToK1_SimpleAction() { TFC.StateHistory[TFC.LastState++] = 17; }
        public override void FromPC_PopAction() { TFC.StateHistory[TFC.LastState++] = 18; }
        public override void FromStandbyToK3Action() { TFC.StateHistory[TFC.LastState++] = 19; }

        // user-variables
        public TestFlagsClass TFC;
    }

    NestedStateMachnImpl fsm;

    public NestedSet2_utst()
    {
    }


    [SetUp]
    public void setUp()
    {
        // Create the FSM and call the entry action manually
        fsm = new NestedStateMachnImpl();
        fsm.EnteredStandbyStateAction();

        fsm.TFC.LastState = 0;
        int i;
        for (i = 0; i < 255; i++)
        {
            fsm.TFC.StateHistory[i] = 255;
        }

        // trigger the test transitions
        fsm.context.StandbyToK3_SimpleTransition();
        fsm.context.K3ToPC_SimpleTransition();
        fsm.context.PCToK1_PushTransition();
        fsm.context.K1_PopTransition();
        fsm.context.PCToK1_SimpleTransition();
        fsm.context.K1ToPC_PushTransition();
        fsm.context.PC_PopTransition();
    }

    [Test]
    public void testProtocol()
    {
        int i;

        Console.WriteLine("[Action log summary:]");
        Console.WriteLine("fsm.TFC.LastState == " + fsm.TFC.LastState);
        for (i = 0; i < fsm.TFC.LastState + 1; i++)
        {
            Console.WriteLine("fsm.TFC.StateHistory[" + i + "] == " + fsm.TFC.StateHistory[i]);
        }

        Assert.AreEqual(19, fsm.TFC.StateHistory[0]); //FromStandbyToK3Action 
        Assert.AreEqual(3, fsm.TFC.StateHistory[1]); //Entered_K3Action
        Assert.AreEqual(7, fsm.TFC.StateHistory[2]); //Exited_K3Action
        Assert.AreEqual(15, fsm.TFC.StateHistory[3]); //FromK3ToPC_SimpleAction
        Assert.AreEqual(4, fsm.TFC.StateHistory[4]); //Entered_PCAction
        Assert.AreEqual(16, fsm.TFC.StateHistory[5]); //FromPCToK1_PushAction
        Assert.AreEqual(1, fsm.TFC.StateHistory[6]); //EnteredK1_Action
        Assert.AreEqual(5, fsm.TFC.StateHistory[7]); //ExitedK1_Action 
        Assert.AreEqual(11, fsm.TFC.StateHistory[8]); //FromK1_PopAction
        Assert.AreEqual(8, fsm.TFC.StateHistory[9]); //Exited_PCAction 
        Assert.AreEqual(17, fsm.TFC.StateHistory[10]); //FromPCToK1_SimpleAction
        Assert.AreEqual(1, fsm.TFC.StateHistory[11]); //EnteredK1_Action
        Assert.AreEqual(20, fsm.TFC.StateHistory[12]); //FromK1ToPC_PushAction
        Assert.AreEqual(4, fsm.TFC.StateHistory[13]); //EnteredPC_Action
        Assert.AreEqual(8, fsm.TFC.StateHistory[14]); //ExitedPC_Action
        Assert.AreEqual(18, fsm.TFC.StateHistory[15]); //FromPC_PopAction
    }

    public static void Main()
    {
    }
}
