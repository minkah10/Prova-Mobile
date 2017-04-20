package br.com.minkaholiveira.cadastroproduto;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TelaInicial extends AppCompatActivity {

    TextView nomeGravado;
    TextView valorGravado;
    TextView categoriaGravado;
    Button cadastraProduto;
    ImageView imagemCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);


        nomeGravado = (TextView) findViewById(R.id.tela_inicial_nome_produto);
        valorGravado = (TextView) findViewById(R.id.tela_inicial_valor_produto);
        categoriaGravado = (TextView) findViewById(R.id.tela_inicial_categoria_produto);
        imagemCheck = (ImageView) findViewById(R.id.tela_inicial_imagem);
        cadastraProduto = (Button) findViewById(R.id.tela_inicial_botao);

        cadastraProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent IntentTelaCadastro = new Intent(TelaInicial.this, CadastraProduto.class);

                imagemCheck.setVisibility(View.INVISIBLE);

                startActivityForResult(IntentTelaCadastro, 200);
            }
        });
    }

        public void onActivityResult(int requestCode, int resultCode, Intent data) {

                super.onActivityResult(requestCode, resultCode, data);
                if(requestCode == 200 && resultCode == RESULT_OK) {
                    String nome = data.getStringExtra("nomeProduto");
                    String valor = data.getStringExtra("valorProduto");
                    String categoria = data.getStringExtra("categoriaProduto");
                    Boolean favoritado = data.getExtras().getBoolean("favoritado");

                    nomeGravado.setText(nome);
                    valorGravado.setText(valor);
                    categoriaGravado.setText(categoria);

                    imagemCheck.setVisibility(View.VISIBLE);

                    if(favoritado){
                        imagemCheck.setImageResource(R.drawable.star_on);
                    }else{
                        imagemCheck.setImageResource(R.drawable.star_off);
                    }

                }
        }
    }
