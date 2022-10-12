import io.reactivex.Maybe;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableMaybeObserver;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class CompositeDisposableTester {

public static void main(String[] args) throws InterruptedException {
    CompositeDisposable compositeDisposable=new CompositeDisposable();
    
    Disposable disposable= Single.just("Hello world").delay(2, TimeUnit.SECONDS, Schedulers.io())
                                   .subscribeWith(new DisposableSingleObserver<String>() {
                                       @Override
                                       public void onSuccess(@NonNull String s) {
                                           System.out.println(s);
        
                                       }
    
                                       @Override
                                       public void onError(@NonNull Throwable e) {
                                           e.printStackTrace();
                                       }
                                   });
                     
                       Disposable disposable1= Maybe.just("Hi").delay(2,TimeUnit.SECONDS,Schedulers.io())
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
                                                               System.out.println("Done");
                                                           }
                                                       });
                                               Thread.sleep(3000);
                                               compositeDisposable.add(disposable);
                                               compositeDisposable.add(disposable1);
                                               compositeDisposable.dispose();
}
}
