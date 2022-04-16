package au.edu.unsw.infs3634.gamifiedlearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ModuleListActivity extends AppCompatActivity {
    private static final String TAG = "ModuleListActivity";
    private RecyclerView mRecyclerView;
    private ModuleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_list);

        //Provide handle for the recycler view
        mRecyclerView = findViewById(R.id.rv_ListModule);
        mRecyclerView.setHasFixedSize(true);

        //Set the recycler view's layout manager
        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //Set an onclick listener for the recycler view
        ModuleAdapter.RecyclerViewClickListener listener = new ModuleAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, String moduleSymbol) {
                Log.d(TAG, moduleSymbol);
                launchDetailActivity(moduleSymbol);
            }
        };

        //Set the recycler view's adapter
        mAdapter = new ModuleAdapter(Module.getModules(), listener);
        mRecyclerView.setAdapter(mAdapter);
    }

    /**
     * Responsible for launching the detail activity once a record is tapped in the recycler view
     * @param symbol - Retrieve the symbol string from the record's Tag() within the recycler iew
     */
    protected void launchDetailActivity (String symbol) {
        Log.d(TAG, "Detail Activity Launched");
        Intent intent = new Intent(this, ModuleDetailActivity.class);
        intent.putExtra(ModuleDetailActivity.INTENT_MESSAGE, symbol);
        startActivity(intent);
    }
}