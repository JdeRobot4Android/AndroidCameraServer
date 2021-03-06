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
// Generated from file `body.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package jderobot;

/**
 * simply body motor
 **/
public class BodyMotor implements java.lang.Cloneable, java.io.Serializable
{
    public float pitch;

    public float yaw;

    public float roll;

    public BodyMotor()
    {
    }

    public BodyMotor(float pitch, float yaw, float roll)
    {
        this.pitch = pitch;
        this.yaw = yaw;
        this.roll = roll;
    }

    public boolean
    equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        BodyMotor _r = null;
        if(rhs instanceof BodyMotor)
        {
            _r = (BodyMotor)rhs;
        }

        if(_r != null)
        {
            if(pitch != _r.pitch)
            {
                return false;
            }
            if(yaw != _r.yaw)
            {
                return false;
            }
            if(roll != _r.roll)
            {
                return false;
            }

            return true;
        }

        return false;
    }

    public int
    hashCode()
    {
        int __h = 5381;
        __h = IceInternal.HashUtil.hashAdd(__h, "::jderobot::BodyMotor");
        __h = IceInternal.HashUtil.hashAdd(__h, pitch);
        __h = IceInternal.HashUtil.hashAdd(__h, yaw);
        __h = IceInternal.HashUtil.hashAdd(__h, roll);
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
        __os.writeFloat(pitch);
        __os.writeFloat(yaw);
        __os.writeFloat(roll);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        pitch = __is.readFloat();
        yaw = __is.readFloat();
        roll = __is.readFloat();
    }

    public static final long serialVersionUID = 2933688184509594668L;
}
