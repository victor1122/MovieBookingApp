package anhnht.Component;

import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anhnh.sliderdemo.R;

public class Movie_Information_Activity extends AppCompatActivity {

    ImageView imageView;
    private TypedArray image;
    TextView movie_des, movieName;
    Button btnTrailer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie__information_);
        final int pos = (int) getIntent().getExtras().get("Position");
        //Set movie poster
        imageView= (ImageView) findViewById(R.id.movie_view);
        image = getResources().obtainTypedArray(R.array.movie_poster);
        imageView.setImageResource(image.getResourceId(pos,-1));
        //Set movie description, name
        movie_des = (TextView) findViewById(R.id.txtMovieDes);
        movieName = (TextView) findViewById(R.id.txtMoiveName);
        movie_des.setText(getResources().getStringArray(R.array.movie_descrip)[pos]);
        movieName.setText(getResources().getStringArray(R.array.movie_eng_name)[pos]);
        movie_des.setMovementMethod(new ScrollingMovementMethod());
        //Set trailer button
        btnTrailer = (Button) findViewById(R.id.btnTrailer);
        btnTrailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = getResources().getStringArray(R.array.movie_trailer)[pos];
                System.out.println(url);
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+url.trim())));
            }
        });


    }
}
