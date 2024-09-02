package com.edge.college.student;

import java.util.concurrent.ConcurrentHashMap;
import java.time.LocalDate;
import java.util.HashMap;

public class Attendance {

    private static final ConcurrentHashMap<String, HashMap<String, Integer>> attendanceRegister = new ConcurrentHashMap<>();

    public static synchronized void markPresent(int id, LocalDate date) throws Exception {
        Student s = Student.getStudent(id);
        if (s == null) {
            throw new Exception("unknown student");
        } else {
            String key = String.format("%s:%s", date.getMonth(), date.getYear());
            Object entryInRegister = attendanceRegister.get(key);
            if (entryInRegister == null) {
                HashMap<String, Integer> map = new HashMap<>();
                map.put(s.toString(), 1);
                attendanceRegister.put(key, map);
            } else {
                HashMap<String, Integer> attendanceEntry = (HashMap<String, Integer>) entryInRegister;
                Object attendance = attendanceEntry.get(s.toString());
                if (attendance == null) {
                    attendanceEntry.put(s.toString(), 1);
                } else {
                    int att = Integer.parseInt(attendance.toString());
                    attendanceEntry.replace(s.toString(), ++att);
                }
                attendanceRegister.put(key, attendanceEntry);
            }
        }
    }

    public static HashMap<String, HashMap<String, Integer>> getReport(String year) {
        HashMap<String, HashMap<String, Integer>> report = new HashMap<String, HashMap<String, Integer>>();

        Object[] keys = attendanceRegister.keySet().toArray();
        for (Object k : keys) {
            if (k.toString().endsWith(year)) {
                HashMap<String, Integer> studentsAttendanceInMonth = attendanceRegister.get(k.toString());
                report.put(k.toString().split(":")[0], studentsAttendanceInMonth);
            }
        }
        return report;
    }

}
