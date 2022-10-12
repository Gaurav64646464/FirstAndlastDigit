import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class SingleMaybeCompletable {
    
    
    public static void main(String[] args) {
    
    //createSingle();
   // createMayBe();
    createCompletable();
    }
    
    private static void createCompletable() {
        Completable.fromSingle(Single.just("hello world")).subscribe(()-> System.out.println("Done1"));
    }
    
    private static void createMayBe() {
        Maybe.empty().subscribe(new MaybeObserver<Object>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
        
            }
    
            @Override
            public void onSuccess(@NonNull Object o) {
                System.out.println(o);
            }
    
            @Override
            public void onError(@NonNull Throwable e) {
        
            }
    
            @Override
            public void onComplete() {
                System.out.println("Done");
            }
        });
    
    }
    
    private static void createSingle() {
        Single.just("Hello world").subscribe(System.out::print);
    }
}
