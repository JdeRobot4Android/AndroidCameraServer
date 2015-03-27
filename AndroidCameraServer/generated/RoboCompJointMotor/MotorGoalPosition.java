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
// Generated from file `MotorGoalPosition.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package RoboCompJointMotor;

public class MotorGoalPosition implements java.lang.Cloneable, java.io.Serializable
{
    public String name;

    public float position;

    public float maxSpeed;

    public MotorGoalPosition()
    {
    }

    public MotorGoalPosition(String name, float position, float maxSpeed)
    {
        this.name = name;
        this.position = position;
        this.maxSpeed = maxSpeed;
    }

    public boolean
    equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        MotorGoalPosition _r = null;
        try
        {
            _r = (MotorGoalPosition)rhs;
        }
        catch(ClassCastException ex)
        {
        }

        if(_r != null)
        {
            if(name != _r.name)
            {
                if(name == null || _r.name == null || !name.equals(_r.name))
                {
                    return false;
                }
            }
            if(position != _r.position)
            {
                return false;
            }
            if(maxSpeed != _r.maxSpeed)
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
        int __h = 0;
        if(name != null)
        {
            __h = 5 * __h + name.hashCode();
        }
        __h = 5 * __h + java.lang.Float.floatToIntBits(position);
        __h = 5 * __h + java.lang.Float.floatToIntBits(maxSpeed);
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
        __os.writeString(name);
        __os.writeFloat(position);
        __os.writeFloat(maxSpeed);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        name = __is.readString();
        position = __is.readFloat();
        maxSpeed = __is.readFloat();
    }
}
