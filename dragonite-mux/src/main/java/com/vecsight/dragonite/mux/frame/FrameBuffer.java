/*
 * VECTORSIGHT CONFIDENTIAL
 * ------------------------
 * Copyright (c) [2015] - [2017]
 * VectorSight Systems Co., Ltd.
 * All Rights Reserved.
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Written by Toby Huang <t@vecsight.com>, June 2017
 */

package com.vecsight.dragonite.mux.frame;

public class FrameBuffer {

    private final byte[] bytesBuffer;

    private short position = 0;

    public FrameBuffer(final short maxSize) {
        bytesBuffer = new byte[maxSize];
    }

    public void add(final byte[] bytes) {
        System.arraycopy(bytes, 0, bytesBuffer, position, bytes.length);
        position += bytes.length;
    }

    public byte[] get() {
        final byte[] bytes = new byte[position];
        System.arraycopy(bytesBuffer, 0, bytes, 0, position);
        return bytes;
    }

    public void reset() {
        position = 0;
    }

    public short getMaxSize() {
        return (short) bytesBuffer.length;
    }

}