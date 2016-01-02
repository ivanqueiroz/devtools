package com.ivanqueiroz.devtools.devtools;

import net.java.html.boot.BrowserBuilder;

public final class Main {
    
    /*
*1. Distrito Federal, Goiás, Mato Grosso do Sul e Tocantins;
2. Pará, Amazonas, Acre, Amapá, Rondônia e Roraima;
3. Ceará, Maranhão e Piauí;
4. Pernambuco, Rio Grande do Norte, Paraíba e Alagoas;
5. Bahia e Sergipe;
6. Minas Gerais;
7. Rio de Janeiro e Espírito Santo;
8. São Paulo;
9. Paraná e Santa Catarina;
0. Rio Grande do Sul.
http://www.geradorcpf.com/
http://www.geradorcpf.com/validar-cpf.htm
http://www.grcs.com.br/fecomercio-rs/calculodv.asp
*/
    private Main() {
    }
    
    public static void main(String... args) throws Exception {
        BrowserBuilder.newBrowser().
            loadPage("pages/index.html").
            loadClass(Main.class).
            invoke("onPageLoad", args).
            showAndWait();
        System.exit(0);
    }

    /**
     * Called when the page is ready.
     * @throws java.lang.Exception
     */
    public static void onPageLoad() throws Exception {
        Data d = new Data();
        
        Regiao r1 = new Regiao();
        r1.setCodigo(1);
        r1.setDescricao("DF, GO, MS e TO");
        d.getRegioes().add(r1);
        Regiao r2 = new Regiao();
        r2.setCodigo(2);
        r2.setDescricao("PA, AM, AC, AP, RO e RR");
        d.getRegioes().add(r2);
        Regiao r3 = new Regiao();
        r3.setCodigo(3);
        r3.setDescricao("CE, MA e PI");
        d.getRegioes().add(r3);
        Regiao r4 = new Regiao();
        r4.setCodigo(4);
        r4.setDescricao("PE, RN, PB e AL");
        d.getRegioes().add(r4);
        Regiao r5 = new Regiao();
        r5.setCodigo(5);
        r5.setDescricao("BA e SE");
        d.getRegioes().add(r5);
        Regiao r6 = new Regiao();
        r6.setCodigo(6);
        r6.setDescricao("MG");
        d.getRegioes().add(r6);
        Regiao r7 = new Regiao();
        r7.setCodigo(7);
        r7.setDescricao("RJ e ES");
        d.getRegioes().add(r7);
        Regiao r8 = new Regiao();
        r8.setCodigo(8);
        r8.setDescricao("SP");
        d.getRegioes().add(r8);
        Regiao r9 = new Regiao();
        r9.setCodigo(9);
        r9.setDescricao("PR e SC");
        d.getRegioes().add(r9);
        Regiao r0 = new Regiao();
        r0.setCodigo(0);
        r0.setDescricao("RS");
        d.getRegioes().add(r0);
        d.applyBindings();
    }
    
}
