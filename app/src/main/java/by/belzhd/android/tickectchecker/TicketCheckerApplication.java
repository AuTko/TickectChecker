package by.belzhd.android.tickectchecker;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.huma.room_for_asset.RoomAsset;

import by.belzhd.android.tickectchecker.db.GeneralAppDatabase;
import by.belzhd.android.tickectchecker.db.ReportsAppDatabase;
import by.belzhd.android.tickectchecker.prefs.TicketCheckerPreferencesManager;

import static by.belzhd.android.tickectchecker.utils.Constants.GENERAL_DB;
import static by.belzhd.android.tickectchecker.utils.Constants.REPORTS_DB;

public class TicketCheckerApplication extends Application {

    private static GeneralAppDatabase generalDB;
    private static ReportsAppDatabase reportsDB;
    private static TicketCheckerPreferencesManager prefs;

    @Override
    public void onCreate() {
        super.onCreate();
        generalDB = RoomAsset.databaseBuilder(this, GeneralAppDatabase.class, GENERAL_DB).build();
        reportsDB = Room.databaseBuilder(this, ReportsAppDatabase.class, REPORTS_DB).allowMainThreadQueries().build();
        prefs = new TicketCheckerPreferencesManager(getApplicationContext());
    }

    public static GeneralAppDatabase getGeneralDB() {
        return generalDB;
    }

    public static ReportsAppDatabase getReportsDB() {
        return reportsDB;
    }

    public static TicketCheckerPreferencesManager prefs() {
        return prefs;
    }
}
