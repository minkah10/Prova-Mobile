package br.com.minkaholiveira.cadastroproduto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText usuarioLogin = (EditText) findViewById(R.id.tela_login_user);
        final EditText senhaLogin = (EditText) findViewById(R.id.tela_login_pass);
        Button buttonLogin = (Button) findViewById(R.id.tela_login_button);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = usuarioLogin.getText().toString();
                String senha = senhaLogin.getText().toString();

                if ((usuario.equals("Admin")) && (senha.equals("admin123"))){
                    Intent IntentLogin = new Intent(LoginActivity.this, TelaInicial.class);
                    startActivity(IntentLogin);

                    Toast.makeText(LoginActivity.this, "Bem Vindo!",
                            Toast.LENGTH_SHORT).show();


                }else {
                    Toast.makeText(LoginActivity.this, "Usuario ou senha incorreto",
                            Toast.LENGTH_SHORT).show();

                }
            }
        });


    }


}
