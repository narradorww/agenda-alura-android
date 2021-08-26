package com.narrador.agenda.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.narrador.agenda.R;


public class activity_form_aluno extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_aluno);
        setTitle("Lista de alunos");
    }
}