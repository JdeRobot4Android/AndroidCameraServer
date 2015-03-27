// **********************************************************************
//
// Copyright (c) 2003-2011 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.4.2
//
// <auto-generated>
//
// Generated from file `Callback_JointMotor_getMotorParams.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package RoboCompJointMotor;

public abstract class Callback_JointMotor_getMotorParams extends Ice.TwowayCallback
{
    public abstract void response(MotorParams __ret);
    public abstract void exception(Ice.UserException __ex);

    public final void __completed(Ice.AsyncResult __result)
    {
        JointMotorPrx __proxy = (JointMotorPrx)__result.getProxy();
        MotorParams __ret = null;
        try
        {
            __ret = __proxy.end_getMotorParams(__result);
        }
        catch(Ice.UserException __ex)
        {
            exception(__ex);
            return;
        }
        catch(Ice.LocalException __ex)
        {
            exception(__ex);
            return;
        }
        response(__ret);
    }
}
