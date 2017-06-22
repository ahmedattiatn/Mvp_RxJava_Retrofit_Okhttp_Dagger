package ahmedattia.project.mainScreen;

import ahmedattia.project.util.CustomScope;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Ahmed Attia on 08/06/2017.
 */
/*The purpose of creating MainScreenModule is to provide the View
( in our case MainActivity) to our Presenter .
The Presenter uses this view as a reference to our MainAvtivity to call the methods
in the View (showError(),showComplete())*/

@Module
public class MainScreenModule {
    private final MainScreenMVP.View view;

    public MainScreenModule(MainScreenMVP.View view) {
        this.view = view;
    }

    /*In Dagger, two dependent components cannot share the same
     scope i.e (Our NetComponent  and MainScreenComponent cannot share the scope of @Singlton).
      So we create a custom  scope  called @CustomScope to be used
      by our MainScreenComponent and MainScreenModule */
    @Provides
    @CustomScope
    MainScreenMVP.View provideMainScreenMVPView() {
        return view;
    }
}
