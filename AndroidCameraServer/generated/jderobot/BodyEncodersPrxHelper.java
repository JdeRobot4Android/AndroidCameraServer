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
// Generated from file `BodyEncodersPrxHelper.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package jderobot;

/**
 * Interface to the Humanoid Body Encoders.
 **/
public final class BodyEncodersPrxHelper extends Ice.ObjectPrxHelperBase implements BodyEncodersPrx
{
    public ArmEncodersData
    getArmEncodersData(BodySide side)
    {
        return getArmEncodersData(side, null, false);
    }

    public ArmEncodersData
    getArmEncodersData(BodySide side, java.util.Map<String, String> __ctx)
    {
        return getArmEncodersData(side, __ctx, true);
    }

    private ArmEncodersData
    getArmEncodersData(BodySide side, java.util.Map<String, String> __ctx, boolean __explicitCtx)
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
                __checkTwowayOnly("getArmEncodersData");
                __delBase = __getDelegate(false);
                _BodyEncodersDel __del = (_BodyEncodersDel)__delBase;
                return __del.getArmEncodersData(side, __ctx);
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

    private static final String __getArmEncodersData_name = "getArmEncodersData";

    public Ice.AsyncResult begin_getArmEncodersData(BodySide side)
    {
        return begin_getArmEncodersData(side, null, false, null);
    }

    public Ice.AsyncResult begin_getArmEncodersData(BodySide side, java.util.Map<String, String> __ctx)
    {
        return begin_getArmEncodersData(side, __ctx, true, null);
    }

    public Ice.AsyncResult begin_getArmEncodersData(BodySide side, Ice.Callback __cb)
    {
        return begin_getArmEncodersData(side, null, false, __cb);
    }

    public Ice.AsyncResult begin_getArmEncodersData(BodySide side, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_getArmEncodersData(side, __ctx, true, __cb);
    }

    public Ice.AsyncResult begin_getArmEncodersData(BodySide side, Callback_BodyEncoders_getArmEncodersData __cb)
    {
        return begin_getArmEncodersData(side, null, false, __cb);
    }

    public Ice.AsyncResult begin_getArmEncodersData(BodySide side, java.util.Map<String, String> __ctx, Callback_BodyEncoders_getArmEncodersData __cb)
    {
        return begin_getArmEncodersData(side, __ctx, true, __cb);
    }

    private Ice.AsyncResult begin_getArmEncodersData(BodySide side, java.util.Map<String, String> __ctx, boolean __explicitCtx, IceInternal.CallbackBase __cb)
    {
        __checkAsyncTwowayOnly(__getArmEncodersData_name);
        IceInternal.OutgoingAsync __result = new IceInternal.OutgoingAsync(this, __getArmEncodersData_name, __cb);
        try
        {
            __result.__prepare(__getArmEncodersData_name, Ice.OperationMode.Idempotent, __ctx, __explicitCtx);
            IceInternal.BasicStream __os = __result.__os();
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

    public ArmEncodersData end_getArmEncodersData(Ice.AsyncResult __result)
    {
        Ice.AsyncResult.__check(__result, this, __getArmEncodersData_name);
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
        ArmEncodersDataHolder __ret = new ArmEncodersDataHolder();
        IceInternal.BasicStream __is = __result.__is();
        __is.startReadEncaps();
        __is.readObject(__ret);
        __is.readPendingObjects();
        __is.endReadEncaps();
        return __ret.value;
    }

    public LegEncodersData
    getLegEncodersData(BodySide side)
    {
        return getLegEncodersData(side, null, false);
    }

    public LegEncodersData
    getLegEncodersData(BodySide side, java.util.Map<String, String> __ctx)
    {
        return getLegEncodersData(side, __ctx, true);
    }

    private LegEncodersData
    getLegEncodersData(BodySide side, java.util.Map<String, String> __ctx, boolean __explicitCtx)
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
                __checkTwowayOnly("getLegEncodersData");
                __delBase = __getDelegate(false);
                _BodyEncodersDel __del = (_BodyEncodersDel)__delBase;
                return __del.getLegEncodersData(side, __ctx);
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

    private static final String __getLegEncodersData_name = "getLegEncodersData";

    public Ice.AsyncResult begin_getLegEncodersData(BodySide side)
    {
        return begin_getLegEncodersData(side, null, false, null);
    }

    public Ice.AsyncResult begin_getLegEncodersData(BodySide side, java.util.Map<String, String> __ctx)
    {
        return begin_getLegEncodersData(side, __ctx, true, null);
    }

    public Ice.AsyncResult begin_getLegEncodersData(BodySide side, Ice.Callback __cb)
    {
        return begin_getLegEncodersData(side, null, false, __cb);
    }

    public Ice.AsyncResult begin_getLegEncodersData(BodySide side, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_getLegEncodersData(side, __ctx, true, __cb);
    }

    public Ice.AsyncResult begin_getLegEncodersData(BodySide side, Callback_BodyEncoders_getLegEncodersData __cb)
    {
        return begin_getLegEncodersData(side, null, false, __cb);
    }

    public Ice.AsyncResult begin_getLegEncodersData(BodySide side, java.util.Map<String, String> __ctx, Callback_BodyEncoders_getLegEncodersData __cb)
    {
        return begin_getLegEncodersData(side, __ctx, true, __cb);
    }

    private Ice.AsyncResult begin_getLegEncodersData(BodySide side, java.util.Map<String, String> __ctx, boolean __explicitCtx, IceInternal.CallbackBase __cb)
    {
        __checkAsyncTwowayOnly(__getLegEncodersData_name);
        IceInternal.OutgoingAsync __result = new IceInternal.OutgoingAsync(this, __getLegEncodersData_name, __cb);
        try
        {
            __result.__prepare(__getLegEncodersData_name, Ice.OperationMode.Idempotent, __ctx, __explicitCtx);
            IceInternal.BasicStream __os = __result.__os();
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

    public LegEncodersData end_getLegEncodersData(Ice.AsyncResult __result)
    {
        Ice.AsyncResult.__check(__result, this, __getLegEncodersData_name);
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
        LegEncodersDataHolder __ret = new LegEncodersDataHolder();
        IceInternal.BasicStream __is = __result.__is();
        __is.startReadEncaps();
        __is.readObject(__ret);
        __is.readPendingObjects();
        __is.endReadEncaps();
        return __ret.value;
    }

    public OdometryData
    getOdometryData(CameraBody camera)
    {
        return getOdometryData(camera, null, false);
    }

    public OdometryData
    getOdometryData(CameraBody camera, java.util.Map<String, String> __ctx)
    {
        return getOdometryData(camera, __ctx, true);
    }

    private OdometryData
    getOdometryData(CameraBody camera, java.util.Map<String, String> __ctx, boolean __explicitCtx)
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
                __checkTwowayOnly("getOdometryData");
                __delBase = __getDelegate(false);
                _BodyEncodersDel __del = (_BodyEncodersDel)__delBase;
                return __del.getOdometryData(camera, __ctx);
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

    private static final String __getOdometryData_name = "getOdometryData";

    public Ice.AsyncResult begin_getOdometryData(CameraBody camera)
    {
        return begin_getOdometryData(camera, null, false, null);
    }

    public Ice.AsyncResult begin_getOdometryData(CameraBody camera, java.util.Map<String, String> __ctx)
    {
        return begin_getOdometryData(camera, __ctx, true, null);
    }

    public Ice.AsyncResult begin_getOdometryData(CameraBody camera, Ice.Callback __cb)
    {
        return begin_getOdometryData(camera, null, false, __cb);
    }

    public Ice.AsyncResult begin_getOdometryData(CameraBody camera, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_getOdometryData(camera, __ctx, true, __cb);
    }

    public Ice.AsyncResult begin_getOdometryData(CameraBody camera, Callback_BodyEncoders_getOdometryData __cb)
    {
        return begin_getOdometryData(camera, null, false, __cb);
    }

    public Ice.AsyncResult begin_getOdometryData(CameraBody camera, java.util.Map<String, String> __ctx, Callback_BodyEncoders_getOdometryData __cb)
    {
        return begin_getOdometryData(camera, __ctx, true, __cb);
    }

    private Ice.AsyncResult begin_getOdometryData(CameraBody camera, java.util.Map<String, String> __ctx, boolean __explicitCtx, IceInternal.CallbackBase __cb)
    {
        __checkAsyncTwowayOnly(__getOdometryData_name);
        IceInternal.OutgoingAsync __result = new IceInternal.OutgoingAsync(this, __getOdometryData_name, __cb);
        try
        {
            __result.__prepare(__getOdometryData_name, Ice.OperationMode.Idempotent, __ctx, __explicitCtx);
            IceInternal.BasicStream __os = __result.__os();
            camera.__write(__os);
            __os.endWriteEncaps();
            __result.__send(true);
        }
        catch(Ice.LocalException __ex)
        {
            __result.__exceptionAsync(__ex);
        }
        return __result;
    }

    public OdometryData end_getOdometryData(Ice.AsyncResult __result)
    {
        Ice.AsyncResult.__check(__result, this, __getOdometryData_name);
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
        OdometryDataHolder __ret = new OdometryDataHolder();
        IceInternal.BasicStream __is = __result.__is();
        __is.startReadEncaps();
        __is.readObject(__ret);
        __is.readPendingObjects();
        __is.endReadEncaps();
        return __ret.value;
    }

    public static BodyEncodersPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
        BodyEncodersPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (BodyEncodersPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA(ice_staticId()))
                {
                    BodyEncodersPrxHelper __h = new BodyEncodersPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static BodyEncodersPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        BodyEncodersPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (BodyEncodersPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA(ice_staticId(), __ctx))
                {
                    BodyEncodersPrxHelper __h = new BodyEncodersPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static BodyEncodersPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        BodyEncodersPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA(ice_staticId()))
                {
                    BodyEncodersPrxHelper __h = new BodyEncodersPrxHelper();
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

    public static BodyEncodersPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        BodyEncodersPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA(ice_staticId(), __ctx))
                {
                    BodyEncodersPrxHelper __h = new BodyEncodersPrxHelper();
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

    public static BodyEncodersPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
        BodyEncodersPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (BodyEncodersPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                BodyEncodersPrxHelper __h = new BodyEncodersPrxHelper();
                __h.__copyFrom(__obj);
                __d = __h;
            }
        }
        return __d;
    }

    public static BodyEncodersPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        BodyEncodersPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            BodyEncodersPrxHelper __h = new BodyEncodersPrxHelper();
            __h.__copyFrom(__bb);
            __d = __h;
        }
        return __d;
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::jderobot::BodyEncoders"
    };

    public static String
    ice_staticId()
    {
        return __ids[1];
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
        return new _BodyEncodersDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
        return new _BodyEncodersDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, BodyEncodersPrx v)
    {
        __os.writeProxy(v);
    }

    public static BodyEncodersPrx
    __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            BodyEncodersPrxHelper result = new BodyEncodersPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}
