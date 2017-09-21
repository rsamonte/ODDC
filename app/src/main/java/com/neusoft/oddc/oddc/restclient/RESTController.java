package com.neusoft.oddc.oddc.restclient;

import android.util.Log;

import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import com.neusoft.oddc.oddc.model.DataPackage;
import com.neusoft.oddc.oddc.model.DataPackageType;
import com.neusoft.oddc.oddc.model.Notification;
import com.neusoft.oddc.oddc.model.ODDCJob;
import com.neusoft.oddc.oddc.model.TaskType;

/**
 * Created by yzharchuk on 8/1/2017.
 */

public class RESTController
{
    private String base_url;

    public void setReturnStatus(HttpStatus returnStatus) {
        this.returnStatus = returnStatus;
    }

    public HttpStatus getReturnStatus() {
        return returnStatus;
    }

    private HttpStatus returnStatus;

    public RESTController( String baseUrl)
    {
        base_url = baseUrl;
    }

    public ArrayList<ODDCJob> getJobList()
    {
        ArrayList<ODDCJob> jobs = null;
        try
        {
            // TODO AsyncTask.get() will take the code into a synchronous operation.
            // TODO Basically it will block the main (UI) thread .
            // jobs = new GetJobsRequestTask(base_url + "jobs/all").execute().get();
        }
        catch(Exception e)
        {
            Log.e("GET Jobs failed: ", e.getMessage());
        }
        return jobs;
    }

    public void postNotification(Notification notification)
    {
        new PostNotificationTask(base_url + "notification/general").execute(notification);
    }

    public HttpStatus postDataPackage(DataPackage dataPackage)
    {
        String dataUrl = null;

        if(dataPackage.getPackageType() == DataPackageType.CONTINUOUS)
            dataUrl = "data/continuous";
        else if(dataPackage.getPackageType() == DataPackageType.EVENT)
            dataUrl = "data/event";
        if(dataPackage.getPackageType() == DataPackageType.SELECTIVE)
            dataUrl = "data/selective";

        HttpStatus status = null;
        try
        {
            status = new PostDataPackageTask(base_url + dataUrl).execute(dataPackage).get();
            int i = 0;
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        catch (ExecutionException e)
        {
            Log.e("Err postDataPackage",e.getMessage());
        }

        return status;
    }

    public boolean postSelectiveCheck()
    {
        boolean selectiveRequest = false;

        try
        {
            selectiveRequest = new PostSelectiveCheckTask(base_url + "ping/flag").execute().get();
            int i = 0;
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        catch (ExecutionException e)
        {
            Log.e("Err postSelectiveCheck",e.getMessage());
        }

        return selectiveRequest;
    }

    public ArrayList<TaskType>postCommandCheck()
    {
        ArrayList<TaskType> tasks = null;

        try
        {
            tasks = new PostCommandCheckTask(base_url + "ping/task").execute().get();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        catch (ExecutionException e)
        {
            Log.e("Err postSelectiveCheck",e.getMessage());
        }

        return tasks;
    }
}