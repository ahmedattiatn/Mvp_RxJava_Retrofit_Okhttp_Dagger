package ahmedattia.project;

import android.app.Application;

import ahmedattia.project.dagger.component.DaggerNetComponent;
import ahmedattia.project.dagger.component.NetComponent;
import ahmedattia.project.dagger.module.AppModule;
import ahmedattia.project.dagger.module.NetModule;

/**
 * Created by Ahmed Attia on 08/06/2017.
 */

public class App extends Application {

    private NetComponent netComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://jsonplaceholder.typicode.com/"))
                .build();
    }

    public NetComponent getNetComponent() {
        return netComponent;
    }
}
