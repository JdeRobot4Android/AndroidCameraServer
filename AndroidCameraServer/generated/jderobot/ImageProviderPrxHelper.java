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
// Generated from file `ImageProviderPrxHelper.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package jderobot;

/**
 * Interface to the image provider.
 **/
public final class ImageProviderPrxHelper extends Ice.ObjectPrxHelperBase implements ImageProviderPrx
{
    /**
     * Returns the latest data.
     **/
    public ImageData
    getImageData()
        throws DataNotExistException,
               HardwareFailedException
    {
        return getImageData(null, false);
    }

    /**
     * Returns the latest data.
     * @param __ctx The Context map to send with the invocation.
     **/
    public ImageData
    getImageData(java.util.Map<String, String> __ctx)
        throws DataNotExistException,
               HardwareFailedException
    {
        return getImageData(__ctx, true);
    }

    private ImageData
    getImageData(java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws DataNotExistException,
               HardwareFailedException
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
                __checkTwowayOnly("getImageData");
                __delBase = __getDelegate(false);
                _ImageProviderDel __del = (_ImageProviderDel)__delBase;
                return __del.getImageData(__ctx);
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

    private static final String __getImageData_name = "getImageData";

    /**
     * Returns the latest data.
     * @param __cb The callback object for the operation.
     **/
    public Ice.AsyncResult begin_getImageData()
    {
        return begin_getImageData(null, false, null);
    }

    /**
     * Returns the latest data.
     * @param __cb The callback object for the operation.
     * @param __ctx The Context map to send with the invocation.
     **/
    public Ice.AsyncResult begin_getImageData(java.util.Map<String, String> __ctx)
    {
        return begin_getImageData(__ctx, true, null);
    }

    /**
     * Returns the latest data.
     * @param __cb The callback object for the operation.
     **/
    public Ice.AsyncResult begin_getImageData(Ice.Callback __cb)
    {
        return begin_getImageData(null, false, __cb);
    }

    /**
     * Returns the latest data.
     * @param __cb The callback object for the operation.
     * @param __ctx The Context map to send with the invocation.
     **/
    public Ice.AsyncResult begin_getImageData(java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_getImageData(__ctx, true, __cb);
    }

    /**
     * Returns the latest data.
     * @param __cb The callback object for the operation.
     **/
    public Ice.AsyncResult begin_getImageData(Callback_ImageProvider_getImageData __cb)
    {
        return begin_getImageData(null, false, __cb);
    }

    /**
     * Returns the latest data.
     * @param __cb The callback object for the operation.
     * @param __ctx The Context map to send with the invocation.
     **/
    public Ice.AsyncResult begin_getImageData(java.util.Map<String, String> __ctx, Callback_ImageProvider_getImageData __cb)
    {
        return begin_getImageData(__ctx, true, __cb);
    }

    private Ice.AsyncResult begin_getImageData(java.util.Map<String, String> __ctx, boolean __explicitCtx, IceInternal.CallbackBase __cb)
    {
        __checkAsyncTwowayOnly(__getImageData_name);
        IceInternal.OutgoingAsync __result = new IceInternal.OutgoingAsync(this, __getImageData_name, __cb);
        try
        {
            __result.__prepare(__getImageData_name, Ice.OperationMode.Idempotent, __ctx, __explicitCtx);
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

    /**
     * ice_response indicates that
     * the operation completed successfully.
     **/
    public ImageData end_getImageData(Ice.AsyncResult __result)
        throws DataNotExistException,
               HardwareFailedException
    {
        Ice.AsyncResult.__check(__result, this, __getImageData_name);
        if(!__result.__wait())
        {
            try
            {
                __result.__throwUserException();
            }
            catch(DataNotExistException __ex)
            {
                throw __ex;
            }
            catch(HardwareFailedException __ex)
            {
                throw __ex;
            }
            catch(Ice.UserException __ex)
            {
                throw new Ice.UnknownUserException(__ex.ice_name(), __ex);
            }
        }
        ImageDataHolder __ret = new ImageDataHolder();
        IceInternal.BasicStream __is = __result.__is();
        __is.startReadEncaps();
        __is.readObject(__ret);
        __is.readPendingObjects();
        __is.endReadEncaps();
        return __ret.value;
    }

    /**
     * Returns the image source description.
     **/
    public ImageDescription
    getImageDescription()
    {
        return getImageDescription(null, false);
    }

    /**
     * Returns the image source description.
     * @param __ctx The Context map to send with the invocation.
     **/
    public ImageDescription
    getImageDescription(java.util.Map<String, String> __ctx)
    {
        return getImageDescription(__ctx, true);
    }

    private ImageDescription
    getImageDescription(java.util.Map<String, String> __ctx, boolean __explicitCtx)
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
                __checkTwowayOnly("getImageDescription");
                __delBase = __getDelegate(false);
                _ImageProviderDel __del = (_ImageProviderDel)__delBase;
                return __del.getImageDescription(__ctx);
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

    private static final String __getImageDescription_name = "getImageDescription";

    /**
     * Returns the image source description.
     * @param __cb The callback object for the operation.
     **/
    public Ice.AsyncResult begin_getImageDescription()
    {
        return begin_getImageDescription(null, false, null);
    }

    /**
     * Returns the image source description.
     * @param __cb The callback object for the operation.
     * @param __ctx The Context map to send with the invocation.
     **/
    public Ice.AsyncResult begin_getImageDescription(java.util.Map<String, String> __ctx)
    {
        return begin_getImageDescription(__ctx, true, null);
    }

    /**
     * Returns the image source description.
     * @param __cb The callback object for the operation.
     **/
    public Ice.AsyncResult begin_getImageDescription(Ice.Callback __cb)
    {
        return begin_getImageDescription(null, false, __cb);
    }

    /**
     * Returns the image source description.
     * @param __cb The callback object for the operation.
     * @param __ctx The Context map to send with the invocation.
     **/
    public Ice.AsyncResult begin_getImageDescription(java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_getImageDescription(__ctx, true, __cb);
    }

    /**
     * Returns the image source description.
     * @param __cb The callback object for the operation.
     **/
    public Ice.AsyncResult begin_getImageDescription(Callback_ImageProvider_getImageDescription __cb)
    {
        return begin_getImageDescription(null, false, __cb);
    }

    /**
     * Returns the image source description.
     * @param __cb The callback object for the operation.
     * @param __ctx The Context map to send with the invocation.
     **/
    public Ice.AsyncResult begin_getImageDescription(java.util.Map<String, String> __ctx, Callback_ImageProvider_getImageDescription __cb)
    {
        return begin_getImageDescription(__ctx, true, __cb);
    }

    private Ice.AsyncResult begin_getImageDescription(java.util.Map<String, String> __ctx, boolean __explicitCtx, IceInternal.CallbackBase __cb)
    {
        __checkAsyncTwowayOnly(__getImageDescription_name);
        IceInternal.OutgoingAsync __result = new IceInternal.OutgoingAsync(this, __getImageDescription_name, __cb);
        try
        {
            __result.__prepare(__getImageDescription_name, Ice.OperationMode.Idempotent, __ctx, __explicitCtx);
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

    /**
     * ice_response indicates that
     * the operation completed successfully.
     **/
    public ImageDescription end_getImageDescription(Ice.AsyncResult __result)
    {
        Ice.AsyncResult.__check(__result, this, __getImageDescription_name);
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
        ImageDescriptionHolder __ret = new ImageDescriptionHolder();
        IceInternal.BasicStream __is = __result.__is();
        __is.startReadEncaps();
        __is.readObject(__ret);
        __is.readPendingObjects();
        __is.endReadEncaps();
        return __ret.value;
    }

    public static ImageProviderPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
        ImageProviderPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (ImageProviderPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA(ice_staticId()))
                {
                    ImageProviderPrxHelper __h = new ImageProviderPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static ImageProviderPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        ImageProviderPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (ImageProviderPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA(ice_staticId(), __ctx))
                {
                    ImageProviderPrxHelper __h = new ImageProviderPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static ImageProviderPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        ImageProviderPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA(ice_staticId()))
                {
                    ImageProviderPrxHelper __h = new ImageProviderPrxHelper();
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

    public static ImageProviderPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        ImageProviderPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA(ice_staticId(), __ctx))
                {
                    ImageProviderPrxHelper __h = new ImageProviderPrxHelper();
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

    public static ImageProviderPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
        ImageProviderPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (ImageProviderPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                ImageProviderPrxHelper __h = new ImageProviderPrxHelper();
                __h.__copyFrom(__obj);
                __d = __h;
            }
        }
        return __d;
    }

    public static ImageProviderPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        ImageProviderPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            ImageProviderPrxHelper __h = new ImageProviderPrxHelper();
            __h.__copyFrom(__bb);
            __d = __h;
        }
        return __d;
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::jderobot::ImageProvider"
    };

    public static String
    ice_staticId()
    {
        return __ids[1];
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
        return new _ImageProviderDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
        return new _ImageProviderDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, ImageProviderPrx v)
    {
        __os.writeProxy(v);
    }

    public static ImageProviderPrx
    __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            ImageProviderPrxHelper result = new ImageProviderPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}
