import io.reactivex.Maybe;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableMaybeObserver;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class MayBeTester {

public static  void main(String[] args) throws InterruptedException {
    
    Disposable disposable= Maybe.just("Hello World")
                                   .delay(2, TimeUnit.SECONDS, Schedulers.io())
                                   .subscribeWith(new DisposableMaybeObserver<String>() {
                                       @Override
                                       public void onSuccess(@NonNull String s) {
                                           System.out.println(s);
                                       }
    
                                       @Override
                                       public void onError(@NonNull Throwable e) {
                                        e.printStackTrace();
                                       }
    
                                       @Override
                                       public void onComplete() {
                                           System.out.println("Done!!");
                                       }
                                   });
    Thread.sleep(3000);
    disposable.dispose();




}
}
