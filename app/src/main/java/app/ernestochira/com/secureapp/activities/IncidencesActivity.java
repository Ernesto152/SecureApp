package app.ernestochira.com.secureapp.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.login.widget.LoginButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import app.ernestochira.com.secureapp.R;

public class IncidencesActivity extends AppCompatActivity {
    Spinner optionsSpinner;
    private LoginButton loginButton;
    private CallbackManager callbackManager;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_VIDEO_CAPTURE = 2;
    private static final int SELECT_FILE = 3;

    private ImageView pictureImageView;
    com.getbase.floatingactionbutton.FloatingActionButton photoFloatingActionButton;
    com.getbase.floatingactionbutton.FloatingActionButton imageFloatingActionButton;
    com.getbase.floatingactionbutton.FloatingActionButton videoFloatingActionButton;

    private Button aceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incidences);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        optionsSpinner = (Spinner) findViewById(R.id.optionsSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.valores_array, android.R.layout.simple_spinner_item);
        optionsSpinner.setAdapter(adapter);

        pictureImageView = (ImageView) findViewById(R.id.pictureImageView);

        photoFloatingActionButton = (com.getbase.floatingactionbutton.FloatingActionButton) findViewById(R.id.photoFloatingActionButton);
        photoFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCamera();
            }
        });
        /////////////////////////////////////////////////
        imageFloatingActionButton = (com.getbase.floatingactionbutton.FloatingActionButton) findViewById(R.id.imageFloatingActionButton);
        imageFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        });
        //////////////////////////////////////////////////
        videoFloatingActionButton = (com.getbase.floatingactionbutton.FloatingActionButton) findViewById(R.id.videoFloatingActionButton);
        videoFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openVideoCamera();
            }
        });


        //////////////////////////////////////////////
        aceptar = (Button) findViewById(R.id.boton_aceptar);
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createLoginDialogo().show();
            }
        });
        //////////////////////////////////////////////
        FacebookSdk.sdkInitialize(getApplicationContext());
    }

    private void openCamera(){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    private void openVideoCamera(){
        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
        }
    }

    public void openGallery(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(
                Intent.createChooser(intent, "Seleccione una imagen"),
                SELECT_FILE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            pictureImageView.setImageBitmap(imageBitmap);
        }
        else if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK) {
            //Uri videoUri = data.getData();
            //videoVideoView.setVideoURI(videoUri);
        }
    }






    public AlertDialog createLoginDialogo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(IncidencesActivity.this);

        LayoutInflater inflater = IncidencesActivity.this.getLayoutInflater();

        View v = inflater.inflate(R.layout.dialog_signin, null);

        builder.setView(v);

        Button signup = (Button) v.findViewById(R.id.crear_boton);
        Button signin = (Button) v.findViewById(R.id.entrar_boton);

        signup.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Crear Cuenta...
                        dismiss();
                    }
                }
        );
        signin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Loguear...
                        dismiss();
                    }
                }

        );
        return builder.create();
    }

    private void dismiss() {
        finish();
    }
}