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
// Generated from file `_remoteConfigDel.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package jderobot;

public interface _remoteConfigDel extends Ice._ObjectDel
{
    int initConfiguration(java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    String read(int id, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int write(String data, int id, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;

    int setConfiguration(int id, java.util.Map<String, String> __ctx)
        throws IceInternal.LocalExceptionWrapper;
}
