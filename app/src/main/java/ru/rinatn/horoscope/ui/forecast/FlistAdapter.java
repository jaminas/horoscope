package ru.rinatn.horoscope.ui.forecast;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import ru.rinatn.horoscope.R;
import ru.rinatn.horoscope.model.Forecast;

public class FlistAdapter extends RecyclerView.Adapter<FlistAdapter.FlistViewHolder>
{
    private List<Forecast> forecasts;

    public FlistAdapter(List<Forecast> forecasts)
    {
        this.forecasts = forecasts;
    }

    @Override
    public FlistAdapter.FlistViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new FlistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FlistViewHolder holder, int position)
    {
        Log.i("--------------", String.valueOf(position));

        String dn = "";
        switch (position)
        {
            case (0): dn = "Вчера"; break;
            case (1): dn = "Сегодня"; break;
            case (2): dn = "Завтра"; break;
        }

        if (forecasts != null && forecasts.get(position) != null)
        {
            holder.titleView.setText(dn);
            holder.descriptionView.setText(forecasts.get(position).getText());
        }
        else
        {
            holder.titleView.setText(dn);
            holder.descriptionView.setText("No data");
        }


    }

    @Override
    public int getItemCount() {
        //return dataset.size();
        return 3;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    public static class FlistViewHolder extends RecyclerView.ViewHolder
    {
        final TextView titleView;
        final TextView descriptionView;

        FlistViewHolder(View view)
        {
            super(view);
            titleView = (TextView) view.findViewById(R.id.title);
            descriptionView = (TextView) view.findViewById(R.id.description);
        }
    }
}

