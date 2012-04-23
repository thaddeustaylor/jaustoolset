/** 
 *  This Promela file was auto-generated using JTS on Wed Apr 13 16:18:34 EDT 2011.
 *  ID=urn.jts.ProtocolBehaviorTest  vsersion=1.1
 *  DO NOT MODIFY
 *  This file contains type definitions found in the JSIDL that was used to generate it.
 */ 

// Client implementation 
active [CLIENTS] proctype clientProcess(){
	// declare data for the messages
	urn_jts_ProtocolBehaviorTest_Message1 urn_jts_ProtocolBehaviorTest_Message1_impl;
	urn_jts_ProtocolBehaviorTest_UnsignedTestMsg urn_jts_ProtocolBehaviorTest_UnsignedTestMsg_impl;
	urn_jts_ProtocolBehaviorTest_UnsignedResponseMessage Message_inst;
	pid incoming_pid;
	// put some values into the declared data here

CLIENT_START_STATE:
	do
		:: printf("send messages");
	
	Message1 ! _pid, urn_jts_ProtocolBehaviorTest_Message1_impl;
	
	UnsignedTestMsg ! _pid, urn_jts_ProtocolBehaviorTest_UnsignedTestMsg_impl;
	goto RECEIVE_MESSAGES;
	 od;
	 
RECEIVE_MESSAGES:
	do
		:: UnsignedResponseMessage[_pid] ? incoming_pid, Message_inst ->
		printf("ResponseData %d, %d, %d, %d.\n",Message_inst.UnsignedRec.UnsignedByte, Message_inst.UnsignedRec.UnsignedShort, Message_inst.UnsignedRec.UnsignedInt, Message_inst.UnsignedRec.UnsignedLong);

	od;

}
// End of client implementation
