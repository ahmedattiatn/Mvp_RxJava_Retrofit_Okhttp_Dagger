package ahmedattia.project.dagger.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ahmed Attia on 08/06/2017.
 */
@Module
public class AppModule {
    /*Now because Retrofit and OkHttp will be used through the application
      we will created an AppModule that will be instantiated when the Application starts
      so that the app context is provided to Retrofit and OkHttp library
   * donc el hadaf ta3 Appmodule hiya bech twaffer el App Context
   * */
    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return application;
    }

}
