package com.example.algorun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List<String> mainList;
    private HashMap<String,List<String>> subList;

    public ExpandableListViewAdapter(Context context, List<String> mainList, HashMap<String, List<String>> subList) {
        this.context = context;
        this.mainList = mainList;
        this.subList = subList;
    }

    @Override
    public int getGroupCount() {
        return this.mainList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.subList.get(this.mainList.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.mainList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.subList.get(this.mainList.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String mainTitle = (String) getGroup(groupPosition);

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.main_list,null);
        }

        TextView mainTv = convertView.findViewById(R.id.main_tv);
        mainTv.setText(mainTitle);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String subTitle = (String) getChild(groupPosition,childPosition);

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.sub_list,null);
        }

        TextView subTv = convertView.findViewById(R.id.sub_tv);
        subTv.setText(subTitle);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
