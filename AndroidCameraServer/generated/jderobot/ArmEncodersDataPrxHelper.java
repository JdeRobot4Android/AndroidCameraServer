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
// Generated from file `ArmEncodersDataPrxHelper.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package jderobot;

/**
 * Arm 
 **/
public final class ArmEncodersDataPrxHelper extends Ice.ObjectPrxHelperBase implements ArmEncodersDataPrx
{
    public static ArmEncodersDataPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
        ArmEncodersDataPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (ArmEncodersDataPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA(ice_staticId()))
                {
                    ArmEncodersDataPrxHelper __h = new ArmEncodersDataPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static ArmEncodersDataPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        ArmEncodersDataPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (ArmEncodersDataPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA(ice_staticId(), __ctx))
                {
                    ArmEncodersDataPrxHelper __h = new ArmEncodersDataPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static ArmEncodersDataPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        ArmEncodersDataPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA(ice_staticId()))
                {
                    ArmEncodersDataPrxHelper __h = new ArmEncodersDataPrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            }
            catch(Ice.FacetNotExistException ex)
            {
            }
        }
        return __d;
    }

    public static ArmEncodersDataPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        ArmEncodersDataPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA(ice_staticId(), __ctx))
                {
                    ArmEncodersDataPrxHelper __h = new ArmEncodersDataPrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            }
            catch(Ice.FacetNotExistException ex)
            {
            }
        }
        return __d;
    }

    public static ArmEncodersDataPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
        ArmEncodersDataPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (ArmEncodersDataPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                ArmEncodersDataPrxHelper __h = new ArmEncodersDataPrxHelper();
                __h.__copyFrom(__obj);
                __d = __h;
            }
        }
        return __d;
    }

    public static ArmEncodersDataPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        ArmEncodersDataPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            ArmEncodersDataPrxHelper __h = new ArmEncodersDataPrxHelper();
            __h.__copyFrom(__bb);
            __d = __h;
        }
        return __d;
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::jderobot::ArmEncodersData"
    };

    public static String
    ice_staticId()
    {
        return __ids[1];
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
        return new _ArmEncodersDataDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
        return new _ArmEncodersDataDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, ArmEncodersDataPrx v)
    {
        __os.writeProxy(v);
    }

    public static ArmEncodersDataPrx
    __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            ArmEncodersDataPrxHelper result = new ArmEncodersDataPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}
