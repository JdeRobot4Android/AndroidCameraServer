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
// Generated from file `CameraBody.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package jderobot;

public enum CameraBody implements java.io.Serializable
{
    
    Top,
    
    Bottom;

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeByte((byte)ordinal());
    }

    public static CameraBody
    __read(IceInternal.BasicStream __is)
    {
        int __v = __is.readByte(2);
        return values()[__v];
    }
}
