package com.narrador.agenda.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.narrador.agenda.R;
import com.narrador.agenda.dao.AlunoDAO;
import com.narrador.agenda.dao.AlunoDao;
import com.narrador.agenda.model.Aluno;


public class activity_form_aluno extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_aluno);

        final AlunoDAO dao = new AlunoDAO();


        setTitle("Cadastro de Alunos");

        final EditText campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        final EditText campoEmail = findViewById(R.id.activity_formulario_aluno_email);
        final EditText campoTelefone = findViewById(R.id.activity_formulario_aluno_phone);


        Button botaoSalvar = findViewById(R.id.botao_salvar_aluno);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String nome = campoNome.getText().toString();
                String telefone = campoTelefone.getText().toString();
                String email = campoEmail.getText().toString();
                Aluno alunoCriado = new Aluno(nome, telefone, email);
                /*Toast.makeText( activity_form_aluno.this,
                                    alunoCriado.getNome() + " - "
                                        + alunoCriado.getEmail() + " - "
                                        + alunoCriado.getTelefone(),
                                Toast.LENGTH_SHORT).show();*/

                dao.salva(alunoCriado);


                startActivity(new Intent(activity_form_aluno.this, ListaAlunosActivity.class));
            }
        });

    }
}