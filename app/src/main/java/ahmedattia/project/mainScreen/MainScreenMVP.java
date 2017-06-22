package ahmedattia.project.mainScreen;

import java.util.List;

import ahmedattia.project.model.Post;

/**
 * Created by Ahmed Attia on 08/06/2017.
 */

public interface MainScreenMVP {
    interface View {
        void showPosts(List<Post> postList);

        void showError(String message);

        void showComplete();
    }

    interface Presenter {
        void loadPost();
    }
}
