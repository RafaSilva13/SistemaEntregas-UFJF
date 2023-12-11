package com.mycompany.sistema.ufjf.persistence;

import com.google.gson.reflect.TypeToken;
import com.mycompany.sistema.ufjf.model.Entregador;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

/*
. Caio Fonseca Braida  -  Matrícula: 202276029
. José Miguel de Lima   -   Matrícula: 202276008
. Rafael Pereira da Silva  -  Matrícula: 202235013
*/

public class EntregadorPersistence implements Persistence<Entregador> {

    private static final String PATH = DIRECTORY+ File.separator +"entregadores.json";
    @Override
    public void save(List<Entregador> itens) {
        Gson gson = new Gson();
        String json = gson.toJson(itens);

        File diretorio = new File(DIRECTORY);
        if(!diretorio.exists())
            diretorio.mkdirs();

        ArquivoEntregador.salva(PATH, json);
    }

    @Override
    public List<Entregador> findAll() {
        Gson gson = new Gson();

        String json = ArquivoEntregador.le(PATH);

        List<Entregador> entregadores = new ArrayList<>();
        if(!json.trim().equals("")) {

            Type tipoLista = new TypeToken<List<Entregador>>() { }.getType();
            entregadores = gson.fromJson(json, tipoLista);

            if (entregadores == null)
                entregadores = new ArrayList<>();
        }

        return entregadores;
    }
}

