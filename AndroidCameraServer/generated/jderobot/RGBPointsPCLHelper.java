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
// Generated from file `RGBPointsPCLHelper.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package jderobot;

public final class RGBPointsPCLHelper
{
    public static void
    write(IceInternal.BasicStream __os, RGBPoint[] __v)
    {
        if(__v == null)
        {
            __os.writeSize(0);
        }
        else
        {
            __os.writeSize(__v.length);
            for(int __i0 = 0; __i0 < __v.length; __i0++)
            {
                __v[__i0].__write(__os);
            }
        }
    }

    public static RGBPoint[]
    read(IceInternal.BasicStream __is)
    {
        RGBPoint[] __v;
        final int __len0 = __is.readAndCheckSeqSize(28);
        __v = new RGBPoint[__len0];
        for(int __i0 = 0; __i0 < __len0; __i0++)
        {
            __v[__i0] = new RGBPoint();
            __v[__i0].__read(__is);
        }
        return __v;
    }
}
