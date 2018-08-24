package com.rs.waterLevelIndicator.manage;

import java.util.Vector;
import com.rs.waterLevelIndicator.interfaces.DevTreeSelectListener;
import com.rs.waterLevelIndicator.model.DevSelectEvent;

public class RegistDevSelectChange {
    String value;
    Vector listeners = new Vector();

    public void addListener(DevTreeSelectListener l) {
        listeners.add(l);
    }

    public void setValue(String value) {
        this.value = value;
        fireChanged();
    }

    private void fireChanged() {
        DevSelectEvent e = new DevSelectEvent();
        e.setValue(value);
        for (int i = 0; i < listeners.size(); i++) {
            DevTreeSelectListener l = (DevTreeSelectListener) listeners.elementAt(i);
            l.selectChanged(e);
        }
    }
}
