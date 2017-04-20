package br.com.minkaholiveira.cadastroproduto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class CadastraProduto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_produto);

        final EditText nomeProduto = (EditText) findViewById(R.id.tela_cadastro_nome_produto_edit);
        final EditText valorProduto = (EditText) findViewById(R.id.tela_cadastro_valor_produto_edit);
        final EditText categoriaProduto = (EditText) findViewById(R.id.tela_cadastro_categoria_produto_edit);
        final CheckBox checkBox = (CheckBox) findViewById(R.id.tela_cadastro_favorito_check);
        Button gravarProduto = (Button) findViewById(R.id.tela_cadastro_button);

        final Produto produto = new Produto();

        gravarProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                produto.setNome(nomeProduto.getText().toString());
                produto.setValor(valorProduto.getText().toString());
                produto.setCategoria(categoriaProduto.getText().toString());

                if (checkBox.isChecked()){
                    produto.setFavoritado(true);
                }else {
                    produto.setFavoritado(false);
                }




                Intent intent= new Intent();
                intent.putExtra("nomeProduto",produto.getNome());
                intent.putExtra("valorProduto",produto.getValor());
                intent.putExtra("categoriaProduto",produto.getCategoria());
                intent.putExtra("favoritado",produto.getFavoritado());
                setResult(RESULT_OK,intent);

                finish();

            }
        });

    }
}
