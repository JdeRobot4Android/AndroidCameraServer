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
// Generated from file `pointCloudDataPrxHelper.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package jderobot;

public final class pointCloudDataPrxHelper extends Ice.ObjectPrxHelperBase implements pointCloudDataPrx
{
    public static pointCloudDataPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
        pointCloudDataPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (pointCloudDataPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA(ice_staticId()))
                {
                    pointCloudDataPrxHelper __h = new pointCloudDataPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static pointCloudDataPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        pointCloudDataPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (pointCloudDataPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                if(__obj.ice_isA(ice_staticId(), __ctx))
                {
                    pointCloudDataPrxHelper __h = new pointCloudDataPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static pointCloudDataPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        pointCloudDataPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA(ice_staticId()))
                {
                    pointCloudDataPrxHelper __h = new pointCloudDataPrxHelper();
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

    public static pointCloudDataPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        pointCloudDataPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try
            {
                if(__bb.ice_isA(ice_staticId(), __ctx))
                {
                    pointCloudDataPrxHelper __h = new pointCloudDataPrxHelper();
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

    public static pointCloudDataPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
        pointCloudDataPrx __d = null;
        if(__obj != null)
        {
            try
            {
                __d = (pointCloudDataPrx)__obj;
            }
            catch(ClassCastException ex)
            {
                pointCloudDataPrxHelper __h = new pointCloudDataPrxHelper();
                __h.__copyFrom(__obj);
                __d = __h;
            }
        }
        return __d;
    }

    public static pointCloudDataPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        pointCloudDataPrx __d = null;
        if(__obj != null)
        {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            pointCloudDataPrxHelper __h = new pointCloudDataPrxHelper();
            __h.__copyFrom(__bb);
            __d = __h;
        }
        return __d;
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::jderobot::pointCloudData"
    };

    public static String
    ice_staticId()
    {
        return __ids[1];
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
        return new _pointCloudDataDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
        return new _pointCloudDataDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, pointCloudDataPrx v)
    {
        __os.writeProxy(v);
    }

    public static pointCloudDataPrx
    __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            pointCloudDataPrxHelper result = new pointCloudDataPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}
