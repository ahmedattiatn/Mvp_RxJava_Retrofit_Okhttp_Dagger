package ahmedattia.project.dagger.component;

import javax.inject.Singleton;

import ahmedattia.project.dagger.module.AppModule;
import ahmedattia.project.dagger.module.NetModule;
import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Ahmed Attia on 08/06/2017.
 */

/*--------------->fel modele MVP
a7na n7ebou  fel pakage mainScreen ( ya3ni fi ay activities or fragments fi west el package )
kif n7ebou ne5dmou bel retrofit  el MainScreenComponent can find and Inject Retrofit
(5ater fel component bsifa 3amma  dima n7otou el injection win tsir)
donc el 7al houwa :

we will be using this NetComponent as a dependency for our MainScreenComponent
and we expose the return type of Retrofit
(we hakka MainScreenComponent can find retrofit
puice que MainScreenComponent est depend de NetComponent
we NetComponent fih (1 des modules NetModule we AppModule fihom kifeh bech nasn3ou
                        object mel Retrofit
                     2 expose the return type of Retrofit))

* */
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    Retrofit retrofit();
}
