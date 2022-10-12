import io.reactivex.Completable;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class CompletableTester {
    
    public static  void main(String[] args) throws InterruptedException {
        Disposable disposable= Completable.complete().delay(2, TimeUnit.SECONDS, Schedulers.io())
        
                                       .subscribeWith(new DisposableCompletableObserver() {
                                           @Override
                                           public void onComplete() {
                                               System.out.println("Done!!");
                                           }
                                           @Override
                                           public void onStart() {
                                               System.out.println("Started!");
                                           }
                                           @Override
                                           public void onError(@NonNull Throwable e) {
                                              e.printStackTrace();
                                           }
                                       });
        Thread.sleep(3000);
        disposable.dispose();
    }

}
