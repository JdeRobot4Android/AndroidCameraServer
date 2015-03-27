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
// Generated from file `BodyMovementsPrx.java'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package jderobot;

public interface BodyMovementsPrx extends Ice.ObjectPrx
{
    public int doMovement(BodyMovementsData data);

    public int doMovement(BodyMovementsData data, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_doMovement(BodyMovementsData data);

    public Ice.AsyncResult begin_doMovement(BodyMovementsData data, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_doMovement(BodyMovementsData data, Ice.Callback __cb);

    public Ice.AsyncResult begin_doMovement(BodyMovementsData data, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_doMovement(BodyMovementsData data, Callback_BodyMovements_doMovement __cb);

    public Ice.AsyncResult begin_doMovement(BodyMovementsData data, java.util.Map<String, String> __ctx, Callback_BodyMovements_doMovement __cb);

    public int end_doMovement(Ice.AsyncResult __result);

    public BodyMovementsData getMovement();

    public BodyMovementsData getMovement(java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_getMovement();

    public Ice.AsyncResult begin_getMovement(java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_getMovement(Ice.Callback __cb);

    public Ice.AsyncResult begin_getMovement(java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_getMovement(Callback_BodyMovements_getMovement __cb);

    public Ice.AsyncResult begin_getMovement(java.util.Map<String, String> __ctx, Callback_BodyMovements_getMovement __cb);

    public BodyMovementsData end_getMovement(Ice.AsyncResult __result);
}
