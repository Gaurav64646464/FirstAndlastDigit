import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import static java.lang.Thread.sleep;

public class ColdAndHotConnectableObservable {
    
    public static void main(String[] args) throws InterruptedException {
    // createColdObservable();
    createHotAndConnectableObservable();
    }
    
    private static void createHotAndConnectableObservable() {
    ConnectableObservable<Integer> observable=Observable.just(1,2,3,4,5).publish();
    observable.subscribe(item -> System.out.println("observer 1:"+item));
    
    observable.connect();
        observable.subscribe(item -> System.out.println("observer 2:"+item));
    }
    
    private static void createColdObservable() throws InterruptedException {
    
        Observable<Integer> observable=Observable.just(1,2,3,4,5);
       
        observable.subscribe(item -> System.out.println("Observer 1:"+item));
        
        pause(3000);
        
        observable.subscribe(item -> System.out.println("Observer 2:"+item));
        
    }
    
    private static void pause(int i) {
    try{
    sleep(i);
    }catch (InterruptedException e){
        e.printStackTrace();
    }
    }
}
