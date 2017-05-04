package br.com.fiap.a2tina_android_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {

    EditText edtNome;
    EditText edtEmail;
    ClienteDAO clienteDAO;
    Cliente cliente;
    boolean estaEditando = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edtNome = (EditText) findViewById(R.id.edtNome);
        edtEmail = (EditText) findViewById(R.id.edtEmail);

        clienteDAO = new ClienteDAO(this);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            estaEditando = true;
            cliente = (Cliente) bundle.get("cliente");
            if(cliente != null){
                getSupportActionBar().setTitle(R.string.editar_cliente);
                edtNome.setText(cliente.getNome());
                edtEmail.setText(cliente.getEmail());
            }
        }
    }

    public void Salvar(View view) {
        String nome = edtNome.getText().toString();
        String email = edtEmail.getText().toString();


        if(estaEditando){
            cliente.setNome(nome);
            cliente.setEmail(email);
            clienteDAO.update(cliente);
        }else{
            cliente = new Cliente(nome, email);
            //Chamar método para salvar no banco de dados
            clienteDAO.insert(cliente);
        }
        finish();
    }
}
