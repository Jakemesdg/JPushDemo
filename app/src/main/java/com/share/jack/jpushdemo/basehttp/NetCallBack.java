package com.share.jack.jpushdemo.basehttp;


import android.util.Log;

import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

/**
 * Author:Created by JackCheng
 */

//自定义回调接口-------->定义成抽象类，能将结果返回
public abstract class NetCallBack extends AsyncHttpResponseHandler {


    //对外开放的两个回调——请求成功和请求失败
    public abstract void onMySuccess(byte[] response);

    public abstract void onMyFailure(byte[] response, Throwable throwable);

    /**
     * 请求成功
     *
     * @param statusCode
     * @param headers
     * @param responseBody
     */
    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
        Log.i("NetCallBack","请求成功------>" + new String(responseBody));
        Log.i("NetCallBack", "请求成功----->header=" + headers.toString());
        Log.i("NetCallBack", "请求成功----->status=" + statusCode);
        onMySuccess(responseBody);

    }

    /**
     * 请求失败
     *
     * @param statusCode
     * @param headers
     * @param responseBody
     * @param error
     */
    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
        Log.i("NetCallBack", "请求失败------>" + new String(responseBody) + "\n错误信息----->" + error.toString());
        Log.i("NetCallBack", "请求失败----->header=" + headers.toString());
        Log.i("NetCallBack", "请求失败----->status=" + statusCode);
        onMyFailure(responseBody, error);
    }

}
