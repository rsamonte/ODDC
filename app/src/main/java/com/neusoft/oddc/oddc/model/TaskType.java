/**
 * Created by yzharchuk on 8/2/2017.
 */

package com.neusoft.oddc.oddc.model;

import java.util.HashMap;
import java.util.Map;

public enum TaskType
{
    UPLOAD(0),
    STOP(1),
    RESUME(2),
    TERMINATE(3),
    SELECTIVE_UPLOAD(4),
    CHANGE_PARAMETERS(5),
    CHANGE_PROPERTIES(6);

    private int value;
    private static Map map = new HashMap<>();

    private TaskType(int value) {
        this.value = value;
    }

    static {
        for (TaskType type : TaskType.values()) {
            map.put(type.value, type);
        }
    }

    public static TaskType valueOf(int type) {
        return (TaskType)map.get(type);
    }

    public int getValue() {
        return value;
    }
}
