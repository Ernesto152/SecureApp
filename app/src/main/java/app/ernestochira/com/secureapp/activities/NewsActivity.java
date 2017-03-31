package app.ernestochira.com.secureapp.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import app.ernestochira.com.secureapp.R;
import app.ernestochira.com.secureapp.adapters.NewsAdapter;
import app.ernestochira.com.secureapp.models.NewsService;

public class NewsActivity extends AppCompatActivity {

    RecyclerView newsRecyclerView;
    RecyclerView.LayoutManager newsLayoutManager;
    NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        newsRecyclerView=(RecyclerView) findViewById(R.id.newsRecyclerView);
        newsAdapter = new NewsAdapter();
        newsAdapter.setProducts((new NewsService()).getNews());
        newsLayoutManager = new LinearLayoutManager(this);
        newsRecyclerView.setAdapter(newsAdapter);
        newsRecyclerView.setLayoutManager(newsLayoutManager);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
