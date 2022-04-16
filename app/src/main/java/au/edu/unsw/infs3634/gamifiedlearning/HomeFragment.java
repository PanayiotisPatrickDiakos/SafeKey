package au.edu.unsw.infs3634.gamifiedlearning;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFragment extends Fragment {
    private String TAG = "HomeFragment";
    private RecyclerView mRecyclerView;
    private ModuleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_module_list, container, false);

        mRecyclerView = view.findViewById(R.id.rv_ListModule);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new GridLayoutManager(view.getContext(), 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ModuleAdapter.RecyclerViewClickListener listener = new ModuleAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, String moduleSymbol) {
                Log.d(TAG, moduleSymbol);
                launchDetailActivity(moduleSymbol);
            }
        };

        mAdapter = new ModuleAdapter(Module.getModules(), listener);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    protected void launchDetailActivity (String symbol) {
        Log.d(TAG, "Detail Activity Launched");
        Intent intent = new Intent(getContext(), ModuleDetailActivity.class);
        intent.putExtra(ModuleDetailActivity.INTENT_MESSAGE, symbol);
        startActivity(intent);

    }

}
