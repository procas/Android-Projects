package com.example.promamukherjee.webservice;

import org.ksoap2.serialization.SoapObject;

import android.os.AsyncTask;
import android.util.Log;

import com.example.promamukherjee.webservice.MainActivity;
import com.example.promamukherjee.webservice.ConstantString;
import com.example.promamukherjee.webservice.WebServiceCall;

 class ConvertArray extends AsyncTask<String, Void, String> {


     private MainActivity activity;
    private String soapAction;
    private String methodName;
    private String paramsName;

    private final static String TAG = ConvertArray.class.getSimpleName();

    public ConvertArray(MainActivity activity, String soapAction, String methodName ) {
        this.activity = activity;
        this.methodName = methodName;
        this.soapAction = soapAction;

    }

    @Override
    protected String doInBackground(String... urls) {
        //create a new soap request object
        SoapObject request = new SoapObject(ConstantString.NAME_SPACE, ConstantString.METHOD);

       // request.addProperty(paramsName, params[0]);
        request.addProperty("Proma", "20");


        return WebServiceCall.callWSThreadSoapPrimitive(ConstantString.URL, soapAction, request); //result

    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (result == null) {
            Log.i(TAG, "cannot get result");
        } else {
            //invoke call back method of Activity
            activity.callBackDataFromAsyncTask(result);
        }
    }



}