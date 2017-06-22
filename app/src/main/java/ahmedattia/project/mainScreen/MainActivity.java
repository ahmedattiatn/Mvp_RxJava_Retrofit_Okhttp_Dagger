package ahmedattia.project.mainScreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import ahmedattia.project.App;
import ahmedattia.project.R;
import ahmedattia.project.model.Post;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainScreenMVP.View {

    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    @Inject
    MainScreenPresenter mainPresenter;

    @BindView(R.id.list_items)
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        ButterKnife.bind(this);

        list = new ArrayList<>();

        DaggerMainScreenComponent.builder()
                .netComponent(((App) getApplicationContext()).getNetComponent())
                .mainScreenModule(new MainScreenModule(this))
                .build().inject(this);
        mainPresenter.loadPost();
    }

    @Override
    public void showPosts(List<Post> postList) {
        for (int i = 0; i < postList.size(); i++) {
            list.add(postList.get(i).getTitle());
        }
        //Create the array adapter and set it to list view
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

    }

    @Override
    public void showError(String message) {
        Toast.makeText(getApplicationContext(), "Error" + message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showComplete() {
        Toast.makeText(getApplicationContext(), "Complete", Toast.LENGTH_SHORT).show();
    }
}
