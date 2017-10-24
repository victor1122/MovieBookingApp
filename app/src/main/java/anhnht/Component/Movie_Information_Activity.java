package anhnht.Component;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anhnh.sliderdemo.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Movie_Information_Activity extends AppCompatActivity {

    ImageView imageView;
    private TypedArray image;
    TextView movie_des, movieName;
    Button btnTrailer;
    private DatabaseReference mUserReference;

    private FirebaseUser currentUser;
    private StorageReference mStorageRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie__information_);
        mStorageRef = FirebaseStorage.getInstance().getReference();

        currentUser = FirebaseAuth.getInstance().getCurrentUser();
        String uid = currentUser.getUid();
        mUserReference = FirebaseDatabase.getInstance().getReference().child("Films");
        mUserReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Toast.makeText(Movie_Information_Activity.this, dataSnapshot.toString(), Toast.LENGTH_LONG).show();
                String name = dataSnapshot.child("Film1").child("Name").getValue().toString();
                movieName.setText(name);

                String des = dataSnapshot.child("Film1").child("Description").getValue().toString();
                movie_des.setText(des);

                String url = dataSnapshot.child("Film1").child("Picture").child("image1").getValue().toString();
                Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                imageView.setImageBitmap(bmp);



                Toast.makeText(Movie_Information_Activity.this, url, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });







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
