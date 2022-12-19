package Postagens;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Postagens {
    private String LocalDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    private String LocalHour = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm"));
    private String conteudo;

    public Postagens(String conteudo) { this.conteudo = conteudo; }
    public String getConteudo() {
        return conteudo;
    }
    public void setConteudo(String conteudo) { this.conteudo = conteudo; }
    public String getLocalDate() {
        return LocalDate;
    }
    public String getLocalHour() {
        return LocalHour;
    }
}
