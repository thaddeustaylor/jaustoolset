/*
 * ex: set ro:
 * DO NOT EDIT.
 * generated by smc (http://smc.sourceforge.net/)
 * from file : ManagementOCU_ManagementOcuFSM.sm
 */

#include "urn_jts_example_management_ocu_1_0/Messages/MessageSet.h"
#include "urn_jts_example_management_ocu_1_0/ManagementOCU_ManagementOcuFSM.h"
#include "include/urn_jts_example_management_ocu_1_0/ManagementOCU_ManagementOcuFSM_sm.h"

using namespace statemap;

namespace urn_jts_example_management_ocu_1_0
{
    // Static class declarations.
    ManagementOCU_ManagementOcuFSM_SM_WaitForControl ManagementOCU_ManagementOcuFSM_SM::WaitForControl("ManagementOCU_ManagementOcuFSM_SM::WaitForControl", 0);
    ManagementOCU_ManagementOcuFSM_SM_HandleMenu ManagementOCU_ManagementOcuFSM_SM::HandleMenu("ManagementOCU_ManagementOcuFSM_SM::HandleMenu", 1);
    ManagementOCU_ManagementOcuFSM_SM_Internally_Generated_State_DO_NOT_USE ManagementOCU_ManagementOcuFSM_SM::Internally_Generated_State_DO_NOT_USE("ManagementOCU_ManagementOcuFSM_SM::Internally_Generated_State_DO_NOT_USE", 2);

    void ManagementOCU_ManagementOcuFSMState::ConfirmControlTransition(ManagementOCU_ManagementOcuFSMContext& context)
    {
        Default(context);
        return;
    }

    void ManagementOCU_ManagementOcuFSMState::ConfirmControlTransition(ManagementOCU_ManagementOcuFSMContext& context, ConfirmControl msg)
    {
        Default(context);
        return;
    }

    void ManagementOCU_ManagementOcuFSMState::InternalStateChange_To_ManagementOCU_ManagementOcuFSM_HandleMenuTransition(ManagementOCU_ManagementOcuFSMContext& context, JTS::InternalEvent* ie)
    {
        Default(context);
        return;
    }

    void ManagementOCU_ManagementOcuFSMState::InternalStateChange_To_ManagementOCU_ManagementOcuFSM_WaitForControlTransition(ManagementOCU_ManagementOcuFSMContext& context, JTS::InternalEvent* ie)
    {
        Default(context);
        return;
    }

    void ManagementOCU_ManagementOcuFSMState::MenuItemEnteredTransition(ManagementOCU_ManagementOcuFSMContext& context)
    {
        Default(context);
        return;
    }

    void ManagementOCU_ManagementOcuFSMState::MenuItemEnteredTransition(ManagementOCU_ManagementOcuFSMContext& context, MenuItemEntered msg)
    {
        Default(context);
        return;
    }

    void ManagementOCU_ManagementOcuFSMState::RejectControlTransition(ManagementOCU_ManagementOcuFSMContext& context)
    {
        Default(context);
        return;
    }

    void ManagementOCU_ManagementOcuFSMState::RejectControlTransition(ManagementOCU_ManagementOcuFSMContext& context, RejectControl msg)
    {
        Default(context);
        return;
    }

    void ManagementOCU_ManagementOcuFSMState::ReportControlTransition(ManagementOCU_ManagementOcuFSMContext& context)
    {
        Default(context);
        return;
    }

    void ManagementOCU_ManagementOcuFSMState::ReportStatusTransition(ManagementOCU_ManagementOcuFSMContext& context)
    {
        Default(context);
        return;
    }

    void ManagementOCU_ManagementOcuFSMState::ReportStatusTransition(ManagementOCU_ManagementOcuFSMContext& context, ReportStatus msg)
    {
        Default(context);
        return;
    }

    void ManagementOCU_ManagementOcuFSMState::Default(ManagementOCU_ManagementOcuFSMContext& context)
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

    void ManagementOCU_ManagementOcuFSM_SM_WaitForControl::ConfirmControlTransition(ManagementOCU_ManagementOcuFSMContext& context, ConfirmControl msg)
    {
        ManagementOCU_ManagementOcuFSM& ctxt(context.getOwner());

        if (context.getDebugFlag() == true)
        {
            std::ostream& str = context.getDebugStream();

            str << "TRANSITION   : ManagementOCU_ManagementOcuFSM_SM ConfirmControlTransition(ConfirmControl msg)"
                << std::endl;
        }

        if (! ctxt.isControlAccepted(msg))
        {
            (context.getState()).Exit(context);
            context.clearState();
            try
            {
                ctxt.sendRequestControlAction();
                ctxt.displayMenuAction();
                ctxt.processNotifications("WaitForControl");
                context.setState(ManagementOCU_ManagementOcuFSM_SM::WaitForControl);
            }
            catch (...)
            {
                context.setState(ManagementOCU_ManagementOcuFSM_SM::WaitForControl);
                throw;
            }
            (context.getState()).Entry(context);
        }
        else if (ctxt.isControlAccepted(msg))
    
    {
            (context.getState()).Exit(context);
            context.clearState();
            try
            {
                ctxt.displayMenuAction();
                ctxt.processNotifications("HandleMenu");
                context.setState(ManagementOCU_ManagementOcuFSM_SM::HandleMenu);
            }
            catch (...)
            {
                context.setState(ManagementOCU_ManagementOcuFSM_SM::HandleMenu);
                throw;
            }
            (context.getState()).Entry(context);
        }        else
        {
             ManagementOCU_ManagementOcuFSM_SM_Default::ConfirmControlTransition(context, msg);
        }

        return;
    }

    void ManagementOCU_ManagementOcuFSM_SM_WaitForControl::InternalStateChange_To_ManagementOCU_ManagementOcuFSM_HandleMenuTransition(ManagementOCU_ManagementOcuFSMContext& context, JTS::InternalEvent* ie)
    {
        ManagementOCU_ManagementOcuFSM& ctxt(context.getOwner());

        if (context.getDebugFlag() == true)
        {
            std::ostream& str = context.getDebugStream();

            str << "TRANSITION   : ManagementOCU_ManagementOcuFSM_SM InternalStateChange_To_ManagementOCU_ManagementOcuFSM_HandleMenuTransition(JTS::InternalEvent* ie)"
                << std::endl;
        }

        (context.getState()).Exit(context);
        context.clearState();
        try
        {
            ctxt.displayMenuAction();
            ctxt.processNotifications("HandleMenu", ie);
            context.setState(ManagementOCU_ManagementOcuFSM_SM::HandleMenu);
        }
        catch (...)
        {
            context.setState(ManagementOCU_ManagementOcuFSM_SM::HandleMenu);
            throw;
        }
        (context.getState()).Entry(context);

        return;
    }

    void ManagementOCU_ManagementOcuFSM_SM_WaitForControl::MenuItemEnteredTransition(ManagementOCU_ManagementOcuFSMContext& context, MenuItemEntered msg)
    {
        ManagementOCU_ManagementOcuFSM& ctxt(context.getOwner());

        if (context.getDebugFlag() == true)
        {
            std::ostream& str = context.getDebugStream();

            str << "TRANSITION   : ManagementOCU_ManagementOcuFSM_SM MenuItemEnteredTransition(MenuItemEntered msg)"
                << std::endl;
        }

        if (!ctxt.isSelectionToEnd(msg))
        {
            (context.getState()).Exit(context);
            context.clearState();
            try
            {
                ctxt.printMessageAction("waiting for AccessControl process to end");
                ctxt.sendRequestControlAction();
                ctxt.displayMenuAction();
                ctxt.processNotifications("WaitForControl");
                context.setState(ManagementOCU_ManagementOcuFSM_SM::WaitForControl);
            }
            catch (...)
            {
                context.setState(ManagementOCU_ManagementOcuFSM_SM::WaitForControl);
                throw;
            }
            (context.getState()).Entry(context);
        }
        else if (ctxt.isSelectionToEnd(msg))
    
    {
            (context.getState()).Exit(context);
            context.clearState();
            try
            {
                ctxt.terminateServiceAction();
                ctxt.sendRequestControlAction();
                ctxt.displayMenuAction();
                ctxt.processNotifications("WaitForControl");
                context.setState(ManagementOCU_ManagementOcuFSM_SM::WaitForControl);
            }
            catch (...)
            {
                context.setState(ManagementOCU_ManagementOcuFSM_SM::WaitForControl);
                throw;
            }
            (context.getState()).Entry(context);
        }        else
        {
             ManagementOCU_ManagementOcuFSM_SM_Default::MenuItemEnteredTransition(context, msg);
        }

        return;
    }

    void ManagementOCU_ManagementOcuFSM_SM_HandleMenu::InternalStateChange_To_ManagementOCU_ManagementOcuFSM_WaitForControlTransition(ManagementOCU_ManagementOcuFSMContext& context, JTS::InternalEvent* ie)
    {
        ManagementOCU_ManagementOcuFSM& ctxt(context.getOwner());

        if (context.getDebugFlag() == true)
        {
            std::ostream& str = context.getDebugStream();

            str << "TRANSITION   : ManagementOCU_ManagementOcuFSM_SM InternalStateChange_To_ManagementOCU_ManagementOcuFSM_WaitForControlTransition(JTS::InternalEvent* ie)"
                << std::endl;
        }

        (context.getState()).Exit(context);
        context.clearState();
        try
        {
            ctxt.sendRequestControlAction();
            ctxt.displayMenuAction();
            ctxt.processNotifications("WaitForControl", ie);
            context.setState(ManagementOCU_ManagementOcuFSM_SM::WaitForControl);
        }
        catch (...)
        {
            context.setState(ManagementOCU_ManagementOcuFSM_SM::WaitForControl);
            throw;
        }
        (context.getState()).Entry(context);

        return;
    }

    void ManagementOCU_ManagementOcuFSM_SM_HandleMenu::MenuItemEnteredTransition(ManagementOCU_ManagementOcuFSMContext& context, MenuItemEntered msg)
    {
        ManagementOCU_ManagementOcuFSM& ctxt(context.getOwner());

        if (context.getDebugFlag() == true)
        {
            std::ostream& str = context.getDebugStream();

            str << "TRANSITION   : ManagementOCU_ManagementOcuFSM_SM MenuItemEnteredTransition(MenuItemEntered msg)"
                << std::endl;
        }

        if (!ctxt.isSelectionToEnd(msg))
        {
            (context.getState()).Exit(context);
            context.clearState();
            try
            {
                ctxt.sendManagementMessageAction(msg);
                ctxt.displayMenuAction();
                ctxt.processNotifications("HandleMenu");
                context.setState(ManagementOCU_ManagementOcuFSM_SM::HandleMenu);
            }
            catch (...)
            {
                context.setState(ManagementOCU_ManagementOcuFSM_SM::HandleMenu);
                throw;
            }
            (context.getState()).Entry(context);
        }
        else if (ctxt.isSelectionToEnd(msg))
    
    {
            (context.getState()).Exit(context);
            context.clearState();
            try
            {
                ctxt.terminateServiceAction();
                ctxt.displayMenuAction();
                ctxt.processNotifications("HandleMenu");
                context.setState(ManagementOCU_ManagementOcuFSM_SM::HandleMenu);
            }
            catch (...)
            {
                context.setState(ManagementOCU_ManagementOcuFSM_SM::HandleMenu);
                throw;
            }
            (context.getState()).Entry(context);
        }        else
        {
             ManagementOCU_ManagementOcuFSM_SM_Default::MenuItemEnteredTransition(context, msg);
        }

        return;
    }

    void ManagementOCU_ManagementOcuFSM_SM_HandleMenu::RejectControlTransition(ManagementOCU_ManagementOcuFSMContext& context, RejectControl msg)
    {
        ManagementOCU_ManagementOcuFSM& ctxt(context.getOwner());

        if (context.getDebugFlag() == true)
        {
            std::ostream& str = context.getDebugStream();

            str << "TRANSITION   : ManagementOCU_ManagementOcuFSM_SM RejectControlTransition(RejectControl msg)"
                << std::endl;
        }

        (context.getState()).Exit(context);
        context.clearState();
        try
        {
            ctxt.sendRequestControlAction();
            ctxt.displayMenuAction();
            ctxt.processNotifications("WaitForControl");
            context.setState(ManagementOCU_ManagementOcuFSM_SM::WaitForControl);
        }
        catch (...)
        {
            context.setState(ManagementOCU_ManagementOcuFSM_SM::WaitForControl);
            throw;
        }
        (context.getState()).Entry(context);

        return;
    }

    void ManagementOCU_ManagementOcuFSM_SM_HandleMenu::ReportStatusTransition(ManagementOCU_ManagementOcuFSMContext& context, ReportStatus msg)
    {
        ManagementOCU_ManagementOcuFSM& ctxt(context.getOwner());

        if (context.getDebugFlag() == true)
        {
            std::ostream& str = context.getDebugStream();

            str << "TRANSITION   : ManagementOCU_ManagementOcuFSM_SM ReportStatusTransition(ReportStatus msg)"
                << std::endl;
        }

        (context.getState()).Exit(context);
        context.clearState();
        try
        {
            ctxt.displayStatusAction(msg);
            ctxt.displayMenuAction();
            ctxt.processNotifications("HandleMenu");
            context.setState(ManagementOCU_ManagementOcuFSM_SM::HandleMenu);
        }
        catch (...)
        {
            context.setState(ManagementOCU_ManagementOcuFSM_SM::HandleMenu);
            throw;
        }
        (context.getState()).Entry(context);

        return;
    }

    void ManagementOCU_ManagementOcuFSM_SM_Internally_Generated_State_DO_NOT_USE::ConfirmControlTransition(ManagementOCU_ManagementOcuFSMContext& context)
    {

        if (context.getDebugFlag() == true)
        {
            std::ostream& str = context.getDebugStream();

            str << "TRANSITION   : ManagementOCU_ManagementOcuFSM_SM ConfirmControlTransition()"
                << std::endl;
        }


        return;
    }

    void ManagementOCU_ManagementOcuFSM_SM_Internally_Generated_State_DO_NOT_USE::MenuItemEnteredTransition(ManagementOCU_ManagementOcuFSMContext& context)
    {

        if (context.getDebugFlag() == true)
        {
            std::ostream& str = context.getDebugStream();

            str << "TRANSITION   : ManagementOCU_ManagementOcuFSM_SM MenuItemEnteredTransition()"
                << std::endl;
        }


        return;
    }

    void ManagementOCU_ManagementOcuFSM_SM_Internally_Generated_State_DO_NOT_USE::RejectControlTransition(ManagementOCU_ManagementOcuFSMContext& context)
    {

        if (context.getDebugFlag() == true)
        {
            std::ostream& str = context.getDebugStream();

            str << "TRANSITION   : ManagementOCU_ManagementOcuFSM_SM RejectControlTransition()"
                << std::endl;
        }


        return;
    }

    void ManagementOCU_ManagementOcuFSM_SM_Internally_Generated_State_DO_NOT_USE::ReportControlTransition(ManagementOCU_ManagementOcuFSMContext& context)
    {

        if (context.getDebugFlag() == true)
        {
            std::ostream& str = context.getDebugStream();

            str << "TRANSITION   : ManagementOCU_ManagementOcuFSM_SM ReportControlTransition()"
                << std::endl;
        }


        return;
    }

    void ManagementOCU_ManagementOcuFSM_SM_Internally_Generated_State_DO_NOT_USE::ReportStatusTransition(ManagementOCU_ManagementOcuFSMContext& context)
    {

        if (context.getDebugFlag() == true)
        {
            std::ostream& str = context.getDebugStream();

            str << "TRANSITION   : ManagementOCU_ManagementOcuFSM_SM ReportStatusTransition()"
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
