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
// Generated from file `_VarColorOperationsNC.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package jderobot;

/**
 * Interface to the image provider.
 **/
public interface _VarColorOperationsNC
{
    /**
     * Returns the image source description.
     **/
    ImageDescription getDescription();

    /**
     * Returns the latest data.
     * @param __cb The callback object for the operation.
     **/
    void getData_async(AMD_VarColor_getData __cb)
        throws DataNotExistException,
               HardwareFailedException;
}
