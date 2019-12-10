package com.turaapp.listofcases.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.turaapp.listofcases.Models.Task;
import com.turaapp.listofcases.R;

import java.util.ArrayList;

public class TaskAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    public ArrayList<Task> objects;

    public TaskAdapter(Context context, ArrayList<Task> tasks){
        this.context = context;
        this.objects = tasks;
        inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.item_task, parent, false);
        }
        Task t = getTask(position);
        TextView tv = view.findViewById(R.id.finaltextview);
        Button delete = view.findViewById(R.id.delete);
        tv.setText(t.title);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delTask(position);
            }
        });
        return view;
    }

    private Task getTask(int position) {
        return ((Task) getItem(position));
    }

    public void addTask(Task task){
        objects.add(task);
        this.notifyDataSetChanged();

    }
    public void delTask(int pos){
        objects.remove(pos);
        this.notifyDataSetChanged();
    }
}
