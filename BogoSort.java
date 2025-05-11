public class BogoSort{

public static void bogoSort(int[] a) {
    while(!isSorted(a)){
        shuffle(a);
    }
}

public static boolean isSorted(int[] a){
    for(int i = 0; i < a.length - 1; i++){
        if(a[i] > a[i+1]){
            return false;
        }
    }
    return true;
}

public static void shuffle(int[] a){
    for(int i = 0; i < a.length - 1; i++){
        int range = (a.length - 1) - i;
        int j = (int)(Math.random() * range + (i + 1));
        swap(a, i, j);
    }
}
private static void swap(int[] a, int i, int j){
    if(i == j)
        return;
    
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
}
}