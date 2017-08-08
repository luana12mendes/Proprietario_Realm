package com.example.luana.proprietario_realm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.luana.proprietario_realm.model.Proprietario;
import com.example.luana.proprietario_realm.R;

import io.realm.Realm;


public class Detalhe extends AppCompatActivity {
    EditText nome , end, cidade, cnh, tel, bairro, email, lat, longi;
    Button btsalvar,btalterar, btdeletar;

    int id;
    Proprietario proprietario;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        nome = (EditText) findViewById(R.id.ed_nome);
        end = (EditText) findViewById(R.id.ed_end);
        cidade = (EditText) findViewById(R.id.ed_cidade);
        cnh = (EditText) findViewById(R.id.ed_cnh);
        tel = (EditText) findViewById(R.id.ed_tel);
        bairro = (EditText) findViewById(R.id.ed_bairro);
        email = (EditText) findViewById(R.id.ed_email);
        lat = (EditText) findViewById(R.id.ed_lat);
        longi = (EditText) findViewById(R.id.ed_longi);

        btsalvar = (Button) findViewById(R.id.bt_salvar_livro);
        btalterar = (Button) findViewById(R.id.bt_alterar_livro);
        btdeletar = (Button) findViewById(R.id.bt_deletar_livro);

        Intent intent    = getIntent();
        id = (int) intent.getSerializableExtra("id");
        realm = Realm.getDefaultInstance();

        if (id !=0) {
            btsalvar.setEnabled(false);
            btsalvar.setClickable(false);
            btsalvar.setVisibility(View.INVISIBLE);

            proprietario = realm.where(Proprietario.class).equalTo("id",id).findFirst();

            nome.setText(proprietario.getNome());
            end.setText(proprietario.getEnd());
            cidade.setText(proprietario.getCidade());
            cnh.setText(proprietario.getCnh());
            tel.setText(proprietario.getTel());
            bairro.setText(proprietario.getBairro());
            email.setText(proprietario.getEmail());
            lat.setText(proprietario.getLat());
            longi.setText(proprietario.getLongi());

        }else{
            btalterar.setEnabled(false);
            btalterar.setClickable(false);
            btalterar.setVisibility(View.INVISIBLE);
            btdeletar.setEnabled(false);
            btdeletar.setClickable(false);
            btdeletar.setVisibility(View.INVISIBLE);

        }



        btsalvar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                salvar();
            }
        });
        btalterar.setOnClickListener( new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                alterar();
            }
        });
        btdeletar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                deletar();
            }
        });


    }

    public void deletar(){
        realm.beginTransaction();
        proprietario.deleteFromRealm();
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"proprietario deletado",Toast.LENGTH_LONG).show();
        this.finish();

    }

    public void salvar() {


        int proximoID = 1;
        if(realm.where(Proprietario.class).max("id") !=null)
            proximoID = realm.where(Proprietario.class).max("id").intValue()+1;

        realm.beginTransaction();
        Proprietario proprietario = new Proprietario();
        proprietario.setId(proximoID);
        proprietario.setNome(nome.getText().toString());
        proprietario.setEnd(end.getText().toString());
        proprietario.setCidade(cidade.getText().toString());
        proprietario.setCnh(cnh.getText().toString());
        proprietario.setTel(tel.getText().toString());
        proprietario.setBairro(bairro.getText().toString());
        proprietario.setEmail(email.getText().toString());
        proprietario.setLat(lat.getText().toString());
        proprietario.setLongi(longi.getText().toString());

        realm.copyToRealm(proprietario);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Proprietario Cadastrado",Toast.LENGTH_LONG).show();
        this.finish();

    }
    public void alterar() {

        realm.beginTransaction();

        proprietario.setNome(nome.getText().toString());
        proprietario.setEnd(end.getText().toString());
        proprietario.setCidade(cidade.getText().toString());
        proprietario.setCnh(cnh.getText().toString());
        proprietario.setTel(tel.getText().toString());
        proprietario.setBairro(bairro.getText().toString());
        proprietario.setEmail(email.getText().toString());
        proprietario.setLat(lat.getText().toString());
        proprietario.setLongi(longi.getText().toString());

        realm.copyToRealm(proprietario);
        realm.commitTransaction();
        realm.close();

        Toast.makeText(this,"Livro Alterado",Toast.LENGTH_LONG).show();
        this.finish();

    }
}
