package br.com.fiap.a2tina_android_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {

    EditText edtNome;
    EditText edtEmail;
    ClienteDAO clienteDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edtNome = (EditText) findViewById(R.id.edtNome);
        edtEmail = (EditText) findViewById(R.id.edtEmail);

        clienteDAO = new ClienteDAO(this);
    }

    public void Salvar(View view) {
        String nome = edtNome.getText().toString();
        String email = edtEmail.getText().toString();

        Cliente cliente = new Cliente(nome, email);

        //Chamar método para salvar no banco de dados
        clienteDAO.insert(cliente);
        finish();
    }
}
