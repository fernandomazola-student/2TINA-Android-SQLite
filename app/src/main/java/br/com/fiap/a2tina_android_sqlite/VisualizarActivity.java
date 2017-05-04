package br.com.fiap.a2tina_android_sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class VisualizarActivity extends AppCompatActivity {

    TextView txtNome;
    TextView txtEmail;
    Cliente cliente;
    ClienteDAO clienteDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);

        txtNome = (TextView)findViewById(R.id.txtNome);
        txtEmail = (TextView) findViewById(R.id.txtEmail);

        cliente = (Cliente) getIntent().getExtras().get("cliente");
        if(cliente != null){
            txtNome.setText(cliente.getNome());
            txtEmail.setText(cliente.getEmail());
        }

        clienteDAO = new ClienteDAO(this);
    }

    public void editar(View view) {
        //Reaproveitando a tela de cadastro
        Intent it = new Intent(VisualizarActivity.this, CadastroActivity.class);
        it.putExtra("cliente", cliente);
        startActivity(it);
        finish();


    }

    public void excluir(View view) {
        clienteDAO.delete(cliente.getId());
        finish();
    }
}
