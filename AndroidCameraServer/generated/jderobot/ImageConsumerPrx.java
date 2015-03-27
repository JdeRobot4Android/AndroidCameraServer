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
// Generated from file `ImageConsumerPrx.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package jderobot;

public interface ImageConsumerPrx extends Ice.ObjectPrx
{
    public void report(ImageData obj);

    public void report(ImageData obj, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_report(ImageData obj);

    public Ice.AsyncResult begin_report(ImageData obj, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_report(ImageData obj, Ice.Callback __cb);

    public Ice.AsyncResult begin_report(ImageData obj, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_report(ImageData obj, Callback_ImageConsumer_report __cb);

    public Ice.AsyncResult begin_report(ImageData obj, java.util.Map<String, String> __ctx, Callback_ImageConsumer_report __cb);

    public void end_report(Ice.AsyncResult __result);
}
