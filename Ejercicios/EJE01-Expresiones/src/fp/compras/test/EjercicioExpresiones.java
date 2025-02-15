package fp.compras.test;

import java.time.LocalDateTime;

import fp.compras.Compra;

public class EjercicioExpresiones {

    public static void main(String[] args){
        Compra compra1 = new Compra("40961226C", "Mercadona", "Cadiz", LocalDateTime.parse("2019-02-24T05:33"), LocalDateTime.parse("2019-02-24T05:57"), 8.65);
        Compra compra2 = new Compra("86302030G", "Mercadona", "Malaga", LocalDateTime.parse("2019-02-24T10:01"), LocalDateTime.parse("2019-02-24T10:34"), 188.65);
        Compra compra3 = new Compra("37089432T", "Mas", "Granada", LocalDateTime.parse("2019-02-24T10:09"), LocalDateTime.parse("2019-02-24T12:56"), 60.43);
        Compra compra4 = new Compra("97785005E", "Mercadona", "Malaga", LocalDateTime.parse("2019-02-24T13:58"), LocalDateTime.parse("2019-02-24T15:48"), 17.43);
        
        Boolean respuesta1 = false;
        Boolean respuesta2 = false;
        Boolean respuesta3 = false;
        Boolean respuesta4 = false;
        Boolean respuesta5 = false;
        Boolean respuesta6 = false;
        Boolean respuesta7 = false;
        Boolean respuesta8 = false;
        Boolean respuesta9 = false;
        Boolean respuesta10 = false;
        Boolean respuesta11 = false;
        Boolean respuesta12 = false;
        String respuesta13;
        Long respuesta14;
        
        if (compra1.getProvincia().equals("Malaga") && compra1.getTotalCompra() > 60){
            respuesta1 = true;
        }
        if (compra3.getFechaSalida().isBefore(LocalDateTime.parse("2019-02-28T17:35"))){
            respuesta2 = true;
        }
        if (compra1.getSupermercado().equals("Mercadona") && compra3.getSupermercado().equals("Mercadona")){
            respuesta3 = true;
        }
        if (compra2.getTotalCompra() > 100){
            respuesta4 = true;
        }
        if (compra1.getFechaSalida().getDayOfYear()==compra4.getFechaSalida().getDayOfYear()&&compra1.getFechaSalida().isBefore(compra4.getFechaLlegada())){
            respuesta5 = true;
        }
        if (compra2.getSupermercado()==compra4.getSupermercado()&&(compra2.getTotalCompra()>100||compra4.getTotalCompra()>100)){
            respuesta6 = true;
        }
        if (compra2.getTotalCompra()*2>compra3.getTotalCompra()){
            respuesta7 = true;
        }
        if ((compra1.getTotalCompra()+compra2.getTotalCompra()+compra3.getTotalCompra()+compra4.getTotalCompra())/4>100){
            respuesta8 = true;
        }
        if (compra2.getFechaSalida().getMonthValue()%2==0){
            respuesta9 = true;
        }
        if (15 < compra3.getFechaSalida().getHour() && compra3.getFechaSalida().getHour() < 21){
            respuesta10 = true;
        }
        if (compra4.getFechaSalida().getDayOfWeek() == java.time.DayOfWeek.MONDAY){
            respuesta11 = true;
        }
        if (compra3.getDNI().startsWith("9", 0)){
            respuesta12 = true;
        }
        respuesta13 = compra1.getDNI().substring(compra1.getDNI().length() - 1);
        respuesta14 = java.time.Duration.between(compra3.getFechaLlegada(), compra3.getFechaSalida()).toMinutes();

        System.out.println("Respuesta 1: " + respuesta1);
        System.out.println("Respuesta 2: " + respuesta2);
        System.out.println("Respuesta 3: " + respuesta3);
        System.out.println("Respuesta 4: " + respuesta4);
        System.out.println("Respuesta 5: " + respuesta5);
        System.out.println("Respuesta 6: " + respuesta6);
        System.out.println("Respuesta 7: " + respuesta7);
        System.out.println("Respuesta 8: " + respuesta8);
        System.out.println("Respuesta 9: " + respuesta9);
        System.out.println("Respuesta 10: " + respuesta10);
        System.out.println("Respuesta 11: " + respuesta11);
        System.out.println("Respuesta 12: " + respuesta12);
        System.out.println("Respuesta 13: " + respuesta13);
        System.out.println("Respuesta 14: " + respuesta14);
    }
}
