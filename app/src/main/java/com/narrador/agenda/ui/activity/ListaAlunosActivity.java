package com.narrador.agenda.ui.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.narrador.agenda.R;
import com.narrador.agenda.dao.AlunoDAO;

public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        AlunoDAO dao = new AlunoDAO();

        setTitle("Lista de alunos");
        /* Busca a referencia do Botão no layout desta activity */
        FloatingActionButton botaoNovoAluno = findViewById(R.id.activity_lista_aluno_fab_novo_aluno);
        /* configura o comportamento de botaoNovoAluno, habilitando-o à "escutar" clicks */
        botaoNovoAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Quando clicado, o botão deve iniciar uma nova activity  "startActivity" com o Intento , dizendo (deondevem.this , paraondevai.class) */
                startActivity(new Intent(ListaAlunosActivity.this,
                        activity_form_aluno.class));

            }
        });
        }
/* sobreescrevendo o comportamento de onResume() para justra o nosso app ao ciclo de vida da Activity */
    @Override
    protected void onResume() {
        super.onResume();

        AlunoDAO dao = new AlunoDAO();


        /*List<String> alunos = new ArrayList<>(Arrays.asList("Alex", "Fran", "José","Maria"));*/
        ListView listaDeAlunos = findViewById(R.id.lista_de_alunos_listview);
        listaDeAlunos.setAdapter(new ArrayAdapter<>
                (this,
                        android.R.layout.simple_list_item_1,
                        dao.todos()));

    }
}