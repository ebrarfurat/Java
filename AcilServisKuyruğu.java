import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;

class Hasta {
    private String ad;
    private int ciddiyet;

    public Hasta(String ad, int ciddiyet){
        this.ad = ad;
        this.ciddiyet = ciddiyet;
    }

    public String getAd(){
        return ad;
    }

    public int getCiddiyet(){
        return ciddiyet;
    }

    @Override
    public String toString(){
        return "Hasta{ad = " + ad + ", ciddiyet=" + ciddiyet + "}";

    }
}

public class AcilServisKuyruğu{
    public static void main(String[] args){
        Queue<Hasta> normalKuyruk = new LinkedList<>();
        Queue<Hasta> yuksekKuyruk = new LinkedList<>();
        Queue<Hasta> cokYuksekKuyruk = new LinkedList<>();

        Random random = new Random();

        for(int i=1; i <= 20; i++){
            String hastaAdi = "Hasta" + i;
            int ciddiyet = random.nextInt(3) + 1;

            Hasta hasta = new Hasta(hastaAdi, ciddiyet);

            switch(ciddiyet){
                case 1 -> normalKuyruk.add(hasta);
                case 2 -> yuksekKuyruk.add(hasta);
                case 3 -> cokYuksekKuyruk.add(hasta);    
            }

            System.out.println(hastaAdi + "oluşturuldu. Ciddiyet:"+ ciddiyet);
            }
            System.out.println("\n--- Tedavi Süreci Başlıyor(3-2-1 Döngüsü) ---");

            while(!cokYuksekKuyruk.isEmpty() || !yuksekKuyruk.isEmpty() || !normalKuyruk.isEmpty()){
                tedaviHastalar(cokYuksekKuyruk, 3, "Çok Yüksek Öncelik");
                tedaviHastalar(yuksekKuyruk, 2, "Yuksek Öncelik");
                tedaviHastalar(normalKuyruk, 1, "Normal Öncelik");

            }
            System.out.println("\n--- Tüm hastalar tedavi edildi. Simülasyon tamamlandı. ---");
        
    }
    private static void tedaviHastalar(Queue<Hasta> kuyruk, int adet, String oncelikSeviyesi){
        int sayac = 0;

        while(!kuyruk.isEmpty() && sayac < adet){
            Hasta hasta = kuyruk.poll();

            System.out.println("\n" + hasta.getAd()+ "(" + oncelikSeviyesi + ",Ciddiyet:" + hasta.getCiddiyet()+ ")");
    
        
        try{
            Thread.sleep(hasta.getCiddiyet()*0);
        }
        catch(InterruptedException e){
            System.out.println("Tedavi sırasında hata oluştu");
        }

        System.out.println(hasta.getAd() + "tedavi edildi.");
        sayac++;
    }
    }
}
