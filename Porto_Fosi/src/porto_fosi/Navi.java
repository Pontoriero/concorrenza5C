/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package porto_fosi;

/**
 *
 * @author verifica
 */
public class Navi {

    private String tipo;
    private Porto porto;

    public Navi(String tipo, Porto porto) {
        setTipo(tipo);
        setPorto(porto);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Porto getPorto() {
        return porto;
    }

    public void setPorto(Porto porto) {
        this.porto = porto;
    }

    public void run() {
        try {

            if (tipo.equals("nazionali")) {
                porto.entraNazionali();
            } else {
                porto.entraInternazionali();
            }

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }
}
