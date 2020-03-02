package ca.cmpt276.restauranthealthinspection.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import java.util.*;

/**
 *
 */
public class Inspection implements Iterable <Violation>{
    @CsvBindByName(column = "TrackingNumber", required = true)
    private String insTrackingNumber;

    @CsvBindByName(column = "InspectionDate", required = true)
    @CsvDate("yyyyMMdd")
    private Calendar calendar;

    public Calendar getCalendar() {
        return calendar;
    }

    private int month;

    private int day;

    private int year;

    @CsvBindByName(column = "InspType", required = true)
    private String insType;

    @CsvBindByName(column = "NumCritical", required = true)
    private int numCritical;

    @CsvBindByName(column = "NumNonCritical", required = true)
    private int numNonCritical;

    @CsvBindByName(column = "HazardRating", required = true)
    private String hazardRating;

    @CsvBindByName(column = "ViolLump")
    private String violLump;

    private List<Violation> violations = new ArrayList<>();

    // Source : https://stackoverflow.com/questions/7103064/java-calculate-the-number-of-days-between-two-dates/14278129
    int getDaysInBetween() {
        long days = Calendar.getInstance().getTimeInMillis() - calendar.getTimeInMillis();

        return (int) Math.round(days / (60.0 * 60 * 24 * 1000)); // 60 seconds * 60 minutes * 24 hours * 1000 ms per second
    }

    public String getFromCurrentDate() {
        if (getDaysInBetween() <= 30) { // hardcode each month's ending day!!
            return getDaysInBetween() + " days";
        }

        // Not accounting for leap years
        if (getDaysInBetween() <= 365) {
            return calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.CANADA)
                    + " " + calendar.get(Calendar.DAY_OF_MONTH);
        }

        return calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.CANADA)
                + " " + calendar.get(Calendar.YEAR);
    }

    // ****************************************
    // Methods for List<Violation> violations
    // ****************************************

    public void add (Violation violation) {
        violations.add(violation);
    }

    public Violation get(int index) {
        return violations.get(index);
    }

    public int size() {
        return violations.size();
    }

    public void remove(int index) {
        violations.remove(index);
    }

    @Override
    public Iterator<Violation> iterator() {
        return violations.iterator();
    }

    // **************
    // Other methods
    // **************

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    public String getInsType() {
        return insType;
    }

    public int getNumCritical() {
        return numCritical;
    }

    public int getNumNonCritical() {
        return numNonCritical;
    }

    public String getHazardRating() {
        return hazardRating;
    }

    public List<Violation> getViolations() {
        return violations;
    }

    public String getInsTrackingNumber() {
        return insTrackingNumber;
    }

    public String getViolLump() {
        return violLump;
    }

    @Override
    public String toString() {
        return "\n\tInspection{" +
                "insTrackingNumber='" + insTrackingNumber + '\'' +
                ", year=" + calendar.get(Calendar.YEAR) +
                ", month=" + calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.CANADA) +
                ", day=" + calendar.get(Calendar.DAY_OF_MONTH) +
                ", insType='" + insType + '\'' +
                ", numCritical=" + numCritical +
                ", numNonCritical=" + numNonCritical +
                ", hazardRating='" + hazardRating + '\'' +
                ", violLump='" + violLump + '\'' +
                '}';
    }
}
