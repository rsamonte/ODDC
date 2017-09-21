package com.neusoft.oddc.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.neusoft.oddc.R;
import com.neusoft.oddc.ui.continous.ContinousRecyclerAdapter;
import com.neusoft.oddc.ui.continous.EntityContinousGroup;
import com.neusoft.oddc.widget.DataConverter;
import com.neusoft.oddc.widget.recycler.DefaultDividerDecoration;

import java.util.List;

public class OAContinuousUploadLogActivity extends BaseActivity {

    public static final Intent createIntent(Context context) {
        Intent intent = new Intent(context, OAContinuousUploadLogActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_oa_continuous_upload_log);
        setCustomTitle(R.string.title_continuous_upload);

        initViews();
    }

    private void initViews() {
        List<EntityContinousGroup> entities = DataConverter.makeFadeContinuousGroupData();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.oa_continuous_upload_log_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        ContinousRecyclerAdapter adapter = new ContinousRecyclerAdapter(entities, this);
        recyclerView.addItemDecoration(new DefaultDividerDecoration(this));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        // adapter.setOnGroupClickListener(onGroupClickListener);
    }


}
