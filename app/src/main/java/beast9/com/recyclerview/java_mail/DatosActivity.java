package beast9.com.recyclerview.java_mail;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import beast9.com.recyclerview.R;

public class DatosActivity extends AppCompatActivity {

    private EditText etNombre, etCorreo, etComentario;
    String nombre, correo, comentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBarDatos);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        etNombre = (EditText)findViewById(R.id.nombre);
        etCorreo = (EditText)findViewById(R.id.correo);
        etComentario = (EditText)findViewById(R.id.comentario);

    }


    public void onClickEnviarDatos(View v)
    {
        nombre = etNombre.getText().toString().trim();
        correo = etCorreo.getText().toString().trim();
        comentario = etComentario.getText().toString().trim();

<<<<<<< HEAD
        //Creating SendMail object
        //SendMail sm = new SendMail(this, nombre, correo, comentario);

        //Executing sendmail to send email
        // sm.execute();

        //we can use this method too

=======
>>>>>>> origin/master
        Intent sendEmail = new Intent(Intent.ACTION_SEND);
        sendEmail.setType("plain/text");
        sendEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{correo});
        sendEmail.putExtra(Intent.EXTRA_TEXT, comentario);
        sendEmail.putExtra(Intent.EXTRA_SUBJECT, "Mensaje enviado desde APP por " + nombre);
        startActivity(Intent.createChooser(sendEmail, "Elige una aplicación: "));
<<<<<<< HEAD

=======
>>>>>>> origin/master

    }
}
