/**
 * Copyright 2004-2048 .
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ipd.jsf.gd.codec.dubbo;

/**
 * Title: <br>
 * <p/>
 * Description: <br>
 * <p/>
 */
public class DubboAdapter {

    // magic header.
    protected static final short MAGIC = (short) 0xdabb;

    protected static final byte MAGIC_HIGH = short2bytes(MAGIC)[0];

    protected static final byte MAGIC_LOW = short2bytes(MAGIC)[1];

    // message flag.
    protected static final byte FLAG_REQUEST = (byte) 0x80;

    protected static final byte FLAG_TWOWAY = (byte) 0x40;

    protected static final byte FLAG_EVENT = (byte) 0x20;

    protected static final int SERIALIZATION_MASK = 0x1f;

    /**
     * ok.
     */
    public static final byte OK                = 20;

    /**
     * clien side timeout.
     */
    public static final byte CLIENT_TIMEOUT    = 30;

    /**
     * server side timeout.
     */
    public static final byte SERVER_TIMEOUT    = 31;

    /**
     * request format error.
     */
    public static final byte BAD_REQUEST       = 40;

    /**
     * response format error.
     */
    public static final byte BAD_RESPONSE      = 50;

    /**
     * service not found.
     */
    public static final byte SERVICE_NOT_FOUND = 60;

    /**
     * service error.
     */
    public static final byte SERVICE_ERROR     = 70;

    /**
     * internal server error.
     */
    public static final byte SERVER_ERROR      = 80;

    /**
     * internal server error.
     */
    public static final byte CLIENT_ERROR      = 90;

    /**
     * The constant RESPONSE_WITH_EXCEPTION.
     */
    public static final byte RESPONSE_WITH_EXCEPTION = 0;
    /**
     * The constant RESPONSE_VALUE.
     */
    public static final byte RESPONSE_VALUE = 1;
    /**
     * The constant RESPONSE_NULL_VALUE.
     */
    public static final byte RESPONSE_NULL_VALUE = 2;

    /**
     * to byte array.
     *
     * @param v
     *         value.
     * @return byte[].
     */
    private static byte[] short2bytes(short v) {
        byte[] ret = {0, 0};
        ret[1] = (byte) v;
        ret[0] = (byte) (v >>> 8);
        return ret;
    }

    /**
     * 是否匹配此协议
     * @param  b1 第一位
     * @param b2 第二位
     * @return 是否匹配magiccode
     */
    public static boolean match(byte b1, byte b2) {
        return b1 == MAGIC_HIGH && b2 == MAGIC_LOW;
    }
}