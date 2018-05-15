package com.wtb.sourcecodered.layoutmanager;

import android.content.Context;
import android.graphics.BitmapFactory;

import com.squareup.picasso.Picasso;
import com.wtb.sourcecodered.recyclerview.RecyclerView;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * Created by Julian Villella on 16-02-24.
 */
public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder> implements GreedoLayoutSizeCalculator.SizeCalculatorDelegate {
    private static final int IMAGE_COUNT = 500; // number of images adapter will show

    private final int[] mImageResIds = Constants.IMAGES;
    private final double[] mImageAspectRatios = new double[Constants.IMAGES.length];

    private Context mContext;

    @Override
    public double aspectRatioForIndex(int index) {
        // Precaution, have better handling for this in greedo-layout
        if (index >= getItemCount()) return 1.0;
        return mImageAspectRatios[getLoopedIndex(index)];
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        private TextView mTextView;
        public PhotoViewHolder(ViewGroup view) {
            super(view);
            mImageView = (ImageView) view.getChildAt(0);
            mTextView = (TextView) view.getChildAt(1);
        }
    }

    public PhotosAdapter(Context context) {
        mContext = context;
        calculateImageAspectRatios();
    }

    int count;
    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        count++;
        Log.i("PhototsAdapter","onCreateViewHolder count ="+count +",viewType="+viewType);
        FrameLayout p = new FrameLayout(mContext);
        p.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        ImageView imageView = new ImageView(mContext);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));
        p.addView(imageView);
        TextView textView = new TextView(mContext);
        p.addView(textView);
        return new PhotoViewHolder(p);
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {
        Picasso.get()
                .load(mImageResIds[getLoopedIndex(position)])
                .into(holder.mImageView);
        holder.mTextView.setText("position:"+position);
    }

    @Override
    public int getItemCount() {
        return IMAGE_COUNT;
    }

    private void calculateImageAspectRatios() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;

        for (int i = 0; i < mImageResIds.length; i++) {
            BitmapFactory.decodeResource(mContext.getResources(), mImageResIds[i], options);
            mImageAspectRatios[i] = options.outWidth / (double) options.outHeight;
        }
    }

    // Index gets wrapped around <code>Constants.IMAGES.length</code> so we can loop content.
    private int getLoopedIndex(int index) {
        return index % Constants.IMAGES.length; // wrap around
    }
}
