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
// Generated from file `Callback_Laser_getLaserData.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package jderobot;

public abstract class Callback_Laser_getLaserData extends Ice.TwowayCallback
{
    public abstract void response(LaserData __ret);

    public final void __completed(Ice.AsyncResult __result)
    {
        LaserPrx __proxy = (LaserPrx)__result.getProxy();
        LaserData __ret = null;
        try
        {
            __ret = __proxy.end_getLaserData(__result);
        }
        catch(Ice.LocalException __ex)
        {
            exception(__ex);
            return;
        }
        response(__ret);
    }
}
