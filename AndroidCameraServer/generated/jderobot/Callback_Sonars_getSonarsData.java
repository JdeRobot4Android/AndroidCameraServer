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
// Generated from file `Callback_Sonars_getSonarsData.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package jderobot;

public abstract class Callback_Sonars_getSonarsData extends Ice.TwowayCallback
{
    public abstract void response(SonarsData __ret);

    public final void __completed(Ice.AsyncResult __result)
    {
        SonarsPrx __proxy = (SonarsPrx)__result.getProxy();
        SonarsData __ret = null;
        try
        {
            __ret = __proxy.end_getSonarsData(__result);
        }
        catch(Ice.LocalException __ex)
        {
            exception(__ex);
            return;
        }
        response(__ret);
    }
}
