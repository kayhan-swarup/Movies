package com.swarup.kayhan.movies;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    public final int ALL = 0;
    public final int ACTION = 1;
    public final int ANIMATION = 2;
    public final int COMEDY = 3;
    public final int THRILLER = 4;
    public final int CRIME = 5;

    String [] urls = {"http://www.imdb.com/title/tt0111161/",
                        "http://www.imdb.com/title/tt0068646/",
                        "http://www.imdb.com/title/tt0468569/",
                        "http://www.imdb.com/title/tt0110912/",
                        "http://www.imdb.com/title/tt0060196/",
                        "http://www.imdb.com/title/tt1375666/",
                        "http://www.imdb.com/title/tt0892769/",
                        "http://www.imdb.com/title/tt0114709/"

                        };
    String [] allMovies = {"The Shawshank Redemption","The Godfather","The Dark Knight","Pulp Fiction","The Good, the Bad and the Ugly","Inception",
                            "How To Train Your Dragon","Toy Story"};
    int[] allGenres = {CRIME,CRIME,ACTION,THRILLER,ACTION,ACTION,ANIMATION,ANIMATION};
    int[] years = {1992,1972,2008,1994,1966,2010,2010,1995};


    HashMap<String,Integer> movieList = new HashMap<String,Integer>();
    ListView listView;
    ArrayAdapter<String> adapter;
    Spinner spinner;
    ArrayList<String> moviesInTheList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner)findViewById(R.id.genre);
        listView = (ListView)findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,moviesInTheList);
        listView.setAdapter(adapter);
        for(int i=0;i<allMovies.length;i++){
            movieList.put(allMovies[i],i);
        }
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case ALL:
                        moviesInTheList.clear();
                        for(String s : allMovies)
                           moviesInTheList.add(s);

                        break;
                    case ACTION:
                        moviesInTheList.clear();
                        for(int i=0;i<allGenres.length;i++){
                            if(allGenres[i]==ACTION)
                                moviesInTheList.add(allMovies[i]);
                        }
                        break;
                    case ANIMATION:
                        moviesInTheList.clear();
                        for(int i=0;i<allGenres.length;i++){
                            if(allGenres[i]==ANIMATION)
                                moviesInTheList.add(allMovies[i]);
                        }
                        break;
                    case COMEDY:
                        moviesInTheList.clear();
                        for(int i=0;i<allGenres.length;i++){
                            if(allGenres[i]==COMEDY)
                                moviesInTheList.add(allMovies[i]);
                        }
                        break;
                    case THRILLER:
                        moviesInTheList.clear();
                        for(int i=0;i<allGenres.length;i++){
                            if(allGenres[i]==THRILLER)
                                moviesInTheList.add(allMovies[i]);
                        }
                        break;
                    case CRIME:
                        moviesInTheList.clear();
                        for(int i=0;i<allGenres.length;i++){
                            if(allGenres[i]==CRIME)
                                moviesInTheList.add(allMovies[i]);
                        }
                        break;
                    default:
                        break;
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                moviesInTheList.clear();
                for(String s:allMovies)
                    moviesInTheList.add(s);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie movie;
                if(position<moviesInTheList.size()){

                    movie = new Movie(moviesInTheList.get(position),allGenres[movieList.get(moviesInTheList.get(position))],
                            years[movieList.get(moviesInTheList.get(position))],urls[movieList.get(moviesInTheList.get(position))]);

                    movie.setTitle(movie.getTitle());
                    movie.show(getSupportFragmentManager(),"TAG");


                }

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
