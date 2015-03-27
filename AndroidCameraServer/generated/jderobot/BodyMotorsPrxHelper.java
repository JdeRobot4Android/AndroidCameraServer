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
// Generated from file `BodyMotorsPrxHelper.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package jderobot;

/**
 * Interface to the Humanoid Body Motors.
 **/
public final class BodyMotorsPrxHelper extends Ice.ObjectPrxHelperBase implements BodyMotorsPrx
{
    public BodyMotorsParam
    getBodyMotorsParam(MotorsName name, BodySide side)
    {
        return getBodyMotorsParam(name, side, null, false);
    }

    public BodyMotorsParam
    getBodyMotorsParam(MotorsName name, BodySide side, java.util.Map<String, String> __ctx)
    {
        return getBodyMotorsParam(name, side, __ctx, true);
    }

    private BodyMotorsParam
    getBodyMotorsParam(MotorsName name, BodySide side, java.util.Map<String, String> __ctx, boolean __explicitCtx)
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
                __checkTwowayOnly("getBodyMotorsParam");
                __delBase = __getDelegate(false);
                _BodyMotorsDel __del = (_BodyMotorsDel)__delBase;
                return __del.getBodyMotorsParam(name, side, __ctx);
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

    private static final String __getBodyMotorsParam_name = "getBodyMotorsParam";

    public Ice.AsyncResult begin_getBodyMotorsParam(MotorsName name, BodySide side)
    {
        return begin_getBodyMotorsParam(name, side, null, false, null);
    }

    public Ice.AsyncResult begin_getBodyMotorsParam(MotorsName name, BodySide side, java.util.Map<String, String> __ctx)
    {
        return begin_getBodyMotorsParam(name, side, __ctx, true, null);
    }

    public Ice.AsyncResult begin_getBodyMotorsParam(MotorsName name, BodySide side, Ice.Callback __cb)
    {
        return begin_getBodyMotorsParam(name, side, null, false, __cb);
    }

    public Ice.AsyncResult begin_getBodyMotorsParam(MotorsName name, BodySide side, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_getBodyMotorsParam(name, side, __ctx, true, __cb);
    }

    public Ice.AsyncResult begin_getBodyMotorsParam(MotorsName name, BodySide side, Callback_BodyMotors_getBodyMotorsParam __cb)
    {
        return begin_getBodyMotorsParam(name, side, null, false, __cb);
    }

    public Ice.AsyncResult begin_getBodyMotorsParam(MotorsName name, BodySide side, java.util.Map<String, String> __ctx, Callback_BodyMotors_getBodyMotorsParam __cb)
    {
        return begin_getBodyMotorsParam(name, side, __ctx, true, __cb);
    }

    private Ice.AsyncResult begin_getBodyMotorsParam(MotorsName name, BodySide side, java.util.Map<String, String> __ctx, boolean __explicitCtx, IceInternal.CallbackBase __cb)
    {
        __checkAsyncTwowayOnly(__getBodyMotorsParam_name);
        IceInternal.OutgoingAsync __result = new IceInternal.OutgoingAsync(this, __getBodyMotorsParam_name, __cb);
        try
        {
            __result.__prepare(__getBodyMotorsParam_name, Ice.OperationMode.Idempotent, __ctx, __explicitCtx);
            IceInternal.BasicStream __os = __result.__os();
            name.__write(__os);
            side.__write(__os);
            __os.endWriteEncaps();
            __result.__send(true);
        }
        catch(Ice.LocalException __ex)
        {
            __result.__exceptionAsync(__ex);
        }
        return __result;
    }

    public BodyMotorsParam end_getBodyMotorsParam(Ice.AsyncResult __result)
    {
        Ice.AsyncResult.__check(__result, this, __getBodyMotorsParam_name);
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
        BodyMotorsParamHolder __ret = new BodyMotorsParamHolder();
        IceInternal.BasicStream __is = __result.__is();
        __is.startReadEncaps();
        __is.readObject(__ret);
        __is.readPendingObjects();
        __is.endReadEncaps();
        return __ret.value;
    }

    public int
    setBodyMotorsData(MotorsName name, BodySide side, float angle, float speed)
    {
        return setBodyMotorsData(name, side, angle, speed, null, false);
    }

    public int
    setBodyMotorsData(MotorsName name, BodySide side, float angle, float speed, java.util.Map<String, String> __ctx)
    {
        return setBodyMotorsData(name, side, angle, speed, __ctx, true);
    }

    private int
    setBodyMotorsData(MotorsName name, BodySide side, float angle, float speed, java.util.Map<String, String> __ctx, boolean __explicitCtx)
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
                __checkTwowayOnly("setBodyMotorsData");
                __delBase = __getDelegate(false);
                _BodyMotorsDel __del = (_BodyMotorsDel)__delBase;
                return __del.setBodyMotorsData(name, side, angle, speed, __ctx);
            }
            catch(IceInternal.LocalExceptionWrapper __ex)
            {
                __handleExceptionWrapper(__delBase, __ex);
            }
            catch(Ice.LocalException __ex)
            {
                __cnt = __handleException(__delBase, __ex, null, __cnt);
            }
        }
    }

    private static final String __setBodyMotorsData_name = "setBodyMotorsData";

    public Ice.AsyncResult begin_setBodyMotorsData(MotorsName name, BodySide side, float angle, float speed)
    {
        return begin_setBodyMotorsData(name, side, angle, speed, null, false, null);
    }

    public Ice.AsyncResult begin_setBodyMotorsData(MotorsName name, BodySide side, float angle, float speed, java.util.Map<String, String> __ctx)
    {
        return begin_setBodyMotorsData(name, side, angle, speed, __ctx, true, null);
    }

    public Ice.AsyncResult begin_setBodyMotorsData(MotorsName name, BodySide side, float angle, float speed, Ice.Callback __cb)
    {
        return begin_setBodyMotorsData(name, side, angle, speed, null, false, __cb);
    }

    public Ice.AsyncResult begin_setBodyMotorsData(MotorsName name, BodySide side, float angle, float speed, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_setBodyMotorsData(name, side, angle, speed, __ctx, true, __cb);
    }

    public Ice.AsyncResult begin_setBodyMotorsData(MotorsName name, BodySide side, float angle, float speed, Callback_BodyMotors_setBodyMotorsData __cb)
    {
        return begin_setBodyMotorsData(name, side, angle, speed, null, false, __cb);
    }

    public Ice.AsyncResult begin_setBodyMotorsData(MotorsName name, BodySide side, float angle, float speed, java.util.Map<String, String> __ctx, Callback_BodyMotors_setBodyMotorsData __cb)
    {
        return begin_setBodyMotorsData(name, side, angle, speed, __ctx, true, __cb);
    }

    private Ice.AsyncResult begin_setBodyMotorsData(MotorsName name, BodySide side, float angle, float speed, java.util.Map<String, String> __ctx, boolean __explicitCtx, IceInternal.CallbackBase __cb)
    {
        __checkAsyncTwowayOnly(__setBodyMotorsData_name);
        IceInternal.OutgoingAsync __result = new IceInternal.OutgoingAsync(this, __setBodyMotorsData_name, __cb);
        try
        {
            __result.__prepare(__setBodyMotorsData_name, Ice.OperationMode.Normal, __ctx, __explicitCtx);
            IceInternal.BasicStream __os = __result.__os();
            name.__write(__os);
            side.__write(__os);
            __os.writeFloat(angle);
            __os.writeFloat(speed);
            __os.endWriteEncaps();
            __result.__send(true);
        }
        catch(Ice.LocalException __ex)
        {
            __result.__exceptionAsync(__ex);
        }
        return __result;
    }

    public int end_setBodyMotorsData(Ice.AsyncResult __result)
    {
        Ice.AsyncResult.__check(__result, this, __setBodyMotorsData_name);
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
        int __ret;
        IceInternal.BasicStream __is = __result.__is();
        __is.startReadEncaps();
        __ret = __is.readInt();
        __is.endReadEncaps();
        return __ret;
    }

    public static BodyMotorsPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
        BodyMotorsPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (BodyMotorsPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA(ice_staticId()))
                {
                    BodyMotorsPrxHelper __h = new BodyMotorsPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static BodyMotorsPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        BodyMotorsPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (BodyMotorsPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA(ice_staticId(), __ctx))
                {
                    BodyMotorsPrxHelper __h = new BodyMotorsPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static BodyMotorsPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        BodyMotorsPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA(ice_staticId()))
                {
                    BodyMotorsPrxHelper __h = new BodyMotorsPrxHelper();
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

    public static BodyMotorsPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        BodyMotorsPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA(ice_staticId(), __ctx))
                {
                    BodyMotorsPrxHelper __h = new BodyMotorsPrxHelper();
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

    public static BodyMotorsPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
        BodyMotorsPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (BodyMotorsPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                BodyMotorsPrxHelper __h = new BodyMotorsPrxHelper();
                __h.__copyFrom(__obj);
                __d = __h;
            }
        }
        return __d;
    }

    public static BodyMotorsPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        BodyMotorsPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            BodyMotorsPrxHelper __h = new BodyMotorsPrxHelper();
            __h.__copyFrom(__bb);
            __d = __h;
        }
        return __d;
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::jderobot::BodyMotors"
    };

    public static String
    ice_staticId()
    {
        return __ids[1];
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
        return new _BodyMotorsDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
        return new _BodyMotorsDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, BodyMotorsPrx v)
    {
        __os.writeProxy(v);
    }

    public static BodyMotorsPrx
    __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            BodyMotorsPrxHelper result = new BodyMotorsPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}
