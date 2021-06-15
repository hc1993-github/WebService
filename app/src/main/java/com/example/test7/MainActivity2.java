package com.example.test7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class MainActivity2 extends AppCompatActivity {
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText = findViewById(R.id.edittext);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String number = editText.getText().toString();
                        String info = getNumberinfo(number);
                        Log.d("HC",info);

                    }
                }).start();
            }
        });
    }


    private String getNumberinfo(String number) {
        String url = "http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx";
        String namespace = "http://WebXml.com.cn/";
        String methodName = "getMobileCodeInfo";
        String action = "http://WebXml.com.cn/getMobileCodeInfo";
        SoapObject soapObject = new SoapObject(namespace,methodName);
        soapObject.addProperty("mobileCode",number);
        soapObject.addProperty("userID","");
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapSerializationEnvelope.VER11);
        envelope.bodyOut = soapObject;
        envelope.dotNet = true;
        envelope.setOutputSoapObject(soapObject);
        HttpTransportSE httpTransportSE = new HttpTransportSE(url);
        try {
            httpTransportSE.call(action,envelope);
        } catch (Exception e) {
            e.printStackTrace();
        }
        SoapObject result = (SoapObject) envelope.bodyIn;
        return result.getProperty(0).toString();
    }
}