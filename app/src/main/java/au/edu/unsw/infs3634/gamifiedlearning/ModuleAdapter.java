package au.edu.unsw.infs3634.gamifiedlearning;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

    public class ModuleAdapter extends RecyclerView.Adapter<ModuleAdapter.ViewHolder> {
        private static final String TAG = "DestinationAdapter";
        private List<Module> mModules, mModulesFiltered;
        private RecyclerViewClickListener mListener;

        /**
         * Constructor method for ModuleAdapter class
         */
        public ModuleAdapter(List<Module> mModules, RecyclerViewClickListener mListener) {
            this.mModules = mModules;
            this.mListener = mListener;
            this.mModulesFiltered = mModules;
        }

        /**
         * Create the ViewHolder and return it
         */
        @NonNull
        @Override
        public ModuleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.module_card_row, parent, false);
            return new ViewHolder(view, mListener);
        }

        /**
         * Associate the data with the view holder for a given position within the RecyclerView
         * @param holder - Viewholder parameter
         * @param position - integer value of the record's row in the recycler view
         */
        @Override
        public void onBindViewHolder(@NonNull ModuleAdapter.ViewHolder holder, int position) {
            Module module = mModulesFiltered.get(position);
            holder.mImage.setImageResource(module.getIcon());
            holder.mName.setText(module.getName());
            holder.mRating.setRating((Float.parseFloat(String.valueOf(module.getDifficulty()))));
            holder.itemView.setTag(module.getId());

        }

        @Override
        public int getItemCount() {
            return mModulesFiltered.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private ImageView mImage;
            private TextView mName;
            private RatingBar mRating;
            private RecyclerViewClickListener mListener;

            public ViewHolder(@NonNull View view, RecyclerViewClickListener listener) {
                super(view);
                mListener = listener;
                view.setOnClickListener(this);
                mImage = view.findViewById(R.id.iv_Icon);
                mName = view.findViewById(R.id.txt_Name);
                mRating = view.findViewById(R.id.rb_Difficulty);
            }

            @Override
            public void onClick(View view) {
                mListener.onClick(view, (String) view.getTag());
                Log.d(TAG, (String) view.getTag());
            }
        }

        //ClickListener interface
        public interface RecyclerViewClickListener {
            void onClick(View view, String moduleSymbol);
        }
}
