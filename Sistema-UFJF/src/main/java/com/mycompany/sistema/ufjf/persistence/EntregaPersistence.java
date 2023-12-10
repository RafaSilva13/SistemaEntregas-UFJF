package com.mycompany.sistema.ufjf.persistence;

import com.google.gson.reflect.TypeToken;
import com.mycompany.sistema.ufjf.model.Entrega;
        
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mycompany.sistema.ufjf.model.Pacote;
import com.mycompany.sistema.ufjf.model.PacoteAdapter;

public class EntregaPersistence implements Persistence<Entrega> {

    private static final String PATH = DIRECTORY+ File.separator +"entregas.json";
    
    @Override
    public void save(List<Entrega> itens) {
        Gson gson = new GsonBuilder() .registerTypeAdapter(Pacote.class, new PacoteAdapter()).create();

        String json = gson.toJson(itens);

        File diretorio = new File(DIRECTORY);
        if(!diretorio.exists())
            diretorio.mkdirs();

        ArquivoEntrega.salva(PATH, json);
    }

    @Override
    public List<Entrega> findAll() {
        Gson gson = new GsonBuilder().registerTypeAdapter(Pacote.class, new PacoteAdapter()).create();

        String json = ArquivoEntrega.le(PATH);

        List<Entrega> entregas = new ArrayList<>();
        if(!json.trim().equals("")) {

            Type tipoLista = new TypeToken<List<Entrega>>() { }.getType();
            entregas = gson.fromJson(json, tipoLista);

            if (entregas == null)
                entregas = new ArrayList<>();
        }

        return entregas;
    }
}