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
// Generated from file `Callback_PTMotors_getPTMotorsData.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package jderobot;

public abstract class Callback_PTMotors_getPTMotorsData extends Ice.TwowayCallback
{
    public abstract void response(PTMotorsData __ret);

    public final void __completed(Ice.AsyncResult __result)
    {
        PTMotorsPrx __proxy = (PTMotorsPrx)__result.getProxy();
        PTMotorsData __ret = null;
        try
        {
            __ret = __proxy.end_getPTMotorsData(__result);
        }
        catch(Ice.LocalException __ex)
        {
            exception(__ex);
            return;
        }
        response(__ret);
    }
}
