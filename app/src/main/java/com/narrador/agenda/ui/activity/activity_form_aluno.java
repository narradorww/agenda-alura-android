package com.narrador.agenda.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.narrador.agenda.R;
import com.narrador.agenda.dao.AlunoDAO;
import com.narrador.agenda.model.Aluno;


public class activity_form_aluno extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Novo Aluno";
    private EditText campoNome;
    private EditText campoEmail;
    private EditText campoTelefone;
    final AlunoDAO dao = new AlunoDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_aluno);
        setTitle(TITULO_APPBAR);
        inicializaCampos();
        configuraBotaoSalvar();
    }

    private void configuraBotaoSalvar() {
        Button botaoSalvar = findViewById(R.id.botao_salvar_aluno);
        botaoSalvar.setOnClickListener((view) ->{
            Aluno alunoCriado = criaAluno();
            salvar(alunoCriado, dao);
        } );
    }

    private void inicializaCampos() {
        campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        campoEmail = findViewById(R.id.activity_formulario_aluno_email);
        campoTelefone = findViewById(R.id.activity_formulario_aluno_phone);
    }

    private void salvar(Aluno alunoCriado, AlunoDAO dao) {
        dao.salva(alunoCriado);


        finish();
    }

    ;


    @NonNull
    private Aluno criaAluno() {
        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();

        return new Aluno(nome, telefone, email);


    }
}