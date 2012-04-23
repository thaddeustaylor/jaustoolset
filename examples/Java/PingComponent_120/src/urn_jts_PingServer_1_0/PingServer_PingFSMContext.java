/*
 * ex: set ro:
 * DO NOT EDIT.
 * generated by smc (http://smc.sourceforge.net/)
 * from file : PingServer_PingFSM.sm
 */

package src.urn_jts_PingServer_1_0;

import framework.internalEvents.*;
import src.urn_jts_PingServer_1_0.Messages.*;
import java.io.PrintStream;

public class PingServer_PingFSMContext
    extends statemap.FSMContext
{
//---------------------------------------------------------------
// Member methods.
//

    public PingServer_PingFSMContext(PingServer_PingFSM owner)
    {
        super (PingServer_PingFSM_SM.Ready);

        _owner = owner;
    }

    public PingServer_PingFSMContext(PingServer_PingFSM owner, PingServer_PingFSMState initState)
    {
        super (initState);

        _owner = owner;
    }

    public void enterStartState()
    {
        getState().Entry(this);
        return;
    }

    public void QueryHeartbeatPulseTransition()
    {
        _transition = "QueryHeartbeatPulseTransition";
        getState().QueryHeartbeatPulseTransition(this);
        _transition = "";
        return;
    }

    public PingServer_PingFSMState getState()
        throws statemap.StateUndefinedException
    {
        if (_state == null)
        {
            throw(
                new statemap.StateUndefinedException());
        }

        return ((PingServer_PingFSMState) _state);
    }

    protected PingServer_PingFSM getOwner()
    {
        return (_owner);
    }

    public void setOwner(PingServer_PingFSM owner)
    {
        if (owner == null)
        {
            throw (
                new NullPointerException(
                    "null owner"));
        }
        else
        {
            _owner = owner;
        }

        return;
    }

//---------------------------------------------------------------
// Member data.
//

    transient private PingServer_PingFSM _owner;

//---------------------------------------------------------------
// Inner classes.
//

    public static abstract class PingServer_PingFSMState
        extends statemap.State
    {
    //-----------------------------------------------------------
    // Member methods.
    //

        protected PingServer_PingFSMState(String name, int id)
        {
            super (name, id);
        }

        protected void Entry(PingServer_PingFSMContext context) {}
        protected void Exit(PingServer_PingFSMContext context) {}

        protected void QueryHeartbeatPulseTransition(PingServer_PingFSMContext context)
        {
            Default(context);
        }

        protected void Default(PingServer_PingFSMContext context)
        {
            if (context.getDebugFlag() == true)
            {
                PrintStream str = 
                    context.getDebugStream();

                str.println(
                    "TRANSITION   : Default");
            }

            throw (
                new statemap.TransitionUndefinedException(
                    "State: " +
                    context.getState().getName() +
                    ", Transition: " +
                    context.getTransition()));
        }

    //-----------------------------------------------------------
    // Member data.
    //
    }

    /* package */ static abstract class PingServer_PingFSM_SM
    {
    //-----------------------------------------------------------
    // Member methods.
    //

    //-----------------------------------------------------------
    // Member data.
    //

        //-------------------------------------------------------
        // Constants.
        //
        public static final PingServer_PingFSM_SM_Default.PingServer_PingFSM_SM_Ready Ready =
            new PingServer_PingFSM_SM_Default.PingServer_PingFSM_SM_Ready("PingServer_PingFSM_SM.Ready", 0);
        public static final PingServer_PingFSM_SM_Default.PingServer_PingFSM_SM_Internally_Generated_State_DO_NOT_USE Internally_Generated_State_DO_NOT_USE =
            new PingServer_PingFSM_SM_Default.PingServer_PingFSM_SM_Internally_Generated_State_DO_NOT_USE("PingServer_PingFSM_SM.Internally_Generated_State_DO_NOT_USE", 1);
        private static final PingServer_PingFSM_SM_Default Default =
            new PingServer_PingFSM_SM_Default("PingServer_PingFSM_SM.Default", -1);

    }

    protected static class PingServer_PingFSM_SM_Default
        extends PingServer_PingFSMState
    {
    //-----------------------------------------------------------
    // Member methods.
    //

        protected PingServer_PingFSM_SM_Default(String name, int id)
        {
            super (name, id);
        }

    //-----------------------------------------------------------
    // Inner classse.
    //


        private static final class PingServer_PingFSM_SM_Ready
            extends PingServer_PingFSM_SM_Default
        {
        //-------------------------------------------------------
        // Member methods.
        //

            private PingServer_PingFSM_SM_Ready(String name, int id)
            {
                super (name, id);
            }

            protected void QueryHeartbeatPulseTransition(PingServer_PingFSMContext context)
            {
                PingServer_PingFSM ctxt = context.getOwner();

                if (context.getDebugFlag() == true)
                {
                    PrintStream str = context.getDebugStream();

                    str.println("TRANSITION   : PingServer_PingFSM_SM.Ready.QueryHeartbeatPulseTransition()");
                }

                PingServer_PingFSMState endState = context.getState();

                context.clearState();
                try
                {
                    ctxt.ReportHeartbeatPulseAction();
                }
                finally
                {
                    context.setState(endState);
                }
                return;
            }

        //-------------------------------------------------------
        // Member data.
        //
        }

        private static final class PingServer_PingFSM_SM_Internally_Generated_State_DO_NOT_USE
            extends PingServer_PingFSM_SM_Default
        {
        //-------------------------------------------------------
        // Member methods.
        //

            private PingServer_PingFSM_SM_Internally_Generated_State_DO_NOT_USE(String name, int id)
            {
                super (name, id);
            }

            protected void QueryHeartbeatPulseTransition(PingServer_PingFSMContext context)
            {

                if (context.getDebugFlag() == true)
                {
                    PrintStream str = context.getDebugStream();

                    str.println("TRANSITION   : PingServer_PingFSM_SM.Internally_Generated_State_DO_NOT_USE.QueryHeartbeatPulseTransition()");
                }


                return;
            }

        //-------------------------------------------------------
        // Member data.
        //
        }

    //-----------------------------------------------------------
    // Member data.
    //
    }
}

/*
 * Local variables:
 *  buffer-read-only: t
 * End:
 */
