package com.example.promamukherjee.testjson;

import java.util.Hashtable;
import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class Bean implements KvmSerializable
{
    public String Country;


    public Bean(){}

    public Bean(String Country) {
        this.Country= Country;

    }

    @Override
    public Object getProperty(int arg0) {
        switch(arg0)
        {
            case 0:
                return Country;

        }
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 2;
    }
    @Override

    public void getPropertyInfo(int index, Hashtable arg1, PropertyInfo info) {
        switch(index)
        {
            case 0:
                info.type = PropertyInfo.STRING_CLASS;
                info.name = "Country";
                break;

            default:
                break;
        }
    }

    @Override
    public void setProperty(int index, Object value) {
        switch(index)
        {
            case 0:
                Country= value.toString();
                break;

            default:
                break;
        }
    }
}
