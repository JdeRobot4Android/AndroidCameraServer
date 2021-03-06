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
// Generated from file `jcm.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package jderobot;

public class FQComponentName implements java.lang.Cloneable, java.io.Serializable
{
    public String platform;

    public String component;

    public FQComponentName()
    {
    }

    public FQComponentName(String platform, String component)
    {
        this.platform = platform;
        this.component = component;
    }

    public boolean
    equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        FQComponentName _r = null;
        if(rhs instanceof FQComponentName)
        {
            _r = (FQComponentName)rhs;
        }

        if(_r != null)
        {
            if(platform != _r.platform)
            {
                if(platform == null || _r.platform == null || !platform.equals(_r.platform))
                {
                    return false;
                }
            }
            if(component != _r.component)
            {
                if(component == null || _r.component == null || !component.equals(_r.component))
                {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    public int
    hashCode()
    {
        int __h = 5381;
        __h = IceInternal.HashUtil.hashAdd(__h, "::jderobot::FQComponentName");
        __h = IceInternal.HashUtil.hashAdd(__h, platform);
        __h = IceInternal.HashUtil.hashAdd(__h, component);
        return __h;
    }

    public java.lang.Object
    clone()
    {
        java.lang.Object o = null;
        try
        {
            o = super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return o;
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeString(platform);
        __os.writeString(component);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        platform = __is.readString();
        component = __is.readString();
    }

    public static final long serialVersionUID = -6526963692964328693L;
}
