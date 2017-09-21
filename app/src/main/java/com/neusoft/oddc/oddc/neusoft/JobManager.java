package com.neusoft.oddc.oddc.neusoft;

import android.content.Context;
import android.util.Log;

import com.neusoft.oddc.NeusoftHandler;
import com.neusoft.oddc.oddc.dal.JobsDAO;
import com.neusoft.oddc.oddc.model.ODDCJob;
import com.neusoft.oddc.oddc.model.ODDCTask;
import com.neusoft.oddc.oddc.restclient.RESTController;
import com.neusoft.oddc.widget.PropertyUtil;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by yzharchuk on 8/8/2017.
 */

public class JobManager
{
    private RESTController restController;

    private boolean isProcessingJobs = false;
    private Timer pingTimer;
    private int pingFrequency = 10;
    private ODDCclass oddc;
    private NeusoftHandler nsh;

    public JobManager(String url)
    {
        restController = new RESTController(url);
    }

    public void setODDC(ODDCclass oddc)
    {
        this.oddc = oddc;
    }
    public void setNSHandler(NeusoftHandler n){this.nsh = n;}

    public void setPingFrequency(int value)
    {
        pingFrequency = value;
    }

    private ArrayList<ODDCJob> getJobsFromServer()
    {
        ArrayList<ODDCJob>jobs = restController.getJobList();
        return jobs;
    }

    public ArrayList<ODDCJob> getJobList()
    {
        return getJobsFromServer();
    }

    public void processJobs(ArrayList<ODDCJob> jobs)
    {
        if(isProcessingJobs)
        {
            return;
        }

        isProcessingJobs = true;

        if(jobs.size() > 0)
        {
            for(ODDCJob job: jobs)
            {
                processJob(job);
            }

            isProcessingJobs = false;
        }
    }

    private void processJob(ODDCJob job)
    {
        ArrayList <ODDCTask> tasks = job.getTasks();

        if(tasks.size() > 0)
        {
            for(ODDCTask task : tasks)
            {
                processTask(task);
            }
        }
    }

    public void processTask(ODDCTask task)
    {
        switch (task.getType())
        {
            case SELECTIVE_UPLOAD:
                processSelectiveUploadTask(task);
                break;
            case UPLOAD:
                nsh.resume();
                break;
            case STOP:
                nsh.stop();
                break;
            case TERMINATE:
                processTerminateTask();
                break;
            case RESUME:
                nsh.resume();
                break;
            case CHANGE_PARAMETERS:
                processParametersTask();
                break;
            case CHANGE_PROPERTIES:
                processPropertiesTask();
                break;
            default:
                Log.d("processTask", "No tasks from Server.");
        }
    }

    private void processResumedTask()
    {
        //TODO FTCA implementation here
        Log.d("processResumedTask", "processResumedTask");

        if(oddc == null)
        {
            Log.d("processResumedTask", "ODDC is not initialized.");
            return;
        }
    }

    private void processTerminateTask()
    {
        //TODO FTCA implementation here
        Log.d("processTerminateTask", "processTerminateTask");

        if(oddc == null)
        {
            Log.d("processTerminateTask", "ODDC is not initialized.");
            return;
        }
    }



    private void processUploadTask()
    {
        //TODO FTCA implementation here
        Log.d("processUploadTask", "processUploadTask");
        if(oddc == null)
        {
            Log.d("processUploadTask", "ODDC is not initialized.");
            return;
        }
        //TODO: Make a call to ODDC function to request Neusoft systems to enable if it is currently inactive.
        //      If the current activity is the ADAS/DVR screen, start the Continuous Data collection process.
    }

    private void processParametersTask()
    {
        //TODO FTCA implementation here
        Log.d("processParametersTask", "processParametersTask");

        if(oddc == null)
        {
            Log.d("processParametersTask", "ODDC is not initialized.");
            return;
        }

        //TODO: Parse the parameter list

        //TODO: Call ODDC to modify parameter value based on the parameter name...
    }

    private void processPropertiesTask()
    {
        //TODO FTCA implementation here
        Log.d("processPropertiesTask", "processPropertiesTask");

        if(oddc == null)
        {
            Log.d("processPropertiesTask", "ODDC is not initialized.");
            return;
        }

        //TODO: Parse the Properties list and corresponding value(s)
        //      Part of the parameters for this command should include the file name of the media file.

        //TODO: Call ODDC to move the file(s) to/from protected folder based on boolean value
        //      True - Move to Protected Folder: Files in this folder will not be deleted during File Manager clean up
        //      False - Move to Normal Folder: Files in this folder can be deleted during File Manager clean up
    }

    private void processSelectiveUploadTask(ODDCTask task)
    {
        oddc.selectiveUpload(task);


        //TODO: Parse the file name list

        //TODO: Using the file list, ODDC / File Manager should search for the files if they exist

        //TODO: Package files into DataPackage

        //TODO: Use RESTController to upload the DataPackage to ODDC/AWS Server
    }

    public void startPingTimer()
    {
        pingTimer = new Timer();
        pingTimer.schedule(new TimerTask() {
            @Override
            public void run()
            {
                //TODO: Pull Job List from ODDC Server
                ArrayList<ODDCJob> jobs = getJobsFromServer();

                //TODO: Process each Job
                if(jobs != null && jobs.size() > 0)
                {
                    processJobs(jobs);
                }
            }
        }, 1000, pingFrequency);
    }

    public void stopPingTimer()
    {
        if(pingTimer != null)
        {
            pingTimer.cancel();
            pingTimer.purge();
        }
    }
}
