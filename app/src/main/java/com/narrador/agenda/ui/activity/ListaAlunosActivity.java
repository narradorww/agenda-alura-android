package com.narrador.agenda.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.narrador.agenda.R;
import com.narrador.agenda.dao.AlunoDAO;
import com.narrador.agenda.dao.AlunoDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);

        AlunoDAO dao = new AlunoDAO();


        setTitle("Lista de alunos");


        /*List<String> alunos = new ArrayList<>(Arrays.asList("Alex", "Fran", "José","Maria"));*/
        ListView listaDeAlunos = findViewById(R.id.lista_de_alunos_listview);
        listaDeAlunos.setAdapter(new ArrayAdapter<>
                (this,
                        android.R.layout.simple_list_item_1,
                        dao.todos()));

    }
}