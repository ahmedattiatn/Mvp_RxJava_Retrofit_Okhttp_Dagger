package ahmedattia.project.mainScreen;

import ahmedattia.project.dagger.component.NetComponent;
import ahmedattia.project.util.CustomScope;
import dagger.Component;

/**
 * Created by Ahmed Attia on 08/06/2017.
 */
/*MainScreenComponent depends mel NetComponent bech najmou nal9aw el retrofit
( bara class NetComponent bech tzid tefhem akther)
fel MainActivity  bech na3mlou injection MainScreenPresenter
* */

@CustomScope
/*In Dagger, two dependent components cannot share the same
     scope i.e (Our NetComponent  and MainScreenComponent cannot share the scope of @Singlton).
      So we create a custom  scope  called @CustomScope to be used
      by our MainScreenComponent and MainScreenModule */
@Component(dependencies =NetComponent.class,modules = MainScreenModule.class)
public interface MainScreenComponent {
    void inject(MainActivity mainActivity);
}
