package com.ivanqueiroz.devtools.devtools;

import com.ivanqueiroz.devtools.devtools.geradores.GeradorDocumento;
import net.java.html.json.Function;
import net.java.html.json.Model;
import net.java.html.json.Property;

import static org.apache.commons.lang.StringUtils.isNotEmpty;
import static org.apache.commons.lang.StringUtils.remove;
import static org.apache.commons.lang.StringUtils.contains;

/**
 * Model annotation generates class Data with one message property, boolean
 * property and read only words property
 */
@Model(className = "Data", targetId = "", properties = {
    @Property(name = "cpf", type = String.class),
    @Property(name = "cpfFormatado", type = boolean.class),
    @Property(name = "regioes", type = Regiao.class, array = true),
    @Property(name = "regiaoEscolhida", type = Regiao.class)
})
final class DataModel {

    @Model(className = "Regiao", properties = {
        @Property(name = "descricao", type = String.class),
        @Property(name = "codigo", type = int.class)
    })
    public class RegiaoModel {
    }

    @Function
    static void gerarCPF(Data model) {
        if (model.getRegiaoEscolhida() != null) {
            model.setCpf(GeradorDocumento.gerar(model.getRegiaoEscolhida().getCodigo()));
        } else {
            model.setCpf(GeradorDocumento.gerar());

        }

    }

    @Function
    static void formatarCPF(Data model) {
        if (isNotEmpty(model.getCpf())) {
            if (!contains(model.getCpf(), ".")) {
                StringBuilder sb = new StringBuilder(model.getCpf());
                model.setCpf(sb.insert(3, ".").insert(7, ".").insert(11, "-").toString());
                
            } else if (contains(model.getCpf(), ".")) {
                model.setCpf(remove(remove(model.getCpf(), "."), "-"));
                
            }
            model.setCpfFormatado(!model.isCpfFormatado());
        }

    }

}
