package pl.edu.agh.sampleapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
 
    private List<Book> mItems;
    private Context mContext;
    private PostItemListener mItemListener;
 
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
 
        public TextView titleTv;
        PostItemListener mItemListener;
 
        public ViewHolder(View itemView, PostItemListener postItemListener) {
            super(itemView);
            titleTv = itemView.findViewById(android.R.id.text1);
 
            this.mItemListener = postItemListener;
            itemView.setOnClickListener(this);
        }
 
        @Override
        public void onClick(View view) {
//            Item item = getItem(getAdapterPosition());
//            this.mItemListener.onPostClick(item.getAnswerId());
//
//            notifyDataSetChanged();
        }
    }
 
    public BookAdapter(Context context, List<Book> books, PostItemListener itemListener) {
        mItems = books;
        mContext = context;
        mItemListener = itemListener;
    }
 
    @Override
    public BookAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
 
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
 
        View postView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);

        return new ViewHolder(postView, this.mItemListener);
    }
 
    @Override
    public void onBindViewHolder(BookAdapter.ViewHolder holder, int position) {
 
        Book book = mItems.get(position);
        TextView textView = holder.titleTv;
        textView.setText(book.getTitle());
    }
 
    @Override
    public int getItemCount() {
        return mItems.size();
    }
 
    public void updateBooks(List<Book> books) {
        mItems = books;
        notifyDataSetChanged();
    }
 
    private Book getItem(int adapterPosition) {
        return mItems.get(adapterPosition);
    }
 
    public interface PostItemListener {
        void onPostClick(long id);
    }
}