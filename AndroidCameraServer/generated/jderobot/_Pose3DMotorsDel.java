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
// Generated from file `_Pose3DMotorsDel.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package jderobot;

public interface _Pose3DMotorsDel extends Ice._ObjectDel
{
    int setPose3DMotorsData(Pose3DMotorsData data, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    Pose3DMotorsData getPose3DMotorsData(java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    Pose3DMotorsParams getPose3DMotorsParams(java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;
}
