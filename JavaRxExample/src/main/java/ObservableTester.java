import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class ObservableTester {

public static void main(String[] args) throws InterruptedException {


    Single<String> testSingle= Single.just("hello World");
    
    Disposable disposable=testSingle.delay(2, TimeUnit.SECONDS, Schedulers.io())
                                  .subscribeWith(new DisposableSingleObserver<String>() {
                                      @Override
                                      public void onSuccess( String s) {
                                          System.out.println(s);
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
