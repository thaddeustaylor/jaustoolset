/*
 * ex: set ro:
 * DO NOT EDIT.
 * generated by smc (http://smc.sourceforge.net/)
 * from file : Transport_ReceiveFSM.sm
 */

#include "urn_jaus_jss_core_Transport_1_1/Messages/MessageSet.h"
#include "urn_jaus_jss_core_Transport_1_1/Transport_ReceiveFSM.h"
#include "include/urn_jaus_jss_core_Transport_1_1/Transport_ReceiveFSM_sm.h"

using namespace statemap;

namespace urn_jaus_jss_core_Transport_1_1
{
    // Static class declarations.
    Transport_ReceiveFSM_SM_Receiving Transport_ReceiveFSM_SM::Receiving("Transport_ReceiveFSM_SM::Receiving", 0);
    Transport_ReceiveFSM_SM_Internally_Generated_State_DO_NOT_USE Transport_ReceiveFSM_SM::Internally_Generated_State_DO_NOT_USE("Transport_ReceiveFSM_SM::Internally_Generated_State_DO_NOT_USE", 1);

    void Transport_ReceiveFSMState::BroadcastGlobalTransition(Transport_ReceiveFSMContext& context)
    {
        Default(context);
        return;
    }

    void Transport_ReceiveFSMState::BroadcastLocalTransition(Transport_ReceiveFSMContext& context)
    {
        Default(context);
        return;
    }

    void Transport_ReceiveFSMState::ReceiveTransition(Transport_ReceiveFSMContext& context)
    {
        Default(context);
        return;
    }

    void Transport_ReceiveFSMState::SendTransition(Transport_ReceiveFSMContext& context)
    {
        Default(context);
        return;
    }

    void Transport_ReceiveFSMState::Default(Transport_ReceiveFSMContext& context)
    {
        if (context.getDebugFlag() == true)
        {
            std::ostream& str = context.getDebugStream();

            str << "TRANSITION   : Default"
                << std::endl;
        }

        throw (
            TransitionUndefinedException(
                context.getState().getName(),
                context.getTransition()));

        return;
    }

    void Transport_ReceiveFSM_SM_Receiving::ReceiveTransition(Transport_ReceiveFSMContext& context)
    {

        if (context.getDebugFlag() == true)
        {
            std::ostream& str = context.getDebugStream();

            str << "TRANSITION   : Transport_ReceiveFSM_SM ReceiveTransition()"
                << std::endl;
        }


        return;
    }

    void Transport_ReceiveFSM_SM_Internally_Generated_State_DO_NOT_USE::BroadcastGlobalTransition(Transport_ReceiveFSMContext& context)
    {

        if (context.getDebugFlag() == true)
        {
            std::ostream& str = context.getDebugStream();

            str << "TRANSITION   : Transport_ReceiveFSM_SM BroadcastGlobalTransition()"
                << std::endl;
        }


        return;
    }

    void Transport_ReceiveFSM_SM_Internally_Generated_State_DO_NOT_USE::BroadcastLocalTransition(Transport_ReceiveFSMContext& context)
    {

        if (context.getDebugFlag() == true)
        {
            std::ostream& str = context.getDebugStream();

            str << "TRANSITION   : Transport_ReceiveFSM_SM BroadcastLocalTransition()"
                << std::endl;
        }


        return;
    }

    void Transport_ReceiveFSM_SM_Internally_Generated_State_DO_NOT_USE::ReceiveTransition(Transport_ReceiveFSMContext& context)
    {

        if (context.getDebugFlag() == true)
        {
            std::ostream& str = context.getDebugStream();

            str << "TRANSITION   : Transport_ReceiveFSM_SM ReceiveTransition()"
                << std::endl;
        }


        return;
    }

    void Transport_ReceiveFSM_SM_Internally_Generated_State_DO_NOT_USE::SendTransition(Transport_ReceiveFSMContext& context)
    {

        if (context.getDebugFlag() == true)
        {
            std::ostream& str = context.getDebugStream();

            str << "TRANSITION   : Transport_ReceiveFSM_SM SendTransition()"
                << std::endl;
        }


        return;
    }
}

/*
 * Local variables:
 *  buffer-read-only: t
 * End:
 */
