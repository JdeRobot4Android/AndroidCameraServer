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
// Generated from file `LaserPrxHelper.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package jderobot;

/**
 * Interface to the Gazebo laser sensor.
 **/
public final class LaserPrxHelper extends Ice.ObjectPrxHelperBase implements LaserPrx
{
    public LaserData
    getLaserData()
    {
        return getLaserData(null, false);
    }

    public LaserData
    getLaserData(java.util.Map<String, String> __ctx)
    {
        return getLaserData(__ctx, true);
    }

    private LaserData
    getLaserData(java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        int __cnt = 0;
        while(true)
        {
            Ice._ObjectDel __delBase = null;
            try
            {
                __checkTwowayOnly("getLaserData");
                __delBase = __getDelegate(false);
                _LaserDel __del = (_LaserDel)__delBase;
                return __del.getLaserData(__ctx);
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __cnt = __handleExceptionWrapperRelaxed(__delBase, __ex, null, __cnt);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, null, __cnt);
            }
        }
    }

    private static final String __getLaserData_name = "getLaserData";

    public Ice.AsyncResult begin_getLaserData()
    {
        return begin_getLaserData(null, false, null);
    }

    public Ice.AsyncResult begin_getLaserData(java.util.Map<String, String> __ctx)
    {
        return begin_getLaserData(__ctx, true, null);
    }

    public Ice.AsyncResult begin_getLaserData(Ice.Callback __cb)
    {
        return begin_getLaserData(null, false, __cb);
    }

    public Ice.AsyncResult begin_getLaserData(java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_getLaserData(__ctx, true, __cb);
    }

    public Ice.AsyncResult begin_getLaserData(Callback_Laser_getLaserData __cb)
    {
        return begin_getLaserData(null, false, __cb);
    }

    public Ice.AsyncResult begin_getLaserData(java.util.Map<String, String> __ctx, Callback_Laser_getLaserData __cb)
    {
        return begin_getLaserData(__ctx, true, __cb);
    }

    private Ice.AsyncResult begin_getLaserData(java.util.Map<String, String> __ctx, boolean __explicitCtx, IceInternal.CallbackBase __cb)
    {
        __checkAsyncTwowayOnly(__getLaserData_name);
        IceInternal.OutgoingAsync __result = new IceInternal.OutgoingAsync(this, __getLaserData_name, __cb);
        try
        {
            __result.__prepare(__getLaserData_name, Ice.OperationMode.Idempotent, __ctx, __explicitCtx);
            IceInternal.BasicStream __os = __result.__os();
            __os.endWriteEncaps();
            __result.__send(true);
        }
        catch(Ice.LocalException __ex)
        {
            __result.__exceptionAsync(__ex);
        }
        return __result;
    }

    public LaserData end_getLaserData(Ice.AsyncResult __result)
    {
        Ice.AsyncResult.__check(__result, this, __getLaserData_name);
        if(!__result.__wait())
        {
            try
            {
                __result.__throwUserException();
            }
            catch(Ice.UserException __ex)
            {
                throw new Ice.UnknownUserException(__ex.ice_name(), __ex);
            }
        }
        LaserDataHolder __ret = new LaserDataHolder();
        IceInternal.BasicStream __is = __result.__is();
        __is.startReadEncaps();
        __is.readObject(__ret);
        __is.readPendingObjects();
        __is.endReadEncaps();
        return __ret.value;
    }

    public static LaserPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
        LaserPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (LaserPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA(ice_staticId()))
                {
                    LaserPrxHelper __h = new LaserPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static LaserPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        LaserPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (LaserPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA(ice_staticId(), __ctx))
                {
                    LaserPrxHelper __h = new LaserPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static LaserPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        LaserPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA(ice_staticId()))
                {
                    LaserPrxHelper __h = new LaserPrxHelper();
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

    public static LaserPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        LaserPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA(ice_staticId(), __ctx))
                {
                    LaserPrxHelper __h = new LaserPrxHelper();
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

    public static LaserPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
        LaserPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (LaserPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                LaserPrxHelper __h = new LaserPrxHelper();
                __h.__copyFrom(__obj);
                __d = __h;
            }
        }
        return __d;
    }

    public static LaserPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        LaserPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            LaserPrxHelper __h = new LaserPrxHelper();
            __h.__copyFrom(__bb);
            __d = __h;
        }
        return __d;
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::jderobot::Laser"
    };

    public static String
    ice_staticId()
    {
        return __ids[1];
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
        return new _LaserDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
        return new _LaserDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, LaserPrx v)
    {
        __os.writeProxy(v);
    }

    public static LaserPrx
    __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            LaserPrxHelper result = new LaserPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}
