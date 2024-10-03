package me.developery.acturator_study;

import org.springframework.stereotype.Service;

@Service
public class MyTimerManager {

    public long getCount() {
        return System.currentTimeMillis();
    }

    public long getTotalTime() {
        return System.currentTimeMillis() * 2;
    }
}
