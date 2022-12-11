package com.example.tfg;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Objects;

public class ViewPagerAdapter extends PagerAdapter {

    Context context;

    int[] images;

    LayoutInflater layoutInflater;

    public ViewPagerAdapter(Context context, int[]images){
        this.context = context;
        this.images = images;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == ((LinearLayout) o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        View imagesView = layoutInflater.inflate(R.layout.profile_images, container, false);
        ImageView imageView = (ImageView) imagesView.findViewById(R.id.profile_image);
        imageView.setImageResource(images[position]);
        Objects.requireNonNull(container).addView(imagesView);
        return imagesView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
}
