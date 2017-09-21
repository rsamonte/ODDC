package com.neusoft.oddc.oddc.restclient;

import android.os.AsyncTask;
import android.util.Log;

import com.neusoft.oddc.oddc.model.TaskType;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;


/**
 * Created by yzharchuk on 8/24/2017.
 */

class PostCommandCheckTask extends AsyncTask<Void, Void, ArrayList<TaskType>>
{
    private String url;
    private HttpStatus returnStatus;

    public PostCommandCheckTask(String url)
    {
        this.url = url;
    }

    @Override
    protected ArrayList<TaskType> doInBackground(Void... data)
    {
        ArrayList<TaskType> ret = null;
        RestTemplate restTemplate = new RestTemplate();
        try
        {
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            ResponseEntity<Object> result = restTemplate.exchange(url, HttpMethod.POST, null, Object.class);

            if (result != null)
            {
                ret = new ArrayList<TaskType>();
                ArrayList<String> temp = (ArrayList<String>)result.getBody();

                if (temp != null && !temp.isEmpty() && temp.size() > 0)
                    for (String name : temp)
                        ret.add(TaskType.valueOf(name));
                else
                    ret = null;
            }
        }
        catch (Exception e)
        {
            Log.e("PostCommandCheckTask", "Error retrieving comands." + e.getMessage());
        }
        return ret;
    }

    @Override
    protected void onPostExecute(ArrayList<TaskType> tasks)
    {
    }
}
