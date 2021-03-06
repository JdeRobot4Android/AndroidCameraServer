// **********************************************************************
//
// Copyright (c) 2003-2013 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.5.1
//
// <auto-generated>
//
// Generated from file `genericData.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package jderobot;

public final class genericDataProviderPrxHelper extends Ice.ObjectPrxHelperBase implements genericDataProviderPrx
{
    private static final String __getGenericData_name = "getGenericData";

    /**
     * Returns the generic data class
     **/
    public GenericData getGenericData()
    {
        return getGenericData(null, false);
    }

    /**
     * Returns the generic data class
     * @param __ctx The Context map to send with the invocation.
     **/
    public GenericData getGenericData(java.util.Map<String, String> __ctx)
    {
        return getGenericData(__ctx, true);
    }

    private GenericData getGenericData(java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        if(__explicitCtx && __ctx == null)
        {
            __ctx = _emptyContext;
        }
        final Ice.Instrumentation.InvocationObserver __observer = IceInternal.ObserverHelper.get(this, "getGenericData", __ctx);
        int __cnt = 0;
        try
        {
            while(true)
            {
                Ice._ObjectDel __delBase = null;
                try
                {
                    __checkTwowayOnly("getGenericData");
                    __delBase = __getDelegate(false);
                    _genericDataProviderDel __del = (_genericDataProviderDel)__delBase;
                    return __del.getGenericData(__ctx, __observer);
                }
                catch(IceInternal.LocalExceptionWrapper __ex)
                {
                    __cnt = __handleExceptionWrapperRelaxed(__delBase, __ex, null, __cnt, __observer);
                }
                catch(Ice.LocalException __ex)
                {
                    __cnt = __handleException(__delBase, __ex, null, __cnt, __observer);
                }
            }
        }
        finally
        {
            if(__observer != null)
            {
                __observer.detach();
            }
        }
    }

    /**
     * Returns the generic data class
     * @param __cb The callback object for the operation.
     **/
    public Ice.AsyncResult begin_getGenericData()
    {
        return begin_getGenericData(null, false, null);
    }

    /**
     * Returns the generic data class
     * @param __cb The callback object for the operation.
     * @param __ctx The Context map to send with the invocation.
     **/
    public Ice.AsyncResult begin_getGenericData(java.util.Map<String, String> __ctx)
    {
        return begin_getGenericData(__ctx, true, null);
    }

    /**
     * Returns the generic data class
     * @param __cb The callback object for the operation.
     **/
    public Ice.AsyncResult begin_getGenericData(Ice.Callback __cb)
    {
        return begin_getGenericData(null, false, __cb);
    }

    /**
     * Returns the generic data class
     * @param __cb The callback object for the operation.
     * @param __ctx The Context map to send with the invocation.
     **/
    public Ice.AsyncResult begin_getGenericData(java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_getGenericData(__ctx, true, __cb);
    }

    /**
     * Returns the generic data class
     * @param __cb The callback object for the operation.
     **/
    public Ice.AsyncResult begin_getGenericData(Callback_genericDataProvider_getGenericData __cb)
    {
        return begin_getGenericData(null, false, __cb);
    }

    /**
     * Returns the generic data class
     * @param __cb The callback object for the operation.
     * @param __ctx The Context map to send with the invocation.
     **/
    public Ice.AsyncResult begin_getGenericData(java.util.Map<String, String> __ctx, Callback_genericDataProvider_getGenericData __cb)
    {
        return begin_getGenericData(__ctx, true, __cb);
    }

    private Ice.AsyncResult begin_getGenericData(java.util.Map<String, String> __ctx, boolean __explicitCtx, IceInternal.CallbackBase __cb)
    {
        __checkAsyncTwowayOnly(__getGenericData_name);
        IceInternal.OutgoingAsync __result = new IceInternal.OutgoingAsync(this, __getGenericData_name, __cb);
        try
        {
            __result.__prepare(__getGenericData_name, Ice.OperationMode.Idempotent, __ctx, __explicitCtx);
            __result.__writeEmptyParams();
            __result.__send(true);
        }
        catch(Ice.LocalException __ex)
        {
            __result.__exceptionAsync(__ex);
        }
        return __result;
    }

    /**
     * ice_response indicates that
     * the operation completed successfully.
     **/
    public GenericData end_getGenericData(Ice.AsyncResult __result)
    {
        Ice.AsyncResult.__check(__result, this, __getGenericData_name);
        boolean __ok = __result.__wait();
        try
        {
            if(!__ok)
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
            IceInternal.BasicStream __is = __result.__startReadParams();
            GenericDataHolder __ret = new GenericDataHolder();
            __is.readObject(__ret);
            __is.readPendingObjects();
            __result.__endReadParams();
            return __ret.value;
        }
        catch(Ice.LocalException ex)
        {
            Ice.Instrumentation.InvocationObserver __obsv = __result.__getObserver();
            if(__obsv != null)
            {
                __obsv.failed(ex.ice_name());
            }
            throw ex;
        }
    }

    public static genericDataProviderPrx checkedCast(Ice.ObjectPrx __obj)
    {
        genericDataProviderPrx __d = null;
        if(__obj != null)
        {
            if(__obj instanceof genericDataProviderPrx)
            {
                __d = (genericDataProviderPrx)__obj;
            }
            else
            {
                if(__obj.ice_isA(ice_staticId()))
                {
                    genericDataProviderPrxHelper __h = new genericDataProviderPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static genericDataProviderPrx checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        genericDataProviderPrx __d = null;
        if(__obj != null)
        {
            if(__obj instanceof genericDataProviderPrx)
            {
                __d = (genericDataProviderPrx)__obj;
            }
            else
            {
                if(__obj.ice_isA(ice_staticId(), __ctx))
                {
                    genericDataProviderPrxHelper __h = new genericDataProviderPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static genericDataProviderPrx checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        genericDataProviderPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA(ice_staticId()))
                {
                    genericDataProviderPrxHelper __h = new genericDataProviderPrxHelper();
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

    public static genericDataProviderPrx checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        genericDataProviderPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA(ice_staticId(), __ctx))
                {
                    genericDataProviderPrxHelper __h = new genericDataProviderPrxHelper();
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

    public static genericDataProviderPrx uncheckedCast(Ice.ObjectPrx __obj)
    {
        genericDataProviderPrx __d = null;
        if(__obj != null)
        {
            if(__obj instanceof genericDataProviderPrx)
            {
                __d = (genericDataProviderPrx)__obj;
            }
            else
            {
                genericDataProviderPrxHelper __h = new genericDataProviderPrxHelper();
                __h.__copyFrom(__obj);
                __d = __h;
            }
        }
        return __d;
    }

    public static genericDataProviderPrx uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        genericDataProviderPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            genericDataProviderPrxHelper __h = new genericDataProviderPrxHelper();
            __h.__copyFrom(__bb);
            __d = __h;
        }
        return __d;
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::jderobot::genericDataProvider"
    };

    public static String ice_staticId()
    {
        return __ids[1];
    }

    protected Ice._ObjectDelM __createDelegateM()
    {
        return new _genericDataProviderDelM();
    }

    protected Ice._ObjectDelD __createDelegateD()
    {
        return new _genericDataProviderDelD();
    }

    public static void __write(IceInternal.BasicStream __os, genericDataProviderPrx v)
    {
        __os.writeProxy(v);
    }

    public static genericDataProviderPrx __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            genericDataProviderPrxHelper result = new genericDataProviderPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }

    public static final long serialVersionUID = 0L;
}
