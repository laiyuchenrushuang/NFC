package com.ly.nfc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.io.UnsupportedEncodingException;

/**
 * Created by ly on 2019/6/24 14:21
 * <p>
 * Copyright is owned by chengdu haicheng technology
 * co., LTD. The code is only for learning and sharing.
 * It is forbidden to make profits by spreading the code.
 */
public class NFCActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nfc);
        NfcUtils nfcUtils = new NfcUtils(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //开启前台调度系统
        NfcUtils.mNfcAdapter.enableForegroundDispatch(this, NfcUtils.mPendingIntent, NfcUtils.mIntentFilter, NfcUtils.mTechList);
    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        //当该Activity接收到NFC标签时，运行该方法
        //调用工具方法，读取NFC数据
        try {
            String str = NfcUtils.readNFCFromTag(intent);
            Log.d("lylog"," readNFCFromTag");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
