package at.technikumwien.maps;

import android.app.Application;

public class MyApplication extends Application {

    private AppDependencyManager appDependencyManager;

    @Override
    public void onCreate() {
        super.onCreate();
        appDependencyManager = new AppDependencyManager(this);

        appDependencyManager.getSyncManager().schedulePeriodicSync();
    }

    public AppDependencyManager getAppDependencyManager() {
        return appDependencyManager;
    }
}
