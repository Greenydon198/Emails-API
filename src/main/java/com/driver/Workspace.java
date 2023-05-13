package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
        super(emailId,Integer.MAX_VALUE);
        calendar = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        calendar.add(meeting);
    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
        if(calendar.size()==0)return 0;
        Collections.sort(calendar,(x,y)->x.startTime.compareTo(y.startTime));
        int max = 1;
        int lis[] = new int[calendar.size()];
        lis[0] = 1;
//        System.out.println(calendar);
        for(int i=1;i<calendar.size();i++){
            int curr = 0;
//            Meeting t = calendar.get(i);
            LocalTime s = calendar.get(i).startTime;
            for(int j=i-1;j>=0;j--){
                LocalTime e = calendar.get(j).endTime;
                if(s.compareTo(e)>0){
                    curr = Math.max(curr,lis[j]);
                }
            }
            lis[i] = curr + 1;
            max = Math.max(max,lis[i]);
        }
        return max;
    }
}
