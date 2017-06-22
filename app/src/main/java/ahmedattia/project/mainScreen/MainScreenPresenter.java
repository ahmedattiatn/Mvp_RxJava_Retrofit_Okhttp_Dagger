package ahmedattia.project.mainScreen;

import java.util.List;

import javax.inject.Inject;

import ahmedattia.project.model.Post;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Ahmed Attia on 08/06/2017.
 */
/*
    Our MainPresenter requires retrofit to make the network calls and the View to
    which it will display the results of the network calls.
    So we provide the Retrofit and View (MainActivity) by injecting them in
    the constructor.
    So whenever a new object of MainPresenter is created Dagger will inject
    the dependency.
    The retrofit dependency will be provided by NetComponent and the
    MainScreenContract.View dependency will be provided by the MainScreenComponent
    whenever we inject it in our Views(in our case we will inject it in MainActivity)


* */
public class MainScreenPresenter implements MainScreenMVP.Presenter {
    Retrofit retrofit;
    MainScreenMVP.View mView;

    @Inject
    public MainScreenPresenter(Retrofit retrofit, MainScreenMVP.View mView) {
        this.retrofit = retrofit;
        this.mView = mView;
    }

    @Override
    public void loadPost() {
        retrofit.create(PostService.class).getPostList().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Post>>() {
                    @Override
                    public void onCompleted() {
                        mView.showComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Post> posts) {
                        mView.showPosts(posts);
                    }
                });

    }

    private interface PostService {
        @GET("/posts")
        Observable<List<Post>> getPostList();
    }
}



